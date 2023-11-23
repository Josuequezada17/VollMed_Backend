package med.voll.api.domain.consulta.deafio;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamiento")
public class ValidadorHorarioAntecedencia implements  ValidadorCancelaminetoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    /*@Override
    public void validar(DatosCancelamientoConsulta datos){
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaDeHoras = Duration.between(ahora, consulta.getFecha()).toHours();

        if(diferenciaDeHoras < 24){
            throw new ValidacionDeIntegridad("La consulta solo puede ser cancelada con 24hrs de anticipacion");
        }
    }*/

}
