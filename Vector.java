public class Vector {
    private final int dim;
    private final double[] data;

    public Vector(int dim, double[] elements) {
        this.dim = dim;
        this.data = new double[dim];
        
        for (int i = 0; i < dim; i++) {
            data[i] = elements[i];
        }
    }

    public double get(int i) {
        return data[i];
    }

    public void set(int i, double value) {
        data[i] = value;
    }

    public int getDim() {
        return dim;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < dim; i++) {
            System.out.print(data[i]);
            if (i < dim - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}