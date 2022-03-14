package tp2.hanoi;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in);
            int choice = 0;
            while (choice != 3) {
                /*
                console clear (ne marche pas sur linux (ubuntu 20.4), a tester sur windows
                - new ProcessBuilder("clear").inheritIO().start().waitFor();
                - clearConsole();
                */
                System.out.println("\n// MENU\n// 1.Pile test\n// 2.Hanoi problem\n// 3.Leave the program\n");
                System.out.print("Your choice: ");
                choice = myObj.nextInt();
                switch (choice) {
                    case 1 -> {
                        tp2.pileFile.Test T1 = new tp2.pileFile.Test();
                        T1.testPile2();
                    }
                    case 2 -> HanoiFunc();
                    case 3 -> System.out.println("Good bye!");
                    default -> System.out.println("You need to choose a number between 1 and 3!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void HanoiFunc() {
        try {
            Scanner myObj = new Scanner(System.in);
            int disk_number = 0;
            while (disk_number < 3 || disk_number > 8) {
                System.out.print("\n\nEnter the number of disks (3 to 8): ");
                disk_number = myObj.nextInt();
                if(disk_number < 3 || disk_number > 8) {
                    System.out.print("Wrong number of disks");
                }
            }

            Hanoi test = new Hanoi();
            test.init(disk_number);
            test.display();
            test.hanoi_process(disk_number, test.getP1(), test.getP3(), test.getP2());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
