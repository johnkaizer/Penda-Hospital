package com.project.pendahospital.Admin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.project.pendahospital.R;

import java.util.HashMap;


public class DoctorsFragment extends Fragment {
    public static final int REQUEST_CODE_IMAGE=101;
    ProgressBar progressBar;
    ImageView image;
    Button Addimage, submitbtn;
    EditText docname, phone, number,time;
    Uri imageUri;
    boolean isImageAdded= false;
    DatabaseReference dataRef;
    StorageReference storageRef;
    private Spinner spinner1;
    AppCompatButton manage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctors, container, false);
        manage= view.findViewById(R.id.View_btn);
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DoctorsManagement.class));

            }
        });
        //Spinners
        spinner1 = view.findViewById(R.id.doctor_category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity() ,R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        progressBar=view.findViewById(R.id.progressbar1);
        image =view.findViewById(R.id.doc_image);
        Addimage=view.findViewById(R.id.appCompatButton2);
        submitbtn=view.findViewById(R.id.appCompatButton3);
        docname=view.findViewById(R.id.test_name);
        phone=view.findViewById(R.id.doc_phone);
        number=view.findViewById(R.id.doc_number);
        time= view.findViewById(R.id.doc_time);

        progressBar.setVisibility(View.GONE);
        dataRef= FirebaseDatabase.getInstance().getReference().child("DoctorsDetails");
        storageRef= FirebaseStorage.getInstance().getReference().child("DoctorsImage");

        Addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String DoctorName= docname.getText().toString();
                final String DocNumber =number.getText().toString();
                final String DoctorPhone=phone.getText().toString();
                final String DoctorTime= time.getText().toString();
                final String DoctorCategory= spinner1.getSelectedItem().toString();

                if (isImageAdded!=false && DoctorName!=null && DocNumber!=null && DoctorPhone!=null && DoctorTime!=null && DoctorCategory!=null){
                    uploadImage(DoctorName,DocNumber,DoctorPhone,DoctorTime,DoctorCategory);
                }

            }
        });



        return view;
    }

    private void uploadImage(String doctorName, String docNumber, String doctorPhone, String doctorTime, String doctorCategory) {
        progressBar.setVisibility(View.VISIBLE);

        final String key = dataRef.push().getKey();
        storageRef.child(key +".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                storageRef.child(key +".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap=new HashMap();
                        hashMap.put("DoctorName",doctorName);
                        hashMap.put("DocNumber",docNumber);
                        hashMap.put("DoctorPhone",doctorPhone);
                        hashMap.put("DoctorTime",doctorTime);
                        hashMap.put("DoctorCategory",doctorCategory);
                        hashMap.put("ImageUrl",uri.toString());

                        dataRef.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getContext(), "Data was successfully uploaded", Toast.LENGTH_SHORT).show();
                                docname.setText("");
                                phone.setText("");
                                number.setText("");
                                time.setText("");
                                image.setImageResource(R.drawable.image_24);
                                progressBar.setVisibility(View.GONE);

                            }
                        });
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress =snapshot.getBytesTransferred()*100/snapshot.getTotalByteCount();
                progressBar.setProgress((int) progress);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE_IMAGE && data!=null){
            imageUri=data.getData();
            isImageAdded=true;
            image.setImageURI(imageUri);

        }
    }
}