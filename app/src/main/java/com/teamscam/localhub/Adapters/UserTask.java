package com.teamscam.localhub.Adapters;

public class UserTask
{
    String HomeTitle;
    int HomeImageId;

    public UserTask(String Title, int homeImageId)
    {
        HomeTitle = Title;
        HomeImageId=homeImageId;
    }
    public int getItemId(){
        return HomeImageId;
    }
}
