/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.odata4.producer.core.uri;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.olingo.odata4.producer.api.uri.UriInfoKind;

public class UriInfoImpl {

  private UriInfoKind kind;

  private Map<String, List<Object>> queryParameter = new HashMap<String, List<Object>>();

  public UriInfoImpl setKind(final UriInfoKind kind) {
    this.kind = kind;
    return this;
  }

  public Object getKind() {
    return kind;
  }

  public List<Object> getQueryParameters(String name) {
    return queryParameter.get(name);
  }

  public void addQueryParameter(String name, Object object) {
    List<Object> entry = queryParameter.get(name);
    if (entry != null) {
      entry.add(object);
    } else {
      queryParameter.put(name, Arrays.asList(object));
    }
  }
}
