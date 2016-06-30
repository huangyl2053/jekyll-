/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120003;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShotokuJohoChushutsuValidationHandler {

    private static final RString 定値_ファイルを指定してください = new RString("ファイルを指定してください");
    private static final int NUM0 = 0;

    /**
     * コンストラクタです。
     *
     */
    public ShotokuJohoChushutsuValidationHandler() {
    }

    /**
     * アップロードファイル未指定チェック。
     *
     * @param files FileData[]
     * @return ValidationMessageControlPairs
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ValidationMessageControlPairs ファイルチェック(FileData[] files) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (files == null || files.length == NUM0) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.指定ファイルが存在しない, (定値_ファイルを指定してください.toString()))));
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
