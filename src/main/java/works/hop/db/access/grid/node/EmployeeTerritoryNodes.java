package works.hop.db.access.grid.node;

import works.hop.db.access.grid.TableNode;

public class EmployeeTerritoryNodes {

    public static class EmployeeTerritoryNode<T> extends TableNode<T> {

        public EmployeeTerritoryNode(String label) {
            setLabel(label);
            setSrcTable("employee_territories");
        }
    }

    public static class EmployeeTerritoryTable extends EmployeeTerritoryNode<Void> {

        public EmployeeTerritoryTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class EmployeeId extends EmployeeTerritoryNode<String> {

        public EmployeeId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("employee_id");
        }
    }

    public static class TerritoryId extends EmployeeTerritoryNode<String> {

        public TerritoryId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("territory_id");
        }
    }

    public static class EmployeeIdFk extends EmployeeTerritoryNode<String> {

        public EmployeeIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("employee_id");
            setDestTable("employees");
            setDestColumn(getSrcColumn());
        }
    }

    public static class TerritoryIdFk extends EmployeeTerritoryNode<String> {

        public TerritoryIdFk(String label) {
            super(label);
            setFk(true);
            setSrcColumn("territory_id");
            setDestTable("territories");
            setDestColumn(getSrcColumn());
        }
    }
}
