package com.example.travelmantics;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil {

    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    public static ChildEventListener mChildEventListener;
    public static FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeal> mDeals;

    public FirebaseUtil(){};

    public static void openFBReference(String ref){

        if(firebaseUtil == null)
        {
            firebaseUtil = new FirebaseUtil();
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            mDeals = new ArrayList<TravelDeal>();

        }
        mDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }

}
