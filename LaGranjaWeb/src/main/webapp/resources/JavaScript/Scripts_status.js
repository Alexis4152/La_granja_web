/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
window.onload= function(){ //PARA MOSTRAR LA IMAGEN DE CARGANDO DEL SITIO WEB ANTES DE QUE CARGUE EL SITIO WEB
	    	var contenedor = document.getElementById('contenedor_carga'); //ESTE ES EL CONTENEDOR PARA CUANDO SE ESTE CARGANDO LA PAGINA 
	    	contenedor.style.visibility = 'hidden';
	     	contenedor.style.opacity = '0';
}//PARA MOSTRAR LA IMAGEN DE CARGANDO DEL SITIO WEB

$(document).ready(function() {//INICIO DEL SCRIPT - ESTE EVENTO ES UNA VEZ YA HAYA CARGADO TODO LA PAGINA CON TODOS SUS ELEMENTOS
	$('#UpdateRegiones').prop('disabled',true);

	var inputParam = $('#InputUpdate').val();
   if(inputParam==""){
	   $('#UpdateRegiones').prop('disabled',true);
   }else{
	   $('#UpdateRegiones').prop('disabled',false);
   }  
   $('#InputUpdate').keyup(function (e) {
		var inputUpdate= $('#InputUpdate').val();
		if(inputUpdate.length>0){ //SI TIENE AL MENOS UN VALOR
				$('#UpdateRegiones').prop('disabled',false);
		}else{ //CUANDO NO TIENE NINGUN VALOR, INACTIVA EL BOTON DE GUARDAR CAMBIOS
			$('#UpdateRegiones').prop('disabled',true);
		}
   });
   $('#Username').keyup(function (e) {
		var inputUpdate= $('#Username').val();
		if(inputUpdate.length>0){ //SI TIENE AL MENOS UN VALOR
			$('#respuestalogin').html("Campos vacios");
		}else{ //CUANDO NO TIENE NINGUN VALOR, INACTIVA EL BOTON DE GUARDAR CAMBIOS
			$('#respuestalogin').html("");
		}
  });
	$("#contenedor_loading").hide();//ESTA ES LA CARGA PARA CUANDO SE DE CLIC A ALGUN BOTÓN	
	//ALERTAS
	$("#already_active").hide();
	$("#already_down").hide();
	$("#success_process").hide();
	$("#down_process").hide();
	var indicador = $('#IndicadorResult').html();
	var bibes =  $('#TransformaBibesResult').html();
	var transforma =$('#TransformaResult').html();
	var core =  $('#CoreCPResult').html();
	var cmasiva =  $('#CMasivaResult').html();
	var cancel = $('#CancelResult').html();

	if(indicador=="Activo"){
		 $('#ProcesadorIndicadorCPActive').prop('disabled',true);
         $('#ProcesadorIndicadorCPDesactive').prop('disabled',false);
	}else{
		 $('#ProcesadorIndicadorCPActive').prop('disabled',false);
         $('#ProcesadorIndicadorCPDesactive').prop('disabled',true);
	}
	if(bibes=="Activo"){
		 $('#TransformaBibesActive').prop('disabled',true);
		    $('#TransformaBibesDesactive').prop('disabled',false);
	}else{
		 $('#TransformaBibesActive').prop('disabled',false);
		    $('#TransformaBibesDesactive').prop('disabled',true);
	}
	if(transforma=="Activo"){
		$('#TransformaActive').prop('disabled',true);
    	$('#TransformaDesactive').prop('disabled',false);
	}else{
		$('#TransformaActive').prop('disabled',false);
    	$('#TransformaDesactive').prop('disabled',true);
	}
	if(core=="Activo"){
		$('#CoreCompagoBatchActive').prop('disabled',true);
    	$('#CoreCompagoBatchDesactive').prop('disabled',false);
	}else{
		$('#CoreCompagoBatchActive').prop('disabled',false);
    	$('#CoreCompagoBatchDesactive').prop('disabled',true);
	}
	if(cmasiva=="Activo"){
		$('#CargaMasivaActive').prop('disabled',true);
		$('#CargaMasivaDesactive').prop('disabled',false);
	}else{
		$('#CargaMasivaActive').prop('disabled',false);
		$('#CargaMasivaDesactive').prop('disabled',true);
	}
	if(cancel=="Activo"){
		$('#CancelacionCompPagoBatchActive').prop('disabled',true);
		$('#CancelacionCompPagoBatchDesactive').prop('disabled',false);
	}else{
		$('#CancelacionCompPagoBatchActive').prop('disabled',false);
		$('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
	}

	function kill_all(select_item){//SpringContactMVCComplete/src/main/java/org/contact/controller/ContactController.java
		var url = "/Spring3HibernateMaven/ConsultaLikePARAMETROS/"+filter; //-RUTA CORRECTA- YA LLEGO A ENVIARLE EL VALOR POR LA URL, FALTA RECIBIR BIEN LA RESPUESTA
		 $('#cuerpo').load(url, function(response, status, xhr) {
			 if(status=="error"){	
				 $('#info').html("error por "+xhr.status+" "+xhr.statusText)
			 }
			 else{
			 }
	    });
		 return false;
		}
	$("#main").on("click",mostrarcarga) //BOTON DE MENU PRINCIPAL 
    $("#imagenredirect").on("click",mostrarcarga)//LA IMAGEN DEL LOGO DE TELCEL 
    $("#appsredirect").on("click",mostrarcarga)//LA IMAGEN DEL LOGO DE TELCEL  //PARTE DEL MENU DE OPCIONES
    $("#dataredirect").on("click",mostrarcarga)//LA IMAGEN DEL LOGO DE TELCEL  //PARTE DEL MENU DE OPCIONES
    $("#memoryredirect").on("click",mostrarcarga)//LA IMAGEN DEL LOGO DE TELCEL /PARTE DEL MENU DE OPCIONES
	$("#linkindicador").on("click",mostrarcarga)//LOS
	$("#linkbibes").on("click",mostrarcarga)//DIFERENTES
	$("#linktransforma").on("click",mostrarcarga)//APLICATIVOS
	$("#linkcore").on("click",mostrarcarga)//MOSTRANDO
	$("#linkcmasiva").on("click",mostrarcarga)//EL LINK 
	$("#linkcancel").on("click",mostrarcarga)//CORRESPONDIENTE DE SU VISTA
	$("#update_bibes_execution").on("click",mostrarcarga)//CAMBIA EL TIPO DE PROCESO QUE SE ESTA EJECUTANDO EN EL PROCESO BIBES 
	
	$("#UpdateRegiones").on("click",mostrarcarga)//EL BOTON PARA ACTUALIZAR DATOS EN LA BASE DE DATOS
    $(document).on('change', '#opciones', function(event) { //EL MENU DE OPCIONES DEL MENU PRINCIPAL
		mostrarcarga();
	});
	function mostrarcarga(){
		 $("#contenedor_loading").show(); //EL GIF DE CARGANDO QUE VA EN RELACION A CUANDO SE EJEJCUTA ALGUN PROCESO EN EL SERVIDOR 
		 $("#contenedor_loading").hide(40000); // SE OCULTA DESPUES DE 40 SEGUNDOS, ESTO PARA MEDIR EL TIEMPO DE LA ULTIMA PETICIÓN)
		 //CUANDO SE LLEGUEN A ACTIVAR MÁS DE 1 PROCESO, SE TENDRÍA QUE AUMENTAR EL TIEMPO DE ESPERA PARA SER DESACTIVADO
S	}
});//FIN DEL SCRIPT 