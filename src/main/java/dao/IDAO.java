package dao;

import java.util.List;
public interface IDAO<T> {
	public T pesquisar(String nome);
	public void inserir(T t);
	public void atualizar(T t);
	public void remover (long id);
	public List<T> listar(); 
	public List<T> apenasUm(String nome);
}
