package tp2.pileFile;

import java.util.ArrayList;

public class List {
    private final ArrayList<Object> m_list;
    private int m_position;

    List() {
        this.m_list = new ArrayList<Object>();
        this.m_position = 0;
    }
    List(ArrayList<Object> _list) {
        this.m_list = _list;
        this.m_position = 0;
    }

    public void first() {
        this.m_position = 1;
    }
    public void last() {
        this.m_position = this.m_list.size();
    }
    public void add(Object _o) {
        this.m_list.add(_o);
    }
    public Object delete() throws Exception {
        if (m_position != 0) {
            Object tmp = m_list.get(this.m_position - 1);
            this.m_list.remove(this.m_position - 1);
            return tmp;
        } else {
            throw new Exception("The list is empty, you cannot delete elem.", null);
        }
    }
    public Object next() throws Exception {
        if (this.m_list.size() == 0) {
            throw new Exception("The list is empty, you cannot get the next elem", null);
        } else if (this.m_list.size() == 1) {
            throw new Exception("The list contains only one elem, you cannot get the next one", null);
        } else if (this.m_position == this.m_list.size()) {
            throw new Exception("You are at the end of the list, you cannot get the next elem", null);
        } else {
            return this.m_list.get(this.m_position);
        }
    }

    public void display() {
        System.out.println(m_list);
    }
}
