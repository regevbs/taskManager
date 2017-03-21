package com.example.regev.selfchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class DisplayMessageActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    //private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
   // private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<Mission> missionsForLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        missionsForLife =(ArrayList<Mission>) intent.getSerializableExtra(EXTRA_MESSAGE);
        // Lookup the recyclerview in activity layout
        //LayoutInflater inflater = this.getLayoutInflater();
        //View dialogView = inflater.inflate(R.layout.activity_display_message, null);
        RecyclerView rvMissions;
        //rvMissions = (RecyclerView) dialogView.findViewById(R.id.my_recycler_view);
        rvMissions = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Initialize contacts
        missionsForLife = new ArrayList<Mission>();//
        // Create adapter passing in the sample user data
        MissionAdapter adapter = new MissionAdapter(this, missionsForLife);
        // Attach the adapter to the recyclerview to populate items
        rvMissions.setAdapter(adapter);
        // Set layout manager to position the items
        rvMissions.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }


    /*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        ArrayList<String> message = intent.getStringArrayListExtra(EXTRA_MESSAGE);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(message);
        mRecyclerView.setAdapter(mAdapter);


        // Capture the layout's TextView and set the string as its text
        //TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText(message);
        //textView.setMovementMethod(new ScrollingMovementMethod());
    }


*/
    // Called when the user taps the Send button
    public void sendMessage (View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        //TextView curText = (TextView) findViewById(R.id.textView);
        missionsForLife.add(new Mission(editText.getText().toString()));
        intent.putExtra(EXTRA_MESSAGE,missionsForLife);
        //String message = curText.getText().toString() + "\n" + editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        finish();
        startActivity(intent);
    }
}
