package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

import java.util.Random;

public class StudentWETI extends StudentPolitechniki{
    public StudentWETI (String imie, String nazwisko, Plec plec, DziedzinaZadania kier_studiow)
    {
        super (imie, nazwisko, plec, kier_studiow);

    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć!  nazywam sie "+getImie()+" "+getNazwisko()+". Jestem studentem Politechniki gdanskiej!" +
                "Studiuje na WETI " + kierunek + ". ");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {

        return Math.min(1.0, super.predkoscPoruszaniaSie(rodzajTerenu) * 1.1);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania zad) {

        Random generator = new Random();

        if (DziedzinaZadania.INFORMATYKA.equals(zad))
            return generator.nextDouble() * 100 > 1;
        else if (DziedzinaZadania.MATEMATYKA.equals(zad))
            return generator.nextDouble() * 100 > 30;
        else if (DziedzinaZadania.FIZYKA.equals(zad))
            return generator.nextDouble() * 100 > 50;

        return generator.nextDouble() * 100 > 80;
    }

}
