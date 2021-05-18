package br.unicamp.mc851.evisita.external.gateway;

import br.unicamp.mc851.evisita.endpoint.dto.PacienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// TODO

@FeignClient(name = "pacientes", url = "http://localhost:8081/")
public interface PacientesClient {
    @RequestMapping(method = RequestMethod.GET, value = "/pacientes")
    List<PacienteResponse> getPacientes();
}
