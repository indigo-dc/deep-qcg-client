/*
 * Copyright © 2019-2020 I.N.F.N.
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

package it.infn.ba.deep.qcg.client;

import feign.Feign.Builder;
import feign.auth.BasicAuthRequestInterceptor;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import it.infn.ba.deep.qcg.client.utils.QcgException;
import it.infn.ba.deep.qcg.client.utils.QcgDecoder;
import it.infn.ba.deep.qcg.client.utils.QcgEncoder;
import it.infn.ba.deep.qcg.client.utils.TokenAuthRequestInterceptor;

import static java.util.Arrays.asList;

public class QcgClient {
	
  static class QcgHeadersInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
      template.header("Accept", "application/json");
      template.header("Content-Type", "application/json");
    }
  }

  static class QcgErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
      return new QcgException(response.status(), response.reason());
    }
  }

  public static Qcg getInstance(String endpoint) {
    return getInstance(endpoint, (RequestInterceptor[]) null);
  }

  /**
   * The generalized version of the method that allows more in-depth customizations via
   * {@link RequestInterceptor}s.
   *
   * @param endpoint
   *          URL of Qcg
   */
  public static Qcg getInstance(String endpoint, RequestInterceptor... interceptors) {
    Builder b =
        Feign.builder()
        	.encoder(new QcgEncoder())
	    	.decoder(new QcgDecoder())
            .errorDecoder(new QcgErrorDecoder())
            .requestInterceptor(new QcgHeadersInterceptor());

    if (interceptors != null)
      b.requestInterceptors(asList(interceptors));

    return b.target(Qcg.class, endpoint);
  }

  /**
   * Creates a Qcg client proxy that performs token authentication.
   */
  public static Qcg getInstanceWithBasicAuth(String endpoint, String username,
      String password) {
    return getInstance(endpoint, new BasicAuthRequestInterceptor(username, password));
  }


  public static Qcg getInstanceWithTokenAuth(String endpoint, String token) {
	return getInstance(endpoint, new TokenAuthRequestInterceptor(token));
  }
}
