/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護認定審査会開催結果登録の抽象ValidationHandlerクラスです。
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
        if (new RString("更新モード").equals(div.getModel()) && div.getTxtYoteiStartTime().getValue().isAfter(div.getTxtYoteiEndTime().getValue())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.期間が不正_追加メッセージあり２, "開始予定時刻", "終了予定時刻")));
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
                if (RTime.parse(row.getShussekiTime()).isBefore(div.getTxtKaisaiStartTime().getValue())
                        || div.getTxtKaisaiEndTime().getValue().isBefore(RTime.parse(row.getShussekiTime()))) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "出席時間")));
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
                if (RTime.parse(row.getTaisekiTime()).isBefore(div.getTxtKaisaiStartTime().getValue())
                        || div.getTxtKaisaiEndTime().getValue().isBefore(RTime.parse(row.getTaisekiTime()))) {
                    validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "退席時間")));
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
