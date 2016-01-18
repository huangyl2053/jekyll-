/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1140011;

import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.definition.batchprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1140011.jukinentotorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1140011.JukinenTotorokuValidationHandler;
import jp.co.ndensan.reams.db.dba.service.jukirendotorokushalist.JukiRendoTorokushaListFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住基連動登録者リスト作成クラスです。
 */
public class jukinentotoroku {

    private final JukiRendoTorokushaListFinder finder;
    private static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBA");
    private static final ReportId 帳票ID = new ReportId("DBA200007");

    /**
     * コンストラクタです。
     */
    public jukinentotoroku() {
        finder = JukiRendoTorokushaListFinder.createInstance();
    }

    /**
     * 住基登録者Divを初期化します。
     *
     * @param div 住基登録者Div
     * @return ResponseData<jukinentotorokuDiv> 住基登録者Div
     */
    public ResponseData<jukinentotorokuDiv> onLoad(jukinentotorokuDiv div) {
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
     * @param div 住基登録者Div
     * @return チェック結果(true/false)
     */
    public ResponseData<jukinentotorokuDiv> onClick_inputCheck(jukinentotorokuDiv div) {
        JukinenTotorokuValidationHandler handler = new JukinenTotorokuValidationHandler(div);
        ValidationMessageControlPairs validPairs = handler.validateForAction(
                div.getBatchParamterInfo().getTxtkonkaikaishi().getValue(),
                div.getBatchParamterInfo().getTxtkonkaishuryo().getValue());
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 住基連動登録者リスト作成
     *
     * @param div バッチパラメータ情報Div
     * @return 住基連動登録者リスト
     */
    public ResponseData<JyukiRendoTorokushaListBatchParameter> onClick_btnAction(BatchParamterInfoDiv div) {
        JyukiRendoTorokushaListBatchParameter parameter = finder.getJukiRendoJouhouParameter(
                div.getTxtzenkaikaishi().getValue(),
                div.getTxtzenkaishuryo().getValue(),
                div.getTxtkonkaikaishi().getValue(),
                div.getTxtkonkaishuryo().getValue(),
                div.getChktaishodaicho().getSelectedKeys(),
                RString.EMPTY);
        return ResponseData.of(parameter).respond();
    }
}
