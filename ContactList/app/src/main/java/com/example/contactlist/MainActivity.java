package com.example.contactlist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ContactAdapter adapter;
    ArrayList<Contact>ListObjectContact;
    Button btnAdd;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAdd = (Button) findViewById(R.id.btn_add);

        ListObjectContact = new ArrayList<Contact>();

        db = new MyDatabase (this);
        Contact contact1 = new Contact(1, "Name", "Company", "Mr", "Mobile", "Email");

        ListObjectContact.add(contact1);
        setRecyclerView();
        //getData();
        setOnClickOnItem();
        onClickbtnAdd();
        adapter.notifyDataSetChanged();

    }

    public void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_contacts);
        recyclerView.setHasFixedSize(true);

        adapter = new ContactAdapter(ListObjectContact, MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecycleTouchListener(this, recyclerView,
                new RecycleTouchListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getBaseContext(), EditContactActivity.class);
                        Contact getContact = ListObjectContact.get(position);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("contact", getContact);
                        intent.putExtra("My package", bundle);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Contact getContact = ListObjectContact.get(position);
                        db.deleteContact(getContact);
                        ListObjectContact.remove(position);
                        Toast.makeText(MainActivity.this, "Deleted",
                                Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();


                    }
                }
        ));
    }

    private void getData() {
        ListObjectContact.clear();
        ListObjectContact = db.getAllContacts();

        adapter.notifyDataSetChanged();

        db.close();
    }

    public Contact findContact(String name){
        for (Contact contact: ListObjectContact){
            if (name == contact.getFullname()) {
                return contact;
            }
        }
        return null;
    }
    public void setOnClickOnItem(){
//       Contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//               Intent intent=new Intent (MainActivity.this,
//                                    EditContactActivity.class);
//               String item= Contacts.getItemAtPosition(position).toString();
//               Contact getContact=findContact(item);
//               Bundle bundle= new Bundle();
//               bundle.putSerializable("contact", getContact);
//               intent.putExtra("My package", bundle);
//               startActivity(intent);
//           }
//       });

    }
    public void onClickbtnAdd(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK){
            Contact contact =(Contact) data.getExtras().getSerializable("RETURN");
            ListObjectContact.add(contact);
            adapter.notifyDataSetChanged();
        }
    }
}

