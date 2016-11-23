/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1150011;

import jp.co.ndensan.reams.db.dba.business.core.nenreitotatsutoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA150010.DBA150010_NenreitotatsuTorokuListParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1150011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1150011.NenreiTotatsuTorokushaListDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1150011.NenreiTotatsuTorokuValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.nenreitotatsutorokushalist.NenreiTotatsushaTorokuListFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢到達登録者リスト作成クラスです。
 *
 * @reamsid_L DBA-0570-010 xuyannan
 */
public class NenreiTotatsuTorokushaList {

    private final NenreiTotatsushaTorokuListFinder finder;

    /**
     * コンストラクタです。
     */
    public NenreiTotatsuTorokushaList() {
        finder = NenreiTotatsushaTorokuListFinder.createInstance();
    }

    /**
     * 年齢到達登録者Divを初期化します。
     *
     * @param div 年齢到達登録者Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv> 年齢到達登録者Div
     */
    public ResponseData<NenreiTotatsuTorokushaListDiv> onLoad(NenreiTotatsuTorokushaListDiv div) {
        FlexibleDate nowDate = new FlexibleDate(RDate.getNowDate().toDateString());
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("BatchRegister"), false);
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
                        .setValue(business.getTaishoShuryoYMD().plusDay(1));
                div.getBatchParamterInfo().getTxtkonkaishuryo()
                        .setValue(business.getTaishoShuryoYMD());

            } else {
                div.getBatchParamterInfo().getTxtzenkaikaishi()
                        .setValue(business.getTaishoKaishiYMD());
                div.getBatchParamterInfo().getTxtzenkaishuryo()
                        .setValue(business.getTaishoShuryoYMD());
                div.getBatchParamterInfo().getTxtkonkaikaishi()
                        .setValue(business.getTaishoShuryoYMD().plusDay(1));
                div.getBatchParamterInfo().getTxtkonkaishuryo()
                        .setValue(nowDate);
            }
        }
        div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200008.getReportId());
        return ResponseData.of(div).respond();
    }

    /**
     * 開始日、終了日によって、チェックを実施する。
     *
     * @param div 年齢到達登録者Div
     * @return ResponseData<NenreiTotatsuTorokushaListDiv>
     */
    public ResponseData<NenreiTotatsuTorokushaListDiv> onClick_inputCheck(NenreiTotatsuTorokushaListDiv div) {
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
     * @return ResponseData<NenreiTotatsuTorokushaListBatchParameter>
     */
    public ResponseData<DBA150010_NenreitotatsuTorokuListParameter> onClick_btnAction(BatchParamterInfoDiv div) {
        DBA150010_NenreitotatsuTorokuListParameter parameter = finder.getNenreiTotatsushaTorokuListBatchParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        return ResponseData.of(parameter).respond();
    }

    private NenreiTotatsuTorokuValidationHandler getValidationHandler(NenreiTotatsuTorokushaListDiv div) {
        return new NenreiTotatsuTorokuValidationHandler(div);
    }
}
