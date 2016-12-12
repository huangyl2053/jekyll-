/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.NinteiChosaIraiShudouDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査依頼(手動)のハンドラークラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinteiChosaIraiShudouValidationHandler {

    private final NinteiChosaIraiShudouDiv div;
    private static final RString 発行書類 = new RString("発行書類を");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査依頼Div
     */
    public NinteiChosaIraiShudouValidationHandler(NinteiChosaIraiShudouDiv div) {
        this.div = div;
    }

    /**
     * 保存するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs checkForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (RString.isNullOrEmpty(div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.必須, "委託先")));
        }
        if (RString.isNullOrEmpty(div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosainCode().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new CheckMessages(UrErrorMessages.必須, "調査員")));
        }
        return validPairs;
    }

    /**
     * 印刷帳票が選択することのチェック。
     *
     * @return
     */
    public ValidationMessageControlPairs 印刷帳票チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getChkIrai().getSelectedKeys().isEmpty()
                && div.getChkNinteichosaDesign().getSelectedKeys().isEmpty()
                && div.getChkNinteichosaOcr().getSelectedKeys().isEmpty()
                && div.getChkSaiCheck().getSelectedKeys().isEmpty()
                && div.getChkTokkiJko().getSelectedKeys().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new CheckMessages(
                    UrErrorMessages.未指定, 発行書類.toString()),
                    div.getChkIrai(),
                    div.getChkNinteichosaDesign(),
                    div.getChkNinteichosaOcr(),
                    div.getChkSaiCheck(),
                    div.getChkTokkiJko()));
        }
        return validationMessages;
    }

    private static class CheckMessages implements IValidationMessage {

        private final Message message;

        public CheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
