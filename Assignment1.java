import java.lang.Math;
import java.util.Scanner;




class Complex{
private double real,img;
Complex(){
    real = 0;
    img = 0;
}
//Setting the real part of complex no
public void setReal(double real) {
    this.real = real;
}

//Setting the imaginary part of complex no
public void setImg(double img) {
    this.img = img;
}

//Method to add two complex no
public void sum(Complex C)
{
    double RealPart,ImgPart;//Local variable Not to confuse with attributes real img
    RealPart = this.real + C.real;
    ImgPart = this.img + C.img;
    if(ImgPart<0)//for printing '-' instead of '+' in output
    {
        System.out.println(RealPart+""+ImgPart+"i");

    }
    else{
        System.out.println(RealPart+" + "+ImgPart+"i");  ;
    }
}

//Method to subtract two complex numbers.
public void Subtract(Complex C)
{
    double RealPart,ImgPart;//Local variable Not to confuse with attributes real img
    RealPart = this.real - C.real;
    ImgPart = this.real - C.real;
    if(ImgPart<0)
    {
        System.out.println(RealPart+""+ImgPart+"i");
    }
    else
    {
        System.out.println(RealPart+"+ "+ImgPart+"i");
    }
}

//for Multiplying two complex number
public void Multiply(Complex C)
{
    double RealPart,ImgPart;
    RealPart  = this.real*C.real - this.img*C.img;
    ImgPart = this.real*C.img + this.img*C.real;

    if(ImgPart<0)
    {
        System.out.println(RealPart+" "+ImgPart+"i");
    }
    else
    {
        System.out.println(RealPart+"+ "+ImgPart+"i");
    }

}

private Complex Multiply(Complex C,Complex D)
{
    Complex ans = new Complex();
    ans.real = C.real*D.real - C.img*D.img;
    ans.img =  C.real*D.img + D.img*D.real;

    return ans;
}

// Method for division
public void Division(Complex C)
{
    Complex conjugate = Conjugate(C);
    Complex multiplication_with_conjugate = Multiply(this,conjugate);
    /**
     * Multiplication_with_conjugate is the object which is result of multiplying
     * the implicitly  passed object and explicitly passed object
     */
    if(Modulus(conjugate) == 0)
    {
        System.out.println("Divisor is Zero!!!!");
        
    }
    else{
        multiplication_with_conjugate.real /= Modulus(conjugate);
        multiplication_with_conjugate.img /= Modulus(conjugate);



        if(multiplication_with_conjugate.img<0)
        {
            System.out.printf("%.2f %.2f\n",multiplication_with_conjugate.real,multiplication_with_conjugate.img);
        }
    else
    {
        System.out.println(multiplication_with_conjugate.real+"+ "+multiplication_with_conjugate.img+"i");
    }

    }
    

    /******************************************************************************
    conjugate (small c) is the conjugate of object C
    Divison is calculated as multiplying "this" complex no with the conjugate of 
    Object C whole divided by the modulus of object C
    Explained with an example below

    *******************************************************************************
      Muliplication method is overloaded one is private and other is public
    ********************************************************************************  
    
    */

       

    

}
    /******************************************************************************
     * 
     * 
     * DIVISION EXAMPLE
     * C1 = a + bi
     * C2 = c + di
     * Ans = C1/C2 = (a+bi)/(c+di)
     * In Ans Multiplying Numerator and Denominator with conjugate of C2
     * 
     *Ans = (ac+bd)/(c^2 + d^2) + i(bc - ad)/(c^2 + d^2)
     * 
     * 
     * 
     ***********************************************************************************/


//Method for calculating modulus
public double Modulus(Complex C)
{
    return Math.sqrt(Math.pow(C.real,2) + Math.pow(C.img,2));
}

private Complex Conjugate(Complex C)
{
    Complex conj = new Complex();
    conj.real = C.real;
    conj.img = -C.img;
    return conj;
}


};


public class Assignment1 {
public static void main(String[] args)   
 {
Scanner sc = new Scanner(System.in);

System.out.println("Enter the Real and Imaginary Part of first complex number");
Complex C1 = new Complex();//creating object

/**
 * Taking input for object C1
 */

System.out.print("Real:- ");
C1.setReal(sc.nextDouble());
System.out.print("Imaginary :- ");
C1.setImg(sc.nextDouble());


Complex C2 = new Complex();//Creating object
System.out.println("Enter the Real and Imaginary Part of  second complex number");

/**
 * Taking input for object C2
 */

System.out.print("Real:- ");
C2.setReal(sc.nextDouble());
System.out.print("Imaginary :- ");
C2.setImg(sc.nextDouble());

int choice = 0;
while(choice!=6)
{
    System.out.println("Enter:-\n1 To reset the no's\n2 to perform addition\n3 To perform subtraction");
    System.out.println("4 To perform Multiplicaton \n5 to perform division\n6 To end the program");
    choice = sc.nextInt();

    switch(choice)
    {
        case 1:
        //C1
        System.out.println("Enter the Real and Imaginary Part of  second complex number");

        System.out.print("Real:- ");
        C1.setReal(sc.nextDouble());
        System.out.print("\nImaginary :- ");
        C1.setImg(sc.nextDouble());

        //C2
        System.out.println("Enter the Real and Imaginary Part of  second complex number");
        System.out.print("Real:- ");
        C2.setReal(sc.nextDouble());
        System.out.print("\nImaginary :- ");
        C2.setImg(sc.nextDouble());


        break;

        case 2:
        C1.sum(C2);
        break;

        case 3:
         int input;
         System.out.println("Enter\n1 to perform C1 - C2\n2 to perform C2 - C1");
         input = sc.nextInt();
         if(input == 1)
         {
             C1.Subtract(C2);

         }
         else
         {
             C2.Subtract(C1);
         }
        break;

        case 4:
        C1.Multiply(C2);
        break;

        case 5:
        System.out.println("Enter\n1 to perform C1/C2\n2 to perform C2/C1");
        input = sc.nextInt();
        if(input == 1)
         {
             C1.Division(C2);

         }
         else
         {
             C2.Division(C1);
         }
        break;

        case 6:
        System.out.println("THE END!!!");
        break;

        default:
        System.out.println("Invalid Choice!");
        break;



    }

}

sc.close();
 }
 
}
