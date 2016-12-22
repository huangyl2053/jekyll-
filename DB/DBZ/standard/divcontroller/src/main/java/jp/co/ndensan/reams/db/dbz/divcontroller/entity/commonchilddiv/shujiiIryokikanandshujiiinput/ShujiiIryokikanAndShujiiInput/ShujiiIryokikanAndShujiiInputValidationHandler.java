/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医医療機関＆主治医入力共有子DivのValidationHandlerです。
 */
public class ShujiiIryokikanAndShujiiInputValidationHandler {

    private final ShujiiIryokikanAndShujiiInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link ShujiiIryokikanAndShujiiInputDiv}
     */
    public ShujiiIryokikanAndShujiiInputValidationHandler(ShujiiIryokikanAndShujiiInputDiv div) {
        this.div = div;
    }

    /**
     * 医療機関コードのバリデーションを実行します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate医療機関コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShujiiIryokikanAndShujiiInputSpec.医療機関コードに該当するデータが存在すること)
                .thenAdd(ShujiiIryokikanAndShujiiInputValidationMessages.医療機関コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(createDictionary医療機関コード().check(messages));
        return validResult;
    }

    private ValidationDictionary createDictionary医療機関コード() {
        return new ValidationDictionaryBuilder()
                .add(ShujiiIryokikanAndShujiiInputValidationMessages.医療機関コードに該当するデータなし,
                        div.getTxtIryoKikanCode())
                .build();
    }

    public ValidationMessageControlPairs validate主治医コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShujiiIryokikanAndShujiiInputSpec.主治医コードに該当するデータが存在すること)
                .thenAdd(ShujiiIryokikanAndShujiiInputValidationMessages.主治医コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(createDictionary主治医コード().check(messages));
        return validResult;
    }

    private ValidationDictionary createDictionary主治医コード() {
        return new ValidationDictionaryBuilder()
                .add(ShujiiIryokikanAndShujiiInputValidationMessages.主治医コードに該当するデータなし,
                        div.getTxtShujiiCode())
                .build();
    }
}
