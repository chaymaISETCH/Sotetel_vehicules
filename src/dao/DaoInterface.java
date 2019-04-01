package dao;

import java.util.List;

public interface DaoInterface<T> {

	public int supp(T t);
	public int mod (T t);
	public int ajout (T t);
	public List<T> liste();
	
	
	
}
