package com.rosalyn.userhunter.Presenter;

import com.rosalyn.userhunter.Interface.GetData;
import com.rosalyn.userhunter.Interface.SentData;
import com.rosalyn.userhunter.Model.NewUserResponse;
import com.rosalyn.userhunter.Model.UserResponse;
import com.rosalyn.userhunter.rest_client.ServerRequest;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * Presenter for all activities related to users
 */
public class UserActivityPresenter {

    /**
     * Calls the server to fetch the users list
     * @param callback with the data received
     */
    public void getUser(final GetData callback){

        ServerRequest.getUsers(new GetData() {
            @Override
            public void getData(@NonNull ArrayList<UserResponse> usersList) {
                callback.getData(usersList);
            }
        });
    }

    /**
     * Calls the server to insert a new user
     *
     * @param name user name
     * @param job user job
     * @param callback with the response received
     */
    public void AddNewUser(String name, String job, final SentData callback){
        ServerRequest.addNewUser(new SentData() {
            @Override
            public void onSuccessful(NewUserResponse newUserResponse) {
                callback.onSuccessful(newUserResponse);
            }
        });
    }

}
