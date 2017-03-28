
package dmbannoproject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morehoud
 */
public class BannoFunctions 
{
    int platformFeaturesCount (String entity)
    {
        int count = 0;
        String findStr = "h3 class=";
        int lastIndex = 0;

        while(lastIndex != -1)
        {

            lastIndex = entity.indexOf(findStr,lastIndex);

            if(lastIndex != -1)
            {
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
    
    String topAlphaChar (String entity)
    {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        String alphaCount = "";
        

        for (int i = 0; i < entity.length(); i++)
        {
            char charAt = entity.charAt(i);

            if (!charCountMap.containsKey(charAt))
            {
                charCountMap.put(charAt, 1);
            }
            else
            {
                charCountMap.put(charAt, charCountMap.get(charAt) + 1);
            }
        }
        
        charCountMap.put(' ', -1);
        
        for (int i = 0; i < 3; i++)
        {
            Map.Entry<Character, Integer> maxEntry = null;
            
            for (Map.Entry<Character, Integer> entry : charCountMap.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }
            alphaCount = alphaCount + maxEntry.getKey() + " : " + maxEntry.getValue() + "\n";
            charCountMap.put(maxEntry.getKey(), -1);
        }
        return alphaCount;
    }
    
    int pngImagesCount (String entity)
    {
        int count = 0;
        String findStr = ".png";
        int lastIndex = 0;

        while(lastIndex != -1)
        {

            lastIndex = entity.indexOf(findStr,lastIndex);

            if(lastIndex != -1)
            {
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
    
    String bannoTwitterHandle (String entity)
    {
        String twitterHandle = "";
        int currIndex = entity.indexOf("twitter:site") + 22;
        char currChar = entity.charAt(currIndex);
        
        while ( currChar!= '>')
        {
            twitterHandle += entity.charAt(currIndex);
            currIndex++;
            currChar = entity.charAt(currIndex);
        }
        
        return twitterHandle;
    }
    
    int financialinstitutionCount (String entity)
    {
        int count = 0;
        int startIndex = entity.indexOf("<body>");
        int endIndex = entity.indexOf("</body>");
        String findStr = "financial institution";
        String mainStr = entity.substring(startIndex, endIndex);
        int lastIndex = 0;

        while(lastIndex != -1)
        {

            lastIndex = mainStr.indexOf(findStr,lastIndex);

            if(lastIndex != -1)
            {
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }
}
