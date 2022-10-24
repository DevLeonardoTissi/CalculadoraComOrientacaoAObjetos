//importando biblioteca para escanear o teclado
import java.util.Scanner;



public class Calculadora {
   
    public int valorA; 
    public int valorB;
    public char op;
    private Scanner keyboard;


    //MÉTODOS GET
    public int getvalorA(){
        return valorA;
    }

    public int getvalorB(){
        return valorB;
    }

    public char getop(){
        return op;
    }

    //MÉTODOS SET
    public void setvalorA(int valorA){
        this.valorA = valorA;
    }

    public void setvalorB(int valorB){
        this.valorB = valorB;
    }

    public void setop(char op){
        this.op = op;
    }
    

    //MÉTODO CAPTURA INFOS
    public void capturainfos(){
        keyboard = new Scanner(System.in);
        System.out.println("Digite o primeiro valor");
        valorA = keyboard.nextInt();
        testaValor(valorA);
       
       if (!testaValor(valorA)) {
            while (valorA < -50 || valorA > 50){
                System.out.println("Digite o primeiro valor"); 
                valorA = keyboard.nextInt();
                
            }
        }

        System.out.println("Digite a operação (+  -  *  /)");
       op = keyboard.next().charAt(0);
       testeoperador(op);
       if (!testeoperador(op)){
            while  ((op != '*') && (op != '+') && (op != '-') && (op != '/')){
                System.out.println("Por favor, Digite uma das 4 operações");
                op = keyboard.next().charAt(0);
            }
        }

        

       System.out.println("Digite o segundo valor");
       valorB = keyboard.nextInt();
       testaValor(valorB);
       
       if (!testaValor(valorB)) {
            while (valorB < -50 || valorB > 50){
                System.out.println("Digite o segundo valor"); 
                valorB = keyboard.nextInt();
                
            }
       } 
       
    
    }


                                         
//MÉTODO TESTA VALOR
    private boolean testaValor(int valorx) {
        if (valorx < -50 || valorx > 50){
            return false;
           }else {
            return true;
        }
    }  
    //MÉTODO TESTE OPERADOR
    private boolean testeoperador(char opteste){
        if ((opteste == '*') || (opteste == '+') || (opteste == '-') || (opteste == '/')) {
            return true;
        } else {
            return false;
        }
        
    }

    //MÉTODO PARA SOMAS

    private int soma(){
        
        int resultado = (valorA + valorB);
        return resultado;
    }

    //MÉTODO PARA SUBTRAÇÃO
    private int subtracao(){
        int resultado = valorA - valorB;
        return resultado;
    }

    //MÉTODO PARA DIVISÃO
    private double divisao(){
        int resultado = (valorA / valorB);
        return resultado;
    }

    //MÉTODO PARA MULTIPLICAÇÃO
    private int multiplicacao(){
        int resultado = 0; 
        for (int i=1; i<=valorB; i++){
            resultado = resultado + valorA;
        }
        
        return resultado;
    }
    //MÉTODO CALCULA - TRATANDO O PROBLEMA DA DIVISÃO POR 0
    private double calcula(){
        double resultado =0;
        
      if (op=='+'){
          resultado=soma();
      }else if(op=='-'){
          resultado=subtracao();
      }else if (op=='*'){
          resultado=multiplicacao();
      }else if (op=='/'){
            if ((op=='/') && (valorB ==0)){
            System.out.println("não é possivel fazer divisão com 0");
            return 0;
        }else {
            resultado=divisao();
        }
      }
       
       return resultado;
       
    }
    //MÉTODO MOSTRA
    public void mostra(){
        System.out.println(valorA + " " + op + " " + valorB + ": " + calcula() );
    }

}


