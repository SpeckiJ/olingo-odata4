/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.odata4.client.core.deserializer;

import java.util.Collections;
import java.util.Map;

import org.apache.olingo.odata4.client.api.deserializer.AnnotationProperty;
import org.apache.olingo.odata4.client.api.deserializer.ComplexValue;
import org.apache.olingo.odata4.client.api.deserializer.NavigationProperty;
import org.apache.olingo.odata4.client.api.deserializer.StructuralProperty;
import org.apache.olingo.odata4.client.api.deserializer.Value;

public class ComplexValueImpl extends PropertyCollection implements ComplexValue {

  public ComplexValueImpl() {}

  public ComplexValueImpl(final Map<String, AnnotationProperty> annotationProperties,
      final Map<String, NavigationProperty> navigationProperties,
      final Map<String, StructuralProperty> structuralProperties) {
    super(annotationProperties, navigationProperties, structuralProperties);
  }

  @Override
  public Value getValue(final String name) {
    StructuralProperty property = structuralProperties.get(name);
    if (property == null) {
      return null;
    }
    return property.getValue();
  }

  @Override
  public Map<String, AnnotationProperty> getAnnotationProperties() {
    return Collections.unmodifiableMap(annotationProperties);
  }

  @Override
  public Map<String, NavigationProperty> getNavigationProperties() {
    return Collections.unmodifiableMap(navigationProperties);
  }

  @Override
  public boolean isComplex() {
    return true;
  }

  @Override
  public Map<String, StructuralProperty> getContent() {
    return Collections.unmodifiableMap(structuralProperties);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getContentAs(final T type) {
    return (T) getContent();
  }

  @Override
  public String toString() {
    return "ComplexValueImpl [annotations=" + annotationProperties + ", navigationProperties=" + navigationProperties
        + ", properties=" + structuralProperties + "]";
  }
}