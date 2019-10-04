package com.ericsson.anuncio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnunciosRepository extends JpaRepository<Anuncio, Long> {
}