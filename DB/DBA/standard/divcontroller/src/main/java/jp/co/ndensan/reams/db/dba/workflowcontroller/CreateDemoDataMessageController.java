/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.workflowcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.DeliveredMessages;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.IMessageController;
import jp.co.ndensan.reams.uz.uza.workflow.flow.messaging.WakeUpMessage;
import jp.co.ndensan.reams.uz.uza.workflow.flow.valueobject.FlowId;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 *
 * @author n8178 城間篤人
 */
public class CreateDemoDataMessageController implements IMessageController {

    private final static RString WFPRMKEY1 = new RString("Key1");
    private final static RString WFPRMKEY2 = new RString("Key2");

    @Override
    public List<WakeUpMessage> sendFlowMessage(DeliveredMessages deliveredMessage) {
        List<WakeUpMessage> messages = new ArrayList<>();

        messages.add(new WakeUpMessage(SubGyomuCode.DBA介護資格, new FlowId("DBAWF2500T"),
                FlowParameters.of(WFPRMKEY1, new RString("Value1"))
                .add(WFPRMKEY2, new RString("Value2"))));

        messages.add(new WakeUpMessage(SubGyomuCode.DBA介護資格, new FlowId("DBAWF3100T"),
                FlowParameters.of(WFPRMKEY1, new RString("Value3"))
                .add(WFPRMKEY2, new RString("Value4"))));

        return messages;
    }
}
