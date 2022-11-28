package Main;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class Fuzzy {
    int mistakes, helps, time;
    public static double fuzzify(long mistakes, long helps, long time) throws Exception {
        double difficulty;
        // Load from 'FCL' file
        String fileName = "src/tipper.fcl";
        FIS fis = FIS.load(fileName, true);
        if (fis == null) { // Error while loading?
            System.err.println("Can't load file: '" + fileName + "'");
        }

        // Show ruleset
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        //functionBlock.chart();

        // Set inputs
        functionBlock.setVariable("mistakes", mistakes);
        functionBlock.setVariable("help", helps);
        functionBlock.setVariable("time",time/1000);

        // Evaluate
        functionBlock.evaluate();
         /*
        // Show output variable's chart
        functionBlock.getVariable("difficulty").chartDefuzzifier(true);
        Gpr.debug("few[mistakes]: " + functionBlock.getVariable("mistakes").getMembership("few"));

        // Print ruleSet
        System.out.println(functionBlock);
        System.out.println("DIFFICULTY:" + functionBlock.getVariable("difficuly").getValue());
         */
        difficulty = functionBlock.getVariable("difficulty").getValue();
        return difficulty;
    }
}
