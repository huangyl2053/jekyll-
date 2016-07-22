/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000015;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000015.DBCMNK4001PanelAllDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNK4001_更正対象給付実績一覧のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-4960-010 dongqianjing
 */
public class DBCMNK4001PanelAllValidationHandler {

    private final DBCMNK4001PanelAllDiv div;
    private static final RString 今回抽出期間 = new RString("今回抽出期間");

    /**
     * コンストラクタです。
     *
     * @param div 更正対象給付実績一覧Div
     */
    public DBCMNK4001PanelAllValidationHandler(DBCMNK4001PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 大小関係が不正のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 大小関係が不正() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                UrErrorMessages.大小関係が不正, 今回抽出期間.toString())));
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
