/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1010001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1010001.NinteiShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 審査依頼受付／みなし２号審査受付の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public class NinteiShinseiTorokuValidationHandler {

    private final NinteiShinseiTorokuDiv div;

    private static final RString MENUID_DBEMN21003 = new RString("DBEMN21003");

    /**
     * コンストラクタです。
     *
     * @param div 審査依頼受付／みなし２号審査受付Div
     */
    public NinteiShinseiTorokuValidationHandler(NinteiShinseiTorokuDiv div) {
        this.div = div;

    }

    /**
     *
     * 編集なしチェック
     *
     * @param flag フラグ
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 編集なしチェック(boolean flag) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (flag) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.編集なしで更新不可));
            return validationMessages;
        }
        return validationMessages;
    }

    /**
     *
     * 被保険者区分チェック
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 被保険者区分チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RString menuID = ResponseHolder.getMenuID();
        if (MENUID_DBEMN21003.equals(menuID)
                && !HihokenshaKubunCode.生活保護.getコード().equals(div.getCcdKaigoNinteiShinseiKihon().
                        getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey())) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.項目に対する制約));
            return validationMessages;
        }
        return validationMessages;
    }

    private static enum NinteiShinseiTorokuMessages implements IValidationMessage {

        編集なしで更新不可(UrErrorMessages.編集なしで更新不可),
        項目に対する制約(UrErrorMessages.項目に対する制約, "みなし２号審査受付場合、被保険者区分", "\"8\" (生活保護)");

        private final Message message;

        private NinteiShinseiTorokuMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
