package com.lian.group.Repository;

import com.lian.group.Entity.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// one thing not clear, JpaRepository<T, ID> T==> entity ID==>?
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    Resource findResourceById(Integer id);

    List<Resource> findAll();
    // delete by id
    void deleteById(Integer id);

    // trying to delete as we like
//    @Override
//    void deleteInBatch(Iterable<Resource> iterable);
}
