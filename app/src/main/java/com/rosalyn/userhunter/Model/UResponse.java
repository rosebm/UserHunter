package com.rosalyn.userhunter.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("per_page")
    private short per_page;

    @SerializedName("total")
    private short total;

    @SerializedName("total_pages")
    private short total_pages;

    @SerializedName("data")
    private ArrayList<UserResponse> data;



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public short getPer_page() {
        return per_page;
    }

    public void setPer_page(short per_page) {
        this.per_page = per_page;
    }

    public short getTotal() {
        return total;
    }

    public void setTotal(short total) {
        this.total = total;
    }

    public short getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(short total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<UserResponse> getData() {
        return data;
    }

    public void setData(ArrayList<UserResponse> data) {
        this.data = data;
    }


}
