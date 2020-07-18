package com.github.kpavlov.jreactive8583.iso;

import com.solab.iso8583.IsoMessage;
import com.solab.iso8583.MessageFactory;

import javax.annotation.Nonnull;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

public class J8583MessageFactory<T extends IsoMessage>
        implements com.github.kpavlov.jreactive8583.iso.MessageFactory<T> {

    @Nonnull
    private final MessageFactory<T> messageFactory;
    @Nonnull
    private final ISO8583Version isoVersion;

    public J8583MessageFactory(@Nonnull final MessageFactory<T> messageFactory,
                               @Nonnull final ISO8583Version isoVersion) {
        this.messageFactory = messageFactory;
        this.isoVersion = isoVersion;
    }

    @Override
    public T newMessage(final int type) {
        return messageFactory.newMessage(type);
    }

    @Override
    public T createResponse(final T requestMessage) {
        return messageFactory.createResponse(requestMessage);
    }

    @Override
    public T parseMessage(final byte[] buf, final int isoHeaderLength) throws UnsupportedEncodingException, ParseException {
        return messageFactory.parseMessage(buf, isoHeaderLength);
    }
}