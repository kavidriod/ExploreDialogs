package com.androidninja.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class ColorDialogFragment extends DialogFragment {

    private String[] colors;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // create the Dialog builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set title
        builder.setTitle(R.string.pickcolor);

        // get the resource object and then copy the resource array to a String array
        Resources resources = this.getResources();
        colors = resources.getStringArray(R.array.colors);

        // set the onClick listener
        builder.setItems(R.array.colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                // The 'which' argument contains the index position of the selected item
                Toast.makeText(getActivity(), "Color Selected: " + colors[which], Toast.LENGTH_LONG).show();
            }
        });

        return builder.create();
    }
}