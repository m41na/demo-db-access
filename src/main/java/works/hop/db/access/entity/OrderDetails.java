package works.hop.db.access.entity;

import java.math.BigDecimal;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("order_details")
public class OrderDetails {

	private Long orderId;
	private Long productId;
	private BigDecimal unitPrice;
	private int quantity;
	private BigDecimal discount;
}
