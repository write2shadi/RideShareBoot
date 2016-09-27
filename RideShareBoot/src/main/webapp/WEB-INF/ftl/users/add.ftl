<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="mum.ea.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>

<#include "/_header.ftl">


<h1 class="page-header">Create a new user</h1>

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
        <label for="role">Role</label>
        <select name="role" id="role" required class="form-control">
            <option <#if form.role == 'CUSTOMER'>selected</#if> value="CUSTOMER">Customer</option>
            <option <#if form.role == 'DRIVER'>selected</#if> value="DRIVER">Driver</option>
            <option <#if form.role == 'ADMIN'>selected</#if> value="ADMIN">Administrator</option>
        </select>
    </div>
    <button class="btn btn-default" type="submit">Save</button>
</form>
</div>
<br />
<br />

<#include "/_footer.ftl">
