/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 支払方法情報のコントローラです。
 *
 * @reamsid_L DBC-0300-010 houtianpeng
 */
public class ShiharaiHohoJyohoValidationHandler {

    private final ShiharaiHohoJyohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 支払方法情報Div
     */
    public ShiharaiHohoJyohoValidationHandler(ShiharaiHohoJyohoDiv div) {
        this.div = div;
    }

    /**
     * 支払方法情報、バリデーションチェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateCheck() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();

        if (支払場所の必須チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.支払場所の必須チェック, div.getTxtShiharaiBasho()));
        }
        if (開始日の必須チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.開始日の必須チェック, div.getTxtStartYMD()));
        }
        if (開始日と終了日の整合性チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.開始日と終了日の整合性チェック, div.getTxtStartYMD(), div.getTxtEndYMD()));
        }
        if (開始時間の必須チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.開始時間の必須チェック, div.getTxtStartHHMM()));
        }
        if (開始時間と終了時間の整合性チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.開始時間と終了時間の整合性チェック, div.getTxtStartHHMM(), div.getTxtEndHHMM()));
        }
        if (口座ＩＤの必須チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.口座ＩＤの必須チェック, div.getDdlKozaID()));
        }
        if (契約番号の必須チェック()) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.口座ＩＤの必須チェック, div.getTxtKeiyakuNo()));
        }
        return validPairs;
    }

    /**
     * 開始日と終了日の整合性チェック
     *
     * @return エラー
     */
    private boolean 開始日と終了日の整合性チェック() {
        return !div.getRadMadoguti().getSelectedKey().isNullOrEmpty()
                && div.getTxtStartYMD().getValue() != null
                && div.getTxtEndYMD().getValue() != null
                && (!div.getTxtStartYMD().getValue().isBeforeOrEquals(div.getTxtEndYMD().getValue()));
    }

    /**
     * 開始時間と終了時間の整合性チェック
     *
     * @return エラー
     */
    private boolean 開始時間と終了時間の整合性チェック() {
        return !div.getRadMadoguti().getSelectedKey().isNullOrEmpty()
                && div.getTxtStartYMD().getValue() != null
                && div.getTxtEndYMD().getValue() != null
                && (div.getTxtStartYMD().getValue().equals(div.getTxtEndYMD().getValue()))
                && (div.getTxtStartHHMM().getValue().isAfter(div.getTxtEndHHMM().getValue()));
    }

    /**
     * 支払場所の必須チェック
     *
     * @return エラー
     */
    private boolean 支払場所の必須チェック() {
        return !div.getRadMadoguti().getSelectedKey().isNullOrEmpty()
                && div.getTxtShiharaiBasho().getValue().isNullOrEmpty();
    }

    /**
     * 開始日の必須チェック
     *
     * @return エラー
     */
    private boolean 開始日の必須チェック() {
        return !div.getRadMadoguti().getSelectedKey().isNullOrEmpty()
                && div.getTxtStartYMD().getValue() == null;
    }

    /**
     * 開始時間の必須チェック
     *
     * @return エラー
     */
    private boolean 開始時間の必須チェック() {
        return !div.getRadMadoguti().getSelectedKey().isNullOrEmpty()
                && div.getTxtStartHHMM().getValue() == null;
    }

    /**
     * 口座ＩＤの必須チェック
     *
     * @return エラー
     */
    private boolean 口座ＩＤの必須チェック() {
        return !div.getRadKoza().getSelectedKey().isNullOrEmpty()
                && div.getDdlKozaID().getSelectedKey().isNullOrEmpty();
    }

    /**
     * 契約番号の必須チェック
     *
     * @return エラー
     */
    private boolean 契約番号の必須チェック() {
        return !div.getRadJyryoinin().getSelectedKey().isNullOrEmpty()
                && div.getTxtKeiyakuNo().getValue().isNullOrEmpty();
    }

    private static enum RRVMessages implements IValidationMessage {

        支払場所の必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "支払場所"),
        開始時間の必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "開始時間"),
        開始日と終了日の整合性チェック(UrErrorMessages.終了日が開始日以前),
        開始時間と終了時間の整合性チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "開始時間", "終了時間"),
        口座ＩＤの必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "口座ＩＤ"),
        契約番号の必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "契約番号"),
        開始日の必須チェック(UrErrorMessages.必須項目_追加メッセージあり, "開始日");
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
