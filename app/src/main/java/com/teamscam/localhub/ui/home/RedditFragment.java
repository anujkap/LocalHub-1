package com.teamscam.localhub.ui.home;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.teamscam.localhub.R;

import static android.content.Context.MODE_PRIVATE;

public class RedditFragment extends Fragment
{
    String title,subreddit,text,uname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_reddit,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final EditText et_sub=view.findViewById(R.id.redET1);
        final EditText et_title=view.findViewById(R.id.redET2);
        final EditText et_text=view.findViewById(R.id.redET3);
        SharedPreferences prefs = getContext().getSharedPreferences("LocalHub10", MODE_PRIVATE);
        uname= prefs.getString("name","User");
        Button button=view.findViewById(R.id.redBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subreddit=et_sub.getText().toString();
                title=et_title.getText().toString();
                text=et_text.getText().toString();
                sendSMS();
            }
        });

    }
    protected void sendSMS()
    {
        String toPhoneNumber = getString(R.string.phone_no);
        String id = getString(R.string.id);
        String smsMessage =id+" "+uname+" Reddit\n{\"Subreddit\" : \""+subreddit+"\",\"Title\" : \""+title+"\",\"Text\" : \""+text+"\" }";
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(toPhoneNumber, null, smsMessage, null, null);
            Toast.makeText(getContext(), "SMS sent.",Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(),"Sending SMS failed.",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}