/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
$(document).ready(function() {//INICIO DEL SCRIPT 
       //INICIO CANCELACIONES -ACTIVAR Y DESACTIVAR 
       $('#CancelacionCompPagoBatchDesactive').on('click', function(){ //Boton para bajar el proceso de carga masiva
    	$('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
    	$('#CancelacionCompPagoBatchActive').prop('disabled',true);
    
        $.ajax({
            type: "POST",
            url: "Bajar_proceso/6",
            beforeSend: function () {
           	 $("#contenedor_loading").show(1000);
               //$("#carga").html("Procesando activacion, espere por favor...");
            },
            success: function(response) {
            if(response=="Ya se encuentra inactivo"){
            	 $("#contenedor_loading").hide();
            	 $("#already_down").show();
        		 $("#already_down").hide(5000);
            		$('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
            		$('#CancelacionCompPagoBatchActive').prop('disabled',false);
            	
            	}else{
            		
            		 $("#contenedor_loading").hide();
            		 $('#CancelResult').css('color','#F11E1E');
            		 $('#CancelResult').html(response);
            		 $("#down_process").show();
            		 $("#down_process").hide(5000);
                     
                     $('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
                     $('#CancelacionCompPagoBatchActive').prop('disabled',false);
                     }
               
            }
        });
    }); 
    $('#CancelacionCompPagoBatchActive').on('click', function(){ //Boton para subir el procesos de Carga Masiva
    	$('#CancelacionCompPagoBatchActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
    	$('#CancelacionCompPagoBatchDesactive').prop('disabled',true); //Y SE HABILITA EL BOTON DE DESACTIVAR
    	
    	$.ajax({
            type: "POST",
            url: "Iniciar_proceso/6",
            beforeSend: function () {
           	 $("#contenedor_loading").show(1000);
               //$("#carga").html("Procesando activacion, espere por favor...");
            },
            success: function(response) {
            	if(response=="Ya se encuentra activo"){
            		$("#contenedor_loading").hide();
            		 $("#already_active").show();
            		 $("#already_active").hide(5000);
            		 $('#CancelacionCompPagoBatchActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
            		$('#CancelacionCompPagoBatchDesactive').prop('disabled',false); //Y SE HABILITA EL BOTON DE DESACTIVAR
            		
            		}else{ 
            		 $("#contenedor_loading").hide();
            		 $('#CancelResult').css('color','#10E21A');
            		 $('#CancelResult').html(response);
            		 $("#success_process").show();
            		 $("#success_process").hide(5000);
                     $('#CancelacionCompPagoBatchActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
                     $('#CancelacionCompPagoBatchDesactive').prop('disabled',false); //Y SE HABILITA EL BOTON DE DESACTIVAR
            	}
            },
        });
    });//FIN CANCELACIONES -ACTIVAR Y DESACTIVAR 
 /*   function Block_Buttoms(){
		 $('#ProcesadorIndicadorCPActive').prop('disabled',true);
        $('#ProcesadorIndicadorCPDesactive').prop('disabled',true);
		$('#TransformaBibesActive').prop('disabled',true);
		$('#TransformaBibesDesactive').prop('disabled',true);
		 $('#TransformaActive').prop('disabled',true);
  	     $('#TransformaDesactive').prop('disabled',true);
		 $('#CoreCompagoBatchActive').prop('disabled',true);
   	 $('#CoreCompagoBatchDesactive').prop('disabled',true);
		 $('#CargaMasivaActive').prop('disabled',true);
		 $('#CargaMasivaDesactive').prop('disabled',true);
		// $('#CancelacionCompPagoBatchActive').prop('disabled',true);
		// $('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
}
function Desblock_Buttoms(){
	 $('#ProcesadorIndicadorCPActive').prop('disabled',false);
    $('#ProcesadorIndicadorCPDesactive').prop('disabled',false);
	$('#TransformaBibesActive').prop('disabled',false);
	 $('#TransformaBibesDesactive').prop('disabled',false);
	 $('#TransformaActive').prop('disabled',false);
	 $('#TransformaDesactive').prop('disabled',false);
	 $('#CoreCompagoBatchActive').prop('disabled',false);
	 $('#CoreCompagoBatchDesactive').prop('disabled',false);
	 $('#CargaMasivaActive').prop('disabled',false);
	 $('#CargaMasivaDesactive').prop('disabled',false);
	 //$('#CancelacionCompPagoBatchActive').prop('disabled',false);
	 //$('#CancelacionCompPagoBatchDesactive').prop('disabled',false);
}*/
});//FIN DEL SCRIPT 