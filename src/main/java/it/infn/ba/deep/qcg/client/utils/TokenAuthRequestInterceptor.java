/*
 * Copyright © 2019 I.N.F.N.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.infn.ba.deep.qcg.client.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import static feign.Util.checkNotNull;

/**
 * An interceptor that adds the request header needed to use HTTP basic authentication.
 */
public class TokenAuthRequestInterceptor implements RequestInterceptor {

  private final String token;

  /**
   * Creates an interceptor that authenticates all requests with the specified bearer token
   *
   * @param token the token to use for authentication
   */
  public TokenAuthRequestInterceptor(String token) {
    checkNotNull(token, "token");
    this.token = "bearer " + token;
  }

  @Override
  public void apply(RequestTemplate template) {
    template.header("Authorization", token);
  }
}

