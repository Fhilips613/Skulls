/*
 * Skulls
 * Copyright 2023 Kiran Hart
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

package ca.tweetzy.skulls.settings;

import ca.tweetzy.flight.settings.TranslationEntry;
import ca.tweetzy.flight.settings.TranslationManager;
import ca.tweetzy.skulls.Skulls;
import lombok.NonNull;
import org.bukkit.plugin.java.JavaPlugin;

public final class Translations extends TranslationManager {

	public Translations(@NonNull JavaPlugin plugin) {
		super(plugin);
		this.mainLanguage = Settings.LANG.getString();
	}

	public static final TranslationEntry MISC_IS_TRUE = create("conditionals.is true", "&ATrue");
	public static final TranslationEntry MISC_IS_FALSE = create("conditionals.is false", "&cFalse");
	public static final TranslationEntry MISC_IS_ALLOWED = create("conditionals.is allowed", "&aAllowed");
	public static final TranslationEntry MISC_IS_DISALLOWED = create("conditionals.is disallowed", "&cDisallowed");
	public static final TranslationEntry CATEGORY_PERMISSION = create("misc.category permission", "&cYou do not have permission to access that category!");
	public static final TranslationEntry SKULL_NOT_FOUND = create("misc.skull not found", "&cNo skull by that id could be found");
	public static final TranslationEntry NO_SKULL_INFO = create("misc.no skull info", "&cCould not determine ID of that skull");
	public static final TranslationEntry SKULL_TITLE = create("skull.name", "&e%skull_name%");
	public static final TranslationEntry ID_TAKEN = create("misc.id taken", "&cThat category id is already in use!");
	public static final TranslationEntry CLAIM_DELAY = create("misc.claim delay", "&cYou can claim another head in &7(&e%time_difference%&7)");
	public static final TranslationEntry RECEIVED_RANDOM_SKULL = create("misc.received random skull", "&aYou received a random skull &F(&E%skull_name%&f)");


	public static final TranslationEntry ALPHABET = create("categories.alphabet", "Alphabet");
	public static final TranslationEntry ANIMALS = create("categories.animals", "Animals");
	public static final TranslationEntry BLOCKS = create("categories.blocks", "Blocks");
	public static final TranslationEntry DECORATION = create("categories.decoration", "Decoration");
	public static final TranslationEntry FOOD_AND_DRINKS = create("categories.food and drinks", "Food & Drinks");
	public static final TranslationEntry HUMANS = create("categories.humans", "Humans");
	public static final TranslationEntry HUMANOID = create("categories.humanoids", "Humanoids");
	public static final TranslationEntry MISC = create("categories.misc", "Miscellaneous");
	public static final TranslationEntry MONSTERS = create("categories.monsters", "Monsters");
	public static final TranslationEntry PLANTS = create("categories.plants", "Plants");
	public static final TranslationEntry PLAYER_HEAD = create("categories.player head", "&e%player_name%'s Head");

	public static final TranslationEntry INPUT_SKULL_EDIT_TITLE = create("input.skull edit.title", "&eEditing Skull");
	public static final TranslationEntry INPUT_SKULL_EDIT_NAME = create("input.skull edit.name", "&FEnter the new name skull name");
	public static final TranslationEntry INPUT_SKULL_EDIT_PRICE = create("input.skull edit.price", "&fEnter the new skull price");

	public static final TranslationEntry INPUT_SKULL_SEARCH_TITLE = create("input.skull search.title", "&eSkull Search");
	public static final TranslationEntry INPUT_SKULL_SEARCH_SUBTITLE = create("input.skull search.subtitle", "&fEnter search terms into chat");

	public static final TranslationEntry INPUT_CATEGORY_CREATE_TITLE = create("input.category create.title", "&eCategory Creation");
	public static final TranslationEntry INPUT_CATEGORY_CREATE_SUBTITLE = create("input.category create.subtitle", "&fEnter id for new category");

	public static final TranslationEntry INSPECT_INFO = create("inspect info",
			"&8&m-----------------------------------------------------",
			"",
			"&eSkull ID&f: &a%skull_id%",
			"&eTexture URL&f: &a%skull_texture%",
			"",
			"&8&m-----------------------------------------------------"
	);

	// GUIS
	public static TranslationEntry GUI_SHARED_ITEMS_BACK_BUTTON_NAME = create("gui.shared buttons.back button.name", "<GRADIENT:DD5E89>&LGo Back</GRADIENT:fbc7d4>");
	public static TranslationEntry GUI_SHARED_ITEMS_BACK_BUTTON_LORE = create("gui.shared buttons.back button.lore",
			"&e&lClick &8» &7to go back"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_EXIT_BUTTON_NAME = create("gui.shared buttons.exit button.name", "<GRADIENT:DD5E89>&LExit</GRADIENT:fbc7d4>");
	public static TranslationEntry GUI_SHARED_ITEMS_EXIT_BUTTON_LORE = create("gui.shared buttons.exit button.lore",
			"&e&lClick &8» &7to exit menu"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_PREVIOUS_BUTTON_NAME = create("gui.shared buttons.previous button.name", "<GRADIENT:DD5E89>&lPrevious Page</GRADIENT:fbc7d4>");
	public static TranslationEntry GUI_SHARED_ITEMS_PREVIOUS_BUTTON_LORE = create("gui.shared buttons.previous button.lore",
			"&e&lClick &8» &7to go back a page"
	);

	public static TranslationEntry GUI_SHARED_ITEMS_NEXT_BUTTON_NAME = create("gui.shared buttons.next button.name", "<GRADIENT:DD5E89>&lNext Page</GRADIENT:fbc7d4>");
	public static TranslationEntry GUI_SHARED_ITEMS_NEXT_BUTTON_LORE = create("gui.shared buttons.next button.lore",
			"&e&lClick &8» &7to go to next page"
	);

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_SELECTOR_TITLE = create("gui.custom category selector.title", "&eSkulls &8> &7Select Category");

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_SELECTOR_ITEMS_CATEGORY_NAME = create("gui.custom category selector.items.category.name", "%category_name%");

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_SELECTOR_ITEMS_CATEGORY_LORE = create("gui.custom category selector.items.category.lore",
			"&e&lClick &8» &7To select category"
	);

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_LIST_TITLE = create("gui.custom category list.title", "&eSkulls &8> &7Custom Categories");

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_LIST_ITEMS_CATEGORY_NAME = create("gui.custom category list.items.category.name", "%category_name%");

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_LIST_ITEMS_CATEGORY_LORE = create("gui.custom category list.items.category.lore",
			"&8View heads by this category",
			"&7Total Heads&F: &b%category_size%",
			"",
			"&e&lClick &8» &7To view category"
	);

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_LIST_ITEMS_NEW_NAME = create("gui.custom category list.items.new.name", "<GRADIENT:DD5E89>&lNew Category</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_CUSTOM_CATEGORY_LIST_ITEMS_NEW_LORE = create("gui.custom category list.items.new.lore", "", "&e&lClick &8» &7To create new category");


	public static final TranslationEntry GUI_PLAYER_HEADS_TITLE = create("gui.player heads.title", "&eSkulls &8> &7Player Heads");
	public static final TranslationEntry GUI_PLAYER_HEADS_ITEMS_HEAD_NAME = create("gui.player heads.items.head.name", "&e%player_name%");


	public static final TranslationEntry GUI_EDIT_TITLE = create("gui.edit.title", "&eSkulls &8> &7Edit &8> &7%skull_id%");

	public static final TranslationEntry GUI_EDIT_ITEMS_NAME_NAME = create("gui.edit.items.name.name", "<GRADIENT:DD5E89>&lSkull Name</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_EDIT_ITEMS_NAME_LORE = create("gui.edit.items.name.lore", "", "&e&lClick &8» &7To change skull name");

	public static final TranslationEntry GUI_EDIT_ITEMS_PRICE_NAME = create("gui.edit.items.price.name", "<GRADIENT:DD5E89>&lSkull Price</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_EDIT_ITEMS_PRICE_LORE = create("gui.edit.items.price.lore", "", "&e&lClick &8» &7To edit skull price");

	public static final TranslationEntry GUI_EDIT_ITEMS_ADD_CATEGORY_NAME = create("gui.edit.items.add category.name", "<GRADIENT:DD5E89>&lAdd To Category</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_EDIT_ITEMS_ADD_CATEGORY_LORE = create("gui.edit.items.add category.lore", "", "&e&lClick &8» &7To add to another category");

	public static final TranslationEntry GUI_EDIT_ITEMS_BLOCKED_NAME = create("gui.edit.items.blocked.name", "<GRADIENT:DD5E89>&lSkull Blocked</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_EDIT_ITEMS_BLOCKED_LORE = create("gui.edit.items.blocked.lore", "", "&7Blocked&f: %is_true%", "", "&e&lClick &8» &7To toggle block status");

	public static final TranslationEntry GUI_SETTINGS_TITLE = create("gui.settings.title", "&eSkulls &8> &7Settings");


	public static final TranslationEntry GUI_MAIN_TITLE = create("gui.main.title", "&eSkulls");

	public static final TranslationEntry GUI_MAIN_ITEMS_CATEGORY_NAME = create("gui.main.items.category.name", "&e%category_name%");

	public static final TranslationEntry GUI_MAIN_ITEMS_CATEGORY_LORE = create("gui.main.items.category.lore",
			"&8View heads by this category",
			"&7Total Heads&F: &b%category_size%",
			"",
			"&e&lClick &8» &7To view category"
	);

	public static final TranslationEntry GUI_MAIN_ITEMS_PLAYERS_NAME = create("gui.main.items.players.name", "&ePlayer Heads");

	public static final TranslationEntry GUI_MAIN_ITEMS_PLAYERS_LORE = create("gui.main.items.players.lore",
			"&8View all player heads",
			"&7Total Heads&F: &b%category_size%",
			"",
			"&e&lClick &8» &7To view player heads"
	);

	public static final TranslationEntry GUI_MAIN_ITEMS_FAVOURITES_NAME = create("gui.main.items.favourites.name", "<GRADIENT:DD5E89>&lFavourites</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_MAIN_ITEMS_FAVOURITES_LORE = create("gui.main.items.favourites.lore",
			"&7A collection of every single head",
			"&7that you have favourited.",
			"",
			"&e&lClick &8» &7To view your favourites"
	);

	public static final TranslationEntry GUI_MAIN_ITEMS_RANDOM_HEAD_NAME = create("gui.main.items.random head.name", "<GRADIENT:DD5E89>&lRandom Head</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_MAIN_ITEMS_RANDOM_HEAD_LORE = create("gui.main.items.random head.lore",
			"&7Used to receive a random head from",
			"&7a random category that you have access too.",
			"",
			"&7Cost: &a$%price%",
			"",
			"&e&lClick &8» &7To receive a random head"
	);

	public static final TranslationEntry GUI_MAIN_ITEMS_SEARCH_NAME = create("gui.main.items.search.name", "<GRADIENT:DD5E89>&lSearch</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_MAIN_ITEMS_SEARCH_LORE = create("gui.main.items.search.lore",
			"",
			"&e&lClick &8» &7To search for heads"
	);

	public static final TranslationEntry GUI_MAIN_ITEMS_CUSTOM_CATEGORIES_NAME = create("gui.main.items.custom categories.name", "<GRADIENT:DD5E89>&lMore Categories</GRADIENT:fbc7d4>");

	public static final TranslationEntry GUI_MAIN_ITEMS_CUSTOM_CATEGORIES_LORE = create("gui.main.items.custom categories.lore",
			"",
			"&e&lClick &8» &7To view more categories"
	);


	public static final TranslationEntry GUI_SKULLS_LIST_TITLE_CATEGORY = create("gui.skulls list.title.category", "&eSkulls &8> &7%category_name%");

	public static final TranslationEntry GUI_SKULLS_LIST_TITLE_FAVOURITES = create("gui.skulls list.title.favourites", "&eSkulls &8> &7Favourites");

	public static final TranslationEntry GUI_SKULLS_LIST_TITLE_SEARCH = create("gui.skulls list.title.search", "&eSkulls &8> &7%search_phrase%");

	public static final TranslationEntry GUI_SKULLS_LIST_TITLE_ALL = create("gui.skulls list.title.all", "&eSkulls &8> &7All");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_NAME = create("gui.skulls list.items.skull.name", "&e%skull_name%");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_ID = create("gui.skulls list.items.skull.lore.id", "&7Id: &e%skull_id%");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_TAGS = create("gui.skulls list.items.skull.lore.tags", "&7Tags: &e%skull_tags%");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_PRICE = create("gui.skulls list.items.skull.lore.price", "&7Cost: &a$%skull_price%");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_TAKE = create("gui.skulls list.items.skull.lore.take", "&e&lLeft Click &8» &7To take one");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_FAVOURITE = create("gui.skulls list.items.skull.lore.favourite", "&e&lRight Click &8» &7To favourite head");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_UN_FAVOURITE = create("gui.skulls list.items.skull.lore.un favourite", "&e&lRight Click &8» &7To unfavourite head");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_EDIT = create("gui.skulls list.items.skull.lore.edit", "&b&lPress 1 &8» &7To edit this skull");


	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_FAVOURITED = create("gui.skulls list.items.skull.lore.favourited", "&e&lFAVOURITED");

	public static final TranslationEntry GUI_SKULLS_LIST_ITEMS_SKULL_LORE_BLOCKED = create("gui.skulls list.items.skull.lore.blocked", "&c&oPurchase is blocked");


	public static void init() {
		new Translations(Skulls.getInstance()).setup(Skulls.getInstance());
	}
}
