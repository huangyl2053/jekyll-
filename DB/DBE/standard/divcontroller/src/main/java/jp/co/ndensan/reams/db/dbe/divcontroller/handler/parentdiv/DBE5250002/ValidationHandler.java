/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5250002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002.NijihanteiKekkaOutputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 判定結果情報出力（保険者）のチェッククラスです。
 */
public class ValidationHandler {

    private final NijihanteiKekkaOutputDiv nijidiv;

    /**
     * コンストラクタです。
     *
     * @param nijidiv 判定結果情報出力（保険者）
     */
    public ValidationHandler(NijihanteiKekkaOutputDiv nijidiv) {
        this.nijidiv = nijidiv;
    }

    public ValidationMessageControlPairs データ空チェック(ValidationMessageControlPairs validPairs) {
        if (nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未表示,
                    nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran()));
        }
        return validPairs;
    }

    public ValidationMessageControlPairs 未選択チェック(ValidationMessageControlPairs validPairs) {
        if (nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran().getSelectedItems().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate対象者一覧未選択,
                    nijidiv.getNijihanteiKekkaIchiran().getDgTaishoshaIchiran()));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate対象者一覧未表示(UrErrorMessages.該当データなし),
        Validate対象者一覧未選択(UrErrorMessages.対象行を選択);
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
