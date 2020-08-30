package works.hop.db.access.grid;

public class EmployeeTerritoryNodes {

    public static class EmployeeTerritoryDemographicNode<T extends Comparable<T>> extends TableNode<T> {

        public EmployeeTerritoryDemographicNode() {
            setSrcTable("employee_territories");
        }
    }

    public static class EmployeeId extends EmployeeTerritoryDemographicNode<String> {

        public EmployeeId() {
            setPk(true);
            setSrcColumn("employee_id");
        }
    }

    public static class TerritoryId extends EmployeeTerritoryDemographicNode<String> {

        public TerritoryId() {
        	setPk(true);
        	setSrcColumn("territory_id");
        }
    }

    public static class EmployeeIdFk extends EmployeeTerritoryDemographicNode<String> {

        public EmployeeIdFk() {
            setFk(true);
            setSrcColumn("employee_id");
            setDestTable("employees");
            setDestColumn(getSrcColumn());
        }
    }

    public static class TerritoryIdFk extends EmployeeTerritoryDemographicNode<String> {

        public TerritoryIdFk() {
            setFk(true);
            setSrcColumn("territory_id");
            setDestTable("territories");
            setDestColumn(getSrcColumn());
        }
    }
}
