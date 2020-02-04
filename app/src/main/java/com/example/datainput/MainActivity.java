package com.example.datainput;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText txtname=(EditText) findViewById(R.id.txtname);
        EditText txtemail=(EditText) findViewById(R.id.txtemail);
        DatePicker datePicker=(DatePicker) findViewById(R.id.dtpicker);
        CheckBox chktoc=(CheckBox) findViewById(R.id.chktoc);
        Button btnnext=(Button) findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayNextAlert();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void displayNextAlert(){
        EditText txtname=(EditText) findViewById(R.id.txtname);
        EditText txtemail=(EditText) findViewById(R.id.txtemail);
        CheckBox chktoc=(CheckBox) findViewById(R.id.chktoc);

        String strName=txtname.getText().toString();
        String strDOB=datePicker.getDayOfMonth()+"/"+(datePicker.getMonth()+1)+"/"+datePicker.getYear();
        String strEmail=txtemail.getText().toString();

        new AlertDialog.Builder(this).setTitle("Details Entered").setMessage("Details Entered:\n"+strName+"\n"+strDOB+"\n"+strEmail).setNeutralButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
