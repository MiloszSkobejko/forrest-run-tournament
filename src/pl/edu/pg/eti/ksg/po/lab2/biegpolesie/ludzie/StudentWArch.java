package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie;


import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

import java.util.Random;

public class StudentWArch extends StudentPolitechniki{
    public StudentWArch (String imie, String nazwisko, Plec plec, DziedzinaZadania kier_studiow)
    {
        super (imie, nazwisko, plec, kier_studiow);

    }

    @Override
    public void przedstawSie() {
        wypowiedzSie("Cześć!  nazywam sie "+getImie()+" "+getNazwisko()+". Jestem studentem Politechniki gdanskiej!" +
                "Studiuje na Wydziale architektury " + kierunek + ". Uwielbiam projektowac zabetonowane place oraz osiedla z mieszkaniami 20m kwadratowch dla 5 osob i kiblem kolo zlewu");
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {

        return Math.min(1.0, super.predkoscPoruszaniaSie(rodzajTerenu) * 1.1);
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania zad) {

        Random generator = new Random();

        if (DziedzinaZadania.INFORMATYKA.equals(zad) || DziedzinaZadania.SZTUKA.equals(zad) || DziedzinaZadania.MATEMATYKA.equals(zad))
        {
            wypowiedzSie("No i elegancko, to jest to co lubie");
            return generator.nextDouble() * 100 > 60;
        }

        wypowiedzSie("nie moj klimat ale moze sie uda");
        return generator.nextDouble() * 100 > 80;
    }

}

