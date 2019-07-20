package com.example.ad36_nguyenthanhlong_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Detail_Fragment extends Fragment {
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    List<Contact> contactList;
    TextView tvTotalPrice, tvPrice;
    Button btOder;
    Contact contact;
    int cost = 0;
    int dem;
    public static Detail_Fragment newInstance(Contact contact, int count) {
        // khoong truyen dc ca 1 list contact
        Bundle args = new Bundle();
        args.putSerializable("contact", contact);

       // args.putSerializable("count",count);
        Detail_Fragment fragment = new Detail_Fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.detail_fragment, container, false);


        contactList = new ArrayList<>();

        Contact contact1 = new Contact("cofe", "1000", 1);
        Contact contact2 = new Contact("tea", "3000", 5);
        contactList.add(contact1);
        contactList.add(contact2);

        Contact contact = (Contact) getArguments().getSerializable("contact");

       // dem = (int) getArguments().getSerializable("count");
        //int d=0;
        // chưa add dc nhieu

        if (contact == null ) {

        }  else contactList.add(contact);


        recyclerView = view.findViewById(R.id.listMenuCustom);
        tvTotalPrice = view.findViewById(R.id.tvTotalPrice);
        tvPrice = view.findViewById(R.id.tvPrice);
        btOder = view.findViewById(R.id.btOder);

        btOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Oder Successful", Toast.LENGTH_LONG).show();
            }
        });


        for (int i = 0; i < contactList.size(); i++) {
            cost = cost + Integer.valueOf(contactList.get(i).cost);
        }

        tvPrice.setText(String.valueOf(cost+" VNĐ"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        contactAdapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(layoutManager);

        contactAdapter.setIonClickContact(new IonclickContact() {
            @Override
            public void onClickDrink(final Contact contact) {
                PopupMenu popupMenu = new PopupMenu(getContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_detail, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        contactList.remove(contact);
                        contactAdapter.notifyDataSetChanged();
                        cost = cost - Integer.valueOf(contact.getCost());
                        tvPrice.setText(String.valueOf(cost)+" VNĐ");
                        return false;
                    }

                });
                popupMenu.show();

            }
        });
        return view;
    }
}
