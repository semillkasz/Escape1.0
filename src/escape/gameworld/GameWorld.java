package escape.gameworld;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is the class the pulls all the game elements together
 * 
 * @author semillkasz
 *
 */
public class GameWorld {
	private String gameID;
	private ArrayList<Player> players = new ArrayList<>();
	private HashMap<String, Room> rooms = new HashMap<>();
	private HashMap<String, Container> containers = new HashMap<>();
	private HashMap<String, Item> items = new HashMap<>();

	private Room kitchen;
	private Room study;
	private Room livingRoom;
	private Room bedroom;
	private Room mainHall;
	private Room hallLeftStudy;
	private Room hallRightBedroom;
	private Room hallLeftKitchen;
	private Room hallRightLivingRoom;

	public GameWorld(String id) {
		this.gameID = id;
		initialiseItems();
		initialiseContainers();
		initialiseRooms();
	}

	/**
	 * Adds a player in the game
	 * 
	 * @param p
	 */
	public void addPlayer(Player p) {
		players.add(p);

	}

	/**
	 * Initialises all the items in the game.
	 * 
	 */
	public void initialiseItems() {
		// Pickable
		items.put("Paper", new Item("Paper", "A scrap of paper.", true, true));
		items.put("Key", new Item("Key", "A door key.", true, true));
		items.put("Study Room Safe Key", new Item("Study Room Safe Key",
				"A modern-looking key", true, true));
		items.put("Bedroom Safe Key", new Item("Bedroom Safe Key",
				"A modern-look key", true, true));
		items.put("Cupboard Key", new Item("Cupboard Key", "A small key", true,
				true));
		items.put("Study Room Key", new Item("Study Room Key", "A room key", true,
				true));
		// items.put("Lamp", new Item("Lamp", "An old-fashioned lamp", true,
		// true));
		items.put("Kitchen Picture", new Item("Kitchen Picture",
				"A family picture", true, true));
		items.put("Living Room Picture", new Item("Living Room Picture",
				"A family picture", true, true));
		items.put("Matches", new Item("Matches",
				"Matches! Might be useful in the future", true, true));
		// Unmovables
		items.put("Sofa", new Item("Sofa", "A red sofa fill of cat fur.",
				false, false));
		items.put("Desk", new Item("Desk", "An office desk", false, false));
		items.put("Chair", new Item("Chair", "An comfortable working chair",
				false, false));
		items.put("Bed", new Item("Bed", "A neatly made bed", false, false));
		items.put("Kitchen Table", new Item("Kitchen Table",
				"An old, wooden kitchen table", false, false));
		items.put("Frame", new Item("Frame", "An empty picture frame", false,
				false));
		items.put("Portrait", new Item("Portrait", "A family portrait", false,
				false));
		items.put("Table", new Item("Table", "A centre table", false, false));
	}

	/**
	 * Initialises all the containers in the game. Places items in their
	 * designated containers.
	 * 
	 */
	public void initialiseContainers() {
		// empty containers
		containers.put("Fridge", new Container("Fridge",
				"An old, empty fridge.", false, false, false, null));
		// rubbish bins
		containers.put("Study Room Bin", new Container("Study Room Bin",
				"A rubbish bin", false, false, false, null));
		containers.put("Living Room Bin", new Container("Living Room Bin",
				"A rubbish bin", false, false, false, null));
		containers.put("Bedroom Bin", new Container("Bedroom Bin",
				"A rubbish bin", false, false, false, null));
		containers.put("Kitchen Bin", new Container("Kitchen Bin",
				"A rubbish bin", false, false, false, null));
		// Safe
		containers.put("Study Room Safe", new Container("Study Room Safe",
				"This safe can be opened by a number combination", false,
				false, true, ("Paper")));
		containers.get("Study Room Safe").add(items.get("Bedroom Safe Key"));
		containers.put("Living Room Safe", new Container("Living Room Safe",
				"This safe can be opened by a photo", false, false, true,
				("Kitchen Picture")));
		containers.get("Living Room Safe").add(items.get("Cupboard Key"));
		containers.put("Bedroom Safe", new Container("Bedroom Safe",
				"This safe can be opened by a key", false, false, true,
				("Study Rooms Safe Key")));
		containers.get("Bedroom Safe").add(items.get("Key"));
		// Clue containers
		containers.put("Bookshelf", new Container("Bookshelf",
				"A bookshelf with alphabetically arranged books.", false,
				false, false, null));
		containers.get("Bookshelf").add(items.get("Paper"));
		containers.put("Sidetable", new Container("Sidetable",
				"A wooden side table.", false, false, false, null));
		containers.get("Sidetable").add(items.get("Study Room Key"));
		containers
				.put("Cupboard", new Container("Cupboard",
						"A cupboard covered with spiderweb", false, false,
						false, null));
		containers.get("Cupboard").add(items.get("Matches"));
		containers.put("Lamp", new Container("Lamp", "An old-fashioned lamp",
				true, true, true, "Matches"));
		containers.put("Bedroom Lamp", new Container("Bedroom Lamp", "An old-fashioned lamp",
				true, true, true, "Matches"));
	}

