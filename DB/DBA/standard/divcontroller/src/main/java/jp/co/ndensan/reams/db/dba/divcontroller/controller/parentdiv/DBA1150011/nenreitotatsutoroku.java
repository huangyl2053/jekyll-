/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1150011;

import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1150011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1150011.nenreitotatsutorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1150011.NenreiTotatsuTorokuValidationHandler;
import jp.co.ndensan.reams.db.dba.service.nenreitotatsutorokushalist.NenreiTotatsushaTorokuListFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢到達登録者リスト作成クラスです。
 */
public class nenreitotatsutoroku {

    private final NenreiTotatsushaTorokuListFinder finder;
    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBA");
    private static final ReportId 帳票ID = new ReportId("DBA200008");

    /**
     * コンストラクタです。
     */
    public nenreitotatsutoroku() {
        finder = NenreiTotatsushaTorokuListFinder.createInstance();
    }

    /**
     * 年齢到達登録者Divを初期化します。
     *
     * @param div 年齢到達登録者Div
     * @return ResponseData<nenreitotatsutorokuDiv> 年齢到達登録者Div
     */
    public ResponseData<nenreitotatsutorokuDiv> onLoad(nenreitotatsutorokuDiv div) {
        FlexibleDate nowDate = new FlexibleDate(RDate.getNowDate().toDateString());
        DbT7022ShoriDateKanriBusiness business = finder.getKaishiShuryobi();
        if (business == null || (business.getTaishoKaishiYMD() == null
                && business.getTaishoShuryoYMD() == null)) {
            div.getBatchParamterInfo().getTxtkonkaikaishi().setValue(nowDate);
            div.getBatchParamterInfo().getTxtkonkaishuryo().setValue(nowDate);

        } else {
            if (nowDate.isBeforeOrEquals(business.getTaishoShuryoYMD())) {
                div.getBatchParamterInfo().getTxtzenkaikaishi()
                        .setValue(business.getTaishoKaishiYMD());
                div.getBatchParamterInfo().getTxtzenkaishuryo()
                        .setValue(business.getTaishoShuryoYMD());
                div.getBatchParamterInfo().getTxtkonkaikaishi()
                        .setValue(business.getTaishoShuryoYMD());
                div.getBatchParamterInfo().getTxtkonkaishuryo()
                        .setValue(business.getTaishoShuryoYMD());

            } else if (nowDate.isAfter(business.getTaishoShuryoYMD())) {
                div.getBatchParamterInfo().getTxtzenkaikaishi()
                        .setValue(business.getTaishoKaishiYMD());
                div.getBatchParamterInfo().getTxtzenkaishuryo()
                        .setValue(business.getTaishoShuryoYMD());
                div.getBatchParamterInfo().getTxtkonkaikaishi()
                        .setValue(business.getTaishoShuryoYMD());
                div.getBatchParamterInfo().getTxtkonkaishuryo()
                        .setValue(nowDate);
            }
        }
        // TODO 帳票出力順の初期化(技術点に提出しました※QA#73393)
//        loadChohyoMode(サブ業務コード, 帳票ID);
        return ResponseData.of(div).respond();
    }

    /**
     * 開始日、終了日によって、チェックを実施する。
     *
     * @param div 年齢到達登録者Div
     * @return チェック結果(true/false)
     */
    public ResponseData<nenreitotatsutorokuDiv> onClick_inputCheck(nenreitotatsutorokuDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 年齢到達登録者リスト作成。
     *
     * @param div バッチパラメータ情報Div
     * @return 年齢到達登録者リスト
     */
    public ResponseData<NenreiTotatsuTorokushaListBatchParameter> onClick_btnAction(BatchParamterInfoDiv div) {
        NenreiTotatsuTorokushaListBatchParameter parameter = finder.getNenreiTotatsushaTorokuListBatchParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                RString.EMPTY);
        return ResponseData.of(parameter).respond();
    }

    private NenreiTotatsuTorokuValidationHandler getValidationHandler(nenreitotatsutorokuDiv div) {
        return new NenreiTotatsuTorokuValidationHandler(div);
    }
}
