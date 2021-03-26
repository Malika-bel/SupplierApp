package com.example.apptestfirebase.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.apptestfirebase.CommandeInstance;
import com.example.apptestfirebase.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView ListeCommande;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList<String> commandes = new ArrayList<>();
        commandes.add("Commande1");
        commandes.add("Commande2");
        commandes.add("Commande3");
        commandes.add("Commande4");
        commandes.add("Commande5");
        commandes.add("Commande6");
        commandes.add("Commande7");
        ListeCommande = root.findViewById(R.id.ListCommande);
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,commandes);
        ListeCommande.setAdapter(adapter);
        ListeCommande.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MyTag","L'élément" + position + "a été cliqué");
                String commande1 = ListeCommande.getItemAtPosition(position).toString();
                Toast.makeText(getContext(),"l'élément" + position + "a été cliqué sont contenu : "+ commande1,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), CommandeInstance.class);
                intent.putExtra("commande",commande1);
                startActivity(intent);
            }
        });

        
        return root;
    }
}