package apps.bishoya.allinoneunitconverter;

import android.os.Bundle;

public class Volume extends converter {
    double[][] factors =
            {
                    {1,1000,1e+6,219.969},
                    {0.001,1,1000,0.219969},
                    {1e-6,0.001,1,0.000219969},
                    {0.00454609,4.54609,4546.09,1},


            };
    final int M3=0;
    final int L=1;
    final int ML=2;
    final int G=3;


    public Volume() {
        super(new String[] { "Cubic meter","Liter","Milliliter","Imperial gallon"});
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter);
        setSpinnerValues();
        initializeGUI();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in, R.anim.out);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in, R.anim.out);
    }

    @Override
    protected void convert(double inputValue) {
        int inUnit = 0;
        int outUnit=0;
        try {
            inUnit=getUnit(getInUnit());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outUnit=getUnit(getOutUnit());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOutput(String.valueOf(inputValue*factors[inUnit][outUnit]));

    }



    private int getUnit(String unit) throws Exception {
        int returnValue;
        if (unit.equals("Cubic meter")){
            returnValue=M3;
        }else if (unit.equals("Liter")){
            returnValue=L;
        }else if (unit.equals("Milliliter")){
            returnValue=ML;
        }else if (unit.equals("Imperial gallon")){
            returnValue=G;
        }
        else{
            throw new Exception();
        }
        return returnValue;
    }

}
