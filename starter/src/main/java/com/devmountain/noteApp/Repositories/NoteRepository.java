package com.devmountain.noteApp.Repositories;

import com.devmountain.noteApp.Entities.Note;
import com.devmountain.noteApp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByUserEquals(User user);
}
