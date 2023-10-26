package sample;

public class ForeCast {

    public int[]Fecth_forecast()
    {
        int max=4;
        int min=1;

        // int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        int []a=new int[5];
        a[1]= (int)Math.floor(Math.random()*(max-min+1)+min);
        a[0]=  (int)Math.floor(Math.random()*(max-min+1)+min);
        a[2]= (int) Math.floor(Math.random()*(max-min+1)+min);
        a[3]= (int) Math.floor(Math.random()*(max-min+1)+min);
        a[4]= (int) Math.floor(Math.random()*(max-min+1)+min);
        return a;
    }

    public static double[]Fecth_Daily()
    {
        double max=2.9;
        double min=1.1;

        // int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        double []a=new double[6];
        a[1]= Math.floor(Math.random()*(max-min+1)+min);
        a[0]=  Math.floor(Math.random()*(max-min+1)+min);
        a[2]=  Math.floor(Math.random()*(max-min+1)+min);
        a[3]=  Math.floor(Math.random()*(max-min+1)+min);
        a[4]=  Math.floor(Math.random()*(max-min+1)+min);
        a[5]=Math.floor(Math.random()*(max-min+1)*min);

        return a;
    }
}
