package works.hop.db.access.grid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {

	private String label;
	private String srcTable;
	private String destTable;
	private String dbQuery;
	private Boolean isPk;
	private Boolean isFk;
	private Boolean isUnique;
}
