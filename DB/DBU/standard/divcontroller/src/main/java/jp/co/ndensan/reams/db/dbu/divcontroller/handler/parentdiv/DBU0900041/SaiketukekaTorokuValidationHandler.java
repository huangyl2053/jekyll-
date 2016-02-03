/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900041;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.SaiketukekaTorokuDivSpec;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900041.SaiketukekaTorokuPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査請求書登録_登録画面のバリデーションハンドラークラスです。
 */
public class SaiketukekaTorokuValidationHandler {

    /**
     * 保存するボタンを押下するとき、完了メッセージを行う。
     *
     * @param pairs バリデーションコントロール
     * @param div SaiketukekaTorokuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明書作成日の必須入力(ValidationMessageControlPairs pairs, SaiketukekaTorokuPanelDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(SaiketukekaTorokuDivSpec.弁明書作成日の空チェック)
                .thenAdd(SaiketukekaTorokuValidationHandler.NoInputMessages.弁明書作成日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                SaiketukekaTorokuValidationHandler.NoInputMessages.弁明書作成日の必須入力,
                div.getSaiketukekaMeisaiPanel().getTxtDateBenmeisyoSakuseibi()).build().check(messages));

        return pairs;
    }

    /**
     * 調査員情報登録エリアの編集チェック処理です。
     *
     * @param 修正後の値 修正後の値
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean 修正_変更有無チェック(RString 修正後の値) {
        修正後の値 = 修正後の値 == null ? RString.EMPTY : 修正後の値;
        RString 修正前の値 = ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class) == null
                ? RString.EMPTY : ViewStateHolder.get(SaiketukekaTorokuPanelHandler.Dbu900041Keys.修正前の値, RString.class);
        return !修正後の値.toString().equals(修正前の値.toString());
    }

    private static enum NoInputMessages implements IValidationMessage {

        弁明書作成日の必須入力(UrErrorMessages.必須, "弁明書作成日");
        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
