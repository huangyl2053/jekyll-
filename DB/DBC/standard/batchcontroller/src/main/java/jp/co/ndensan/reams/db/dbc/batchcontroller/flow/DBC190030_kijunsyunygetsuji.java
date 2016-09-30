/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.InsSetaiyinShotokuJyohoTemp1Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.InsSetaiyinShotokuJyohoTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030.UpdSetaiyinShotokuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC190030.DBC190030_KijunsyunygetsujiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のフロークラスです。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
public class DBC190030_kijunsyunygetsuji extends BatchFlowBase<DBC190030_KijunsyunygetsujiParameter> {

    private static final RString 世帯員把握BATCHID = new RString("DBB002001_SetaiinHaaku");
    private static final RString 管理識別区分 = SetaiinHaakuKanriShikibetsuKubun.高額介護.getコード();
    private static final String 世帯員把握バッチ = "setaiShotokuKazeiHanteiFlow";
    private static final String INS世帯員所得情報一時表1 = "insSetaiyinShotokuJyohoTemp1Process";
    private static final String INS世帯員所得情報一時表2 = "insSetaiyinShotokuJyohoTemp2Process";
    private static final String UPD世帯員所得情報一時表 = "updSetaiyinShotokuJyohoTempProcess";

    @Override
    protected void defineFlow() {
//バッチパラメータ．抽出条件＝白紙印刷の場合、対象世帯員クラス①作成処理は行わない
        if (!ShinseishoHakkoChushutsuJoken.白紙印刷.getコード().equals(getParameter().get抽出条件())) {
//BatchStep 1
            executeStep(INS世帯員所得情報一時表1);
//BatchStep 2
            executeStep(世帯員把握バッチ);
//BatchStep 3
            executeStep(UPD世帯員所得情報一時表);
//TODO BatchStep 4.1 4.2 BatchStep5~8

//BatchStep9
            executeStep(INS世帯員所得情報一時表2);
//BatchStep 10
            executeStep(世帯員把握バッチ);
//BatchStep 11
            executeStep(UPD世帯員所得情報一時表);
//TODO BatchStep 4.1 4.2 BatchStep12 13...
        }
    }

    @Step(INS世帯員所得情報一時表1)
    IBatchFlowCommand insSetaiyinShotokuJyohoTemp1Process() {
        return loopBatch(InsSetaiyinShotokuJyohoTemp1Process.class).
                arguments(getParameter().toDBC190030ProcessParameter()).define();
    }

    @Step(世帯員把握バッチ)
    IBatchFlowCommand setaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(世帯員把握BATCHID, SubGyomuCode.DBZ介護共通,
                new DBB002001_SetaiinHaakuParameter(管理識別区分)).define();
    }

    @Step(UPD世帯員所得情報一時表)
    IBatchFlowCommand updSetaiyinShotokuJyohoTempProcess() {
        return simpleBatch(UpdSetaiyinShotokuJyohoTempProcess.class).define();
    }

    @Step(INS世帯員所得情報一時表2)
    IBatchFlowCommand insSetaiyinShotokuJyohoTemp2Process() {
        return loopBatch(InsSetaiyinShotokuJyohoTemp2Process.class).
                arguments(getParameter().toDBC190030ProcessParameter()).define();
    }

}
