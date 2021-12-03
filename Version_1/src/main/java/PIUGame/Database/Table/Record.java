package PIUGame.Database.Table;

import PIUGame.States.Difficulty.LevelDifficulty;
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
    private LevelDifficulty levelDifficulty;
    private Double time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public void setLevelDifficulty(LevelDifficulty levelDifficulty) {
        this.levelDifficulty = levelDifficulty;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }
}
