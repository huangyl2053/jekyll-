/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2020004;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.KyufugakuGengakuKanriListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020004.KyufugakuGengakuKanriListDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 給付額減額管理リストのバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3800-010 b_zhengs
 */
public class KyufugakuGengakuKanriListValidationHandler {

    /**
     * 基準日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufugakuGengakuKanriListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor基準日の必須入力(ValidationMessageControlPairs pairs, KyufugakuGengakuKanriListDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KyufugakuGengakuKanriListDivSpec.基準日の非空チェック)
                .thenAdd(NoInputMessages.基準日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.基準日の必須入力, div.getChushutuJoken().getTxtKijunDate()).build().check(messages));
        return pairs;
    }

    /**
     * 減額終了日抽出_終了日が開始日以前のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div KyufugakuGengakuKanriListDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor減額終了日抽出_終了日が開始日以前(ValidationMessageControlPairs pairs,
            KyufugakuGengakuKanriListDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KyufugakuGengakuKanriListDivSpec.減額終了日抽出_終了日が開始日以前のチェック)
                .thenAdd(NoInputMessages.減額終了日抽出_終了日が開始日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減額終了日抽出_終了日が開始日以前, div.getTxtGengakuShuryoRange()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        基準日の必須入力(UrErrorMessages.必須, "基準日"),
        減額終了日抽出_終了日が開始日以前(UrErrorMessages.期間が不正);

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
