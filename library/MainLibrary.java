package com.howtodoinjava.hibernate.library;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class MainLibrary {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setNamePublishingHouse("Libris");
        publishingHouse.setYearOfAppear(1955);
        publishingHouse.setRating(3);

        Books book = new Books();
        book.setTitle("Cei trei mușchetari");
        book.setPublishingHouse(publishingHouse);
        book.setNrPages(325);
        book.setYearOfPublication(1901);
        book.setStatus(false);
        book.setCategories("Roman");

        Authors author = new Authors();
        author.setName("Dumas");
        author.setSurnameAuthor("Alexander");
        author.setGender("M");
        author.setAge(33);
        author.setYearsOfExperience(55);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select option:");
        System.out.println("Option1: Insert a new author.");
        System.out.println("Option2: Insert a new book.");
        System.out.println("Option3: Insert a new publishing house.");
        System.out.println("Option4: Modify the author name and surname.");
        System.out.println("Option5: Modify the publishing house name.");
        System.out.println("Option6: Show all the books.");
        System.out.println("Option7: Show the author sorted by name and surname.");
        System.out.println("Option8: Show the ages and the names of all the  authors which helped writing the selected book.");
        System.out.println("Option9: Show the publishing house name and the books name from the 'action' category.");
        System.out.println("Option10: Show the oldest book along with the name of the author/authors that helped writing it.");
        System.out.println("Option11: Delete a specified publishing house.");
        System.out.println("Option12: Check if the selected book is available to be borrowed.");
        System.out.println("Option13: Connect an author to a book.");
        System.out.println("Option14: Connect the reviews and stars list to a book.");
        System.out.println("Option15: Create a simple profile in our library.");
        System.out.println("Option16: Borrow books if you have a profile.");
        System.out.println("Option17: Save and exit.");

        int option = scanner.nextInt();

        do {
            if (option == 1) {
                System.out.println("Insert a new author:");
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("1.Insert the first name:");
                String input1 = scanner1.nextLine();

                System.out.println("1.Insert the last name of the author:");
                String input2 = scanner1.nextLine();

                System.out.println("2.Insert the age:");
                Integer input3 = scanner1.nextInt();

                System.out.println("3.Insert the experience:");
                Integer input4 = scanner1.nextInt();

                System.out.println("4.Insert gender:");
                String input5 = scanner1.next();

                Authors authorAdd = new Authors();
                authorAdd.setName(input1);
                authorAdd.setSurnameAuthor(input2);
                authorAdd.setAge(input3);
                authorAdd.setYearsOfExperience(input4);
                authorAdd.setGender(input5);

                session.persist(authorAdd);

                System.out.println("The new author has been added.");
            }
            if (option == 2) {
                System.out.println("Insert a new book:");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("1.Insert title:");
                String input1 = scanner1.nextLine();

                System.out.println("2.Insert the publication year:");
                Integer input2 = scanner1.nextInt();

                System.out.println("3.Insert category:");
                String input3 = scanner1.next();

                System.out.println("4.Insert the number of pages:");
                Integer input4 = scanner1.nextInt();

                System.out.println("5.Insert status:");
                Boolean input5 = scanner1.nextBoolean();

                Books bookAdd = new Books();
                bookAdd.setTitle(input1);
                bookAdd.setYearOfPublication(input2);
                bookAdd.setCategories(input3);
                bookAdd.setNrPages(input4);
                bookAdd.setStatus(input5);

                System.out.println("Choose the next options:");
                System.out.println("1.Create new publishing house for your new book.");
                System.out.println("2.Select the existing publishing house for your new book.");

                int option1 = scanner1.nextInt();

                if (option1 == 1) {
                    System.out.println("Insert a new publishing house:");
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("1.Insert the name of the publishing house:");
                    String input6 = scanner2.nextLine();

                    System.out.println("2.Insert the year of appearance:");
                    Integer input7 = scanner2.nextInt();

                    System.out.println("3.Insert rating:");
                    Integer input8 = scanner2.nextInt();

                    PublishingHouse publishingHouseAdd = new PublishingHouse();
                    publishingHouseAdd.setNamePublishingHouse(input6);
                    publishingHouseAdd.setYearOfAppear(input7);
                    publishingHouseAdd.setRating(input8);

                    System.out.println("The new publishing house has been added.");

                    session.persist(publishingHouseAdd);
                    bookAdd.setPublishingHouse(publishingHouseAdd);

                }
                if (option1 == 2){
                    Scanner scanner2 = new Scanner(System.in);
                    Query resultAll = session.createQuery("from PublishingHouse");
                    List list = resultAll.getResultList();
                    list.forEach(System.out::println);

                    System.out.println("Insert the name of the publishing house.");
                    String input = scanner2.next();
                    Query query = session.createQuery("from PublishingHouse where namePublishingHouse =:name");
                    query.setParameter("name",input);
                    PublishingHouse resultList = (PublishingHouse) query.getResultList().get(0);

                    bookAdd.setPublishingHouse(resultList);
                }

                session.persist(bookAdd);

                System.out.println("The new book has been added.");

            }
            if (option == 3) {
                System.out.println("Insert a new publishing house:");
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("1.Insert the name of the publishing house:");
                String input1 = scanner1.nextLine();

                System.out.println("2.Insert the year of appearance:");
                Integer input2 = scanner1.nextInt();

                System.out.println("3.Insert rating:");
                Integer input3 = scanner1.nextInt();

                PublishingHouse publishingHouseAdd = new PublishingHouse();
                publishingHouseAdd.setNamePublishingHouse(input1);
                publishingHouseAdd.setYearOfAppear(input2);
                publishingHouseAdd.setRating(input3);

                System.out.println("The new publishing house has been added.");
                session.persist(publishingHouseAdd);
            }
            if (option == 4) {
                System.out.println("The authors are:");
                Query result = session.createQuery("from Authors");
                result.getResultList().forEach(System.out::println);

                System.out.println("Select the author name that you want to modify:");
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("1.The name of the author:");
                String input1 = scanner1.nextLine();

                System.out.println("2.The surname of the author:");
                String input2 = scanner1.nextLine();

                Query query = session.createQuery("from Authors where name=: newName and surnameAuthor=: newSurname");
                query.setParameter("newName", input1);
                query.setParameter("newSurname", input2);
                List list = query.getResultList();

                System.out.println("1.Enter the new name of the author:");
                String input3 = scanner1.nextLine();

                System.out.println("2.Enter the new surname of the author:");
                String input4 = scanner1.nextLine();

                Object o = list.get(0);
                Authors x = (Authors) o;
                x.setName(input3);
                x.setSurnameAuthor(input4);
                session.update(x);

            }
            if (option == 5) {
                System.out.println("The Publishing Houses are:");
                Query result = session.createQuery("from PublishingHouse");
                result.getResultList().forEach(System.out::println);

                System.out.println("Select the publishing house that you want to modify:");
                Scanner scanner1 = new Scanner(System.in);
                String input1 = scanner1.nextLine();
                Query query = session.createQuery("from PublishingHouse where namePublishingHouse=:newName");
                query.setParameter("newName", input1);
                List list = query.getResultList();

                System.out.println("Enter the new name of the publishing house:");
                String input2 = scanner1.nextLine();
                Object o = list.get(0);
                PublishingHouse x = (PublishingHouse) o;
                x.setNamePublishingHouse(input2);
                session.update(x);

            }
            if (option == 6) {
                System.out.println("Those are the books:");
                Query query = session.createQuery("from Books");
                List list = query.getResultList();
                System.out.println(list);

            }
            if (option == 7) {
                System.out.println("The authors shown by name and surname:");
                Query query = session.createQuery("from Authors where name=:newName and surnameAuthor=:newSurname");

                Authors authorAdd = (Authors) query.getResultList().get(0);

                System.out.println(authorAdd);

            }
            if (option == 8) {
                System.out.println("Insert the book name:");

                Scanner scanner1 = new Scanner(System.in);
                String input1 = scanner1.nextLine();

                Query query = session.createQuery("from Books where title=:newTitle");
                query.setParameter("newTitle", input1);
                Books bookAdd = (Books) query.getResultList().get(0);
                System.out.println(bookAdd.getAuthors());

            }
            if (option == 9) {
                Query query = session.createQuery("from Books where category=:newCategory");
                query.setParameter("newCategory", "action");
                List<Books> list = (List<Books>) query.getResultList();
                for (Books item : list) {
                    String x = item.getTitle();
                    String y = String.valueOf(item.getPublishingHouse());
                    System.out.println("The names of the books are " + x + " and the publishing houses are " + y);
                }

            }
            if (option == 10) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Select the year of the book:");

                Integer input1 = scanner1.nextInt();
                Query query = session.createQuery("from Books where yearOfPublication<:newYearOfPublication");
                query.setParameter("newYearOfPublication", input1);
                Query query1 = session.createQuery("from Authors where yearsOfExperience=:newYearsOfExperience");
                Authors authorAdd = (Authors) query1.getResultList().get(0);

                List<Books> list = (List<Books>) query.getResultList();
                for (Books item : list) {

                    String name = String.valueOf(item.getAuthors());
                    Integer exp = author.getIdAuthor();
                    System.out.println("The name of the authors are " + name + " and their experience are " + exp);

                }

            }
            if (option == 11) {
                System.out.println("Choose the publishing house that you want to delete:");

                Scanner scanner5 = new Scanner(System.in);
                String input = scanner5.nextLine();

                Query query = session.createQuery("from PublishingHouse where namePublishingHouse=:newNamePublishingHouse");
                query.setParameter("newNamePublishingHouse", input);
                List list = query.getResultList();
                session.delete(list.get(0));
            }
            if (option == 12) {
                System.out.println("Select the book name that you want to borrow:");
                Scanner scanner5 = new Scanner(System.in);
                String input = scanner5.nextLine();

                Query query = session.createQuery("from Books where title =: newTitle");
                query.setParameter("newTitle", input);
                List<Books> list = (List<Books>) query.getResultList();

                for (Books bookAdd : list) {
                    if (bookAdd.isStatus() == true) {
                        System.out.println("The book " + bookAdd.getTitle() + " is available to be borrowed.");
                    } else {
                        System.out.println("The book " + bookAdd.getTitle() + " is not available to be borrowed.");
                    }
                }

            }
            if (option == 13) {
                System.out.println("Select the book:");
                Scanner scanner5 = new Scanner(System.in);
                String input = scanner5.nextLine();
                Query query = session.createQuery("from Books where title =:newTitle");
                query.setParameter("newTitle", input);
                Books list = (Books) query.getResultList().get(0);
                System.out.println("The book '" + list + "' has been found.");

                Scanner scanner6 = new Scanner(System.in);
                System.out.println("Insert the author name:");
                String input1 = scanner6.nextLine();
                System.out.println("Insert the author surname:");
                String input2 = scanner6.nextLine();
                Query query1 = session.createQuery("from Authors where name =:newName and surnameAuthor=:newSurname");
                query1.setParameter("newName", input1);
                query1.setParameter("newSurname", input2);
                Authors list1 = (Authors) query1.getResultList().get(0);

                System.out.println("The author '" + list1 + "' has been found.");

                list.getAuthors().add(list1);
                session.persist(list);
                System.out.println("The link has been successful.");

            }

            if (option == 14) {
                System.out.println("Chose the book you want to add a rating");
                Scanner scanner1 = new Scanner(System.in);
                String inputSearchBookByTitle = scanner1.nextLine();
                Query query = session.createQuery("from Books where title=:searchTitle");
                query.setParameter("searchTitle", inputSearchBookByTitle);
                Books listResulTitle = (Books) query.getResultList().get(0);

                System.out.println("Please add a review");
                String inputAddReviewToABook = scanner1.nextLine();
                System.out.println("Please add a star between 1 and 5");
                Integer inputAddStarToABook = scanner1.nextInt();
                ReviewAndStar reviewAndStar = new ReviewAndStar();
                reviewAndStar.setStars(inputAddStarToABook);
                reviewAndStar.setReview(inputAddReviewToABook);
                session.persist(reviewAndStar);


                listResulTitle.getReviewAndStars().add(reviewAndStar);

                session.save(listResulTitle);
            }
            if (option == 15) {
                System.out.println("To create an account you need to enter your name and a unique number or numbers");
                System.out.println("Insert your last name");
                Scanner scanner1 = new Scanner(System.in);
                String inputLastName = scanner1.nextLine();
                System.out.println("Insert your first name");
                String inputFirstName = scanner1.nextLine();
                System.out.println("Insert unique number");
                Integer inputUniqueID = scanner1.nextInt();
                System.out.println("Insert your gender");
                String inputGender = scanner1.nextLine();

                Person personClients = new Person();
                personClients.setPersonLastName(inputLastName);
                personClients.setPersonFirstName(inputFirstName);
                personClients.setIdIdentification(inputUniqueID);
                personClients.setGender(inputGender);
                session.persist(personClients);
            }
            if (option == 16) {

                System.out.println("Chose the book you want to borrow");
                Scanner scanner1 = new Scanner(System.in);

                String searchBook = scanner1.nextLine();
                Query query = session.createQuery("from Books where title=:searchBook");
                query.setParameter("searchBook", searchBook);
                Books bookFound = (Books) query.getResultList().get(0);
                System.out.println(bookFound + "was found");

                System.out.println("Enter your unique ID");
                Integer searchUniquePersonID = scanner1.nextInt();
                Query query1 = session.createQuery("from Person where idPersonC=:searchID");
                query1.setParameter("searchID", searchUniquePersonID);
                Person personClients = (Person) query1.getResultList().get(0);
                System.out.println(personClients + "was found");

                bookFound.getPersonClients().add(personClients);
                session.persist(bookFound);
            }

            if (option != 17) {
                option = scanner.nextInt();
            }


        } while (option != 17);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

}
