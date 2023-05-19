package pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.DziedzinaZadania;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.RodzajTerenu;

import java.util.Random;

public class TerminatorL extends Terminator{

    public TerminatorL(String model, int numerSeryjny)
    {
        super ("Terminator T-101L meluje sie na starcie", numerSeryjny);
    }

    @Override
    public double predkoscPoruszaniaSie(RodzajTerenu rodzajTerenu) {
        switch(rodzajTerenu)
        {
            case DROGA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". DO PRZODU SZYBKO.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.95; //Od 0.95 do 1.5
            case SCIEZKA:
                komunikuj("Wykryto teren: "+rodzajTerenu+". DO PRZODU NAWET SZYBKO.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.85; //Od 0.85 do 0.95
            case WYSOKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". DO PRZODU.");
                return czynnikiLosowe.nextDouble()*0.1 + 0.4; //Od 0.4 do 0.5
            case NISKI_LAS:
                komunikuj("Wykryto teren: "+rodzajTerenu+". DO PRZODU.");
                return czynnikiLosowe.nextDouble()*0.2 + 0.6; //Od 0.2 do 0.4
            case BAGNO:
            default:
                komunikuj("Wykryto teren: "+rodzajTerenu+".");
                komunikuj("Awaria silników!");
                return czynnikiLosowe.nextDouble()*0.1; //Od 0.0 do 0.1
        }
    }

    @Override
    public boolean rozwiazZadanie(DziedzinaZadania zad) {

        Random generator = new Random();

        if (DziedzinaZadania.FIZYKA.equals(zad) || DziedzinaZadania.MATEMATYKA.equals(zad) || DziedzinaZadania.INFORMATYKA.equals(zad))
            return true;
        else if (DziedzinaZadania.NAUKI_LESNE.equals(zad))
            return generator.nextDouble() * 100 > 40;

        return generator.nextDouble() * 100 > 95;
    }
}
