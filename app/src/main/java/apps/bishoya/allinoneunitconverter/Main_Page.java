package apps.bishoya.allinoneunitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        final Button tempBtn = (Button)this.findViewById(R.id.tempBtn);
        final Button areaBtn = (Button)this.findViewById(R.id.areaBtn);
        final Button digitalStorageBtn = (Button)this.findViewById(R.id.digitalStorageBtn);
        final Button lengthBtn = (Button)this.findViewById(R.id.lengthBtn);
        final Button massBtn = (Button)this.findViewById(R.id.massBtn);
        final Button timeBtn = (Button)this.findViewById(R.id.timeBtn);
        final Button volumeBtn = (Button)this.findViewById(R.id.volumeBtn);
        tempBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Page.this.getApplicationContext(),Temperature.class));
                overridePendingTransition(R.anim.in, R.anim.out);

            }
        });
        massBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Page.this.getApplicationContext(),Mass.class));
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });
        lengthBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Page.this.getApplicationContext(),Length.class));
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });
        volumeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main_Page.this.getApplicationContext(),Volume.class));
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });

    }
}
