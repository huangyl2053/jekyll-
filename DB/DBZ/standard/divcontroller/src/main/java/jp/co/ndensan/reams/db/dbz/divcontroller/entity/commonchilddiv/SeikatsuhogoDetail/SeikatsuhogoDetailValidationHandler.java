/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 生活保護明細のValidationHandlerクラスです。
 *
 * @reamsid_L DBZ-4510-010 xuyannan
 */
public class SeikatsuhogoDetailValidationHandler {

    private final SeikatsuhogoDetailDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 生活保護明細Div
     */
    public SeikatsuhogoDetailValidationHandler(SeikatsuhogoDetailDiv div) {
        this.div = div;
    }

    /**
     * 「確定する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTeishiShuryoYMD().getValue().isBefore(div.getTxtTeishiKaishiYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate停止期間が不正_追加メッセージあり, div.getTxtTeishiShuryoYMD(), div.getTxtTeishiKaishiYMD()));
        }
        // TODO QA1198 "停止期間の期間重複チェック"はなんですか？
        return validPairs;
    }

    /**
     * 「明細を確定する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForDetailKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtJukyuHaishiYMD().getValue().isBefore(div.getTxtJukyuKaishiYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate受給期間が不正_追加メッセージあり, div.getTxtJukyuKaishiYMD(), div.getTxtJukyuHaishiYMD()));
        }
        // TODO SeikaatsuhogoDataModelにて、停止期間がありません,実装できない。
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate受給期間が不正_追加メッセージあり(UrErrorMessages.期間が不正_追加メッセージあり２, "廃止年月日", "開始年月日"),
        Validate停止期間が不正_追加メッセージあり(UrErrorMessages.期間が不正_追加メッセージあり２, "停止終了日", "停止開始日"),
        Validate期間が不正(UrErrorMessages.期間が不正),
        Validate期間が重複(UrErrorMessages.期間が重複);
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
