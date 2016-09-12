/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0230011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011.KobetsuJikoRenkeiInfoSakuseiKoikiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護住民票個別事項連携情報作成【広域運用】の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBU-0550-010 zhangzhiming
 */
public class KaigoJyuminValidationHandler {

    private final KobetsuJikoRenkeiInfoSakuseiKoikiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護住民票Div
     */
    public KaigoJyuminValidationHandler(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        this.div = div;
    }

    /**
     * 確定するボタン押下の場合、入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (!div.getKonkaiInfoInput().getChkZenken().isAllSelected()) {
            if (div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(new KaigoJyuminValidationHandler.RRVMessages(
                        UrErrorMessages.必須, "今回開始日")));
            }
            if (div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().getValue() == null) {
                validationMessages.add(new ValidationMessageControlPair(new KaigoJyuminValidationHandler.RRVMessages(
                        UrErrorMessages.必須, "今回開始時")));
            }
            if (div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().getValue() != null
                    && div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().getValue() != null
                    && (RDateTime.of(div.getKonkaiInfoInput().getTxtZenkaiChushutsuToYMD().getValue() == null
                            ? RDate.getNowDate().toDateString() : div.getKonkaiInfoInput().getTxtZenkaiChushutsuToYMD().getValue().toDateString(),
                            div.getKonkaiInfoInput().getTxtZenkaiChushutsuToTime().getValue() == null
                            ? RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH_mm)
                            : div.getKonkaiInfoInput().getTxtZenkaiChushutsuToTime().getValue().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                    .isBefore(RDateTime.of(div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromYMD().getValue().toDateString(),
                                    div.getKonkaiInfoInput().getTxtKonkaiChushutsuFromTime().getValue()
                                    .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))))) {
                validationMessages.add(new ValidationMessageControlPair(new KaigoJyuminValidationHandler.RRVMessages(
                        UrErrorMessages.期間が不正_追加メッセージあり２, "今回開始日と今回開始時", "前回終了日と前回終了時")));
            }
        }
        return validationMessages;
    }

    private static final class RRVMessages implements IValidationMessage {

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
