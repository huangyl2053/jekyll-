/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.DBU0210011;

import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyo.ChushutsuKikanJohoData;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0210011.KobetsuJikoRenkeiInfoSakuseiDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護住民票個別事項連携情報作成【他社住基】ハンドラクラスです。
 */
public class KobetsuJikoRenkeiInfoSakuseiHandler {

    private final KobetsuJikoRenkeiInfoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護住民票個別事項連携情報作成【他社住基】情報Div
     */
    public KobetsuJikoRenkeiInfoSakuseiHandler(KobetsuJikoRenkeiInfoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param chushutsuKikanJohoData 抽出期間情報Entity
     */
    public void initialize(ChushutsuKikanJohoData chushutsuKikanJohoData) {

        if (chushutsuKikanJohoData != null) {
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromYMD().setValue(
                    new RDate(chushutsuKikanJohoData.get対象開始日時().getDate().wareki().toDateString().toString()));
            div.getTblChushutsuKikan().getTxtKonkaiChushutsuFromTime().setValue(
                    chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD().setValue(
                    new RDate(chushutsuKikanJohoData.get対象終了日時().getDate().wareki().toDateString().toString()));
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().setValue(
                    chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().setValue(
                    new RDate(chushutsuKikanJohoData.get対象終了日時().getDate().wareki().toDateString().toString()));
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().setValue(
                    chushutsuKikanJohoData.get対象開始日時().getRDateTime().getTime());
        } else {
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromYMD().setValue(
                    new RDate(RDate.getNowDate().wareki().toDateString().toString()));
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuFromTime().setValue(RDate.getNowTime());
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToYMD().setValue(
                    new RDate(RDate.getNowDate().wareki().toDateString().toString()));
            div.getTblChushutsuKikan().getTxtZenkaiChushutsuToTime().setValue(RDate.getNowTime());
        }
    }

    /**
     * 「今回開始日、今回開始時」＞「前回終了日、前回終了時」の場合、エラーとする。
     *
     * @return validationMessages
     */
    public ValidationMessageControlPairs 開始日と終了日の比較チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(RRVMessages.ValidateA));
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        ValidateA(DbzErrorMessages.期間が不正_未来日付不可, "今回開始日と今回開始時", "前回終了日と前回終了時");
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
