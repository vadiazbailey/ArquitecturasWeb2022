package repository;

public interface JPARepository<T> {
	
	public void save(T t);
	
}
