package pe.edu.cibetec.patitas_backend.service;

import pe.edu.cibetec.patitas_backend.dto.SignOutRequestDTO;
import pe.edu.cibetec.patitas_backend.dto.LoginRequestDTO;

import java.io.IOException;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;

    String CierreSesion(SignOutRequestDTO signOutRequestDTO) throws IOException;
}