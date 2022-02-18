package tp2.pileFile;

public class Test {

    private final PileInteger p1;
    private final PileInteger p2;
    private final PileInteger p3;
    private final PileInteger pTmp;

    Test() {
        this.p1 = new PileInteger();
        this.p2 = new PileInteger();
        this.p3 = new PileInteger();
        this.pTmp = new PileInteger();
        init();
    }
    Test(PileInteger p1, PileInteger p2, PileInteger p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.pTmp = new PileInteger();
        init();
    }

    private void init() {
        for (int i = 0; i < 15; i++) {
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
            for (int i = 0; i < 15; i++) {
                Integer integer = p1.unstack();
                pTmp.stack(integer);
                if (integer % 2 == 0) {
                    p2.stack(integer);
                } else {
                    p3.stack(integer);
                }
            }

            // recreate p1
            for (int i = 0; i < 15; i++) {
                p1.stack(pTmp.unstack());
            }

            // display
            System.out.println("\nEnding State:");
            display();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