	/**
	 * Initialises all the rooms in the game. Places all the items and
	 * containers in designated rooms.
	 */
	public void initialiseRooms() {
		
		rooms.put("Kitchen", new Room("Kitchen", false, null));
		this.kitchen = rooms.get("Kitchen");
		rooms.put("Study", new Room("Study", true, "Study Room Key"));
		this.study = rooms.get("Study");
		rooms.put("Living Room", new Room("Living Room", false, null));
		this.livingRoom = rooms.get("Living Room");
		rooms.put("Bedroom", new Room("Bedroom", false, null));
		this.bedroom = rooms.get("Bedroom");
		// Hall Rooms
		rooms.put("Main Hall", new Room("Main Hall", false, null));
		this.mainHall = rooms.get("Main Hall");
		rooms.put("Hall - Study", new Room("Hall - Study", false, null));
		this.hallLeftStudy = rooms.get("Hall - Study");
		rooms.put("Hall - Bedroom", new Room("Hall - Bedroom", false, null));
		this.hallRightBedroom = rooms.get("Hall - Bedroom");
		rooms.put("Hall - Living Room", new Room("Hall - Living Room", false,
				null));
		this.hallRightLivingRoom = rooms.get("Hall - Living Room");
		rooms.put("Hall - Kitchen", new Room("Hall - Kitchen", false, null));
		this.hallLeftKitchen = rooms.get("Hall - Kitchen");

		kitchen.addItem(items.get("Kitchen Table"));
		kitchen.addItem(items.get("Kitchen Picture"));
		kitchen.addContainer(containers.get("Fridge"));
		kitchen.addContainer(containers.get("Kitchen Bin"));
		kitchen.addContainer(containers.get("Cupboard"));

		study.addItem(items.get("Chair"));
		study.addItem(items.get("Desk"));
		study.addContainer(containers.get("Study Room Bin"));
		study.addContainer(containers.get("Bookshelf"));
		study.addContainer(containers.get("Study Room Safe"));
		study.addItem(containers.get("Lamp"));

		livingRoom.addItem(items.get("Table"));
		livingRoom.addItem(items.get("Sofa"));
		livingRoom.addItem(items.get("Living Room Picture"));
		livingRoom.addItem(items.get("Portrait"));
		livingRoom.addContainer(containers.get("Living Room Bin"));
		livingRoom.addContainer(containers.get("Living Room Safe"));

		bedroom.addItem(items.get("Bed"));
		bedroom.addItem(items.get("Table"));
		bedroom.addContainer(containers.get("Bedroom Lamp"));
		bedroom.addContainer(containers.get("Bedroom Bin"));
		bedroom.addContainer(containers.get("Bedroom Safe"));
		bedroom.addContainer(containers.get("Sidetable"));
		
		assignItemsToRooms();

	}

	/**
	 * Assigns a 2D array of item Strings for each direction in every room
	 * 
	 */
	public void assignItemsToRooms() {
		study.setItemsByDirection("North", STUDY_NORTH);
		study.setItemsByDirection("East", STUDY_EAST);
		study.setItemsByDirection("South", STUDY_SOUTH);
		study.setItemsByDirection("West", STUDY_WEST);

		livingRoom.setItemsByDirection("North", LIVING_NORTH);
		livingRoom.setItemsByDirection("East", LIVING_EAST);
		livingRoom.setItemsByDirection("South", LIVING_SOUTH);
		livingRoom.setItemsByDirection("West", LIVING_WEST);
		
		bedroom.setItemsByDirection("North", BEDROOM_NORTH);
		bedroom.setItemsByDirection("East", BEDROOM_EAST);
		bedroom.setItemsByDirection("South", BEDROOM_SOUTH);
		bedroom.setItemsByDirection("West", BEDROOM_WEST);
		
		kitchen.setItemsByDirection("North", KITCHEN_NORTH);
		kitchen.setItemsByDirection("East", KITCHEN_EAST);
		kitchen.setItemsByDirection("South", KITCHEN_SOUTH);
		kitchen.setItemsByDirection("West", KITCHEN_WEST);
	}

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	/**
	 * Allows the user to use an item (e.g. Use key to open safe)
	 * 
	 * @param con
	 *            container to be opened
	 * @param key
	 *            key to open container
	 * @return if opened
	 */
	public boolean useItem(Container con, String key) {
		if (containers.get(con.getName()).getKey().equals(key)) {
			return true;
		}
		return false;
	}

	/* GETTERS AND SETTERS */
	
