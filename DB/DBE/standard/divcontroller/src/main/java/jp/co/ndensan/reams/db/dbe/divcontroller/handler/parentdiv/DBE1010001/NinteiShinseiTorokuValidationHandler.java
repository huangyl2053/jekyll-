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
     * データ重複チェック
     *
     * @param hasFlag データ重複フラグ
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データ重複チェック(boolean hasFlag) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (hasFlag) {
            validationMessages.add(new ValidationMessageControlPair(NinteiShinseiTorokuMessages.既に登録済));
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

        既に登録済(UrErrorMessages.既に登録済, "証記載保険者番号、被保険者番号、認定申請年月日と認定申請区分(申請時)コード"),
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
