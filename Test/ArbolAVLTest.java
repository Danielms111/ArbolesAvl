import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolAVLTest {
    private NodoArbolAVL root;
    private ArbolAVL arbol = new ArbolAVL(root);
    private void setUp1(){
        root=null;
    }
    private void setUp2(){
        root=null;
        arbol.insert(2);
        arbol.insert(3);
    }

    private void setUp3(){
        root=null;
        arbol.insert(1);
        arbol.insert(5);
        arbol.insert(12);
        arbol.insert(15);
        arbol.insert(4);
    }

    @Test
    public void insertTest1(){
        setUp2();
        assertEquals(arbol.search(3, new NodoArbolAVL<>(3)).getElemento(), 3);
    }

    @Test
    public void insertTest2(){
        setUp1();
        arbol.insert(1);
        assertFalse(arbol.isEmpty());
    }

    @Test
    public void insetTest3(){
        setUp1();
        arbol.insert(45);
        assertEquals(arbol.search(45, new NodoArbolAVL<>(45)).getElemento(), 45);

    }

    @Test
    public void deleteTest1(){
        setUp2();
        assertEquals(arbol.delete(1).getElemento(),2);
    }

    @Test
    public void deleteTest2(){
        setUp1();
        arbol.insert(1);
        arbol.delete(1);
        assertTrue(arbol.isEmpty());
    }

    @Test
    public void deleteTest3(){
        setUp3();
        arbol.delete(1);
        arbol.delete(5);
        arbol.delete(12);
        arbol.delete(4);
        arbol.delete(15);
        assertTrue(arbol.isEmpty());
    }

}