/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020006;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020006.NinteiChosainJikanMasterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査スケジュール登録6のバリデーションハンドラークラスです。
 */
public class NinteiChosainJikanMasterValidationHandler {

    private final NinteiChosainJikanMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査スケジュール登録6Div
     */
    public NinteiChosainJikanMasterValidationHandler(NinteiChosainJikanMasterDiv div) {
        this.div = div;
    }

    /**
     * 「設定年月の時間枠を検索する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForSearch() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDdlTaishoChiku().getSelectedKey() == null
                || div.getDdlTaishoChiku().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.地区リストチェック, div.getDdlTaishoChiku()));
        }
        return validPairs;
    }

    /**
     * 「登録する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForCreate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (new RString("key1").equals(div.getRadYoyaku().getSelectedKey()) && (div.getMainPanel().getTxtBiko().getValue() == null
                || div.getMainPanel().getTxtBiko().getValue().isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.備考欄チェック, div.getMainPanel().getTxtBiko()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        地区リストチェック(UrErrorMessages.選択されていない, "地区"),
        備考欄チェック(UrErrorMessages.必須, "備考");
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
