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
@Table("products")
public class Product {

	@Id
	private Long productId;
	private String productName;
	private Long supplierId;
	private Long categoryId;
	private String quantityPerUnit;
	private Float unitPrice;
	private Long unitsInStock;
	private Long unitsOnOrder;
	private Long reorderLevel;
	private Long discontinued;
}
