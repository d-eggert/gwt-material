
package gwt.material.design.client.js;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.dom.client.Element;
import com.workingflows.js.jquery.client.api.Functions;
import com.workingflows.js.jquery.client.api.JQueryElement;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JSInterop utils for Materialize component
 *
 * @author kevzlou7979
 */
@JsType(isNative = true, name = JsPackage.GLOBAL)
public class JsMaterialElement extends JQueryElement {

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsMaterialElement $(JQueryElement element);

    @JsMethod(name = "$", namespace = JsPackage.GLOBAL)
    public static native JsMaterialElement $(Element element);

    /**
     * Collapsible Component
     */
    @JsMethod
    public native JQueryElement collapsible(boolean accordion);

    /**
     * Tabs Component
     */
    @JsMethod
    public native JQueryElement tabs();

    @JsMethod
    public native JQueryElement tabs(String method, String id);

    /**
     * Date Picker Component
     */
    @JsMethod
    public native JsMaterialElement pickadate(String picker);

    @JsMethod
    public native JsMaterialElement pickadate(JsDatePickerOptions property);

    @JsMethod
    public native JsMaterialElement set(Functions.Func1<Thing> thing);

    @JsMethod
    public native JsMaterialElement set(String key, JavaScriptObject value);

    @JsMethod
    public native JsMaterialElement set(String key, JavaScriptObject value, Functions.Func function);

    @JsMethod
    public native JavaScriptObject get(String key);

    @JsMethod
    public native JsDate get(String key, String format);

    @JsMethod
    public native JsMaterialElement stop();

    @JsMethod
    public native void obj();

    @JsMethod
    public native void clear();

    /**
     * Dismissable CollectionItem Component
     */
    @JsMethod(namespace = JsPackage.GLOBAL)
    public static native void initDismissableCollection();

    /**
     * Toast Component
     */
    @JsMethod(namespace = "Materialize")
    public static native double toast(String message, int duration, String classname, Functions.Func callback);
}
