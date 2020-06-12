/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
$(document).ready(function(){//INICIO DEL SCRIPT - TOMA LA PRIMER PARTE DEL EVENTO QUE ES DETECTAR LO QUE SE ESTA ESCRIBIENDO EN EL INPUT
	$('#Boton_guardar').prop('disabled',true);
	
	function COMPROBAR_SI_YA_SE_PUEDE_ACTIVAR_EL_BOTON_ADD(){
		var a= $('#CLAVE_ADDING').val();
		var b= $('#VALOR_ADDING').val();
		var d= $('#DESCRIPCION_ADDING').val();
		if(a!=""
			&&b!=""
			&&d!=""){ //Si todos los campos para agregar un nuevo parametro no estan vacios se activa el boton
			$('#Boton_guardar').prop('disabled',false); //CUANDO TODOS LOS PARAMETROS TIENE VALOR SE PUEDE HABILITAR EL BOTON DE GUARDAR
			$('#NO_SE_PUEDE_GUARDAR_CLAVE').html("");
			$('#NO_SE_PUEDE_GUARDAR_VALOR').html("");
			$('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').html("");
		}
		else{
			$('#Boton_guardar').prop('disabled',true);//CUANDO POR LO MENOS HAY UN CAMPO QUE NO TIENE PARAMETRO
		}
	}
	
	$('#CLAVE_ADDING').keyup(function (e) { //EL BUSCADOR
		var filter= $('#CLAVE_ADDING').val();
		if(filter.length>0){ //SI TIENE AL MENOS UN VALOR	
			COMPROBAR_SI_YA_SE_PUEDE_ACTIVAR_EL_BOTON_ADD(); //$('#Boton_guardar').prop('disabled',false);
			$('#NO_SE_PUEDE_GUARDAR_CLAVE').html("");
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			$('#NO_SE_PUEDE_GUARDAR_CLAVE').css('color','#F11E1E'); 
			$('#NO_SE_PUEDE_GUARDAR_CLAVE').html("COMPLETA ESTE DATO POR FAVOR");
			  $('#Boton_guardar').prop('disabled',true);
		}
	});
	$('#VALOR_ADDING').keyup(function (e) { //EL BUSCADOR
		var filter= $('#VALOR_ADDING').val();
		if(filter.length>0){ //SI TIENE AL MENOS UN VALOR
			COMPROBAR_SI_YA_SE_PUEDE_ACTIVAR_EL_BOTON_ADD();// $('#Boton_guardar').prop('disabled',false);
			$('#NO_SE_PUEDE_GUARDAR_VALOR').html("");
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			$('#NO_SE_PUEDE_GUARDAR_VALOR').css('color','#F11E1E');
			$('#NO_SE_PUEDE_GUARDAR_VALOR').html("COMPLETA ESTE DATO POR FAVOR");
			  $('#Boton_guardar').prop('disabled',true);
		}
	});
	$('#APLICATIVO_ADDING').keyup(function (e) { //EL BUSCADOR
		var filter= $('#APLICATIVO_ADDING').val();
		if(filter.length>0){ //SI TIENE AL MENOS UN VALOR	
			COMPROBAR_SI_YA_SE_PUEDE_ACTIVAR_EL_BOTON_ADD();// $('#Boton_guardar').prop('disabled',false);
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			$('#NO_SE_PUEDE_GUARDAR_APLICATIVO').css('color','#F11E1E');
			$('#NO_SE_PUEDE_GUARDAR_APLICATIVO').html("COMPLETA ESTE DATO POR FAVOR");
			  $('#Boton_guardar').prop('disabled',true);
		}
	});
	$('#DESCRIPCION_ADDING').keyup(function (e) { //EL BUSCADOR
		var filter= $('#DESCRIPCION_ADDING').val();
		if(filter.length>0){ //SI TIENE AL MENOS UN VALOR	
			 COMPROBAR_SI_YA_SE_PUEDE_ACTIVAR_EL_BOTON_ADD(); //$('#Boton_guardar').prop('disabled',false);
			 $('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').html("");
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			$('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').css('color','#F11E1E');
			$('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').html("COMPLETA ESTE DATO POR FAVOR");
			  $('#Boton_guardar').prop('disabled',true);
		}
		
	});
	
	$('#Boton_cerrar').on('click', function(){ //Boton para bajar el proceso de carga masiva
		 //LOS CAMPOS DE TEXTO PARA AGREGAR NUEVO PARAMETRO
        $('#CLAVE_ADDING').val("");//YA FUNCIONA ESTO DE LIMPIAR CUANDO SE SALE DE LA VENTANA MODAL
        $('#VALOR_ADDING').val("");//A LOS CAMPOS DE TEXTO SE LES MANEJA COMO .VAL
        $('#DESCRIPCION_ADDING').val("");
        //LAS ETIQUETAS QUE MUESTRAN EL MENSAJE CUANDO EL CAMPO NO DEBE DE ESTAR VACIO
        $('#NO_SE_PUEDE_GUARDAR_CLAVE').html("");//A LAS ETIQUETAS SE LES MANEJA COMO .HTML
        $('#NO_SE_PUEDE_GUARDAR_VALOR').html("");
        $('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').html("");
        $('#Boton_guardar').prop('disabled',true);
	}); //FIN DE BIBES ACTIVAR Y DESACTIVAR 
	var modal = document.getElementById('mod');
	//CUANDO EL USUARIO DA CLIC EN CUALQUIER PARTE FUERA DEL MODAL, EL MODAL SE CIERRA
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	        //LOS CAMPOS DE TEXTO PARA AGREGAR NUEVO PARAMETRO
	        $('#CLAVE_ADDING').val("");//YA FUNCIONA ESTO DE LIMPIAR CUANDO SE SALE DE LA VENTANA MODAL
	        $('#VALOR_ADDING').val("");//A LOS CAMPOS DE TEXTO SE LES MANEJA COMO .VAL
	        $('#DESCRIPCION_ADDING').val("");
	        //LAS ETIQUETAS QUE MUESTRAN EL MENSAJE CUANDO EL CAMPO NO DEBE DE ESTAR VACIO
	        $('#NO_SE_PUEDE_GUARDAR_CLAVE').html("");//A LAS ETIQUETAS SE LES MANEJA COMO .HTML
	        $('#NO_SE_PUEDE_GUARDAR_VALOR').html("");
	        $('#NO_SE_PUEDE_GUARDAR_DESCRIPCION').html("");
	        $('#Boton_guardar').prop('disabled',true);
	    }
	}
	$('#search').keyup(function (e) { //EL BUSCADOR
		var filter= $('#search').val();
		if(filter.length>0){ //SI TIENE AL MENOS UN VALOR	
			cargar_consulta_like(filter); //filter es la cadena o caracter escrito en ese momento
			$('#info').html("")
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			cargar_consulta_select_all();
		}
	});//YA RECIBE VALOR POR PARTE DEL EVENTOO
	$('#InputUpdate').keyup(function (e) {//EL DATO SELECCIONADO
		var filter= $('#InputUpdate').val();
		var id= $('#ID').val(); //Se evalua el id que corresponde al dato que se está actualizando en el momento
		if(filter.length>0&&filter.length<200){ //CUANDO ESTA EN EL RANGO PERMITIDO DE VALORES POR LA BD
			//alert("condicion filter");
			if(id==5){ //VALIDANDO QUE UNICAMENTE SEA EL CAMPO DE REGIONESEJECUTAR PARA VALIDAR SU CADENA
				if(id.length>0 && id.length<=25){
					//alert("es regiones ejecutar");
					//const regexindividual = /^\w([CE\CM\R\1-9]{1})/
					const regexfull  = 
/(([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\1-9]{1})[,]{1}([CE\CM\R\-1-9]{1}))$/g
					
			if(filter.match(regexfull)){ //ESTO ES CUANDO SE CUMPLE LA CONDICIÓNN DEL REGEX
						//   alert("cadena coincide con la regex");
					    $('#UpdateRegiones').prop('disabled',false);
					    $('#info').html("");
				        }
		
					else{ //Cuando la cadena no coincide
						$('#info').html("");
						//Salert("no entra a la concidión");
						 $('#UpdateRegiones').prop('disabled',true);
					}
				}else{
					alert("Texto largo");
					 $('#info').html("");
				}	
			}
			else if(id!=5&&id>0){//VALIDANDO CUALQUIER OTRO DATO QUE NO SEA EL ID 5
				const regexindividual = /^\w([A-Za-z0-9])/g //^([a-zA-Z\d])/g
					
			if(filter.match(regexindividual)){ //ESTO ES CUANDO SE CUMPLE LA CONDICIÓNN DEL REGEX, EL BOTÓN ES VALIDO
				    $('#UpdateRegiones').prop('disabled',false);
				    $('#info').html("");
			        }
	
				else{ //Cuando la cadena no coincide, ENTONCES EL BOTÓN SE BLOQUEA
					$('#info').html("");
					//Salert("no entra a la concidión");
					 $('#UpdateRegiones').prop('disabled',true);
				}
			}
		}else if(filter.length==0||filter.length<0){ //CUANDO NO TIENE NINGUN VALOR, REFRESCA LA VISTA MOSTRANDO TODOS LOS DATOS		 
			$('#info').html("No se permiten valores vacios.");
			 $('#UpdateRegiones').prop('disabled',true);
		}else if (filter.length>=200){//CUANDO ESTA FUERA DEL RANGO DE VALORES PERMITIDOS POR EL SERVIDOR
			 $('#UpdateRegiones').prop('disabled',true);
			$('#info').html("El maximo de caracteres permitido es de 200, la longitud que ingresas es de: "+filter.length+" caracteres.");
		}
	});//YA RECIBE VALOR POR PARTE DEL EVENTOO
});//FIN DEL SCRIPT 

