package com.juegos.ageofadrian.security;

import com.juegos.ageofadrian.infoJuego.model.Avatar;
import com.juegos.ageofadrian.infoJuego.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AvatarService avatarService;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Avatar avatar = avatarService.buscarAvatar(nombre);

        if (avatar == null)
            throw new UsernameNotFoundException("No existe el usuario '" + nombre + "'");

        String password = null;
        String rol = null;

        password = avatar.getPassword();
        rol = avatar.getRol();

        if (password == null) {
            throw new UsernameNotFoundException("Clave inválida");
        }
        return new User(avatar.getNombre(), password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(rol));
    }

}
