package works.hop.dbdemo.grid.node;

import works.hop.dbdemo.grid.TableNode;

public class EmployeeNodes {

    public static class EmployeeNode<T> extends TableNode<T> {

        public EmployeeNode(String label) {
            setLabel(label);
            setSrcTable("employees");
        }
    }

    public static class EmployeeTable extends EmployeeNode<Void> {

        public EmployeeTable(String label) {
            super(label);
            setTable(true);
        }
    }

    public static class EmployeeId extends EmployeeNode<String> {

        public EmployeeId(String label) {
            super(label);
            setPk(true);
            setSrcColumn("employee_id");
        }
    }

    public static class EmployeeReportsTo extends EmployeeNode<String> {

        public EmployeeReportsTo(String label) {
            super(label);
            setFk(true);
            setSrcColumn("reports_to");
            setDestTable(getSrcTable());
            setDestColumn("employee_id");
        }
    }
}
