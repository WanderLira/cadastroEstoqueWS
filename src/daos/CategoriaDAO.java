package daos;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import entities.Categoria;

@Repository
public class CategoriaDAO extends AbstractDAO<Categoria> {

	@Override
	public Class<Categoria> entityClass() {
		return Categoria.class;
	}
	
	public List<Categoria> buscar(Categoria filtro){
		String str = "select c from Categoria c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		return query.getResultList();
	}

}

