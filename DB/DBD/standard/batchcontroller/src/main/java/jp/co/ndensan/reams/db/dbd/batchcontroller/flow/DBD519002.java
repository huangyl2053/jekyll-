/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002.ChosainDataCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002.ChosaitakusakiDataCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002.ShujiiDataCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002.ShujiiIryokikanDataCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519002.YokaigoNinteiGaibuDataUpdateProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519002.DBD519002Parameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定関連データ作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
public class DBD519002 extends BatchFlowBase<DBD519002Parameter> {

    private RString iF種類情報;
    private static final RString IF種類情報_電算 = new RString("2");

    private static final String 認定調査委託先情報CSV_電算版_出力 = "chosaitakusakiDataReamsCsv";
    private static final String 認定調査委託先情報CSV_出力 = "chosaitakusakiDataCsv";
    private static final String 認定調査員情報CSV_電算版_出力 = "chosainDataReamsCsv";
    private static final String 認定調査員情報CSV_出力 = "chosainDataCsv";
    private static final String 主治医医療機関情報CSV_電算版_出力 = "shujiiIryokikanDataReamsCsv";
    private static final String 主治医医療機関情報CSV_出力 = "shujiiIryokikanDataCsv";
    private static final String 主治医情報CSV_電算版_出力 = "shujiiReamsDataCsv";
    private static final String 主治医情報CSV_出力 = "shujiiDataCsv";
    private static final String 要介護認定外部データ出力履歴に更新 = "yokaigoNinteiGaibuDataOutputHistoryUpdate";

    @Override
    protected void prepareConfigData() {
        iF種類情報 = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
    }

    @Override
    protected void defineFlow() {
        if (IF種類情報_電算.equals(iF種類情報)) {
            executeStep(認定調査委託先情報CSV_電算版_出力);
            executeStep(認定調査員情報CSV_電算版_出力);
            executeStep(主治医医療機関情報CSV_電算版_出力);
            executeStep(主治医情報CSV_電算版_出力);
        } else {
            executeStep(認定調査委託先情報CSV_出力);
            executeStep(認定調査員情報CSV_出力);
            executeStep(主治医医療機関情報CSV_出力);
            executeStep(主治医情報CSV_出力);
        }
        executeStep(要介護認定外部データ出力履歴に更新);
    }

    /**
     * 認定調査委託先情報CSV_電算版_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査委託先情報CSV_電算版_出力)
    protected IBatchFlowCommand chosaitakusakiDataReamsCsv() {
        return loopBatch(ChosaitakusakiDataCsvProcess.class).arguments(getParameter().toChosaitakusakiReamsProcessParameter()).define();
    }

    /**
     * 認定調査委託先情報CSV_電算版_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査委託先情報CSV_出力)
    protected IBatchFlowCommand chosaitakusakiDataCsv() {
        return loopBatch(ChosaitakusakiDataCsvProcess.class).arguments(getParameter().toChosaitakusakiProcessParameter()).define();
    }

    /**
     * 認定調査員情報CSV_電算版_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査員情報CSV_電算版_出力)
    protected IBatchFlowCommand chosainDataReamsCsv() {
        return loopBatch(ChosainDataCsvProcess.class).arguments(getParameter().toChosainReamsProcessParameter()).define();
    }

    /**
     * 認定調査員情報CSV_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定調査員情報CSV_出力)
    protected IBatchFlowCommand chosainDataCsv() {
        return loopBatch(ChosainDataCsvProcess.class).arguments(getParameter().toChosainProcessParameter()).define();
    }

    /**
     * 主治医医療機関情報CSV_電算版_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医医療機関情報CSV_電算版_出力)
    protected IBatchFlowCommand shujiiIryokikanDataReamsCsv() {
        return loopBatch(ShujiiIryokikanDataCsvProcess.class).arguments(getParameter().toShujiiIryokikanReamsProcessParameter()).define();
    }

    /**
     * 主治医医療機関情報CSV_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医医療機関情報CSV_出力)
    protected IBatchFlowCommand shujiiIryokikanDataCsv() {
        return loopBatch(ShujiiIryokikanDataCsvProcess.class).arguments(getParameter().toShujiiIryokikanProcessParameter()).define();
    }

    /**
     * 主治医情報CSV_電算版_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医情報CSV_電算版_出力)
    protected IBatchFlowCommand shujiiReamsDataCsv() {
        return loopBatch(ShujiiDataCsvProcess.class).arguments(getParameter().toShujiiReamsProcessParameter()).define();
    }

    /**
     * 主治医情報CSV_出力。
     *
     * @return IBatchFlowCommand
     */
    @Step(主治医情報CSV_出力)
    protected IBatchFlowCommand shujiiDataCsv() {
        return loopBatch(ShujiiDataCsvProcess.class).arguments(getParameter().toShujiiProcessParameter()).define();
    }

    /**
     * 要介護認定外部データ出力履歴に更新。
     *
     * @return IBatchFlowCommand
     */
    @Step(要介護認定外部データ出力履歴に更新)
    protected IBatchFlowCommand yokaigoNinteiGaibuDataOutputHistoryUpdateProcess() {
        return loopBatch(YokaigoNinteiGaibuDataUpdateProcess.class).
                arguments(getParameter().toYokaigoNinteiGaibuDataOutputHistoryProcessParameter()).define();
    }

}
