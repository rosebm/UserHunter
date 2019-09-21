package com.rosalyn.userhunter.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Class for Json response
 */
public class UserResponse {
    @SerializedName("avatar")
    private String photo_url;

    @SerializedName("firs_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("last_name")
    private String email;

    public UserResponse(String f, String l, String e, String p){//test
        this.email = e;
        this.first_name = f;
        this.last_name = l;
        this.photo_url = p;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
