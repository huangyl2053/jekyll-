/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.workflow.flow.task.ITaskDetailManageable;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 *
 * @author N8211 田辺 紘一
 */
public class FukaKoseiTaskDetailManageable implements ITaskDetailManageable {

    @Override
    public RString getDetailString() {

        Map<RString, RString> check = new HashMap<RString, RString>();

        FlowParameters param = FlowParameterAccessor.get();

        RStringBuilder rsb = new RStringBuilder();

        if (param.size() < 2) {
            RString 被保番号 = new RString("被保番号：0000000094");
            RString 氏名 = new RString("氏名：介護　次郎");

            rsb.append(被保番号);
            rsb.append("<br>");
            rsb.append(氏名);

            check.put(new RString("key"), new RString("1"));
            FlowParameterAccessor.merge(check);
        } else {
            RString 被保番号 = new RString("被保番号：0000000108");
            RString 氏名 = new RString("氏名：秋田　よし子");

            rsb.append(被保番号);
            rsb.append("<br>");
            rsb.append(氏名);
        }

        return rsb.toRString();
    }

}
