package com.example.tonytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText editListItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editListItem = findViewById(R.id.editListItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        editListItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When user is done editing, click save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create an intent that will contain the results
                Intent intent = new Intent();
                // pass the edited results (data)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, editListItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POS, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POS));
                // set the result of the intent
                setResult(RESULT_OK, intent);
                //finish activity, close the screen and go back
                finish();
            }
        });

    }
}