public interface IArbolAVL<T> {

    NodoArbolAVL<T> search(T element, NodoArbolAVL nodo);
    NodoArbolAVL<T> leftRotation(NodoArbolAVL nodo);
    NodoArbolAVL<T> rightRotation(NodoArbolAVL nodo);
    NodoArbolAVL<T> doubleRightRotation(NodoArbolAVL nodo);
    NodoArbolAVL<T> doubleLeftRotation(NodoArbolAVL nodo);
    void insert(T element);
}
