package works.hop.db.access.grid;

public class EmployeeNodes {

    public static class EmployeeNode<T extends Comparable<T>> extends TableNode<T> {

        public EmployeeNode() {
            setSrcTable("employees");
        }
    }

    public static class EmployeeId extends EmployeeNode<String> {

        public EmployeeId() {
            setPk(true);
            setSrcColumn("employee_id");
        }
    }
    
    public static class EmployeeReportsTo extends EmployeeNode<String> {

        public EmployeeReportsTo() {
            setFk(true);
            setSrcColumn("reports_to");
            setDestTable(getSrcTable());
            setDestColumn("employee_id");
        }
    }
}
