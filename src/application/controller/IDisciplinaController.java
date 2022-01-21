package application.controller;

import application.model.Disciplina;
import java.sql.SQLException;

public interface IDisciplinaController {

    void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    void bucarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException;
    void buscarDisciplinas() throws ClassNotFoundException, SQLException;
}
