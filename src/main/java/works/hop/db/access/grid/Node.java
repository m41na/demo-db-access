package works.hop.db.access.grid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node<T extends Comparable<T>> {

	private T value;
	private String label;
	private String srcTable;
	private String destTable;
	private String columnName;
	private String selectQuery;
	private boolean isPk;
	private boolean isFk;
	private boolean isUnique;
}
