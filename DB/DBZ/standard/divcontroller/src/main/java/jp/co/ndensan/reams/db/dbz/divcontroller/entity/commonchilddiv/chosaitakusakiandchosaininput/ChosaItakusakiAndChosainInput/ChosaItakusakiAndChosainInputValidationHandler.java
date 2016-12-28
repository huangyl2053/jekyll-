/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調査委託先＆調査員入力共有子DivのValidationHandlerです。
 */
public class ChosaItakusakiAndChosainInputValidationHandler {

    private final ChosaItakusakiAndChosainInputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link ChosaItakusakiAndChosainInputDiv}
     */
    public ChosaItakusakiAndChosainInputValidationHandler(ChosaItakusakiAndChosainInputDiv div) {
        this.div = div;
    }

    /**
     * 調査委託先コードのバリデーションを実行します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate調査委託先コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ChosaItakusakiAndChosainInputSpec.調査委託先コードに該当するデータが存在すること)
                .thenAdd(ChosaItakusakiAndChosainInputValidationMessages.委託先コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(createDictionary調査委託先コード().check(messages));
        return validResult;
    }

    private ValidationDictionary createDictionary調査委託先コード() {
        return new ValidationDictionaryBuilder()
                .add(ChosaItakusakiAndChosainInputValidationMessages.委託先コードに該当するデータなし,
                        div.getTxtChosaItakusakiCode())
                .build();
    }

    /**
     * 調査員コードのバリデーションを実行します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate調査員コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ChosaItakusakiAndChosainInputSpec.調査員コードに該当するデータが存在すること)
                .thenAdd(ChosaItakusakiAndChosainInputValidationMessages.調査員コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        if(!div.getTxtChosaItakusakiCode().getValue().isEmpty() && !div.getTxtChosaItakusakiName().getValue().isEmpty()){
            validResult.add(createDictionary調査員コード().check(messages));
        }
        return validResult;
    }

    private ValidationDictionary createDictionary調査員コード() {
        return new ValidationDictionaryBuilder()
                .add(ChosaItakusakiAndChosainInputValidationMessages.調査員コードに該当するデータなし,
                        div.getTxtChosainCode())
                .build();
    }
}
