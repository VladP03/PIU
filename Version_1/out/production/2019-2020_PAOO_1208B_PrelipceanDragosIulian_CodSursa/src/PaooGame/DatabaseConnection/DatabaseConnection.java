package PaooGame.DatabaseConnection;
import PaooGame.RefLinks;
import PaooGame.States.SettingState;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class DatabaseConnection {
    public RefLinks refLink;
    private Connection c = null;
    private Statement stmt = null;

    private int id;
    private int level;
    private int diamondCollected;
    private String difficultyLevel;

    private LinkedList<Record> records = new LinkedList<Record>();



    public DatabaseConnection(RefLinks refLink) {
        this.refLink = refLink;
        //createDatabase();

    }

    public void createDatabase(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/PaooGame/DatabaseConnection/game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "CREATE TABLE Score" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    "level INT NOT NULL, " +
                    "diamondCollected INT NOT NULL, " +
                    "difficultyLevel CHAR(50) )";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.out.println("There was an error at creating database.");
        }
        finally {
            System.out.println("Table created succesfully");
        }
    }

    public void update(){
        //id = 3;
        level = refLink.GetGame().getPlayState().getIndex_level();
        diamondCollected = refLink.GetGame().getPlayState().GetHero().getNr_stone();
        difficultyLevel = refLink.GetGame().getPlayState().getDifficulty_level();
        System.out.println("id: " + id);
        System.out.println("level: " + level);
        System.out.println("diamondColl: " + diamondCollected);
        System.out.println("difficultylevel: " + difficultyLevel);
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/PaooGame/DatabaseConnection/game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
        //" + id + ", " +

            String sql = "INSERT INTO Score (level, diamondCollected, difficultyLevel) " +
                    "VALUES (" + level + ", " + diamondCollected + ", '" + difficultyLevel +  "')";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.out.println("There was an error at updating database.");
        }
        finally {
            System.out.println("Table updated succesfully.");
        }
    }

    public void showRecords(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/PaooGame/DatabaseConnection/game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "SELECT * FROM Score";
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while(rs.next()){
                id = rs.getInt("id");
                level = rs.getInt("level");
                diamondCollected = rs.getInt("diamondCollected");
                difficultyLevel = rs.getString("difficultyLevel");
                System.out.println(id + "\n" + level + "\n" + diamondCollected + "\n" + difficultyLevel + "\n" + "\n");

                records.add(new Record(id, level, diamondCollected, difficultyLevel));
            }

            rs.close();

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.out.println("There was an error at showing records.");
        }
        finally {
            System.out.println("Records shown succesfully.");
        }
    }

    public void deleteRecords(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/PaooGame/DatabaseConnection/game.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "DELETE FROM Score";

            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            records.removeAll(records);       //delete all
            //records.remove();

        } catch (Exception e) {
            System.out.println("There was an error at deleting record from database.");
        }
        finally {
            System.out.println("Table updated succesfully.");
        }
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

    public void setId(int id){
        this.id = id;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setDiamondCollected(int diamondCollected){
        this.diamondCollected = diamondCollected;
    }

    public void setDifficultyLevel(String difficultyLevel){
        this.difficultyLevel = difficultyLevel;
    }

    public LinkedList<Record> getRecords(){
        records = null;
        records = new LinkedList<Record>();
        showRecords();
        return records;
    }

}
