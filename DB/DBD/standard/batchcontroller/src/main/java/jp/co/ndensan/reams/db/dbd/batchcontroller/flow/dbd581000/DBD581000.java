/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd581000;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581000.DBD581000Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計表発行のバッチフロークラスです。
 *
 * @reamsid_L DBD-1771-032 chenxin
 */
public class DBD581000 extends BatchFlowBase<DBD581000Parameter> {

    private static final String 実施状況表の発行 = "jissiJyokyohyoHakkou";
    private static final String 受給者数状況表の発行 = "ukeishaJyokyohyoHakkou";
    private static final RString 要介護認定実施状況表 = new RString("要介護認定実施状況表（その月に申請・認定を受けた受給者の統計）");
    private static final RString 要介護認定月別受給者数状況表 = new RString("要介護認定月別受給者認定者数状況表（その月に基準日時点の受給者の統計）");
    private static final RString BATCH_ID_DBD581001 = new RString("DBD581001");
    private static final RString BATCH_ID_DBD582001 = new RString("DBD582001");

    @Override
    protected void defineFlow() {
        if (getParameter().get出力帳票().equals(要介護認定実施状況表)) {
            executeStep(実施状況表の発行);
        }
        if (getParameter().get出力帳票().equals(要介護認定月別受給者数状況表)) {
            executeStep(受給者数状況表の発行);
        }
    }

    /**
     * 実施状況表の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(実施状況表の発行)
    protected IBatchFlowCommand jissiJyokyohyoHakkou() {
        return otherBatchFlow(BATCH_ID_DBD581001, SubGyomuCode.DBD介護受給, getParameter().toDBD581001Parameter()).define();
    }

    /**
     * 受給者数状況表の発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(受給者数状況表の発行)
    protected IBatchFlowCommand ukeishaJyokyohyoHakkou() {
        return otherBatchFlow(BATCH_ID_DBD582001, SubGyomuCode.DBD介護受給, getParameter().toDBD582001Parameter()).define();
    }

}
