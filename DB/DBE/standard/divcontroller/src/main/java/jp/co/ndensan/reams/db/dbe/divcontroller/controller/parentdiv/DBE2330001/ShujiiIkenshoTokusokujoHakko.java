/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2330001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.Dbe233001FlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.DBE2330001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.ShujiiIkenshoTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 主治医意見書督促状発行のコントローラです。
 *
 */
public class ShujiiIkenshoTokusokujoHakko {

    private static final RString RADIOBUTTONKEY1 = new RString("key1");

    /**
     * 初期化の設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onLoad(ShujiiIkenshoTokusokujoHakkoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷書類区分の設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onChange_radChohyo(ShujiiIkenshoTokusokujoHakkoDiv div) {
        getHandler(div).onChange_radChohyo();
        return ResponseData.of(div).respond();
    }

    private ShujiiIkenTokusokujoHakkoHandler getHandler(ShujiiIkenshoTokusokujoHakkoDiv div) {
        return new ShujiiIkenTokusokujoHakkoHandler(div);
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> beforeHakkou(ShujiiIkenshoTokusokujoHakkoDiv div) {
        RDate 開始日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue();
        RDate 終了日 = div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue() == null
                ? RDate.MIN : div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue();
        if (終了日.isBefore(開始日)) {
            throw new ApplicationException(UrErrorMessages.終了日が開始日以前.getMessage());
        }
        if (RADIOBUTTONKEY1.equals(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey())
                && div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.未指定.getMessage().replace("主治医意見書督促状対象者一覧の印刷書類を"));
        }
        int 該当データ件数 = getHandler(div).該当データ件数取得(getHandler(div).getTempData());
        if (該当データ件数 > 0) {
            return ResponseData.of(div).respond();
        } else {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
    }

    /**
     * バッチパラメータの設定します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<Dbe233001FlowParameter> hakkou(ShujiiIkenshoTokusokujoHakkoDiv div) {
        Dbe233001FlowParameter parameter = new Dbe233001FlowParameter();
        ShujiiIkenTokusokujoHakkoTempData tempData = getHandler(div).getTempData();
        parameter.toDBE233001Parameter(tempData);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 戻るボタンが押下します。
     *
     * @param div ShujiiIkenshoTokusokujoHakkoDiv
     * @return ResponseData<ShujiiIkenTokusokujoHakkoDiv>
     */
    public ResponseData<ShujiiIkenshoTokusokujoHakkoDiv> onClick_btnBack(ShujiiIkenshoTokusokujoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBE2330001TransitionEventName.処理完了).respond();
        }
        return ResponseData.of(div).respond();
    }
}
