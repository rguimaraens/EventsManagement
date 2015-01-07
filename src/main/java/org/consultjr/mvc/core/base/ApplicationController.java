/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.consultjr.mvc.core.base;

import org.consultjr.mvc.model.Application;
import org.consultjr.mvc.model.SystemConfig;
import org.consultjr.mvc.model.User;
import org.consultjr.mvc.service.SystemConfigService;
import org.consultjr.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Base Controller Operations
 *
 * @author rgcs
 */
public class ApplicationController {
    
    private Application app;

    private final Logger logger;
    /**
     * Spring Authentication Object
     */
    private Authentication auth;

    @Autowired
    private UserService userService;

    @Autowired
    private SystemConfigService sysConfigService;

    public Logger getLogger() {
        return logger;
    }

    public ApplicationController() {
        this.logger = LoggerFactory.getLogger(this.getClass());
        SecurityContext secutiryContext = SecurityContextHolder.getContext();
        this.auth = secutiryContext.getAuthentication();
        //this.app = this.getApplicationDatabaseObject();
    }

    public Authentication getAuth() {
        return auth == null ? SecurityContextHolder.getContext().getAuthentication() : auth;
    }

    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SystemConfigService getSysConfigService() {
        return sysConfigService;
    }

    public void setSysConfigService(SystemConfigService sysConfigService) {
        this.sysConfigService = sysConfigService;
    }    

    @ModelAttribute("loggedUser")
    public User getLoggedUser() {
        if (null == getAuth()) {
            return null;
        }

        getLogger().info("Principal: {}", getAuth().getPrincipal());
        if (!(getAuth().getPrincipal() instanceof org.springframework.security.core.userdetails.User)) {
            return null;
        }

        org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) getAuth().getPrincipal();
        if (null != u) {
            return userService.getUserByUsername(u.getUsername());
        }

        return null;
    }
    
    private String getConfig(String configKey) {
        SystemConfig sc = sysConfigService.get(configKey);

        if (null == sc) {
            return null;
        }

        return sc.getValue();
    }

    @ModelAttribute("productType")
    public String getProductType() {
        return getConfig("_productType");
    }

    @ModelAttribute("title")
    public String getPageTitle() {
        return getConfig("_appTitle");
    }
        
    public Application getApplicationDatabaseObject() {
        Application app = (Application) sysConfigService.getJson("_app", Application.class);
        this.app = (app != null ? app : new Application("_INVALID_"));
        return this.app;
    }
    
    @ModelAttribute("app")
    public Application getApplicationObject() {
        return (this.app == null || this.app.getProductKey().equals("_INVALID_") ? this.getApplicationDatabaseObject() : this.app);
    }
    
    protected void updateApplication(Application newerObject) {
        this.app = newerObject;
    }
    
    
}
