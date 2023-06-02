/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sgitg.app.core.oauth2.altu.oauth2.jwt.io;

import com.sgitg.app.core.oauth2.altu.commons.json.CustomizableEntityWriter;
import com.sgitg.app.core.oauth2.altu.oauth2.jwt.ClaimsSet;

import java.util.List;

public final class JWTClaimsSetWriter extends CustomizableEntityWriter<ClaimsSet> implements JWTConstants {

    @Override
    protected void handleProperties(ClaimsSet claimsSet) {
        List<String> audiences = claimsSet.getAudiences();
        set(AUDIENCE, audiences.size() > 1 ? audiences : claimsSet.getAudience());
        set(ISSUER, claimsSet.getIssuer());
        set(JWT_ID, claimsSet.getJwdId());
        set(NOT_BEFORE, claimsSet.getNotBefore());
        set(SUBJECT, claimsSet.getSubject());
        set(TYPE, claimsSet.getType());
        set(EXPIRATION_TIME, claimsSet.getExpirationTime());
        set(ISSUED_AT, claimsSet.getIssuedAt());
    }

}