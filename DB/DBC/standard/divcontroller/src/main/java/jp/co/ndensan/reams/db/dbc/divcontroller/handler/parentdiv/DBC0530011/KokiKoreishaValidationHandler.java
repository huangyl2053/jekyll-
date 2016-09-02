/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0530011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.KokiKoreishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0530011.KokiKoreishaDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面入力のチェックHandler。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreishaValidationHandler {

    /**
     * 資格期間大小関係チェック
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 資格期間大小関係チェック(ValidationMessageControlPairs pairs, KokiKoreishaDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KokiKoreishaDivSpec.資格期間大小関係チェック)
                .thenAdd(NoInputMessages.資格期間大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.資格期間大小関係チェック, div.getMeisaiPanel().getTxtShikakuShutokuYMD(), div.getMeisaiPanel().
                getTxtShikakuSoshitsuYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 保険者適用期間大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 保険者適用期間大小関係チェック(ValidationMessageControlPairs pairs, KokiKoreishaDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KokiKoreishaDivSpec.保険者適用期間大小関係チェック)
                .thenAdd(NoInputMessages.保険者適用期間大小関係チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.保険者適用期間大小関係チェック, div.getMeisaiPanel().getTxtHokenshaKaishiYMD(), div.getMeisaiPanel().
                getTxtHokenshaShuryoYMD()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        資格期間大小関係チェック(UrErrorMessages.終了日が開始日以前.getMessage()),
        保険者適用期間大小関係チェック(UrErrorMessages.終了日が開始日以前.getMessage());
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
