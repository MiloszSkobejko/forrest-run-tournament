package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.Czlowiek;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

import java.util.Random;

public class LesnyBiegacz extends Czlowiek {

    public LesnyBiegacz(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec);
    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć! Jestem "+getImie()+" "+getNazwisko()+". Biegam przez laki lasy i pola (i drogi).");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        if(RodzajTerenu.WYSOKI_LAS.equals(rodzajTerenu) || RodzajTerenu.NISKI_LAS.equals(rodzajTerenu))
        {
            wypowiedzSie("W lesie jak w polsce");
            return humorIUwarunkowaniaOsobiste.nextDouble()*0.2 + 0.2; //Od 0.2 do 0.4
        }
        else
            return Math.min(1.0, super.predkoscPoruszaniaSie(rodzajTerenu) * 1.1);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania zadanie) {

        Random generator = new Random();

        return generator.nextDouble() * 100 > 90;
    }
}
