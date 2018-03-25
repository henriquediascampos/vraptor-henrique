/**
 * 
 */

$(document).ready(function(){
    $("#btnBuscar").click(function(){
      var pais = $("#nomePais").val();
      teste(pais);
    });
});

function buscar(){
  $.get("pais/buscar", function(){
      alert("patos");
  });

}

function teste(pais){
  nome= pais;
  data = {nome};
  $.get("pais/salvar", data,
  function(data){
      alert("Data: " + data);
  });
}