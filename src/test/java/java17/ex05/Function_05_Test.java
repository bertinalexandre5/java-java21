package java17.ex05;

import java.util.List;
import java.util.WeakHashMap;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

import java17.data.Data;
import java17.data.Person;
import org.junit.internal.builders.JUnit3Builder;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
//  Consumer<Person> changePasswordToSecret = null;
    Consumer<Person> changePasswordToSecret = person -> person.setPassword("secret"); // Je modifie le mot de passe de la personne pour lui donner la valeur "secret"

    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
//  Consumer<Person> verifyAge = null;
    Consumer<Person> verifyAge = person -> {
        assert person.getAge() > 4;
    }; // Je vérifie que l'age de la personne est supérieur à 4 avec > 4

    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
//  Consumer<Person> verifyPassword = null;
    Consumer<Person> verifyPassword = person -> {
        assert person.getPassword().equals("secret");
    }; // Je vérifie que le mot de passe est égal à "secret avec la méthode.equals
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret); // J'appelle la fonction changePasswordToSecret initiée juste au dessus

        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        personList.forEach(verifyAge.andThen(verifyPassword)); // J'appelle les fonction verifyAge et verifyPassword initiée juste an dessous en utilisant la méthode andThen
        for(Person p : personList) {
            verifyAge.accept(p);
            verifyPassword.accept(p);
        }
    }
}