public class Calculation {


    public long Factorial (double number){

        int i = 1;
        long factorial = 1;
        while(i <= number)
        {
            factorial *= i;
            i++;
        }
        return factorial;
    }


}
