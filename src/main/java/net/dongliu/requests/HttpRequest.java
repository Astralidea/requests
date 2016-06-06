package net.dongliu.requests;

import net.dongliu.requests.body.RequestBody;

import javax.annotation.Nonnull;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Http request
 *
 * @author Liu Dong
 */
public class HttpRequest {
    static final int DEFAULT_TIMEOUT = 10_000;

    private final String method;
    private final Collection<? extends Map.Entry<String, ?>> headers;
    private final Collection<? extends Map.Entry<String, ?>> cookies;
    private final String userAgent;
    private final Charset charset;
    private final RequestBody<?> body;
    private final int socksTimeout;
    private final int connectTimeout;
    private final Proxy proxy;
    private final boolean followRedirect;
    private final boolean compress;
    private final boolean verify;
    private final List<CertificateInfo> certs;
    private final BasicAuth basicAuth;
    @Nonnull
    private final Session session;
    private final URL url;

    HttpRequest(RequestBuilder builder) {
        method = builder.method;
        headers = builder.headers;
        cookies = builder.cookies;
        userAgent = builder.userAgent;
        charset = builder.requestCharset;
        body = builder.body;
        socksTimeout = builder.socksTimeout;
        connectTimeout = builder.connectTimeout;
        proxy = builder.proxy;
        followRedirect = builder.followRedirect;
        compress = builder.compress;
        verify = builder.verify;
        certs = builder.certs;
        basicAuth = builder.basicAuth;
        session = builder.session;

        this.url = Utils.joinUrl(builder.url, builder.params, charset);
    }

    public String getMethod() {
        return method;
    }

    public Collection<? extends Map.Entry<String, ?>> getHeaders() {
        return headers;
    }

    public Collection<? extends Map.Entry<String, ?>> getCookies() {
        return cookies;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public Charset getCharset() {
        return charset;
    }

    public RequestBody<?> getBody() {
        return body;
    }

    public int getSocksTimeout() {
        return socksTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public boolean isFollowRedirect() {
        return followRedirect;
    }

    public boolean isCompress() {
        return compress;
    }

    public boolean isVerify() {
        return verify;
    }

    public List<CertificateInfo> getCerts() {
        return certs;
    }

    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    @Nonnull
    public Session getSession() {
        return session;
    }

    public URL getUrl() {
        return url;
    }
}