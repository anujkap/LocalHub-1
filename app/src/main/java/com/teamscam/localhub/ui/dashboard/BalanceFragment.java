package com.teamscam.localhub.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.teamscam.localhub.MainActivity;
import com.teamscam.localhub.R;
import com.teamscam.localhub.ui.home.HomeFragment;

import java.util.Objects;

public class BalanceFragment extends Fragment {
    String msg,to,amt;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_balance,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button=view.findViewById(R.id.ReqBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                sendCall();
            }
        });
    }
    public void sendCall()
    {
        String ussd = "*99*3"+ Uri.encode("#");
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussd)));
    }

}
