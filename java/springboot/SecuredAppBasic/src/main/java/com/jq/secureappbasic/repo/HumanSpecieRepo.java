package com.jq.secureappbasic.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jq.secureappbasic.model.HumanSpecie;

@Repository
public interface HumanSpecieRepo extends CrudRepository<HumanSpecie, Long> {

}
