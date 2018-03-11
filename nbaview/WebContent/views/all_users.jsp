<div id="allUsers">
	<c:if test="${ userList.size() == 0 }">
		<div id="content">There is no user now!</div>
	</c:if>
	<c:if test="${ userList.size() != 0 }">
		<div id="content">
			<table id="users" cellspacing="0">
				<tr>
					<td>userid</td>
					<td>username</td>
					<td>email</td>
					<td>tel</td>
					<td>level</td>
					<td>signtime</td>
					<td>operation</td>
				</tr>
				<c:forEach items="${ userList }" var="user">
					<tr id="tr_${ user.getUsername() }">
						<td>${ user.getId() }</td>
						<td id="${ user.getUsername() }">${ user.getUsername() }</td>
						<td>${ user.getEmail() }</td>
						<td>${ user.getTel() }</td>
						<td>${ user.getLevel() }</td>
						<td>${ user.getSignDate() }</td>
						<td><input type="button" value="delete" id="deleteUser" class="deleteUserOperation" name="${ user.getUsername() }">
							<input type="button" value="to manager" id="asManager" class="addManagerOperation" name="${ user.getUsername() }">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="page">
			<a href="/nbaview/mine">first</a>
			<a href="/nbaview/mine?count=10&page=${ currentPage - 1 }">prev</a>
			<c:forEach items="${ pageTags }" var="page">
				<a href="/nbaview/mine?count=10&page=${ page }">${ page }</a>
			</c:forEach>
			<a href="/nbaview/mine?count=10&page=${ currentPage + 1 }">next</a>
			<% String pageCount = request.getAttribute("pageCount").toString(); %>
			<a href="/nbaview/mine?count=10&page=${ pageCount }">last</a>
		</div>
	</c:if>
</div>