package com.sgitg.app.core.oauth2.altu.oauth2.common.parameters;


import com.sgitg.app.core.oauth2.altu.oauth2.common.exception.OAuthSystemException;
import com.sgitg.app.core.oauth2.altu.oauth2.common.message.OAuthMessage;

import java.util.Map;

/**
 * @author xkxu
 */
public class BodyEntityParametersApplier implements OAuthParametersApplier {

	@Override
	public OAuthMessage applyOAuthParameters(
			OAuthMessage message, Map<String, Object> params) throws OAuthSystemException {
		message.setBodyEntity(params);
		return message;
	}

}
