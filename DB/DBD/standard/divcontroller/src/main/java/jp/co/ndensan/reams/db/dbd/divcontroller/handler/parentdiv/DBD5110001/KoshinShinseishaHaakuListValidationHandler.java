/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5110001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.KoshinShinseishaHaakuListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001.KoshinShinseishaHaakuListDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 更新未申請者把握リスト作成画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-1420-010 wangjie2
 */
public class KoshinShinseishaHaakuListValidationHandler {

    /**
     * 認定有効期間_終了月の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定有効期間_終了月の未入力チェック(ValidationMessageControlPairs pairs, KoshinShinseishaHaakuListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinShinseishaHaakuListDivSpec.認定有効期間_終了月の非空チェック)
                .thenAdd(NoInputMessages.認定有効期間_終了月の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認定有効期間_終了月の必須入力, div.getTxtInsatsuDate()).build().check(messages));
        return pairs;
    }

    /**
     * 認定有効期間_終了月_Fromの未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定有効期間_終了月_Fromの未入力チェック(ValidationMessageControlPairs pairs, KoshinShinseishaHaakuListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinShinseishaHaakuListDivSpec.認定有効期間_終了月_Fromの非空チェック)
                .thenAdd(NoInputMessages.認定有効期間_終了月_Fromの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認定有効期間_終了月_Fromの必須入力, div.getTxtInsatsuDateFrom()).build().check(messages));
        return pairs;
    }

    /**
     * 認定有効期間_終了月_Toの未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 認定有効期間_終了月_Toの未入力チェック(ValidationMessageControlPairs pairs, KoshinShinseishaHaakuListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinShinseishaHaakuListDivSpec.認定有効期間_終了月_Toの非空チェック)
                .thenAdd(NoInputMessages.認定有効期間_終了月_Toの必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.認定有効期間_終了月_Toの必須入力, div.getTxtInsatsuDateTo()).build().check(messages));
        return pairs;
    }

    /**
     * 期間大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 期間大小関係チェック(ValidationMessageControlPairs pairs, KoshinShinseishaHaakuListDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KoshinShinseishaHaakuListDivSpec.期間大小関係チェック)
                .thenAdd(NoInputMessages.期間大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.期間大小関係チェック, div.getTxtInsatsuDateTo(), div.getTxtInsatsuDateFrom()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        認定有効期間_終了月の必須入力(UrErrorMessages.必須.getMessage(), "認定有効期間(終了月)"),
        認定有効期間_終了月_Fromの必須入力(UrErrorMessages.必須.getMessage(), "認定有効期間(終了月)From"),
        認定有効期間_終了月_Toの必須入力(UrErrorMessages.必須.getMessage(), "認定有効期間(終了月)To"),
        期間大小関係チェック(UrErrorMessages.期間が不正.getMessage());
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
