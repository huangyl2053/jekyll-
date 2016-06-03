/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7030001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001.DvShokanbaraiJohoDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「実行する」ボタンを押下時の入力チェックValidationHandlerです。
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoValidationHandler {

    private final DvShokanbaraiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link DvShokanbaraiJohoDiv}
     */
    public DvShokanbaraiJohoValidationHandler(DvShokanbaraiJohoDiv div) {
        this.div = div;
    }

    /**
     * 様式番号一覧チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate様式番号一覧() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate様式番号一覧();
        return create様式番号一覧Dictionary().check(message);
    }

    private ValidationDictionary create様式番号一覧Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.様式番号一覧データ未指定,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo()).build();
    }

    /**
     * 支払方法と金融機関コード制御チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate金融機関コード() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate金融機関コード();
        return create金融機関コードDictionary().check(message);
    }

    private ValidationDictionary create金融機関コードDictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.金融機関コードは未指定でなければなりません,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getRadKogakuShiharaisaki()).build();
    }

    /**
     * サービス提供年月From、サービス提供年月Toの大小関係チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateサービス提供年月() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validateサービス提供年月();
        return createサービス提供年月Dictionary().check(message);
    }

    private ValidationDictionary createサービス提供年月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.サービス提供年月期間が不正,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanServiceTeikyoYM()).build();
    }

    /**
     * 申請日From、申請日Toの大小関係チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate申請日() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate申請日();
        return create申請日Dictionary().check(message);
    }

    private ValidationDictionary create申請日Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.申請日期間が不正,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanShinseiDate()).build();
    }

    /**
     * 住宅改修支給届出日From、住宅改修支給届出日Toの大小関係チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate住宅改修支給届出日() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate住宅改修支給届出日();
        return create住宅改修支給届出日Dictionary().check(message);
    }

    private ValidationDictionary create住宅改修支給届出日Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.住宅改修支給届出日期間が不正,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanHokenshaKetteiDate()).build();
    }

    /**
     * 決定日From、決定日Toの大小関係チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate決定日() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate決定日();
        return create決定日Dictionary().check(message);
    }

    private ValidationDictionary create決定日Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.決定日期間が不正,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKetteiDate()).build();
    }

    /**
     * 国保連送付年月From、国保連送付年月Toの大小関係チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate国保連送付年月() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validate国保連送付年月();
        return create国保連送付年月Dictionary().check(message);
    }

    private ValidationDictionary create国保連送付年月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.国保連送付年月期間が不正,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDvKensakuJoken().getTxtShokanKokuhorenSofuYM()).build();
    }

    /**
     * validateCommonButton check
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateCommonButton() {
        IValidationMessages message = new DvShokanbaraiJohoValidator(div).validateCommonButton();
        return createCommonButton().check(message);
    }

    private ValidationDictionary createCommonButton() {
        return new ValidationDictionaryBuilder()
                .add(DvShokanbaraiJohoValidationMessage.対象のデータがありません,
                        div.getDvShokanbaraiParam().getDvShokanChushutsuJoken().getDgYoshikiNo()).build();
    }

}
