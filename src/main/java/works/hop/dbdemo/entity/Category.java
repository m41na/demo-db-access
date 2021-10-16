package works.hop.dbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("categories")
public class Category {

    @Id
    private Long categoryId;        //pk
    private String categoryName;
    private String description;
    private byte[] picture;
}
