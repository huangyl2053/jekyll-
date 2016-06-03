/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDivSpec;
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
 * 負担限度額認定更新のお知らせ通知書個別発行のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
public class FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler {

    /**
     * 画面に一つ出力チェックボックスを選択しない場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor出力チェックボックス(ValidationMessageControlPairs pairs,
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDivSpec.出力対象の選択されていない)
                .thenAdd(NoInputMessages.出力対象の選択されていない).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.出力対象の選択されていない,
                div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu()).build().check(messages));
        return pairs;
    }

    /**
     * 出力チェックボックスをチェックオンの場合、発行日は空の場合、エラーとする
     *
     * @param pairs バリデーションコントロール
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor発行日の必須入力(ValidationMessageControlPairs pairs,
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDivSpec.発行日の非空チェック)
                .thenAdd(NoInputMessages.発行日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.発行日の必須入力,
                div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().
                getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD()).build().check(messages));
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        出力対象の選択されていない(UrErrorMessages.選択されていない, "出力対象"),
        発行日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "発行日"),
        文書番号の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "文書番号");
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
