package Bücherei;

import java.util.PriorityQueue;
import java.util.Queue;

public class Buch implements BuchStatus {

    private int id;

    private String titel;

    private Person ausgeliehenVon;

    public Person getAusgeliehenVon() {
        return ausgeliehenVon;
    }

    public void setAusgeliehenVon(Person ausgeliehenVon) {
        this.ausgeliehenVon = ausgeliehenVon;
    }

    private Queue<Person> vorbestellungen = new PriorityQueue<>();

    private BuchStatus status;

    public Buch(int id, String titel)
    {
        this.id = id;
        this.titel = titel;
        this.status = new Verfügbar(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setStatus(BuchStatus status)
    {
        this.status = status;
    }

    public BuchStatus getStatus()
    {
        return this.status;
    }

    public String getTitel()
    {
        return titel;
    }

    @Override
    public void statusBetreten() {

    }

    @Override
    public void statusVerlassen() {

    }

    @Override
    public BuchStatus vorbestellen(Person person) {
        this.status.statusVerlassen();
        setStatus(this.status.vorbestellen(person));
        this.status.statusBetreten();
        return this.status;
    }

    @Override
    public BuchStatus ausleihen(Person person) {
        this.status.statusVerlassen();
        setStatus(this.status.ausleihen(person));
        this.status.statusBetreten();
        return this.status;
    }

    @Override
    public BuchStatus verloren(){
        this.status.statusVerlassen();
        setStatus(this.status.verloren());
        this.status.statusBetreten();
        return this.status;
    }

    @Override
    public BuchStatus aussondern(){
        this.status.statusVerlassen();
        setStatus(this.status.aussondern());
        this.status.statusBetreten();
        return this.status;
    }

    @Override
    public BuchStatus rueckgabe(){
        this.status.statusVerlassen();
        setStatus(this.status.rueckgabe());
        this.status.statusBetreten();
        return this.status;
    }

    @Override
    public BuchStatus abholzeitAbgelaufen() {
        this.status.statusVerlassen();
        setStatus(this.status.abholzeitAbgelaufen());
        this.status.statusBetreten();
        return this.status;
    }

    public boolean hatVorbestellungen() {
        return !this.vorbestellungen.isEmpty();
    }

    public Person vorbestellerEntfernen() {
        return vorbestellungen.poll();
    }

    public Person gibVorbesteller() {
        return this.vorbestellungen.peek();
    }
}