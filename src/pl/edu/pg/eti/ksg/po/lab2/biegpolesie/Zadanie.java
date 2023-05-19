package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TB
 */
class Zadanie implements ElementTrasy {

    private final DziedzinaZadania dziedzinaZadania;
    private Map<Uczestnik,Double> uczestnicyZadania = new HashMap<>();


     Zadanie(DziedzinaZadania dziedzinaZadania)
    {
        this.dziedzinaZadania = dziedzinaZadania;
    }


    @Override
    public Iterable<Uczestnik> getUczestnicy() {
        return uczestnicyZadania.keySet();
    }

    public DziedzinaZadania getDziedzinaZadania() {
        return dziedzinaZadania;
    }

    public Map<Uczestnik, Double> getUczestnicyZadania() {
        return uczestnicyZadania;
    }

    @Override
    public void dodajUczestnika(Uczestnik u) {
        uczestnicyZadania.put(u, 0.0);
    }

    @Override
    public void usunUczestnika(Uczestnik u) {
        uczestnicyZadania.remove(u);
    }

    @Override
    public int getLiczbaUczestnikowNaTrasie() {
        return uczestnicyZadania.size();
    }

}
