/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import jp.co.ndensan.reams.db.dbz.business.core.validation.FukaTaishoshaSearchValidationMessage;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 賦課対象者検索ののバリデーションクラスです。
 *
 * @author n8300 姜井図
 */
public class FukaTaishoshaSearchMaxNumberValidator implements IValidatable {

    private final int 最大表示件数;
    private final TextBoxNum 最大表示件数入力値;

    /**
     * コンストラクタです。
     *
     * @param 最大表示件数 int
     * @param 最大表示件数入力値 int
     */
    public FukaTaishoshaSearchMaxNumberValidator(int 最大表示件数, TextBoxNum 最大表示件数入力値) {
        this.最大表示件数 = 最大表示件数;
        this.最大表示件数入力値 = 最大表示件数入力値;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages validationMessages = ValidationMessagesFactory.createInstance();

        if (null != 最大表示件数入力値.getValue() && 最大表示件数入力値.getValue().intValue() > 最大表示件数) {
            validationMessages.add(FukaTaishoshaSearchValidationMessage.最大取得件数上限超過);
        } else if (null != 最大表示件数入力値.getValue() && 最大表示件数入力値.getValue().intValue() == 0) {
            validationMessages.add(FukaTaishoshaSearchValidationMessage.最大取得件数上限超過);
        }

        return validationMessages;
    }

}
