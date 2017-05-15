package com.androidstarterkit.tool;


import java.util.List;

public class JavaLineScanner {

  public int getCloseBracketIndex(List<String> codelines) {
    int result = -1;
    for (int i = 0, li = codelines.size(); i < li; i++) {
      String commentRemovedCodeline = replaceComment(codelines.get(i));

      if (commentRemovedCodeline.contains("}")) {
        result = i;
      }
    }

    return result;
  }

  public String replaceComment(String codeline) {
    return codeline.replaceAll("//.*", "");
  }
}
