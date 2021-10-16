package works.hop.dbdemo.metadata;

import works.hop.dbdemo.grid.TableNode;
import works.hop.dbdemo.grid.relation.Graphs;
import works.hop.dbdemo.grid.relation.NodeEdge;
import works.hop.dbdemo.grid.relation.TableNodes;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SchemaInfo {

    public static final String SCHEMA_TABLE = "TABLE";
    //public static final String SYSTEM_TABLE = "SYSTEM TABLE";

    public static void main(String[] args) {
        //printSchemaInfo();
        extractSchemaInfo();
        TableNodes nodes = new TableNodes();
        Graphs.printGraph(nodes);
    }

    public static void printSchemaInfo(){
        SchemaInfo schemaInfo = new SchemaInfo();
        DbConnector connector = PgDbConnector.instance();
        connector.handle((connection, th) -> {
            if (connection != null) {
                try {
                    schemaInfo.printTableInfo(connection, SCHEMA_TABLE);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.err.println(th.getMessage());
            }
        });
    }

    public void printTableInfo(Connection connection, String tableType) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{tableType});
        System.out.println("Printing TABLE_TYPE \"" + tableType + "\" ");
        System.out.println("----------------------------------");
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println(tableName);
            printColumnInfo(databaseMetaData, tableName);
        }
    }

    public void printColumnInfo(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);
        while (columns.next()) {
            String columnName = columns.getString("COLUMN_NAME");
            String dataType = columns.getString("DATA_TYPE");
            String columnSize = columns.getString("COLUMN_SIZE");
            String decimalDigits = columns.getString("DECIMAL_DIGITS");
            String isNullable = columns.getString("IS_NULLABLE");
            String is_autoIncrement = columns.getString("IS_AUTOINCREMENT");
            //Printing results
            System.out.printf("%s --- dataType: %s, columnSize: %s, decimalDigits: %s, isNullable: %s, isAutoIncrement: %s%n", columnName, dataType, columnSize, decimalDigits, isNullable, is_autoIncrement);
        }
        printPKColumnInfo(databaseMetaData, tableName);
        printFKColumnInfo(databaseMetaData, tableName);
    }

    public void printPKColumnInfo(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        ResultSet PK = databaseMetaData.getPrimaryKeys(null, null, tableName);
        System.out.println("------------PRIMARY KEYS-------------");
        while (PK.next()) {
            System.out.printf("%s --- name: %s%n", PK.getString("COLUMN_NAME"), PK.getString("PK_NAME"));
        }
    }

    public void printFKColumnInfo(DatabaseMetaData databaseMetaData, String tableName) throws SQLException {
        ResultSet FK = databaseMetaData.getImportedKeys(null, null, tableName);
        System.out.println("------------FOREIGN KEYS-------------");
        while (FK.next()) {
            System.out.printf("%s --- name: %s, fkTable: %s, fkColumn: %s%n", FK.getString("PKTABLE_NAME"), FK.getString("PKCOLUMN_NAME"), FK.getString("FKTABLE_NAME"),  FK.getString("FKCOLUMN_NAME"));
        }
    }

    public static void extractSchemaInfo(){
        SchemaInfo schemaInfo = new SchemaInfo();
        DbConnector connector = PgDbConnector.instance();
        connector.handle((connection, th) -> {
            if (connection != null) {
                try {
                    schemaInfo.extractTableInfo(connection, SCHEMA_TABLE);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.err.println(th.getMessage());
            }
        });
    }

    public void extractTableInfo(Connection connection, String tableType) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{tableType});
        List<String> targetTables = Arrays.asList("categories", "customer_customer_demo", "customer_demographics",
                "us_states", "territories", "suppliers", "shippers", "region", "products", "orders", "order_details",
                "employees", "employee_territories", "customers");
        //add nodes
        Map<String, TableNode<?>> nodes = new HashMap<>();
        //add associations
        Map<String, Set<NodeEdge>> adjacencyList = new HashMap<>();
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            if(targetTables.contains(tableName)) {
                System.out.println("------------TABLE NAME-------------");
                System.out.println(tableName);
                TableNode<Void> tableNode = TableNode.tableNode(tableName, tableName);
                nodes.putIfAbsent(tableName, tableNode);
                //add empty neighbours
                adjacencyList.put(tableName, new TreeSet<>());
                //extract pk column info
                ResultSet PK = databaseMetaData.getPrimaryKeys(null, null, tableName);
                System.out.println("------------PRIMARY KEYS-------------");
                while (PK.next()) {
                    String pkName = PK.getString("PK_NAME");
                    String pkColumn = PK.getString("COLUMN_NAME");
                    System.out.printf("%s --- name: %s%n", pkColumn, pkName);
                    String pkLabel = tableName + ":" + pkColumn;
                    TableNode<String> pkIdNode = TableNode.pkIdNode(pkLabel, tableName, pkColumn);
                    nodes.put(pkLabel, pkIdNode);
                    adjacencyList.get(tableName).add(new NodeEdge(tableName, pkLabel));
                }
                //extract fk column info
                ResultSet FK = databaseMetaData.getImportedKeys(null, null, tableName);
                System.out.println("------------FOREIGN KEYS-------------");
                while (FK.next()) {
                    String pkTableName = FK.getString("PKTABLE_NAME");
                    String pkColumnName = FK.getString("PKCOLUMN_NAME");
                    String fkTableName = FK.getString("FKTABLE_NAME");
                    String fkColumnName = FK.getString("FKCOLUMN_NAME");
                    System.out.printf("%s --- name: %s, fkTable: %s, fkColumn: %s%n", pkTableName, pkColumnName, fkTableName, fkColumnName);
                    String pkLabel = pkTableName + ":" + pkColumnName;
                    String fkLabel = fkTableName + ":" + fkColumnName + "_fk";
                    TableNode<String> fkIdNode = TableNode.fkIdNode(fkLabel, tableName, fkColumnName, pkTableName, pkColumnName);
                    nodes.put(fkLabel, fkIdNode);
                    adjacencyList.get(tableName).add(new NodeEdge(tableName, fkLabel));
                    //add empty neighbours
                    adjacencyList.putIfAbsent(fkLabel, new TreeSet<>());
                    //add to neighbours
                    adjacencyList.get(fkLabel).add(new NodeEdge(fkLabel, pkLabel));
                }
            }
        }

        //create table nodes
        TableNodes tableNodes = TableNodes.builder().nodes(nodes).adjacencyList(adjacencyList).build();
        Graphs.printGraph(tableNodes);
    }
}
