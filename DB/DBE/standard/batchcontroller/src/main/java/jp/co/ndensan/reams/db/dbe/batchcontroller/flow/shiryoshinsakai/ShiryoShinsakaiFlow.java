/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai.ShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会資料一括作成のバッチ処理クラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class ShiryoShinsakaiFlow extends BatchFlowBase<ShiryoShinsakaiBatchParameter> {

    private static final String 事務局_審査会資料一括作成 = "jimuShiryoShinsakaiFlow";
    private static final RString 事務局_審査会資料一括作成ID = new RString("DBE517001_ShinsakaiShiryoJImukyoku");
    private static final String 委員_審査会資料一括作成 = "iinShiryoShinsakaiFlow";
    private static final RString 委員_審査会資料一括作成ID = new RString("DBE517002_ShinsakaiShiryoIin");
    private static final RString 選択 = new RString("1");

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().getChohyoIin_taishoushaFalg())
                || 選択.equals(getParameter().getChohyoIin_tokkiJikouFalg())
                || 選択.equals(getParameter().getChohyoIin_itiziHanteiFalg())
                || 選択.equals(getParameter().getChohyoIin_tokkiJikouHanteiFalg())
                || 選択.equals(getParameter().getChohyoIin_ikenshoFalg())
                || 選択.equals(getParameter().getChohyoIin_sonotaSiryoFalg())
                || 選択.equals(getParameter().getChohyoIin_tuutishoFalg())
                || 選択.equals(getParameter().getChohyoIin_hanteiFalg())) {
            executeStep(委員_審査会資料一括作成);
        }
        if (選択.equals(getParameter().getChoyoJimu_taishoushaFalg())
                || 選択.equals(getParameter().getChoyoJimu_tokkiJikouFalg())
                || 選択.equals(getParameter().getChoyoJimu_itiziHanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_tokkiJikouHanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_ikenshoFalg())
                || 選択.equals(getParameter().getChoyoJimu_sonotaSiryoFalg())
                || 選択.equals(getParameter().getChoyoJimu_gaikyouTokkiFalg())
                || 選択.equals(getParameter().getChoyoJimu_hanteiFalg())
                || 選択.equals(getParameter().getChoyoJimu_gaikyouTokkiIranFalg())) {
            executeStep(事務局_審査会資料一括作成);
        }
    }

    /**
     * 審査会資料一括作成（委員）バッチのです。
     *
     * @return IinShiryoShinsakaiFlow
     */
    @Step(委員_審査会資料一括作成)
    protected IBatchFlowCommand callIinShiryoShinsakaiFlow() {
        return otherBatchFlow(委員_審査会資料一括作成ID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 審査会資料一括作成（事務局）バッチのです。
     *
     * @return JimuShiryoShinsakaiFlow
     */
    @Step(事務局_審査会資料一括作成)
    protected IBatchFlowCommand callJimuShiryoShinsakaiFlow() {
        return otherBatchFlow(事務局_審査会資料一括作成ID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }
}
