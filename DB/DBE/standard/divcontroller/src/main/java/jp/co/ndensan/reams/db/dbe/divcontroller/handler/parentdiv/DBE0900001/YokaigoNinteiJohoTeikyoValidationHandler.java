/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0900001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.YokaigoNinteiJohoTeikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001.dgNinteiKekkaIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
//        List<dgNinteiKekkaIchiran_Row> rowList = div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getDataSource();
//        if (rowList == null || rowList.isEmpty()) {
//            validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(
//                    UrErrorMessages.該当データなし)));
//        }
//        if (div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getSelectedItems() == null
//                || div.getNInteiRirekiInfo().getDgNinteiKekkaIchiran().getSelectedItems().isEmpty()) {
//            validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(
//                    UrErrorMessages.対象行を選択)));
//        }
        getMessage(validationMessages);
        return validationMessages;
    }

    private ValidationMessageControlPairs getMessage(ValidationMessageControlPairs validationMessages) {
        if (!div.getHakkoChohyo().getChkNinteiChosahyo().isAllSelected() && !div.getHakkoChohyo().getChkTokkiJiko().isAllSelected()
                && !div.getHakkoChohyo().getChkShujiiIkensho().isAllSelected() && !div.getHakkoChohyo().getChkSonotaShiryo().isAllSelected()
                && !div.getHakkoChohyo().getChkIchijiHanteiKekka().isAllSelected()) {
            validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(
                    UrErrorMessages.選択されていない, "帳票")));
        }
        if ((div.getHakkoChohyo().getChkNinteiChosahyo().isAllSelected() || div.getHakkoChohyo().getChkTokkiJiko().isAllSelected()
                || div.getHakkoChohyo().getChkShujiiIkensho().isAllSelected() || div.getHakkoChohyo().getChkSonotaShiryo().isAllSelected()
                || div.getHakkoChohyo().getChkIchijiHanteiKekka().isAllSelected())
                && div.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi().getSelectedKey().equals(new RString("key1"))) {
            validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(
                    DbeErrorMessages.印刷不可, "被保険者")));
        }
        if ((div.getHakkoChohyo().getChkNinteiChosahyo().isAllSelected() || div.getHakkoChohyo().getChkTokkiJiko().isAllSelected()
                || div.getHakkoChohyo().getChkShujiiIkensho().isAllSelected() || div.getHakkoChohyo().getChkSonotaShiryo().isAllSelected()
                || div.getHakkoChohyo().getChkIchijiHanteiKekka().isAllSelected())
                && div.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi().getSelectedKey().equals(new RString("key1"))
                && !div.getChkShujiiIkensho().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new YokaigoNinteiJohoTeikyoValidationHandler.RRVMessages(
                    DbeErrorMessages.印刷不可, "主治医")));
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
