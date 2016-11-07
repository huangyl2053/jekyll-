/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author liuyl
 */
public class DBC2210011MainValidationHandler {

    /**
     * 資格期間大小関係チェック
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 特別給付サービス重複チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.特別給付サービス重複チェック)
                .thenAdd(NoInputMessages.特別給付サービス重複チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特別給付サービス重複チェック, div.getTokubetsuKyufuJigyoshaDetailServiceInfo().getDdlService())
                .build().check(messages));
        return pairs;
    }

    /**
     * 保険者適用期間大小関係チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KoshinShinseishaHaakuListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 登録終了日チェック(ValidationMessageControlPairs pairs, DBC2210011MainDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBC2210011MainDivSpec.登録終了日チェック)
                .thenAdd(NoInputMessages.登録終了日チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.登録終了日チェック, div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuKaishiYMD(), div.getTokubetsuKyufuJigyoshaDetailServiceInfo().
                getTokubetsuKyufuJigyoshaDetailJigyosha().getTxtTorokuShuryoYMD()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        特別給付サービス重複チェック(UrErrorMessages.既に存在.getMessage(), "そのサービス種類"),
        登録終了日チェック(UrErrorMessages.大小関係が不正.getMessage(), "登録終了日");
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
