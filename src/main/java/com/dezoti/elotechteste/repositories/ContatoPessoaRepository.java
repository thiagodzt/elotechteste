package com.dezoti.elotechteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dezoti.elotechteste.domain.ContatoPessoa;

@Repository
public interface ContatoPessoaRepository extends JpaRepository<ContatoPessoa, Integer> {

}
