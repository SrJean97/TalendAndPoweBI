package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileInputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileInputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelEndJava result = new TFileInputExcelEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL + "                log.error(message_";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "                System.err.println(message_";
  protected final String TEXT_21 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\ttry {" + NL + "\t\t\t\tif(excelReader_";
  protected final String TEXT_23 = "!=null) {" + NL + "\t\t\t\t\texcelReader_";
  protected final String TEXT_24 = ".handleException();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_25 = ") {" + NL + "globalMap.put(\"";
  protected final String TEXT_26 = "_ERROR_MESSAGE\",e_";
  protected final String TEXT_27 = ".getMessage());" + NL + "\t\t\t\tif(!(e_";
  protected final String TEXT_28 = ".getCause() instanceof com.talend.excel.xssf.event.EnoughDataException)) {" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tthrow(e_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_33 = " - \" + e_";
  protected final String TEXT_34 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_36 = ".getMessage());\t" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_40 = "_NB_LINE\",nb_line_";
  protected final String TEXT_41 = ");" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t} finally { " + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\tif(!(source_";
  protected final String TEXT_45 = " instanceof java.io.InputStream)){" + NL + "\t\t\t\t\t\tworkbook_";
  protected final String TEXT_46 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "  \t\t\t\tif(!(source_";
  protected final String TEXT_48 = " instanceof java.io.InputStream)){" + NL + "  \t\t\t\t\tworkbook_";
  protected final String TEXT_49 = ".getPackage().revert();" + NL + "  \t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t}\t" + NL + "\t\t";
  protected final String TEXT_51 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}

        public void logErrorMessage() {
            if(isLog4jEnabled){
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            } else {
            
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
            }
        }
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
	boolean eventMode = "EVENT_MODE".equals(mode);
	
	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_21);
    if(version07 && eventMode) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
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
     if(dieOnError) { 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     } else { 
    stringBuffer.append(TEXT_31);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    log4jFileUtil.retrievedDataNumberInfo(node);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    if((version07 && !eventMode) || !version07) {
    stringBuffer.append(TEXT_42);
    }//Bug TDI-25655
    stringBuffer.append(TEXT_43);
    if(!version07){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    }else if(!eventMode){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    } else {//TODO event mode
				
				}
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    return stringBuffer.toString();
  }
}
