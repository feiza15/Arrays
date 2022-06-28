public class Main {

    public static void main(String[] args) {
        //using this method to call the different methods
        tenArray();
        System.out.println(addition(1, 2));
        System.out.println(numbers(8755));
        modNumbers(24);
        System.out.println(modNumbers(6314));
        printNumbers();
    }

    public static void printNumbers() {
        for (int i = 1; i < 100; i++) {
            System.out.println(numbers(i));
        }
    }
    
    public static void tenArray() {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]*10;
            System.out.println(arr[i]);
        }
    }

    //all the methods with mod in the name is my second attempt at the numbers questions using % and /
    public static String modNumbers(int a) {
        //bunch of if statements to see the length of the number as once i create the array to store each unit, i cant change it
        if(a < 100){
            // calls the method which deals with numbers of length 2
            return modTensNumber(a);
        }
        else if (a < 1000) {
            // calls the method which deals with numbers of length 2
            return modHundredNumber(a);
        }
        else {
            // calls the method which deals with numbers of length 3
            return modThousandNumber(a);
        }
    }

    public static String modThousandNumber(int a) {
        // uses mod to find the single digits and declaring and initialising the called deconNumber
        int[] deconNumber = {(a/1000)%10, (a/100)%10, (a/10)%10, a%10};

        //String with the string version of the number so units[4] = "four so i can access the index to get the string version of the number
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //sends the hundred and tens of the number to the methods that deal with them, takes the returned string and connects it to the string which is being returned
        return units[deconNumber[0]] + " thousand and " + modHundredNumber((deconNumber[1]*100) + (deconNumber[2]*10) + deconNumber[3]);
    }

    public static String modHundredNumber(int a) {
        // uses mod to find the single digits and declaring and initialising the called deconNumber
        int[] deconNumber = {(a/100)%10, (a/10)%10, a%10};

        //String with the string version of the number so units[4] = "four so i can access the index to get the string version of the number
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //sends the tens of the number to the methods that deal with them, takes the returned string and connects it to the string which is being returned
        return units[deconNumber[0]] + " hundred and " + modTensNumber((deconNumber[1]*10) +deconNumber[2]);
    }

    public static String modTensNumber(int i) {
        // uses mod to find the single digits and declaring and initialising the called deconNumber
        int[] deconNumber = {(i/10)%10, i%10};

        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        //deals with the fact that 11 and 12 are annoying
        if(deconNumber[0] == 1) {
            if(deconNumber[1] == 11) {
                return "eleven";
            }
            else if(deconNumber[1] == 12) {
                return "twelve";
            }
            else{
                return units[deconNumber[1]] + "teen";
            }
        }
        else {
            return tens[deconNumber[0]] + " " + units[deconNumber[1]];
        }
    }


    //these few methods use the longer method I was using which switches from string to arrays
    public static String numbers(int a) {
        //the String.valueOF(a) turns a into a string from an int and the split.(") then splits the string into strings of one number
        // if you use .split("e") for a string with e, it would split the String into an array, breaking off the string at the e's
        String[] split = String.valueOf(a).split("");

        //same thing as before
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //initialses a string, in this approach i stored the final string into a variable but in the other approach i returned the string withouut storing it in a variable
        String number;

        //same thing were it checks how long the number is
        //as i turned the split number into a string, to access the units and tens string where ive stored the string values, ive chnaged the string into an int
        // so Integer.parseInt("4") gives the int 4 so i can then use it to access the arrays.
        if(a < 10) {
            number = units[Integer.parseInt(split[0])];
        }
        else if(a < 100) {
            number = tensNumber(a);
        }
        else if(a < 1000) {
            number = hundredsNumber(a);
        }
        else {
            number = units[Integer.parseInt(split[0])] + " thousand " + hundredsNumber(Integer.parseInt(split[1] + split[2] +split[3]));
        }
        return number;
    }

    public static String hundredsNumber(int a) {
        String[] split = String.valueOf(a).split("");

        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String number;

        return units[Integer.parseInt(split[0])] + " hundred and " + tensNumber(Integer.parseInt(split[1] + split[2]));
        //return number;
    }

    public static String tensNumber(int a) {
        String[] split = String.valueOf(a).split("");

        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String number;
        if(a < 10) {
            number = units[Integer.parseInt(split[0])];
        }

        else if (split[0].equals("1")) {
            if (split[1].equals("1") || split[1].equals("2")) {
                if (a == 11) {
                    number = "eleven";
                }
                else {
                    number = "twelve";
                }
            }
            else {
                number = units[Integer.parseInt(split[1])] + "teen";
            }
        }
        else {
            number = tens[Integer.parseInt(split[0])] + "-" + units[Integer.parseInt(split[1])];
        }

        return number;
    }

    public static int addition(int a, int b) {
        return a+b;
    }


}
