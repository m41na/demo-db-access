package works.hop.dbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("order_details")
public class OrderDetail {

    private Long orderId;
    private Long productId;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal discount;
}
