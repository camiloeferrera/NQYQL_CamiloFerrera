import java.util.Scanner;

class Main {
  public static Scanner entrada = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    int n = 0, m = 0;
    int valid = 1;
    while(valid == 1){
      System.out.println("Ingrese el tamaño N(par): ");
      n = entrada.nextInt();
      if(n%2!=0){
        System.out.println("N debe ser par");
      }else{
        valid = 2;
      }
    }
    while(valid==2){
      System.out.println("Ingrese el tamaño M(impar)");
      m = entrada.nextInt();
      if(m%2==0 && n>m){
        System.out.println("M debe ser impar y menor a N");
      }else{
        valid = 3;
      }
    }
    System.out.println("Ingrese los valores del primer arreglo: ");
    int[] arreglo1 = Lectura(n);
    System.out.println("Ingrese los valores del segundo arreglo: ");
    int[] arreglo2 = Lectura(m);
    System.out.print("Arreglo N: ");
    Imprimir(arreglo1);
    System.out.print("Arreglo M: ");
    Imprimir(arreglo2);
    int[] ordenado = Intercalado(arreglo1, arreglo2);
    System.out.print("Arreglo Resultante: ");
    Imprimir(ordenado);
  }

  public static int[] Lectura(int size){
    int [] temporal = new int [size];
    for(int i = 0; i< size; i++){
      temporal[i] = entrada.nextInt();
    }

    return temporal;
  }

  public static void Imprimir(int[] x){
    for(int i = 0; i< x.length; i++){
      System.out.print(x[i]);
    }
    System.out.println();
  }

  public static int [] Intercalado(int[] a1, int [] a2){
    int totalLength = a1.length + a2.length;
    int[] ordenado = new int [totalLength];


    int primeraSeccion = ( (totalLength - 1 ) / 2) - (a2.length - 1);

    int segundaSeccion = ( totalLength ) - primeraSeccion;

    int contA1 = 0;
    int contA2 = 0;

    for(int i = 0; i < primeraSeccion; i++){
      ordenado[i] = a1[contA1];
      contA1++;
    }

    boolean intercalado = true;
    for(int i = primeraSeccion; i < segundaSeccion; i++){
      
      if(intercalado){
        ordenado[i] = a2[contA2];
        contA2++;
      }else{
        ordenado[i] = a1[contA1];
        contA1++;
      }
      intercalado = !intercalado;
    }

    for(int i = segundaSeccion; i < totalLength ; i++){
      ordenado[i] = a1[contA1];
      contA1++;
    }

    return ordenado;
  }

}
