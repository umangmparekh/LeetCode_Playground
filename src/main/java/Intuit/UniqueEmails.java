package Intuit;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println("Unique emails Count >> " + numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();

        for(String email : emails){
            StringBuilder cleanEmail = new StringBuilder();
            for(int i=0; i<email.length(); ++i){
                char currChar = email.charAt(i);

                if(currChar == '+' || currChar == '@') break;
                if(currChar != '.') cleanEmail.append(currChar);
            }

            StringBuilder domainName = new StringBuilder();
            for(int i=email.length()-1; i>=0; --i){
                char currChar = email.charAt(i);
                domainName.append(currChar);
                if(currChar == '@') break;
            }

            domainName = domainName.reverse();
            cleanEmail.append(domainName);
            uniqueEmails.add(cleanEmail.toString());

        }

        return uniqueEmails.size();
    }
}
