/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA1120011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jukinentotoroku.DbT7022ShoriDateKanriBusiness;
import jp.co.ndensan.reams.db.dba.business.core.nenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListBatchParameterSakusei;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA120010.DBA120010_NenreitotatsuYoteishaListParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1120011.NenreiToutatuYoteishaCheckListDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1120011.NenreiToutatuYoteishaCheckListValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.nenreitoutatuyoteishachecklist.NenreiToutatuYoteishaCheckListManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 年齢到達予定者チェックリストのクラス。
 *
 * @reamsid_L DBA-0580-010 yaodongsheng
 */
public class NenreiToutatuYoteishaCheckList {

    private static final RString 出力対象_登録対象者 = new RString("key0");
    private static final RString 住民種別_全て = new RString("key0");

    /**
     * 年齢到達予定者チェックリストの初期化。<br/>
     *
     * @param requestDiv NenreiToutatuYoteishaCheckListDiv
     * @return ResponseData<NenreiToutatuYoteishaCheckListDiv>
     */
    public ResponseData<NenreiToutatuYoteishaCheckListDiv> onLoad(NenreiToutatuYoteishaCheckListDiv requestDiv) {
        ResponseData<NenreiToutatuYoteishaCheckListDiv> responseData = new ResponseData<>();
        NenreiToutatuYoteishaCheckListManager nenreiToutatuYoteishaManager
                = InstanceProvider.create(NenreiToutatuYoteishaCheckListManager.class);
        DbT7022ShoriDateKanriBusiness shoriDateKanri = nenreiToutatuYoteishaManager.get開始終了日();
        requestDiv.getRadShutsuRyokuTaisho().setSelectedKey(出力対象_登録対象者);
        requestDiv.getRadJunminShubetsu().setSelectedKey(住民種別_全て);
        if (shoriDateKanri != null) {
            requestDiv.getTxtZenkaiRange().setFromValue(new RDate(
                    shoriDateKanri.getTaishoKaishiYMD().wareki().toDateString().toString()));
            requestDiv.getTxtZenkaiRange().setToValue(new RDate(
                    shoriDateKanri.getTaishoShuryoYMD().wareki().toDateString().toString()));
            requestDiv.getTxtKonkaiRange().setFromValue(new RDate(
                    shoriDateKanri.getTaishoShuryoYMD().plusDay(1).wareki().toDateString().toString()));
            requestDiv.getTxtKonkaiRange().clearToValue();
        }
        requestDiv.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200001.getReportId());
        // TODO QA323
//        ReportId chohyoBunruiID = requestDiv.get帳票分類ID(SubGyomuCode.DBA介護資格, new ReportId("DBA200001"));
//        KaigoChohyoShutsuryokujunDiv kaigoChohyoShutsuryokujunDiv = new KaigoChohyoShutsuryokujunDiv();
//        kaigoChohyoShutsuryokujunDiv.loadChohyoMode(サブ業務コード, chohyoBunruiID);
        responseData.data = requestDiv;
        return responseData;
    }

    /**
     * 年齢到達予定者チェックリスト実施前のCheck。<br/>
     *
     * @param requestDiv NenreiToutatuYoteishaCheckListDiv
     * @return ResponseData<INenreiToutatsuYoteishaCheckListBatchParameter>
     */
    public ResponseData<NenreiToutatuYoteishaCheckListDiv> onClick_btnCheck(NenreiToutatuYoteishaCheckListDiv requestDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(requestDiv).checkShuryoToValueInput());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 年齢到達予定者チェックリストの実施button。<br/>
     *
     * @param requestDiv NenreiToutatuYoteishaCheckListDiv
     * @return ResponseData<INenreiToutatsuYoteishaCheckListBatchParameter>
     */
    public ResponseData<DBA120010_NenreitotatsuYoteishaListParameter> onClick_btnBatchRegister(
            NenreiToutatuYoteishaCheckListDiv requestDiv) {
        NenreiToutatsuYoteishaCheckListBatchParameterSakusei batchParameterSakusei
                = new NenreiToutatsuYoteishaCheckListBatchParameterSakusei();
        RString 出力対象 = requestDiv.getRadShutsuRyokuTaisho().getSelectedKey();
        RString 住民種別 = requestDiv.getRadJunminShubetsu().getSelectedKey();
        FlexibleDate 今回開始日 = new FlexibleDate(requestDiv.getTxtKonkaiRange().getFromValue().toDateString());
        FlexibleDate 今回終了日 = new FlexibleDate(requestDiv.getTxtKonkaiRange().getToValue().toDateString());
        List<RString> 編集方法 = requestDiv.getChkHenshuHoho().getSelectedKeys();
        // TODO 帳票出力順の実装方式は不明です。
        Long 出力順ID = requestDiv.getCcdChohyoShutsuryokujun().get出力順ID();
        DBA120010_NenreitotatsuYoteishaListParameter parameter
                = batchParameterSakusei.getNenreiToutatsuYoteishaCheckListBatchParameter(
                        出力対象, 住民種別, 今回開始日, 今回終了日, 編集方法, 出力順ID);
        return ResponseData.of(parameter).respond();

    }

    private NenreiToutatuYoteishaCheckListValidationHandler getValidationHandler(NenreiToutatuYoteishaCheckListDiv div) {
        return new NenreiToutatuYoteishaCheckListValidationHandler(div);
    }
}
