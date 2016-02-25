/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.business.validation.FukaTaishoshaSearchValidationMessage;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 賦課対象者検索ののバリデーションクラスです。
 *
 * @author n8300 姜井図
 */
public class FukaTaishoshaSearchSearchResultValidator implements IValidatable {

    private final boolean 検索結果件数Flag;

    /**
     * コンストラクタです。
     *
     * @param 検索結果件数Flag boolean
     */
    public FukaTaishoshaSearchSearchResultValidator(boolean 検索結果件数Flag) {
        this.検索結果件数Flag = 検索結果件数Flag;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        if (検索結果件数Flag) {
            validationMessages.add(FukaTaishoshaSearchValidationMessage.対象者が存在しない);
        }

        return validationMessages;
    }

}
