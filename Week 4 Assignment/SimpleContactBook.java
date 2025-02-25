import java.util.Scanner;

class Contact {
    String name, phone, email;
    Contact next;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.next = null;
    }
}

class ContactBook {
    Contact head;

    void add(String name, String phone, String email) {
        Contact newContact = new Contact(name, phone, email);
        if (head == null) {
            head = newContact;
        } else {
            Contact temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }
        System.out.println("contact added ! " + name);
    }

    void delete(String name) {
        if (head == null) {
            System.out.println("list is empty !");
            return;
        }
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("contact deleted !");
            return;
        }
        Contact temp = head;
        while (temp.next != null && !temp.next.name.equals(name)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("u sure bc this is not found !");
        } else {
            temp.next = temp.next.next;
            System.out.println("contact deleted !");
        }
    }

    void searchByName(String name) {
        Contact temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("ok so like we found : " + temp.name + " " + temp.phone + " " + temp.email);
                return;
            }
            temp = temp.next;
        }
        System.out.println("not found !");
    }

    void searchByEmail(String email) {
        Contact temp = head;
        while (temp != null) {
            if (temp.email.equals(email)) {
                System.out.println("ok so like we found : " + temp.name + " " + temp.phone + " " + temp.email);
                return;
            }
            temp = temp.next;
        }
        System.out.println("not found !");
    }

    void printList() {
        Contact temp = head;
        if (temp == null) {
            System.out.println("list is empty !");
            return;
        }
        while (temp != null) {
            System.out.println(temp.name + " - " + temp.phone + " - " + temp.email);
            temp = temp.next;
        }
    }
}

public class SimpleContactBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactBook book = new ContactBook();

        while (true) {
            System.out.println("*************** \n(A)dd \n(D)elete \n(S)earch \n(E)mail Search \n(P)rint \n(Q)uit \n*************** \ntype the letter to enter the command : ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("A")) {
                System.out.print("name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("phone number: ");
                String phone = sc.nextLine();
                System.out.print("email: ");
                String email = sc.nextLine();
                book.add(name, phone, email);
            } else if (choice.equalsIgnoreCase("D")) {
                System.out.print("contact to delete : ");
                sc.nextLine();
                String name = sc.nextLine();
                book.delete(name);
            } else if (choice.equalsIgnoreCase("S")) {
                System.out.print("name to search : ");
                sc.nextLine();
                String name = sc.nextLine();
                book.searchByName(name);
            } else if (choice.equalsIgnoreCase("E")) {
                System.out.print("email to search : ");
                sc.nextLine();
                String email = sc.nextLine();
                book.searchByEmail(email);
            } else if (choice.equalsIgnoreCase("P")) {
                book.printList();
            } else if (choice.equalsIgnoreCase("Q")) {
                System.out.println("ok bye");
                break;
            } else {
                System.out.println("wrong choice buddy !@#!@!#!");
            }
        }

        sc.close();
    }
}
