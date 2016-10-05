/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 新総合事業・事業対象者登録画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-4900-010 wangjie2
 */
public class SogoJigyoTaishoshaTorokuValidationHandler {

    /**
     * 開始日と終了日の前後順チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div SogoJigyoTaishoshaTorokuDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 開始日と終了日の前後順チェック(
            ValidationMessageControlPairs pairs, SogoJigyoTaishoshaTorokuDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SogoJigyoTaishoshaTorokuSpec.開始日と終了日の前後順チェック)
                .thenAdd(NoInputMessages.開始日と終了日の前後順チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.開始日と終了日の前後順チェック, div.getSougouZigyouTaishouShousai().getTxtymfromto())
                .build().check(messages));
        return pairs;
    }

    /**
     * 適用期間重複チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div SogoJigyoTaishoshaTorokuDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 適用期間重複チェック(
            ValidationMessageControlPairs pairs, SogoJigyoTaishoshaTorokuDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SogoJigyoTaishoshaTorokuSpec.適用期間重複チェック)
                .thenAdd(NoInputMessages.適用期間重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.適用期間重複チェック, div.getSougouZigyouTaishouShousai().getTxtymfromto())
                .build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        開始日と終了日の前後順チェック(UrErrorMessages.終了日が開始日以前.getMessage()),
        適用期間重複チェック(UrErrorMessages.期間が重複.getMessage());
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
