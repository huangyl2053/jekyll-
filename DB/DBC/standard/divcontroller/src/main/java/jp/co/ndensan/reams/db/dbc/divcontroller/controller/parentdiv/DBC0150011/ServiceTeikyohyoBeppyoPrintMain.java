/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo.TeikyohyoBeppyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0150011_サービス提供票別表のクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class ServiceTeikyohyoBeppyoPrintMain {

    private static final RString 引数_被保険者番号なし = new RString("被保険者番号なし");

    private ServiceTeikyohyoBeppyoPrintMainHandler getHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return ServiceTeikyohyoBeppyoPrintMainHandler.of(div);
    }

    private ServiceTeikyohyoBeppyoPrintMainValidationHandler getValidationHandler(
            ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return new ServiceTeikyohyoBeppyoPrintMainValidationHandler(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv>
     */
    public ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv> onLoad(ServiceTeikyohyoBeppyoPrintMainDiv div) {

        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = key.get被保険者番号();
        ShikibetsuCode 識別コード = key.get識別コード();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().
                    replace(引数_被保険者番号なし.toString()));
        } else {
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            div.getCccKaigoShiKakuKihon().initialize(被保険者番号);
            div.getTxtSakuseiYmd().setValue(RDate.getNowDate());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下時のイベントです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(ServiceTeikyohyoBeppyoPrintMainDiv div) {

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        TeikyohyoBeppyoManager manager = TeikyohyoBeppyoManager.createInstance();
        return ResponseData.of(getHandler(div).to帳票発行処理(被保険者番号, manager)).respond();
    }

    /**
     * 「発行する」ボタン押下時の入力チェックです。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv>
     */
    public ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv> onClick_btnReportPublishCheck(
            ServiceTeikyohyoBeppyoPrintMainDiv div) {

        ValidationMessageControlPairs valid = getValidationHandler(div).validate();
        if (valid.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(valid).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(
                    UrQuestionMessages.確認_汎用.getMessage().getCode(),
                    UrQuestionMessages.確認_汎用.getMessage().replace("サービス提供票別表を発行して").evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).cancelPublish().respond();
        }
        return ResponseData.of(div).respond();
    }

}
