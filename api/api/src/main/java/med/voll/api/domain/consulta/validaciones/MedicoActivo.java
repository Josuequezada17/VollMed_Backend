package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoActivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        if(datosAgendarConsulta.idMedico() == null){
            return;
        }

        var medicoActivo = repository.findActivoById(datosAgendarConsulta.idMedico());

        if(!medicoActivo){
            throw new ValidacionDeIntegridad("No se permite agendar citas con medicos inactivos");
        }

    }

}
