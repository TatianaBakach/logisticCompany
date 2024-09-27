package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.BaseDTO;
import by.senla.tatianabakach.entity.BaseEntity;
import by.senla.tatianabakach.exception.EntityNotFoundException;
import by.senla.tatianabakach.exception.SaveEntityException;
import by.senla.tatianabakach.mapper.BaseMapper;
import by.senla.tatianabakach.repository.BaseRepository;
import by.senla.tatianabakach.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Slf4j
@Transactional(readOnly = true)
public abstract class CrudServiceImpl<E extends BaseEntity, D extends BaseDTO,
        M extends BaseMapper<E, D>, R extends BaseRepository<E>> implements CrudService<D> {

    final R repository;

    final Class<E> genericType;

    final M mapper;

    protected CrudServiceImpl(R repository, M mapper, Class<E> genericType) {
        this.repository = repository;
        this.genericType = genericType;
        this.mapper = mapper;
        //HashSet
    }

    @Override
    @Transactional
    public D save(D d) {
        try {
            D save = mapper.toDto(repository.save(mapper.toEntity(d)));
            log.info(this.genericType.getSimpleName() + " save");
            return save;
        } catch (Exception ex) {
            log.error(this.genericType.getSimpleName() + " don't save");
            throw new SaveEntityException(this.genericType.getSimpleName());
        }
    }

    @Override
    public D getById(Integer id) {
        Optional<E> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            log.info(this.genericType.getSimpleName() + " get, id: " + id);
            return mapper.toDto(entity.get());
        }
        log.error(this.genericType.getSimpleName() + " don't get, id: " + id);
        throw new EntityNotFoundException(this.genericType.getSimpleName());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        try {
            this.repository.deleteById(id);
            log.info(this.genericType.getSimpleName() + " delete, id: " + id);
        } catch (Exception ex) {
            log.error(this.genericType.getSimpleName() + " don't delete, id: " + id
                    + " Error message: " + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public D update(Integer id, D d) {
        mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(this.genericType.getSimpleName())));
        try {
            d.setId(id);
            this.repository.save(mapper.toEntity(d));
            log.info(this.genericType.getSimpleName() + " update");
            return d;
        } catch (Exception ex) {
            log.error(this.genericType.getSimpleName() + " don't update");
            throw new SaveEntityException(this.genericType.getSimpleName());
        }
    }

    @Override
    public Page<D> findAll(Integer pageNumber, String sortField, String sortDirection) {
        Pageable pageable = findAllWithPagination(pageNumber, sortField, sortDirection);
        Page<D> all = repository.findAll(pageable).map(mapper::toDto);
        log.info("Page " + this.genericType.getSimpleName() + " create");
        return all;
    }

    public Pageable findAllWithPagination(final Integer pageNumber,
                                          final String sortField, final String sortDirection) {
        final int pageSize = 3;
        PageRequest pageRequest;
//                = PageRequest.of(pageNumber - 1, pageSize);
//        if (sortField != null && sortField.equalsIgnoreCase("sort")) {
//            pageRequest = PageRequest.of(pageNumber - 1, pageSize);
//            log.info(this.genericType.getSimpleName() + " sort by: " + sortField);
//        } else if (sortField != null && sortDirection != null) {
            Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortField).ascending() : Sort.by(sortField).descending();
            pageRequest = PageRequest.of(pageNumber - 1, pageSize, sort);
            log.info(this.genericType.getSimpleName() + " sort by: " + sortField +
                    " ,sort direction: " + sortDirection);
//        }
        return pageRequest;
    }
}


