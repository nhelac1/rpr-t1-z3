package ba.unsa.etf.rpr;

public class Sat {
    private int sat;
    private int minuta;
    private int sekunda;

    Sat (int h, int m, int s) {
        postavi(h, m, s);
    }
    public void postavi(int h, int m, int s) {
        sat = h;
        minuta = m;
        sekunda = s;
    }
    public void sljedeci() {
        sekunda = sekunda + 1;
        if (sekunda == 60) {
            sekunda = 0;
            minuta = minuta + 1;
        }
        if (minuta == 60) {
            minuta = 0;
            sat = sat + 1;
        }
        if (sat == 24)
            sat = 0;
    }
    public void prethodni() {
        sekunda = sekunda - 1;
        if (sekunda == -1) {
            sekunda = 59;
            minuta = minuta - 1;
        }
        if (minuta == -1) {
            minuta = 59;
            sat = sat - 1;
        }
        if (sat == -1)
            sat = 23;
    }
    public void pomjeriZa (int pomak) {
        if (pomak > 0) {
            for (int i = 0; i < pomak; i++)
                sljedeci();
        } else
            for (int i = 0; i <= pomak; i++)
                prethodni();
    }
    public  int dajSate() {
        return sat;
    }
    public  int dajMinute() {
        return minuta;
    }
    public  int dajSekunde() {
        return sekunda;
    }
    void Ispisi() {
        System.out.println(sat + ":" + minuta + ":" + sekunda);
    }
    public static void main(String[] args) {
	Sat h = new Sat(15, 30, 45);

    h.Ispisi();
    h.sljedeci();
    h.Ispisi();
    h.pomjeriZa(-48);
    h.Ispisi();
    h.postavi(0, 0, 0);
    h.Ispisi();
    }
}
