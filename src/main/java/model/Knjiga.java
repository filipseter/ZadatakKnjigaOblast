package model;


import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

@DatabaseTable( tableName = "knjige" )
public class Knjiga {

    public static final String POLJE_NAZIV = "naslov";
    public static final String POLJE_BROJ_STRANA = "broj_strana";
    public static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja";

    @DatabaseField( generatedId = true )
    private int id;
    @DatabaseField( columnName = POLJE_NAZIV, canBeNull = false )
    private String naslov;
    @DatabaseField( columnName = POLJE_BROJ_STRANA, canBeNull = false )
    private int brojStrana;
    @DatabaseField( columnName = POLJE_DATUM_IZDAVANJA, canBeNull = false )
    private Date datumIzdanja;
    private boolean prisutna;
    @ForeignCollectionField( foreignFieldName = "knjiga" )
    ForeignCollection<Oblast> oblasti;

    //GETTERS
    public int getId() { return id; }
    public String getNaslov() { return naslov; }
    public int getBrojStrana() { return brojStrana; }
    public Date getDatumIzdanja() { return datumIzdanja; }
    public boolean isPrisutna() { return prisutna; }
    public ForeignCollection<Oblast> getOblasti() { return oblasti; }

    //SETTERS
    public void setNaslov( String naslov ) { this.naslov = naslov; }
    public void setBrojStrana( int brojStrana ) { this.brojStrana = brojStrana; }
    public void setDatumIzdanja( Date datumIzdanja ) { this.datumIzdanja = datumIzdanja; }
    public void setPrisutna( boolean prisutna ) { this.prisutna = prisutna; }

    //CONSTRUCT
    public Knjiga( ) { }
    public Knjiga( String naslov,
                   int brojStrana,
                   Date datumIzdanja,
                   boolean prisutna )
    {
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datumIzdanja = datumIzdanja;
        this.prisutna = prisutna;

    }

    //TO_STRING
    @Override
    public String toString() {
        return "Knjiga {" +
                " ID=" + id +
                ", NASLOV=" + naslov +
                ", BR_STR=" + brojStrana +
                ", DATUM=" + datumIzdanja +
                ", PRISUTNA=" + prisutna +
                " }";
    }

}
