package com.example.pbt.view;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pbt.R;
import com.example.pbt.ViewModel.MainViewModel;
import com.example.pbt.model.Post;
import com.example.pbt.model.User;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

/**
 * Fragmento con diálogo básico
 */
public class createPost extends DialogFragment {

    private MainViewModel mViewModel;

    public createPost() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createSimpleDialog();
    }

    /**
     * Crea un diálogo de alerta sencillo
     * @return Nuevo diálogo
     */
    public AlertDialog createSimpleDialog() {
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View v = inflater.inflate(R.layout.fragment_create_post, null);

        builder.setView(v);


        v.findViewById(R.id.publishPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post p = new Post();
                p.setTitle(((EditText)(v.findViewById(R.id.titulopost))).getText().toString());
                p.setDescription(((EditText)(v.findViewById(R.id.descrpost))).getText().toString());
                p.setAuthor(new User("Bruno"));
                mViewModel.addPost(p);
                dismiss();

            }
        });

        return builder.create();
    }
}