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

package gigigo.com.kmvp;

/**
 * Defines an interface for the execute action
 *
 * @param <T> data type
 *
 * @author Juan Godínez Vera - 26/04/2017
 * @version 2.0.0
 * @since 2.0.0
 */
public interface IAction<T> {
    /**
     * Defines the method to be called when the action is invoked.
     * @param argument data type to return
     */
    void invoke(T argument);
}