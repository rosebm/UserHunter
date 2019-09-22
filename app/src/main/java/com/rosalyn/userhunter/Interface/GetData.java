package com.rosalyn.userhunter.Interface;

import com.rosalyn.userhunter.Model.UserResponse;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/**
 * Interface that receives data from API and send it to UI
 */
public interface GetData {
    void getData(@NonNull ArrayList<UserResponse> usersList);
}
