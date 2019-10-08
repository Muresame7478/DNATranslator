package com.gmail.lynx7478.dnatranslator.ui.rnatoamino;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.lynx7478.dnatranslator.MainActivity;
import com.gmail.lynx7478.dnatranslator.R;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class RNAToAminoFragment extends Fragment {

    private RNAToAminoViewModel RNAToAminoViewModel;

    private static TextView text;
    private static EditText input;
    private static EditText output;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RNAToAminoViewModel =
                ViewModelProviders.of(this).get(RNAToAminoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rnatoamino, container, false);
        text = root.findViewById(R.id.textViewB);

        input = root.findViewById(R.id.textInputAmino);
        output = root.findViewById(R.id.textOutputRNA);

        input.setScroller(new Scroller(getActivity().getApplicationContext()));
        input.setMinLines(2);
        input.setVerticalScrollBarEnabled(true);
        input.setMovementMethod(new ScrollingMovementMethod());
        return root;
    }

    public static void rnaToAmino(View view)
    {
        String sequence = input.getText().toString();
        String[] split = sequence.split("AUG");

        if(split.length <=1)
        {
            text.setText("No start codon found or no codons found after start codon.");
            return;
        }

        // Sudivides string into parts of 3 characters each.
        String[] subdvisions = Iterables.toArray(Splitter.fixedLength(3).split(split[1]),
                String.class
        );

        // Resulting string formation.
        //TODO: Add something for when a stop codon in encountered?
        String result = "(Met)";
        boolean stop = false;
        for(int i = 0; i<subdvisions.length; i++)
        {
            if(MainActivity.codons.containsKey(subdvisions[i]))
            {
                if(MainActivity.codons.get(subdvisions[i]).equals("STO"))
                {
                    stop = true;
                    break;
                }
                result = result + MainActivity.codons.get(subdvisions[i]);
            }
        }

        if(stop)
        {
            text.setText("The sequence has been translated! A STOP codon was found.");
        }else
        {
            text.setText("The sequence has been translated!");
        }
        output.setText(result);
        return;

    }
}