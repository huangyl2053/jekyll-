/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD204010.TaishoKyufuJissekiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD204010.TokuchiJissekiKanriListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD204010.DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 特別地域加算軽減実績管理リスト作成フロークラスです．
 *
 * @reamsid_L DBD-3880-030 jinge
 */
public class DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriList
        extends BatchFlowBase<DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter> {

    private static final String 給付実績参照キー作成 = "給付実績参照キー作成";

    private static final String 帳票出力情報の取得 = "帳票出力情報の取得";

    @Override
    protected void defineFlow() {
        executeStep(給付実績参照キー作成);
        executeStep(帳票出力情報の取得);
    }

    /**
     * 給付実績参照キー作成です。
     *
     *
     * @return IBatchFlowCommand
     */
    @Step(給付実績参照キー作成)
    protected IBatchFlowCommand taishoKyufuJissekiTokutei() {
        return loopBatch(TaishoKyufuJissekiTokuteiProcess.class)
                .arguments(getParameter().toTaishoKyufuJissekiTokuteiProcessParameter())
                .define();
    }

    /**
     * 帳票出力情報の取得です。
     *
     *
     * @return IBatchFlowCommand
     */
    @Step(帳票出力情報の取得)
    protected IBatchFlowCommand tokuchiJissekiKanriListSakusei() {
        return loopBatch(TokuchiJissekiKanriListSakuseiProcess.class)
                .arguments(getParameter().toTokuchiJissekiKanriListSakuseiProcessParameter())
                .define();
    }

}
