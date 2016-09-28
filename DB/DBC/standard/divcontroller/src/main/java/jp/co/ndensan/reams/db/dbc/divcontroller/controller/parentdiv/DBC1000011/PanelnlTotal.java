/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1000011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC030010.DBC030010_ShokanShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011.PanelnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000011.PanelnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyu.ShokanbaraiShikyuFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払い支給（不支給）決定通知書一括作成Divを制御します。
 *
 * @reamsid_L DBC-1000-010 zhangzhiming
 */
public class PanelnlTotal {

    /**
     * 償還払い支給（不支給）決定通知書一括作成画面初期化を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onLoad(PanelnlTotalDiv div) {
        ShoriDateKanri shori = ShokanbaraiShikyuFinder.createInstance()
                .select前回対象日(ShoriName.償還払い支給不支給決定通知書一括作成_受付日.get名称());
        ChohyoBunruiKanri chohyo = ShokanbaraiShikyuFinder.createInstance().select帳票分類ID();
        createHandler(div).onLoad(shori, chohyo);
        return ResponseData.of(div).respond();
    }

    /**
     * 決定日一括更新区分を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onChange_koushin(PanelnlTotalDiv div) {
        createHandler(div).onChange_koushin();
        return ResponseData.of(div).respond();
    }

    /**
     * 受付日を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onClick_uketsukebi(PanelnlTotalDiv div) {
        createHandler(div).onClick_uketsukebi();
        return ResponseData.of(div).respond();
    }

    /**
     * 決定日を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onClick_ketteibi(PanelnlTotalDiv div) {
        createHandler(div).onClick_ketteibi();
        return ResponseData.of(div).respond();
    }

    /**
     * 決定者受付年月を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onClick_KetteishaUketsukeYM(PanelnlTotalDiv div) {
        createHandler(div).onClick_KetteishaUketsukeYM();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を処理します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<PanelnlTotalDiv> onClick_btnJikou(PanelnlTotalDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = createHandler(div).validateCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチを起動します。
     *
     * @param div 償還払い支給（不支給）決定通知書一括作成DIV
     * @return ResponseData<PanelnlTotalDiv>
     */
    public ResponseData<DBC030010_ShokanShikyuKetteiTsuchishoParameter> onClick_batch(PanelnlTotalDiv div) {
        DBC030010_ShokanShikyuKetteiTsuchishoParameter parameter = createHandler(div).onClick_btnJikouBatch();
        return ResponseData.of(parameter).respond();
    }

    private PanelnlTotalHandler createHandler(PanelnlTotalDiv div) {
        return new PanelnlTotalHandler(div);
    }
}
