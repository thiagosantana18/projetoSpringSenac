package br.com.senac;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Aluno;
import br.com.senac.domain.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.ProfessorService;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoService alunoService;
	@Autowired
	ProfessorService professorService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Thiago");
		aluno1.setSobreNome("Santana");
		
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Walter");
		aluno2.setSobreNome("Junior");
		
		alunoService.salvar(aluno2);
		
		/*List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for (Aluno aluno: listaAlunos) {
			System.out.println("\n"+"Aluno: ");
			System.out.println(aluno.getNome());
		}*/
		
		
		Professor professor1 = new Professor();
		professor1.setNome("Marcelo");
		professor1.setSobreNome("Estruc");
		
		professorService.salvar(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNome("Priscilla");
		professor2.setSobreNome("Abreu");
		
		professorService.salvar(professor2);
		
		/*List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		
		for(Professor professor: listaProfessores) {
			System.out.println("\n"+"Professor: ");
			System.out.println(professor.getNome());
		}*/
	}

}
