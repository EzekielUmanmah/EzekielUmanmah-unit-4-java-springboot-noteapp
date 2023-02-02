package com.devmountain.noteApp.Services;

import com.devmountain.noteApp.DTOs.NoteDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDTO noteDTO, Long userId);

    void deleteNoteById(NoteDTO noteDTO);

    @Transactional
    void updateNoteById(NoteDTO noteDTO);

    @Transactional
    List<NoteDTO> getAllNotesByUserId(Long userId);

    @Transactional
    Optional<NoteDTO> getNoteById(Long id);
}
