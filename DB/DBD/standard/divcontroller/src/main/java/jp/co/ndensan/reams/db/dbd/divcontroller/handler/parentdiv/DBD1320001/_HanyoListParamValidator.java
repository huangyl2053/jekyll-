/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001.HanyoListParamDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 汎用リスト出力(介護受給共通)の入力チェッククラスです。
 *
 * @reamsid_L DBD-3930-011 liwul
 */
public class _HanyoListParamValidator implements IValidatable {

    private final HanyoListParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい{@link HanyoListParamDiv}
     */
    public _HanyoListParamValidator(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 表題のバリデーション
     *
     * @return バリデーションメッセージ　IValidationMessages
     */
    public IValidationMessages validate表題() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HanyoListParamSpec.帳票出力項目チェック１)
                .thenAdd(HanyoListParamValidationMessage.帳票出力項目チェック１)
                .messages());
        return messages;
    }

    /**
     * 帳票出力項目チェックのバリデーション
     *
     * @return バリデーションメッセージ　IValidationMessages
     */
    public IValidationMessages validate帳票出力項目チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HanyoListParamSpec.帳票出力項目チェック２)
                .thenAdd(HanyoListParamValidationMessage.帳票出力項目チェック２)
                .ifNot(HanyoListParamSpec.帳票出力項目チェック３)
                .thenAdd(HanyoListParamValidationMessage.帳票出力項目チェック３)
                .messages());
        return messages;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(HanyoListParamSpec.実行するボタンクリック1)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック1)
                .ifNot(HanyoListParamSpec.実行するボタンクリック2)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック2)
                .ifNot(HanyoListParamSpec.実行するボタンクリック3)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック3)
                .ifNot(HanyoListParamSpec.実行するボタンクリック5)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック5)
                .ifNot(HanyoListParamSpec.実行するボタンクリック7)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック7)
                .ifNot(HanyoListParamSpec.実行するボタンクリック10)
                .thenAdd(HanyoListParamValidationMessage.実行するボタンクリック10)
                .messages());
        return messages;
    }
}
