package mawashi.alex.mvpsimpleformat.Model;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alessandro.argentier on 15/09/2016.
 */
public class ModelDAO implements ModelDAOInterface{
    private String path;
    private final String TAG = "ModelDAO";

    //costruttori

    public ModelDAO(String path){
        this.path = path;
    }

    public ModelDAO(){}

    //////metodi
    //path = "/MVC_Example"

    public void addInFile(Model m, String path){

        this.path = path;
        File root_text = Environment.getExternalStorageDirectory();
        try{
            File folder = new File(Environment.getExternalStorageDirectory() + path);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdir();
            }
            BufferedWriter fwv = new BufferedWriter(new FileWriter(new File("/sdcard" + path +"/file_saved.txt"), false));
            if (root_text.canWrite()) {
                fwv.write(m.getName() + ":" + m.getNumber());
                fwv.close();
            }
        }catch (Exception e){
            Log.e(TAG, "ERROR: " + e.toString());
        }


    }

    public Model getFromFile(String path){
        this.path = path;
        Model m = new Model();

        File folder = new File(Environment.getExternalStorageDirectory() + path);

        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
        try{
            String str_file = readFileAsString("/sdcard" + path + "/file_saved.txt");
            if(str_file.equals("")){
                //FILE NON TROVATO O VUOTO
                m.setName("");
                m.setNumber("");
            }else{
                //ELABORA CONTENUTI FILE AD ES.
                String[] str_splitted = str_file.split(":");
                m.setName(str_splitted[0]);
                m.setNumber(str_splitted[1]);
            }
        }catch (Exception e){
            Log.e(TAG, "Error: " + e.toString());
        }

        return m;
    }

    public static String readFileAsString(String filePath) {
        String result = "";
        File file = new File(filePath);
        if (file.exists() ) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                char current;
                while (fis.available() > 0) {
                    current = (char) fis.read();
                    result = result + String.valueOf(current);
                }
            }catch (Exception e) {
                Log.d("ERRORE", e.toString());
            }finally {
                if (fis != null)
                    try {
                        fis.close();
                    } catch (IOException ignored) {}
            }
        }
        return result;
    }



}
