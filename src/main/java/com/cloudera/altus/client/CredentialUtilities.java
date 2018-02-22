/*
 * Copyright (c) 2018 Cloudera, Inc. All Rights Reserved.
 *
 * Portions Copyright (c) Copyright 2013-2018 Amazon.com, Inc. or its
 * affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudera.altus.client;

import static com.cloudera.altus.ValidationUtils.checkNotNullAndThrow;

import com.cloudera.altus.AltusClientException;

import java.io.IOException;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

/**
 * Utility methods for interacting with Altus credentials.
 */
public class CredentialUtilities {

  private CredentialUtilities() {}

  /**
   * Decodes a private key from the string format used in Altus profiles.
   * @param privateKey the private key as a single line string
   * @return the private key
   */
  public static PrivateKey decodePrivateKey(String privateKey) {
    checkNotNullAndThrow(privateKey);
    privateKey = privateKey.replace("\\n", "\n");
    try (PemReader pemReader = new PemReader(new StringReader(privateKey))) {
      PemObject pemObject = pemReader.readPemObject();
      if (pemObject == null) {
        throw new AltusClientException("Invalid private key ");
      }
      PKCS8EncodedKeySpec privateKeySpec =
              new PKCS8EncodedKeySpec(pemObject.getContent());
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePrivate(privateKeySpec);
    } catch (IOException |
            NoSuchAlgorithmException |
            InvalidKeySpecException e) {
      throw new AltusClientException(
          "Unable to generate private key " + e.getMessage(), e);
    }
  }
}
