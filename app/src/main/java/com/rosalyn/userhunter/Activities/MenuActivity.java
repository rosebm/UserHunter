package com.rosalyn.userhunter.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.rosalyn.userhunter.R;
import com.rosalyn.userhunter.databinding.ActivityMenuBinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class MenuActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMenuBinding menuBinding = DataBindingUtil.setContentView(this, R.layout.activity_menu);

        menuBinding.btnSearch.setOnClickListener(this);
        menuBinding.btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_search:
                callSearchScreen();
                break;
            case R.id.btn_add:
                callAddScreen();
                break;
        }
    }

    /**
     * Calls the Search activity
     */
    private void callSearchScreen(){
    }

    /**
     * Calls the AddUser activity
     */
    private void callAddScreen(){
    }
}
