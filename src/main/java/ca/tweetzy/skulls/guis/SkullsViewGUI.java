/*
 * Skulls
 * Copyright 2022 Kiran Hart
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ca.tweetzy.skulls.guis;

import ca.tweetzy.flight.gui.Gui;
import ca.tweetzy.flight.gui.events.GuiClickEvent;
import ca.tweetzy.flight.settings.TranslationManager;
import ca.tweetzy.flight.utils.Common;
import ca.tweetzy.flight.utils.PlayerUtil;
import ca.tweetzy.flight.utils.QuickItem;
import ca.tweetzy.skulls.Skulls;
import ca.tweetzy.skulls.api.enums.ViewMode;
import ca.tweetzy.skulls.api.interfaces.Skull;
import ca.tweetzy.skulls.api.interfaces.SkullUser;
import ca.tweetzy.skulls.guis.abstraction.SkullsPagedGUI;
import ca.tweetzy.skulls.settings.Settings;
import ca.tweetzy.skulls.settings.Translations;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Date Created: April 21 2022
 * Time Created: 11:59 a.m.
 *
 * @author Kiran Hart
 */
public final class SkullsViewGUI extends SkullsPagedGUI<Skull> {

	private final Player player;
	private final SkullUser skullPlayer;
	private final ViewMode viewMode;
	private final String category;

	public SkullsViewGUI(final Gui parent, final SkullUser skullPlayer, final String category, final ViewMode viewMode) {
		super(
				parent,
				Bukkit.getPlayer(skullPlayer.getUUID()),
				viewMode == ViewMode.SEARCH ? TranslationManager.string(Translations.GUI_SKULLS_LIST_TITLE_SEARCH, "search_phrase", category) : viewMode == ViewMode.FAVOURITE ? TranslationManager.string(Translations.GUI_SKULLS_LIST_TITLE_FAVOURITES) : TranslationManager.string(Translations.GUI_SKULLS_LIST_TITLE_CATEGORY, "category_name", category),
				6,
				new ArrayList<>()
		);

		this.category = category;
		this.viewMode = viewMode;
		this.skullPlayer = skullPlayer;
		this.player = Bukkit.getPlayer(this.skullPlayer.getUUID());
		draw();
	}

	@Override
	protected void prePopulate() {
		if (this.viewMode == ViewMode.SEARCH)
			this.items = Skulls.getSkullManager().getSkullsBySearch(this.player, category);

		else if (viewMode == ViewMode.FAVOURITE)
			this.items = Skulls.getSkullManager().getSkulls(skullPlayer.getFavourites());
		else
			this.items= Skulls.getSkullManager().getSkulls(category);
	}

	@Override
	protected ItemStack makeDisplayItem(Skull skull) {
		final QuickItem item = QuickItem.of(skull.getItemStack()).name(TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_NAME, "skull_name", skull.getName()));

		item.lore(TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_ID, "skull_id", skull.getId()));
		item.lore(TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_TAGS, "skull_tags", String.join(", ", skull.getTags())));

		if (Settings.CHARGE_FOR_HEADS.getBoolean() && skull.getPrice() > 0) {
			item.lore(TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_PRICE, "skull_price", String.format("%,.2f", skull.getPrice())));
		}

		if (!skull.isBlocked() && this.skullPlayer.getFavourites().contains(skull.getId())) {
			item.lore(" ");
			item.lore(TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_FAVOURITED));
			item.lore(" ");
		} else {
			item.lore(" ");
		}

		item.lore(skull.isBlocked() ? TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_BLOCKED) : TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_TAKE));

		if (!skull.isBlocked()) {
			item.lore(this.skullPlayer.getFavourites().contains(skull.getId()) ? TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_UN_FAVOURITE) : TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_FAVOURITE));
		}

		if (this.player.hasPermission("skulls.admin"))
			item.lore(" ", TranslationManager.string(Translations.GUI_SKULLS_LIST_ITEMS_SKULL_LORE_EDIT));

		return item.make();
	}

	@Override
	protected void onClick(Skull skull, GuiClickEvent event) {
		final Player player = event.player;

		if (event.clickType == ClickType.LEFT) {
			if (skull.isBlocked()) {
				if (!player.isOp() || !player.hasPermission("skulls.buyblocked")) return;
			}

			if (!Skulls.getPlayerManager().playerCanClaim(player)) {
				return;
			}

			if (Settings.ASK_FOR_BUY_CONFIRM.getBoolean()) {
				event.manager.showGUI(event.player, new ConfirmGUI(this, event.player, confirmed -> {
					if (confirmed) {
						handleBuy(skull);
						event.manager.showGUI(event.player, this);
					} else {
						event.manager.showGUI(event.player, this);
					}
				}));
				return;
			}

			handleBuy(skull);
		}

		if (event.clickType == ClickType.RIGHT) {
			if (!Settings.GENERAL_USAGE_REQUIRES_NO_PERM.getBoolean() && !player.hasPermission("skulls.favourite"))
				return;


			this.skullPlayer.toggleFavourite(skull.getId());
			this.skullPlayer.sync();

			if (this.viewMode == ViewMode.FAVOURITE)
				event.manager.showGUI(event.player, new SkullsViewGUI(this.parent, this.skullPlayer, "", ViewMode.FAVOURITE));
			else
				draw();
		}

		if (event.clickType == ClickType.NUMBER_KEY && player.hasPermission("skulls.admin")) {
			event.manager.showGUI(player, new SkullEditGUI(this, player, skull, this.page));
		}
	}

	private void handleBuy(Skull skull) {
		if (!Settings.CHARGE_FOR_HEADS.getBoolean()) {
			PlayerUtil.giveItem(player, skull.getItemStack());
			return;
		}

		final double price = player.hasPermission("skulls.freeskulls") ? 0 : skull.getPrice();

		if (price <= 0) {
			PlayerUtil.giveItem(player, skull.getItemStack());
			return;
		}

		if (!Skulls.getEconomyManager().has(player, price)) {
			Common.tell(player, TranslationManager.string(Translations.NO_MONEY));
			return;
		}

		Skulls.getEconomyManager().withdraw(player, price);
		PlayerUtil.giveItem(player, skull.getItemStack());
		Common.tell(player, TranslationManager.string(Translations.PURCHASE_SUCCESS));
	}

	@Override
	protected void drawFixed() {
		applyBackExit();
	}
}
