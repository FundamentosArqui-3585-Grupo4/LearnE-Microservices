package org.learne.platform.learneservice.interfaces.rest.transform.Material;

import org.learne.platform.learneservice.domain.model.commands.Material.CreateMaterialCommand;
import org.learne.platform.learneservice.interfaces.rest.resources.Material.CreateMaterialResource;

public class CreateMaterialCommandFromResourceAssembler {

    public static CreateMaterialCommand ToCommandFromResource(CreateMaterialResource resource) {
        return new CreateMaterialCommand(resource.course_id(),resource.title(),resource.format(),resource.link());
    }
}
