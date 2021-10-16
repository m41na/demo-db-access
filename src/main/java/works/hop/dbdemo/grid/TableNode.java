package works.hop.dbdemo.grid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TableNode<T> {

    private NodeValue<T> value;
    private String label;
    private String srcTable;
    private String srcColumn;
    private String destTable;
    private String destColumn;
    private String selectQuery;
    private boolean isPk;
    private boolean isFk;
    private boolean isUnique;
    private boolean isTable;

    public TableNode(String label, String tableName){
        this.srcTable = tableName;
        this.label = label;
    }

    public static <V>TableNode<V> tableNode(String label, String tableName){
        TableNode<V> tableNode = new TableNode<>(label, tableName);
        tableNode.setTable(true);
        return tableNode;
    }

    public static <V>TableNode<V> pkIdNode(String label, String tableName, String srcColumn){
        TableNode<V> pkIdNode = new TableNode<>(label, tableName);
        pkIdNode.setPk(true);
        pkIdNode.setSrcColumn(srcColumn);
        return pkIdNode;
    }

    public static <V>TableNode<V> fkIdNode(String label, String tableName, String srcColumn, String destTable, String destColumn){
        TableNode<V> fkIdNode = new TableNode<>(label, tableName);
        fkIdNode.setFk(true);
        fkIdNode.setSrcColumn(srcColumn);
        fkIdNode.setDestTable(destTable);
        fkIdNode.setDestColumn(destColumn);
        return fkIdNode;
    }
}
