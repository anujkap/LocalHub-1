package com.teamscam.localhub.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.teamscam.localhub.Adapters.MyRecyclerViewAdapter;
import com.teamscam.localhub.Adapters.UserTask;
import com.teamscam.localhub.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {

    final List<UserTask> homeTaskList=new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home,container,false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView username=view.findViewById(R.id.username);
        SharedPreferences prefs = this.getActivity().getSharedPreferences("LocalHub10", MODE_PRIVATE);
        String uname= prefs.getString("name","User");
        username.setText(uname);

        final LinearLayout linearLayout=view.findViewById(R.id.upi_dash);
        linearLayout.removeAllViews();
        UserTask a=new UserTask("Facebook",R.drawable.ic_facebook);
        UserTask b=new UserTask("Twitter",R.drawable.ic_twitter);
        UserTask c=new UserTask("Gmail",R.drawable.ic_gmail);
        //UserTask d=new UserTask("Uber",R.drawable.ic_uber);
        //UserTask e=new UserTask("Paytm",R.drawable.ic_paytm);
        UserTask g = new UserTask("Reddit", R.drawable.reddit);
        homeTaskList.add(a);
        homeTaskList.add(b);
        homeTaskList.add(c);
        homeTaskList.add(g);


        final MyRecyclerViewAdapter adapter =new MyRecyclerViewAdapter(getActivity().getApplicationContext(),R.layout.recylerview_row,homeTaskList);
        int k=adapter.getCount();

        for (int i = 0; i <4; i++)
        {
            if(i==0)
            {
                linearLayout.removeAllViews();
            }
            final int l=i;
            View item=adapter.getView(i,null,null);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    TextView tv=view.findViewById(R.id.homeTextViewRecyclerView1);
                    String check=tv.getText().toString();
                    if(check.equalsIgnoreCase("Facebook")) {
                        FacebookFragment facebookFragment = new FacebookFragment();
                        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, facebookFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                    }
                    else if(check.equalsIgnoreCase("Twitter"))
                    {
                        TwitterFragment fragment = new TwitterFragment();
                        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(check.equalsIgnoreCase("Gmail"))
                    {
                        Gmail fragment = new Gmail();
                        FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(check.equalsIgnoreCase("Reddit")){
                        RedditFragment fragment = new RedditFragment();
                        Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(null).commit();
                    }
                    /*
                    else if(check.equalsIgnoreCase("Paytm"))
                    {

                    }
                    else if(check.equalsIgnoreCase("Uber"))
                    {

                    }
                     */
                }
            });
            linearLayout.addView(item);
        }

    }


}