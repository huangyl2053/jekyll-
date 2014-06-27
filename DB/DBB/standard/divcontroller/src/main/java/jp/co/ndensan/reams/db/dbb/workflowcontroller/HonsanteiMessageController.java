/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller;

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
 * @author N8211 田辺 紘一
 */
public class HonsanteiMessageController implements IMessageController {

    private final static RString WFPRMKEY1 = new RString("Key1");
    private final static RString WFPRMKEY2 = new RString("Key2");

    @Override
    public List<WakeUpMessage> sendFlowMessage(DeliveredMessages deliveredMessage) { //この引数に、起動元となったメッセージの情報が格納される
        List<WakeUpMessage> messages = new ArrayList<>();

        messages.add(new WakeUpMessage(SubGyomuCode.DBB介護賦課, new FlowId("DBBWF51001"),
                FlowParameters.of(WFPRMKEY1, new RString("Value1"))
                .add(WFPRMKEY2, new RString("Value2"))));

        return messages;
    }
}
