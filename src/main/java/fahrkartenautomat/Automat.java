package fahrkartenautomat;

import java.util.Scanner;

public class Automat {

private int position;
private double pricePerZone = 2.3;
private double output;
//private double amountInput;
private Scanner scanner = new Scanner(System.in);

public int getPosition(){
    return position;
}

public void setPosition(int p){
    position = p;
}

/*public double getAmountInput(){
    return amountInput;
}
public void setAmountInput(double am){
    amountInput = am;
}*/
public Scanner getCashInput(){
    return scanner;
}
public void setCashInput(double cashInput) {
        cashInput = scanner.nextDouble();
    }

    public double calculatePrice(int destinationZone){
    output = pricePerZone * (Math.abs(destinationZone - position) + 1);

    return output;
}

/*public double payment() {
    switch (int = i) {
        case 2:
            output = output - 2;

    }
}*/
public double payment(){
    while (output!= 0){
        System.out.println("Please pay the amount of "+output+"€. Only coins!");

        double cash;
        cash = scanner.nextDouble();

if (cash == 2){
    return output = output - 2;
}
else if(cash == 1){
    return output = output - 1;
}
else if(cash == 0.5){
    return output = output - 0.5;
}
else if(cash == 0.2){
    return output = output - 0.2;
}
else if(cash == 0.1){
    return output = output - 0.1;
}
else if(cash == 0.05){
    return output = output - 0.05;
}
else if(cash == 0.02){
    return output = output - 0.02;
}
else if(cash == 0.01){
    return output = output - 0.01;
}
else System.out.println("Error!");
    }
    return output;
}


}
