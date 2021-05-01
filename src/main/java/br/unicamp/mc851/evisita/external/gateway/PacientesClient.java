package br.unicamp.mc851.evisita.external.gateway;

import br.unicamp.mc851.evisita.viewmodel.PacienteVM;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// TODO

@FeignClient("pacientes")
public interface PacientesClient {
    @RequestMapping(method = RequestMethod.GET, value = "pacientes")
    List<PacienteVM> getPacientes();
}
