package com.teamscam.localhub.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.teamscam.localhub.Adapters.MyRecyclerViewAdapter;
import com.teamscam.localhub.Adapters.MyUPIAdapter;
import com.teamscam.localhub.Adapters.UserTask;
import com.teamscam.localhub.MainActivity;
import com.teamscam.localhub.R;
import com.teamscam.localhub.ui.home.HomeFragment;
import com.teamscam.localhub.ui.home.TwitterFragment;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    final List<UserTask> homeTaskList=new ArrayList<>();
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserTask a=new UserTask("Send", R.drawable.ic_payment_send);
        UserTask b=new UserTask("Request",R.drawable.ic_cash_recieve);
        UserTask c=new UserTask("Balance",R.drawable.ic_check_bal);
        homeTaskList.add(a);
        homeTaskList.add(b);
        homeTaskList.add(c);
        final LinearLayout linearLayout=view.findViewById(R.id.upi_dash);
        final MyRecyclerViewAdapter adapter =new MyRecyclerViewAdapter(getContext(),R.layout.recylerview_row,homeTaskList);
        int k=adapter.getCount();
        for (int i = 0; i <k ; i++)
        {
            final int l = i;
            View item = adapter.getView(i, null, null);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView tv=view.findViewById(R.id.homeTextViewRecyclerView1);
                    String check=tv.getText().toString();
                    if(check.equalsIgnoreCase("Send"))
                    {
                        SendFragment fragment = new SendFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(check.equalsIgnoreCase("Request"))
                    {
                        RequestFragment fragment = new RequestFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    else if(check.equalsIgnoreCase("Balance"))
                    {
                        BalanceFragment fragment = new BalanceFragment();
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }

                }
            });
            linearLayout.addView(item);
        }

    }

}