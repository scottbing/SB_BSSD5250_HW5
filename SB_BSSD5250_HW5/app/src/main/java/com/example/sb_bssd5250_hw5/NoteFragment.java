package com.example.sb_bssd5250_hw5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class NoteFragment extends Fragment {

    private static int EDITOR_REQUEST = 1;

    public static final String EXTRA_NAME = "com.example.sb_bssd5250_hw5a";
    public static final String EXTRA_DATE = "com.example.sb_bssd5250_hw5b";
    public static final String EXTRA_DESC = "com.example.sb_bssd5250_hw5c";

    private TextView nameView;
    private TextView dateView;
    private TextView descView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        Context context = getActivity();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.WHITE);

        nameView = new TextView(context);
        nameView.setText("Name");
        dateView = new TextView(context);
        dateView.setText("Date");
        descView = new TextView(context);
        descView.setText("Description");

        Button editButton = new Button(context);
        editButton.setText("Edit");
        editButton.setOnClickListener(editClickedListener);

        linearLayout.addView(nameView);
        linearLayout.addView(dateView);
        linearLayout.addView(descView);
        linearLayout.addView(editButton);


        return linearLayout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDITOR_REQUEST){
            if(resultCode == Activity.RESULT_OK) {
                nameView.setText((data.getStringExtra(NoteEditorDialog.EXTRA_NAME)));
                dateView.setText((data.getStringExtra(NoteEditorDialog.EXTRA_DATE)));
                descView.setText((data.getStringExtra(NoteEditorDialog.EXTRA_DESC)));
            }
        }
    }

    public void showDialog() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        NoteEditorDialog noteEditorDialog = new NoteEditorDialog();
        noteEditorDialog.setTargetFragment(this, EDITOR_REQUEST);
        noteEditorDialog.show(fragmentManager, "DIALOG_NOT_EDITOR");
    }

    private View.OnClickListener editClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Log.d("NoteFragment", "edit clicked");
            /*FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            NoteEditorDialog noteEditorDialog = new NoteEditorDialog();
            noteEditorDialog.show(fragmentManager, "DIALOG_NOT_EDITOR");*/
            showDialog();
        }
    };
}