<!-- partial:partials/_sidebar.html -->
		<nav class="sidebar">
	      <div class="sidebar-header">
	        <a href="#" class="sidebar-brand">
	          GO<span>Cheetha</span>
	        </a>
	        <div class="sidebar-toggler not-active">
	          <span></span>
	          <span></span>
	          <span></span>
	        </div>
	      </div>
	      <div class="sidebar-body">
	        <ul class="nav">
	          <li class="nav-item nav-category">Main</li>
	          <li class="nav-item ${param.dashboard}">
	            <a href="index.jsp" class="nav-link">
	              <i class="link-icon" data-feather="box"></i>
	              <span class="link-title">Dashboard</span>
	            </a>
	          </li>
	          <li class="nav-item nav-category">Administration</li>
	          <li class="nav-item ${param.city}">
	            <a href="CountryControllerServlet" class="nav-link">
	              <i class="link-icon" data-feather="message-square"></i>
	              <span class="link-title">Country</span>
	            </a>
	          </li>
	       
 
	         </ul>
	      </div>
	    </nav>
	    
	    
	    
	    <nav class="settings-sidebar">
	      <div class="sidebar-body">
	        <a href="#" class="settings-sidebar-toggler">
	          <i data-feather="settings"></i>
	        </a>
	        <h6 class="text-muted">Sidebar:</h6>
	        <div class="form-group">
	          <div class="form-check form-check-inline">
	            <label class="form-check-label">
	              <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarLight" value="sidebar-light" checked>
	              Light
	            </label>
	          </div>
	          <div class="form-check form-check-inline">
	            <label class="form-check-label">
	              <input type="radio" class="form-check-input" name="sidebarThemeSettings" id="sidebarDark" value="sidebar-dark">
	              Dark
	            </label>
	          </div>
	        </div>
	        </div>
	    </nav>
			<!-- partial -->
		>