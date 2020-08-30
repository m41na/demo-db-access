package works.hop.db.access.entity;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("customer_demographics")
public class CustomerDemographic {

	private String customerTypeId;
	private String customerDesc;
}
