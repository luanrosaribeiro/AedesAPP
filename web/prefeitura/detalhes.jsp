<%@page import="dao.DenunciasDAO"%>
<%@include  file='cabecalho.jsp'%>
<%  
    modelo.Denuncias d = new modelo.Denuncias();
    DenunciasDAO dao = new DenunciasDAO();
    d = dao.buscarPorChavePrimaria(Integer.parseInt(request.getParameter("id")));
%>

<div class="contact-clients-area mg-b-40">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="contact-client-single ct-client-b-mg-30 ct-client-b-mg-30-n shadow-reset">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="contact-client-img">
                                <a href=""><img src="<%=d.getImagem()%>" style="width: 100%;" alt="" /></a>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="mapid" id="mapid">

                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="contact-client-content">
                                <h2><a href="#">Detalhes da Denúncias</a></h2>
                            </div>
                            <div class="contact-client-address">
                                <p><strong>Status: </strong><%=d.getStatusNome()%></p>
                                <p><strong>Data: </strong><%=d.getDataFormatada()%></p>
                                <p><strong>Protocolo: </strong><%=d.getProtocolo()%></p>
                                <p><strong>Observações: </strong><%=d.getObservacoes()%></p></br>
                                <div class="button-style-three">
                                    <a href="status?id=<%=d.getId()%>&status=2" type="button" class="btn btn-custon-rounded-three btn-success"><span class="adminpro-icon adminpro-checked-pro"></span>Concluído</a></br>
                                    <a href="status?id=<%=d.getId()%>&status=3" type="button" class="btn btn-custon-rounded-three btn-danger"><span class="adminpro-icon adminpro-danger-error"></span> Não Procede</a></br>
                                    <a href="status?id=<%=d.getId()%>&status=4" type="button" class="btn btn-custon-rounded-three btn-primary"><span class="adminpro-icon adminpro-informatio"></span> Não foi Possível Verificar</a>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>

<script>
    var local = [<%=d.getLatitude()%>, <%=d.getLongitude()%>];
    var mymap = L.map('mapid').setView(local, 18);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Mapa fornecido por: <a href="https://www.openstreetmap.org/">Open Street Map</a>',
        maxZoom: 28
    }).addTo(mymap);
    var marker = L.marker(local).addTo(mymap);
    marker.bindPopup("<p>Longitude: <%=d.getLongitude()%></p><p>Latitude: <%=d.getLatitude()%></p>");
</script>
<%@include file='rodape.jsp'%>