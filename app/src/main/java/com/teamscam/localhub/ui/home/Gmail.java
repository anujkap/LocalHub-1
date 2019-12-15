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

public class Gmail extends Fragment
{
    String to,sub,cont,uname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_gmail,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences prefs = getContext().getSharedPreferences("LocalHub10", MODE_PRIVATE);
        uname= prefs.getString("name","User");
        final EditText et1=view.findViewById(R.id.gmaET1);
        final EditText et2=view.findViewById(R.id.gmaET2);
        final EditText et3=view.findViewById(R.id.gmaET3);
        Button button=view.findViewById(R.id.gmaBTN);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                to=et1.getText().toString();
                sub=et2.getText().toString();
                cont=et3.getText().toString();
                sendSMS();
            }
        });

    }
    protected void sendSMS()
    {
        String toPhoneNumber = getString(R.string.phone_no);
        String id = getString(R.string.id);
        String smsMessage =id+" "+uname+" Mail\n{\"To\" : \""+to+"\",\"Subject\" : \""+sub+"\",\"Content\" : \""+cont+"\"}";
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
