/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.helper;

import jp.co.ndensan.reams.db.dbz.business.core.FukaTaishoshaSearchMaxNumberValidator;
import jp.co.ndensan.reams.db.dbz.business.core.FukaTaishoshaSearchSearchConditionValidator;
import jp.co.ndensan.reams.db.dbz.business.core.FukaTaishoshaSearchSearchResultValidator;
import jp.co.ndensan.reams.db.dbz.business.core.validation.FukaTaishoshaSearchValidationMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001.SearchConditionDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 賦課対象者検索のバリデーションマッピングクラスです。
 *
 * @author n8300 姜井図
 */
public final class FukaTaishoshaSearchValidationHelper {

    private FukaTaishoshaSearchValidationHelper() {
    }

    /**
     * 最大表示件数バリデーションを行います。
     *
     * @param 最大表示件数 int
     * @param 最大表示件数入力値 TextBoxNum
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate最大表示件数(int 最大表示件数, TextBoxNum 最大表示件数入力値) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(FukaTaishoshaSearchValidationMessage.最大取得件数上限超過, 最大表示件数入力値)
                .build();

        IValidationMessages messages = new FukaTaishoshaSearchMaxNumberValidator(最大表示件数, 最大表示件数入力値).validate();

        return dictionary.check(messages);
    }

    /**
     * 検索条件バリデーションを行います。
     *
     * @param 検索条件Flag boolean
     * @param 検索条件Div HihokenshaFinderDiv
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate検索条件(boolean 検索条件Flag, SearchConditionDiv 検索条件Div) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(FukaTaishoshaSearchValidationMessage.検索条件未指定, 検索条件Div)
                .build();

        IValidationMessages messages = new FukaTaishoshaSearchSearchConditionValidator(検索条件Flag).validate();

        return dictionary.check(messages);
    }

    /**
     * 検索結果件数バリデーションを行います。
     *
     * @param 検索結果件数Flag boolean
     * @param 検索条件Div HihokenshaFinderDiv
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate検索結果件数(boolean 検索結果件数Flag, SearchConditionDiv 検索条件Div) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(FukaTaishoshaSearchValidationMessage.対象者が存在しない, 検索条件Div)
                .build();

        IValidationMessages messages = new FukaTaishoshaSearchSearchResultValidator(検索結果件数Flag).validate();

        return dictionary.check(messages);
    }
}
