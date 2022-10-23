public class NodoArbolAVL <T>
{
    private T elemento;
    private NodoArbolAVL left;
    private NodoArbolAVL right;

    private int factorEquilibrio;

    // Constructores
    public NodoArbolAVL( T elemento){
        this.elemento = elemento;
        this.left = null;
        this.right = null;
        factorEquilibrio = 0;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArbolAVL getLeft() {
        return left;
    }

    public void setLeft(NodoArbolAVL left) {
        this.left = left;
    }

    public NodoArbolAVL getRight() {
        return right;
    }

    public void setRight(NodoArbolAVL right) {
        this.right = right;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }
}
