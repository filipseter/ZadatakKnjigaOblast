package zadaci;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Knjiga;
import model.Konstante;
import model.Oblast;

import java.util.Date;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {

    public static Dao<Knjiga, Integer> knjigaDao;
    public static Dao<Oblast, Integer> oblastDao;

    public static void main(String[] args) throws Exception {

        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            knjigaDao = DaoManager.createDao( connectionSource, Knjiga.class );
            oblastDao = DaoManager.createDao( connectionSource, Oblast.class );

            Knjiga knjiga1, knjiga2;
            Oblast oblast;
            knjiga1 = new Knjiga( "Java programiranje", 650, new Date(), false );
            knjigaDao.create( knjiga1 );
            knjiga2 = new Knjiga( "Android programiranje", 500, new Date(), true );
            knjigaDao.create( knjiga2 );

            //PRIKAZ SVIH KNJIGA
            List<Knjiga> listaKnjiga;
            listaKnjiga = knjigaDao.queryForAll();
            printBreak();
            for (Knjiga k : listaKnjiga )
                System.out.println( k );
            printBreak();

            oblast = new Oblast( "Uvod", 2, knjiga1 );
            oblastDao.create( oblast );
            oblast = new Oblast( "Naredbe", 10, knjiga1 );
            oblastDao.create( oblast );
            oblast = new Oblast( "Aritmeticki operatori", 20, knjiga1 );
            oblastDao. create( oblast );
            oblast = new Oblast( "Android operativni sistem", 2, knjiga2 );
            oblastDao.create( oblast );
            oblast = new Oblast( "Activity klasa", 30, knjiga2 );
            oblastDao. create( oblast );

            //PRIKAZ SVIH OBLASTI
            List<Oblast> listaOblasti;
            listaOblasti = oblastDao.queryForAll();
            printBreak();
            for (Oblast k : listaOblasti )
                System.out.println( k );
            printBreak();






        } finally {
            if ( connectionSource != null )
                connectionSource.close();
        }

    }

    public static void printBreak() {
        System.out.println("------------------------------------------------------------------------------------");
    }

}
