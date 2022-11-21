package com.project.pendahospital.Admin;

import android.net.Uri;
import android.os.Bundle;

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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.project.pendahospital.R;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctors, container, false);
        //Spinners
        spinner1 = view.findViewById(R.id.doctor_category_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity() ,R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        progressBar=view.findViewById(R.id.progressbar1);
        image =view.findViewById(R.id.prod_image);
        Addimage=view.findViewById(R.id.appCompatButton2);
        submitbtn=view.findViewById(R.id.appCompatButton3);
        docname=view.findViewById(R.id.doc_name);
        phone=view.findViewById(R.id.doc_phone);
        number=view.findViewById(R.id.doc_number);
        time= view.findViewById(R.id.doc_time);

        progressBar.setVisibility(View.GONE);



        return view;
    }
}