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
package com.javacreed.examples.gson.part1;

public class Book {

  private Author[] authors;
  private String isbn;
  private String title;

  public Author[] getAuthors() {
    return authors;
  }

  public int[] getAuthorsIds() {
    final int[] ids = new int[authors.length];
    for (int i = 0; i < ids.length; i++) {
      ids[i] = authors[i].getId();
    }
    return ids;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setAuthors(final Author[] authors) {
    this.authors = authors;
  }

  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    final StringBuilder formatted = new StringBuilder();
    formatted.append(title);
    formatted.append(" [").append(isbn).append("]\nWritten by:");
    for (final Author author : authors) {
      formatted.append("\n  >> ").append(author);
    }

    return formatted.toString();
  }
}
