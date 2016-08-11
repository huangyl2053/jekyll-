/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011;

import jp.co.ndensan.reams.db.dbu.definition.message.DbuErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author wangkun
 */
public class JigyoJokyoHokokuGeppoSakuseiValidationHandler {

    /**
     * コンストラクタです。
     */
    public JigyoJokyoHokokuGeppoSakuseiValidationHandler() {
    }

    /**
     * DBZE00002「必須項目を入力してください。:%1」
     *
     * @param 引数 引数
     * @return validPairs
     */
    public ValidationMessageControlPairs check必須入力項目(RString 引数) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JigyoJokyoHokokuGeppoSakuseiValidationHandler.CheckMessages(
                UrErrorMessages.必須項目_追加メッセージあり,
                引数.toString())));
        return validPairs;
    }

    /**
     * DBZE00004「入力値が不正です。:%1」以降の日付を設定
     *
     * @param 引数 引数
     * @return validPairs
     */
    public ValidationMessageControlPairs check入力値が不正(RString 引数) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JigyoJokyoHokokuGeppoSakuseiValidationHandler.CheckMessages(
                UrErrorMessages.入力値が不正_追加メッセージあり,
                引数.toString())));
        return validPairs;
    }

    /**
     * DBUE00001「%1以降の日付を設定してください。」
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check以降の日付を設定() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new JigyoJokyoHokokuGeppoSakuseiValidationHandler.CheckMessages(
                DbuErrorMessages.開始日不正,
                "平成12年4月")));
        return validPairs;
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
