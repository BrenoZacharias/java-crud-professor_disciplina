package application.controller;

import application.model.Disciplina;
import application.persistence.DisciplinaDao;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class DisciplinaController implements IDisciplinaController{

    private TextField tfCodigoDisciplina;
    private TextField tfNomeDiscilplina;
    private TextField tfCodigoProfessorDisciplina;
    private Label lblNomeProfessor;
    private TextArea taListaDisciplinas;

    public DisciplinaController(TextField tfCodigoDisciplina,
                                TextField tfNomeDiscilplina,
                                TextField tfCodigoProfessorDisciplina,
                                Label lblNomeProfessor,
                                TextArea taListaDisciplinas)
    {
        this.tfCodigoDisciplina = tfCodigoDisciplina;
        this.tfNomeDiscilplina = tfNomeDiscilplina;
        this.tfCodigoProfessorDisciplina = tfCodigoProfessorDisciplina;
        this.lblNomeProfessor = lblNomeProfessor;
        this.taListaDisciplinas = taListaDisciplinas;
    }

    @Override
    public void inserirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.insereDisciplina(d);
        limparCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void atualizarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.atualizaDisciplina(d);
        limparCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void excluirDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        DisciplinaDao dDao = new DisciplinaDao();
        dDao.excluiDisciplina(d);
        limparCamposDisciplina();
        buscarDisciplinas();
    }

    @Override
    public void bucarDisciplina(Disciplina d) throws ClassNotFoundException, SQLException {
        limparCamposDisciplina();
        DisciplinaDao dDao = new DisciplinaDao();
        d = dDao.buscaDisciplina(d);
        tfCodigoDisciplina.setText(String.valueOf(d.getCodigo()));
        tfNomeDiscilplina.setText(d.getNome());
        tfCodigoProfessorDisciplina.setText(String.valueOf(d.getProfessor().getCodigo()));
        lblNomeProfessor.setText(d.getProfessor().getNome());
    }

    @Override
    public void buscarDisciplinas() throws ClassNotFoundException, SQLException {
        limparCamposDisciplina();

        DisciplinaDao dDao = new DisciplinaDao();
        List<Disciplina> listaDisciplinas = dDao.buscaDisciplinas();

        taListaDisciplinas.setText("");

        StringBuffer sb = new StringBuffer("Código\t\t\t\tNome\t\t\t\t\tProfessor\n");
        for(Disciplina d : listaDisciplinas){
            sb.append(d.getCodigo()+"\t\t\t\t\t"+d.getNome()+"\t\t\t\t"+d.getProfessor()+"\n");
        }

        taListaDisciplinas.setText(sb.toString());
    }

    private void limparCamposDisciplina(){
        tfCodigoDisciplina.setText("");
        tfNomeDiscilplina.setText("");
        tfCodigoProfessorDisciplina.setText("");
        lblNomeProfessor.setText("");
    }
}

