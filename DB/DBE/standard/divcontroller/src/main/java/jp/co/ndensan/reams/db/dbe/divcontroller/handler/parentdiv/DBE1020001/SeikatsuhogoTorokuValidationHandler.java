/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1020001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001.SeikatsuhogoTorokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * みなし2号登録の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public class SeikatsuhogoTorokuValidationHandler {

    private final SeikatsuhogoTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div みなし2号登録Div
     */
    public SeikatsuhogoTorokuValidationHandler(SeikatsuhogoTorokuDiv div) {
        this.div = div;

    }

    /**
     *
     * 保険者をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs hokenshaCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getCcdHokenshaList().getSelectedItem() == null) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.保険者));
        }
        return validationMessages;
    }

    /**
     *
     * 被保険者番号をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs hihokenshaNoCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtHihokenshaNo().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.被保険者番号));
        }
        return validationMessages;
    }

    /**
     *
     * 氏名をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs shimeiCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtShimei().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.申請者氏名));
        }
        return validationMessages;
    }

    /**
     *
     * カナ氏名をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs kanaShimeiCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtKanaShimei().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.申請者カナ氏名));
        }
        return validationMessages;
    }

    /**
     *
     * 郵便番号をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs yubinNoCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtYubinNo().getValue().value())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.郵便番号));
        }
        return validationMessages;
    }

    /**
     *
     * 住所をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs jushoCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getCcdZenkokuJushoInput().get全国住所コード().value())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.住所));
        }
        return validationMessages;
    }

    /**
     *
     * 電話番号をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs telNoCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getTxtTelNo().getDomain().value())) {
            validationMessages.add(new ValidationMessageControlPair(SeikatsuhogoTorokuMessages.電話番号));
        }
        return validationMessages;
    }

    /**
     * 入力チェックを実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs allCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(hokenshaCheck());
        validationMessages.add(hihokenshaNoCheck());
        validationMessages.add(shimeiCheck());
        validationMessages.add(kanaShimeiCheck());
        validationMessages.add(yubinNoCheck());
        validationMessages.add(jushoCheck());
        validationMessages.add(telNoCheck());
        return validationMessages;
    }

    private static enum SeikatsuhogoTorokuMessages implements IValidationMessage {

        保険者(UrErrorMessages.必須項目_追加メッセージあり, "保険者"),
        被保険者番号(UrErrorMessages.必須項目_追加メッセージあり, "被保険者番号"),
        申請者氏名(UrErrorMessages.必須項目_追加メッセージあり, "申請者氏名"),
        申請者カナ氏名(UrErrorMessages.必須項目_追加メッセージあり, "申請者カナ氏名"),
        郵便番号(UrErrorMessages.必須項目_追加メッセージあり, "郵便番号"),
        住所(UrErrorMessages.必須項目_追加メッセージあり, "住所"),
        電話番号(UrErrorMessages.必須項目_追加メッセージあり, "電話番号");

        private final Message message;

        private SeikatsuhogoTorokuMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
