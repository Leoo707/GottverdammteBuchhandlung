package Bücherei;

public class Verfügbar extends AbstractBuchStatus {

    public Verfügbar(Buch buch) {
        super(buch);

    }

    public BuchStatus ausleihen(Person person) {
        buch.setAusgeliehenVon(person);
        return new Ausgeliehen(buch);
    }

    public BuchStatus aussondern() {
        //Buch aus Bibliothek entfernen
        return new Unbrauchbar(buch);
    }

}
