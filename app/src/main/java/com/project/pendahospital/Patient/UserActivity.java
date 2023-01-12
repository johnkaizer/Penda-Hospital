package com.project.pendahospital.Patient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.pendahospital.Aunthentication.LoginActivity;
import com.project.pendahospital.Models.User;
import com.project.pendahospital.R;

public class UserActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    TextView details,details1,details2,insta,facebook,twitter;
    LinearLayout layout,layout1,layout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        progressBar = findViewById(R.id.progressBar);
        details = findViewById(R.id.penda_details);
        insta = findViewById(R.id.instagram);
        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.facebook.com/PendaHealth/");
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://twitter.com/pendahealth");
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl( "https://www.instagram.com/penda_health/");
            }
        });


        layout = findViewById(R.id.linear);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details1 = findViewById(R.id.penda_details1);
        layout1 = findViewById(R.id.linear1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        details2 = findViewById(R.id.penda_details2);
        layout2= findViewById(R.id.linear2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        progressBar.setVisibility(View.VISIBLE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView fullNameTxt = findViewById(R.id.user_name);
        final TextView emailTxt = findViewById(R.id.user_email);
        final TextView phoneTxt = findViewById(R.id.user_phone);
        final TextView passwordTxt = findViewById(R.id.user_pass);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile !=null){
                    String fullName = userProfile.fullName;
                    String email = userProfile.email;
                    String phone = userProfile.phone;
                    String password = userProfile.password;


                    fullNameTxt.setText(fullName);
                    emailTxt.setText(email);
                    phoneTxt.setText(phone);
                    passwordTxt.setText(password);

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(UserActivity.this,"Something wrong happened!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void expand(View view) {
        int v = (details.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details.setVisibility(v);
    }
    public void expand1(View view) {
        int v = (details1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details1.setVisibility(v);
    }
    public void expand2(View view) {
        int v = (details1.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;

        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details1.setVisibility(v);
    }
}