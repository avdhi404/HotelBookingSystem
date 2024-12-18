import java.util.Scanner;
import java.util.ArrayList;

class Room{
	int roomNumber;
	boolean isAvailable;
	double pricePerNight;
	
	public Room(int roomNumber, double pricePerNight){
		this.roomNumber = roomNumber;
		this.isAvailable = true;
		this.pricePerNight = pricePerNight;
	}

	public void bookRoom(){
		if (isAvailable){
			isAvailable = false;
			System.out.println("Room " + roomNumber + " has been booked sucessfully.");
		} else {
			System.out.println("Sorry, Room " + roomNumber + "is already booked.");
		}
	}

	public void checkAvailability(){
		if (isAvailable){
			System.out.println("Room " + roomNumber + " is available.");
		} else {
			System.out.println("Room " + roomNumber + " is not available.");
		}
	}

	public void displayRoomDetails(){
		System.out.println("Room Number: " + roomNumber + 
			" | Price per Night: $" + pricePerNight +
			" | Available: " + (isAvailable ? "Yes" : "No"));
	}
}

class HotelBookingSystem{
	ArrayList<Room> rooms = new ArrayList<>();
	public void addRooms(){
		rooms.add(new Room(101, 100.00));
		rooms.add(new Room(102, 120.00));
		rooms.add(new Room(103, 150.00));
		rooms.add(new Room(104, 200.00));
		rooms.add(new Room(105, 250.00));
		
	}
	
	public void displayAvailableRooms(){
		System.out.println("\n--- Available Rooms ---");
		for (Room room : rooms){
			room.checkAvailability();
		}
	}

	public void bookRoom(int roomNumber){
		for(Room room : rooms){
			if(room.roomNumber == roomNumber){
				room.bookRoom();
				return;
			}
		}
		System.out.println("Room not found.");
	}

	public void calculateTotalCost(int roomNumber, int nights) {
		for (Room room : rooms) {
			if (room.roomNumber == roomNumber) {
				if (!room.isAvailable) {
					double totalCost = room.pricePerNight * nights;
					System.out.println("Total cost for " + nights + " nights: $" + totalCost);
					return;
				} else {
					System.out.println("Room is not booked yet.");
				}
			}
		}
		System.out.println("Room not found.");
	}
}

public class HotelBookingSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelBookingSystem hotel = new HotelBookingSystem();
        hotel.addRooms();

		while (true) {
			System.out.println("\n--- Hotel Booking System ---");
			System.out.println("1. View Available Rooms");
			System.out.println("2. Book a Room");
			System.out.println("3. Calculate Total Cost");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1: // View available rooms
					hotel.displayAvailableRooms();
					break;
				case 2: // Book a room
					System.out.print("Enter room number to book (101-105): ");
					int roomNumber = scanner.nextInt();
					hotel.bookRoom(roomNumber);
					break;
				case 3: // Calculate total cost
					System.out.print("Enter room number to calculate cost (101-105): ");
					int roomForCost = scanner.nextInt();
					System.out.print("Enter number of nights: ");
					int nights = scanner.nextInt();
					hotel.calculateTotalCost(roomForCost, nights);
					break;
				case 4: // Exit
					System.out.println("Thank you for using the Hotel Booking System!");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
