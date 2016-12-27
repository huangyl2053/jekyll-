/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsChikokuUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IssotaiUmu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.ShinsakaiKaisaiKekkaDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会開催結果登録の抽象ValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0160-010 wangxiaodong
 */
public class ShinsakaiKaisaiValidationHandler {

    private static final RString 対象文言 = new RString("  対象: ");
    private static final RString 出席時間文言 = new RString("出席時間");
    private static final RString 退席時間文言 = new RString("退席時間");
    private static final RString 出席時間退席時間文言 = new RString("出席時間、退席時間");
    private static final RString 議長文言 = new RString("議長");
    private static final RString 全員遅刻文言 = new RString("全員が遅刻");
    private static final RString 全員早退文言 = new RString("全員が早退");
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
     * 登録対象についてチェックします。
     *
     * @param 結果情報 結果情報
     * @return メッセージ
     */
    public ValidationMessageControlPairs validate(ShinsakaiKaisaiYoteiJoho2 結果情報) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        yoteiStartToKaisaiEndTimeCheck(validationMessages);
        出席時間Check(validationMessages);
        退席時間Check(validationMessages);
        議長人数Check(validationMessages);
        議長出席Check(validationMessages);
        必須項目Check(validationMessages);
        変更有無Check(validationMessages, 結果情報);
        if (!validationMessages.existsError()) {
            全員が遅刻Check(validationMessages);
            全員が早退Check(validationMessages);
        }
        return validationMessages;
    }

    /**
     * 開始予定時刻と終了予定時刻の前後順をチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void yoteiStartToKaisaiEndTimeCheck(ValidationMessageControlPairs validationMessages) {
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
    private void 出席時間Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                ValidationMessageControlPair pair = 出席時間Check(row);
                if (pair != null) {
                    validationMessages.add(pair);
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
    private void 退席時間Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (!rowList.isEmpty()) {
            for (dgShinsakaiIinIchiran_Row row : rowList) {
                ValidationMessageControlPair pair = 退席時間Check(row);
                if (pair != null) {
                    validationMessages.add(pair);
                }
            }
        }
    }

    /**
     *
     * 議長人数をチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void 議長人数Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        int 議長人数 = 0;
        for (dgShinsakaiIinIchiran_Row row : rowList) {
            if (row.getGichoKubun().getSelectedKey().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                議長人数++;
            }
        }
        if (議長人数 == 0) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new ShinsakaiKaisaiMessages(UrErrorMessages.存在しない, 議長文言.toString())));
        }
        if (1 < 議長人数) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new ShinsakaiKaisaiMessages(UrErrorMessages.特定不可, 議長文言.toString())));
        }
    }

    /**
     *
     * 必須項目チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void 必須項目Check(ValidationMessageControlPairs validationMessages) {
        RString 開催日 = div.getShinsakaiKaisaiInfo().getTxtKaisaiBi().getText();
        if (RString.isNullOrEmpty(開催日)) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.必須項目)));
        } else if (!RDate.canConvert(開催日)) {
            validationMessages.add(
                    new ValidationMessageControlPair(
                            new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "開催日")));
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
     * 変更有無チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     * @param 介護認定審査会開催予定情報 介護認定審査会開催予定情報
     */
    private void 変更有無Check(ValidationMessageControlPairs validationMessages, ShinsakaiKaisaiYoteiJoho2 介護認定審査会開催予定情報) {
        if (new RString("新規モード").equals(div.getModel())) {
            return;
        }
        for (ShinsakaiKaisaiKekkaJoho2 介護認定審査会開催結果情報 : 介護認定審査会開催予定情報.getShinsakaiKaisaiKekkaJohoList()) {
            if (介護認定審査会開催結果情報.toEntity().hasChanged()) {
                return;
            }
        }
        for (ShinsakaiOnseiJoho2 介護認定審査会音声情報 : 介護認定審査会開催予定情報.getShinsakaiOnseiJohoList()) {
            if (介護認定審査会音声情報.toEntity().hasChanged()) {
                return;
            }
        }
        for (ShinsakaiWariateIinJoho2 介護認定審査会割当委員情報 : 介護認定審査会開催予定情報.getShinsakaiWariateIinJoho2List()) {
            if (介護認定審査会割当委員情報.toEntity().getState().equals(EntityDataState.Deleted)) {
                return;
            } else if (介護認定審査会割当委員情報.toEntity().hasChanged()) {
                return;
            }
        }

        validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKaisaiMessages(UrErrorMessages.更新対象のデータがない)));
    }

    /**
     *
     * 議長出席チェックをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void 議長出席Check(ValidationMessageControlPairs validationMessages) {
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
     * 全員が遅刻かをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void 全員が遅刻Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (rowList.isEmpty()) {
            return;
        }
        for (dgShinsakaiIinIchiran_Row row : rowList) {
            if (row.getChikokuUmu().getSelectedKey().equals(new RString("false"))) {
                return;
            }
        }
        validationMessages.add(
                new ValidationMessageControlPair(
                        new ShinsakaiKaisaiMessages(DbeWarningMessages.保存確認, 全員遅刻文言.toString())));
    }

    /**
     *
     * 全員が早退かをチェックします。
     *
     * @param validationMessages バリデーションメッセージ
     */
    private void 全員が早退Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getShinsakaiIinToroku().getDgShinsakaiIinIchiran().getDataSource();
        if (rowList.isEmpty()) {
            return;
        }
        for (dgShinsakaiIinIchiran_Row row : rowList) {
            if (row.getSotaiUmu().getSelectedKey().equals(new RString("false"))) {
                return;
            }
        }
        validationMessages.add(
                new ValidationMessageControlPair(
                        new ShinsakaiKaisaiMessages(DbeWarningMessages.保存確認, 全員早退文言.toString())));
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

    /**
     * 出席時間と遅刻が妥当かをチェックします。
     *
     * @param row チェック対象
     * @return メッセージ
     */
    ValidationMessageControlPair 出席時間Check(dgShinsakaiIinIchiran_Row row) {
        if (row.getShukketsuKubun().getSelectedValue().equals(IsShusseki.欠席.get名称())) {
            return null;
        }
        boolean is遅刻有無内容が遅刻 = row.getChikokuUmu().getSelectedValue().equals(IsChikokuUmu.遅刻.get名称());
        RTime 審査会開催時刻 = div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue();
        RTime 審査会終了時刻 = div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue();
        if (審査会開催時刻.isAfter(審査会終了時刻)) {
            return null;
        }
        RTime 委員出席時刻 = row.getShussekiTime().getValue();
        if (is遅刻有無内容が遅刻 && 審査会開催時刻.equals(委員出席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(出席時間文言, row).toString()));
        }
        if (!is遅刻有無内容が遅刻 && !審査会開催時刻.equals(委員出席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(出席時間文言, row).toString()));
        }
        if (委員出席時刻.isBefore(審査会開催時刻) || 審査会終了時刻.isBefore(委員出席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(出席時間文言, row).toString()));
        }
        return null;
    }

    /**
     * 退席時間と早退が妥当かをチェックします。
     *
     * @param row チェック対象
     * @return メッセージ
     */
    ValidationMessageControlPair 退席時間Check(dgShinsakaiIinIchiran_Row row) {
        if (row.getShukketsuKubun().getSelectedValue().equals(IsShusseki.欠席.get名称())) {
            return null;
        }
        boolean is早退有無内容が早退 = row.getSotaiUmu().getSelectedValue().equals(IssotaiUmu.早退.get名称());
        RTime 審査会開催時刻 = div.getShinsakaiKaisaiInfo().getTxtKaisaiStartTime().getValue();
        RTime 審査会終了時刻 = div.getShinsakaiKaisaiInfo().getTxtKaisaiEndTime().getValue();
        if (審査会開催時刻.isAfter(審査会終了時刻)) {
            return null;
        }
        RTime 委員出席時刻 = row.getShussekiTime().getValue();
        RTime 委員退席時刻 = row.getTaisekiTime().getValue();
        if (is早退有無内容が早退 && 審査会終了時刻.equals(委員退席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(退席時間文言, row).toString()));
        }
        if (!is早退有無内容が早退 && !審査会終了時刻.equals(委員退席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(退席時間文言, row).toString()));
        }
        if (委員退席時刻.isBefore(審査会開催時刻) || 審査会終了時刻.isBefore(委員退席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.入力値が不正_追加メッセージあり,
                            createエラー文言(退席時間文言, row).toString()));
        }
        if (委員出席時刻.isAfter(委員退席時刻)) {
            return new ValidationMessageControlPair(
                    new ShinsakaiKaisaiMessages(UrErrorMessages.大小関係が不正,
                            createエラー文言(出席時間退席時間文言, row).toString()));
        }
        return null;
    }

    /**
     * 一覧データグリッドの行内容から対象者を含めたエラー文言を生成します。
     *
     * @param 内容 内容
     * @param row row
     * @return エラー文言
     */
    RString createエラー文言(RString 内容, dgShinsakaiIinIchiran_Row row) {
        return 内容.concat(対象文言).concat(row.getShimei()).concat(row.getGichoKubun().getSelectedValue());
    }

}
