import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.*;

public class SendMessage {

    private static final String ACCOUNT_SID = "";
    private static final String AUTH_TOKEN = "";
    private static final String TWILIO_NUMBER = "";
    private static final List<String> NUMBERS = new ArrayList<>();

    public static void main(String[] args) {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String msg = buildMessage();

        for (String i : NUMBERS) {
            send(i, msg);
        }

    }

    private static Set<String> getList() {
        List<String> list = new ArrayList<>(List.of(
                "Tourist Attractions",
                "Things You Do At Work",
                "Things That You Wear",
                "Things You Plug In",
                "Things at a Circus",
                "Fruits",
                "Games",
                "Things You Buy for Kids",
                "Famous Females",
                "Reasons to Make a Phone Call",
                "Things at a Carnival",
                "Things That Grow",
                "Old-fashioned boy's name",
                "Items that are frozen",
                "Television shows from 2000",
                "Rivers",
                "Vegetables",
                "Things that are yellow",
                "Trees",
                "Marching band instruments",
                "College subjects",
                "Insects",
                "Restaurants",
                "Villains",
                "Toys",
                "Weapons",
                "Things that are Square",
                "Things used by a Bodybuilder",
                "Things in the Bathroom",
                "Types of Exercises",
                "Desserts",
                "Newspapers",
                "Things Found in Space",
                "Book Authors",
                "Countries",
                "Types of Clothing",
                "Games played at Recess",
                "Mammals",
                "Holidays Around the World",
                "Fruits",
                "Things Found in a Forest",
                "Colors",
                "Politicians",
                "Flavors of Ice Cream",
                "Reasons a Child is Grounded",
                "Gemstones",
                "Types of Balls",
                "Animals in Zoos",
                "Things Found in a Park",
                "Parts of the Human Body",
                "Types of Transportation",
                "School Supplies",
                "Items Found in a Library",
                "Types of Birds",
                "Flowers",
                "Types of Shoes",
                "Halloween Costumes",
                "Words Associated With Exercise",
                "Cosmetics/Toiletries",
                "Something You're Afraid of",
                "Reasons to Call 911",
                "Titles People Can Have",
                "Store Names",
                "Things That Are Round",
                "Appliances",
                "Athletes",
                "Things That Have Wheels",
                "Websites",
                "U.S. Cities",
                "Things That Grow",
                "Personality Traits",
                "Things in the Sky",
                "Places in Europe",
                "Foreign Cities",
                "Things that are Sticky",
                "Movie Titles",
                "Companies",
                "Sports Equipment",
                "Vehicles",
                "Types of Drinks",
                "Musical Groups",
                "Seafood",
                "Gifts/Presents",
                "Things that Have Buttons",
                "Things that Have Spots",
                "Things You Get Tickets For",
                "Fictional Characters",
                "Ways to Get From Here to There",
                "Board Games",
                "Colleges/Universities",
                "Things Found in a Hospital",
                "Dairy Products",
                "Tourist Attractions",
                "Restaurants",
                "Things You Do At Work",
                "Footwear",
                "Things You Get in the Mail",
                "Acronyms",
                "Spices/Herbs",
                "Reasons to Take Out a Loan",
                "Excuses for Being Late",
                "Desserts",
                "Appliances",
                "Bad Habits",
                "4-Letter Words",
                "Bodies of Water",
                "Menu Items",
                "Birds",
                "Things That Can Kill You",
                "Fish",
                "Medicine/Drugs",
                "Kinds of Soup",
                "Things in a Souvenir Shop",
                "Words Ending in -N",
                "Things You Sit In/On",
                "Things With Tails",
                "Things You Throw Away",
                "Words Associated With Money",
                "Math Terms",
                "Articles of Clothing",
                "Things That Are Cold",
                "School Subjects",
                "Musical Instruments",
                "Holidays",
                "Capital Cities",
                "Breakfast Foods"
                ));

        Set<String> fullSet = new HashSet<>(list);
        List<String> newList = new ArrayList<>(fullSet);

        Set<String> twelveList = new HashSet<>();
        List<Integer> intList = new ArrayList<>();

        for(int i = 0; i < 12; i++) {
            Random rand = new Random();
            int index = rand.nextInt(fullSet.size());
            while(intList.contains(index)) {
                index = rand.nextInt(fullSet.size());
            }
            intList.add(index);
            twelveList.add(newList.get(index));
        }
        return twelveList;
    }

    private static String buildMessage() {
        int counter =  0;
        StringBuilder sb = new StringBuilder();
        sb.append("The Chosen Letter is: ");
        sb.append(Letters.getRandomLetter());
        for(String item : getList()) {
            sb.append("\n");
            sb.append(++counter);
            sb.append(". ");
            sb.append(item);
        }
        return sb.toString();
    }

    private static void send(String number, String list) {
        Message message = Message.creator(
                new PhoneNumber(number),
                new PhoneNumber(TWILIO_NUMBER),
                list
        ).create();

        System.out.println(message.getSid());
    }
}
