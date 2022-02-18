package tp2.pileFile;

public class PileInteger extends Pile {
    public PileInteger() {
        super();
    }
    public void stack(Integer _i) {
        super.m_pile.last();
        super.m_pile.add(_i);
    }
    public Integer unstack() throws Exception {
        try {
            super.m_pile.last();
            return (Integer) super.m_pile.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void display() {
        super.m_pile.display();
    }
}
