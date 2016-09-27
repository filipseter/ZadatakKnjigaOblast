package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable( tableName = "oblast")
public class Oblast {

    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_POCENTA_STRANA = "pocetna_strana";

    @DatabaseField( generatedId = true )
    private int id;
    @DatabaseField( columnName = POLJE_NAZIV, canBeNull = false )
    private String naziv;
    @DatabaseField( columnName = POLJE_POCENTA_STRANA, canBeNull = false)
    private int pocetnaStrana;
    @DatabaseField( columnName = "knjiga", foreign = true )
    private Knjiga knjiga;

    //GETTERS
    public int getId() { return id; }
    public String getNaziv() { return naziv; }
    public int getPocetnaStrana() { return pocetnaStrana; }
    public Knjiga getKnjiga() { return knjiga; }

    //SETTERS
    public void setNaziv( String naziv ) { this.naziv = naziv; }
    public void setPocetnaStrana( int pocetnaStrana ) { this.pocetnaStrana = pocetnaStrana; }
    public void setKnjiga( Knjiga knjiga ) { this.knjiga = knjiga; }

    //CONSTRUCT
    public Oblast( ) { }
    public Oblast( String naziv,
                   int pocetnaStrana,
                   Knjiga knjiga )
    {
        this.naziv = naziv;
        this.pocetnaStrana = pocetnaStrana;
        this.knjiga = knjiga;
    }

    //TO_STRING
    @Override
    public String toString() {
        return "Oblast {" +
                " ID=" + id +
                ", NAZIV=" + naziv +
                ", P_STR=" + pocetnaStrana +
                " }";
    }
}
