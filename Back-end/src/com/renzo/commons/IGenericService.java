package com.renzo.commons;

import java.io.Serializable;
import java.util.List;

public interface IGenericService <T, ID extends Serializable>{

		T save(T entity);
		T update(T entity);
		void delete(T entity);
		T findById(ID id);
		List<T> findAll();
		void flush();
}
