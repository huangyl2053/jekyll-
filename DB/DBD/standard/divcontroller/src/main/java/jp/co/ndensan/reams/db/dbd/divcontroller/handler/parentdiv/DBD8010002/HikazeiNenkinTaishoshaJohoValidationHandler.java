/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.syorijyoutaicode.SyoriJyoutaiCode;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
//import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDivSpec;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.dgShoriSettei_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 非課税年金対象者情報取込画面のHandlerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJohoValidationHandler {

    private final HikazeiNenkinTaishoshaJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HikazeiNenkinTaishoshaJohoDiv
     */
    public HikazeiNenkinTaishoshaJohoValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        this.div = div;
    }

    /**
     * 編集なしチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor編集なし(ValidationMessageControlPairs pairs) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        //messages.add(ValidateChain.validateStart(div).ifNot(HikazeiNenkinTaishoshaJohoDivSpec.編集なしチェック)
        //        .thenAdd(NoInputMessages.編集なしチェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.編集なしチェック).build().check(messages));
        return pairs;
    }

    /**
     * 再処理確認チェックチェックを行います。
     *
     * @return バリデーション結果
     */
    public boolean validateFor再処理確認() {

        List<dgShoriSettei_Row> rowList = div.getDgShoriSettei().getDataSource();
        for (dgShoriSettei_Row row : rowList) {
            if (!row.getHdnSyokiShoriJotai().equals(row.getTxtShoriJotai().getSelectedKey())
                    && !SyoriJyoutaiCode.再処理前.getコード().equals(row.getHdnSyokiShoriJotai())
                    && SyoriJyoutaiCode.再処理前.getコード().equals(row.getTxtShoriJotai().getSelectedKey())) {
                return true;
            }
        }
        return false;
    }

    private static enum NoInputMessages implements IValidationMessage {

        編集なしチェック(DbdErrorMessages.変更無し);

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
