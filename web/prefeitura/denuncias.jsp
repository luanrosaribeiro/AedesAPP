<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.DenunciasDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Denuncias"%>
<%@include file='cabecalho.jsp' %>
<%  
    List<Denuncias> lista = null;
    lista = (List<Denuncias>) request.getAttribute("lista");
%>
<div class="static-table-area mg-b-15">
    <div class="container-fluid">
        <form method="GET" action="./denuncias">
            <div class="row">
                <div class="sparkline16-list shadow-reset mg-t-30">
                    <div class="sparkline14-hd">
                        <div class="main-sparkline14-hd">
                            <h1>Pesquisar por Data</h1>
                        </div>
                    </div>
                    <div class="sparkline16-graph">
                        <div class="row">
                            <div class='col-sm-3'>
                                <div class="date-picker-inner">
                                    <div class="form-group data-custon-pick data-custom-mg" id="data_5">
                                        <div class="input-daterange input-group"  id="datepicker">
                                            <label>Início</label>
                                            <input type="date" class="form-control" name="txtData1">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class='col-sm-3'>
                                <div class="date-picker-inner">
                                    <div class="form-group data-custon-pick data-custom-mg" id="data_5">
                                        <div class="input-daterange input-group"  id="datepicker">
                                            <label>Fim</label>
                                            <input type="date" class="form-control" name="txtData2">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class='col-sm-3'>
                                <div class="button-style-three align-middle">
                                    <button type="submit"  class="btn btn-custon-rounded-three btn-primary"><span class="adminpro-icon adminpro-search"></span></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<br/>
<div class="static-table-area mg-b-15">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="sparkline8-list shadow-reset">
                    <div class="sparkline8-hd">
                        <div class="main-sparkline8-hd">
                            <h1>Denúncias</h1>
                            <div class="sparkline8-outline-icon">
                                <span class="sparkline8-collapse-link"><i class="fa fa-chevron-up"></i></span>
                                <span><i class="fa fa-wrench"></i></span>
                                <span class="sparkline8-collapse-close"><i class="fa fa-times"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="sparkline8-graph">
                        <div class="static-table-list">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Status</th>
                                        <th>Data</th>
                                        <th>Observações</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Denuncias d : lista) {%>
                                    <tr>

                                        <td><%=d.getId()%></td>
                                        <td>
                                            <%
                                                if (d.getStatus() == 1) {
                                            %>
                                            <a href="./denuncias?status=<%=d.getStatus()%>" class="btn btn-primary">Aguardando análise</a>
                                            <%} else if (d.getStatus() == 2) {
                                            %>
                                            <a href="./denuncias?status=<%=d.getStatus()%>" class="btn btn-custon-four btn-success">Indícios de foco</a>
                                            <%
                                            } else if (d.getStatus() == 3) {
                                            %>
                                            <a href="./denuncias?status=<%=d.getStatus()%>" class="btn btn-custon-four btn-danger">Não há indícios de foco</a>
                                            <%
                                            } else {
                                            %>
                                            <a href="./denuncias?status=<%=d.getStatus()%>" class="btn btn-custon-four btn-warning">Não foi possível verificar</a>
                                            <%
                                                }
                                            %>

                                        </td>
                                        <td><%=d.getDataFormatada()%></td>
                                        <td><%=d.getObservacoes()%></td>
                                        <td><a href='detalhes.jsp?id=<%=d.getId()%>' class="btn btn-primary" type="submit" style="background-color: #731F35">Detalhes</a></td>
                                        <%
                                            switch (d.getStatus()) {
                                                case 1:

                                        %>
                                        <td>
                                            <div class="button-style-three">
                                                <a href="status?id=<%=d.getId()%>&status=2" type="button" class="btn btn-custon-rounded-three btn-success"><span class="adminpro-icon adminpro-checked-pro"></span></a>
                                                <a href="status?id=<%=d.getId()%>&status=3" type="button" class="btn btn-custon-rounded-three btn-danger"><span class="adminpro-icon adminpro-danger-error"></span></a>
                                                <a href="status?id=<%=d.getId()%>&status=4" type="button" class="btn btn-custon-rounded-three btn-warning"><span class="adminpro-icon adminpro-informatio"></span></a>
                                            </div>
                                        </td>
                                        <%
                                                break;
                                            case 2:
                                        %>
                                        <td>
                                            <div class="button-style-three">
                                                <a href="status?id=<%=d.getId()%>&status=3" type="button" class="btn btn-custon-rounded-three btn-danger"><span class="adminpro-icon adminpro-danger-error"></span></a>
                                                <a href="status?id=<%=d.getId()%>&status=4" type="button" class="btn btn-custon-rounded-three btn-warning"><span class="adminpro-icon adminpro-informatio"></span></a>    
                                            </div>
                                        </td>

                                        <%
                                                break;
                                            case 3:
                                        %>
                                        <td>
                                            <div class="button-style-three">
                                                <a href="status?id=<%=d.getId()%>&status=2" type="button" class="btn btn-custon-rounded-three btn-success"><span class="adminpro-icon adminpro-checked-pro"></span></a>
                                                <a href="status?id=<%=d.getId()%>&status=4" type="button" class="btn btn-custon-rounded-three btn-warning"><span class="adminpro-icon adminpro-informatio"></span></a>
                                            </div>
                                        </td>    

                                        <%
                                                break;
                                            case 4:
                                        %>
                                        <td>
                                            <div class="button-style-three">
                                                <a href="status?id=<%=d.getId()%>&status=3" type="button" class="btn btn-custon-rounded-three btn-danger"><span class="adminpro-icon adminpro-danger-error"></span></a>
                                                <a href="status?id=<%=d.getId()%>&status=2" type="button" class="btn btn-custon-rounded-three btn-success"><span class="adminpro-icon adminpro-checked-pro"></span></a>
                                            </div>
                                        </td>
                                        <%}%>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file='rodape.jsp' %>