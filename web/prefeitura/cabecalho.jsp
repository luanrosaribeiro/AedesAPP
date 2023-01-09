<%@page import="modelo.Admins"%>
<!doctype html>
<%
    Admins adm = new Admins();
    adm = (Admins) request.getSession().getAttribute("admin");
%>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Aedes APP</title>
        <meta name="mobile-web-app-capable" content="yes">
        <link rel="icon" sizes="192x192" href="images/android-desktop.png">

        <!-- Add to homescreen for Safari on iOS -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="Material Design Lite">
        <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

        <!-- Tile icon for Win8 (144x144 + tile color) -->
        <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
        <meta name="msapplication-TileColor" content="#3372DF">

        <link rel="shortcut icon" href="images/favicon.png">

        <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
        <!--
        <link rel="canonical" href="http://www.example.com/">
        -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
        <link rel="stylesheet" href="styles.css">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- favicon
             ============================================ -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
        <!-- Google Fonts
             ============================================ -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i,800" rel="stylesheet">
        <!-- Bootstrap CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!-- Bootstrap CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <!-- adminpro icon CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/adminpro-custon-icon.css">
        <!-- meanmenu icon CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/meanmenu.min.css">
        <!-- animate CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/animate.css">
        <!-- mCustomScrollbar CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css">
        <!-- normalize CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/normalize.css">
        <!-- accordions CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/accordions.css">
        <!-- tabs CSS
                    ============================================ -->
        <link rel="stylesheet" href="assets/css/tabs.css">
        <!-- style CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/style.css">
        <!-- responsive CSS
             ============================================ -->
        <link rel="stylesheet" href="assets/css/responsive.css">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.4.0/dist/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA==" crossorigin=""/>

        <!-- modernizr JS
             ============================================ -->
        <script src="https://unpkg.com/leaflet@1.4.0/dist/leaflet.js" integrity="sha512-QVftwZFqvtRNi0ZyCtsznlKSWOStnDORoefr1enyq5mVL4tmKB3S/EnC3rRJcxCPavG10IcrVGSmPh6Qw5lwrg==" crossorigin=""></script>
        <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
        <meta name="mobile-web-app-capable" content="yes">
        <link rel="icon" sizes="192x192" href="images/android-desktop.png">

        <!-- Add to homescreen for Safari on iOS -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="Material Design Lite">
        <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

        <!-- Tile icon for Win8 (144x144 + tile color) -->
        <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
        <meta name="msapplication-TileColor" content="#3372DF">

        <link rel="shortcut icon" href="images/favicon.png">

        <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
        <!--
        <link rel="canonical" href="http://www.example.com/">
        -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.cyan-light_blue.min.css">
        <link rel="stylesheet" href="styles.css">
        <style>
            #view-source {
                position: fixed;
                display: block;
                right: 0;
                bottom: 0;
                margin-right: 40px;
                margin-bottom: 40px;
                z-index: 900;
            }
        </style>
    </head>
    <body class="materialdesign">
        <!-- Header top area start-->
        <div class="wrapper-pro">
            <div class="left-sidebar-pro">
                <nav id="sidebar">
                    <div class="sidebar-header">
                        <a href="./index">
                            <img src="assets/img/logo.png" style="width: 136px;" alt="" />
                        </a>

                        <strong>AA+</strong>
                    </div>
                    <div class="left-custom-menu-adp-wrap">
                        <ul class="nav navbar-nav left-sidebar-menu-pro">
                            <li class="nav-item">
                                <a href="index" ><i class="fa big-icon fa-home" href="principal.jsp"></i> <span class="mini-dn">Home</span> <span class="indicator-right-menu mini-dn"></span></a>
                            </li>
                            <li class="nav-item">
                                <a href="denuncias" ><i class="fa big-icon fa-envelope"></i> <span class="mini-dn">Denúncias</span> <span class="indicator-right-menu mini-dn"></span></a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- Header top area start-->
            <div class="content-inner-all">
                <div class="header-top-area">
                    <div class="fixed-header-top">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-1 col-md-6 col-sm-6 col-xs-12">
                                    <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
                                        <i class="fa fa-bars"></i>
                                    </button>
                                </div>
                                <div class="col-lg-6 col-md-1 col-sm-1 col-xs-12"></div>
                                <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
                                    <div class="header-right-info">
                                        <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                            <li class="nav-item">
                                                <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
                                                    <span class="adminpro-icon adminpro-user-rounded header-riht-inf"></span>
                                                    <span class="admin-name"><%=adm.getEmail()%></span>
                                                    <span class="author-project-icon adminpro-icon adminpro-down-arrow"></span>
                                                </a>
                                                <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated flipInX">
                                                    <li><a href="../logout"><span class="adminpro-icon adminpro-locked author-log-ic"></span>Sair</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mobile-menu-area">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="mobile-menu">
                                    <nav id="dropdown">
                                        <ul class="mobile-menu-nav">
                                            <li>
                                                <a  href="index">Principal <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>

                                            </li>
                                            <li>
                                                <a href="denuncias">Denuncias <span class="admin-project-icon adminpro-icon adminpro-down-arrow"></span></a>

                                            </li>

                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                                        
