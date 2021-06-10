package com.example.readnpass.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.readnpass.Activity.MainActivity;
import com.example.readnpass.Activity.SendMessageListActivity;
import com.example.readnpass.Activity.UserInComeMessageActivity;
import com.example.readnpass.R;

public class MessageFragment extends Fragment {

    public MessageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        RelativeLayout sendmessage =view.findViewById(R.id.linlay1);
        RelativeLayout incomingmessages =view.findViewById(R.id.linlay2);

        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SendMessageListActivity.class);
                intent.putExtra("userId","287ec72b-05ac-4fcf-1c90-08d91304fd91");
                startActivity(intent);
            }
        });

        incomingmessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInComeMessageActivity.class);
                intent.putExtra("userId","287ec72b-05ac-4fcf-1c90-08d91304fd91");
                startActivity(intent);
            }
        });

        TextView txtemail =view.findViewById(R.id.txtemail);
        return view;
    }
}
