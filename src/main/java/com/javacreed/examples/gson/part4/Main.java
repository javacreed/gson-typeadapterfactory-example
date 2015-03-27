/*
 * #%L
 * Gson TypeAdapterFactory Example
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.gson.part4;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {
  public static void main(final String[] args) throws IOException {

    final Class<?> type = new TypeToken<List<A>>() {}.getRawType();

    // Configure GSON
    final DataTypeAdapterFactory.Builder dtafBuilder = new DataTypeAdapterFactory.Builder();
    dtafBuilder.add(A.class, new ATypeAdapter());
    dtafBuilder.add(type, new ListATypeAdapter());

    final GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapterFactory(dtafBuilder.build());
    gsonBuilder.setPrettyPrinting();

    final Gson gson = gsonBuilder.create();

    final List<B> list = Arrays.asList(new B());

    final String json = gson.toJson(list, type);
    System.out.println(json);
  }
}
