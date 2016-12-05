/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会開催結果登録の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
 */
public class ShinsakaiKaisaiValidationHandler {

    private final ShinsakaiKaisaiKekkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催結果登録Div
     */
    public ShinsakaiKaisaiValidationHandler(ShinsakaiKaisaiKekkaDiv div) {
        this.div = div;
    }

    /**
     * 開始予定時刻と終了予定時刻の前後順をチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void yoteiStartToKaisaiEndTimeCheck(ValidationMessageControlPairs validationMessages) {
        if (div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue().isBefore(div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.期間が不正_追加メッセージあり２, "開催開始時間", "開催終了時間")));
        }
    }

    /**
     *
     * 出席時間チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 出席時間Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (row.getShussekiTime().getValue().isBefore(div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue())
                        || div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue().isBefore(row.getShussekiTime().getValue())) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "出席時間")));
                    row.getShussekiTime().setDisabled(Boolean.FALSE);
                }
            }
        }
    }

    /**
     *
     * 退席時間 チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 退席時間Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (row.getTaisekiTime().getValue().isBefore(div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue())
                        || div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue().isBefore(row.getTaisekiTime().getValue())) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "退席時間")));
                    row.getTaisekiTime().setDisabled(Boolean.FALSE);
                }
            }
        }
    }

    /**
     *
     * 議長複数チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 議長複数Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            boolean 議長 = false;
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (!議長 && row.getGichoKubun().getSelectedKey().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                    議長 = true;
                    continue;
                }
                if (議長 && row.getGichoKubun().getSelectedKey().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.特定不可, "議長")));
                }
            }
        }
    }

    /**
     *
     * 必須項目チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 必須項目Check(ValidationMessageControlPairs validationMessages) {
        RString 開催日 = div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getText();
        if (RString.isNullOrEmpty(開催日)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        } else if (!RDate.canConvert(開催日)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "開催日")));
        }
        RString 開催開始時間 = div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getText();
        if (RString.isNullOrEmpty(開催開始時間)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        }
        RString 開催終了時間 = div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getText();
        if (RString.isNullOrEmpty(開催終了時間)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        }
        RString 所要時間 = div.getShinsakaiKaisaiInfo().getTxtShoyoTime().getText();
        if (RString.isNullOrEmpty(所要時間)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        }
        RString 実施人数 = div.getShinsakaiKaisaiInfo().getTxtJissiSu().getText();
        if (RString.isNullOrEmpty(実施人数)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        }
        RString 開催会場 = div.getShinsakaiKaisaiInfo().getDdlKaisaiBasho().getSelectedValue();
        if (RString.isNullOrEmpty(開催会場)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        }

    }

    /**
     *
     * 議長出席チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 議長出席Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (row.getGichoKubun().getSelectedKey().equals(new RString("1"))
                        && row.getShukketsuKubun().getSelectedKey().equals(new RString("false"))) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(DbeErrorMessages.欠席の設定不可)));
                }
            }
        }
    }

    /**
     *
     * 全員が遅刻チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 全員が遅刻Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            boolean is全員遅刻 = true;
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (row.getChikokuUmu().getSelectedKey().equals(new RString("false"))) {
                    is全員遅刻 = false;
                }
            }
            if (is全員遅刻 && !ResponseHolder.isReRequest()) {
                validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(DbeWarningMessages.保存確認, "全員が遅刻")));
            }
        }
    }

    /**
     *
     * 全員が早退チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    public void 全員が早退Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            boolean is全員が早退 = true;
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                if (row.getSotaiUmu().getSelectedKey().equals(new RString("false"))) {
                    is全員が早退 = false;
                }
            }
            if (is全員が早退 && !ResponseHolder.isReRequest()) {
                validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(DbeWarningMessages.保存確認, "全員が早退")));
            }
        }
    }

    private static class ShinsakaiKaisaiMessages implements IValidationMessage {

        private final Message message;

        public ShinsakaiKaisaiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
