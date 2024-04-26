package com.example.uts_mobprog.ui.kubus;

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

import com.example.uts_mobprog.databinding.FragmentKubusBinding;
import com.example.uts_mobprog.ui.Geometry;
import com.example.uts_mobprog.ui.Kubus;

public class KubusFragment extends Fragment {

    private FragmentKubusBinding binding;
    private EditText kubusEditText;
    private TextView textView;
    private Button hitungButtonKubus;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        KubusViewModel homeViewModel =
                new ViewModelProvider(this).get(KubusViewModel.class);

        binding = FragmentKubusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        kubusEditText = binding.kubusText;
        textView = binding.TextView2;
        hitungButtonKubus = binding.hitungButtonKubus;

        hitungButtonKubus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sideLengthStr = kubusEditText.getText().toString();
                if (!sideLengthStr.isEmpty()) {
                    double sisi = Double.parseDouble(sideLengthStr);
                    double volume = HitungVolumeKubus(sisi);
                    textView.setText("Volume: " + volume);
                } else {
                    textView.setText("Masukkan panjang sisi kubus terlebih dahulu.");
                }
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    // Method to calculate the volume of the cube
    private double HitungVolumeKubus(double sisi) {
        final Geometry[] geometries = new Geometry[1];
        geometries[0] = new Kubus(sisi);

        // Menghitung volume bola menggunakan method yang telah didefinisikan dalam kelas Geometry
        return geometries[0].calculateVolume();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
