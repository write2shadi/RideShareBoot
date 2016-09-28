<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.Booking" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


 <h1 class="page-header">Add New Booking</h1>
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
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td>User ID</td>
				<td><select>
                         <option value="1">1</option>
                         <option value="2">2</option>
                         <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                 </td>				
			</tr>
			<tr>
				<td>RideInfo ID</td>
				<td><select>
                         <option value="1">1</option>
                         <option value="2">2</option>
                         <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                 </td>				
			</tr>
		
 


			<tr>
				<td> Number of Seats</td>
				<td> <input type="text" name="timeOfBooking" id="numberOfSeats" value="${form.numberOfSeats}" required /></td>				
			</tr>

		
			<tr>
				<td colspan="3"><input type="submit" value="Add Booking"/></td>
			</tr>
		</table>
	</form>
	

	
<#include "/_footer.ftl">
