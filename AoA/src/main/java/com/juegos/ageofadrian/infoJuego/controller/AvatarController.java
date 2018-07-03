package com.juegos.ageofadrian.infoJuego.controller;

import com.juegos.ageofadrian.infoJuego.exceptions.AvatarErrorException;
import com.juegos.ageofadrian.infoJuego.exceptions.AvatarNotFoundException;
import com.juegos.ageofadrian.infoJuego.model.Avatar;
import com.juegos.ageofadrian.infoJuego.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Avatar> registrarAvatar(@RequestBody Avatar avatar) throws AvatarErrorException {
        Avatar avatarNuevo = avatarService.crearAvatar(avatar);
        if (avatarNuevo == null)
            throw new AvatarErrorException("No se pudo crear el avatar");

        return ResponseEntity.ok(avatarNuevo);
    }
/*
    @RequestMapping(value = "/login/{nombre}", method = RequestMethod.POST)
    public ResponseEntity<Avatar> buscarAvatar(@PathVariable String nombre) throws AvatarErrorException {
        Avatar avatar = avatarService.buscarAvatar(nombre);
        if (avatar == null)
            throw new AvatarErrorException("No se pudo encontrar el avatar");

        return ResponseEntity.ok(avatar);
    }
*/
    @RequestMapping(value = "/editarAvatar", method = RequestMethod.PUT)
    public ResponseEntity<Avatar> editarAvatar(@RequestBody Avatar avatar) throws AvatarNotFoundException {
        Avatar avatarEditado = avatarService.editarAvatar(avatar);
        if (avatarEditado == null)
            throw new AvatarNotFoundException("No se pudo editar el avatar");

        return ResponseEntity.ok(avatarEditado);
    }

    @RequestMapping(value = "/eliminarAvatar/{avatarId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarAvatar(@PathVariable Long avatarId) throws AvatarNotFoundException {
        if (!avatarService.eliminarAvatar(avatarId))
            throw new AvatarNotFoundException("No se pudo eliminar el avatar");

        return ResponseEntity.ok("Eliminado con éxito");
    }

    @RequestMapping("/listarAvatares")
    public ResponseEntity<List<Avatar>> listarAvatares() throws AvatarErrorException {
        List<Avatar> avatares = avatarService.listarAvatares();
        if (avatares == null)
            throw new AvatarErrorException("No se pudo cargar la lista");

        return ResponseEntity.ok(avatares);
    }

    @ExceptionHandler(AvatarNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(AvatarNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(AvatarErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(AvatarErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

}
