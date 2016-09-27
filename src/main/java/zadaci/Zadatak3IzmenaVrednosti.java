package zadaci;


import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import model.Knjiga;
import model.Konstante;
import model.Oblast;

import java.util.List;

public class Zadatak3IzmenaVrednosti {

    public static Dao<Knjiga, Integer> knjigaDao;
    public static Dao<Oblast, Integer> oblastDao;

    public static void main(String[] args) throws Exception {

        ConnectionSource connectionSource = null;

        try {
            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            knjigaDao = DaoManager.createDao( connectionSource, Knjiga.class );
            oblastDao = DaoManager.createDao( connectionSource, Oblast.class );

            List<Oblast> oblastList = oblastDao.queryForEq(Oblast.POLJE_NAZIV, "Activity klasa");
            for ( Oblast o : oblastList ) {
                o.setPocetnaStrana(35);
                oblastDao.update( o );
                System.out.println( o );
            }



        } finally {
            if ( connectionSource != null )
                connectionSource.close();
        }

    }


}
