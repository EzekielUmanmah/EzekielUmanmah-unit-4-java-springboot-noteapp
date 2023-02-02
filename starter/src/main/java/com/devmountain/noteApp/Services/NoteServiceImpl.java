package com.devmountain.noteApp.Services;

import com.devmountain.noteApp.DTOs.NoteDTO;
import com.devmountain.noteApp.Entities.Note;
import com.devmountain.noteApp.Entities.User;
import com.devmountain.noteApp.Repositories.NoteRepository;
import com.devmountain.noteApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addNote(NoteDTO noteDTO, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Note note = new Note(noteDTO);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }
    @Override
    public void deleteNoteById(NoteDTO noteDTO){
        Optional<Note> noteOptional = noteRepository.findById(noteDTO.getId());
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }
    @Override
    @Transactional
    public void updateNoteById(NoteDTO noteDTO){
        Optional<Note> noteOptional = noteRepository.findById(noteDTO.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDTO.getBody());
            noteRepository.saveAndFlush(note);
        });
    }

    @Override
    @Transactional
    public List<NoteDTO> getAllNotesByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Note> noteList = noteRepository.findAllByUserEquals(userOptional.get());
//            in map(), the lambda can be replaced with a method reference
//            return noteList.stream().map(NoteDTO::new).collect(Collectors.toList());
            return noteList.stream().map(note -> new NoteDTO(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public Optional<NoteDTO> getNoteById(Long id){
        Optional<Note> noteOptional = noteRepository.findById(id);
//        functional style expression
//        return noteOptional.map(NoteDTO::new);
        if(noteOptional.isPresent()){
            return Optional.of(new NoteDTO(noteOptional.get()));
        }
        return Optional.empty();
    }
}
