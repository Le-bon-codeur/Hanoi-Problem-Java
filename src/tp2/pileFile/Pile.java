package tp2.pileFile;

public class Pile {
    protected final List m_pile;

    Pile() {
        this.m_pile = new List();
    }
    Pile(List _l) {
        this.m_pile = _l;
    }

    protected void stack(Object _o) {
        this.m_pile.last();
        this.m_pile.add(_o);
    }
    protected Object unstack() throws Exception {
        try {
            this.m_pile.last();
            return this.m_pile.delete();
        } catch (Exception e) {
            return e;
        }
    }
     public void display() {
         this.m_pile.display();
     }
}

