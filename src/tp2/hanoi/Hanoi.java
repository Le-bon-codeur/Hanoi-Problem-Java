package tp2.hanoi;
import tp2.pileFile.*;

public class Hanoi {
    private final PileInteger P1;
    private final PileInteger P2;
    private final PileInteger P3;

    public Hanoi() {
        this.P1 = new PileInteger();
        this.P2 = new PileInteger();
        this.P3 = new PileInteger();
    }

    public PileInteger getP1() {
        return P1;
    }
    public PileInteger getP2() {
        return P2;
    }
    public PileInteger getP3() {
        return P3;
    }

    public void init(int _disk_number) {
        int tmp = _disk_number;
        for(int i = 0; i < _disk_number; i++) {
            P1.stack(tmp);
            tmp--;
        }
    }

    public void hanoi_process(int _num_disk, PileInteger _start, PileInteger _end, PileInteger _tmp) throws Exception {
        if(_num_disk != 0) {
            hanoi_process(_num_disk-1, _start, _tmp, _end);
            Integer tmp = _start.unstack();
            _end.stack(tmp);
            display();
            hanoi_process(_num_disk-1, _tmp, _end, _start);
        }
    }

    public void display() {
        System.out.print("\n\nP1: ");
        P1.display();
        System.out.print("\nP2: ");
        P2.display();
        System.out.print("\nP3: ");
        P3.display();
    }
}
