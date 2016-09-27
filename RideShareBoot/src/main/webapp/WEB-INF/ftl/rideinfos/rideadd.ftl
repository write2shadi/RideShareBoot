<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.RideInfo" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


<h2>Add New Ride</h2>
	<br/>
		<form role="form" name="form" action="" method="post">
		<input class="form-control"  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
			<div class="form-group">
        		<label>Pick Up Street</label>
				<input class="form-control"  type="text" name="pickUpStreet" id="pickUpStreet" value="${form.pickUpStreet}" required autofocus />				
			</div>
				<div class="form-group">
        		<label>Pick Up City</label>
        		<input class="form-control"  type="text" name="pickUpCity" id="pickUpCity" value="${form.pickUpCity}" required  />				
			</div>

			<div class="form-group">
        		<label>Pick Up State</label>
				<input class="form-control"  type="text" name="pickUpState" id="pickUpState" value="${form.pickUpState}" required />				
			</div>

			<div class="form-group">
        		<label>Pick Up Zip</label>
				<input class="form-control"  type="text" name="pickUpZip" id="pickUpZip" value="${form.pickUpZip}"/>				
			</div>

			<div class="form-group">
        		<label>Drop Off Street</label>
				<input class="form-control"  type="text" name="dropOffStreet" id="dropOffStreet" value="${form.dropOffStreet}" required  />				
			</div>
			
			<div class="form-group">
        		<label>Drop Off City</label>
				<input class="form-control"  type="text" name="dropOffCity" id="dropOffCity" value="${form.dropOffCity}" required  />				
			</div>
			<div class="form-group">
        		<label>Drop Off State</label>
				<input class="form-control"  type="text" name="dropOffState" id="dropOffState" value="${form.dropOffState}" required  />				
			</div>
			<div class="form-group">
        		<label>Drop Off Zip</label>
				<input class="form-control"  type="text" name="dropOffZip" id="dropOffZip" value="${form.dropOffZip}" />				
			</div>
			<div class="form-group">
        		<label>Pick Up Date</label>
				<input class="form-control"  type="date" name="pickUpDate" id="pickUpDate" value="${form.pickUpDate?date}" />				
			</div>
			
			<div class="form-group">
        		<label>Pick Up Time</label>
				<input class="form-control"  type="time" name="pickUpTime" id="pickUpTime" value="${form.pickUpTime?time}" />				
			</div>
			<div class="form-group">
				<input class="form-control"  type="submit" value="Add Ride"/>
			</div>
		
	</form>
	
<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
	
<#include "/_footer.ftl">
