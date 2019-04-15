package task2.out;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import task2.csp.Assigment;
import task2.csp.solution.Solution;
import task2.csp.solution.SolutionCollection;

public class HTMLFileGenerator {
  public static void generateHtmlFile(SolutionCollection solutionCollection) {

    for (Solution solution : solutionCollection.getSollutions()) {
      Collections.sort(solution.getAssigments());
    }

    try {
      Path path = Paths.get(solutionCollection.getFile());
      if (Files.exists(path)) {
        Files.delete(path);
      }
      Files.createFile(path);

      String htmlCode =
          "<!DOCTYPE html>\n"
              + "<html>\n"
              + "<head>\n"
              + "<style>\n"
              + "table, th, td {\n"
              + "  border: 1px solid black;\n"
              + "}\n"
              + "</style>\n"
              + "</head>\n"
              + "<body>\n"
              + "\n"
              + "<h2>"
              + solutionCollection.getFile()
              + "</h2>\n"
              + "<span>\n"
              + "method: "
              + solutionCollection.getSolveMethod()
              + "\n"
              + "</span>\n"
              + "<br>\n"
              + "<span>\n"
              + "heuristic: "
              + solutionCollection.getHeuristic()
              + "\n"
              + "</span>\n"
              + "<br>\n"
              + "<span>\n"
              + "solutions found: "
              + solutionCollection.getSollutions().size()
              + "\n"
              + "</span>\n"
              + "<br>\n"
              + "<span>\n"
              + "total moves: "
              + solutionCollection.getTotalMoves()
              + "\n"
              + "</span>\n"
              + "<br>\n";

      StringBuilder sb = new StringBuilder();

      sb.append("<span>\n").append("Constraints: \n" + "<br>\n");
      sb.append(solutionCollection.getConstraintsToString());
      sb.append("</span>\n");

      for (Solution solution : solutionCollection.getSollutions()) {
        sb.append("<table style=\"width:10%\">\n");

        int row = 0;
        sb.append("<tr>\n");
        for (Assigment a : solution.getAssigments()) {
          if (row != a.getVariable().getRowIndex()) {
            sb.append("</tr>\n");
            row = a.getVariable().getRowIndex();
            sb.append("<tr>\n");
          }
          sb.append("<td>\n");
          sb.append(a.getValue()).append("\n");
          sb.append("</td>\n");
        }
        sb.append("</tr>\n</table>\n");
        sb.append("<span>\n")
            .append("moves: ")
            .append(solution.getMoves())
            .append("\n")
            .append("</span>\n");
      }

      String close = "\n</body>\n</html>";

      BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
      bufferedWriter.write(htmlCode + sb.toString() + close);
      bufferedWriter.close();

    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
