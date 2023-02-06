package com.kristofferph.security.game;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomAppSerializer extends JsonSerializer<Applist> {

    @Override
    public void serialize(Applist applist, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        gen.writeObject(applist.getApps());

    }
}
