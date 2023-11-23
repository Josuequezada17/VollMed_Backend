package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteActivo implements ValidadorDeConsultas{

    @Autowired
    private PacienteRepository repository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        if(datosAgendarConsulta.idPaciente() == null){
            return;
        }

        var pacienteActivo = repository.findActivoById(datosAgendarConsulta.idPaciente());

        if(!pacienteActivo){
            throw new ValidacionDeIntegridad("No se permite agendar citas a  pacientes inactivos");
        }

    }

}
