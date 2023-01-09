<%@page import="modelo.Denuncias"%>
<%@page import="java.util.List"%>
<%@include file='cabecalho.jsp'%>
<%  Integer tamanho = (Integer) request.getAttribute("tamanho");
    Integer tamanhodia = (Integer) request.getAttribute("tamanhodia");
    Integer porcentagemdia;

    if (tamanho == 0) {
        porcentagemdia = 0;
    } else {
        porcentagemdia = (tamanhodia * 100) / tamanho;
    }
%>
<div class="income-order-visit-user-area">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" >
                <div class="income-dashone-total shadow-reset nt-mg-b-30 res-mg-t-30">
                    <div class="income-title">
                        <div class="main-income-head">
                            <h2>Denúncias - Diárias</h2>
                        </div>
                    </div>
                    <div class="income-dashone-pro">
                        <div class="income-rate-total">
                            <div class="price-adminpro-rate">
                                <h3><span></span><span class="counter"><%=porcentagemdia%>%</span></h3>
                                <h3><span></span><span class="counter"><%=tamanhodia%></span></h3>
                            </div>

                            <div class="price-graph">
                                <span id="sparkline1">
                                    <span class="income-percentange"></span> <canvas width="27" height="19" style="display: inline-block; width: 27px; height: 19px; vertical-align: top;"></canvas>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="mapid" id="mapid">

                </div>
            </div>
        </div>
    </div>
</div>

<main class="mdl-layout__content mdl-color--grey-150">
    <div class="mdl-grid demo-content">
        <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
            <%  Integer tamanho1 = (Integer) request.getAttribute("tamanho1");
                Integer porcentagem1;

                if (tamanho == 0) {
                    porcentagem1 = 0;
                } else {
                    porcentagem1 = (tamanho1 * 100) / tamanho;
                }
            %>
            <svg fill="#0047ab" width="200px" height="200px" viewBox="0 0 1 1" class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop">
            <use xlink:href="#piechart" mask="url(#piemask)"></use>
            <text x="0.5" y="0.5" font-family="Roboto" font-size="0.3" fill="#0047ab" text-anchor="middle" dy="0.1"><%=porcentagem1%><tspan font-size="0.2" dy="-0.07">%</tspan></text>
            <text x="0.5" y="0.6" font-family="Roboto" font-size="0.07" fill="#0047ab" text-anchor="middle" dy="0.1">Aguardando Análise</text>
            </svg>
            <%  Integer tamanho2 = (Integer) request.getAttribute("tamanho2");
                Integer porcentagem2;

                if (tamanho2 == 0) {
                    porcentagem2 = 0;
                } else {
                    porcentagem2 = (tamanho2 * 100) / tamanho;
                }
            %>
            <svg fill="#5a9c5b" width="200px" height="200px" viewBox="0 0 1 1" class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop">
            <use xlink:href="#piechart" mask="url(#piemask)"></use>
            <text x="0.5" y="0.5" font-family="Roboto" font-size="0.3" fill="#5a9c5b" text-anchor="middle" dy="0.1"><%=porcentagem2%><tspan dy="-0.07" font-size="0.2">%</tspan></text>
            <text x="0.5" y="0.6" font-family="Roboto" font-size="0.07" fill="#5a9c5b" text-anchor="middle" dy="0.1">Concluídas</text>
            </svg>
            <%
                Integer tamanho3 = (Integer) request.getAttribute("tamanho3");
                Integer porcentagem3;
                if (tamanho3 == 0) {
                    porcentagem3 = 0;
                } else {
                    porcentagem3 = (tamanho3 * 100) / tamanho;
                }
            %>
            <svg fill="#e61919" width="200px" height="200px" viewBox="0 0 1 1" class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop">
            <use xlink:href="#piechart" mask="url(#piemask)"></use>
            <text x="0.5" y="0.5" font-family="Roboto" font-size="0.3" fill="#e61919" text-anchor="middle" dy="0.1"><%=porcentagem3%><tspan dy="-0.07" font-size="0.2">%</tspan></text>
            <text x="0.5" y="0.6" font-family="Roboto" font-size="0.07" fill="#e61919" text-anchor="middle" dy="0.1">Não Procedem</text>
            </svg>
            <%  Integer tamanho4 = (Integer) request.getAttribute("tamanho4");
                Integer porcentagem4;

                if (tamanho4 == 0) {
                    porcentagem4 = 0;
                } else {
                    porcentagem4 = (tamanho4 * 100) / tamanho;
                }
            %>
            <svg fill="#f19b09" width="200px" height="200px" viewBox="0 0 1 1" class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop">
            <use xlink:href="#piechart" mask="url(#piemask)"></use>
            <text x="0.5" y="0.5" font-family="Roboto" font-size="0.3" fill="##f19b09" text-anchor="middle" dy="0.1"><%=porcentagem4%><tspan dy="-0.07" font-size="0.2">%</tspan></text>
            <text x="0.5" y="0.6" font-family="Roboto" font-size="0.07" fill="#f19b09" text-anchor="middle" dy="0.1">Impossível Verificar</text>
            </svg>
        </div>

    </div>
