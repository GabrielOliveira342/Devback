package com.example.DevBack.config;

import com.example.DevBack.model.Consulta;
import com.example.DevBack.model.Convenio;
import com.example.DevBack.model.Medico;
import com.example.DevBack.model.Paciente;
import com.example.DevBack.model.Prontuario;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class HospitalConfiguration {

    @Bean
    public Medico medico() {
        Medico medico = new Medico();
        medico.setId(1L);
        medico.setNome("Dr. Carlos Souza");
        medico.setEspecialidade("Cardiologia");
        medico.setCrm("CRM-12345");
        return medico;
    }

    @Bean
    public Convenio convenio() {
        Convenio convenio = new Convenio();
        convenio.setId(1L);
        convenio.setNome("Unimed");
        convenio.setCnpj("12.345.678/0001-99");
        return convenio;
    }

    @Bean
    public Prontuario prontuario() {
        Prontuario prontuario = new Prontuario();
        prontuario.setId(1L);
        prontuario.setTipoSanguineo("O+");
        prontuario.setAlergia("Penicilina");
        prontuario.setObservacoes("Paciente hipertenso");
        return prontuario;
    }

    @Bean
    public Consulta consulta(Medico medico, Convenio convenio) {
        Consulta consulta = new Consulta();
        consulta.setId(1L);
        consulta.setDataHora(LocalDateTime.of(2025, 5, 10, 14, 30));
        consulta.setMotivo("Dor no peito");
        consulta.setValor(250.00);
        consulta.setMedico(medico);
        consulta.setConvenio(convenio);
        return consulta;
    }

    @Bean
    public Paciente paciente(Prontuario prontuario, Consulta consulta) {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("João da Silva");
        paciente.setCpf("123.456.789-00");
        paciente.setTelefone("(11) 98765-4321");
        paciente.setProntuario(prontuario);
        paciente.setConsultas(List.of(consulta));
        return paciente;
    }
}
