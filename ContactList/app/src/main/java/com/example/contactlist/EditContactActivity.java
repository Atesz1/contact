package com.example.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditContactActivity extends AppCompatActivity {
    private EditText mEdt_Fullname, mEdt_company, mEdt_title, mEdt_mobile, mEdt_email;
    private TextView mEdt_created;
    private ImageView mEdt_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        mEdt_Fullname=(EditText) findViewById(R.id.edit_fullname);
        mEdt_company=(EditText) findViewById(R.id.edit_company);
        mEdt_title=(EditText) findViewById(R.id.edit_title);
        mEdt_mobile=(EditText) findViewById(R.id.edit_mobile);
        mEdt_email=(EditText) findViewById(R.id.edit_email);
        mEdt_created=(TextView) findViewById(R.id.tv_created);
        mEdt_avatar=(ImageView) findViewById(R.id.avatar);

        Intent intentData= getIntent();
        Bundle packBundle= intentData.getBundleExtra("My package");
        Contact getContact= (Contact)packBundle.getSerializable("contact");

        mEdt_Fullname.setText(getContact.getFullname());
        mEdt_company.setText(getContact.getCompany());
        mEdt_title.setText(getContact.getTitle());
        mEdt_mobile.setText(getContact.getMobile());
        mEdt_email.setText(getContact.getEmail());

    }


}
