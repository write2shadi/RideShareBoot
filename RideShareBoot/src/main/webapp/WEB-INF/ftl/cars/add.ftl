<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.CarEntity" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


 <h1 class="page-header">Add New Car</h1>
	
<@spring.bind "form" />
<#if spring.status.error>
 <div class="row">
    <div class="col-lg-12">
        <div class="alert alert-warning alert-dismissable">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <i class="fa fa-info-circle"></i>
			<ul>
			    <#list spring.status.errorMessages as error>
			        <li>${error}</li>
			    </#list>
			</ul>            
        </div>
    </div>
</div>
</#if>
<!-- /.row -->
                


	<br/>
	 <div class="col-lg-6">
		<form role="form" name="form" action="" method="post">
		<input class="form-control" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="form-group">
                <label>Car Make</label>
				<input class="form-control" type="text" name="carMake" id="carMake" value="${form.carMake}" required autofocus />
				<p class="help-block">Nissan, Ford, Toyota..</p>				
        </div>
		<div class="form-group">
                                <label>Car Model</label>
				 <input class="form-control" type="text" name="carModel" id="carModel" value="${form.carModel}" required  />
				 <p class="help-block">Altima, Taurus, Yaris..</p>			
			</div>

		<div class="form-group">
             <label>Car Year</label>
			<input class="form-control" type="number" name="carYear" id="carYear" value="${form.carYear}" required />
			<p class="help-block">Like 2004</p>			
			</div>
<div class="form-group">
                                <label>Car Color</label>
				 <input class="form-control" type="text" name="carColor" id="carColor" value="${form.carColor}" required />
				 <p class="help-block">Red, Navy, Black..</p>			
			</div>

			<div class="form-group">
                                <label>Car Type</label>
				 <input class="form-control" type="text" name="carType" id="carType" value="${form.carType}" required  />
				 <p class="help-block">Sedan, SUV, 4x4..</p>				
			</div>
			<div class="form-group">
                 <input type="submit" value="Add Car" class="btn btn-default"/>
			</div>		
	</form>
	</div>

	
<#include "/_footer.ftl">
