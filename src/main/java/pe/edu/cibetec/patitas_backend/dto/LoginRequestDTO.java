package pe.edu.cibetec.patitas_backend.dto;

public record LoginRequestDTO(String tipoDocumento, String numeroDocumento, String password) {
}
