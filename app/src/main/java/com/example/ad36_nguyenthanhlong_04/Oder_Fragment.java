package com.example.ad36_nguyenthanhlong_04;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Oder_Fragment extends Fragment {
    RecyclerView recyclerView;
    ContactAdapter adapter;
    IonclickContact ionclickContact;

    Contact contact0, contact1, contact2, contact3;
    Contact contact4, contact5, contact6, contact7;
    List<Contact> contactList;

    public static Oder_Fragment newInstance() {

        Bundle args = new Bundle();

        Oder_Fragment fragment = new Oder_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.oder_fragment, container, false);



        recyclerView = view.findViewById(R.id.RecyclerList);
        contactList = new ArrayList<>();

        contact0 = new Contact("coffe", "1000", 0);
        contact1 = new Contact("tea", "2000", 1);
        contact2 = new Contact("macchaiato", "3000", 2);
        contact3 = new Contact("capucinno", "4000", 3);
        contact4 = new Contact("socola", "5000", 4);
        contact5 = new Contact("tea_oolong", "6000", 5);
        contact6 = new Contact("Fruitjuice", "7000", 6);
        contact7 = new Contact("Cold Milk", "8000", 7);

        contactList.add(contact0);
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);
        contactList.add(contact7);


        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setIonClickContact(new IonclickContact() {
            @Override
            public void onClickDrink(Contact contact) {
                ionclickContact.onClickDrink(contact);
                Toast.makeText(getContext(),"Đã thêm",Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof IonclickContact){
             ionclickContact= (IonclickContact) context;
        }else {
            throw new RuntimeException(context.toString()+"must implement");
        }
    }
}
