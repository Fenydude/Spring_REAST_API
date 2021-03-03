package com.bogurov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourceHandlerSetting {
    @Value("#{'${resourceHandle.list}'.split(',')}")
    private List<String> resourceHandlerPathPatternList;
    @Value("#{'${resourceLocation.list}'.split(',')}")
    private List<String> resourceLocationList;

    public List<String> getResourceHandlerPathPatternList() {
        return resourceHandlerPathPatternList;
    }

    public void setResourceHandlerPathPatternList(List<String> resourceHandlerPathPatternList) {
        this.resourceHandlerPathPatternList = resourceHandlerPathPatternList;
    }

    public List<String> getResourceLocationList() {
        return resourceLocationList;
    }

    public void setResourceLocationList(List<String> resourceLocationList) {
        this.resourceLocationList = resourceLocationList;
    }

    private boolean checkListsSize() {
        if (resourceHandlerPathPatternList.size() == resourceLocationList.size()) {
            return true;
        } else {
            return false;
        }
    }

    public int getListsSize() throws Exception {
        if (checkListsSize()) {
            return resourceHandlerPathPatternList.size();
        } else {
            throw new Exception("The size of lists are not equal");
        }
    }
}
