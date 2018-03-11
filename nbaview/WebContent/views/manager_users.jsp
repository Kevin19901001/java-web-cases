<div id="managerUsers">
	<c:if test="${ managerList.size() == 0 }">
		<div id="content">There is no manager user!</div>
	</c:if>
	<c:if test="${ managerList.size() != 0 }">
		<div id="content">
			<table id="managers" cellspacing="0">
				<tr>
					<td>userid</td>
					<td>username</td>
					<td>email</td>
					<td>tel</td>
					<td>level</td>
					<td>signtime</td>
					<td>operation</td>
				</tr>
				<c:forEach items="${ managerList }" var="manager">
					<tr id="tr_${ manager.getUsername() }">
						<td>${ manager.getId() }</td>
						<td id="${ manager.getUsername() }">${ manager.getUsername() }</td>
						<td>${ manager.getEmail() }</td>
						<td>${ manager.getTel() }</td>
						<td>${ manager.getLevel() }</td>
						<td>${ manager.getSignDate() }</td>
						<td>
							<input type="button" value="to commnon" id="asCommon" class="removeManagerOperation" name="${ manager.getUsername() }">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</div>