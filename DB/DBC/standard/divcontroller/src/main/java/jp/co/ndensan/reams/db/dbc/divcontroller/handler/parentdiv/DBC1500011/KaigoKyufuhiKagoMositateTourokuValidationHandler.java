/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1500011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011.KaigoKyufuhiKagoMositateTourokuDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のメッセージクラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
public class KaigoKyufuhiKagoMositateTourokuValidationHandler {

    private final KaigoKyufuhiKagoMositateTourokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KaigoKyufuhiKagoMositateTourokuValidationHandler(KaigoKyufuhiKagoMositateTourokuDiv div) {
        this.div = div;
    }

    /**
     * 必須項目を入力チェックを行う。
     *
     * @param msg メッセージの引数
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check必須項目を入力(RString msg) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!new RString("被保番号、支援事業者番号").equals(msg)) {
            validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり,
                    msg.toString()), div.getTxtHihoNo()));
        } else {
            validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                    UrErrorMessages.必須項目_追加メッセージあり,
                    msg.toString()), div.getTxtTeikyoYMRange()));
        }

        return validationMessages;
    }

    /**
     * 終了日が開始日以前チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check終了日が開始日以前() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                UrErrorMessages.終了日が開始日以前)));
        return validationMessages;
    }

    /**
     * 申立日エラーチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check申立日エラー() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                DbcErrorMessages.申立日エラー), div.getTxtMeisaiMoshitateDate(), div.getTxtMeisaiTeikyoYM())
        );
        return validationMessages;
    }

    /**
     * 同月審査申立理由整合性エラーチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check同月審査申立理由整合性エラー() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                DbcErrorMessages.同月審査申立理由整合性エラー), div.getDdlMeisaiKagoMoshitateRiyu()));
        return validationMessages;
    }

    /**
     * 送付済みチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs check送付済みチェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(new KaigoKyufuhiKagoMositateTourokuValidationHandler.CheckMessages(
                SoufuzumiMSG.送付済みチェック), div.getTxtMeisaiSendYM()));
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

    /**
     * 送付済みチェックメッセージです。
     */
    public enum SoufuzumiMSG implements IMessageGettable {

        /**
         * 送付済みチェック
         */
        送付済みチェック("送付済みのため、削除できません");
        private final Message message;

        private SoufuzumiMSG(String msg) {
            this.message = new ErrorMessage(RString.EMPTY.toString(), msg);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
