package PIUGame;

import PIUGame.Database.Table.Record;
import PIUGame.Database.Table.RecordDAO;
import PIUGame.States.Difficulty.LevelDifficulty;

public class Main {
    public static void main(String [] args){
        RecordDAO recordDAO = new RecordDAO();

        recordDAO.startSession();

//        Record record = Record.builder()
//                .levelDifficulty(LevelDifficulty.EASY)
//                .name("Iuli")
//                .time(30.50)
//                .build();
//        recordDAO.saveRecord(record);
//        Record record2 = Record.builder()
//                .levelDifficulty(LevelDifficulty.HARD)
//                .name("Razvan")
//                .time(150.50)
//                .build();
//        recordDAO.saveRecord(record2);
//        Record record3 = Record.builder()
//                .levelDifficulty(LevelDifficulty.MEDIUM)
//                .name("Silviu")
//                .time(40.50)
//                .build();
//        recordDAO.saveRecord(record3);


        createGame game1 = createGame.getInstance();
        game1.startGame();
        createGame.reset();
    }
}
