import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LinearAlgebra la = new LinearAlgebra();
        
        int opcao;
        
        do {
            System.out.println("\n======================================");
            System.out.println("=== ÁLGEBRA LINEAR COMPUTACIONAL ===");
            System.out.println("======================================");
            System.out.println("1. Operações com Matrizes");
            System.out.println("2. Operações com Vetores");
            System.out.println("3. Eliminação Gaussiana");
            System.out.println("4. Resolver Sistema Linear");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch(opcao) {
                case 1:
                    menuMatrizes(scanner, la);
                    break;
                case 2:
                    menuVetores(scanner, la);
                    break;
                case 3:
                    menuGauss(scanner, la);
                    break;
                case 4:
                    menuSistema(scanner, la);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while(opcao != 0);
        
        scanner.close();
    }
    
    public static void menuMatrizes(final Scanner scanner, final LinearAlgebra la) {
        System.out.println("\n--- OPERAÇÕES COM MATRIZES ---");
        System.out.println("1. Transposição");
        System.out.println("2. Soma de matrizes");
        System.out.println("3. Multiplicação por escalar");
        System.out.println("4. Multiplicação elemento a elemento");
        System.out.println("5. Multiplicação de matrizes (produto)");
        System.out.print("Escolha: ");
        
        final int op = scanner.nextInt();
        
        switch(op) {
            case 1:
                // Transposição
                final Matrix A = la.lerMatriz(scanner, "Matriz A");
                System.out.println("\nMatriz original:");
                A.print();
                
                final Matrix At = la.transpose(A);
                System.out.println("\nMatriz transposta:");
                At.print();
                break;
                
            case 2:
                // Soma de matrizes
                final Matrix A1 = la.lerMatriz(scanner, "Matriz A");
                final Matrix B1 = la.lerMatriz(scanner, "Matriz B");
                
                System.out.println("\nMatriz A:");
                A1.print();
                System.out.println("\nMatriz B:");
                B1.print();
                
                final Matrix C1 = la.sum(A1, B1);
                if (C1 != null) {
                    System.out.println("\nA + B =");
                    C1.print();
                }
                break;
                
            case 3:
                // Multiplicação por escalar
                final Matrix A2 = la.lerMatriz(scanner, "Matriz");
                System.out.print("Digite o valor do escalar: ");
                final double escalar = scanner.nextDouble();
                
                System.out.println("\nMatriz original:");
                A2.print();
                
                final Matrix D = la.times(escalar, A2);
                System.out.println("\n" + escalar + " * Matriz =");
                D.print();
                break;
                
            case 4:
                // Multiplicação elemento a elemento
                final Matrix A3 = la.lerMatriz(scanner, "Matriz A");
                final Matrix B3 = la.lerMatriz(scanner, "Matriz B");
                
                System.out.println("\nMatriz A:");
                A3.print();
                System.out.println("\nMatriz B:");
                B3.print();
                
                final Matrix E = la.times(A3, B3);
                if (E != null) {
                    System.out.println("\nA .* B =");
                    E.print();
                }
                break;
                
            case 5:
                // Multiplicação de matrizes
                final Matrix A4 = la.lerMatriz(scanner, "Matriz A");
                final Matrix B4 = la.lerMatriz(scanner, "Matriz B");
                
                System.out.println("\nMatriz A:");
                A4.print();
                System.out.println("\nMatriz B:");
                B4.print();
                
                final Matrix F = la.dot(A4, B4);
                if (F != null) {
                    System.out.println("\nA * B =");
                    F.print();
                }
                break;
                
            default:
                System.out.println("Opção inválida!");
        }
    }
    
    public static void menuVetores(final Scanner scanner, final LinearAlgebra la) {
        System.out.println("\n--- OPERAÇÕES COM VETORES ---");
        System.out.println("1. Transposição (vetor -> matriz)");
        System.out.println("2. Soma de vetores");
        System.out.println("3. Multiplicação por escalar");
        System.out.println("4. Multiplicação elemento a elemento");
        System.out.print("Escolha: ");
        
        final int op = scanner.nextInt();
        
        switch(op) {
            case 1:
                // Transposição de vetor
                final Vector v = la.lerVetor(scanner, "Vetor");
                System.out.print("\nVetor original: ");
                v.print();
                
                final Matrix vt = la.transpose(v);
                System.out.println("\nVetor como matriz coluna:");
                vt.print();
                break;
                
            case 2:
                // Soma de vetores
                final Vector v1 = la.lerVetor(scanner, "Vetor A");
                final Vector v2 = la.lerVetor(scanner, "Vetor B");
                
                System.out.print("\nVetor A: ");
                v1.print();
                System.out.print("Vetor B: ");
                v2.print();
                
                final Vector v3 = la.sum(v1, v2);
                if (v3 != null) {
                    System.out.print("A + B = ");
                    v3.print();
                }
                break;
                
            case 3:
                // Multiplicação por escalar
                final Vector v4 = la.lerVetor(scanner, "Vetor");
                System.out.print("Digite o valor do escalar: ");
                final double escalar = scanner.nextDouble();
                
                System.out.print("\nVetor original: ");
                v4.print();
                
                final Vector v5 = la.times(escalar, v4);
                System.out.print(escalar + " * Vetor = ");
                v5.print();
                break;
                
            case 4:
                // Multiplicação elemento a elemento
                final Vector v6 = la.lerVetor(scanner, "Vetor A");
                final Vector v7 = la.lerVetor(scanner, "Vetor B");
                
                System.out.print("\nVetor A: ");
                v6.print();
                System.out.print("Vetor B: ");
                v7.print();
                
                final Vector v8 = la.times(v6, v7);
                if (v8 != null) {
                    System.out.print("A .* B = ");
                    v8.print();
                }
                break;
                
            default:
                System.out.println("Opção inválida!");
        }
    }
    
    public static void menuGauss(final Scanner scanner, final LinearAlgebra la) {
        System.out.println("\n--- ELIMINAÇÃO GAUSSIANA ---");
        System.out.println("Digite a matriz para aplicar eliminação Gaussiana:");
        
        final Matrix A = la.lerMatriz(scanner, "Matriz");
        
        System.out.println("\nMatriz original:");
        A.print();
        
        final Matrix resultado = la.gauss(A);
        System.out.println("\nMatriz após eliminação Gaussiana:");
        resultado.print();
    }
    
    public static void menuSistema(final Scanner scanner, final LinearAlgebra la) {
        System.out.println("\n--- RESOLVER SISTEMA LINEAR ---");
        System.out.println("Digite a matriz aumentada do sistema [A | b]:");
        System.out.println("Exemplo para 3 equações: matriz 3x4 (3 linhas, 4 colunas)");
        
        final Matrix sistema = la.lerMatriz(scanner, "Matriz aumentada");
        
        System.out.println("\nSistema original:");
        sistema.print();
        
        final Matrix solucao = la.solve(sistema);
        System.out.println("\nMatriz após Gauss-Jordan:");
        solucao.print();
        
        // Mostrar a solução de forma mais clara
        System.out.println("\nSolução do sistema:");
        for (int i = 0; i < sistema.getRows(); i++) {
            // Verificar se a linha tem um pivô (1 na diagonal)
            if (Math.abs(solucao.get(i, i) - 1.0) < 0.0001) {
                // Verificar se os outros coeficientes são zero
                boolean linhaValida = true;
                for (int j = 0; j < sistema.getRows(); j++) {
                    if (j != i && Math.abs(solucao.get(i, j)) > 0.0001) {
                        linhaValida = false;
                        break;
                    }
                }
                if (linhaValida) {
                    final char variavel = (char)('x' + i);
                    System.out.println(variavel + " = " + solucao.get(i, sistema.getCols() - 1));
                }
            }
        }
    }
}