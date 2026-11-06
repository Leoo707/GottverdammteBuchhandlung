package Bücherei;

public class Ausgeliehen extends AbstractBuchStatus {

    public Ausgeliehen(Buch buch) {
        super(buch);
    }

    @Override
    public BuchStatus rueckgabe() {
        buch.setAusgeliehenVon(null);
        if(buch.hatVorbestellungen()) {
            return new Abholbereit(buch);
        }
        else {
            return new Verfügbar(buch);
        }
    }

    @Override
    public BuchStatus verloren() {
        //Rechnung stellen
        buch.setAusgeliehenVon(null);
        return new Unbrauchbar(buch);
    }
}
