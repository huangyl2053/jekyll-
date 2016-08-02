/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5610001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.KoshinTaishoshaKanriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001.KoshinTaishoshaKanriDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 更新申請対象者管理リスト作成画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class KoshinTaishoshaKanriValidationHandler {

    /**
     * 対象月の必須入力を行います
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoshaKanriDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象月の必須入力(ValidationMessageControlPairs pairs, KoshinTaishoshaKanriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoshaKanriDivSpec.対象月の非空チェック)
                .thenAdd(NoInputMessages.対象月の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.対象月の必須入力, div.getZenkaiJoho().getTxtTaishoTsuki()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期間_終了月_Fromの未入力チェックを行います
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoshaKanriDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効期間_終了月_Fromの未入力チェック(ValidationMessageControlPairs pairs, KoshinTaishoshaKanriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoshaKanriDivSpec.有効期間_終了日_Fromの非空チェック)
                .thenAdd(NoInputMessages.有効期間_終了月_Fromの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期間_終了月_Fromの必須入力, div.getYukoKikanSelect().getTxtYukokikanSelect()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期間_終了月_Toの未入力チェックを行います
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinTaishoshaKanriDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効期間_終了月_Toの未入力チェック(ValidationMessageControlPairs pairs, KoshinTaishoshaKanriDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinTaishoshaKanriDivSpec.有効期間_終了日_Toの非空チェック)
                .thenAdd(NoInputMessages.有効期間_終了月_Toの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期間_終了月_Toの必須入力, div.getYukoKikanSelect().getTxtYukokikanSelect()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        対象月の必須入力(UrErrorMessages.必須.getMessage(), "認定対象月(対象月)"),
        有効期間_終了月_Fromの必須入力(UrErrorMessages.必須.getMessage(), "認定有効期間(終了日)From"),
        有効期間_終了月_Toの必須入力(UrErrorMessages.必須.getMessage(), "認定有効期間(終了日)To");

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
