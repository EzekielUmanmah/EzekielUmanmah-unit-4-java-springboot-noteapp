package com.devmountain.noteApp.DTOs;

import com.devmountain.noteApp.Entities.Note;
import com.devmountain.noteApp.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDTO implements Serializable {
    private Long id;
    private String body;
    private UserDTO userDTO;

    public NoteDTO(Note note) {
        if (note.getId() != null) {
            this.id = note.getId();
        }
        if (note.getBody() != null) {
            this.body = note.getBody();
        }
    }
}
