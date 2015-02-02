/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.helper;

import jp.co.ndensan.reams.db.dbc.business.KokuhorenJohoTorikomiValidator;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiValidationHelper {

    public static ValidationMessageControlPairs validate(CheckBoxList 同月過誤分, CheckBoxList 通常分, IChohyoShutsuryokujunDiv 出力順) {
        // チェックした際にメッセージが返された際に、該当するコントロールを メッセージとコントロールのペアとしてあらかじめ登録する。
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionary(
                new ValidationMessageControlPair(DbzErrorMessages.選択されていない, 通常分, 同月過誤分),
                new ValidationMessageControlPair(DbzErrorMessages.出力順序を指定));

        // ビジネスパッケージクラスなどでコントロールの値チェックを行い、結果メッセージを受け取る
        IValidationMessages messages = (new KokuhorenJohoTorikomiValidator(同月過誤分, 通常分, 出力順.get出力順ID())).validate();
        return dictionary.check(messages);
    }

}
