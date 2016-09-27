<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->

<#include "/_header.ftl">


<h1>Log in</h1>

<p>You can use: demo@localhost / demo</p>

<form role="form" action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

	<div class="form-group">
         <label>Username</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Username here .." required autofocus/>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required autofocus/>
    </div>                          
  
  
    <div class="checkbox">
                                    <label>
                                         <input type="checkbox" name="remember-me" id="remember-me"/> Remember me
                                    </label>
                                </div>

    <button type="submit"  class="btn btn-default">Sign in</button>
</form>

<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>

<#include "/_footer.ftl">