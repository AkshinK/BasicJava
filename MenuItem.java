import models.*;

import java.io.*;
import java.util.*;

public class MenuItem {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> initialProducts = new ArrayList<>();
    private static ArrayList<GoldenTicket> prizeTickets = new ArrayList<>();
    private static ArrayList<Kid> kids = new ArrayList<>();
    private static ArrayList<OompaLoompa> oompaLoompas = new ArrayList<>();

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public void singASong() throws Exception {
		PrintWriter writer = new PrintWriter("RandomSong.txt");
        System.out.println("Enter the lines for song:\n");
        int lines = scanner.nextInt();
        OompaLoompaSong oompaLoompaSong = new OompaLoompaSong(lines);
        for (int i = 0; i < lines; i++) {
			String song = oompaLoompaSong.sing();
            System.out.println(song);
			writer.println(song);
        }
		System.out.println('\n');
		writer.close();
    }

    public  void listTickets() {
        for (int i = 0; i < prizeTickets.size(); i++) {
            System.out.println(prizeTickets.get(i));
        }
        System.out.println('\n');
    }

    public void listRaffledTickets() {
		System.out.println("The list of raffled tickets:\n");
        for (int i = 0; i < prizeTickets.size(); i++) {
            if (prizeTickets.get(i).isRaffled()) {
                System.out.println(prizeTickets.get(i));
            }
        }
		System.out.println('\n');
    }

        public void registerPrize() throws Exception{
            System.out.println("Do you want to create normal ticket or golden ticket: \nFor golden ticket press - G, for normal press - N");
            String choice = scanner.next();
            if (choice.toUpperCase().equals("G")) {
                Date date = new Date();
                String code = GoldenTicket.codeCreator();
                GoldenTicket goldenTicket = new GoldenTicket(code, date);
                prizeTickets.add(goldenTicket);
                System.out.println("Golden ticket added");
            }
            else if (choice.toUpperCase().equals("N")) {
                GoldenTicket normalTicket = new GoldenTicket();
                prizeTickets.add(normalTicket);
                System.out.println("Normal ticket added");
            }
    }

    public void registerBeings() throws Exception{
        System.out.println("If you want to register Kid press K, for OompaLoompa press O:");
        String choice = scanner.next();
        if (choice.toUpperCase().equals("K")) {
            System.out.println("Enter kid's code: ");
            int code = scanner.nextInt();
            System.out.println("Enter the name: ");
            String name = scanner.next();
            System.out.println("Enter the birthday in format yyyy-MM-dd: ");
            String birthDay = scanner.next();
            System.out.println("Enter the place of birth: ");
            String place = scanner.next();

            Kid kid = new Kid(code,name,birthDay,place);
            kids.add(kid);
            System.out.println("Kid is registered");

        }
        else if (choice.toUpperCase().equals("O")) {
            System.out.println("Enter OompaLoompa's code: ");
            int code = scanner.nextInt();
            System.out.println("Enter the height: ");
            int height = scanner.nextInt();
            System.out.println("Enter the name: ");
            String name = scanner.next();
            System.out.println("Enter the favourite food: ");
            String food = scanner.next();

            OompaLoompa oompaLoompa = new OompaLoompa(code,name,height,food);
            oompaLoompas.add(oompaLoompa);
            System.out.println("Oompa loompa is registered");
        }
    }

    public void registerProducts() {
        System.out.println("Enter Product's description: ");
        String description = scanner.next();
        System.out.println("Enter the barcode: ");
        long barcode = scanner.nextInt();
        System.out.println("Enter the serial number: ");
        String serialNum = scanner.next();
            Product product = new Product(description, barcode, serialNum);
            products.add(product);
	    initialProducts.add(product);
            System.out.println("The Product is registered successfully!");

        }
        public void registerSale () {
            System.out.println("Enter the kid's code: ");
            int code = scanner.nextInt();
            System.out.println("Enter the product's barcode: ");
            long barcode = scanner.nextInt();

            for (int i = 0; i < kids.size(); i++) {
                if (kids.get(i).getCode() == code) {
                    ArrayList<Product> randomProductList = new ArrayList<>();
                    for (int j = 0; j < products.size(); j++) {
                        if (products.get(j).getBarcode() == barcode) {
                            randomProductList.add(products.get(j));
                        }
                    }
                    int randomProductIndex = random.nextInt(randomProductList.size());
                    kids.get(i).addProduct(randomProductList.get(randomProductIndex));
					System.out.println("Product sold to the kid successfully!");
                    products.remove(randomProductList.get(randomProductIndex));
                    break;
                }
            }
        }

