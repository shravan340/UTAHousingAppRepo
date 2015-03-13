package utahousing.seproject.com.utahousing;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import utahousing.seproject.database.DBAdapter;
import utahousing.seproject.database.DBHelper;


public class HousingLogin extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing_login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_housing_login, menu);
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

    public void OnLoginClick(View view){
        EditText tb_myMavUserId=(EditText) findViewById(R.id.tb_username);
        EditText tb_password=(EditText) findViewById(R.id.tb_password);
        DBAdapter dbAdapter=new DBAdapter(this);
        if(dbAdapter.isLoginSuccessful(tb_myMavUserId.getText().toString(),tb_password.getText().toString())) {
            Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HousingHome.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Invalid Username/Password. Please try again",Toast.LENGTH_SHORT).show();
        }
    }
}
