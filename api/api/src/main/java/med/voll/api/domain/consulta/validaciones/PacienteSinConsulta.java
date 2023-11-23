package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSinConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        //Las fechas en las que el paciente puede asignar consultas
        var primerHorario = datosAgendarConsulta.fecha().withHour(7);
        var ultimoHorario = datosAgendarConsulta.fecha().withHour(18);

        var pacienteConConsulta = repository.existsByPacienteIdAndFechaBetween(
                datosAgendarConsulta.idPaciente(), primerHorario, ultimoHorario);

        if(pacienteConConsulta){
            throw new ValidacionDeIntegridad("El paciente ya tiene una consulta para ese dia");
        }

    }

}
