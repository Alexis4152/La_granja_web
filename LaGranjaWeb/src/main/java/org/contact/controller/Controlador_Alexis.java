package org.contact.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.contact.model.VENTA;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.contact.model.PARAMETROS;
import org.contact.model.PRODUCTOS;
import org.contact.service.JdbcServicio_Acceso_Usuarios_Alexis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.telcel.util.Constantes;
import mx.telcel.util.Herramientas;


//ANNOTATIONS BY SPRING
@Controller
public class Controlador_Alexis {
	
	@Autowired
	private JdbcServicio_Acceso_Usuarios_Alexis SERVICIO;
	
	//Interface
	//Clase que implementa a la interface del servicio
	//Interface del dao
	//Clase que implementa la interface del dao = aqui se hacen las consultas
	
	//DAO
	//DATA
	//ACCESS
	//OBJECT

	@RequestMapping("/Venta")
	public String VENTA(Model modelo){
		modelo.addAttribute("Productos_en_venta",Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA);
		modelo.addAttribute("Total",Constantes.TOTAL_DE_VENTA);	
		modelo.addAttribute("Venta",new VENTA());
		return "Venta";
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/MOSTRAR_PRODUCTOS_POR_CATEGORIA/{key}", method = RequestMethod.GET)//A CONSIDERAR POR EL NOMBRE DEL USUARIO LA LISTA DE PARAMETROS A LAS CUALES PODRA TENER ACCESO
	public ModelAndView MOSTRAR_PRODUCTOS_POR_CATEGORIA(@PathVariable("key") String TIPO_PRODUCTO, ModelMap model) {
	   	   model.put("Productos", Constantes.PRODUCTOS=SERVICIO.MOSTRAR_PRODUCTOS(TIPO_PRODUCTO));
	       return new ModelAndView("/Productos_por_categoria",model); //CON PARAMETROS SOLO SE REFRESCA LA PARTE DE LA TABLA PARAMETROS MANDANDO LA INFO NUEVA
	}	
	@RequestMapping(value ="/AGREGAR_PRODUCTO_A_VENTA/{ID_PRODUCTO}/{NOMBRE_PRODUCTO}/{PRECIO}")
	public String AGREGAR_A_VENTA(@PathVariable("ID_PRODUCTO") int ID_PRODUCTO,@PathVariable("NOMBRE_PRODUCTO") String NOMBRE,
			@PathVariable("PRECIO") float PRECIO) throws Exception { Herramientas a = new Herramientas();
		if (ID_PRODUCTO ==12 || ID_PRODUCTO ==15) { //SI EL ID_PRODUCTO CORRESPONDE A MEDIA PECHUGA O PECHUGA EN BISTECK, ENTONCES SE MANDA EL ID DE LA PECHUGA
			if(ID_PRODUCTO ==15) {Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(2),2,NOMBRE,PRECIO,1);}//CUANDO ES PECHUGA EN BISTECK SE LE PASA EL ID DE LA PECHUGA
			if(ID_PRODUCTO ==12) {Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(2),2,NOMBRE,PRECIO, (float)0.5);} //SI ES MEDIA PECHUGA MANDAMOS MEDIA CANTIDAD CON EL ID 2 DE PECHUGA
		}
	    else if(ID_PRODUCTO==1||ID_PRODUCTO==11||ID_PRODUCTO==13||ID_PRODUCTO==14) {//SI EL ID ES IGUAL A: POLLO COMP. / MEDIO POLLO / PIERNA COMPLETA / HUACAL COMPLETO
			if(ID_PRODUCTO==1){// POLLO COMPLETO
		Constantes.POLLO_ENTERO=SERVICIO.OBTENER_PRODUCTOS_PARA_PAQUETE("2,3,4,5,6,7,8,9,10");for(PRODUCTOS RUN : Constantes.POLLO_ENTERO) {
					Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(RUN.getID_PRODUCTO()),RUN.getID_PRODUCTO(),RUN.getNOMBRE_PRODUCTO(),RUN.getPRECIO(),RUN.getCANTIDAD());
				}Constantes.POLLO_ENTERO.clear();}
			else if(ID_PRODUCTO==11) {//MEDIO POLLO
				Constantes.MEDIO_POLLO=SERVICIO.OBTENER_PRODUCTOS_PARA_PAQUETE("2,3,4,5,6,9,10");for(PRODUCTOS RUN : Constantes.MEDIO_POLLO) {
					Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(RUN.getID_PRODUCTO()),RUN.getID_PRODUCTO(),RUN.getNOMBRE_PRODUCTO(),RUN.getPRECIO(),RUN.getCANTIDAD());
				}Constantes.MEDIO_POLLO.clear();}
			else if(ID_PRODUCTO==13) {//PIERNA COMPLETA
				Constantes.PIERNA_COMPLETA=SERVICIO.OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS("3,4");for(PRODUCTOS RUN : Constantes.PIERNA_COMPLETA) {
					Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(RUN.getID_PRODUCTO()),RUN.getID_PRODUCTO(),RUN.getNOMBRE_PRODUCTO(),RUN.getPRECIO(),1);
				}Constantes.PIERNA_COMPLETA.clear();}
			else if(ID_PRODUCTO==14) {//HUACAL COMPLETO
				Constantes.HUACAL_COMPLETO=SERVICIO.OBTENER_PRODUCTOS_PIERNA_HUACAL_COMPLETOS("6,7");for(PRODUCTOS RUN : Constantes.HUACAL_COMPLETO) {
					Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(RUN.getID_PRODUCTO()),RUN.getID_PRODUCTO(),RUN.getNOMBRE_PRODUCTO(),RUN.getPRECIO(),1);
				}Constantes.HUACAL_COMPLETO.clear();}
		}else{//SE AGREGA UN PRODUCTO NORMAL
			Herramientas.AGREGAR_PRODUCTO_A_LISTA(SERVICIO.REVISAR_SI_HAY_EXISTENCIA_DE_PRODUCTO(ID_PRODUCTO),ID_PRODUCTO,NOMBRE,PRECIO,1);
		}
		   return "redirect:/Venta";
	} 
	
	@RequestMapping(value ="/ELIMINAR_PRODUCTO_DE_VENTA/{ID_PRODUCTO}")
	public String ELIMINAR_PRODUCTO_DE_VENTA(@PathVariable("ID_PRODUCTO") int ID_PRODUCTO) throws Exception { 
		  Herramientas.ELIMINAR_PRODUCTO_DE_VENTA(ID_PRODUCTO);
		   return "redirect:/Venta";
	} 
	
	@RequestMapping(value ="/LIMPIAR_TODA_LA_VENTA")
	public String LIMPIAR_TODA_LA_VENTA() throws Exception { 
		  Herramientas.LIMPIAR_TODA_LA_VENTA();
		   return "redirect:/Venta";
	} 
	
	//VALIDADO CON EL JDBC
    @RequestMapping(value = "/PAGAR_VENTA", method = RequestMethod.POST) //PARA AGREGAR
	public String addContact(@ModelAttribute("Venta")  VENTA NUEVA_VENTA, BindingResult result) {
    	NUEVA_VENTA.setESTADO_VENTA("REALIZADA");
    	NUEVA_VENTA.setID_USUARIO(SERVICIO.OBTENER_ID_USUARIO(Herramientas.USUARIO_LOGGEADO()));
    	SERVICIO.INSERTAR_DATOS_EN_LA_TABLA_VENTA(NUEVA_VENTA);
    	SERVICIO.INSERTAR_DATOS_EN_LA_TABLA_DESCRIPCION_DE_VENTA(Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA, 200);
    	SERVICIO.DESCONTAR_DE_INVENTARIO(Constantes.PRODUCTOS_ACTUALMENTE_EN_VENTA, 200);
    	Herramientas.LIMPIAR_TODA_LA_VENTA();
		return "redirect:/Venta";
	}
    //INICIO - APARTIR DE AQUI TODAS LAS URLS SON VENTAS REALIZADAS
  //  @RequestMapping("/ListaDeVentas")
    @RequestMapping(value = "/ListaDeVentas", method = RequestMethod.GET)
	public String VENTAS_REALIZADAS(ModelMap modelo) throws JsonGenerationException, JsonMappingException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
    	//
    	modelo.addAttribute("Lista_de_ventas",mapper.writeValueAsString(SERVICIO.MOSTRAR_VENTAS_REALIZADAS()));
       
    	return "Lista_ventas";
	}

    
    //FIN - APARTIR DE AQUI TODAS LAS URLS SON VENTAS REALIZADAS
}