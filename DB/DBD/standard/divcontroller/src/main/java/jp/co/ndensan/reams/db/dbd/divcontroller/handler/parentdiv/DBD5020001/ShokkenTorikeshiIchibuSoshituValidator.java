/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 要介護認定処理画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public class ShokkenTorikeshiIchibuSoshituValidator implements IValidatable {

    private final ShokkenTorikeshiIchibuSoshituDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     */
    public ShokkenTorikeshiIchibuSoshituValidator(ShokkenTorikeshiIchibuSoshituDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.申請日が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.申請日が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.認定日が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.認定日が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.喪失日が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.喪失日が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.要介護度が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.要介護度が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.有効開始日が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.有効開始日が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.有効終了日が未入力チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.有効終了日が未入力)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.有効開始日と有効終了日の関連チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.有効開始日と有効終了日の関連チェック)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.前回有効終了日と今回有効開始日の関連チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.前回有効終了日と今回有効開始日の関連チェック)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.新予防給付適用の60日前のみなし更新チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.新予防給付適用の60日前のみなし更新チェック)
                .messages());
        return messages;
    }

    /**
     * 履歴番号チェックします。
     *
     * @return 履歴番号チェック結果
     */
    public IValidationMessages validate履歴番号() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShokkenTorikeshiIchibuSoshituSpec.受給申請中かの確認チェック)
                .thenAdd(ShokkenTorikeshiIchibuSoshituValidationMessage.受給申請中かの確認チェック)
                .messages());
        return messages;
    }

}
