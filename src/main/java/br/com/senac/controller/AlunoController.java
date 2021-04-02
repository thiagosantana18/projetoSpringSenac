package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listarAlunos")
	public ModelAndView listarTodosAlunos() {
		ModelAndView mv = new ModelAndView("aluno/listarAlunos");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
		
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAlunos() {
		ModelAndView mv = new ModelAndView("aluno/cadastrarAlunos");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAlunos(Aluno aluno) {
		alunoService.salvar(aluno);
		return listarTodosAlunos();
	}
	
	@GetMapping("/alterar/{idAluno}")
	public ModelAndView alterarAluno(@PathVariable("idAluno") Integer idAluno) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("aluno/alterarAlunos");
		mv.addObject("aluno", alunoService.buscaPorID(idAluno));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarAluno(Aluno aluno) throws ObjectNotFoundException {
		alunoService.salvarAlteracao(aluno);
		return listarTodosAlunos();
	}
}
