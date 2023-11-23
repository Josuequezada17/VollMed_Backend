package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas {

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        var ahora = LocalDateTime.now();
        var horaDeConsulta = datosAgendarConsulta.fecha();

        var diferenciaDe30Min = Duration.between(ahora, horaDeConsulta).toMinutes()<30;

        if(diferenciaDe30Min){
            throw new ValidacionDeIntegridad
                    ("Las consultas deben de programarse con al menos 30 minutos de anticipación");
        }

    }

}
