package com.androidninja.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SingleChoiceFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ArrayList<Integer> selectedItems = new ArrayList<>();
        // create the Dialog builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        //Set title
        builder.setTitle(R.string.picktoppings);
        // Specify the list array, the items to be selected by default (null for none), and the listener through
        // which to receive callbacks when items are selected
        builder.setSingleChoiceItems(R.array.toppings, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //Set Action buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //User clicked OK
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //User clicked Cancel
            }
        });

        return builder.create();
    }

   }