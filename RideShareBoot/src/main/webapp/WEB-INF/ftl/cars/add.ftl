<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.CarEntity" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


<h2>Add New Car</h2>
	<br/>
		<form role="form" name="form" action="" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td>Car Make</td>
				<td> <input type="text" name="carMake" id="carMake" value="${form.carMake}" required autofocus /></td>				
			</tr>
			<tr>
				<td>Car Model</td>
				<td> <input type="text" name="carModel" id="carModel" value="${form.carModel}" required  /></td>				
			</tr>

			<tr>
				<td>Car Year</td>
				<td> <input type="text" name="carYear" id="carYear" value="${form.carYear}" required /></td>				
			</tr>

			<tr>
				<td>Car Color</td>
				<td> <input type="text" name="carColor" id="carColor" value="${form.carColor}" required /></td>				
			</tr>

			<tr>
				<td>Car Type</td>
				<td> <input type="text" name="carType" id="carType" value="${form.carType}" required  /></td>				
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Add Car"/></td>
			</tr>
		</table>
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
