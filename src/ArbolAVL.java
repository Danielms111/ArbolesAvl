import org.w3c.dom.Node;

public class ArbolAVL<T> implements IArbolAVL{
    private NodoArbolAVL root;

    public ArbolAVL(NodoArbolAVL<T> root) {
        this.root = null;
    }

    @Override
    public NodoArbolAVL search(Object element, NodoArbolAVL c){
        if(root == null){
            return null;
        } else if ((int)c.getElemento()==(int)element){
            return c;
        } else if ((int)c.getElemento()<(int)element) {
            return search(element, c.getRight());
        }else{
            return search(element, c.getLeft());
        }
    }
    public int getFE(NodoArbolAVL c){
        if(c==null){
            return -1;
        }else{
            return c.getFactorEquilibrio();
        }
    }

    @Override
    public NodoArbolAVL leftRotation(NodoArbolAVL c){
        NodoArbolAVL aux = c.getLeft();
        c.setLeft(aux.getRight());
        aux.setRight(c);
        c.setFactorEquilibrio(Math.max(getFE(c.getLeft()), getFE(c.getRight())+1));
        aux.setFactorEquilibrio(Math.max(getFE(aux.getLeft()), getFE(aux.getRight())+1));
        return aux;
    }

    @Override
    public NodoArbolAVL rightRotation(NodoArbolAVL c){
        NodoArbolAVL aux = c.getRight();
        c.setRight(aux.getLeft());
        aux.setLeft(c);
        c.setFactorEquilibrio(Math.max(getFE(c.getLeft()), getFE(c.getRight())+1));
        aux.setFactorEquilibrio(Math.max(getFE(aux.getLeft()), getFE(aux.getRight())+1));
        return aux;
    }

    @Override
    public NodoArbolAVL doubleRightRotation (NodoArbolAVL c){
        NodoArbolAVL temp;
        c.setLeft(rightRotation(c.getLeft()));
        temp=leftRotation(c);
        return temp;
    }

    @Override
    public NodoArbolAVL doubleLeftRotation(NodoArbolAVL c){
        NodoArbolAVL temp;
        c.setRight(leftRotation(c.getRight()));
        temp=rightRotation(c);
        return temp;
    }

    public NodoArbolAVL insertBalanceado(NodoArbolAVL c, NodoArbolAVL sub){
        NodoArbolAVL nuevoPadre = sub;
        if((int)c.getElemento()<(int)sub.getElemento()){
            if (sub.getLeft()==null){
                sub.setLeft(c);
            }else{
                sub.setLeft(insertBalanceado(c,sub.getLeft()));
                if ((getFE(sub.getLeft())-getFE(sub.getRight())) == 2){
                    if ((int)c.getElemento()<(int)sub.getLeft().getElemento()){
                        nuevoPadre = leftRotation(sub);
                    }else{
                        nuevoPadre = doubleLeftRotation(sub);
                    }
                }
            }
        } else if ((int)c.getElemento()>(int)sub.getElemento()) {
            if (sub.getRight()==null){
                sub.setRight(c);
            }else{
                sub.setRight(insertBalanceado(c, sub.getRight()));
                if ((getFE(sub.getRight())-getFE(sub.getLeft())) ==2){
                    if ((int)c.getElemento()>(int)sub.getRight().getElemento()){
                        nuevoPadre = rightRotation(sub);
                    }else{
                        nuevoPadre = doubleRightRotation(sub);
                    }
                }
            }
        }else{
            System.out.println("NODO DUPLICADO");
        }
        if ((sub.getLeft()==null && (sub.getRight()!=null))){
            sub.setFactorEquilibrio(sub.getRight().getFactorEquilibrio()+1);
        }else if(sub.getRight()==null && sub.getLeft()!=null){
            sub.setFactorEquilibrio(sub.getLeft().getFactorEquilibrio()+1);
        }else{
            sub.setFactorEquilibrio((Math.max(getFE(sub.getLeft()), getFE(sub.getRight()))) +1);
        }
        return nuevoPadre;
    }

    @Override
    public void insert(Object element){
        NodoArbolAVL c = new NodoArbolAVL(element);
        if(root==null){
            root=c;
        }else{
            root=insertBalanceado(c, root);
        }
    }
    public boolean isEmpty(){
        return root==null;
    }

    public NodoArbolAVL delete(int goal){
        return delete(goal, root);
    }

    private NodoArbolAVL delete(int goal, NodoArbolAVL current){
        if(current == null){
            return null;
        }
        if((int)current.getElemento() == (int)goal){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                NodoArbolAVL min = getMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.setElemento(min.getElemento());
                //Hacer eliminación a partir de la derecha
                NodoArbolAVL subarbolDER = delete((int)min.getElemento(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(goal < (int)current.getElemento()){
            NodoArbolAVL subArbolIzquierdo = delete(goal, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            NodoArbolAVL subArbolDerecho = delete(goal, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }

    public NodoArbolAVL getMin(NodoArbolAVL current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }


    /*public NodoArbolAVL delete(){

    }*/

}
