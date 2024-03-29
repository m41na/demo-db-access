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
@Table("us_states")
public class StatesAbbr {

    @Id
    private Long stateId;
    private String stateName;
    private String stateAbbr;
    private String stateRegion;
}
