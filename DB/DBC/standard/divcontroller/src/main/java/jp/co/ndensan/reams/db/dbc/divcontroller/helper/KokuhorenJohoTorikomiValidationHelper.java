/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.helper;

import jp.co.ndensan.reams.db.dbc.business.core.KokuhorenJohoTorikomiValidator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author N2810 久保 里史
 */
public final class KokuhorenJohoTorikomiValidationHelper {

    /**
     * validateメソッドです。
     *
     * @param 同月過誤分 同月過誤分
     * @param 通常分 通常分
     * @param 出力順 出力順
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate(CheckBoxList 同月過誤分, CheckBoxList 通常分, IChohyoShutsuryokujunDiv 出力順) {
        // チェックした際にメッセージが返された際に、該当するコントロールを メッセージとコントロールのペアとしてあらかじめ登録する。
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(KokuhorenJohoTorikomiValiationMessage.選択されていない, 通常分, 同月過誤分)
                .add(KokuhorenJohoTorikomiValiationMessage.出力順序を指定)
                .build();

        // ビジネスパッケージクラスなどでコントロールの値チェックを行い、結果メッセージを受け取る
        IValidationMessages messages = (new KokuhorenJohoTorikomiValidator(同月過誤分, 通常分, 出力順.get出力順ID())).validate();
        return dictionary.check(messages);
    }

    private KokuhorenJohoTorikomiValidationHelper() {

    }

    private static enum KokuhorenJohoTorikomiValiationMessage implements IValidationMessage {

        選択されていない(UrErrorMessages.選択されていない),
        出力順序を指定(UrErrorMessages.出力順序を指定);
        private final Message message;

        private KokuhorenJohoTorikomiValiationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        @Override
        public Message getMessage() {
            return this.message;
        }
    }
}
