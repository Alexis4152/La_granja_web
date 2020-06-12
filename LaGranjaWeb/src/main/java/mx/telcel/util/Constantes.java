package mx.telcel.util;

import java.util.ArrayList;
import java.util.List;

import org.contact.model.ACCESO_USUARIOS;
import org.contact.model.PARAMETROS;

@SuppressWarnings("unchecked")
public class Constantes {
	@SuppressWarnings("rawtypes")
	public static List<ACCESO_USUARIOS> usuarioparametros=new ArrayList();
	public static List<PARAMETROS> PARAMETROELEGIDO= new ArrayList();
	public static String procesos_abajo="";
	public static String procesos_arriba="";
	public static String bandera = "";
	public static String banderaactivo = "";
	public static ArrayList<Integer> acceso_parametros = new ArrayList<Integer>();
	public static ArrayList<Integer> acceso_parametros_consulta_like = new ArrayList<Integer>();
	@SuppressWarnings("rawtypes")
	public static ArrayList memoria = new ArrayList();
	@SuppressWarnings("rawtypes")
	public static ArrayList activo_ono = new ArrayList();
	
	@SuppressWarnings("rawtypes")
	public static ArrayList date_hour = new ArrayList();

	public static String DATOSDELAMEMORIA = "";
	public static String FECHA_HORA_SERVIDOR = "";

	public static String total = "";
	public static String uso = "";
	public static String libre = "";
	public static String share = "";
	public static String buff = "";
	public static String available = "";
 
	 
	//MENSAJE DE TODOS LOS PROCESOS ABAJO 
	public static String ASUNTO_ALL_PROCESS_KILL="LISTA DE PROCESOS DETENIDOS EN CP";
	public static String MSG_ALL_PROCESS_KILL="A CONTINUACIÓN SE ENLISTA LOS PROCESOS QUE FUERON DETENIDOS: ";
	
	//MENSAJE DE TODOS LOS PROCESOS ARRIBA 
	public static String ASUNTO_ALL_PROCESS_START="LISTA DE PROCESOS ACTIVADOS EN CP";
	public static String MSG_ALL_PROCESS_START="A CONTINUACIÓN SE ENLISTA LOS PROCESOS QUE FUERON ACTIVADOS: ";

	// ESTADOS Y DETALLES DE LOS PROCESOS
	public static final String MENSAJE_PROCESO_ABAJO = "fue detenido por el Portal de Aplicativos Complemento Pago.";
	public static final String MENSAJE_PROCESO_ARRIBA = "fue reestablecido mediante el Portal de Aplicativos Complemento Pago.";
	public static final String DESTINATARIO_GUSTAVO = "gustavo.segundo@telcel.com";
	public static final String DESTINATARIO_PEDRO = "pedro.torresr@mail.telcel.com";
	public static final String DESTINATARIO_AGUS = "agustin.zuloaga@mail.telcel.com";
	public static final String DESTINATARIO_LORENA = "lorena.solorio@telcel.com";
	public static final String DESTINATARIO_ALEXIS = "alexis.luna@mail.telcel.com";//
	public static final String SISTEMAS_ABIERTOS_COMPLEMENTO_PAGO ="gustavo.segundo@telcel.com,pedro.torresr@mail.telcel.com,agustin.zuloaga@mail.telcel.com,alexis.luna@mail.telcel.com";
    
	// CONEXION AL SERVIDOR
	// DE TEST
	public static final String USERNAME = "svbcp01";
	public static final String HOST = "10.119.160.195";
	public static final int PORT = 22;
	public static final String PASSWORD = "complementopago";

	// DE PRODUCCION
	/*
	 * public static final String USERNAME = "svbcp01"; public static final String
	 * HOST = "10.191.135.79"; public static final int PORT = 22; public static
	 * final String PASSWORD = "Compago1";
	 */
	// FIN DE CONEXION AL SERVIDOR
	public static String Activo_Inactivo = "";
	public static String IndicadorActivo_Inactivo = "";
	public static String BibesActivo_Inactivo = "";
	public static String TransformaActivo_Inactivo = "";
	public static String CoreCPActivo_Inactivo = "";
	public static String CMasivaActivo_Inactivo = "";
	public static String CancelacionsActivo_Inactivo = "";

