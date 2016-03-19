/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011;

import jp.co.ndensan.reams.db.dbc.definition.message.jutakukaishuhishikyushinsei.JutakuKaishuhiShikyuShinseiErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011.MishinsaShikyuShinseiListPanelValidator;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011.SearchConditionToMishinsaShikyuShinseiPanelValidator;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011.ShinsaButtonDivValidator;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修費支給申請一括審査・決定画面 チェッククラスです
 */
public class JutakuKaishuhiShikyuShinseiPanelVlaidationHandler {

    private final JutakuKaishuhiShikyuShinseiPanelDiv div;

    /**
     * コンストラクタです
     *
     * @param div (JutakuKaishuhiShikyuShinseiPanelDiv
     */
    public JutakuKaishuhiShikyuShinseiPanelVlaidationHandler(JutakuKaishuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    /**
     * volidate支給申請日
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidate支給申請日() {
        IValidationMessages messages = new SearchConditionToMishinsaShikyuShinseiPanelValidator(div).validate();
        return createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary().check(messages);
    }

    /**
     * volidateデータ選択
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidateデータ選択() {
        IValidationMessages messages = new MishinsaShikyuShinseiListPanelValidator(div).validate();
        return createMishinsaShikyuShinseiListPanelValidatorDictionary().check(messages);
    }

    /**
     * volidateデータ選択と未審査
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs volidateデータ選択と未審査() {
        IValidationMessages messages = new ShinsaButtonDivValidator(div).validate();
        return createMishinsaShinsaButtonDivValidatorDictionary().check(messages);
    }

    /**
     * createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationDictionary createSearchConditionToMishinsaShikyuShinseiPanelValidatorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの有効性チェック,
                        div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.支給申請日FROMと支給申請日TOの必須チェック,
                        div.getSearchConditionToMishinsaShikyuShinseiPanel().getTxtShikyuShinseiDate()).build();
    }

    /**
     * createMishinsaShikyuShinseiListPanelValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationDictionary createMishinsaShikyuShinseiListPanelValidatorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei()).build();
    }

    /**
     * createMishinsaShinsaButtonDivValidatorDictionary
     *
     * @return ValidationDictionary
     */
    private ValidationDictionary createMishinsaShinsaButtonDivValidatorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.データ選択のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei())
                .add(JutakuKaishuhiShikyuShinseiErrorMessages.未審査のチェック,
                        div.getMishinsaShikyuShinseiListPanel().getDgMishinsaShikyuShinsei()).build();
    }
}
