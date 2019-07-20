package com.example.ad36_nguyenthanhlong_04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewhoder >{
    List<Contact> contactList;
    IonclickContact ionclickContact;

    public ContactAdapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setIonClickContact(IonclickContact ionClickContact) {
        this.ionclickContact = ionClickContact;
    }

    @NonNull
    @Override
    public ContactAdapter.Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact,parent,false);
        Viewhoder viewhoder = new Viewhoder(view);
        return  viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.Viewhoder holder, int position) {
        int [] imgview = {R.drawable.coffee_00,R.drawable.tea_01,R.drawable.macchaiato_02,R.drawable.capucinno_03,R.drawable.socola_04,R.drawable.tea_oolong_05,R.drawable.fruitjuice_06};
        final Contact contact = contactList.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvCost.setText(contact.getCost());

        if (contact.img<imgview.length){
            holder.imageView.setImageResource(imgview[contact.img]);

        }else holder.imageView.setImageResource(R.drawable.noimg);
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ionclickContact.onClickDrink(contact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvName, tvCost;
        ImageView imageView;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameContact);
            tvCost = itemView.findViewById(R.id.tvCost);
            imageView = itemView.findViewById(R.id.imgview);
        }
    }
}
