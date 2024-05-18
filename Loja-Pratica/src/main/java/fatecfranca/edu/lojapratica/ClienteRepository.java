package fatecfranca.edu.lojapratica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteRepository, Long> {
    // esta interface vai herdar todos os métodos de CRUD
    // (Create, read, update, delete) de ClienteEntity
    // não vamos precisar de escrever código SQL
    // teremos métodos prontos
}
