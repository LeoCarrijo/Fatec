package fatecfranca.edu.lojapratica.model.repository;

import fatecfranca.edu.lojapratica.model.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    // esta interface vai herdar todos os métodos de CRUD
    // (Create, read, update, delete) de ClienteEntity
    // não vamos precisar de escrever código SQL
    // teremos métodos prontos
}