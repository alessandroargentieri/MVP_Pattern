package mawashi.alex.mvpsimpleformat.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import mawashi.alex.mvpsimpleformat.Presenter.PresenterClass;
import mawashi.alex.mvpsimpleformat.Presenter.PresenterInterface;
import mawashi.alex.mvpsimpleformat.R;

public class ViewActivity extends AppCompatActivity implements ViewInterface {

    EditText nameEdit, numberEdit;

    //PresenterClass mPresenter;
    PresenterInterface mPresenter = new PresenterClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        nameEdit = (EditText)findViewById(R.id.editName);
        numberEdit = (EditText)findViewById(R.id.editNumber);

    }

    public void Add(View v){
        mPresenter.add(nameEdit, numberEdit);
    }

    public void Get(View v){
        mPresenter.get(nameEdit, numberEdit);
    }
}
