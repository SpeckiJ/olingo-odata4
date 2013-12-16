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
package org.apache.olingo.odata4.producer.core.uri.expression;

public enum SupportedBinaryOperators {
  MUL("mul"), DIV("div"), MOD("mod"),
  ADD("add"), SUB("sub"), GT("gt"), GE("ge"), LT("lt"), LE("le"),
  ISOF("isof"),
  EQ("eq"), NE("ne"),
  AND("and"), OR("or");

  private String syntax;

  private SupportedBinaryOperators(final String syntax) {
    this.syntax = syntax;
  }

  @Override
  public String toString() {
    return syntax;
  }

  public static SupportedBinaryOperators get(String operator) {
    for (SupportedBinaryOperators op : SupportedBinaryOperators.values()) {
      if (op.toString().equals(operator)) {
        return op;
      }
    }
    return null;
  }

}
