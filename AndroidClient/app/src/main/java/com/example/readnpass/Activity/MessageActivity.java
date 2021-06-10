package com.example.readnpass.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.readnpass.Adapter.MessageAdapter;
import com.example.readnpass.Messages.ChatMessage;
import com.example.readnpass.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MessageActivity extends AppCompatActivity
{
    ImageButton sendmassege;
    EditText editTextMassege;
    MessageAdapter messageAdapter;
    Context context = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        editTextMassege = findViewById(R.id.editTextMassege);
        sendmassege = findViewById(R.id.sendmassege);
        messageAdapter = new MessageAdapter(context);
        sendmassege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ChatMessage chatMessage = new ChatMessage(editTextMassege.getText().toString(),
                        FirebaseAuth.getInstance()
                                .getCurrentUser()
                                .getDisplayName(),true);
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(chatMessage);
                messageAdapter.add(chatMessage);
                // scroll the ListView to the last added element
               // messagesView.setSelection(messagesView.getCount() - 1);
            }
        });
    }
}
