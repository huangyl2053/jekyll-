/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5090001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.createtarget.CreateTargetBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5090001.CreateTargetDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * センター送信データ出力の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateTargetValidationHandler {

    private final CreateTargetDiv div;
    private static final RString キー_0 = new RString("key0");
    private static final RString キー_1 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div センター送信データDiv
     */
    public CreateTargetValidationHandler(CreateTargetDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (キー_0.equals(div.getRdoShinseiNintei().getSelectedKey())
                && (div.getTxtShinseiYMD().getFromValue() == null || div.getTxtShinseiYMD().getToValue() == null)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new CreateTargetValidationHandler.CreateTargetMessages(UrErrorMessages.必須項目)));
        }
        if (キー_1.equals(div.getRdoShinseiNintei().getSelectedKey())
                && (div.getNinteiYMD().getFromValue() == null || div.getNinteiYMD().getToValue() == null)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new CreateTargetValidationHandler.CreateTargetMessages(UrErrorMessages.必須項目)));
        }
        return validationMessages;
    }

    /**
     * 対象者一覧チェックします。
     *
     * @param business 対象者一覧情報
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データチェック(List<CreateTargetBusiness> business) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (business == null || business.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new CreateTargetValidationHandler.CreateTargetMessages(UrErrorMessages.該当データなし)));
        }
        return validationMessages;
    }

    /**
     * 対象者一覧未選択チェックします。
     *
     * @param shinsei 対象者一覧情報
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 未選択チェック(List<RString> shinsei) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (shinsei == null || shinsei.isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new CreateTargetValidationHandler.CreateTargetMessages(UrErrorMessages.対象者を選択)));
        }
        return validationMessages;
    }

    private static final class CreateTargetMessages implements IValidationMessage {

        private final Message message;

        private CreateTargetMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
