/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4030011;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 障がい者控除対象者認定書一括発行画面のDivControllerです
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public class ShogaishaKoujoTaishoNinteiSho {

    /**
     * 画面初期化
     *
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return ResponseData<ShogaishaKoujoTaishoNinteiShoDiv>
     */
    public ResponseData<ShogaishaKoujoTaishoNinteiShoDiv> onLoad(ShogaishaKoujoTaishoNinteiShoDiv div) {
        ShogaishaKoujoTaishoNinteiShoHandler handler = getHandler(div);
        handler.onLoad();
        RDate rDate = RDate.getNowDate();
        div.getShogaishaKojoNinteishoOutput().getTxtKofuDay().setValue(rDate);
        return ResponseData.of(div).respond();

    }

    /**
     * 「実行」ボタン押下時の処理です。
     *
     * @param div ShogaishaKoujoTaishoNinteiShoDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShogaishaKoujoTaishoNinteiShoDiv> onClick_btnNintei(ShogaishaKoujoTaishoNinteiShoDiv div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor対象年度の必須入力(pairs, div);
        getValidationHandler().validateFor喪失日_終了日が開始日以前(pairs, div);
        getValidationHandler().validateFor決定日_終了日が開始日以前(pairs, div);
        getValidationHandler().validateFor出力順序の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
            }
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            //TODO ShogaishaKojoTaishoshaListParameter parameter = getHandler(div).getParameter();
            return null;
        }
        return ResponseData.of(div).respond();
    }

    private ShogaishaKoujoTaishoNinteiShoHandler getHandler(ShogaishaKoujoTaishoNinteiShoDiv div) {
        return new ShogaishaKoujoTaishoNinteiShoHandler(div);
    }

    private ShogaishaKoujoTaishoNinteiShoValidationHandler getValidationHandler() {
        return new ShogaishaKoujoTaishoNinteiShoValidationHandler();
    }

}