	// JARS DE LOS PROCESOS
	// EN TEST JAR+NAME+CG (CG=CONSULTA GENERAL)
	public static final String Jar_TransformaBibes_CG = "java -Xms128m -Xmx256m -XX:PermSize=128m -XX:MaxPermSize=256m -Dfile.encoding=ISO-8859-1 -jar TransformaBibes-0.0.1.jar";
	public static final String Jar_Transforma_CG = "java -Xms128m -Xmx256m -XX:PermSize=128m -XX:MaxPermSize=256m -Dfile.encoding=ISO-8859-1 -jar Transforma-1.0.jar";
	public static final String Jar_IndicadorComPagoFact_CG = "java -Xms128m -Xmx1024m -XX:PermSize=128m -XX:MaxPermSize=1024m -Dfile.encoding=ISO-8859-1 -jar IndicadorComPagoFact-0.0.1.jar";
	public static final String Jar_CoreCompPagoBatch_CG = "java -Xms128m -Xmx256m -XX:PermSize=128m -XX:MaxPermSize=256m -Dfile.encoding=ISO-8859-1 -jar CoreCompPagoBatch-1.0.jar";
	public static final String Jar_CMasivaCompPagoBatch_CG = "java -jar CMasivaCompPagoBatch-1.0.jar";
	public static final String Jar_CancelacionCompPagoBatch_CG = "java -jar CancelacionCompPagoBatch-1.0.jar";

	public static final String Jar_TransformaBibes = "TransformaBibes-0.0.1.jar";
	public static final String Jar_Transforma = "Transforma-1.0.jar";
	public static final String Jar_IndicadorComPagoFact = "IndicadorComPagoFact-0.0.1.jar";
	public static final String Jar_CoreCompPagoBatch = "CoreCompPagoBatch-1.0.jar";
	public static final String Jar_CMasivaCompPagoBatch = "CMasivaCompPagoBatch-1.0.jar";
	public static final String Jar_CancelacionCompPagoBatch = "CancelacionCompPagoBatch-1.0.jar";
	// EN PRODUCCION
	/*
	 * CONSULTA GENERAL public static final String Jar_CoreCompPagoBatch =
	 * "java -Xms128m -Xmx256m -XX:PermSize=128m -XX:MaxPermSize=256m -Dfile.encoding=ISO-8859-1 -jar CoreCompPagoBatch-1.0.jar"
	 * ; public static final String Jar_CMasivaCompPagoBatch =
	 * "java -jar CMasivaCompPagoBatch-1.0.jar"; public static final String
	 * Jar_CancelacionCompPagoBatch = "java -jar CancelacionCompPagoBatch-1.0.jar";
	 * 
	 * CONSULTA INDIVIDUAL public static final String Jar_TransformaBibes =
	 * "TransformaBibes-0.0.1.jar"; public static final String Jar_Transforma =
	 * "Transforma-1.0.jar"; public static final String Jar_IndicadorComPagoFact =
	 * "IndicadorComPagoFact-0.0.1.jar"; public static final String
	 * Jar_CoreCompPagoBatch = "CoreCompPagoBatch-1.0.jar"; public static final
	 * String Jar_CMasivaCompPagoBatch = "CMasivaCompPagoBatch-1.0.jar"; public
	 * static final String Jar_CancelacionCompPagoBatch =
	 * "CancelacionCompPagoBatch-1.0.jar";
	 *
	 */

	//ACTIVACIÓN O DESACTIVACIÓN
	public static final String ACTIVACION="Activación del ";
	public static final String DESACTIVACION="Desactivación del ";
	// NOMBRES DE PROCESOS
	public static final String PROCESS_IndicadorComPagoFact = "proceso IndicadorComPagoFact ";//El proceso IndicadorComPagoFact 
	public static final String PROCESS_TransformaBibes = "proceso TransformaBibes ";//El proceso TransformaBibes
	public static final String PROCESS_Transforma = "proceso Transforma ";//El proceso Transforma
	public static final String PROCESS_CoreCompagoBatch = "proceso CoreCompagoBatch ";//El proceso CoreCompagoBatch
	public static final String PROCESS_CancelacionBatch = "proceso CancelacionBatch ";//El proceso CancelacionBatch
	public static final String PROCESS_CMasiva = "proceso CargaMasivaComplementoPagoBatch ";//El proceso CargaMasivaComplementoPagoBatch

