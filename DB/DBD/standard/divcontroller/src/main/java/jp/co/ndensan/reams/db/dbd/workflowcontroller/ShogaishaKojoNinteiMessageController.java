/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.workflowcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.DeliveredMessages;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.IMessageController;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.WakeUpMessage;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 障害者控除対象者一括認定のメッセージコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class ShogaishaKojoNinteiMessageController implements IMessageController {

    private static final int FLOW_NUM = 3;
    private static final FlowId FLOW_ID = new FlowId("DBDWF41003");
    private static final RString WFPRMKEY1 = new RString("Key1");

    @Override
    public List<WakeUpMessage> sendFlowMessage(DeliveredMessages deliveredMessage) {
        List<WakeUpMessage> messages = new ArrayList<>();

        for (int index = 0; index < FLOW_NUM; index++) {

            RStringBuilder value = new RStringBuilder();
            value.append("value");
            value.append(String.valueOf(index));

            messages.add(new WakeUpMessage(SubGyomuCode.DBD介護受給, FLOW_ID, FlowParameters.of(WFPRMKEY1, value.toRString())));
        }
        return messages;
    }
}
