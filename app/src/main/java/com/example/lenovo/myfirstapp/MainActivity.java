package com.example.lenovo.myfirstapp;

import android.app.Activity;
//import android.os.PersistableBundle;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {
final private String msg="Android : ";
    private Button b_next;
    private Button b_true;
    private Button b_false;
   private int n;
   private TextView tv;
private String con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random r;
        Log.d(msg, " In Create ");
        if(savedInstanceState==null)
        {
            r = new Random();
            n = r.nextInt(1000) + 1;
            con = "Is " + Integer.toString(n) + " prime or not";//1//

        }
        TextView t = (TextView) findViewById(R.id.TEXT);
        t.setText(con);

        b_next=(Button)findViewById(R.id.NEXT);
        b_true=(Button)findViewById(R.id.CORRECT);
        b_false=(Button)findViewById(R.id.INCORRECT);

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r=new Random();
                n=r.nextInt(1000)+1;
                String m="Is "+Integer.toString(n)+" prime or not";//1//
                TextView t=(TextView)findViewById(R.id.TEXT);
                t.setText(m);
            }
        });

        b_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplication().getBaseContext(),"Correct",Toast.LENGTH_SHORT).show();
            Log.d(msg,"In true");
            }
        });

        b_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication().getBaseContext(),"Incorrect",Toast.LENGTH_SHORT).show();
            Log.d(msg,"In false");
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(msg,"In onSaveInstance");
        TextView tv1=(TextView)findViewById(R.id.TEXT);
        con=tv1.getText().toString();
        outState.putString("TEXT",con);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        TextView tv1=(TextView)findViewById(R.id.TEXT);
        tv1.setText(savedInstanceState.getString("TEXT"));
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, " In Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, " In Resume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, " In Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, " In Stop");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(msg, " In Destroy");
    }
}
