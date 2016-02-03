/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 調定簿作成のバリデーションハンドラークラスです。
 */
public class ChoteiboSakuseiValidationHandler {

    private final ChoteiboSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調定簿作成Div
     */
    public ChoteiboSakuseiValidationHandler(ChoteiboSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 処理年度の必須をチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor処理年度未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getDdlShoriNendo().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "処理年度")));
        }
        return validPairs;
    }

    /**
     * 抽出調定日時の開始年月日の必須をチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor抽出調定日時の開始年月日未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtChushutsuStYMD().getValue().toString().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "抽出調定日時の開始年月日")));
        }
        return validPairs;
    }

    /**
     * 抽出調定日時の開始時分秒（以上）の必須をチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor抽出調定日時の開始時分秒未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtChushutsuStTime().getValue().toString().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "抽出調定日時の開始時分秒（以上）")));
        }
        return validPairs;
    }

    /**
     * 抽出調定日時の終了年月日の必須をチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor抽出調定日時の終了年月日未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtChushutsuEdYMD().getValue().toString().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "抽出調定日時の終了年月日")));
        }
        return validPairs;
    }

    /**
     * 抽出調定日時の終了時分秒（未満）の必須をチェックします。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor抽出調定日時の終了時分秒未入力() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtChushutsuEdTime().getValue().toString().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.必須, "抽出調定日時の終了時分秒（未満）"),
                    div.getTxtChushutsuStYMD()));
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
