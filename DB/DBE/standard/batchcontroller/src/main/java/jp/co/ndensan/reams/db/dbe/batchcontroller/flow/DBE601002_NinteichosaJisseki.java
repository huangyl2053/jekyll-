/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601002.ChosahyoJissekiIchiranProcessCSV;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601002.ChosahyoJissekiIchiranProcessREPORT;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601002.DBE601002_NinteichosaJissekiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
public class DBE601002_NinteichosaJisseki extends BatchFlowBase<DBE601002_NinteichosaJissekiParameter> {

    private static final String CHOSAHYO_JISSEKI_ICHIRAN_CSV = "chosahyojissekiichirancsv";
    private static final String CHOSAHYO_JISSEKI_ICHIRAN_REPORT = "chosahyojissekiichiranreport";
    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    @Override
    protected void defineFlow() {
        if (CSVを出力する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(CHOSAHYO_JISSEKI_ICHIRAN_CSV);
        } else if (集計表を発行する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(CHOSAHYO_JISSEKI_ICHIRAN_REPORT);
        }
    }

    /**
     * 要介護認定事業状況CSVデータの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(CHOSAHYO_JISSEKI_ICHIRAN_CSV)
    IBatchFlowCommand chosahyojissekiichiranCSV() {
        return loopBatch(ChosahyoJissekiIchiranProcessCSV.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 要介護認定事業状況REPORTデータの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(CHOSAHYO_JISSEKI_ICHIRAN_REPORT)
    IBatchFlowCommand chosahyojissekiichiranREPORT() {
        return loopBatch(ChosahyoJissekiIchiranProcessREPORT.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
