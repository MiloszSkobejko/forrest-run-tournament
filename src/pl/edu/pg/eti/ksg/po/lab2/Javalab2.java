package pl.edu.pg.eti.ksg.po.lab2;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.*;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.ludzie.*;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.RobotMobilny;
import pl.edu.pg.eti.ksg.po.lab2.biegpolesie.roboty.Terminator;

/*
 * @author TB
 */
public class Javalab2 {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new BagiennyBiegacz("Krzysztof", "Kowalski", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new Student("Marek", "Nowak", Czlowiek.Plec.MEZCZYZNA, DziedzinaZadania.MATEMATYKA));
        uczestnicy.add(new RobotMobilny(1));
        uczestnicy.add(new StudentPolitechniki("Janek", "Ciesla", Czlowiek.Plec.MEZCZYZNA, DziedzinaZadania.MATEMATYKA));
        uczestnicy.add(new StudentWETI("Konrad", "Roland", Czlowiek.Plec.MEZCZYZNA, DziedzinaZadania.MATEMATYKA));
        uczestnicy.add(new StudentWArch("Domino", "Jachaś", Czlowiek.Plec.MEZCZYZNA, DziedzinaZadania.MATEMATYKA));
        uczestnicy.add(new StudentWETIOrazLesnik("Franek", "Firanek", Czlowiek.Plec.MEZCZYZNA, DziedzinaZadania.MATEMATYKA));
        uczestnicy.add(new Terminator("Pasztet", 1200));
        uczestnicy.add(new Terminator("Mielonka", 2400));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w aplikacji Bieg po Lesie. Wybierz bieg: ");
        System.out.println("1. Górki");
        System.out.println("2. Na przełaj z Matematyką");
        System.out.println("3. Bagienny miks naukowy");
        System.out.println("4. Spotkanie z Fizyka i Magda Gessler w Lesie");
        int wybor = scanner.nextInt();
        
        BiegPoLesie bieg;
        
        switch(wybor)
        {
            default:
                System.out.println("Niezany wybór. Wybieranie opcji nr 1.");
            case 1:
                bieg = gorki(System.out, System.out);
                break;
            case 2:
                bieg = naPrzelajZMatematyka(System.out, System.out);
                break;
            case 3:
                bieg = bagiennyMiks(System.out, System.out);
                break;
            case 4:
                bieg = MagdaWLesie(System.out, System.out);
        }
        
        for(Uczestnik u : uczestnicy)
        {
            bieg.dodajUczestnika(u);
        }
        
        bieg.przeprowadzImpreze();
    }
    
    private static BiegPoLesie gorki(PrintStream mikrofon, PrintStream przestrzenWLesie)
    {
        BiegPoLesie gorki_ = new BiegPoLesie("Górki",mikrofon,przestrzenWLesie);
        
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.DROGA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.NISKI_LAS));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.FIZYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.WYSOKI_LAS));

        
        return gorki_;
    }

    private static BiegPoLesie naPrzelajZMatematyka(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie naPrzelaj = new BiegPoLesie("Na przełaj z matematyką",mikrofon,przestrzenWLesie);
        
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.DROGA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.SCIEZKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        
        return naPrzelaj;
    }

    private static BiegPoLesie bagiennyMiks(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie miks = new BiegPoLesie("Bagienny miks naukowy",mikrofon,przestrzenWLesie);
        
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.DROGA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.SCIEZKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.FIZYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.INFORMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.SZTUKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        miks.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy(RodzajTerenu.WYSOKI_LAS));
        
        return miks;
    }

    private static BiegPoLesie MagdaWLesie(PrintStream mikrofon, PrintStream przestrzenWLesie)
    {
        BiegPoLesie magdaWLesie = new BiegPoLesie("Spotkanie z Fizyka i Magda Gessler w Lesie",mikrofon,przestrzenWLesie);

        try {
            magdaWLesie.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy("NISKI_LAS"));
            magdaWLesie.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy("WYSOKI_LAS"));
            magdaWLesie.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy("FIZYKA"));
            magdaWLesie.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy("DROGA"));
            magdaWLesie.dodajElementTrasy(FabrykaElementowTrasy.stworzElementTrasy("FIZYKA"));
        }
        catch (ElementTrasyFromStringException exc)
        {
            System.out.println("Nie ma takiej drogi");
            exc.printStackTrace();
        }


        return magdaWLesie;
    }

}
