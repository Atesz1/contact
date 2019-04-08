package com.example.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddContactActivity extends AppCompatActivity {
    private EditText mEdt_Fullname, mEdt_company, mEdt_title, mEdt_mobile, mEdt_email;
    private TextView mEdt_created;
    private ImageView mEdt_avatar;
    Button mBtn_Save , mBtn_Cancel;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db = new MyDatabase(this);
        mEdt_Fullname = (EditText) findViewById(R.id.edit_fullname);
        mEdt_company = (EditText) findViewById(R.id.edit_company);
        mEdt_title = (EditText) findViewById(R.id.edit_title);
        mEdt_mobile = (EditText) findViewById(R.id.edit_mobile);
        mEdt_email = (EditText) findViewById(R.id.edit_email);
        mEdt_created = (TextView) findViewById(R.id.tv_created);
        mEdt_avatar = (ImageView) findViewById(R.id.avatar);
        mBtn_Save = (Button) findViewById(R.id.btn_save);
        mBtn_Cancel= (Button) findViewById(R.id.btn_cancel);
        setonClick();

    }
    public Contact addContact(){
        Contact newContact  = new Contact();
        newContact.setFullname(mEdt_Fullname.getText().toString());
        newContact.setCompany(mEdt_company.getText().toString());
        newContact.setTitle(mEdt_title.getText().toString());
        newContact.setMobile(mEdt_mobile.getText().toString());
        newContact.setEmail(mEdt_email.getText().toString());

        String dateInString = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        newContact.setCreated(dateInString);
        newContact.setmId(db.addContact(newContact));

       return newContact;
    }

    public void setonClick(){
        mBtn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = addContact();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("RETURN", contact);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        mBtn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        }
    }

