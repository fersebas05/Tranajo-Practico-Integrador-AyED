package Contenedores;

import Recursos.*;

public abstract class Lista2DLinkedList extends Lista1DLinkedList implements OperacionesCL3{
    
    public void insertar(Object elemento) {
		NodoDoble nodo;
		if (estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(elemento);
		} else{
			if (esMenor(elemento, this.frenteL.getNodoInfo())) {
				//insercion al frente
				this.frenteL = new NodoDoble(elemento, null, this.frenteL);
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL);
			}else{				
				if (esMayor(elemento, this.finalL.getNodoInfo()) || iguales(elemento, this.finalL.getNodoInfo())) {
					//insercion al final
					//Completar!!!
					this.finalL = new NodoDoble(elemento, this.finalL, null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);
				}else{				
					// al medio
					NodoDoble temp = this.frenteL;
					boolean flag = false;
					while (temp.getNextNodo() != null && !flag) {
						if (esMayor(elemento, temp.getNextNodo().getNodoInfo()) || iguales(elemento, temp.getNextNodo().getNodoInfo())) {
							temp = temp.getNextNodo();
						}else{
							flag = true;
						}
					}				
			
					nodo = new NodoDoble(elemento, temp, temp.getNextNodo());
					temp.getNextNodo().setPrevNodo(nodo);
					temp.setNextNodo(nodo);	
				}
			}
		}
		this.ultimo++;
	}	

	
	public abstract boolean iguales(Object elemento1, Object elemento2);
	public abstract boolean esMenor(Object elemento1, Object elemento2);
	public abstract boolean esMayor(Object elemento1, Object elemento2);




}
