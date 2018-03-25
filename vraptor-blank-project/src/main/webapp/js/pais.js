/**
 * 
 */

$(document).ready(function(){
    $("#btnBuscar").click(function(){
    	buscar();
    });
});

function buscar(){
  $.get("pais/buscar");
}