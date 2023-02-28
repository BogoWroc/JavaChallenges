package pl.bogo.course.repository;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String msg, Exception e) {
        super(msg, e);
    }
}
