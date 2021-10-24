package PaooGame.DatabaseConnection;

public class Record {

    private final int id;
    private final int level;
    private final int diamondCollected;
    private final String difficultyLevel;

    public Record(int id, int level, int diamondCollected, String difficultyLevel){
        this.id = id;
        this.level = level;
        this.diamondCollected = diamondCollected;
        this.difficultyLevel = difficultyLevel;
    }

    public int getId(){
        return id;
    }

    public int getLevel(){
        return level;
    }

    public int getDiamondCollected(){
        return diamondCollected;
    }

    public String getDifficultyLevel(){
        return difficultyLevel;
    }


}
