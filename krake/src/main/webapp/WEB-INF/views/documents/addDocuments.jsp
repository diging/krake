<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<h2>Add new Documents</h2>

<form:form modelAttribute="searchDocumentBean" action="" method="POST">
<div class="form-group">
    <label for="searchTerm">Search for a document:</label>
    <form:input type="text" class="form-control" path="searchTerm" placeholder="Search term"></form:input>
  </div>
</form:form>