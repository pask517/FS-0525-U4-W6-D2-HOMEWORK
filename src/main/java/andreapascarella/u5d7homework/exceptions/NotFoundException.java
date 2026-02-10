package andreapascarella.u5d7homework.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("La risorsa con id: " + id + " non é stata trovata!");
    }
}
