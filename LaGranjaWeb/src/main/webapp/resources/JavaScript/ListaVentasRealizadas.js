/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
$(document).ready(function(){//INICIO DEL SCRIPT - TOMA LA PRIMER PARTE DEL EVENTO QUE ES DETECTAR LO QUE SE ESTA ESCRIBIENDO EN EL INPUT
	//var datos = eval('${Lista_de_ventas}');
$('#VENTAS_REALIZADAS').DataTable( {
    "ajax":{
       "url": "ListaDeVentas",
        dataSrc: '' 
     }, 
    'columns': [
        { "data": "id_venta" },
        { "data": "subtotal" },
        { "data": "descuento"},
        { "data": "total" },	
        { "data": "pago" },	
        { "data": "cambio" },	
        { "data": "fecha" },	
        { "defaultContent": "<button type='button' class='editar btn btn-primary'><i class='fa fa-pencil-square-o'></i></button>	<button type='button' class='eliminar btn btn-danger' data-toggle='modal' data-target='#modalEliminar' ><i class='fa fa-trash-o'></i></button>" }	 
    ]
   // language: idioma_espaniol
});

 $.ajax({
        type: "POST",
        url: "VENTAS_REALIZADAS/1",
        beforeSend: function (){
        	 $("#contenedor_loading").show(1000);
          // $("#carga").html("Procesando baja, espere por favor...");
        },
        success: function(response) {
        if(response=="Ya se encuentra activo"){
        	$("#contenedor_loading").hide();
        	$("#already_active").show();
   		 $("#already_active").hide(5000);
                $('#ProcesadorIndicadorCPActive').prop('disabled',true);
                $('#ProcesadorIndicadorCPDesactive').prop('disabled',false);
             
            }else{
            	
            	$("#contenedor_loading").hide();
                 $('#IndicadorResult').css('color','#10E21A');
                 $('#IndicadorResult').html(response);
                
                 $("#success_process").show();
        		 $("#success_process").hide(5000);
                 $('#ProcesadorIndicadorCPActive').prop('disabled',true);
                 $('#ProcesadorIndicadorCPDesactive').prop('disabled',false);
                 }
           
        }
    });
});
