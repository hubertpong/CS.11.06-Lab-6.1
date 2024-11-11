import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param numbers
     * @return Answer to Challenge 1
     * @throws IOException
     */


    public static int countOfGreater(int[] numbers){
        int count = 0;
        for(int i = 0; i<numbers.length-1; i++){
            if(numbers[i] < numbers[i+1]){
                count++;
            }
        }
        return count;
    }
    public static int challengeOne(String fileName) throws IOException {
        int[] numbers = readFile(fileName);
        return countOfGreater(numbers);
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] no = readFile(fileName);
        int[] sums = new int[no.length-2];
        int sumsIndex = 0;
        for(int i = 0; i<no.length-2; i++){
            sums[sumsIndex] = no[i] + no[i+1] + no[i+2];
            sumsIndex++;
        }
        return countOfGreater(sums);
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] instructions = readStringFile(fileName);
        int h = 0;
        int d = 0;
        for(int i = 0; i<instructions.length; i++){
            String current = instructions[i];
            String[] diff = current.split(" ");
            if(diff[0].equals("forward")){
                h += Integer.parseInt(diff[1]);
            }
            else if(diff[0].equals("down")){
                d += Integer.parseInt(diff[1]);
            }
            else{
                d -= Integer.parseInt(diff[1]);
            }
        }
        return h * d;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] instructions = readStringFile(filename);
        int h = 0;
        int d = 0;
        int aim = 0;
        for(int i = 0; i<instructions.length; i++){
            String currentInstruction = instructions[i];
            String[] differentInstructions = currentInstruction.split(" ");
            String direction = differentInstructions[0];
            int value = Integer.parseInt(differentInstructions[1]);
            if(direction.equals("forward")){
                h += value;
                d += aim * value;
            }
            else if(direction.equals("down")){
                aim += value;
            }
            else{
                aim -= value;
            }
        }
        System.out.println(h);
        System.out.println(d);
        return h * d;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static String[] readStringFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}