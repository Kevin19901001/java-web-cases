<table id='singleUser' cellspacing="0">
	<tr>
		<td>userid</td>
		<td>username</td>
		<td>email</td>
		<td>tel</td>
		<td>level</td>
		<td>signtime</td>
		<td>operation</td>
	</tr>
	<tr id="tr_${ searchedUser.getUsername() }">
		<td>${ searchedUser.getId() }</td>
		<td id="${ searchedUser.getUsername() }">${ searchedUser.getUsername() }</td>
		<td>${ searchedUser.getEmail() }</td>
		<td>${ searchedUser.getTel() }</td>
		<td>${ searchedUser.getLevel() }</td>
		<td>${ searchedUser.getSignDate() }</td>
		<td>
			<input type="button" value="delete" id="deleteUser" class="deleteUserOperation" name="${ searchedUser.getUsername() }">
			<c:if test="${ searchedUser.getLevel() == 'common' }">
				<input type="button" value="to manager" id="asManager" class="addManagerOperation" name="${ searchedUser.getUsername() }">
			</c:if>
			<c:if test="${ searchedUser.getLevel() == 'manager' }">
				<input type="button" value="to common" id="asCommon" class="removeManagerOperation" name="${ searchedUser.getUsername() }">
			</c:if>
		</td>
	</tr>
</table>