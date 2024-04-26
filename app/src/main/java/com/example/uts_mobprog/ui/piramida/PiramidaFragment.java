package com.example.uts_mobprog.ui.piramida;

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

import com.example.uts_mobprog.databinding.FragmentPiramidaBinding;
import com.example.uts_mobprog.ui.Geometry;
import com.example.uts_mobprog.ui.Piramida;

public class PiramidaFragment extends Fragment {

    private FragmentPiramidaBinding binding;
    private EditText num1EditText, num2EditText;
    private TextView textView;
    private Button hitungButtonPiramida;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PiramidaViewModel piramidaViewModel =
                new ViewModelProvider(this).get(PiramidaViewModel.class);

        binding = FragmentPiramidaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        num1EditText = binding.num1EditText;
        num2EditText = binding.num2EditText;
        textView = binding.TextView3;
        hitungButtonPiramida = binding.hitungButtonPiramida;

        hitungButtonPiramida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the EditText fields
                String input1 = num1EditText.getText().toString();
                String input2 = num2EditText.getText().toString();
                if (!input1.isEmpty() && !input2.isEmpty()) {
                    // Convert the inputs to doubles
                    double sisi = Double.parseDouble(input1);
                    double tinggi = Double.parseDouble(input2);

                    // Calculate the volume of the pyramid
                    double volume = HitungVolumePiramida(sisi, tinggi);

                    // Display the result
                    textView.setText("Volume: " + volume);
                } else {
                    // If inputs are empty, display a message
                    textView.setText("Masukkan panjang sisi / diameter dan tinggi piramida terlebih dahulu.");
                }
            }
        });

        piramidaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    // Method to calculate the volume of the pyramid
    private double HitungVolumePiramida(double sisi, double tinggi) {
        final Geometry[] geometries = new Geometry[1];
        geometries[0] = new Piramida(sisi,tinggi);
        return geometries[0].calculateVolume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
