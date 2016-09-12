/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5180001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5180001.ShinsaTaishoDataDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会審査対象データ出力（モバイル）のチェッククラスです。
 *
 * @reamsid_L DBE-1840-010 yaoyahui
 */
public class ShinsaTaishoDataValidationHandler {

    private final ShinsaTaishoDataDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 判定結果情報出力（介護認定審査会）
     */
    public ShinsaTaishoDataValidationHandler(ShinsaTaishoDataDiv div) {
        this.div = div;
    }

    /**
     * 審査会一覧が複数選択の場合
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs データの選択チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (1 < div.getCcdShinsakaiIchiranList().get開催番号List().size()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate審査会の複数選択チェック));
        }

        if (div.getCcdShinsakaiIchiranList().get開催番号List().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate審査会未選択チェック));
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        Validate審査会の複数選択チェック(DbeErrorMessages.複数選択不可, "審査会一覧"),
        Validate審査会未選択チェック(UrErrorMessages.対象行を選択);
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
