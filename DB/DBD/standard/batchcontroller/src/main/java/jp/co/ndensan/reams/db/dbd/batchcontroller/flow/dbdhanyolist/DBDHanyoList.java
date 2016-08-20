/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdhanyolist;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdhanyolist.DBDHanyoListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author zhangxi
 */
public class DBDHanyoList extends BatchFlowBase<DBDHanyoListParameter> {

    @Override
    protected void defineFlow() {
        if ("汎用リスト_施設入退所".equals(getParameter().getBatchKind().toString())) {
            executeStep("汎用リスト出力_施設入退所");
        }
        if ("汎用リスト_国保".equals(getParameter().getBatchKind().toString())) {
            executeStep("汎用リスト出力_国保");
        }
        if ("汎用リスト_後期高齢者".equals(getParameter().getBatchKind().toString())) {
            executeStep("汎用リスト出力_後期高齢者");
        }
        if ("汎用リスト_事業対象者".equals(getParameter().getBatchKind().toString())) {
            executeStep("汎用リスト出力_事業対象者");
        }
        if ("汎用リスト_利用者負担割合".equals(getParameter().getBatchKind().toString())) {
            executeStep("汎用リスト出力_利用者負担割合");
        }
    }

    @Step("汎用リスト出力_施設入退所")
    protected IBatchFlowCommand callHanyoListShisetsuNyutaishoFlow() {
        return otherBatchFlow(new RString("DBD710150_HanyoListShisetsuNyutaisho"), SubGyomuCode.DBD介護受給, getParameter().getShisetsuNyutaishoBatchParameter()).define();
    }

    @Step("汎用リスト出力_国保")
    protected IBatchFlowCommand callHanyoListKokuhoFlow() {
        return otherBatchFlow(new RString("DBD710110_HanyoListKokuho"), SubGyomuCode.DBD介護受給, getParameter().getKokuhoParameter()).define();
    }

    @Step("汎用リスト出力_後期高齢者")
    protected IBatchFlowCommand callHanyoListKokiKoreishaFlow() {
        return otherBatchFlow(new RString("DBD710120_HanyoListKokiKoreisha"), SubGyomuCode.DBD介護受給, getParameter().getKokiKoreishaParameter()).define();
    }

    @Step("汎用リスト出力_事業対象者")
    protected IBatchFlowCommand callHanyoListJigyoTaishoshaFlow() {
        return otherBatchFlow(new RString("DBD710130_HanyoListJigyoTaishosha"), SubGyomuCode.DBD介護受給, getParameter().getJigyoTaishoshaParameter()).define();
    }

    @Step("汎用リスト出力_利用者負担割合")
    protected IBatchFlowCommand callHanyoListRiyoshaFutanWariaiFlow() {
        return otherBatchFlow(new RString("DBD710140_HanyoListRiyoshaFutanwariai"), SubGyomuCode.DBD介護受給, getParameter().getRiyoshaFutanwariaiParameter()).define();
    }
}
