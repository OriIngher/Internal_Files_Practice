package com.example.internal_files_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author oriin 
 */
public class MainActivity extends AppCompatActivity {
EditText ed1;
TextView tv1;
FileInputStream fis;
String line,strwr,strrd,strwr1,strrd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.ed1);
        tv1 = (TextView) findViewById(R.id.tv1);
        if(ed1!=null)
        {
            try {
                FileInputStream fis = openFileInput("test.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                line = br.readLine();
                while (line!=null)
                {
                    sb.append(line+'\n');
                    line= br.readLine();
                }
                strrd = sb.toString();
                isr.close();
                tv1.setText(strrd);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(tv1!=null)
        {
            try {
                FileInputStream fis = openFileInput("test.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                StringBuffer sb = new StringBuffer();
                line = br.readLine();
                while (line!=null)
                {
                    sb.append(line+'\n');
                    line= br.readLine();
                }
                strrd = sb.toString();
                isr.close();
                tv1.setText(strrd);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return saves the text in the edit text and text view in the file
     * @param view
     */
    public void Save(View view) {
        tv1.setText(tv1.getText()+String.valueOf(ed1.getText()));
        strwr = ed1.getText().toString();
        strrd1 = tv1.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(strwr);
            bw.write(strrd1);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return reset the text on the edit text and text view and write it in the file
     * @param view
     */
    public void Reset(View view) {
        ed1.setText("");
        tv1.setText("");
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write("");
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return saves the text in the edit text and text view in the file and close the app
     * @param view
     */
    public void Exit(View view) {
        tv1.setText(tv1.getText()+String.valueOf(ed1.getText()));
        strwr = ed1.getText().toString();
        strrd1 = tv1.getText().toString();
        try {
            FileOutputStream fos = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(strwr);
            bw.write(strrd1);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();

    }







































    /**
     *
     * @param menu
     */
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     *
     * @param item
     * @return checks if "credits" button is pressed and if so moves to "credits" activity
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id==R.id.credits)
        {
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return true;
    }

}
