/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ikenshoShujiiIchiran;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ikenshoShujiiIchiran.IkenshoShujiiIchiranProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshoshujiiichiran.IkenshoShujiiIchiranParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療機関・主治医一覧表_バッチフロークラスです
 */
public class IkenshoShujiiIchiranFlow extends BatchFlowBase<IkenshoShujiiIchiranParameter> {

    @Override
    protected void defineFlow() {
        executeStep(REPORT_PROCESS);
    }

    private static final String REPORT_PROCESS = "reportProcess"; //@Stepの定数はメソッドの近くに置くと見やすくていい。

    @Step(REPORT_PROCESS)
    private IBatchFlowCommand reportProcess() {
        return loopBatch(IkenshoShujiiIchiranProcess.class)
                .arguments(createProcessParameter())
                .define();
    }
    
    private Map<RString, Object> createProcessParameter() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(new RString("parameterClass"), getParameter().to主治医一覧情報プロセスparameter());
        return processParameter;
    }
}
