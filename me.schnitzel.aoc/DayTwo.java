import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DayTwo {

    public static void main(String[] args) throws IOException {
        task1();
        task2();
    }

    private static void task1() throws IOException {
        var data = Files.readAllLines(new File("data/day2.txt").toPath());
        long sum = 0;
        for (var line : data) {
            var gameData = line.split(":");
            var gameID = Integer.parseInt(gameData[0].split(" ")[1]);
            boolean valid = true;
            var cubeSets = gameData[1].trim().split(";");
            for (var set : cubeSets) {
                if (!valid) {
                    break;
                }
                var cubes = set.trim().split(",");
                for (var cube : cubes) {
                    var cubeData = cube.trim().split(" ");
                    // System.out.println(gameID + "\t" + cubeData[1] + "\t" + cubeData[0]);
                    if (cubeData[1].equals("red") && Integer.parseInt(cubeData[0]) > 12) {
                        valid = false;
                        break;
                    }
                    if (cubeData[1].equals("green") && Integer.parseInt(cubeData[0]) > 13) {
                        valid = false;
                        break;
                    }
                    if (cubeData[1].equals("blue") && Integer.parseInt(cubeData[0]) > 14) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                sum += gameID;
            }
        }
        System.out.println("Result: " + sum);
    }

    private static void task2() throws IOException {
        var data = Files.readAllLines(new File("data/day2.txt").toPath());
        int sum = 0;
        for (var line : data) {
            var gameData = line.split(":");
            var gameID = Integer.parseInt(gameData[0].split(" ")[1]);
            int red = -1;
            int green = -1;
            int blue = -1;
            var cubeSets = gameData[1].trim().split(";");
            for (var set : cubeSets) {
                var cubes = set.trim().split(",");
                for (var cube : cubes) {
                    var cubeData = cube.trim().split(" ");
                    // System.out.println(gameID + "\t" + cubeData[1] + "\t" + cubeData[0]);
                    var num = Integer.parseInt(cubeData[0]);
                    if (cubeData[1].equals("red") && num > red) {
                        red = num;
                    }
                    if (cubeData[1].equals("green") && num > green) {
                        green = num;
                    }
                    if (cubeData[1].equals("blue") && num > blue) {
                        blue = num;
                    }
                }
            }
            // System.out.println(gameID + "\t" + red + "\t" + green + "\t" + blue);
            sum += red * green * blue;
        }
        System.out.println("Result: " + sum);
    }

}
