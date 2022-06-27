package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TLoopBeginJava
{
  protected static String nl;
  public static synchronized TLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLoopBeginJava result = new TLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "int current_iteration_";
  protected final String TEXT_3 = " = 0;";
  protected final String TEXT_4 = NL + "\tlog.info(\"";
  protected final String TEXT_5 = " - Start to loop from \" + (";
  protected final String TEXT_6 = ") + \" to \" + (";
  protected final String TEXT_7 = ") + \" with a step of \" + (";
  protected final String TEXT_8 = ") + \" (\" + ";
  protected final String TEXT_9 = " + \").\");";
  protected final String TEXT_10 = NL + NL + "for(int loop";
  protected final String TEXT_11 = " =";
  protected final String TEXT_12 = "; loop";
  protected final String TEXT_13 = "<=";
  protected final String TEXT_14 = "=loop";
  protected final String TEXT_15 = "+";
  protected final String TEXT_16 = "){";
  protected final String TEXT_17 = NL + "for(int loop";
  protected final String TEXT_18 = ">=";
  protected final String TEXT_19 = NL + "\t";
  protected final String TEXT_20 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Iteration value is \" + loop";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = NL + "current_iteration_";
  protected final String TEXT_24 = "++;" + NL + "globalMap.put(\"";
  protected final String TEXT_25 = "_CURRENT_VALUE\",loop";
  protected final String TEXT_26 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_27 = "_CURRENT_ITERATION\",current_iteration_";
  protected final String TEXT_28 = ");" + NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = ";" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tlog.info(\"";
  protected final String TEXT_32 = " - Start to loop using a while loop. Initial declaration: '\" + ";
  protected final String TEXT_33 = " + \"'. Condition: '\" + ";
  protected final String TEXT_34 = " + \"'.\");" + NL + "\t";
  protected final String TEXT_35 = NL + "while(";
  protected final String TEXT_36 = "){" + NL + "\t";
  protected final String TEXT_37 = " - Current iteration value: \" + current_iteration_";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean forLoop = ("true").equals(ElementParameterParser.getValue(node,"__FORLOOP__"));

boolean whileLoop = ("true").equals(ElementParameterParser.getValue(node,"__WHILELOOP__"));

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if (forLoop) {

String from = ElementParameterParser.getValue(node, "__FROM__");
if (("").equals(from)) from = "1";
String to   = ElementParameterParser.getValue(node, "__TO__");
if (("").equals(to)) to = "1";
String step   = ElementParameterParser.getValue(node, "__STEP__");
if (("").equals(step)) step = "1";
boolean increase = ("true").equals(ElementParameterParser.getValue(node, "__INCREASE__"));
if(isLog4jEnabled){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(increase?"\"Increasing\"":"\"Decreasing\"");
    stringBuffer.append(TEXT_9);
    
}
if(increase){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_16);
    
}else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(step);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_19);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
}else{// While type

String condition = ElementParameterParser.getValue(node, "__CONDITION__");
String declaration = ElementParameterParser.getValue(node, "__DECLARATION__");


    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(declaration);
    stringBuffer.append(TEXT_30);
    if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, "DECLARATION"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, "CONDITION"));
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(condition);
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
}

    stringBuffer.append(TEXT_29);
    return stringBuffer.toString();
  }
}
