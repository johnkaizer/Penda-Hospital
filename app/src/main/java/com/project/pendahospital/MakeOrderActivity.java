package com.project.pendahospital;

import static com.project.pendahospital.Constants.BUSINESS_SHORT_CODE;
import static com.project.pendahospital.Constants.CALLBACKURL;
import static com.project.pendahospital.Constants.PARTYB;
import static com.project.pendahospital.Constants.PASSKEY;
import static com.project.pendahospital.Constants.TRANSACTION_TYPE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.pendahospital.Models.AccessToken;
import com.project.pendahospital.Models.STKPush;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MakeOrderActivity extends AppCompatActivity {
    TextView docName,Category,docTime;
    EditText patName, patPhone,patTime;
    AppCompatButton submit;

    DatabaseReference dataRef;
    private DarajaApiClient mApiClient;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        docName = findViewById(R.id.doc_name);
        docName.setText(getIntent().getExtras().getString("title"));
        Category = findViewById(R.id.doc_category);
        Category.setText(getIntent().getExtras().getString("amount"));
        docTime = findViewById( R.id.doc_time);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        docTime.setText(currentDate);
        patName = findViewById(R.id.pat_name);
        patPhone = findViewById(R.id.pat_phone);
        patTime = findViewById(R.id.pat_time);
        submit= findViewById(R.id.submit_btn);
        dataRef= FirebaseDatabase.getInstance().getReference().child("TransactionDetails");

        ButterKnife.bind(this);
        mProgressDialog = new ProgressDialog(this);
        mApiClient = new DarajaApiClient();
        mApiClient.setIsDebug(true); //Set True to enable logging, false to disable.
        getAccessToken();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_number = patPhone.getText().toString();
                String amount = Category.getText().toString();
                performSTKPush(phone_number,amount);
                PaymentDetails();
            }
        });
    }

    private void getAccessToken() {
        mApiClient.setGetAccessToken(true);
        mApiClient.mpesaService().getAccessToken().enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {

                if (response.isSuccessful()) {
                    mApiClient.setAuthToken(response.body().accessToken);
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessToken> call, @NonNull Throwable t) {

            }
        });
    }

    private void PaymentDetails() {
        String TransactionDate =  docTime.getText().toString();
        String TransactionTitle =  patName.getText().toString();
        String TransactionAmount =  patPhone.getText().toString();
        String Product =  patPhone.getText().toString();
        String CustomerPhone =  patPhone.getText().toString();
        String Location =  patPhone.getText().toString();

        TransactionModel deposit = new TransactionModel(TransactionTitle,TransactionAmount,TransactionDate,Product,CustomerPhone,Location);
        dataRef.push().setValue(deposit);
        Intent intent = new Intent(MakeOrderActivity.this, SuccessActivity.class);
        startActivity(intent);
        finish();
    }

    private void performSTKPush(String phone_number, String amount) {
        mProgressDialog.setMessage("Processing your request");
        mProgressDialog.setTitle("Please Wait...");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.show();
        String timestamp = Utils.getTimestamp();
        STKPush stkPush = new STKPush(
                BUSINESS_SHORT_CODE,
                Utils.getPassword(BUSINESS_SHORT_CODE, PASSKEY, timestamp),
                timestamp,
                TRANSACTION_TYPE,
                String.valueOf(amount),
                Utils.sanitizePhoneNumber(phone_number),
                PARTYB,
                Utils.sanitizePhoneNumber(phone_number),
                CALLBACKURL,
                "Penda Hospital", //Account reference
                "Payment"  //Transaction description
        );


        mApiClient.setGetAccessToken(false);

        //Sending the data to the Mpesa API, remember to remove the logging when in production.
        mApiClient.mpesaService().sendPush(stkPush).enqueue(new Callback<STKPush>() {
            @Override
            public void onResponse(@NonNull Call<STKPush> call, @NonNull Response<STKPush> response) {
                mProgressDialog.dismiss();
                try {
                    if (response.isSuccessful()) {
                        Timber.d("post submitted to API. %s", response.body());
                    } else {
                        Timber.e("Response %s", response.errorBody().string());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<STKPush> call, @NonNull Throwable t) {
                mProgressDialog.dismiss();
                Timber.e(t);
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}