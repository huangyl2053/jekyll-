/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定情報提供のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoValidationHandler {

    private final YokaigoNinteiJohoTeikyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定情報提供Div
     */
    public YokaigoNinteiJohoTeikyoValidationHandler(YokaigoNinteiJohoTeikyoDiv div) {
        this.div = div;
    }

    /**
     * データチェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!div.getHakkoChohyo().getChkNinteiChosahyo().isAllSelected()
                && !div.getHakkoChohyo().getChkTokkiJiko().isAllSelected()
                && !div.getHakkoChohyo().getChkShujiiIkensho().isAllSelected()
                && !div.getHakkoChohyo().getChkSonotaShiryo().isAllSelected()
                && !div.getHakkoChohyo().getChkIchijiHanteiKekka().isAllSelected()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(UrErrorMessages.選択されていない, "帳票"),
                    div.getHakkoChohyo()));
        }
        return validationMessages;
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
