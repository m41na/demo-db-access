package works.hop.db.metadata;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class PgDbConnector implements DbConnector {

    private static DbConnector connector;

    public final String DB_URL = "jdbc:postgresql://localhost/";
    public final String DB_USER = "postgres";
    public final String DB_PASS = "admins";
    public final String DB_DRIVER = "org.postgresql.Driver";
    public final String DB_SCHEMA = "public";
    private final DataSource dataSource = dataSource();

    private PgDbConnector() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static DbConnector instance() {
        if (connector == null) {
            connector = new PgDbConnector();
        }
        return connector;
    }

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASS);
        dataSource.setSchema(DB_SCHEMA);
        return dataSource;
    }

    @Override
    public void handle(BiConsumer<Connection, Throwable> consumer) {
        try(DbConnection connection = DbConnection.get(dataSource.getConnection())){
            consumer.accept(connection.connect(), null);
        } catch (SQLException e) {
            e.printStackTrace();
            consumer.accept(null, e);
        }
    }
}
