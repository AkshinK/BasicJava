import java.util.Scanner;

public class Main {
    /*
    The project writes everything to a file named "Output.txt"
The OoompaLoompa song writes to a file named "RandomSong.txt"
*/

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice != -1) {
            System.out.println("Select the number to execute:(Enter '-1' to exit)\n\n" +
                    "1 - Register Prize tickets\n" +
                    "2 - List all prize tickets\n" +
                    "3 - List only raffled tickets\n" +
                    "4 - Create a new Oompa Loompa song\n" +
                    "5 - Register Beings\n" +
                    "6 - Register Products\n" +
                    "7 - Ruffle tickets\n" +
                    "8 - Register sale\n" +
                    "9 - List winners\n" +
                    "0 - Write everything to file");
            choice = scanner.nextInt();
            MenuItem menuItem = new MenuItem();
            switch (choice) {
                case 1:
                    menuItem.registerPrize();
                    break;
                case 2:
                    menuItem.listTickets();
                    break;
                case 3:
                    menuItem.listRaffledTickets();
                    break;
                case 4:
                    menuItem.singASong();
                    break;
                case 5:
                    menuItem.registerBeings();
                    break;
                case 6:
                    menuItem.registerProducts();
                    break;
                case 7:
                    menuItem.ruffleTicket();
                    break;
                case 8:
                    menuItem.registerSale();
                    break;
                case 9:
                    menuItem.listWinners();
                    break;
                case 0:
                    menuItem.writeToFile();
                    break;
                default:
                    break;
            }
        }
    }
}