	// NOMBRES DE LOS SH PARA LEVANTAR
	// EN TEST
	public static final String Start_IndicadorComPagoFact = "indicadorProcesoCompPago-batch-shell.sh";
	public static final String Start_Transforma = "Transforma-batch-shell.sh";
	public static final String Start_TransformaBibes = "TransBibes-shell.sh"; // De este traer los parametros de la base
	public static final String Start_CoreCompagoBatch = "compPago-batch-shell.sh";
	public static final String Start_CancelacionBatch = "Cancelacion_cPago-batch.sh";
	public static final String Start_C_masiva_Compago_batch = "C_Masiva_compPago-batch-shell.sh";

	// EN PRODUCCION
	/*
	 * public static final String Start_CoreCompagoBatch="compPago-batch-shell.sh";
	 * public static final String Start_CancelacionBatch =
	 * "Cancelacion_cPago-batch.sh"; public static final String
	 * Start_C_masiva_Compago_batch ="C_Masiva_compPago-batch-shell.sh";
	 */
	// FIN DE NOMBRES DE LOS SH PARA LEVANTAR

	// NOMBRES DE LOS SH PARA BAJAR
	// TEST
	public static final String Kill_IndicadorComPagoFact = "kill-indicadorProcesoCompPago-batch-shell.sh";
	public static final String Kill_Transforma = "kill-Transforma-batch-shell.sh";
	public static final String Kill_TransformaBibes = "kill-TransformaBibes-batch-shell.sh"; // De este traer los
																								// parametros de la base
	public static final String Kill_CoreCompagoBatch = "kill-compPago-batch-shell.sh";
	public static final String Kill_CancelacionBatch = "kill-Cancelacion_cPago-batch.sh";
	public static final String Kill_C_masiva_Compago_batch = "kill-CMasiva_compPago-batch-shell.sh";

	// EN PRODUCCION
	/*
	 * public static final String
	 * Kill_CoreCompagoBatch="kill-compPago-batch-shell.sh"; public static final
	 * String Kill_CancelacionBatch = "kill-Cancelacion_cPago-batch.sh"; public
	 * static final String Kill_C_masiva_Compago_batch
	 * ="kill-CMasiva_compPago-batch-shell.sh";
	 */
	// FIN DE NOMBRES DE LOS SH PARA BAJAR

	/*
	 * PENDIENTES
	 *
	 * FIN DE PENDIENTES
	 */

	// RUTA DE LOS LOGS
	// EN TEST
	public static final String RUTA_DEL_LOG = "/complementopago/java/logs";
	// EN PRODUCCION
	// public static final String RUTA_DEL_LOG ="/compago/java/logs";
	// FIN DE RUTA DE LOS LOGS

	// NOMBRES DE LOS LOGS
	// EN TEST
	public static final String IndicadorComPagoFact = "ReporteDataStage.log";
	public static final String Transforma = "Transforma.log";
	public static final String TransformaBibes = "TransformaBibes.log";
	public static final String CoreCompagoBatch = "complementoPagoBatch.log";
	public static final String CancelacionCPBatch = "CancelacionComplementoPagoBatch.log";
	public static final String C_MasivaCPBatch = "CMasivaCcomplementoPagoBatch.log";

	// EN PRODUCCION
	/*
	 * public static final String CoreCompagoBatch="complementoPagoBatch.log";
	 * public static final String CancelacionCPBatch
	 * ="CancelacionComplementoPagoBatch.log"; public static final String
	 * C_MasivaCPBatch ="CMasivaCcomplementoPagoBatch.log";
	 */
	// FIN DE NOMBRES DE LOS LOGS

	// NUEVO LOG public static final String
	// ProcesosDetenidosCP="ProcesosDetenidos.log";
}
