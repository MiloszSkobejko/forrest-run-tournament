package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

import java.util.Random;

/**
 *
 * @author TB
 */
public class Student extends Czlowiek{

    protected final DziedzinaZadania kierunek;

    public Student(String imie, String nazwisko, Plec plec, DziedzinaZadania kier_studiow)
    {
        super(imie, nazwisko, plec);
        kierunek = kier_studiow;
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć! Jestem studentem " + kierunek + ", nazywam sie "+getImie()+" "+getNazwisko()+". ");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {

            return Math.min(1.0, super.predkoscPoruszaniaSie(rodzajTerenu) * 1.1);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania zad) {

        Random generator = new Random();

        return generator.nextDouble() * 100 > 80;
    }

}
