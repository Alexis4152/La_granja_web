/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
$(document).ready(function() {//INICIO DEL SCRIPT 
     //INICIO CARGA MASIVA -ACTIVAR Y DESACTIVAR 
    $('#CargaMasivaDesactive').on('click', function(){ //Boton para bajar el proceso de carga masiva 	
    	$('#CargaMasivaDesactive').prop('disabled',true);
    	$('#CargaMasivaActive').prop('disabled',true);

        $.ajax({
            type: "POST",
            url: "Bajar_proceso/5",
            beforeSend: function () 	{
            	 $("#contenedor_loading").show(1000);
               // $("#carga").html("Procesando baja, espere por favor...");
             },
            success: function(response) {
            if(response=="Ya se encuentra inactivo"){
            	 $("#contenedor_loading").hide();
            		 $("#already_down").show();
            		 $("#already_down").hide(5000);
            		$('#CargaMasivaDesactive').prop('disabled',true);
            		$('#CargaMasivaActive').prop('disabled',false);
            		
            	}else{
            		 $("#contenedor_loading").hide();
            		 $('#CMasivaResult').css('color','#F11E1E');
            		 $('#CMasivaResult').html(response);
            		
                     $("#down_process").show();
            		 $("#down_process").hide(5000);
                     $('#CargaMasivaDesactive').prop('disabled',true);
                     $('#CargaMasivaActive').prop('disabled',false);
                     }
               
            }
        });
    }); 
    $('#CargaMasivaActive').on('click', function(){ //Boton para subir el procesos de Carga Masiva
    	$('#CargaMasivaActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
    	$('#CargaMasivaDesactive').prop('disabled',true); //Y SE HABILITA EL BOTON DE DESACTIVAR

    	$.ajax({
            type: "POST",
            url: "Iniciar_proceso/5",
            beforeSend: function () {
            	 $("#contenedor_loading").show(1000);
                //$("#carga").html("Procesando activacion, espere por favor...");
             },
            success: function(response){
            	if(response=="Ya se encuentra activo"){
            		 $("#contendor_loading").hide();
            		 $("#already_active").show();
            		 $("#already_active").hide(5000);
            		$('#CargaMasivaActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
            		$('#CargaMasivaDesactive').prop('disabled',false); //Y SE HABILITA EL BOTON DE DESACTIVAR
            		
            	}else{
            		 $("#contenedor_loading").hide();
            		 $('#CMasivaResult').css('color','#10E21A');
            		 $('#CMasivaResult').html(response);
            		 $("#success_process").show();
            		 $("#success_process").hide(5000);
            		 $('#CargaMasivaActive').prop('disabled',true); //UNA VEZ DANDO CLIC EN EL BOTON DE ACTIVAR SE INHABILITA
                     $('#CargaMasivaDesactive').prop('disabled',false); //Y SE HABILITA EL BOTON DE DESACTIVAR
                    }
            },
        });
    });//FIN CARGA MASIVA -ACTIVAR Y DESACTIVAR 
  /*  function Block_Buttoms(){
		 $('#ProcesadorIndicadorCPActive').prop('disabled',true);
       $('#ProcesadorIndicadorCPDesactive').prop('disabled',true);
		$('#TransformaBibesActive').prop('disabled',true);
		$('#TransformaBibesDesactive').prop('disabled',true);
		 $('#TransformaActive').prop('disabled',true);
 	     $('#TransformaDesactive').prop('disabled',true);
		 $('#CoreCompagoBatchActive').prop('disabled',true);
  	 $('#CoreCompagoBatchDesactive').prop('disabled',true);
		// $('#CargaMasivaActive').prop('disabled',true);
		 //$('#CargaMasivaDesactive').prop('disabled',true);
		$('#CancelacionCompPagoBatchActive').prop('disabled',true);
		$('#CancelacionCompPagoBatchDesactive').prop('disabled',true);
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
	// $('#CargaMasivaActive').prop('disabled',false);
	 //$('#CargaMasivaDesactive').prop('disabled',false);
	 $('#CancelacionCompPagoBatchActive').prop('disabled',false);
	 $('#CancelacionCompPagoBatchDesactive').prop('disabled',false);
}*/
});//FIN DEL SCRIPT 