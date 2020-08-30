package works.hop.db.access.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("territories")
public class Territory {

	@Id
	private String territoryId;
	private String territoryDescription;
	private Long regionId;
}
