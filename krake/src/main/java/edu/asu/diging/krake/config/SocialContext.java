package edu.asu.diging.krake.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.github.connect.GitHubConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import edu.asu.diging.krake.properties.IPropertiesManager;
import edu.asu.diging.krake.users.IUserManager;

@Configuration
@EnableSocial
@PropertySource("classpath:/config.properties")
public class SocialContext implements SocialConfigurer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IUserManager userManager;
    
    @Autowired
    private IPropertiesManager propertyManager;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig,
            Environment env) {
        String githubClientId = propertyManager.getProperty(IPropertiesManager.GITHUB_CLIENT_ID);
        String githubSecret = propertyManager.getProperty(IPropertiesManager.GITHUB_SECRET);
        cfConfig.addConnectionFactory(new GitHubConnectionFactory(
                githubClientId, githubSecret));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(
            ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
                dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setConnectionSignUp(new KrakeConnectionSignUp(userManager));
        return repository;
    }

    @Bean
    public ProviderSignInController providerSignInController(
            ConnectionFactoryLocator connectionFactoryLocator,
            UsersConnectionRepository usersConnectionRepository) {
        ProviderSignInController controller = new ProviderSignInController(
                connectionFactoryLocator, usersConnectionRepository,
                new SimpleSignInAdapter(userManager));
        return controller;
    }
}
