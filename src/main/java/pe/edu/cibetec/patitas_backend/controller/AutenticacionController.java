package pe.edu.cibetec.patitas_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibetec.patitas_backend.dto.SignOutRequestDTO;
import pe.edu.cibetec.patitas_backend.dto.SignOutResponseDTO;
import pe.edu.cibetec.patitas_backend.dto.LoginRequestDTO;
import pe.edu.cibetec.patitas_backend.dto.LoginResponseDTO;
import pe.edu.cibetec.patitas_backend.service.AutenticacionService;

import java.util.Arrays;

@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO) {

        try {
            //Thread.sleep(Duration.ofSeconds(5));
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);
            System.out.println("Resultado: " + Arrays.toString(datosUsuario));
            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "Error: Usuario no encontrado", "", "");
            }
            return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);

        } catch (Exception e) {
            return new LoginResponseDTO("99", "Error: Ocurrió un problema", "", "");
        }

    }

    @PostMapping("/signout")
    public SignOutResponseDTO CierreSesion(@RequestBody SignOutRequestDTO signOutRequestDTO){
        try {
            String codigo = autenticacionService.CierreSesion(signOutRequestDTO);

            if (codigo == null){
                return new SignOutResponseDTO("99","Error : No se pudo guardar el registro");
            }

            return new SignOutResponseDTO(codigo, "Se guardó el registro de cierre de sesión");
        }
        catch (Exception e ) {
            System.out.println(e.getMessage().toString());
            return new SignOutResponseDTO("99", "Error");
        }
    }

}