/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100001.KaigoNinteiShinsakaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査会一覧の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1350-010 zuotao
 */
public class KaigoNinteiShinsakaiValidationHandler {

    private final KaigoNinteiShinsakaiDiv div;
    private static final RString 審査会 = new RString("審査会");

    /**
     * コンストラクタです。
     *
     * @param div 審査会一覧Div
     */
    public KaigoNinteiShinsakaiValidationHandler(KaigoNinteiShinsakaiDiv div) {
        this.div = div;
    }

    /**
     * 審査会データの空をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会データ空チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getCcdShinsakaiItiran().get一覧件数() == 0) {
            validationMessages.add(new ValidationMessageControlPair(
                    new KaigoNinteiShinsakaiValidationHandler.KaigoNinteiShinsakaiMessages(UrErrorMessages.対象データなし_追加メッセージあり, 審査会)));
        }
        return validationMessages;
    }

    /**
     * 審査会未選をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会未選択チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (0 < div.getCcdShinsakaiItiran().get一覧件数() && div.getCcdShinsakaiItiran().get開催番号List().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new KaigoNinteiShinsakaiValidationHandler.KaigoNinteiShinsakaiMessages(UrErrorMessages.選択されていない, 審査会)));
        }
        return validationMessages;
    }

    /**
     * 審査会未選をチェックします。
     *
     * @param 開催番号 開催番号
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会未選択チェック_選択(RString 開催番号) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(開催番号)) {
            validationMessages.add(new ValidationMessageControlPair(
                    new KaigoNinteiShinsakaiValidationHandler.KaigoNinteiShinsakaiMessages(UrErrorMessages.選択されていない, 審査会)));
        }
        return validationMessages;
    }

    /**
     * 審査会複数選択不可をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会複数選択不可チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (1 < div.getCcdShinsakaiItiran().get開催番号List().size()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new KaigoNinteiShinsakaiValidationHandler.KaigoNinteiShinsakaiMessages(DbeErrorMessages.複数選択不可, 審査会)));
        }
        return validationMessages;

    }

    private static final class KaigoNinteiShinsakaiMessages implements IValidationMessage {

        private final Message message;

        private KaigoNinteiShinsakaiMessages(IMessageGettable message, RString replaceParam) {
            this.message = message.getMessage().replace(replaceParam.toString());
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
