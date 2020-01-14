package co.arum.generic;

public class GenericTest<E> {
	private E t;
	
	public E get() {
		return t;
	}
	public void set(E t) {
		this.t = t;
	}
}
