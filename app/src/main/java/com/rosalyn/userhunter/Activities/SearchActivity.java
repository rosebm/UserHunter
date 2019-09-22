package com.rosalyn.userhunter.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.rosalyn.userhunter.Adapter.UserRecyclerViewAdapter;
import com.rosalyn.userhunter.Interface.GetData;
import com.rosalyn.userhunter.Model.UserResponse;
import com.rosalyn.userhunter.Presenter.UserActivityPresenter;
import com.rosalyn.userhunter.R;
import com.rosalyn.userhunter.databinding.ActivitySearchBinding;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends Activity implements GetData {
    private ActivitySearchBinding searchBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        initUI();
    }

    /**
     * Initializes the UI
     */
    private void initUI(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        searchBinding.rvUsersList.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        //dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
        searchBinding.rvUsersList.addItemDecoration(dividerItemDecoration);

        UserActivityPresenter userActivityPresenter = new UserActivityPresenter();
        userActivityPresenter.getUser(new GetData() {
            @Override
            public void getData(@NonNull ArrayList<UserResponse> usersList) {
                searchBinding.rvUsersList.setAdapter(new UserRecyclerViewAdapter(SearchActivity.this, usersList));
            }
        });
    }

    //test
    private ArrayList<UserResponse> createDummyList(){
        final ArrayList<UserResponse> users = new ArrayList<>();

        users.add(new UserResponse("Rosalyn", "Blanco", "nine9.r@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        users.add(new UserResponse("Pedro", "Perez", "pedro@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        users.add(new UserResponse("Andrea", "Dossi", "ad@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        users.add(new UserResponse("Rosalyn 1", "Blanco", "nine9.r@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        users.add(new UserResponse("Pedro 1", "Perez", "pedro@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));
        users.add(new UserResponse("Andrea 1", "Dossi", "ad@gmail.com", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"));

        return users;
    }

    @Override
    public void getData(@NonNull ArrayList<UserResponse> usersList) {
        searchBinding.rvUsersList.setAdapter(new UserRecyclerViewAdapter(this, usersList));
    }
}
