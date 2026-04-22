package crowdstrike;

import java.util.*;

public class WordBreak {

    private static Map<Integer, List<String>> memo;
    private static Set<String> dict;

    private static String str;

    public static List<String> wordBreak(String s, List<String> wordDict){
        str = s;
        dict = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dfs(0);
    }

    // Returns all valid sentences formed from s[start..]
    private static List<String> dfs(int start) {
        if(memo.containsKey(start)) return memo.get(start);

        List<String> result = new ArrayList<>();

        // Base Case :reached end of string — one valid path complete
        if(start == str.length()){
            result.add("");
            return  result;
        }

        for(int end=start+1; end<= str.length(); end++){
            String word = str.substring(start, end);

            if(dict.contains(word)){
                List<String> suffixes = dfs(end);

                for(String suffix : suffixes){
                    result.add(word+(suffix.isEmpty() ?  " " : (" " + suffix)));
                }
            }
        }

        memo.put(start, result);
        return result;
    }

    public static void main(String[] args){

         String s = "catsanddog";
         List<String> wordDict = List.of("cat","cats","and","sand","dog");
        System.out.println(wordBreak(s, wordDict));

    }

    }