function cargar_consulta_like(filter){//SpringContactMVCComplete/src/main/java/org/contact/controller/ContactController.java
	var url = "/PortalAplicativosComplementoPago/ConsultaLikePARAMETROS/"+filter; //-RUTA CORRECTA- YA LLEGO A ENVIARLE EL VALOR POR LA URL, FALTA RECIBIR BIEN LA RESPUESTA
	 $('#cuerpo').load(url, function(response, status, xhr) {

		 if(status=="error"){	
			 $('#info').html("error por "+xhr.status+" "+xhr.statusText)
		 }
		
		
    });
	 return false;
	}
function cargar_consulta_select_all(){//SpringContactMVCComplete/src/main/java/org/contact/controller/ContactController.java
	var url = "/PortalAplicativosComplementoPago/Consulta_SELECT_ALL_PARAMETROS"; //-RUTA CORRECTA- YA LLEGO A ENVIARLE EL VALOR POR LA URL, FALTA RECIBIR BIEN LA RESPUESTA
	 $('#cuerpo').load(url, function(response, status, xhr) { //BUSCAR EL XMLHTTPREQUEST
		 if(status=="error"){
			 $('#info').html("error por "+xhr.status+" "+xhr.statusText)
		 }
		 else{
		 }
    });
	 return false;
	}
function confirmacion(){
alert("¿Estas seguro?");
}