package com.lhfs.yyhweb.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class Test {
	
	    public static void main(String[] args) throws Exception {

	        Configuration cfg = new Configuration();
	        //将写好的标签加入，起名叫label
	        cfg.setSharedVariable("label", new LabelDirective());
	        cfg.setDirectoryForTemplateLoading(new File("temp"));
	        cfg.setObjectWrapper(new DefaultObjectWrapper());

	        Template temp = cfg.getTemplate("list.ftl");

	        Map root = new HashMap();
	        root.put("user", "rzy");

	        /* Writer out = new OutputStreamWriter(System.out); */

	        File htmlFile = new File("E:/a.html");
	        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));

	        temp.process(root, out);
	        out.flush();
	    }
}
