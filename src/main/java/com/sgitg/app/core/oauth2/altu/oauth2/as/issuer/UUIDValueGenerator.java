/**
 *       Copyright 2010 Newcastle University
 *
 *          http://research.ncl.ac.uk/smart/
 *
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

package com.sgitg.app.core.oauth2.altu.oauth2.as.issuer;

import com.sgitg.app.core.oauth2.altu.oauth2.common.exception.OAuthSystemException;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * Exemplar OAuth Token Generator
 */
public class UUIDValueGenerator implements ValueGenerator {

    @Override
    public String generateValue() throws OAuthSystemException {
        return generateValue(UUID.randomUUID().toString());
    }

    @Override
    public String generateValue(String param) throws OAuthSystemException {
        try {
			return UUID.fromString(UUID.nameUUIDFromBytes(param.getBytes("UTF-8")).toString()).toString();
		} catch (UnsupportedEncodingException e) {
			throw new OAuthSystemException("OAuth Token cannot be generated.", e);
		}
    }
}
