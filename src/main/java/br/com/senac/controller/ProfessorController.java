package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Professor;
import br.com.senac.service.ProfessorService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarProfessores")
	public ModelAndView listarTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/listarProfessores");
		mv.addObject("professores", professorService.buscarTodosProfessores());
		return mv;
		
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessores() {
		ModelAndView mv = new ModelAndView("professor/cadastrarProfessores");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessores(Professor professor) {
		professorService.salvar(professor);
		return listarTodosProfessores();
	}
	
	@GetMapping("/alterar/{idProfessor}")
	public ModelAndView alterarProfessor(@PathVariable("idProfessor") Integer idProfessor) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("professor/alterarProfessores");
		mv.addObject("professor", professorService.buscaPorID(idProfessor));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterarProfessor(Professor professor) throws ObjectNotFoundException {
		professorService.salvarAlteracao(professor);
		return listarTodosProfessores();
	}
}