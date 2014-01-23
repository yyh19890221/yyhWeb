package com.lhfs.yyhweb.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateNumberModel;

public class LabelDirective implements TemplateDirectiveModel {
	
	 @Override
	    public void execute(Environment env, Map params, TemplateModel[] loopVars,
	            TemplateDirectiveBody body) throws TemplateException, IOException {
	        Writer out = env.getOut();
	        
	        //将模版里的数字参数转化成int类型的方法，，其它类型的转换请看freemarker文档
	        TemplateModel paramValue = (TemplateModel) params.get("num");
	        int num = ((TemplateNumberModel) paramValue).getAsNumber().intValue();
	        
	        out.write("Akishimo num=" + params.get("num")+"的类型为:"+paramValue.getClass());
	        if (body != null) {
	            body.render(env.getOut());
	        }else{
	            throw new RuntimeException("标签内部至少要加一个空格");
	        }
	    }

}
