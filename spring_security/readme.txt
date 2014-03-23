Basic login & logout functionality including:
-	in-memory auth store
-	access decision manager config
-	decision voters config
-	custom login & logout pages
-	remember me
-	change & forgot password

--------------------
Basic Role Config

	<http auto-config="true" access-decision-manager-ref="unanimousBased">
		<intercept-url pattern="/*" access="ROLE_USER" />
	</http>
		
	<!-- intercepts requests -->
	<authentication-manager alias="authenticationManager">
		<authentication-provider>
			<user-service>
				<user authorities="ROLE_USER" name="guest" password="guest" />
			</user-service>
		</authentication-provider>
	</authentication-manager>
	
	<beans:bean class="org.springframework.security.access.vote.UnanimousBased" id="unanimousBased">
		<beans:property name="decisionVoters">
			<beans:list>
				<beans:ref bean="roleVoter" />
				<beans:ref bean="authenticatedVoter" />
			</beans:list>
		</beans:property>
	</beans:bean>
	
	<beans:bean class="org.springframework.security.access.vote.RoleVoter" id="roleVoter" />
	<beans:bean class="org.springframework.security.access.vote.AuthenticatedVoter" id="authenticatedVoter" />
--------------------