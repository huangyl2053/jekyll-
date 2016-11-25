/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1180011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011.ShikyugakuKeisanKekkaTorokuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
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
                .add(ShikyugakuKeisanKekkaTorokuMessage.連絡票整理番号年度が不正, div.getTxtShikyuShinseishoSeiriNoInput())
                .build();
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
                .add(ShikyugakuKeisanKekkaTorokuMessage.自己負担額証明書整理番号既に存在, div.getTxtJikoFutanSeiriNom())
                .build();
    }

    /**
     * 内訳入力途中チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate内訳入力途中() {
        IValidationMessages message = new ShikyugakuKeisanKekkaTorokuValidator(div).validate内訳入力途中();
        return create内訳入力途中チェックDictionary().check(message);
    }

    private ValidationDictionary create内訳入力途中チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShikyugakuKeisanKekkaTorokuMessage.内訳入力途中).build();
    }

    /**
     * 入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate入力チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDdlHokenSeido().getRequired() && div.getDdlHokenSeido().getSelectedKey().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "保険制度"), div.getDdlHokenSeido()));
        }
        if (div.getTxtHokenshaMei().isRequired() && RString.isNullOrEmpty(div.getTxtHokenshaMei().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "保険者番号"), div.getTxtHokenshaMei()));
        }
        if (div.getTxtShoKisaiHokenshaNo().isRequired() && RString.isNullOrEmpty(div.getTxtShoKisaiHokenshaNo().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "保険者名"), div.getTxtShoKisaiHokenshaNo()));
        }
        if (div.getTxtTaishoshaShimei().isRequired() && RString.isNullOrEmpty(div.getTxtTaishoshaShimei().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "対象者氏名"), div.getTxtTaishoshaShimei()));
        }
        if (div.getTxtHiHokenshaShoNo().isRequired() && RString.isNullOrEmpty(div.getTxtHiHokenshaShoNo().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "被保険者(証)番号"), div.getTxtHiHokenshaShoNo()));
        }
        
        return validationMessages;
    }

    /**
     * 支給額計算結果入力チェック。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate支給額計算結果入力チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getTxtTaishoKeisanKikan().isToRequired() && div.getTxtTaishoKeisanKikan().getToValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "対象計算期間"), div.getTxtTaishoKeisanKikan()));
        }
        if (div.getTxtHonninShikyugaku().isRequired() && div.getTxtHonninShikyugaku().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "按分後支給額"), div.getTxtHonninShikyugaku()));
        }
        if (div.getTxtTsuchiYMD().isRequired() && div.getTxtTsuchiYMD().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "通知日"), div.getTxtTsuchiYMD()));
        }
        if (div.getTxtRenrakuhyoHakkoshaMei().isRequired() && RString.isNullOrEmpty(div.getTxtRenrakuhyoHakkoshaMei().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "氏名"), div.getTxtRenrakuhyoHakkoshaMei()));
        }
        if (div.getTxtRenrakuhyoHakkoshaYubinNo().isRequired()
                && (div.getTxtRenrakuhyoHakkoshaYubinNo().getValue() == null || div.getTxtRenrakuhyoHakkoshaYubinNo().getValue().isEmpty())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "郵便番号"), div.getTxtRenrakuhyoHakkoshaYubinNo()));
        }
        if (div.getTxtRenrakuhyoHakkoshaJusho().isRequired() && RString.isNullOrEmpty(div.getTxtRenrakuhyoHakkoshaJusho().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "住所"), div.getTxtRenrakuhyoHakkoshaJusho()));
        }
        validate名称チェック(validationMessages);
        return validationMessages;
    }

    private void validate名称チェック(ValidationMessageControlPairs validationMessages) {
        if (div.getTxtToiawasesakiMeisho1().isRequired() && RString.isNullOrEmpty(div.getTxtToiawasesakiMeisho1().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "名称１"), div.getTxtToiawasesakiMeisho1()));
        }
        if (div.getTxtToiawasesakiYobinNo().isRequired()
                && (div.getTxtToiawasesakiYobinNo().getValue() == null || div.getTxtToiawasesakiYobinNo().getValue().isEmpty())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "郵便番号"), div.getTxtToiawasesakiYobinNo()));
        }
        if (div.getTxtToiawasesakiTelNo().isRequired() && RString.isNullOrEmpty(div.getTxtToiawasesakiTelNo().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "電話番号"), div.getTxtToiawasesakiTelNo()));
        }
        if (div.getTxtToiawasesakiJusho().isRequired() && RString.isNullOrEmpty(div.getTxtToiawasesakiJusho().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(new ShikyugakuKeisanKekkaTorokuValidationHandler.RRVMessages(
                    UrErrorMessages.必須, "住所"), div.getTxtToiawasesakiJusho()));
        }
    }

    private static final class RRVMessages implements IValidationMessage {

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
