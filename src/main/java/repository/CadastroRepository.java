package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.entities.Cadastro;
import model.enums.TipoCadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro,Long> {
	
	//Buscar cadastro pelo login
    Optional<Cadastro> findByLogin(String login);
    
    //Verificar se existe cadastro com o login informado
    boolean existsByLogin(String login);

    //Buscar cadastro pelo tipo de cadastro
    List<Cadastro> findByTipoCadastro(TipoCadastro tipoCadastro);

    //Buscas cadastro pelo login e tipo de cadastro
    Optional<Cadastro> findByLoginAndTipoCadastro(String login, TipoCadastro tipoCadastro);
}
