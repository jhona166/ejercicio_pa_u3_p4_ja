package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto p) {
		this.entityManager.persist(p);

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Producto p) {
		this.entityManager.merge(p);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoBarras(String codigo) {
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT e FROM Producto e Where e.codigoBarra= :datoCodigo", Producto.class);
		myQuery.setParameter("datoCodigo", codigo);

		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigo(String codigo) {
		CriteriaBuilder myCriterial = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> myQuery = myCriterial.createQuery(Producto.class);
		
		
		Root<Producto> myTabla = myQuery.from(Producto.class);
		Predicate predicadoCodigo = myCriterial.equal(myTabla.get("codigoBarra"), codigo);
		
		
		myQuery.select(myTabla).where(predicadoCodigo);
		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();

	}

}
