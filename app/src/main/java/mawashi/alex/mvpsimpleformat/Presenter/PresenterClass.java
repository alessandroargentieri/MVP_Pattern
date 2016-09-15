package mawashi.alex.mvpsimpleformat.Presenter;

import android.widget.EditText;
import java.lang.ref.WeakReference;

import mawashi.alex.mvpsimpleformat.Model.Model;
import mawashi.alex.mvpsimpleformat.Model.ModelDAO;
import mawashi.alex.mvpsimpleformat.Model.ModelDAOInterface;

/**
 * Created by alessandro.argentier on 15/09/2016. MODIFIED
 */
public class PresenterClass implements PresenterInterface {

    private WeakReference<EditText> nameEditRef;
    private WeakReference<EditText> numberEditRef;
    ModelDAOInterface mDAO = new ModelDAO();

    public void add(EditText name, EditText number){
        //get the widgets passed, as WeakReferences
        nameEditRef = new WeakReference<EditText>(name);
        numberEditRef = new WeakReference<EditText>(number);

        //create locally widget from these references
        EditText nameEdit = nameEditRef.get();
        EditText numberEdit = numberEditRef.get();

        //get the contents
        String Name = nameEdit.getText().toString();
        String Number = numberEdit.getText().toString();

        //create new Model of data
        Model m = new Model(Name, Number);

        mDAO.addInFile(m, "/MVC_Example");
    }

    public void get(EditText name, EditText number){
        //get the widgets passed, as WeakReferences
        nameEditRef = new WeakReference<EditText>(name);
        numberEditRef = new WeakReference<EditText>(number);

        //create locally widget from these references
        EditText nameEdit = nameEditRef.get();
        EditText numberEdit = numberEditRef.get();

        Model m = mDAO.getFromFile("/MVC_Example");

        //view the contents
        nameEdit.setText(m.getName());
        numberEdit.setText(m.getNumber());
    }
}
