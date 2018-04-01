/**
 * 
 */

$(document).ready(function(){
    $("#btnBuscar").click(function(){
      var nome = $("#nomePais").val();
      teste(nome);
    }); 
});

function buscar(){ 
  $.get("pais/buscar", function(){
  });

}

function teste(nome){
  data = {nome};
  $.get("pais/salvar", data,
  function(data){
  });
}