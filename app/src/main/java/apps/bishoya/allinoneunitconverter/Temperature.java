package apps.bishoya.allinoneunitconverter;

import android.os.Bundle;

public class Temperature  extends converter {
    final double[][] factors={{1,1.8},{0.55555555555555555555555555555556,1}};
    final int C=0;
    final int F=1;
    final int K=2;
    public Temperature() {
        super(new String[] { "Celsius", "Fahrenheit", "Kelvin" });
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
        if (inUnit==outUnit){
            setOutput(String.valueOf(inputValue));
        }else {
            double converted=-1;
            if (inUnit == C) {
                converted = convertFromC(inputValue, outUnit);
            }
            if (inUnit == F) {
                converted = convertFromF(inputValue, outUnit);

            }
            if (inUnit == K) {
                converted = convertFromK(inputValue, outUnit);
            }
            setOutput(String.valueOf(converted));

        }

    }

    private double convertFromK(double inputValue, int outUnit) {
        double converted=inputValue;
        if (outUnit==C){
            converted=inputValue- 273.15;
        }
        if (outUnit==F){
            converted=convertFromC(convertFromK(inputValue,C),F);
        }
        return converted;

    }

    private double convertFromF(double inputValue, int outUnit) {
        double converted=inputValue;
        if (outUnit==C){
            converted=(inputValue-32)*factors[F][C];
        }
        if (outUnit==K){
            converted=convertFromC(convertFromF(inputValue,C),K);
        }
        return converted;
    }

    private double convertFromC(double inputValue, int outUnit) {
        double converted=inputValue;
        if (outUnit==F){
            converted=(inputValue*factors[C][F])+32;
        }
        if (outUnit==K){
            converted=inputValue+273.15;
        }
        return converted;
    }


    private int getUnit(String unit) throws Exception {
        int returnValue;
        switch (unit) {
            case "Celsius":
                returnValue = C;
                break;
            case "Fahrenheit":
                returnValue = F;
                break;
            case "Kelvin":
                returnValue = K;
                break;
            default:
                throw new Exception();
        }
        return returnValue;
    }


}
