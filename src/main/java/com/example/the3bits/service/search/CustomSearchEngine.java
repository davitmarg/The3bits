package com.example.the3bits.service.search;

import com.example.the3bits.facade.rental.model.RentalResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomSearchEngine {


    private String rentalString(RentalResponseModel announcement) {
        String result = announcement.getDescription();

        result += "#" + announcement.getUser().getFirstName();
        result += " " + announcement.getUser().getLastName();
        result += " " + announcement.getUser().getUsername();

        result += "#" + announcement.getHouseResponseModel().getAddress().getCountry();
        result += " " + announcement.getHouseResponseModel().getAddress().getCity();
        result += " " + announcement.getHouseResponseModel().getAddress().getStreet();

        result += "#" + announcement.getPrice();

        result += "#";
        return result;
    }

    private Integer distance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }

    private Double similarity(String[] terms, String text) {
        double sum = 0.;

        for(String term : terms)
            for (int i = 0; i + term.length() - 1 < text.length(); i++) {
                double dist = distance(term,text.substring(i,i+term.length()));
                dist/=term.length();
                dist/=text.length();
                dist/= terms.length;
                sum+=dist;
            }

        return sum;
    }
    private Double similarity(String term, String text) {
        String[] terms = term.toLowerCase().split(" ");
        return similarity(terms,text.toLowerCase());
    }

    public List<RentalResponseModel> search(String term, List<RentalResponseModel> announcements) {

        announcements.sort((a, b) -> {
            Double val1 = similarity(term, rentalString(a));
            Double val2 = similarity(term, rentalString(b));
            return val1.compareTo(val2);
        });
        return announcements;
    }

}
