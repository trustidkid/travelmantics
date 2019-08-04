package com.example.travelmantics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    EditText txtTitle;
    EditText txtPrice;
    EditText txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        FirebaseUtil.openFBReference("traveldeals");
       // mFirebaseDatabase = FirebaseDatabase.getInstance();
       // mDatabaseReference = mFirebaseDatabase.getReference().child("traveldeals");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        txtTitle = findViewById(R.id.txtTitle);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescription = findViewById(R.id.txtDescription);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_menu:
                //saveDeal();
                //Toast.makeText(this,"Deal Saved",Toast.LENGTH_LONG).show();
                //clean();
                Intent intent = new Intent(this, UserActivity.class);
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
        
    }

    private void saveDeal() {
        String desc = txtDescription.getText().toString();
        String title = txtTitle.getText().toString();
        String price = txtPrice.getText().toString();
        TravelDeal deal = new TravelDeal(price,title,desc,"");
        mDatabaseReference.push().setValue(deal);
    }

    private void clean(){
        txtDescription.setText("");
        txtPrice.setText("");
        txtTitle.setText("");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return  true;
    }
}
