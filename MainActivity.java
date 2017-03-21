package com.example.regev.selfchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Vector;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    ArrayList<Mission> missionsForLife;
    MissionAdapter adapter;
    RecyclerView rvMissions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        missionsForLife = new ArrayList<Mission>();

        //rvMissions = (RecyclerView) dialogView.findViewById(R.id.my_recycler_view);
        rvMissions = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Initialize contacts
        missionsForLife = new ArrayList<Mission>();//
        // Create adapter passing in the sample user data
        adapter = new MissionAdapter(this, missionsForLife);
        // Attach the adapter to the recyclerview to populate items
        rvMissions.setAdapter(adapter);
        // Set layout manager to position the items
        rvMissions.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
        registerForContextMenu(rvMissions);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Mission info = (Mission) item.getMenuInfo();
        info.getDescription();
        switch (item.getItemId()) {
            case R.id.delete:
                missionsForLife.remove(info);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    /** Called when the user taps the Send button */
    public void sendMessage (View view) {
        // Do something in response to button
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        //ArrayList<Mission> message = new ArrayList<Mission>();
        missionsForLife.add(new Mission(editText.getText().toString()));
        adapter.notifyDataSetChanged();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }
}
