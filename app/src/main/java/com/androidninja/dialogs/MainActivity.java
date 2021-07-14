package com.androidninja.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NoticeBackDialogFragment.NoticeDialogListener {

    Button dialogFragmentButton,buildingAnAlertDialog,singleChoiceAlertDialog,
            multiChoiceAlertDialog,singleChoiceWithRadioButtonAlertDialog,activityAsDialog,passingEventBackToDialogHost,dismissCancelDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogFragmentButton = findViewById(R.id.dialogFragmentButton);
        buildingAnAlertDialog  = findViewById(R.id.buildingAnAlertDialog);
        singleChoiceAlertDialog = findViewById(R.id.singleChoiceAlertDialog);
        multiChoiceAlertDialog = findViewById(R.id.multiChoiceAlertDialog);
        singleChoiceWithRadioButtonAlertDialog = findViewById(R.id.singleChoiceWithRadioButtonAlertDialog);
        activityAsDialog = findViewById(R.id.activityAsDialog);
        passingEventBackToDialogHost = findViewById(R.id.passingEventBackToDialogHost);
        dismissCancelDialog = findViewById(R.id.dismissCancelDialog);

        dialogFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogs();

            }
        });

        singleChoiceAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a Dialog Fragment and show it
                DialogFragment colorDialogFragment = new ColorDialogFragment();
                colorDialogFragment.show(getSupportFragmentManager(),"Colors");
            }
        });
        buildingAnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //To build an AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title);


                // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked OK button
                    }
                     });
                   builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           // User cancelled the dialog
                       }
                   });

                // Create the AlertDialog
                AlertDialog dialog = builder.create();

                //To show the dialog
                dialog.show();

            }
        });


        multiChoiceAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a Dialog Fragment and show it
                DialogFragment multiChoiceFragment = new MultiChoiceFragment();
                multiChoiceFragment.show(getSupportFragmentManager(),"Toppings");
            }
        });


        singleChoiceWithRadioButtonAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a Dialog Fragment and show it
                DialogFragment customDialogFragment = new CustomDialogFragment();
                customDialogFragment.show(getSupportFragmentManager(),"signin");
            }
        });

        activityAsDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityAsDialog.class);
                startActivity(intent);
            }
        });

        passingEventBackToDialogHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new NoticeBackDialogFragment();
                dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
            }
        });

        dismissCancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new CancelDismissDialogFragment();
                dialog.show(getSupportFragmentManager(), "CancelDismissDialogFragment");
            }
        });
    }




    //To show a dialog
    private void showDialogs() {
        // create a Dialog Fragment and show it
        DialogFragment dialogFragment = new FireMissilesDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"Missiles");
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
       //User touched the dialog's positive button
        Toast.makeText(getApplicationContext(),"Positive button clicked ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        //User touched the dialog's negative button
        Toast.makeText(getApplicationContext(),"Negative button clicked ",Toast.LENGTH_LONG).show();
    }
}