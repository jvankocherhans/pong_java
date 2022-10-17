package ch.lidl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Designpattern: Singleton
 */
public class SaveScoreFile {

    // Membervariablen
    private HashMap<String, Integer> playerScore = new HashMap<>();

    private static SaveScoreFile saveScoreFileInstance;

    /**
     * Konstruktor der SaveScoreFile-Klasse
     */
    private SaveScoreFile() {

    }

    /**
     * Gibt die Instanz der Klasse zurück, sofern sie vorhanden ist.
     * Erstellt sie, falls nicht.
     * @return SaveScoreFile
     */
    public static SaveScoreFile getSaveScoreFileInstance() {
        if(saveScoreFileInstance == null) {
           saveScoreFileInstance = new SaveScoreFile(); 
        }

        return saveScoreFileInstance;
    }

    /**
     * Neue Werte werden dem File hinzugefügt
     * @param playerName
     * @param score
     */
    public void addPlayerScore(String playerName, Integer score) {
        playerScore = getFileData();
        try {
            new FileInputStream("scoreBoard.dat").close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(playerScore.containsKey(playerName)) {
            if(playerScore.get(playerName) < score) {
                playerScore.replace(playerName, score);
            }
        } else if(!playerScore.containsKey(playerName)) {
            playerScore.putIfAbsent(playerName, score);
        }

        setFileData(playerScore);
    }

    /**
     * Die Werte werden aus dem File herausgelesen und zurückgeben
     * @return playerScoreCache
     */
    public HashMap<String, Integer> getFileData() {
        HashMap<String, Integer> playerScoreCache = new HashMap<>();

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("scoreBoard.dat"));
            playerScoreCache = (HashMap<String, Integer>) input.readObject();
        } catch (IOException e) {
            System.out.println(("Error reading file"));
        }
        catch (ClassNotFoundException e) {}
        return playerScoreCache;
    }

    /**
     * Neues File wird erstellt und Werte hinzugefügt
     * @param fileData
     */
    private void setFileData(HashMap<String, Integer> fileData) {
        try {
            ObjectOutputStream fileOutPut = new ObjectOutputStream(new FileOutputStream("scoreBoard.dat"));
            fileOutPut.writeObject(fileData);
            fileOutPut.close();
        } catch (IOException e) {
            System.err.println("Error saving to file");
        }
    }

    
}