	/**
	 * Returns the list of rooms from the hashmap
	 * 
	 * @return
	 */
	public ArrayList<Room> getRoomList() {
		ArrayList<Room> r = new ArrayList<Room>();
		for(Room rm : rooms.values()){
			r.add(rm);
		}
		return r;
	}

	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public HashMap<String, Room> getRooms() {
		return this.rooms;
	}
	
	public void setRooms(HashMap<String, Room> rooms) {
		this.rooms = rooms;
	}

	public HashMap<String, Container> getContainers() {
		return containers;
	}

	public void setContainers(HashMap<String, Container> containers) {
		this.containers = containers;
	}

	public HashMap<String, Item> getItems() {
		return items;
	}

	public void setItems(HashMap<String, Item> items) {
		this.items = items;
	}

	/* 2D ARRAYS FOR EACH DIRECTION IN THE STUDY ROOM */
	private String[][] STUDY_NORTH = {
			{"Study Room Bin", "", "", "", "", "Study Room Safe"},
			{"", "", "", "Chair", "", ""},
			{"", "", "", "Desk", "Desk", ""}
		};
	private String[][] STUDY_EAST = {
			{"Study Room Safe", "", "", "", "", "Lamp"},
			{"", "", "", "Desk", "", "", ""},
			{"", "Chair", "Desk", "", "", ""}
		};
	private String[][] STUDY_SOUTH = {
			{"Lamp", "", "Door", "Door", "", ""},
			{"", "", "", "", "", "Bookshelf"},
			{"", "", "", "", "", "Bookshelf"}
		};
	private String[][] STUDY_WEST = {
			{"", "Bookshelf", "Bookshelf", "", "", "Study Room Bin"},
			{"", "", "", "", "", ""},
			{"", "", "", "", "", ""}
		};
	
	/* 2D ARRAYS FOR EACH DIRECTION IN THE LIVING ROOM */
	private String[][] LIVING_NORTH = {
			{"Living Room Bin", "", "", "Sofa", "Sofa", ""},
			{"", "", "", "", "", ""},
			{"", "", "", "Table", "Table", ""}
		};
	private String[][] LIVING_EAST = {	//added a family portrait 
			{"", "Portrait", "", "Frame", "", "Living Room Picture"},
			{"Sofa", "", "Table", "", "", ""},
			{"Sofa", "", "Table", "", "", ""}
		};
	private String[][] LIVING_SOUTH = {
			{"", "", "Door", "Door", "", "Living Room Safe"},
			{"", "", "", "", "", ""},
			{"", "", "", "", "", ""}
		};
	private String[][] LIVING_WEST = {
			{"Safe", "", "", "", "", "Living Room Bin"},
			{"", "", "", "", "", ""},
			{"", "", "", "", "", ""}
		};

	/* 2D ARRAYS FOR EACH DIRECTION IN THE KITCHEN */
	private String[][] KITCHEN_NORTH = {
			{"Kitchen Bin", "", "", "", "", "Fridge"},
			{"", "", "", "Kitchen Table", "Kitchen Table", ""},
			{"", "", "", "", "", ""}
		};
	private String[][] KITCHEN_EAST = {
			{"Fridge", "", "", "", "", "Kitchen Picture"},
			{"", "Kitchen Table", "", "", "", ""},
			{"", "Kitchen Table", "", "", "", ""}
		};
	private String[][] KITCHEN_SOUTH = {
			{"Kitchen Picture", "", "Door", "Door", "", ""},
			{"", "", "", "", "", "Cupboard"},
			{"", "", "", "", "", "Cupboard"}
		};
	private String[][] KITCHEN_WEST = {
			{"", "Cupboard", "Cupboard", "", "", "Kitchen Bin"},
			{"", "", "", "", "", ""},
			{"", "", "", "", "", ""}
		};
	
	/* 2D ARRAYS FOR EACH DIRECTION IN THE BEDROOM */
	private String[][] BEDROOM_NORTH = {
			{"Bedroom Bin", "", "", "", "", "Bedroom Lamp"},
			{"", "Table", "", "", "Bed", "Bed"},
			{"", "", "", "", "", "Sidetable"}
		};
	private String[][] BEDROOM_EAST = {
			{"Bedroom Lamp", "Bed", "Sidetable", "", "", ""},
			{"", "Bed", "", "", "", ""},
			{"", "", "", "", "", ""}
		};
	private String[][] BEDROOM_SOUTH = {
			{"", "", "Door", "Door", "", "Bedroom Safe"},
			{"", "", "", "", "", ""},
			{"", "", "", "", "", ""}
		};
	private String[][] BEDROOM_WEST = {
			{"Bedroom Safe", "", "", "", "", "Bedroom Bin"},
			{"", "", "", "", "Table", ""},
			{"", "", "", "", "", ""}
		};

}