package mawashi.alex.mvpsimpleformat.Model;

/**
 * Created by alessandro.argentier on 15/09/2016.
 */
public interface ModelDAOInterface {

    public void addInFile(Model m, String path);

    public Model getFromFile(String path);

}
