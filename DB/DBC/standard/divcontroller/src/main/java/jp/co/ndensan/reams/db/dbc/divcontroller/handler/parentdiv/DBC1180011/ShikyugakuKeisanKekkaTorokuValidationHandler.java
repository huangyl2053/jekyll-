/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100011.KogakuGassanShikyuShinseiTorokuValidationMessage;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額合算支給額計算結果登録のValidationHandlerです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuValidationHandler {

    private final ShikyugakuKeisanKekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link ShikyugakuKeisanKekkaTorokuDiv}
     */
    public ShikyugakuKeisanKekkaTorokuValidationHandler(ShikyugakuKeisanKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 「計算結果を保存する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate計算結果を保存する() {
        IValidationMessages message = new ShikyugakuKeisanKekkaTorokuValidator(div).validate計算結果を保存する();
        return create計算結果を保存するDictionary().check(message);
    }

    private ValidationDictionary create計算結果を保存するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShikyugakuKeisanKekkaTorokuMessage.明細グリッド必須項目, div.getDgKogakuGassanShikyugakuKeisanKekkaMeisai())
                .add(ShikyugakuKeisanKekkaTorokuMessage.按分後支給額, div.getTxtHonninShikyugaku())
                .add(ShikyugakuKeisanKekkaTorokuMessage.以上の者に係る所得区分必須項目, div.getDdlOver70ShotokuKubun())
                .add(ShikyugakuKeisanKekkaTorokuMessage.介護等合算算定基準額必須項目, div.getTxtSanteiKijunGaku())
                .add(ShikyugakuKeisanKekkaTorokuMessage.対象計算期間終了年月日入力値が不正, div.getTxtTaishoKeisanKikan())
                .add(ShikyugakuKeisanKekkaTorokuMessage.計算期間年度内範囲制約, div.getTxtTaishoKeisanKikan())
                .add(ShikyugakuKeisanKekkaTorokuMessage.金額入力値が不正, div.getTxtHonninShikyugaku(), div.getTxtOver70HonninShikyugaku())
                .build();
    }

    /**
     * 整合性チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate整合性チェック() {
        IValidationMessages message = new ShikyugakuKeisanKekkaTorokuValidator(div).validate整合性チェック();
        return create整合性チェックDictionary().check(message);
    }

    private ValidationDictionary create整合性チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShikyugakuKeisanKekkaTorokuMessage.高額合算支給不支給決定データの存在).build();
    }

    /**
     * 「計算結果を追加する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate計算結果を追加する() {
        IValidationMessages message = new ShikyugakuKeisanKekkaTorokuValidator(div).validate計算結果を追加する();
        return create計算結果を追加するDictionary().check(message);
    }

    private ValidationDictionary create計算結果を追加するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShikyugakuKeisanKekkaTorokuMessage.連絡票整理番号既に存在, div.getTxtShikyuShinseishoSeiriNoInput())
                .add(KogakuGassanShikyuShinseiTorokuValidationMessage.証明書整理番号桁数が不正,
                        div.getTxtShikyuShinseishoSeiriNoInput()).build();
    }

    /**
     * 「内訳を確定する」ボタン押下時のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate内訳を確定する() {
        IValidationMessages message = new ShikyugakuKeisanKekkaTorokuValidator(div).validate内訳を確定する();
        return create内訳を確定するDictionary().check(message);
    }

    private ValidationDictionary create内訳を確定するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShikyugakuKeisanKekkaTorokuMessage.自己負担額証明書整理番号桁数が不正, div.getTxtJikoFutanSeiriNom())
                .add(ShikyugakuKeisanKekkaTorokuMessage.保険者番号桁数が不正, div.getTxtShoKisaiHokenshaNo())
                .add(ShikyugakuKeisanKekkaTorokuMessage.被保険者記号桁数が不正, div.getTxtKokuhoHihokenshaShoKigo())
                .add(ShikyugakuKeisanKekkaTorokuMessage.被保険者証番号桁数が不正, div.getTxtHiHokenshaShoNo())
                .add(ShikyugakuKeisanKekkaTorokuMessage.自己負担額証明書整理番号が不正, div.getTxtJikoFutanSeiriNom())
                .add(ShikyugakuKeisanKekkaTorokuMessage.自己負担額証明書整理番号既に存在, div.getTxtJikoFutanSeiriNom())
                .build();
    }
}
