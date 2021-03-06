<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


<h1 class="page-header">Register New Customer!</h1>

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
<div class="col-lg-6">
<form role="form" name="form" action="" method="post">
    <input class="form-control" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label for="email">Email address</label>
        <input class="form-control" type="email" name="email" id="email" value="${form.email}" required autofocus />
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input class="form-control" type="password" name="password" id="password" required/>
    </div>
    <div class="form-group">
        <label for="passwordRepeated">Repeat</label>
        <input class="form-control" type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    


    <div class="form-group">
        <label>First Name</label>
        <input class="form-control" type="text" name="firstName" id="firstName" required/>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input class="form-control" type="text" name="lastName" id="lastName" required/>
    </div>    
    <div class="form-group">
        <label>Phone</label>
        <input class="form-control" type="number" name="phone" id="phone" required/>
    </div>        
   <div class="form-group">
        <label>Address Line 1</label>
        <input class="form-control" type="text" name="addressLine1" id="addressLine1" required/>
    </div> 
   <div class="form-group">
        <label>Address Line 2</label>
        <input class="form-control" type="text" name="addressLine2" id="addressLine2" required/>
    </div>    
   <div class="form-group">
        <label>City</label>
        <input class="form-control" type="text" name="city" id="city" required/>
    </div>     
   <div class="form-group">
        <label>State</label>
        <input class="form-control" type="text" name="state" id="state" required/>
    </div>     
   <div class="form-group">
        <label>Zip Code</label>
        <input class="form-control" type="text" name="zipCode" id="zipCode" required/>
    </div>     
            
    <button class="btn btn-default" type="submit">Create Account & Go to Login</button>
</form>
</div>
<br />
<br />

<#include "/_footer.ftl">
