package PIUGame;

import PIUGame.Database.Table.Record;
import PIUGame.Database.Table.RecordDAO;
import PIUGame.States.Difficulty.Difficulty;

public class main {
    public static void main(String [] args){
        RecordDAO recordDAO = new RecordDAO();
        //recordDAO.startSession();

//        Record record = Record.builder()
//                .difficulty(Difficulty.EASY)
//                .name("Iuli")
//                .time(150.50)
//                .build();
//        recordDAO.saveRecord(record);
//        Record record2 = Record.builder()
//                .difficulty(Difficulty.HARD)
//                .name("Razvan")
//                .time(90.50)
//                .build();
//        recordDAO.saveRecord(record2);
//        Record record3 = Record.builder()
//                .difficulty(Difficulty.MEDIUM)
//                .name("Silviu")
//                .time(90.50)
//                .build();
//        recordDAO.saveRecord(record3);


        createGame game1 = createGame.getInstance();
        game1.startGame();
        createGame.reset();
    }
}
