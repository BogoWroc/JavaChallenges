package org.example.jooq;

import org.example.jooq.model.tables.Article;
import org.example.jooq.model.tables.Author;
import org.example.jooq.model.tables.records.ArticleRecord;
import org.example.jooq.model.tables.records.AuthorRecord;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;

import java.util.HashMap;

import static org.example.jooq.Crud.*;

public class CrudExamples {

    private final DSLContext context;

    public CrudExamples(DSLContext context) {
        this.context = context;
    }

    public void crudExamples() {
        createValues();
        readValues();
        updateValues();
        deleteValues();
    }

    private void createValues() {

        AuthorRecord author = context.newRecord(Author.AUTHOR);
        author.setId(1);
        author.setFirstName("John");
        author.setLastName("Smith");
        author.setAge(40);

        save(author);

        ArticleRecord article = context.newRecord(Article.ARTICLE);

        article.setId(2);
        article.setTitle("jOOQ examples");
        article.setDescription("A few examples of jOOQ CRUD operations");
        article.setAuthorId(1);

        save(article);
    }

    private void readValues() {
        Result<Record> authors = getAll(
                context,
                Author.AUTHOR
        );

        authors.forEach(author -> {
            Integer id = author.getValue(Author.AUTHOR.ID);
            String firstName = author.getValue(Author.AUTHOR.FIRST_NAME);
            String lastName = author.getValue(Author.AUTHOR.LAST_NAME);
            Integer age = author.getValue(Author.AUTHOR.AGE);
            System.out.printf("Author %s %s has id: %d and age: %d%n", firstName, lastName, id, age);
        });

        Result<Record> articles = getFields(
                context,
                Article.ARTICLE,
                Article.ARTICLE.ID, Article.ARTICLE.TITLE
        );

        AuthorRecord author = getOne(
                context,
                Author.AUTHOR,
                Author.AUTHOR.ID.eq(1)
        );
    }

    private void updateValues() {
        HashMap<Field<String>, String> fieldsToUpdate = new HashMap<>();
        fieldsToUpdate.put(Author.AUTHOR.FIRST_NAME, "David");
        fieldsToUpdate.put(Author.AUTHOR.LAST_NAME, "Brown");
        update(
                context,
                Author.AUTHOR,
                fieldsToUpdate,
                Author.AUTHOR.ID.eq(1)
        );

        ArticleRecord article = context.fetchOne(Article.ARTICLE, Article.ARTICLE.ID.eq(2));
        article.setTitle("A New Article Title");
        update(article);
    }

    private void deleteValues() {
        delete(
                context,
                Article.ARTICLE,
                Article.ARTICLE.ID.eq(1)
        );

        AuthorRecord author = context.fetchOne(Author.AUTHOR, Author.AUTHOR.ID.eq(1));
        delete(author);
    }
}
