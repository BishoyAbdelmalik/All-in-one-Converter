package apps.bishoya.allinoneunitconverter;

import android.os.Bundle;

public class Mass  extends converter {
    double[][] factors =
            {
                    {1,1000,1e+6,1e+9,1e+12,2205,35274},
                    {0.001,1,1000,1e+6,1e+9,2.205,35.274},
                    {0.000001,0.001,1,1000,1e+6,0.0022026,0.03527337},
                    {0.000000001,0.000001,0.001,1,1000,2.2046244201837774916665196917053e-6,3.5273368606701940035273368606702e-5},
                    {0.000000000001,0.000000001,0.000001,0.001,1,2.2045855379188712522045855379189e-9,3.5273368606701940035273368606702e-8},
                    {4.5351473922902494331065759637188e-4,0.45351473922902494331065759637188,454,453592,4.536e+8,1,16},
                    {2.8349492544083460906049781708907e-5,0.02834949254408346090604978170891,28.35,28350,2.835e+7,0.0625,1},
            };
    final int MT=0;
    final int KG=1;
    final int G=2;
    final int MilliG=3;
    final int MicroG=4;
    final int Ib=5;
    final int Oz=6;
    public Mass() {
        super(new String[] { "Metric ton","Kilogram","Gram","Milligram","Microgram","Pound","Ounce" });
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
        switch (unit) {
            case "Metric ton":
                returnValue = MT;
                break;
            case "Kilogram":
                returnValue = KG;
                break;
            case "Gram":
                returnValue = G;
                break;
            case "Milligram":
                returnValue = MilliG;
                break;
            case "Microgram":
                returnValue = MicroG;
                break;
            case "Pound":
                returnValue = Ib;
                break;
            case "Ounce":
                returnValue = Oz;
                break;
            default:
                throw new Exception();
        }
        return returnValue;
    }

}
