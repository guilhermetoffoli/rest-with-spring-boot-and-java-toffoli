package br.com.toffoli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.toffoli.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
