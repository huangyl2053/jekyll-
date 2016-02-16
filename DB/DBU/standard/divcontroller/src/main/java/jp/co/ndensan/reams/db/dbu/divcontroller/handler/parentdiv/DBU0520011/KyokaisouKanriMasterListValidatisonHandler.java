/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0520011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011.KyokaisouKanriMasterListPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * KyokaisouKanriMasterListValidationMessageバリデーションメッセージを定義している列挙型です。
 *
 * @author ludm
 */
public class KyokaisouKanriMasterListValidatisonHandler {

    private final KyokaisouKanriMasterListPanelDiv div;
    private static final RString 境界層対象抽出範囲 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール情報Div
     */
    public KyokaisouKanriMasterListValidatisonHandler(KyokaisouKanriMasterListPanelDiv div) {
        this.div = div;
    }

    /**
     * 「範囲」が選択されている場合に、開始日と終了日両者とも入力されていないとエラーにする。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 範囲抽出必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validate();
        validPairs.add(new ValidationMessageControlPair(RRVMessages.範囲抽出必須入力チェック,
                div.getKyokaisoKariParam().getTxtHaniChushutsu(), div.getKyokaisoKariParam().getTxtHaniChushutsu()));
        return validPairs;
    }

    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        boolean チェック結果 = false;
        if ((境界層対象抽出範囲).equals(div.getKyokaisoKariParam().getRadHani().getSelectedKey())
                && div.getKyokaisoKariParam().getTxtHaniChushutsu().getFromValue() == null
                && div.getKyokaisoKariParam().getTxtHaniChushutsu().getToValue() == null) {
            チェック結果 = true;
        }
        if (チェック結果) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.範囲抽出必須入力チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        範囲抽出必須入力チェック(UrErrorMessages.必須, "開始日と終了日のいずれか１つ以上を入力してください。");

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
