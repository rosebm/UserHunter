package com.rosalyn.userhunter.Interface;

import com.rosalyn.userhunter.Model.NewUserResponse;

/**
 * Interface that receives data from API
 */
public interface SentData {
    void onSuccessful(NewUserResponse newUserResponse);
}
