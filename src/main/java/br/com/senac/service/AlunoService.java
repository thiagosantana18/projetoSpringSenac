package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Aluno;
import br.com.senac.repository.AlunoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repoAluno;
	
	public Aluno salvar(Aluno aluno) {
		return repoAluno.save(aluno);
	}
	
	public List<Aluno> buscarTodosAlunos() {
		return repoAluno.findAll();
	}
	
	public Aluno buscaPorID(Integer idAluno) throws ObjectNotFoundException {
		Optional<Aluno> aluno = repoAluno.findById(idAluno);
		return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno " + idAluno + " não encontrado"));
	}
	
	public Aluno salvarAlteracao(Aluno alunoAlterado) throws ObjectNotFoundException {
		Aluno aluno = buscaPorID(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}
}
