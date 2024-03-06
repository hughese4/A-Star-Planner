import java.util.Scanner;

public class MonkeLogic {
    private String room_loc;
    private String box_loc;
    private String bananas_loc;
    
    // Game intro to initialize the starting locations of the monkey, box, and bananas
    public void intro() {
        Scanner scanner = new Scanner(System.in);       
        do {
            System.out.println("=================================================\n");
            System.out.println("Select which room the monkey starts in: ");
            System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==> ");
            room_loc = scanner.next();
        } while (!room_loc.equals("A") && !room_loc.equals("B") && !room_loc.equals("C"));

        do {
            System.out.println("Select which room the box starts in: ");
            System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==> ");
            box_loc = scanner.next();
        } while (!box_loc.equals("A") && !box_loc.equals("B") && !box_loc.equals("C"));

        do {
            System.out.println("Select which room the bananas starts in: ");
            System.out.print("[1] Room A\n[2] Room B\n[3] Room C\n==> ");
            bananas_loc = scanner.next();
        } while (!bananas_loc.equals("A") && !bananas_loc.equals("B") && !bananas_loc.equals("C"));
    }

    // Main loop for the program
    public void planLoop() {
        System.out.println("The monkey is in room " + room_loc);
        System.out.println("The box is in room " + box_loc);
        System.out.println("The bananas are in room " + bananas_loc);
    }

}
