package com.arlin.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arlin.brewer.model.Cerveja;

@Controller
public class CervejaController {

	@GetMapping("/cerveja")
	public String novo(Cerveja cerveja) {
		return "cerveja/cadastro-cerveja";
	}

	@PostMapping("/cerveja")
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		redirect.addFlashAttribute("mensagem", "Cadastro realizado!");
		System.out.println("SKU " + cerveja.getSku());
		return "redirect:/cerveja";
	}

}
