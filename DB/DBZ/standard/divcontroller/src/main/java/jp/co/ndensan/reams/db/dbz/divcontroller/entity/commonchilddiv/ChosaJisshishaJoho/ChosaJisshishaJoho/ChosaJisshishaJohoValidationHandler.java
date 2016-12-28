/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調査実施者情報共有子DivのValidationHandlerです。
 */
public class ChosaJisshishaJohoValidationHandler {

    private final ChosaJisshishaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link ChosaJisshishaJohoDiv}
     */
    public ChosaJisshishaJohoValidationHandler(ChosaJisshishaJohoDiv div) {
        this.div = div;
    }

    /**
     * 所属機関コードのバリデーションを実行します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate所属機関コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ChosaJisshishaJohoSpec.所属機関コードに該当するデータが存在すること)
                .thenAdd(ChosaJisshishaJohoValidationMessages.所属機関コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(createDictionary所属機関コード().check(messages));
        return validResult;
    }

    private ValidationDictionary createDictionary所属機関コード() {
        return new ValidationDictionaryBuilder()
                .add(ChosaJisshishaJohoValidationMessages.所属機関コードに該当するデータなし,
                        div.getTxtShozokuKikanCode())
                .build();
    }

    /**
     * 記入者コードのバリデーションを実行します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate記入者コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ChosaJisshishaJohoSpec.記入者コードに該当するデータが存在すること)
                .thenAdd(ChosaJisshishaJohoValidationMessages.記入者コードに該当するデータなし)
                .messages());
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(createDictionary記入者コード().check(messages));
        return validResult;
    }

    private ValidationDictionary createDictionary記入者コード() {
        return new ValidationDictionaryBuilder()
                .add(ChosaJisshishaJohoValidationMessages.記入者コードに該当するデータなし,
                        div.getTxtKinyushaCode())
                .build();
    }

}
