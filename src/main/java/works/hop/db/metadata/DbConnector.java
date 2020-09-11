package works.hop.db.metadata;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.BiConsumer;

public interface DbConnector {

    void handle(BiConsumer<Connection, Throwable> consumer);

    class DbConnection implements Closeable {

        final Connection connection;

        static DbConnection get(Connection conn){
            System.out.println("Connecting to database...");
            return new DbConnection(conn);
        }

        private DbConnection(Connection connection) {
            this.connection = connection;
        }

        Connection connect(){
            try {
                connection.setAutoCommit(false);
                return this.connection;
            } catch (SQLException e) {
                System.out.println("Could not connect to database...");
                e.printStackTrace();
                return null;
            }
        }

        void commit(){
            try {
                connection.commit();
            } catch (SQLException e) {
                System.out.println("Could not commit transaction...");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        void rollback(){
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println("Could not rollback transaction...");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        public void close() {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Could not close the connection...");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
