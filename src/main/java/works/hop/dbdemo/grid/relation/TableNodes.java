package works.hop.dbdemo.grid.relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import works.hop.dbdemo.grid.TableNode;
import works.hop.dbdemo.grid.node.*;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class TableNodes {

    private Map<String, TableNode<?>> nodes;
    private Map<String, Set<NodeEdge>> adjacencyList;

    public TableNodes() {
        initializeGraph();
    }

    public void initializeGraph(){
        nodes = new HashMap<>();
        nodes.put("A", new CategoryNodes.CategoryTable("A"));
        nodes.put("B", new CategoryNodes.CategoryId("B"));
        nodes.put("C", new CustomerDemographicNodes.CustomerDemographicTable("C"));
        nodes.put("D", new CustomerDemographicNodes.CustomerId("D"));
        nodes.put("X", new CustomerDemographicNodes.CustomerTypeId("X"));
        nodes.put("E", new CustomerDemographicNodes.CustomerIdFk("E"));
        nodes.put("F", new CustomerDemographicNodes.CustomerTypeIdFk("F"));
        nodes.put("G", new CustomerNodes.CustomerTable("G"));
        nodes.put("H", new CustomerNodes.CustomerId("H"));
        nodes.put("I", new DemographicNodes.DemographicTable("I"));
        nodes.put("J", new DemographicNodes.CustomerTypeId("J"));
        nodes.put("K", new EmployeeNodes.EmployeeTable("K"));
        nodes.put("L", new EmployeeNodes.EmployeeId("L"));
        nodes.put("M", new EmployeeNodes.EmployeeReportsTo("M"));
        nodes.put("N", new EmployeeTerritoryNodes.EmployeeTerritoryTable("N"));
        nodes.put("O", new EmployeeTerritoryNodes.EmployeeId("O"));
        nodes.put("P", new EmployeeTerritoryNodes.TerritoryId("P"));
        nodes.put("Q", new EmployeeTerritoryNodes.EmployeeIdFk("Q"));
        nodes.put("R", new EmployeeTerritoryNodes.TerritoryIdFk("R"));
        nodes.put("S", new OrderDetailNodes.OrderDetailTable("S"));
        nodes.put("T", new OrderDetailNodes.OrderDetailId("T"));
        nodes.put("U", new OrderDetailNodes.OrderDetailProductId("U"));
        nodes.put("V", new OrderDetailNodes.OrderDetailIdFk("V"));
        nodes.put("W", new OrderDetailNodes.OrderDetailProductIdFk("W"));
        nodes.put("Y", new OrderNodes.OrderTable("Y"));
        nodes.put("Z", new OrderNodes.OrderId("Z"));
        nodes.put("A1", new OrderNodes.OrderCustomerIdFk("A1"));
        nodes.put("B1", new OrderNodes.OrderEmployeeIdFk("B1"));
        nodes.put("C1", new OrderNodes.OrderShipViaFk("C1"));
        nodes.put("D1", new ProductNodes.ProductTable("D1"));
        nodes.put("E1", new ProductNodes.ProductId("E1"));
        nodes.put("F1", new ProductNodes.ProductCategoryIdFk("F1"));
        nodes.put("G1", new ProductNodes.ProductSupplierIdFk("G1"));
        nodes.put("H1", new RegionNodes.RegionTable("H1"));
        nodes.put("I1", new RegionNodes.RegionId("I1"));
        nodes.put("J1", new ShipperNodes.ShipperTable("J1"));
        nodes.put("K1", new ShipperNodes.ShipperId("K1"));
        nodes.put("L1", new StateAbbrNodes.StateAbbrTable("L1"));
        nodes.put("M1", new StateAbbrNodes.StateAbbrId("M1"));
        nodes.put("N1", new SupplierNodes.SupplierTable("N1"));
        nodes.put("O1", new SupplierNodes.SupplierId("O1"));
        nodes.put("P1", new TerritoryNodes.TerritoryTable("P1"));
        nodes.put("Q1", new TerritoryNodes.TerritoryId("Q1"));
        nodes.put("R1", new TerritoryNodes.TerritoryRegionIdFk("R1"));
        initializeEdges();
    }

    public void initializeEdges() {
        adjacencyList = new HashMap<>();
        addEdge("A", "B");
        addEdge("C", "D");
        addEdge("C", "E");
        addEdge("C", "F");
        addEdge("C", "X");
        addEdge("G", "H");
        addEdge("I", "J");
        addEdge("K", "L");
        addEdge("K", "M");
        addEdge("N", "O");
        addEdge("N", "P");
        addEdge("N", "Q");
        addEdge("N", "R");
        addEdge("S", "T");
        addEdge("S", "U");
        addEdge("S", "V");
        addEdge("S", "W");
        addEdge("Y", "Z");
        addEdge("Y", "A1");
        addEdge("Y", "B1");
        addEdge("Y", "C1");
        addEdge("D1", "E1");
        addEdge("D1", "F1");
        addEdge("D1", "G1");
        addEdge("H1", "I1");
        addEdge("J1", "K1");
        addEdge("L1", "M1");
        addEdge("N1", "O1");
        addEdge("P1", "Q1");
        addEdge("P1", "R1");
        addEdge("E", "G");
        addEdge("F", "I");
        addEdge("M", "K");
        addEdge("Q", "K");
        addEdge("R", "P1");
        addEdge("V", "Y");
        addEdge("W", "D1");
        addEdge("A1", "G");
        addEdge("B1", "K");
        addEdge("C1", "J1");
        addEdge("F1", "A");
        addEdge("G1", "N1");
        addEdge("R1", "H1");
    }

    public void addEdge(String src, String dest) {
        if (!adjacencyList.containsKey(src)) {
            Set<NodeEdge> neighbours = new TreeSet<>();
            neighbours.add(new NodeEdge(src, dest));
            adjacencyList.put(src, neighbours);
        } else if (adjacencyList.get(src).stream().noneMatch(edge -> edge.getDest().equals(dest))) {
            adjacencyList.get(src).add(new NodeEdge(src, dest));
        } else {
            System.out.printf("Edge with src {%s} and dest {%s} already exists%n", src, dest);
        }
    }

    public List<String> vertices(){
        return new ArrayList<>(nodes.keySet());
    }

    public List<NodeEdge> neighbours(String label) {
        if (adjacencyList.containsKey(label)) {
            return adjacencyList.get(label).stream().map(edge -> new NodeEdge(edge.getSrc(), edge.getDest(), edge.getWeight())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public List<NodeEdge> inbound(String label) {
        return adjacencyList.values().stream()
                .flatMap(set -> set.stream()
                        .filter(edge -> edge.getDest().equals(label))
                        .map(edge -> new NodeEdge(edge.getSrc(), edge.getDest(), edge.getWeight())))
                .collect(Collectors.toList());
    }

    public List<NodeEdge> outbound(String label) {
        return adjacencyList.values().stream()
                .flatMap(set -> set.stream()
                        .filter(edge -> edge.getSrc().equals(label))
                        .map(edge -> new NodeEdge(edge.getSrc(), edge.getDest(), edge.getWeight())))
                .collect(Collectors.toList());
    }
}
