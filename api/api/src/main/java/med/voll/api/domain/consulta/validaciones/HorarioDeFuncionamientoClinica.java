package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamientoClinica implements ValidadorDeConsultas{

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        //Si se cumple es que es domingo
        var domingo = DayOfWeek.SUNDAY.equals(datosAgendarConsulta.fecha().getDayOfWeek());

        //Para validar si es antes de las 7
        var antesDeApertura = datosAgendarConsulta.fecha().getHour() < 7;

        //Para validar si es despues de las 19
        var despuesDeCierre = datosAgendarConsulta.fecha().getHour() > 19;

        if(domingo || antesDeApertura || despuesDeCierre){
            throw new ValidacionDeIntegridad
                ("El horario de atencion de la clinica es de lunes a sabado, de 7:00 a 19:00 horas");

        }

    }

}
