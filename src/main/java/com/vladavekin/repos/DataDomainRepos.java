package com.vladavekin.repos;

import com.vladavekin.domain.DataDomain;
import org.springframework.data.repository.CrudRepository;

public interface DataDomainRepos extends CrudRepository<DataDomain, Long> {

}