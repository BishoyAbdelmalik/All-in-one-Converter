package apps.bishoya.allinoneunitconverter;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class converter extends AppCompatActivity {
    protected String[] s;
    public converter(String[] s ){
        this.s=s;
    }
    protected Spinner inUnit;
    private Spinner outUnit;
    private EditText input;
    private EditText output;

    protected void setSpinnerValues() {
        inUnit = findViewById(R.id.spinner);
        outUnit=findViewById(R.id.spinner2);
        inUnit.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, s));
        outUnit.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, s));
        outUnit.setSelection(1);
    }
    protected  void initializeGUI(){
        input=findViewById(R.id.in);
        output=findViewById(R.id.out);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2){}
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>0){
                    convert(Double.parseDouble(s.toString()));
                }else{
                    setOutput("");
                }
            }
        });

        inUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String s=String.valueOf(input.getText());
                if (s.length()>0) {
                    convert(Double.parseDouble(s));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        outUnit.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String s=String.valueOf(input.getText());
                if (s.length()>0) {
                    convert(Double.parseDouble(s));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        output.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("conversion output", output.getText().toString());
                clipboard.setPrimaryClip(clip);

                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), "Output copied to clipboard", duration);
                toast.show();
            }
        });
        ImageButton arrow =findViewById(R.id.imageButton);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int outputUnit=outUnit.getSelectedItemPosition();
                int inputUnit=inUnit.getSelectedItemPosition();
                inUnit.setSelection(outputUnit);
                outUnit.setSelection(inputUnit);
            }
        });

    }

    protected  void setOutput(String s){
        output.setText(s);
    }
    protected String getInUnit(){
        return inUnit.getSelectedItem().toString();
    }
    protected String getOutUnit(){
        return outUnit.getSelectedItem().toString();
    }
    abstract void convert(double inputValue);



}
