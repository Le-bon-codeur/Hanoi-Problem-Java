package tp2.hanoi;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter the number of disks you want: ");
            int disk_number = myObj.nextInt();

            Hanoi test = new Hanoi();
            test.init(disk_number);
            test.display();
            test.hanoi_process(disk_number, test.getP1(), test.getP3(), test.getP2());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
