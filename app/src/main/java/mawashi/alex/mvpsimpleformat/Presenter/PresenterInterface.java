package mawashi.alex.mvpsimpleformat.Presenter;

import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by alessandro.argentier on 15/09/2016.
 */
public interface PresenterInterface {


    public void add(EditText name, EditText number);
    public void get(EditText name, EditText number);


}
