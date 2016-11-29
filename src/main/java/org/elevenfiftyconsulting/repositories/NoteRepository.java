package org.elevenfiftyconsulting.repositories;

import org.elevenfiftyconsulting.beans.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {

}
