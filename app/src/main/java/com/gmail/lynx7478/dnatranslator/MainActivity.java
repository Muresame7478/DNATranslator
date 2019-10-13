// Created by Gabriel Herbert for biology class at IES Cervantes.

package com.gmail.lynx7478.dnatranslator;

import android.os.Bundle;
import android.view.View;

import com.gmail.lynx7478.dnatranslator.ui.aminotoarn.AminoToRNAFragment;
import com.gmail.lynx7478.dnatranslator.ui.rnatoamino.RNAToAminoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static HashMap<String, String> codons;

    public static HashMap<String, String[]> aminoacids;

    private static void a(String a, String b)
    {
        codons.put(a, b);
    }
    private static void b(String a, String[] b)
    {
        aminoacids.put(a, b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Init. codon hashmap.
        codons =  new HashMap<String, String>();

        a("AUG", "Met");

        a("UUU", "Phe");
        a("UUC", "Phe");
        a("UUA", "Leu");
        a("UUG", "Leu");

        a("UCU", "Ser");
        a("UCC", "Ser");
        a("UCA", "Ser");
        a("UCG", "Ser");

        a("UAU", "Tyr");
        a("UAC", "Phe");
        a("UAA", "STO");
        a("UAG", "STO");

        a("UGU", "Cys");
        a("UGC", "Cys");
        a("UGA", "STO");
        a("UGG", "Trp");

        a("CUU", "Leu");
        a("CUC", "Leu");
        a("CUA", "Leu");
        a("CUG", "Leu");

        a("CCU", "Pro");
        a("CCC", "Pro");
        a("CCA", "Pro");
        a("CCG", "Pro");

        a("CAU", "His");
        a("CAC", "His");
        a("CAA", "Gln");
        a("CAG", "Gln");

        a("CGU", "Arg");
        a("CGC", "Arg");
        a("CGA", "Arg");
        a("CGG", "Arg");

        a("AUU", "Ile");
        a("AUC", "Ile");
        a("AUA", "Ile");
//			a("AUG", "Met");

        a("ACU", "Thr");
        a("ACC", "Thr");
        a("ACA", "Thr");
        a("ACG", "Thr");

        a("AAU", "Asn");
        a("AAC", "Asn");
        a("AAA", "Lys");
        a("AAG", "Lys");

        a("AGU", "Ser");
        a("AGC", "Ser");
        a("AGA", "Arg");
        a("CGG", "Arg");

        a("GUU", "Val");
        a("GUC", "Val");
        a("GUA", "Val");
        a("GUG", "Val");

        a("GCU", "Ala");
        a("GCC", "Ala");
        a("GCA", "Ala");
        a("GCG", "Ala");

        a("GAU", "Asp");
        a("GAC", "Asp");
        a("GAA", "Glu");
        a("GAG", "Glu");

        a("GGU", "Gly");
        a("GGC", "Gly");
        a("GGA", "Gly");
        a("GGG", "Gly");

        aminoacids = new HashMap<String, String[]>();

        b("Phe", new String[]{"UUU", "UUC", "UAC"});
        b("Leu", new String[]{"UUA", "UUG", "CUU","CUC","CUA","CUG"});
        b("Ser", new String[]{"UCU", "UCC", "UCA", "UCG","AGU","AGC"});
        b("STO", new String[]{"UAA", "UAG", "UGA"});
        b("Cys", new String[]{"UGU", "UGC"});
        b("Trp", new String[]{"UGG"});
        b("Pro", new String[]{"CCU", "CCC","CCA","CCG"});
        b("His", new String[]{"CAU", "CAC"});
        b("Gln", new String[]{"CAA", "CAG"});
        b("Arg", new String[]{"CGU", "CGC","CGA","CGG","AGA","AGG"});
        b("Ile", new String[]{"AUU", "AUC","AUA"});
        b("Met", new String[]{"AUG"});
        b("Thr", new String[]{"ACU", "ACC","ACA","ACG"});
        b("Asn", new String[]{"AAU", "AAC"});
        b("Lys", new String[]{"AAA", "AAG"});
        b("Val", new String[]{"GUU", "GUC","GUA","GUG"});
        b("Ala", new String[]{"GCU", "GCC","GCA","GCG"});
        b("Asp", new String[]{"GAU", "GAC"});
        b("Glu", new String[]{"GAA", "GAG"});
        b("Gly", new String[]{"GGU", "GGC","GGA","GGG"});




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_rnatoa, R.id.navigation_atorna)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void rnaToAmino(View v)
    {
        RNAToAminoFragment.rnaToAmino(v);
    }

    public void aminoToRNA(View v)
    {
        AminoToRNAFragment.aminoToRNA(v);
    }

}
