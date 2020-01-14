package co.arum.generic;

public class Gcal{
	
	public <T extends Number> double sum(T t1, T t2){
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		return v1+v2;
	}
}
