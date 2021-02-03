// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.android.communication.chat.implementation;

import com.azure.android.core.http.ServiceClient;
import com.azure.android.core.http.responsepaging.AsyncPagedDataRetriever;
import com.azure.android.core.http.responsepaging.PagedDataResponseRetriever;
import com.azure.android.core.internal.util.serializer.SerializerAdapter;
import com.azure.android.core.internal.util.serializer.SerializerFormat;
import com.azure.android.core.util.paging.PagedDataRetriever;

/**
 * Initializes a new instance of the AzureCommunicationChatService type.
 */
public final class AzureCommunicationChatServiceImpl {
    /**
     * The serializer.
     */
    final SerializerAdapter serializerAdapter = SerializerAdapter.createDefault();

    /**
     * The Azure Core generic ServiceClient to setup interceptors and produce retrofit proxy.
     */
    private ServiceClient serviceClient;

    /**
     * Gets The Azure Core generic ServiceClient to setup interceptors and produce retrofit proxy.
     * 
     * @return the serviceClient value.
     */
    public ServiceClient getServiceClient() {
        return this.serviceClient;
    }

    /**
     * The endpoint of the Azure Communication resource.
     */
    private final String endpoint;

    /**
     * Gets The endpoint of the Azure Communication resource.
     * 
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * Api Version.
     */
    private final String apiVersion;

    /**
     * Gets Api Version.
     * 
     * @return the apiVersion value.
     */
    public String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * The ChatThreadsImpl object to access its operations.
     */
    private final ChatThreadsImpl chatThreads;

    /**
     * Gets the ChatThreadsImpl object to access its operations.
     * 
     * @return the ChatThreadsImpl object.
     */
    public ChatThreadsImpl getChatThreads() {
        return this.chatThreads;
    }

    /**
     * The ChatsImpl object to access its operations.
     */
    private final ChatsImpl chats;

    /**
     * Gets the ChatsImpl object to access its operations.
     * 
     * @return the ChatsImpl object.
     */
    public ChatsImpl getChats() {
        return this.chats;
    }

    /**
     * Initializes an instance of AzureCommunicationChatService client.
     * 
     * @param serviceClient The Azure Core generic ServiceClient to setup interceptors and produce retrofit proxy.
     * @param endpoint The endpoint of the Azure Communication resource.
     */
    public AzureCommunicationChatServiceImpl(ServiceClient serviceClient, String endpoint) {
        this.serviceClient = serviceClient;
        this.endpoint = endpoint;
        this.apiVersion = "2020-11-01-preview3";
        this.chatThreads = new ChatThreadsImpl(this);
        this.chats = new ChatsImpl(this);
    }

    String readAsString(okhttp3.ResponseBody body) {
        if (body == null) {
            return "";
        }
        try {
            return new String(body.bytes());
        } catch(java.io.IOException ex) {
            throw new RuntimeException(ex);
        } finally {
            body.close();
        }
    }

    <T> T deserializeContent(okhttp3.Headers headers, okhttp3.ResponseBody body, java.lang.reflect.Type type) {
        final String str = readAsString(body);
        try {
            final String mimeContentType = headers.get(CONTENT_TYPE);
            return this.serializerAdapter.deserialize(str, type, resolveSerializerFormat(mimeContentType));
        } catch(java.io.IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    <T> T deserializeHeaders(okhttp3.Headers headers, java.lang.reflect.Type type) {
        try {
            return this.serializerAdapter.deserialize(headers, type);
        } catch(java.io.IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    <T> retrofit2.Response<T> executeRetrofitCall(retrofit2.Call<T> call) {
        try {
            return call.execute();
        } catch(java.io.IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    java.lang.reflect.ParameterizedType createParameterizedType(Class<?> rawClass, java.lang.reflect.Type... genericTypes) {
        return new java.lang.reflect.ParameterizedType() {
            @Override
            public java.lang.reflect.Type[] getActualTypeArguments() {
                return genericTypes;
            }
            @Override
            public java.lang.reflect.Type getRawType() {
                return rawClass;
            }
            @Override
            public java.lang.reflect.Type getOwnerType() {
                return null;
            }
        };
    }

    private static final String CONTENT_TYPE = "Content-Type";

    private static final java.util.Map<String, SerializerFormat> SUPPORTED_MIME_TYPES = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private static final java.util.TreeMap<String, SerializerFormat> SUPPORTED_SUFFIXES = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    private static final SerializerFormat DEFAULT_ENCODING = SerializerFormat.JSON;
    static {
        SUPPORTED_MIME_TYPES.put("text/xml", SerializerFormat.XML);
        SUPPORTED_MIME_TYPES.put("application/xml", SerializerFormat.XML);
        SUPPORTED_MIME_TYPES.put("application/json", SerializerFormat.JSON);
        SUPPORTED_SUFFIXES.put("xml", SerializerFormat.XML);
        SUPPORTED_SUFFIXES.put("json", SerializerFormat.JSON);
    }

    SerializerFormat resolveSerializerFormat(String mimeContentType) {
        if (mimeContentType == null || mimeContentType.isEmpty()) {
            return DEFAULT_ENCODING;
        }
        final String[] parts = mimeContentType.split(";");
        final SerializerFormat encoding = SUPPORTED_MIME_TYPES.get(parts[0]);
        if (encoding != null) {
            return encoding;
        }
        final String[] mimeTypeParts = parts[0].split("/");
        if (mimeTypeParts.length != 2) {
            return DEFAULT_ENCODING;
        }
        final String subtype = mimeTypeParts[1];
        final int lastIndex = subtype.lastIndexOf("+");
        if (lastIndex == -1) {
            return DEFAULT_ENCODING;
        }
        final String mimeTypeSuffix = subtype.substring(lastIndex + 1);
        final SerializerFormat serializerEncoding = SUPPORTED_SUFFIXES.get(mimeTypeSuffix);
        if (serializerEncoding != null) {
            return serializerEncoding;
        }
        return DEFAULT_ENCODING;
    }
}
