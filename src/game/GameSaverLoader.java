package game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

public class GameSaverLoader {
    /**
     * Saves a game to a file.
     * <p>
     * Saves the whole state.
     *
     * @param  level Level that I'm in
     * @param fileName Where it is saved
     * @return load and save a game file.
     */

    public static void save (GameLevel level, String fileName)
            throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getSoldier().getGainCount() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    public static GameLevel load(String fileName){
        return null;
}}
