/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1140011;

import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA140010.DBA140010_JukiRendoTorokushaListParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.DBA1140011TransitionEventName;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.JukiNendoTorokushaListDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1140011.JukinenTotorokuValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.jukirendotorokushalist.JukiRendoTorokushaListFinder;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住基連動登録者リスト作成クラスです。
 *
 * @reamsid_L DBA-0560-010 xuyannan
 */
public class JukiNendoTorokushaList {

    private final JukiRendoTorokushaListFinder finder;
    // TODO 帳票出力順の初期化(技術点に提出しました※QA#73393)
//    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBA");
//    private static final ReportId 帳票ID = new ReportId("DBA200007_JukiRendoTorokuList");

    /**
     * コンストラクタです。
     */
    public JukiNendoTorokushaList() {
        finder = JukiRendoTorokushaListFinder.createInstance();
    }

    /**
     * 住基登録者Divを初期化します。
     *
     * @param div 住基登録者Div
     * @return ResponseData<JukiNendoTorokushaListDiv> 住基登録者Div
     */
    public ResponseData<JukiNendoTorokushaListDiv> onLoad(JukiNendoTorokushaListDiv div) {
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
        div.getBatchParamterInfo().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200007.getReportId());
        return ResponseData.of(div).respond();
    }

    /**
     * 開始日、終了日によって、チェックを実施する。
     *
     * @param div 住基登録者Div
     * @return チェック結果(true/false)
     */
    public ResponseData<JukiNendoTorokushaListDiv> onClick_inputCheck(JukiNendoTorokushaListDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForAction();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住基連動登録者リスト作成。
     *
     * @param div バッチパラメータ情報Div
     * @return 住基連動登録者リスト
     */
    public ResponseData<DBA140010_JukiRendoTorokushaListParameter> onClick_btnAction(BatchParamterInfoDiv div) {
        DBA140010_JukiRendoTorokushaListParameter parameter = finder.getJukiRendoTorokushaListBatchParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                div.getChktaishodaicho().getSelectedKeys(),
                div.getCcdChohyoShutsuryokujun().get出力順ID());
        IUrControlData controlData = UrControlDataFactory.createInstance();
        parameter.setLoginUserId(controlData.getLoginInfo().getUserId());
        return ResponseData.of(parameter).forwardWithEventName(DBA1140011TransitionEventName.処理終了).respond();
    }

    private JukinenTotorokuValidationHandler getValidationHandler(JukiNendoTorokushaListDiv div) {
        return new JukinenTotorokuValidationHandler(div);
    }
}
