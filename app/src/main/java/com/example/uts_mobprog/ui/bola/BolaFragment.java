package com.example.uts_mobprog.ui.bola;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uts_mobprog.databinding.FragmentBolaBinding;
import com.example.uts_mobprog.ui.*;



public class BolaFragment extends Fragment {

    private FragmentBolaBinding binding;
    private EditText bolaEditText;
    private TextView textView;
    private Button hitungButtonBola;
    private Double result;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BolaViewModel dashboardViewModel =
                new ViewModelProvider(this).get(BolaViewModel.class);

        binding = FragmentBolaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bolaEditText = binding.bolaEditText;
        textView = binding.TextView1;
        hitungButtonBola = binding.hitungButtonBola;

        hitungButtonBola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diameterStr = bolaEditText.getText().toString();
                if (!diameterStr.isEmpty()) {
                    double diameter = Double.parseDouble(diameterStr);
                    double volume = hitungVolumeBola(diameter);
                    textView.setText("Volume: " + volume);
                } else {
                    textView.setText("Masukkan diameter bola terlebih dahulu.");
                }
            }
        });

        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    private double hitungVolumeBola(double diameter) {
        final Geometry[] geometries = new Geometry[1];
        geometries[0] = new Bola(diameter);
        return geometries[0].calculateVolume();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
