package com.lian.group.Repository;

import com.lian.group.Entity.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// one thing not clear, JpaRepository<T, ID> T==> entity ID==>? ID type?
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

    // ---Search Part
    Resource findResourceById(Integer id);
    Resource findResourceByName(String resourceName);

    List<Resource> findAll();
    // ---Delete Part
    void deleteById(Integer id);

    // trying to delete Iterable
//    @Override
//    void deleteInBatch(Iterable<Resource> iterable);

    //---Create Part
    //---Update Part
    // both using set() + save()
}
