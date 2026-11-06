package Bücherei;

public interface BuchStatus {

    void statusBetreten();

    void statusVerlassen();

    BuchStatus vorbestellen(Person person);

    BuchStatus ausleihen(Person person);

    BuchStatus verloren();

    BuchStatus aussondern();

    BuchStatus rueckgabe();

    BuchStatus abholzeitAbgelaufen();
}
