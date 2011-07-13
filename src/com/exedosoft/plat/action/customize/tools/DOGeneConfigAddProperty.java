package com.exedosoft.plat.action.customize.tools;

import com.exedosoft.plat.ExedoException;
import com.exedosoft.plat.action.DOAbstractAction;
import com.exedosoft.plat.bo.BOInstance;
import com.exedosoft.plat.bo.DOBO;
import com.exedosoft.plat.gene.jquery.PropertyManager;

public class DOGeneConfigAddProperty extends DOAbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4555077593344493040L;

	@Override
	public String excute() throws ExedoException {
		
		DOBO bo = DOBO.getDOBOByName("do_bo");
		BOInstance instance = bo.getCorrInstance();
		if(instance==null){
			this.setEchoValue("没有数据!");
			return NO_FORWARD;
		}
		
		String colName =  this.actionForm.getValue("col_name");
		String type = this.actionForm.getValue("dbtype");
		String dbsize = this.actionForm.getValue("dbsize");
		
		if(colName==null || type ==null || dbsize==null){
			this.setEchoValue("字段名称或者类型或者长度没有定义!");
			return NO_FORWARD;
		}

		
		DOBO thisBO = DOBO.getDOBOByID(instance.getUid());
		
		PropertyManager pm = new PropertyManager();
		pm.addProperty(thisBO, colName,Integer.parseInt( type ),Integer.parseInt(dbsize));
		
		////处理租户表字段
		////处理后根据表地段创建View
		
		///修改View
		

		

		return DEFAULT_FORWARD;
	}

}