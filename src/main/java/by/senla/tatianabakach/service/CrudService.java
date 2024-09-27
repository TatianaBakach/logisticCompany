package by.senla.tatianabakach.service;

import by.senla.tatianabakach.dto.BaseDTO;
import org.springframework.data.domain.Page;

public interface CrudService<D extends BaseDTO>{

    D getById(Integer id);

    D save(D d);

    void delete(Integer id);

    D update(Integer id, D e);

    Page<D> findAll(Integer pageNumber, String sortField, String sortDirection);

}
