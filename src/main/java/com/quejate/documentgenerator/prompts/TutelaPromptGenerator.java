package com.quejate.docuaigenerator.prompts;

import com.quejate.docuaigenerator.dtos.TutelaRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TutelaPromptGenerator {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String generatePrompt(TutelaRequestDTO request) {
        String fechaPresentacion = LocalDate.now().format(DATE_FORMATTER);

        return String.format("""
            Redacta una acción de tutela completa y específica para Colombia, siguiendo la estructura legal establecida por la jurisprudencia constitucional colombiana, con los siguientes datos.

            INFORMACIÓN DEL CASO:
            - Solicitante: %s
            - Documento: %s
            - Ubicación: %s, %s
            - Entidad demandada: %s
            - Tipo de solicitud: %s
            - Fecha de radicación PQRSD: %s
            - Días transcurridos sin respuesta: %d
            - Derecho fundamental vulnerado: %s
            - Descripción del caso: %s
            - Fecha de presentación de la tutela: %s

            INSTRUCCIONES ESPECÍFICAS:
            1. Sigue la estructura legal colombiana para acciones de tutela
            2. Dirige la tutela al "Juzgado Civil Municipal de %s" (no uses indicaciones genéricas)
            3. Usa información concreta y específica, nunca pongas texto entre paréntesis con instrucciones
            4. Estructura obligatoria según normativa colombiana:
               - SEÑOR JUEZ (encabezado dirigido al juez)
               - Identificación completa del accionante
               - Identificación de la entidad accionada
               - HECHOS (numerados cronológicamente)
               - DERECHOS FUNDAMENTALES VULNERADOS
               - PRETENSIONES (lo que se solicita al juez)
               - FUNDAMENTOS DE DERECHO (marco normativo aplicable)
               - COMPETENCIA (por qué ese juzgado es competente)
               - PROCEDIBILIDAD (requisitos de procedencia de la tutela)
               - SOLICITUD FINAL
            5. Al final del documento, incluir la siguiente fórmula de cierre en líneas separadas:
               "Atentamente,"
               "%s"
               "C.C. %s"

            CONTEXTO LEGAL COLOMBIANO:
            - Constitución Política de Colombia, artículo 86
            - Decreto 2591 de 1991 (reglamentario de la tutela)
            - El plazo legal para responder PQRSD es de 15 días hábiles (Ley 1755 de 2015)
            - Han transcurrido %d días sin respuesta, configurando vía de hecho por omisión
            - Se vulnera el derecho fundamental %s
            - La tutela procede contra %s por ser entidad pública/privada que presta servicio público
            - Competencia: Juzgado del lugar donde ocurre la vulneración (%s)

            FORMATO:
            - Solo texto plano, sin markdown, sin negritas, sin cursivas
            - No incluir título "Acción de Tutela"
            - No incluir sección de firmas
            - No usar paréntesis con instrucciones como "(indicar)", "(especificar)", etc.
            - Ser completamente específico en todos los datos

            EJEMPLO DE LO QUE NO DEBES HACER:
            "Juzgado (indicar competente)"
            "Entidad (nombre de la entidad)"
            "Derecho (especificar derecho)"
            Redacta el documento completo usando únicamente la información proporcionada, sin agregar indicaciones genéricas o texto entre paréntesis.
            """,
                request.getFullName(),
                request.getDocumentNumber(),
                request.getCity(),
                request.getDepartment(),
                request.getEntity(),
                request.getPqrType(),
                request.getPqrDate(),
                request.getDaysExceeded(),
                request.getRightViolated(),
                request.getPqrDescription(),
                fechaPresentacion,
                request.getCity(),
                request.getFullName(),
                request.getDocumentNumber(),
                request.getDaysExceeded(),
                request.getRightViolated(),
                request.getEntity(),
                request.getCity()
        );
    }
}
