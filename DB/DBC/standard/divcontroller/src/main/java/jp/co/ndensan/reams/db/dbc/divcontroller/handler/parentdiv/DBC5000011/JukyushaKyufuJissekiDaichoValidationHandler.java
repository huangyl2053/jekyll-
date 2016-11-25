/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5000011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011.JukyushaKyufuJissekiDaichoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 受給者給付実績一覧表発行 のコントローラです。
 *
 * @reamsid_L DBC-3070-010 dangjingjing
 */
public class JukyushaKyufuJissekiDaichoValidationHandler {

    private final JukyushaKyufuJissekiDaichoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JukyushaKyufuJissekiDaichoDiv
     */
    public JukyushaKyufuJissekiDaichoValidationHandler(JukyushaKyufuJissekiDaichoDiv div) {
        this.div = div;
    }

    /**
     * UrErrorMessages.?を入力してください。
     *
     * @param msg msg
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check開始終了年月が必須(RString msg) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("開始年月を").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.未入力, "開始年月を"), div.getTxtRangeYM()));
        }
        if (new RString("終了年月を").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.未入力, "終了年月を"), div.getTxtRangeYM()));
        }
        return validationMessages;
    }

    /**
     * UrErrorMessages.大小関係が不正です。(%1)
     *
     * @param msg msg
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs check大小関係不正(RString msg) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("年月").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.大小関係が不正, msg.toString()), div.getTxtRangeYM()));
        }
        if (new RString("被保険者番号").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.大小関係が不正, msg.toString()), div.getTxtRangeHihokenshaNoFrom(), div.getTxtRangeHihokenshaNoTo()));
        }
        if (new RString("老人保健市町村番号").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.大小関係が不正, msg.toString()), div.getTxtRojinhokenShikuchosonNoRangeFrom(),
                    div.getTxtRojinhokenShikuchosonNoRangeTo()));
        }
        if (new RString("老人保健受給者番号").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.大小関係が不正, msg.toString()), div.getTxtRojinHokenJukyushaNoFrom(),
                    div.getTxtRojinHokenJukyushaNoTo()));
        }
        if (new RString("事業者番号").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.大小関係が不正, msg.toString()), div.getTxtJigyoshaNoFrom(), div.getTxtJigyoshaNoTo()));
        }
        return validationMessages;
    }

    /**
     * UrErrorMessages.?指定してください。
     *
     * @param msg msg
     * @return validPairs
     */
    public ValidationMessageControlPairs check未指定(RString msg) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("要介護を").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.未指定, "要介護を"), div.getChkYokaigodo()));
        }
        if (new RString("出力様式を").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.未指定, "出力様式を"), div.getChkShutsuryokuYoshiki1(), div.getChkShutsuryokuYoshiki2(),
                    div.getChkShutsuryokuYoshiki3(), div.getChkShutsuryokuYoshiki4(), div.getChkShutsuryokuYoshiki5()));
        }
        return validationMessages;
    }

    /**
     * UrErrorMessages.入力値が不正です。:%1
     *
     * @param msg msg
     * @return validPairs
     */
    public ValidationMessageControlPairs check必須項目を入力(RString msg) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("１～100").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, "１～100"), div.getTabChushutsuJoken().getTxtKyufuritsu()));
        }
        return validationMessages;
    }

    /**
     * UrErrorMessages.出力順序を指定してください。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs check出力順序を指定() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                UrErrorMessages.出力順序を指定)));
        return validationMessages;
    }

    /**
     * UrErrorMessages.年月範囲は１年以内としてください。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check年月範囲不正() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new JukyushaKyufuJissekiDaichoValidationHandler.CheckMessages(
                DbcErrorMessages.年月範囲不正), div.getTxtRangeYM()));
        return validationMessages;
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
