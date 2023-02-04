package com.devmountain.noteApp.Controllers;

import com.devmountain.noteApp.DTOs.NoteDTO;
import com.devmountain.noteApp.Services.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {
    @Autowired
    private NoteServiceImpl noteService;

    @PostMapping("/user/{userId}")
    public void addNote(@RequestBody NoteDTO noteDTO, @PathVariable Long userId){
        noteService.addNote(noteDTO, userId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        noteService.deleteNoteById(noteId);
    }

    @PutMapping
    public void updateNoteById(@RequestBody NoteDTO noteDTO){
        noteService.updateNoteById(noteDTO);
    }
    @GetMapping("/user/{userId}")
    public List<NoteDTO> getNotesByUser(@PathVariable Long userId){
        return noteService.getAllNotesByUserId(userId);
    }

    @GetMapping("/{noteId}")
    public Optional<NoteDTO> getNote(@PathVariable Long noteId){
        return noteService.getNoteById(noteId);
    }
}