</main>
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" style="position: fixed; left: -1000px; height: -1000px;">
<defs>
<mask id="piemask" maskContentUnits="objectBoundingBox">
    <circle cx="0.5" cy="0.5" r="0.49" fill="white"></circle>
    <circle cx="0.5" cy="0.5" r="0.40" fill="black"></circle>
</mask>
<g id="piechart">
<circle cx="0.5" cy="0.5" r="0.5"></circle>
<path stroke="none" fill="rgba(255, 255, 255, 0.75)"></path>
</g>
</defs>
</svg>
<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 500 250" style="position: fixed; left: -1000px; height: -1000px;">
<defs>
<g id="chart">
<g id="Gridlines">
<line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="27.3" x2="468.3" y2="27.3"></line>
<line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="66.7" x2="468.3" y2="66.7"></line>
<line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="105.3" x2="468.3" y2="105.3"></line>
<line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="144.7" x2="468.3" y2="144.7"></line>
<line fill="#888888" stroke="#888888" stroke-miterlimit="10" x1="0" y1="184.3" x2="468.3" y2="184.3"></line>
</g>
<g id="Numbers">
<text transform="matrix(1 0 0 1 485 29.3333)" fill="#888888" font-family="'Roboto'" font-size="9">500</text>
<text transform="matrix(1 0 0 1 485 69)" fill="#888888" font-family="'Roboto'" font-size="9">400</text>
<text transform="matrix(1 0 0 1 485 109.3333)" fill="#888888" font-family="'Roboto'" font-size="9">300</text>
<text transform="matrix(1 0 0 1 485 149)" fill="#888888" font-family="'Roboto'" font-size="9">200</text>
<text transform="matrix(1 0 0 1 485 188.3333)" fill="#888888" font-family="'Roboto'" font-size="9">100</text>
<text transform="matrix(1 0 0 1 0 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">1</text>
<text transform="matrix(1 0 0 1 78 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">2</text>
<text transform="matrix(1 0 0 1 154.6667 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">3</text>
<text transform="matrix(1 0 0 1 232.1667 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">4</text>
<text transform="matrix(1 0 0 1 309 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">5</text>
<text transform="matrix(1 0 0 1 386.6667 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">6</text>
<text transform="matrix(1 0 0 1 464.3333 249.0003)" fill="#888888" font-family="'Roboto'" font-size="9">7</text>
</g>
<g id="Layer_5">
<polygon opacity="1" stroke-miterlimit="10" points="0,223.3 48,138.5 154.7,169 211,88.5
         294.5,80.5 380,165.2 437,75.5 469.5,223.3 	"></polygon>
</g>
<g id="Layer_4">
<polygon stroke-miterlimit="10" points="469.3,222.7 1,222.7 48.7,166.7 155.7,188.3 212,132.7
         296.7,128 380.7,184.3 436.7,125 	"></polygon>
</g>
</g>
</defs>
</svg>
<script>

    var local = [-31.3272809, -54.10259];
    var mymap = L.map('mapid').setView(local, 12);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Mapa fornecido por: <a href="https://www.openstreetmap.org/">Open Street Map</a>',
        maxZoom: 25
    }).addTo(mymap);
    <%
        List<modelo.Denuncias> lista = (List<modelo.Denuncias>) request.getAttribute("lista");
        for (Denuncias d : lista) {
    %>
    local = [<%=d.getLatitude()%>, <%=d.getLongitude()%>];
    var marker = L.marker(local).addTo(mymap);
    marker.bindPopup("<p>Longitude: <%=d.getLongitude()%></p><p>Latitude: <%=d.getLatitude()%></p>");
    <%}%>
</script>
<%@include file='rodape.jsp'%>