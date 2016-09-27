package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Konstante;
import model.Oblast;

public class Zadatak1KreiranjeTabela {

    public static void main(String[] args) throws Exception {

        ConnectionSource connectionSource = null;

        try {

            connectionSource = new JdbcConnectionSource(Konstante.DATABASE_URL);
            TableUtils.dropTable( connectionSource, Knjiga.class, true );
            TableUtils.dropTable( connectionSource, Oblast.class, true );
            TableUtils.createTable( connectionSource, Knjiga.class );
            TableUtils.createTable(  connectionSource, Oblast.class );

        } finally {
            if ( connectionSource != null )
                connectionSource.close();
        }

    }

}
