/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainDivSpec;
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
 * 減免減額認定証・決定通知書個別発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public class GemmenGengakuShoHakkoMainValidationHandler {

    /**
     * 画面に一つ出力チェックボックスを選択しない場合、エラーとする。
     *
     * @param pairs バリデーションコントロール
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力チェックボックス(ValidationMessageControlPairs pairs,
            GemmenGengakuShoHakkoMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoHakkoMainDivSpec.出力対象の選択されていない)
                .thenAdd(NoInputMessages.出力対象の選択されていない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力対象の選択されていない,
                div.getTsuchishoSakuseiKobetsu()).
                build().check(messages));
        return pairs;
    }

    /**
     * 申請情報が存在しない場合、エラーとする。
     *
     * @param pairs バリデーションコントロール
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請情報の存在(ValidationMessageControlPairs pairs,
            GemmenGengakuShoHakkoMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoHakkoMainDivSpec.申請情報の存在しない)
                .thenAdd(NoInputMessages.申請情報の存在).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請情報の存在,
                div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu(), div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu()).
                build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発効日は空の場合、エラーとする。
     *
     * @param pairs バリデーションコントロール
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の必須入力(ValidationMessageControlPairs pairs,
            GemmenGengakuShoHakkoMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoHakkoMainDivSpec.発行日の非空チェック)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、交付日は空の場合、エラーとする。
     *
     * @param pairs バリデーションコントロール
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor交付日の必須入力(ValidationMessageControlPairs pairs,
            GemmenGengakuShoHakkoMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoHakkoMainDivSpec.交付日の非空チェック)
                .thenAdd(NoInputMessages.交付日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.交付日の必須入力,
                div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、文書番号は空の場合、エラーとする。
     *
     * @param pairs バリデーションコントロール
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor文書番号の必須入力(ValidationMessageControlPairs pairs,
            GemmenGengakuShoHakkoMainDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(GemmenGengakuShoHakkoMainDivSpec.文書番号の非空チェック)
                .thenAdd(NoInputMessages.文書番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.文書番号の必須入力,
                div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        出力対象の選択されていない(UrErrorMessages.選択されていない, "出力対象"),
        発行日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "発行日"),
        交付日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "交付日"),
        文書番号の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "文書番号"),
        申請情報の存在(UrErrorMessages.存在しない, "減免減額認定証・決定通知書の情報");
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
