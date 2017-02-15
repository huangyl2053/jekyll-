package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601001.IkenshoJissekiIchiranProcessCSV;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601001.IkenshoJissekiIchiranProcessREPORT;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601001.DBE601001_IkenshoSakuseiJIssekiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成実績集計表のバッチフロークラスです。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public class DBE601001_IkenshoSakuseiJIsseki extends BatchFlowBase<DBE601001_IkenshoSakuseiJIssekiParameter> {

    private static final String IKENSHO_JISSEKI_ICHIRAN_CSV = "ikenshoJissekiIchirancsv";
    private static final String IKENSHO_JISSEKI_ICHIRAN_REPORT = "ikenshoJissekiIchiranreport";
    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    @Override
    protected void defineFlow() {
        if (CSVを出力する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(IKENSHO_JISSEKI_ICHIRAN_CSV);
        } else if (集計表を発行する.equals(getParameter().getSyohyoSyuturyoku())) {
            executeStep(IKENSHO_JISSEKI_ICHIRAN_REPORT);
        }
    }

    /**
     * 要介護認定事業状況CSVデータの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKENSHO_JISSEKI_ICHIRAN_CSV)
    IBatchFlowCommand ikenshoJissekiIchiranCSV() {
        return loopBatch(IkenshoJissekiIchiranProcessCSV.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 要介護認定事業状況REPORTデータの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(IKENSHO_JISSEKI_ICHIRAN_REPORT)
    IBatchFlowCommand ikenshoJissekiIchiranREPORT() {
        return loopBatch(IkenshoJissekiIchiranProcessREPORT.class)
                .arguments(getParameter().toProcessParamter()).define();
    }
}
