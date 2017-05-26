/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.NinteiChosaIraiShudouDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
     * 保存するボタンを押下するとき、更新項目のバリデーションチェックを行う。
     *
     */
    public void 更新項目チェック() {
        RString 更新前_調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
        RString 更新前_調査員コード = ViewStateHolder.get(ViewStateKeys.認定調査員コード, RString.class);
        RString 更新前_調査依頼年月日 = ViewStateHolder.get(ViewStateKeys.認定調査依頼年月日, RString.class);
        RString 更新後_調査委託先コード = div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue();
        RString 更新後_調査員コード = div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().getTxtChosainCode().getValue();
        RString 更新後_調査依頼年月日 = div.getNinteichosaIraiByHand().getTxtChosaIraiD().getValue().toDateString();
        boolean notUpdate = true;
        if (!更新前_調査委託先コード.equals(更新後_調査委託先コード)) {
            notUpdate = false;
        }
        if (!RString.isNullOrEmpty(更新前_調査員コード)) {
            if (!更新前_調査員コード.equals(更新後_調査員コード)) {
                notUpdate = false;
            }
        } else if (!RString.isNullOrEmpty(更新後_調査員コード)) {
            notUpdate = false;
        }
        if (!更新前_調査依頼年月日.equals(更新後_調査依頼年月日)) {
            notUpdate = false;
        }
        if (notUpdate) {
            throw new ApplicationException(UrErrorMessages.編集なしで更新不可.getMessage());
        }
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
