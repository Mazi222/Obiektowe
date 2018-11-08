package lab5.Napisy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SubtitleTimeChanger {

    private SubtitleParser subtitleParser;

    SubtitleTimeChanger()
    {
        subtitleParser = new SubtitleParser();
    }

    public void delay(final String inputName, final String outputName, int delay, int fps) throws IOException, WrongFramesException, NoMatchFoundExepction
    {

        FileWriter fileWriter = new FileWriter(new File(outputName));
        Scanner scanner = new Scanner(new File(inputName));

        while (scanner.hasNextLine())
        {
            String lineFromFile = scanner.nextLine();
            String[] parsedSubtitle = subtitleParser.parse(lineFromFile);

            int newBeginFrameOfTheText = Integer.parseInt(parsedSubtitle[0])+(delay/1000)*fps;
            int newEndFrameOfTheText = Integer.parseInt(parsedSubtitle[1])+(delay/1000)*fps;
            if(newEndFrameOfTheText<newBeginFrameOfTheText)
            {
                throw new WrongFramesException(lineFromFile);
            }

            StringBuilder subtitleBuilder = new StringBuilder();
            subtitleBuilder.append("{").append(newBeginFrameOfTheText).append("}{").append(newEndFrameOfTheText).append("}").append(parsedSubtitle[2]).append("\n");

            fileWriter.write(subtitleBuilder.toString());
        }
    }
}
