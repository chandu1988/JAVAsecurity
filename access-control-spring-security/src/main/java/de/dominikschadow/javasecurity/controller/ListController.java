/*
 * Copyright (C) 2016 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Java Security project.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.javasecurity.controller;

import de.dominikschadow.javasecurity.domain.Contact;
import de.dominikschadow.javasecurity.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Dominik Schadow
 */
@Controller
@RequestMapping(value = "/contacts/list")
public class ListController {
    private static final  Logger LOGGER = LoggerFactory.getLogger(ListController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = GET)
    public String list(Model model) {
        List<Contact> contacts = contactService.getContacts();

        LOGGER.info("Found {} contacts for user", contacts.size());

        model.addAttribute("contacts", contacts);

        return "contacts/list";
    }
}
