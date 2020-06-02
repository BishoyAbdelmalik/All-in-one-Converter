package apps.bishoya.allinoneunitconverter;

import android.os.Bundle;

public class Length extends converter {
    double[][] factors =
            {
                    {1,1000,100000,1e+6,1e+9,1e+12,0.621371,1093.61,3280.83,39370},
                    {0.001,1,100,1000,1e+6,1e+9,0.000621371,1.09361,3.281,39.37},
                    {1e-5,0.01,1,10,10000,1e+7,6.2137e-6,0.0109361,0.0328084,0.393701},
                    {1e-6,0.001,0.1,1,1000,1e+6,6.2137e-7,0.00109361,0.00328084,0.0393701},
                    {1e-9,1e-6,1e-4,0.001,1,1000,6.2137e-10,1.0936e-6,3.2808e-6,3.937e-5},
                    {1e-12,1e-9,1e-7,1e-6,0.001,1,6.2137e-13,1.0936e-9,3.2808e-9,3.937e-8},
                    {1.609,1609,160934,1.609e+6,1.609e+9,1.609e+12,1,1760,5280,63360},
                    {0.0009144,0.9144,91.44,914.4,914400,9.144e+8,0.000568182,1,3,36},
                    {0.0003048,0.3048,30.48,304.8,304800,3.048e+8,0.000189394,0.333333,1,12},
                    {2.54e-5,0.0254,2.54,25.4,25400,2.54e+7,1.5783e-5,0.0277778,0.0833333,1},
            };
    final int KM=0;
    final int M=1;
    final int CM=2;
    final int MilliM=3;
    final int MicroM=4;
    final int NanoM=5;
    final int Mile=6;
    final int Yard=7;
    final int Foot=8;
    final int In=9;

    public Length() {
        super(new String[] { "Kilometer","Meter","Centimeter","Millimeter","Micrometer","Nanometer","Mile","Yard","Foot","Inch" });
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
        if (unit.equals("Kilometer")){
            returnValue=KM;
        }else if (unit.equals("Meter")){
            returnValue=M;
        }else if (unit.equals("Centimeter")){
            returnValue=CM;
        }else if (unit.equals("Millimeter")){
            returnValue=MilliM;
        }else if (unit.equals("Micrometer")){
            returnValue=MicroM;
        }else if (unit.equals("Nanometer")){
            returnValue=NanoM;
        }else if (unit.equals("Mile")){
            returnValue=Mile;
        }else if (unit.equals("Yard")){
            returnValue=Yard;
        }else if (unit.equals("Foot")){
            returnValue=Foot;
        }else if (unit.equals("Inch")){
            returnValue=In;
        }
        else{
            throw new Exception();
        }
        return returnValue;
    }

}
