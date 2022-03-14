package tp2.pileFile;

public class Test {

    private final PileInteger p1;
    private final PileInteger p2;
    private final PileInteger p3;
    private final PileInteger pTmp; //** Optional : used to recreate P1 after using it for P2 and P3 **//

    private final int myNum = 5;

    public Test() {
        this.p1 = new PileInteger();
        this.p2 = new PileInteger();
        this.p3 = new PileInteger();
        this.pTmp = new PileInteger();
        init();
    }
    public Test(PileInteger p1, PileInteger p2, PileInteger p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.pTmp = new PileInteger();
        init();
    }

    private void init() {
        for (int i = 0; i < myNum; i++) {
            Integer integer = (int) (Math.random() * 49 + 1);
            this.p1.stack(integer);
        }
    }

    private void display() {
        p1.display();
        p2.display();
        p3.display();
    }

    public void testPile() {
        try {

            // display
            System.out.println("\nStarting state:");
            display();

            // split the pile one into p2 (pair numbers) and p3 (odd numbers)
            for (int i = 0; i < myNum; i++) {
                Integer integer = p1.unstack();
                pTmp.stack(integer);
                if (integer % 2 == 0) {
                    p2.stack(integer);
                } else {
                    p3.stack(integer);
                }
            }

            // recreate p1 //**(optional)**//
            for (int i = 0; i < myNum; i++) {
                p1.stack(pTmp.unstack());
            }

            // display
            System.out.println("\nEnding State:");
            display();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void testPile2() {
        try {

            // display
            System.out.println("\nStarting state:");
            display();

            for (int i = 0; i < myNum; i++) {
                pTmp.stack(p1.unstack());
            }

            // split the pile one into p2 (pair numbers) and p3 (odd numbers)
            for (int i = 0; i < myNum; i++) {
                Integer integer = pTmp.unstack();
                if (integer % 2 == 0) {
                    p2.stack(integer);
                    p1.stack(integer);
                } else {
                    p3.stack(integer);
                    p1.stack(integer);
                }
            }

            // display
            System.out.println("\nEnding State:");
            display();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
