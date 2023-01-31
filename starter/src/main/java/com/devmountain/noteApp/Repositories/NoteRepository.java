package com.devmountain.noteApp.Repositories;

import com.devmountain.noteApp.Entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
