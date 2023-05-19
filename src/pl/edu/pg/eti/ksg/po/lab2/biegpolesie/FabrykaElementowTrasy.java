package pl.edu.pg.eti.ksg.po.lab2.biegpolesie;


public class FabrykaElementowTrasy {

    public static ElementTrasy stworzElementTrasy(RodzajTerenu rodzajTerenu)
    {
        return new Teren(rodzajTerenu);
    }


    public static ElementTrasy stworzElementTrasy(DziedzinaZadania dziedzinaZadania)
    {
        return new Zadanie(dziedzinaZadania);
    }

    public static ElementTrasy stworzElementTrasy(String str) throws ElementTrasyFromStringException {

        for (DziedzinaZadania zd : DziedzinaZadania.values()) {
            if (zd.name().equals(str)) {
                return new Zadanie(zd);
            }
        }
        for (RodzajTerenu rt : RodzajTerenu.values()) {
            if (rt.name().equals(str)) {
                return new Teren(rt);
            }
        }

        throw new ElementTrasyFromStringException("String nie jest Terenem ani Zadaniem");

    }
}
