
<h3>Hello, <span th:text="${facebookProfile.name}">Some User</span>!</h3>

		<h4>These are your friends:</h4>

		<ul>
			<li th:each="friend:${friends}" th:text="${friend.name}">Friend</li>
		</ul>