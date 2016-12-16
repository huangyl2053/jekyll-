/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5140001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe5140001.ShinsakaiKaisaiYoteiJohoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.ShinsakaiKaisaiYoteiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.dgKaisaiYoteiNyuryokuran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140001.dgShinsakaiKaisaiGogitaiJoho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 介護認定審査会開催予定登録1のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0130-010 yaodongsheng
 */
public class ShinsakaiKaisaiYoteiTorokuValidationHandler {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;
    private static final RString 未開催 = new RString("1");
    private static final RString 分割 = new RString("-");
    private static final RString FUNN = new RString(":");
    private static final RString NENNDO = new RString("年");
    private static final RString GETSU = new RString("月");
    private final ShinsakaiKaisaiYoteiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShinsakaiKaisaiYoteiTorokuDiv
     */
    public ShinsakaiKaisaiYoteiTorokuValidationHandler(ShinsakaiKaisaiYoteiTorokuDiv div) {
        this.div = div;
    }

    /**
     *
     * 保存可否をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保存可否Check() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        List<dgKaisaiYoteiNyuryokuran_Row> dgNyuryokuRowList = div.getDgKaisaiYoteiNyuryokuran().getDataSource();
        boolean hozon = false;
        for (dgKaisaiYoteiNyuryokuran_Row dgNyuryokuRow : dgNyuryokuRowList) {
            if ((!dgNyuryokuRow.getKaisaiGogitai1().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai1().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai2().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai2().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai3().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai3().getValue().isEmpty())
                    || (!dgNyuryokuRow.getKaisaiGogitai4().isDisabled() && !dgNyuryokuRow.getKaisaiGogitai4().getValue().isEmpty())) {
                hozon = true;
                break;
            }
        }
        if (!hozon) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                            UrErrorMessages.更新対象のデータがない), div.getDgKaisaiYoteiNyuryokuran()));
        }
        return validationMessages;
    }

    /**
     *
     * 合議体存在をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 合議体存在Check(ValidationMessageControlPairs validationMessages) {
        List<dgShinsakaiKaisaiGogitaiJoho_Row> dgGogitaiRowList = div.getDgShinsakaiKaisaiGogitaiJoho().getDataSource();
        for (dgKaisaiYoteiNyuryokuran_Row dgNyuryokuRow : div.getDgKaisaiYoteiNyuryokuran().getDataSource()) {
            if (!isAru(dgNyuryokuRow.getKaisaiGogitai1(), dgGogitaiRowList)) {
                set合議体存在Message(validationMessages);
                break;
            }
            if (!isAru(dgNyuryokuRow.getKaisaiGogitai2(), dgGogitaiRowList)) {
                set合議体存在Message(validationMessages);
                break;
            }
            if (!isAru(dgNyuryokuRow.getKaisaiGogitai3(), dgGogitaiRowList)) {
                set合議体存在Message(validationMessages);
                break;
            }
            if (!isAru(dgNyuryokuRow.getKaisaiGogitai4(), dgGogitaiRowList)) {
                set合議体存在Message(validationMessages);
                break;
            }
        }
        return validationMessages;
    }

    /**
     *
     * 合議体重複をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 合議体重複チェック(ValidationMessageControlPairs validationMessages) {
        set合議体重複Message(validationMessages);
        return validationMessages;
    }

    /**
     *
     * 設定日未選択をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 設定日未選択チェック(ValidationMessageControlPairs validationMessages) {
        if (div.getTxtSeteibi().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                            UrErrorMessages.選択されていない, "設定日"), div.getTxtSeteibi()));
        }
        return validationMessages;
    }

    /**
     *
     * 審査会の1日最大登録件数をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会の1日最大登録件数チェック(ValidationMessageControlPairs validationMessages) {
        RString 開催最大数 = DbBusinessConfig.get(ConfigNameDBE.審査会開催最大数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        List<dgKaisaiYoteiNyuryokuran_Row> nyuryokuRowList = div.getDgKaisaiYoteiNyuryokuran().getDataSource();
        int count = 0;
        for (dgKaisaiYoteiNyuryokuran_Row row : nyuryokuRowList) {
            if (!row.getKaisaiGogitai1().getValue().isEmpty()) {
                count++;
            }
            if (!row.getKaisaiGogitai2().getValue().isEmpty()) {
                count++;
            }
            if (!row.getKaisaiGogitai3().getValue().isEmpty()) {
                count++;
            }
            if (!row.getKaisaiGogitai4().getValue().isEmpty()) {
                count++;
            }
        }
        if (count > Integer.valueOf(開催最大数.toString())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                            DbeErrorMessages.審査会開催最大数を超過), div.getDgKaisaiYoteiNyuryokuran()));
        }
        return validationMessages;
    }

    /**
     *
     * 予定進捗状況未選択をチェックします。
     *
     * @param index index
     * @param shinsakaEntityList shinsakaEntityList
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 予定進捗状況チェック(int index, List<ShinsakaiKaisaiYoteiJohoParameter> shinsakaEntityList) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        dgKaisaiYoteiNyuryokuran_Row row = div.getDgKaisaiYoteiNyuryokuran().getActiveRow();
        switch (index) {
            case INDEX_1:
                set予定進捗状況Message(validationMessages, row.getKaisaiGogitai1().getValue(), shinsakaEntityList);
                break;
            case INDEX_2:
                set予定進捗状況Message(validationMessages, row.getKaisaiGogitai2().getValue(), shinsakaEntityList);
                break;
            case INDEX_3:
                set予定進捗状況Message(validationMessages, row.getKaisaiGogitai3().getValue(), shinsakaEntityList);
                break;
            case INDEX_4:
                set予定進捗状況Message(validationMessages, row.getKaisaiGogitai4().getValue(), shinsakaEntityList);
                break;
            default:
                break;
        }
        return validationMessages;
    }

    /**
     *
     * 週コピーから日をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 週コピーから日チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RStringBuilder date = new RStringBuilder();
        if (div.getTxtCopyFrom().getValue() == null || !FlexibleDate.canConvert(date.append(getLblMonth(div.getLblMonth().getText()))
                .append(div.getTxtCopyFrom().getValue().padZeroToLeft(INDEX_2)).toRString())
                || !new FlexibleDate(date.toRString()).isValid()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピーから日"),
                    div.getTxtCopyFrom()));
        }
        return validationMessages;
    }

    /**
     *
     * 週コピー開始日をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 週コピー開始日チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RStringBuilder date = new RStringBuilder();
        if (div.getTxtCopyTo().getValue() == null || !FlexibleDate.canConvert(date.append(getLblMonth(div.getLblMonth().getText()))
                .append(div.getTxtCopyTo().getValue().padZeroToLeft(INDEX_2)).toRString()) || !new FlexibleDate(date.toRString()).isValid()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピー開始日"),
                    div.getTxtCopyTo()));
            return validationMessages;
        }
        date = new RStringBuilder();
        FlexibleDate 週コピーから日 = new FlexibleDate(date.append(
                getLblMonth(div.getLblMonth().getText())).append(div.getTxtCopyFrom().getValue().padZeroToLeft(INDEX_2)).toRString());
        date = new RStringBuilder();
        FlexibleDate 週コピー開始日 = new FlexibleDate(date.append(
                getLblMonth(div.getLblMonth().getText())).append(div.getTxtCopyTo().getValue().padZeroToLeft(INDEX_2)).toRString());
        if (週コピー開始日.isBeforeOrEquals(週コピーから日.plusDay(INDEX_6))) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピー開始日"),
                    div.getTxtCopyTo()));
        }
        return validationMessages;
    }

    /**
     *
     * 週コピー開始日以降予定をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 週コピー開始日以降予定チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(
                new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(DbeErrorMessages.週コピー不可),
                div.getTxtCopyFrom(), div.getTxtCopyTo()));
        return validationMessages;
    }

    /**
     *
     * 合議体未選択をチェックします。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 合議体未選択チェック() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getDgShinsakaiKaisaiYoteiIchiran().getSelectedItems().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                            UrErrorMessages.選択されていない, "開催合議体"), div.getDgKaisaiYoteiNyuryokuran()));
        }
        return new ValidationMessageControlPairs();
    }

    /**
     *
     * 審査会番号付番をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 審査会番号付番チェック(ValidationMessageControlPairs validationMessages) {
        return new ValidationMessageControlPairs();
    }

    /**
     *
     * 割付可能をチェックします。
     *
     * @param validationMessages validationMessages
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 割付可能チェック(ValidationMessageControlPairs validationMessages) {
        return new ValidationMessageControlPairs();
    }

    private boolean isAru(TextBox kaisaiGogitai, List<dgShinsakaiKaisaiGogitaiJoho_Row> dgGogitaiRowList) {
        if (!kaisaiGogitai.isDisabled() && !kaisaiGogitai.getValue().isEmpty()) {
            for (dgShinsakaiKaisaiGogitaiJoho_Row dgGogitaiRow : dgGogitaiRowList) {
                if (kaisaiGogitai.getValue().equals(dgGogitaiRow.getNumber().getText())) {
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    private void set合議体存在Message(ValidationMessageControlPairs validationMessages) {
        validationMessages.add(new ValidationMessageControlPair(
                new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                        UrErrorMessages.入力値が不正_追加メッセージあり, "合議体番号"), div.getDgKaisaiYoteiNyuryokuran()));
    }

    private void set合議体重複Message(ValidationMessageControlPairs validationMessages) {
        int index = -1;
        for (dgKaisaiYoteiNyuryokuran_Row row : div.getDgKaisaiYoteiNyuryokuran().getDataSource()) {
            index = index + 1;
            if (重複チェック4(row)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(DbeErrorMessages.重複の合議体が入力),
                        div.getDgKaisaiYoteiNyuryokuran()));
                continue;
            }
            if (重複チェック3(row)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(DbeErrorMessages.重複の合議体が入力),
                        div.getDgKaisaiYoteiNyuryokuran()));
                continue;
            }
            if (重複チェック2(row)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                                DbeErrorMessages.重複の合議体が入力), div.getDgKaisaiYoteiNyuryokuran()));
                continue;
            }
            if (重複チェック1(row)) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(
                                DbeErrorMessages.重複の合議体が入力), div.getDgKaisaiYoteiNyuryokuran()));
            }
        }
    }

    private boolean 重複チェック4(dgKaisaiYoteiNyuryokuran_Row row) {
        return !row.getKaisaiGogitai4().isDisabled() && !row.getKaisaiGogitai4().getValue().isEmpty()
                && (row.getKaisaiGogitai4().getValue().equals(row.getKaisaiGogitai1().getValue())
                || row.getKaisaiGogitai4().getValue().equals(row.getKaisaiGogitai2().getValue())
                || row.getKaisaiGogitai4().getValue().equals(row.getKaisaiGogitai3().getValue()));
    }

    private boolean 重複チェック3(dgKaisaiYoteiNyuryokuran_Row row) {
        return !row.getKaisaiGogitai3().isDisabled() && !row.getKaisaiGogitai3().getValue().isEmpty()
                && (row.getKaisaiGogitai3().getValue().equals(row.getKaisaiGogitai1().getValue())
                || row.getKaisaiGogitai3().getValue().equals(row.getKaisaiGogitai2().getValue())
                || row.getKaisaiGogitai3().getValue().equals(row.getKaisaiGogitai4().getValue()));
    }

    private boolean 重複チェック2(dgKaisaiYoteiNyuryokuran_Row row) {
        return !row.getKaisaiGogitai2().isDisabled() && !row.getKaisaiGogitai2().getValue().isEmpty()
                && (row.getKaisaiGogitai2().getValue().equals(row.getKaisaiGogitai1().getValue())
                || row.getKaisaiGogitai2().getValue().equals(row.getKaisaiGogitai3().getValue())
                || row.getKaisaiGogitai2().getValue().equals(row.getKaisaiGogitai4().getValue()));
    }

    private boolean 重複チェック1(dgKaisaiYoteiNyuryokuran_Row row) {
        return !row.getKaisaiGogitai1().isDisabled() && !row.getKaisaiGogitai1().getValue().isEmpty()
                && (row.getKaisaiGogitai1().getValue().equals(row.getKaisaiGogitai2().getValue())
                || row.getKaisaiGogitai1().getValue().equals(row.getKaisaiGogitai3().getValue())
                || row.getKaisaiGogitai1().getValue().equals(row.getKaisaiGogitai4().getValue()));
    }

    private void set予定進捗状況Message(ValidationMessageControlPairs validationMessages, RString 開催合議体,
            List<ShinsakaiKaisaiYoteiJohoParameter> shinsakaEntityList) {
        dgKaisaiYoteiNyuryokuran_Row row = div.getDgKaisaiYoteiNyuryokuran().getActiveRow();
        RDate seteibi = div.getTxtSeteibi().getValue();
        RString 開始時間 = row.getKaisaiTime().getValue().split(分割.toString()).get(0).replace(FUNN, RString.EMPTY);
        RString 終了時間 = row.getKaisaiTime().getValue().split(分割.toString()).get(1).replace(FUNN, RString.EMPTY);
        for (ShinsakaiKaisaiYoteiJohoParameter entity : shinsakaEntityList) {
            if (new RString(entity.get日付().toString()).equals(seteibi.toDateString()) && entity.get開始予定時刻().equals(開始時間)
                    && entity.get終了予定時刻().equals(終了時間) && Integer.valueOf(開催合議体.toString()) == entity.get合議体番号()
                    && !未開催.equals(entity.get介護認定審査会進捗状況())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShinsakaiKaisaiYoteiTorokuValidationHandler.ValidationMessage(DbeErrorMessages.予定中止不可),
                        div.getDgKaisaiYoteiNyuryokuran()));
            }
        }
    }

    private RString getLblMonth(RString formatMonth) {
        return formatMonth.replace(NENNDO, RString.EMPTY).replace(GETSU, RString.EMPTY);
    }

    private static final class ValidationMessage implements IValidationMessage {
//        週コピーから日が日付ではない(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピーから日"),
//        週コピー開始日が日付ではない(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピー開始日"),
//        週コピー開始日期間が不正(UrErrorMessages.入力値が不正_追加メッセージあり, "週コピー開始日"),
//        週コピー開始日以降予定が存在(DbeErrorMessages.週コピー不可),
//        合議体が未選択(UrErrorMessages.選択されていない, "開催合議体"),
//        選択の開催合議体が開催予定情報は登録されていない(DbeErrorMessages.審査会委員割付不可),
//        割付可能(DbeErrorMessages.既に開催結果が作成済で審査会委員割付不可),

        private final Message message;

        private ValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
