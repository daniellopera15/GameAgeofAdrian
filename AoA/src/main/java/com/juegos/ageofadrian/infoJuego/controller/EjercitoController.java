package com.juegos.ageofadrian.infoJuego.controller;

import com.juegos.ageofadrian.infoJuego.exceptions.EjercitoErrorException;
import com.juegos.ageofadrian.infoJuego.exceptions.EjercitoNotFoundException;
import com.juegos.ageofadrian.infoJuego.model.Ejercito;
import com.juegos.ageofadrian.infoJuego.service.EjercitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/ejercito")
@CrossOrigin
public class EjercitoController {

    @Autowired
    private EjercitoService ejercitoService;

    @RequestMapping(value = "/crearEjercito", method = RequestMethod.POST)
    public ResponseEntity<Ejercito> crearEjercito(@RequestBody Ejercito ejercito) throws EjercitoErrorException {
        Ejercito ejercitoNuevo = ejercitoService.crearEjercito(ejercito);
        if (ejercitoNuevo == null)
            throw new EjercitoErrorException("No se pudo crear el ejercito");

        return ResponseEntity.ok(ejercitoNuevo);
    }

    @RequestMapping(value = "/actualizarEjercito", method = RequestMethod.PUT)
    public ResponseEntity<Ejercito> actualizarEjercito(@RequestBody Ejercito ejercito) throws EjercitoNotFoundException {
        Ejercito ejercitoActualizado = ejercitoService.editarEjercito(ejercito);
        if (ejercitoActualizado == null)
            throw new EjercitoNotFoundException("No se pudo actualizar el ejercito");

        return ResponseEntity.ok(ejercitoActualizado);
    }

    @RequestMapping(value = "/eliminarEjercito/{ejercitoId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarEjercito(@PathVariable String ejercitoId) throws EjercitoNotFoundException {
        if (!ejercitoService.eliminarEjercito(ejercitoId))
            throw new EjercitoNotFoundException("No se pudo eliminar el ejercito");

        return ResponseEntity.ok("Eliminado con éxito");
    }

    @ExceptionHandler(EjercitoNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Map<String, String> notFoundException(EjercitoNotFoundException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }

    @ExceptionHandler(EjercitoErrorException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, String> errorException(EjercitoErrorException e) {
        return Collections.singletonMap("mensaje", e.getMessage());
    }
}
