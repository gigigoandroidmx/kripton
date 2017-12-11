/* Copyright (c) 2016 Gigigo Android Development Team México
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gigigo.kbase.domain;

import java.util.ArrayList;
import java.util.List;


/**
 * Defines the interactor with base functionality
 *
 * @author Juan Godínez Vera - 28/12/2016
 * @author Daniel Moises Ruiz Pérez - 28/12/2016
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class KInteractor
        implements IInteractor {

    private List<Object> parameters;

    public boolean hasParams() {
        return parameters != null && parameters.size() > 0;
    }

    public <T> T tryGetParamValueAs(Class<T> classType, int index) {
        return tryGetParamValueAs(classType, index, DefaultValues.defaultValue(classType));
    }

    public <T> T tryGetParamValueAs(Class<T> classType, int index, T defaultValue) {
        if(hasParams()) {
            try {
                if(index < parameters.size()) {
                    Object object = parameters.get(index);
                    return DefaultValues.as(classType, object, defaultValue);
                } else {
                    return defaultValue;
                }
            } catch (Exception exception) {
                return defaultValue;
            }
        }

        return defaultValue;
    }

    /**
     * Defines the method to sets the parameters to be invoked when the api so requires
     *
     * @param parameters list of parameters
     */
    public void setParams(List<Object> parameters) {
        if(parameters == null) return;

        this.parameters = parameters;
    }

    /**
     * Defines the method to sets the parameters to be invoked when the api so requires
     *
     * @param parameters array of parameters
     */
    public void setParams(Object ... parameters) {
        if(parameters == null) return;

        ArrayList<Object> arrayList = new ArrayList(parameters.length);

        for(Object item : parameters) {
            arrayList.add(item);
        }

        setParams(arrayList);
    }

}