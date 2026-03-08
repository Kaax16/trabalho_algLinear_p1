public class Matrix {
    private int linhas;
    private int colunas;
    private double[][] data;

    public Matrix (int linhas, int colunas, double[] elements){
        this.colunas = colunas;
        this.linhas = linhas;
        this.data = new double[linhas][colunas];

        int index = 0;

        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                data[i][j] = elements[index];
                index++;

            }
        }

    }

    public double get(int i, int j){
        return data[i][j];

    }

    public void set (int i, int j, double value) {
        data[i][j] = value;

    }

    public void getLinhas(int linha){
        return data[i] = linha;
    }

}