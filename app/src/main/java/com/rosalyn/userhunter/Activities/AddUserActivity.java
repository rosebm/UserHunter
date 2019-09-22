package com.rosalyn.userhunter.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rosalyn.userhunter.Presenter.UserActivityPresenter;
import com.rosalyn.userhunter.R;
import com.rosalyn.userhunter.databinding.ActivityAddUserBinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class AddUserActivity extends Activity {
    private ActivityAddUserBinding activityAddUserBinding;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        activityAddUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_user);
        initializeListeners();
    }

    private void initializeListeners(){
        activityAddUserBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = activityAddUserBinding.tilName.getEditText().getText().toString();
                String job = activityAddUserBinding.tilJob.getEditText().getText().toString();

                //Toast.makeText(context, name + " " + job, Toast.LENGTH_SHORT).show();
                addNewUser(name, job);
            }
        });
    }

    private void addNewUser(String name, String job){
        UserActivityPresenter userActivityPresenter = new UserActivityPresenter();

    }
}
