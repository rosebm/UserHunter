package com.rosalyn.userhunter.Presenter;

import com.rosalyn.userhunter.Interface.GetData;
import com.rosalyn.userhunter.Model.UserResponse;
import com.rosalyn.userhunter.rest_client.ServerRequest;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class UserActivityPresenter {

    public void getUser(final GetData callback){

        ServerRequest.getUsers(new GetData() {
            @Override
            public void getData(@NonNull ArrayList<UserResponse> usersList) {
                callback.getData(usersList);
            }
        });
    }

    public void AddNewUser(String name, String job){
    }

}
