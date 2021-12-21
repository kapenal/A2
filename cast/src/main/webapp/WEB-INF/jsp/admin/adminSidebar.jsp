<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Sidebar -->
    <ul class="navbar-nav sidebar sidebar-light accordion" id="accordionSidebar">
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="adminIndex">
        <div class="sidebar-brand-icon">
          <img src="${pageContext.request.contextPath}/resources/admin_template/img/logo/logo2.png">
        </div>
        <div class="sidebar-brand-text mx-3">RuangAdmin</div>
      </a>
      <hr class="sidebar-divider my-0">
      <li class="nav-item active">
        <a class="nav-link" href="/admin/adminIndex">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>
       <hr class="sidebar-divider my-0">
      <li class="nav-item active">
        <a class="nav-link" href="/admin/noticeList">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>공지사항</span></a>
      </li>
       <hr class="sidebar-divider my-0">	
      <li class="nav-item active">
        <a class="nav-link" href="/admin/exhibitionList">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>전시소개</span></a>
      </li>
      </li>
       <hr class="sidebar-divider my-0">	
      <li class="nav-item active">
        <a class="nav-link" href="/admin/qnaList">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>QNA</span></a>
      </li>
      <hr class="sidebar-divider my-0">	
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMemberList"
          aria-expanded="true" aria-controls="collapseMemberList">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>가입자 리스트</span>
        </a>
        
        <div id="collapseMemberList" class="collapse" aria-labelledby="headingMemberList" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">MemberList</h6>
            <a class="collapse-item" href="/admin/customerList">고객리스트</a>
            <a class="collapse-item" href="/admin/ceoList">사업자리스트</a>
            <a class="collapse-item" href="/admin/travelerList">여행작가리스트</a>
          </div>
        </div>
      </li>
      <hr class="sidebar-divider my-0">	
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseJoinRequestList"
          aria-expanded="true" aria-controls="collapseJoinRequestList">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>가입 승인 요청 리스트</span>
        </a>
        
        <div id="collapseJoinRequestList" class="collapse" aria-labelledby="headingJoinRequestList" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Ceo</h6>
            <a class="collapse-item" href="/admin/ceoJoinRequestList">사업자 가입 요청</a>
            <h6 class="collapse-header">Traveler</h6>
            <a class="collapse-item" href="/admin/travelerJoinRequestList">여행작가 가입 요청</a>
          </div>
        </div>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        Features
      </div>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBootstrap"
          aria-expanded="true" aria-controls="collapseBootstrap">
          <i class="far fa-fw fa-window-maximize"></i>
          <span>Bootstrap UI</span>
        </a>
        <div id="collapseBootstrap" class="collapse" aria-labelledby="headingBootstrap" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Bootstrap UI</h6>
            <a class="collapse-item" href="adminAlerts">Alerts</a>
            <a class="collapse-item" href="adminButtons">Buttons</a>
            <a class="collapse-item" href="adminDropdowns">Dropdowns</a>
            <a class="collapse-item" href="adminModals">Modals</a>
            <a class="collapse-item" href="adminPopovers">Popovers</a>
            <a class="collapse-item" href="adminProgress-bar">Progress Bars</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseForm" aria-expanded="true"
          aria-controls="collapseForm">
          <i class="fab fa-fw fa-wpforms"></i>
          <span>Forms</span>
        </a>
        <div id="collapseForm" class="collapse" aria-labelledby="headingForm" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Forms</h6>
            <a class="collapse-item" href="adminForm_basics">Form Basics</a>
            <a class="collapse-item" href="adminForm_advanceds">Form Advanceds</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTable" aria-expanded="true"
          aria-controls="collapseTable">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span>
        </a>
        <div id="collapseTable" class="collapse" aria-labelledby="headingTable" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Tables</h6>
            <a class="collapse-item" href="adminSimple-tables">Simple Tables</a>
            <a class="collapse-item" href="adminDatatables">DataTables</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="adminUi-colors">
          <i class="fas fa-fw fa-palette"></i>
          <span>UI Colors</span>
        </a>
      </li>
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        Examples
      </div>
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePage" aria-expanded="true"
          aria-controls="collapsePage">
          <i class="fas fa-fw fa-columns"></i>
          <span>Pages</span>
        </a>
        <div id="collapsePage" class="collapse" aria-labelledby="headingPage" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Example Pages</h6>
            <a class="collapse-item" href="login.html">Login</a>
            <a class="collapse-item" href="register.html">Register</a>
            <a class="collapse-item" href="404.html">404 Page</a>
            <a class="collapse-item" href="blank.html">Blank Page</a>
          </div>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span>
        </a>
      </li>
      <hr class="sidebar-divider">
      <div class="version" id="version-ruangadmin"></div>
    </ul>
    <!-- Sidebar -->
	</body>
</html>