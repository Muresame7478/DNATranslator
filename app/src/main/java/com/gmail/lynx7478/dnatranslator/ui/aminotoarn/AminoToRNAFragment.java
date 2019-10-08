package com.gmail.lynx7478.dnatranslator.ui.aminotoarn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.gmail.lynx7478.dnatranslator.MainActivity;
import com.gmail.lynx7478.dnatranslator.R;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

public class AminoToRNAFragment extends Fragment {

    private AminoToRNAViewModel aminoToRNAViewModel;

    private static TextView textView;
    private static EditText input;
    private static EditText output;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aminoToRNAViewModel =
                ViewModelProviders.of(this).get(AminoToRNAViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aminotorna, container, false);

        textView = root.findViewById(R.id.textViewB);
        input = root.findViewById(R.id.textInputAmino);
        output = root.findViewById(R.id.textOutputRNA);

        return root;
    }

    public static void aminoToRNA(View v)
    {
        String[] acids = Iterables.toArray(Splitter.fixedLength(3).split(input.getText().toString()),
                String.class
        );

        String result = "";
        for(int i = 0; i<acids.length; i++)
        {
            String pre = "";
            if(MainActivity.aminoacids.containsKey(acids[i]))
            {
                String[] s = MainActivity.aminoacids.get(acids[i]);
                if(s.length==1)
                {
                    pre = s[0];
                }else
                {
                    pre = "[ ";
                    for(int e = 0; e<s.length; e++)
                    {
                        pre = pre + s[e]+", ";
                    }
                    pre = pre + "]";
                }
                result = result + pre;
            }
        }

        output.setText(result);
        textView.setText("Your aminoacid chain has been translated.");

    }
}