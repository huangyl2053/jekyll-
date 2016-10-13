/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU1110011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.TokuteiPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011.grdTokuteiJoho_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 個人番号関連情報提供のValidationHandlerクラスです。
 *
 * @reamsid_L DBU-4880-010 linghuhang
 */
public class TokuteiPanelValidationHandler {

    private final TokuteiPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 個人番号関連情報提供Div
     */
    public TokuteiPanelValidationHandler(TokuteiPanelDiv div) {
        this.div = div;
    }

    /**
     * 実行するボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<grdTokuteiJoho_Row> listRow = div.getGrdTokuteiJoho().getDataSource();
        boolean is選択 = true;
        for (grdTokuteiJoho_Row row : listRow) {
            if (row.getChkSeiGyo().isValue()) {
                is選択 = false;
                break;
            }
        }
        if (is選択) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.選択されていない));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        選択されていない(UrErrorMessages.選択されていない, "作成対象とする特定個人情報");

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
