/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0440011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class KogakuSabisuhiShikyuShinseiPanelValidationHandler {

    private final KogakuSabisuhiShikyuShinseiPanelDiv div;
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 削除 = new RString("削除");

    /**
     * 初期化
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     */
    public KogakuSabisuhiShikyuShinseiPanelValidationHandler(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック
     *
     * @param 画面モード RString
     * @param 審査決定フラグ boolean
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs get入力チェック(RString 画面モード, boolean 審査決定フラグ) {
        ValidationMessageControlPairs validPairs = div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().check受付日と決定日();
        if (削除モード.equals(画面モード) && 審査決定フラグ) {
            validPairs.add(new ValidationMessageControlPair(
                    new KogakuSabisuhiShikyuShinseiPanelValidationHandler.IdocheckMessages(
                            UrErrorMessages.実行不可, 削除.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
