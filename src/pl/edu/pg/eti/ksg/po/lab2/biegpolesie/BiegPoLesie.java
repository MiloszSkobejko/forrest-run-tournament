package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author TB
 */
public class BiegPoLesie {
    private final String nazwa;
    private final PrintStream mikrofon, przestrzenWLesie;
    private final Komentator komentator;
    private final List<ElementTrasy> elementyTrasy;
    private final Set<Uczestnik> uczestnicy;
    private final List<Uczestnik> meta;
    
    
    public BiegPoLesie(String nazwa, PrintStream mikrofon, PrintStream przestrzenWLesie) {
        this.nazwa = nazwa;
        this.mikrofon = mikrofon;
        this.przestrzenWLesie = przestrzenWLesie;
        this.komentator = new Komentator(mikrofon);
        this.elementyTrasy = new LinkedList<>();
        this.uczestnicy = new HashSet<>();
        this.meta = new LinkedList<>();

    }

    public void dodajElementTrasy(ElementTrasy e) {
        elementyTrasy.add(e);
    }

    public void wyczyscTrase() {
        elementyTrasy.clear();
    }
    
    public Iterable<ElementTrasy> getElementyTrasy()
    {
        return elementyTrasy;
    }

    public void dodajUczestnika(Uczestnik u) {
        uczestnicy.add(u);
    }

    public void wyczyscListeStartowa() {
        uczestnicy.clear();
    }

    public Iterable<Uczestnik> getUczestnicy() {
        return uczestnicy;
    }
    
    public void przeprowadzImpreze()
    {
        komentator.inaugurujBieg(nazwa, uczestnicy);
        
        for(Uczestnik u : uczestnicy)
        {
            u.mowDo(przestrzenWLesie);
        }
        
        komentator.oznajmijStartUczestnikow(uczestnicy.size(), elementyTrasy.size());
        
        for(Uczestnik u : uczestnicy)
        {
            umiescUczestnikaWElemencieTrasy(u, 0);
        }
        
        
        boolean czyPozostaliUczestnicyNaTrasie;
        int licznikTur = 1;
        do
        {
            komentator.powiadomONowejTurze(licznikTur);
            czyPozostaliUczestnicyNaTrasie = false;
            for(int iterator = elementyTrasy.size() - 1; iterator >= 0; iterator--)
            {
                boolean czyPozostaliUczestnicy = zmaganiaZElementemTrasy(iterator) > 0;
                czyPozostaliUczestnicyNaTrasie = czyPozostaliUczestnicyNaTrasie || czyPozostaliUczestnicy;
            }
            licznikTur++;
        }
        while(czyPozostaliUczestnicyNaTrasie);

        ZakonczBieg();
    }
    
    private void umiescUczestnikaWElemencieTrasy(Uczestnik u, int i) {
        if(i < elementyTrasy.size())
        {
            elementyTrasy.get(i).dodajUczestnika(u);
        }
        else
        {
            meta.add(u);
            System.out.println("DODANO DO META");
        }
    }
        
    private int zmaganiaZElementemTrasy(int indeksElementuTrasy)
    {
        ElementTrasy et = elementyTrasy.get(indeksElementuTrasy);
        HashSet<Uczestnik> doUsuniecia = new HashSet<>();

        int liczbaUczestnikow = 0;
        if(et instanceof Teren)
        {
            Teren t = (Teren) et;
            for(Uczestnik u : t.getUczestnicy())
            {   
                komentator.relacjonuj(indeksElementuTrasy+1, u, t.getRodzajTerenu());
                double predkosc = u.predkoscPoruszaniaSie(t.getRodzajTerenu());

                double dotychczasowyPostep = t.getUczestnicyWTerenie().get(u);

                dotychczasowyPostep += predkosc * 1;

                if(dotychczasowyPostep < 1.0)
                    t.getUczestnicyWTerenie().put(u, dotychczasowyPostep);
                else
                {
                    doUsuniecia.add(u);
                    umiescUczestnikaWElemencieTrasy(u,indeksElementuTrasy + 1);
                }
                liczbaUczestnikow++;
            }
        }

        if (et instanceof Zadanie)
        {
            Zadanie zad = (Zadanie) et;

            for(Uczestnik u : zad.getUczestnicy())
            {
                komentator.relacjonujZadanie(indeksElementuTrasy+1, u, zad.getDziedzinaZadania());

                if (u.rozwiazZadanie(zad.getDziedzinaZadania()))
                {
                    doUsuniecia.add(u);
                    umiescUczestnikaWElemencieTrasy(u, indeksElementuTrasy + 1);
                }

                liczbaUczestnikow++;
            }
        }


//        for(Uczestnik u : doUsuniecia)
//        {
//            et.usunUczestnika(u);
//        }

        doUsuniecia.forEach(u -> et.usunUczestnika(u));


        return liczbaUczestnikow;
    }

    public void ZakonczBieg()
    {
        komentator.KomentujKoniec(uczestnicy, meta);
    }

}
