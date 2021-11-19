package PIUGame.Database.Table;

import PIUGame.States.Difficulty.Difficulty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Difficulty difficulty;
    private Double time;
}
