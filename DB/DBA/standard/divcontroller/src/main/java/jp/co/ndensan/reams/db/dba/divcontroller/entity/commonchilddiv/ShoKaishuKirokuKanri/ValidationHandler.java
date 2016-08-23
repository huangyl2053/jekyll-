/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 証交付回収情報のチェッククラスです。
 *
 * @reamsid_L DBA-1070-010 lizhuoxuan
 */
public class ValidationHandler {

    private final ShoKaishuKirokuKanriDiv shoDiv;
    private static final int 桁数_256 = 256;

    /**
     * コンストラクタです。
     *
     * @param shoDiv ShoKaishuKirokuKanriDiv
     */
    public ValidationHandler(ShoKaishuKirokuKanriDiv shoDiv) {
        this.shoDiv = shoDiv;
    }

    /**
     * 交付日と有効期限の整合性チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付日と有効期限の整合性チェック(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxtKoufuType().getValue() != null
                && new RString("資格者証").equals(shoDiv.getPanelInput().getTxtKoufuType().getValue())
                && (shoDiv.getPanelInput().getTxtKoufuDate().getValue() != null
                && shoDiv.getPanelInput().getTxtYukouKigen().getValue() != null)
                && (!shoDiv.getPanelInput().getTxtKoufuDate().getValue().
                isBefore(shoDiv.getPanelInput().getTxtYukouKigen().getValue()))) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.ValidateA, shoDiv.getPanelInput().getTxtKoufuDate()));
        }
    }

    /**
     * 交付事由の必須チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付事由の必須チェック(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue() != null
                && RString.EMPTY.equals(shoDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate必須, shoDiv.getPanelInput().getDdlKoufuJiyu()));
        }
    }

    /**
     * 交付理由の最大桁数です。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付理由の最大桁数(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxaKoufuRiyu().getValue() != null
                && 桁数_256 < shoDiv.getPanelInput().getTxaKoufuRiyu().getValue().length()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate桁数, shoDiv.getPanelInput().getTxaKoufuRiyu()));
        }
    }

    /**
     * 回収理由のの最大桁数です。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 回収理由のの最大桁数(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxaKaishuRiyu().getValue() != null
                && 桁数_256 < shoDiv.getPanelInput().getTxaKaishuRiyu().getValue().length()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate桁数2, shoDiv.getPanelInput().getTxaKaishuRiyu()));
        }
    }

    /**
     * 交付日と回収日の順番の整合性チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付日と回収日の順番の整合性チェック(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxtKoufuDate().getValue() != null
                && shoDiv.getPanelInput().getTxtKaisyuDate().getValue() != null
                && shoDiv.getPanelInput().getTxtKaisyuDate().getValue().
                isBefore(shoDiv.getPanelInput().getTxtKoufuDate().getValue())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate順番,
                    shoDiv.getPanelInput().getTxtKoufuDate(),
                    shoDiv.getPanelInput().getTxtKaisyuDate()));
        }
    }

    /**
     * 交付日がセットになっているかの入力チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付日がセットになっているかの入力チェック(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxtKoufuDate().getValue() == null
                && !RString.EMPTY.equals(shoDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate交付日, shoDiv.getPanelInput().getTxtKoufuDate()));
        }
    }

    /**
     * 交付事由がセットになっているかの入力チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 交付事由がセットになっているかの入力チェック(ValidationMessageControlPairs validPairs) {
        if (RString.EMPTY.equals(shoDiv.getPanelInput().getDdlKoufuJiyu().getSelectedValue())
                && shoDiv.getPanelInput().getTxtKoufuDate().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate交付事由, shoDiv.getPanelInput().getDdlKoufuJiyu()));
        }
    }

    /**
     * 回収日がセットになっているかの入力チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 回収日がセットになっているかの入力チェック(ValidationMessageControlPairs validPairs) {
        if (shoDiv.getPanelInput().getTxtKaisyuDate().getValue() == null
                && !RString.EMPTY.equals(shoDiv.getPanelInput().getDdlKaisyuJiyu().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate回収日, shoDiv.getPanelInput().getTxtKaisyuDate()));
        }
    }

    /**
     * 回収事由がセットになっているかの入力チェックです。
     *
     * @param validPairs ValidationMessageControlPairs
     */
    public void 回収事由がセットになっているかの入力チェック(ValidationMessageControlPairs validPairs) {
        if (RString.EMPTY.equals(shoDiv.getPanelInput().getDdlKaisyuJiyu().getSelectedValue())
                && shoDiv.getPanelInput().getTxtKaisyuDate().getValue() != null) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.Validate回収事由, shoDiv.getPanelInput().getDdlKaisyuJiyu()));
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        ValidateA(UrErrorMessages.期間が不正_追加メッセージあり２, "有効期限", "交付日"),
        Validate必須(UrErrorMessages.必須, "交付事由"),
        Validate桁数(UrErrorMessages.桁数が不正, "交付理由", "256"),
        Validate桁数2(UrErrorMessages.桁数が不正, "回収理由", "256"),
        Validate順番(UrWarningMessages.日付の前後関係逆転以降, "交付日", "回収日"),
        Validate交付日(UrErrorMessages.必須項目_追加メッセージあり, "交付日"),
        Validate交付事由(UrErrorMessages.必須項目_追加メッセージあり, "交付事由"),
        Validate回収日(UrErrorMessages.必須項目_追加メッセージあり, "回収事由を設定する場合、回収日は必須項目"),
        Validate回収事由(UrErrorMessages.必須項目_追加メッセージあり, "回収日を設定する場合、回収事由は必須項目");
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
