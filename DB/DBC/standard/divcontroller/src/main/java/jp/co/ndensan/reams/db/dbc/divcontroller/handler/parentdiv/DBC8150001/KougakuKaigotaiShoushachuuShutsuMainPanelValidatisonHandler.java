/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8150001;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）の入力チェックです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
public class KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler {

    private final KougakuKaigotaiShoushachuuShutsuMainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamPanelDiv
     */
    public KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 国保連インターフェース管理テーブルチェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler.RRVMessages.Validate初期チェック));
        return validPairs;
    }

    /**
     * 今回日時チェック。
     *
     * @return ValidationMessageControlPairs
     */
    public boolean 今回日時チェック() {
        boolean flg = false;
        RString 処理日 = div.getTxtShoriYMDKonkai().getValue().toDateString();
        RString 処理時 = div.getTxtShoriHMKonkai().getText();
        RString 処理日時 = 処理日.concat(処理時);
        RString 抽出期間終了日 = div.getTxtChushutsuKikanKonkai().getToDateValue().toDateString();
        RString 抽出期間終了時 = get抽出期間(div.getTxtChushutsuKikanKonkai().getToTimeValue());
        RString 抽出期間終了日時 = 抽出期間終了日.concat(抽出期間終了時);
        if (抽出期間終了日時.compareTo(処理日時) > 0) {
            flg = true;
        }
        return flg;
    }

    private RString get抽出期間(RTime value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            int hour = value.getHour();
            int minute = value.getMinute();
            int second = value.getSecond();
            return new RString(String.valueOf(hour).concat(String.valueOf(minute)).concat(String.valueOf(second)));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        今回日時チェック(UrQuestionMessages.確認_汎用),
        Validate初期チェック(DbcErrorMessages.高額対象者抽出初期チェック);
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