        public void ruffleTicket () {
            System.out.println("How many ticket will be ruffled: ");
            int tickets = scanner.nextInt();
            int randomTicket;
            int i = 0;
            while (i < tickets) {
                System.out.println("Do you want to ruffle the existing golden ticket or create new one?:\nFor new one enter - N, for existing prizes enter the the code of the ticket:");
                String choice = scanner.next();
                if(choice.toUpperCase().equals("N")){
                    Date ruffledDate = new Date();
                    String code = GoldenTicket.codeCreator();
                    GoldenTicket goldenTicket = new GoldenTicket(code, ruffledDate);
                    prizeTickets.add(goldenTicket);
                    randomTicket = random.nextInt(products.size());
                    while (products.get(randomTicket).getPrizeTicket() != null &&
                            products.get(randomTicket).getPrizeTicket().isRaffled())
                        randomTicket = random.nextInt(products.size());

                    products.get(randomTicket).setPrizeTicket(goldenTicket);
                    System.out.println("The golden ticket with code " + goldenTicket.getCode() + " ruffled in random product with the serial number " + products.get(randomTicket).getSerialNumber());
					System.out.println('\n');
                }
                else {
                    for (int j = 0; j < prizeTickets.size(); j++) {
                        if(choice.equals(prizeTickets.get(j).getCode())){
                            randomTicket = random.nextInt(products.size());
                            while (products.get(randomTicket).getPrizeTicket() != null &&
                                    products.get(randomTicket).getPrizeTicket().isRaffled())
                                randomTicket = random.nextInt(products.size());
                            products.get(randomTicket).setPrizeTicket(prizeTickets.get(j));
                            System.out.println("The golden ticket with code " + prizeTickets.get(j).getCode() + " ruffled in random product with the serial number " + products.get(randomTicket).getSerialNumber());
							System.out.println('\n');
                        }
                    }
                }
                i++;
            }
        }


        public void listWinners () {
            ArrayList<Product> purchasedProducts;
            for (int i = 0; i < kids.size(); ++i) {
                purchasedProducts = kids.get(i).getPurchasedProducts();
                if (purchasedProducts != null && purchasedProducts.size() != 0) {
                    for (int j = 0; j < kids.get(i).getPurchasedProducts().size(); j++) {
                        if (purchasedProducts.get(j).getPrizeTicket() != null) {
                            System.out.println("Winner: " + kids.get(i).getName());
                            break;
                        }
                    }
                    break;
                } else
                    System.out.println("There is no winner");
            }
        }

        public void listProducts(){
            for (int i = 0; i < products.size(); i++) {
                System.out.println(products.get(i));
            }
        }
        public void writeToFile () throws Exception {
            PrintWriter writer = new PrintWriter("Output.txt");

            writer.println("The list of the tickets:\n");

            for(GoldenTicket goldenTicket : prizeTickets){
                writer.println(goldenTicket.toString());
            }
            writer.println("\n\n\n");

            writer.println("The list of the kids:\n");
            for (Kid kid : kids) {
                writer.println(kid.toString());
                if (kid.getPurchasedProducts() != null) {
                    writer.println("Purchased products of the kid:\n");
                    for (Product product : kid.getPurchasedProducts()) {
                        writer.println(product.toString());
                    }
                }
            }

            writer.println("\n\n\n");
            writer.println("The list of oompaloompas:\n");
            for (OompaLoompa oompaLoompa : oompaLoompas) {
                writer.println(oompaLoompa.toString());}

            writer.println("\n\n\n");

            writer.println("The list of the products:\n");
            for (Product product : initialProducts){
                writer.println(product.toString());
            }
            writer.close();
        }
    }