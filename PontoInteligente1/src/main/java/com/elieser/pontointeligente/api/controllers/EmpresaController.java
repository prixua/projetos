package com.elieser.pontointeligente.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elieser.pontointeligente.api.dtos.EmpresaDto;
import com.elieser.pontointeligente.api.entities.Empresa;
import com.elieser.pontointeligente.api.response.Response;
import com.elieser.pontointeligente.api.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*")
public class EmpresaController {

	private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

	@Autowired
	private EmpresaService empresaService;

	public EmpresaController() {
	}

	/**
	 * Retorna uma empresa dado um CNPJ.
	 * 
	 * @param cnpj
	 * @return ResponseEntity<Response<EmpresaDto>>
	 */
	@GetMapping(value = "/cnpj/{cnpj}")
	public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable("cnpj") String cnpj) {
		log.info("Buscando empresa por CNPJ: {}", cnpj);
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		Optional<Empresa> empresa = empresaService.buscarPorCnpj(cnpj);

		if (!empresa.isPresent()) {
			log.info("Empresa não encontrada para o CNPJ: {}", cnpj);
			response.getErrors().add("Empresa não encontrada para o CNPJ " + cnpj);
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterEmpresaDto(empresa.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * Retorna todas as empresas.
	 *
	 * @return ResponseEntity<Response<List<EmpresaDto>>>
	 */
	@GetMapping(value = "/")
	public ResponseEntity<Response<List<EmpresaDto>>> buscarEmpresas() {
		log.info("Buscando todas as empresas");
		Response<List<EmpresaDto>> response = new Response<List<EmpresaDto>>();
		Optional<List<Empresa>> empresas = empresaService.buscarEmpresas();

		if (!empresas.isPresent()) {
			log.info("Nenhuma empresa encontrada.");
			response.getErrors().add("Nenhuma empresa encontrada");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.converterListaEmpresaDto(empresas.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * Popula um DTO com os dados de uma empresa.
	 * 
	 * @param empresa
	 * @return EmpresaDto
	 */
	private EmpresaDto converterEmpresaDto(Empresa empresa) {
		EmpresaDto empresaDto = new EmpresaDto();
		empresaDto.setId(empresa.getId());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());

		return empresaDto;
	}

	private List<EmpresaDto> converterListaEmpresaDto(List<Empresa> empresas){
		List<EmpresaDto> empresasDtos = new ArrayList<>();
		empresas.forEach(empresa -> empresasDtos.add(converterEmpresaDto(empresa)));
		return empresasDtos;
	}

}
