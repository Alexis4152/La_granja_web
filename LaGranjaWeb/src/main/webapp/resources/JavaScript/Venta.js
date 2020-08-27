/**
 * SE DEBE ACTUALIZAR LA PAGINA DEL JSP EN LA PARTE DE EJECUCIÓN PARA QUE TOME LOS NUEVOS
 * CAMBIOS QUE SE LE HAGAN AL ARCHIVO .JS
 */
$(document).ready(function(){//INICIO DEL SCRIPT - TOMA LA PRIMER PARTE DEL EVENTO QUE ES DETECTAR LO QUE SE ESTA ESCRIBIENDO EN EL INPUT
	//BLOQUEAMOS LOS SIGUIENTES TRES INPUTS

	
	/*$('#Monto_del_subtotal').prop('disabled',true);
	$('#Monto_del_total').prop('disabled',true);
	$('#Monto_del_cambio').prop('disabled',true);*/
	$('#Monto_del_cambio').val(0);
	
	
	
	
	var modal = document.getElementById('mod');
	//CUANDO EL USUARIO DA CLIC EN CUALQUIER PARTE FUERA DEL MODAL, EL MODAL SE CIERRA
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	        //Se pueden agregar eventos o acciones al cerrar el modal
	    }
	}
	$('#Boton_crudo').on('click', function(){ 
		var tipo_producto ="Crudo";
		VER_PRODUCTOS_POR_CATEGORIA(tipo_producto);
		document.getElementById('mod').style.display='block';
		style="width:auto;";
	});  
	$('#Boton_cocido').on('click', function(){ 
		var tipo_producto ="Cocido";
		VER_PRODUCTOS_POR_CATEGORIA(tipo_producto);
		document.getElementById('mod').style.display='block';
		style="width:auto;";
	});
	$('#Boton_adicionales').on('click', function(){ 
		var tipo_producto ="Adicionales";
		VER_PRODUCTOS_POR_CATEGORIA(tipo_producto);
		document.getElementById('mod').style.display='block';
		style="width:auto;";
	});
	$('#Monto_del_descuento').keyup(function(e){ //MONTO DEL DESCUENTO
		var subtotal= $('#Monto_del_subtotal').val();
		var descuento= $('#Monto_del_descuento').val();
		var pago = $('#Monto_del_pago').val();
		var total= $('#Monto_del_total').val();
		if(subtotal>0&&descuento>0&&subtotal>descuento){//Aplicando el descuento
			$('#Monto_del_total').val(subtotal-descuento); 
			if(pago>0){
				$('#Monto_del_cambio').val(pago-total); 
			}
		}else if(subtotal==0||subtotal<0){
			alert("No hay un total de esta venta para aplicar descuento");
			$('#Monto_del_total').val(subtotal); 
		}
		else if(descuento>subtotal||descuento==subtotal){
			alert("El descuento no puede ser mayor o igual al total");
			$('#Monto_del_total').val(subtotal); 
		}else if(descuento<=0){
			$('#Monto_del_total').val(subtotal); 
		}
	});//MONTO DEL DESCUENTO
	$('#Monto_del_pago').keyup(function(e){ //MONTO DEL DESCUENTO
		var total= $('#Monto_del_total').val();
		var pago = $('#Monto_del_pago').val();
		if(total>0&&pago>0&&pago>=total){//Aplicando el descuento
			$('#Monto_del_cambio').val(pago-total); 
		}
		else if(pago<=0){
			$('#Monto_del_cambio').val(0); 
		}
		else if(total<=0){
			alert("No hay un total a pagar"); 
			$('#Monto_del_cambio').val(0);
		}
	});//MONTO DEL DESCUENTO
	/*$('#Pagar_venta').on('click', function(){ 
		var subtotal= $('#Monto_del_subtotal').val();
		var descuento= $('#Monto_del_descuento').val();
		var total= $('#Monto_del_total').val();
		var pago = $('#Monto_del_pago').val();
		var cambio= $('#Monto_del_cambio').val();
		INSERTAR_EN_TABLA_VENTA(subtotal,descuento,total,pago,cambio);
		document.getElementById('mod').style.display='block';
		style="width:auto;";
	});*/
	
	
});
function VER_PRODUCTOS_POR_CATEGORIA(tipo){
	var url = "/PolleriaLaGranja/MOSTRAR_PRODUCTOS_POR_CATEGORIA/"+tipo;
	 $('#Products_body').load(url, function(response, status, xhr) {
	
    });
	 return false;
	}
function INSERTAR_EN_TABLA_VENTA(subtotal,descuento,total,pago,cambio){
	var url = "/PolleriaLaGranja/PAGAR_VENTA/"+subtotal+"/"+descuento+"/"+total+"/"+pago+"/"+cambio;
	 $('#Products_body').load(url, function(response, status, xhr) {
	
    });
	 return false;
	}