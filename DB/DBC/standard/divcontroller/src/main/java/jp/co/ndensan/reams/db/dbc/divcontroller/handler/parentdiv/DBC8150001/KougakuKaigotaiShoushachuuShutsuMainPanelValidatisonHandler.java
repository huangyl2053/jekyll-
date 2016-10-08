/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8150001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
    private static final RString ZERO_TIME = new RString("000000");
    private static final RString コンマ = new RString(":");
    private static final RString TIME_ZERO = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamPanelDiv
     */
    public KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 今回終了日時＞今回処理日時チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 今回終了日時チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 終了日付 = toRStringDate(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getToDatePlaceHolder());
        RString 終了時刻 = get時刻(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getToPlaceHolder());
        RString 今回終了日時 = 終了日付.concat(終了時刻);
        RString 処理日付 = div.getChushutsuKikanPanel().getTxtShoriYMDKonkai().getValue().toDateString();
        RString 処理時刻 = div.getChushutsuKikanPanel().getTxtShoriHMKonkai().getText();
        RString 処理日時 = 処理日付.concat(処理時刻);
        if (今回終了日時.compareTo(処理日時) > 0) {
            validPairs.add(new ValidationMessageControlPair(
                    KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler.RRVMessages.Validate今回終了日時チェック));
            return validPairs;
        } else {
            return validPairs;
        }
    }

    /**
     * 今回開始日時＞今回終了日時チェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 今回開始日時チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        RString 開始日付 = toRStringDate(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getFromDatePlaceHolder());
        RString 開始時刻 = get時刻(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getToPlaceHolder());
        RString 今回開始日時 = 開始日付.concat(開始時刻);
        RString 終了日付 = toRStringDate(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getToDatePlaceHolder());
        RString 終了時刻 = get時刻(div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().getToPlaceHolder());
        RString 今回終了日時 = 終了日付.concat(終了時刻);
        if (今回開始日時.compareTo(今回終了日時) > 0) {
            validPairs.add(new ValidationMessageControlPair(
                    KougakuKaigotaiShoushachuuShutsuMainPanelValidatisonHandler.RRVMessages.Validate今回開始日時チェック));
            return validPairs;
        } else {
            return validPairs;
        }
    }

    private RString get時刻(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return ZERO_TIME;
        }
        RStringBuilder jokenBuilder = new RStringBuilder();
        List<RString> listvalue = value.split(コンマ.toString());
        for (RString list : listvalue) {
            if (list.length() != 2) {
                jokenBuilder.append(TIME_ZERO).append(list);
            } else {
                jokenBuilder.append(list);
            }
        }
        return jokenBuilder.toRString();
    }

    private RString toRStringDate(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RDate(obj.toString()).toDateString();
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

    private static enum RRVMessages implements IValidationMessage {

        Validate今回終了日時チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "終了日時", "処理日時"),
        Validate今回開始日時チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "今回開始日時", "今回終了日時"),
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
