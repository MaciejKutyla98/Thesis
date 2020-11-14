package com.example.thesis;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsHolder> {

    List<Person> personList;
    Context context;

    public ContactsAdapter(List<Person> personList, Context context){
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_row, viewGroup, false);
        return new ContactsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactsHolder contactsHolder, int i) {

        Person person = personList.get(i);
        contactsHolder.nameTextView.setText(person.getName());
        contactsHolder.telephoneTextView.setText(person.getTelephoneNumber());
        contactsHolder.mailTextView.setText(person.getMail());
        final String phone = "tel:" + person.getTelephoneNumber();
        contactsHolder.telephoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(phone));
                context.startActivity(callIntent);
            }
        });

        boolean isExpanded = personList.get(i).isExpanded();
        contactsHolder.contactDetailLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class ContactsHolder extends RecyclerView.ViewHolder{

        ConstraintLayout contactDetailLayout;
        TextView nameTextView, telephoneTextView, mailTextView;

        public ContactsHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.contact_name);
            telephoneTextView = itemView.findViewById(R.id.contact_number);
            mailTextView = itemView.findViewById(R.id.contact_mail);
            contactDetailLayout = itemView.findViewById(R.id.contactDetailLayout);

            nameTextView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Person person  = personList.get(getAdapterPosition());
                    person.setExpanded(!person.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}
