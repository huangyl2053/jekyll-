/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査員マスタ画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0170-010 lijia
 */
public class ShinsakaiKekkaTorokuValidationHandler {

    private final ShinsakaiKekkaTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public ShinsakaiKekkaTorokuValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 個別入力欄への入力チェックを行います。
     *
     * @return メッセージのリスト
     */
    public ValidationMessageControlPairs validate個別() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ShinsakaiKekkaTorokuHandler handler = getHandler();

        if (handler.get判定結果() == HanteiKekkaCode.認定) {
            有効月数範囲チェック(validationMessages);
            認定期間開始チェック(validationMessages);
            認定期間終了チェック(validationMessages);
            設定期間Fromと設定期間Toの前後順(validationMessages);
        }
        return validationMessages;
    }

    /**
     * 全体部分の入力チェックを行います。
     *
     * @return メッセージのリスト
     */
    public ValidationMessageControlPairs validate全体() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        対象者一覧件数チェック(validationMessages);
        if (validationMessages.existsError()) {
            return validationMessages;
        }
        hasAnyChanges(validationMessages);
        return validationMessages;
    }

    /**
     * 対象者一覧件数チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    private void 対象者一覧件数チェック(ValidationMessageControlPairs validationMessages) {
        if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.該当データなし),
                    div.getDgTaishoshaIchiran()
            ));
        }
    }

    private void hasAnyChanges(ValidationMessageControlPairs validationMessages) {
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            if (!RString.isNullOrEmpty(row.getJotai())) {
                return;
            }
        }
        validationMessages.add(new ValidationMessageControlPair(
                new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.更新対象のデータがない),
                div.getDgTaishoshaIchiran()
        ));
    }

    /**
     * 設定期間Fromと設定期間Toの前後順チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    void 設定期間Fromと設定期間Toの前後順(ValidationMessageControlPairs validPairs) {
        RDate 設定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        RDate 設定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if ((設定期間From == null && 設定期間To == null)
                || (設定期間From != null && 設定期間To == null)
                || (設定期間From == null && 設定期間To != null)) {
            return;
        }
        if (is設定期間(設定期間From, 設定期間To)) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, "設定期間From", "設定期間To")));
        }
    }

    private boolean is設定期間(RDate 設定期間From, RDate 設定期間To) {
        return 設定期間From.isBefore(設定期間To);
    }

    /**
     * 有効月数範囲チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    void 有効月数範囲チェック(ValidationMessageControlPairs validPairs) {
        ShinsakaiKekkaTorokuHandler handler = new ShinsakaiKekkaTorokuHandler(div);
        YokaigoJotaiKubun09 yokaigodo = handler.get今回二次判定();
        if (!ShinsakaiKekkaTorokuHandler.is要支援要介護(yokaigodo)) {
            return;
        }
        RString value = div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue();
        if (RString.isNullOrEmpty(value)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.項目に対する制約, "有効月数", "1以上"),
                    div.getDdlNinteiKikanMonth()));
            return;
        }
        Decimal ninteiKikanMonth = new Decimal(value.toString());
        if ((NinteiShinseiShinseijiKubunCode.新規申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue()))
                && !((ninteiKikanMonth.compareTo(Decimal.ONE) >= 0)
                && (ninteiKikanMonth.compareTo(new Decimal(12))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                && !((ninteiKikanMonth.compareTo(Decimal.ONE) >= 0)
                && (ninteiKikanMonth.compareTo(new Decimal(24))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
    }

    /**
     * 認定期間開始チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    void 認定期間開始チェック(ValidationMessageControlPairs validPairs) {
        ShinsakaiKekkaTorokuHandler handler = getHandler();
        RDate 算出基準日 = handler.calculate算出基準日();
        RDate 認定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();

        if (算出基準日 == null || 認定期間From == null) {
            return;
        }
        if (算出基準日.equals(認定期間From)) {
            return;
        }
        validPairs.add(
                new ValidationMessageControlPair(
                        new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                                UrErrorMessages.項目に対する制約,
                                "認定期間・開始日",
                                算出基準日.wareki().toDateString().toString())));

    }

    /**
     * 認定期間終了チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    void 認定期間終了チェック(ValidationMessageControlPairs validPairs) {
        RDate 認定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        if (認定期間To == null) {
            return;
        }
        if (認定期間To.plusDay(1).getDayValue() == 1) {
            return;
        }
        validPairs.add(
                new ValidationMessageControlPair(
                        new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                                UrErrorMessages.項目に対する制約,
                                "認定期間・終了日",
                                "（月末日)")));

    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private ShinsakaiKekkaTorokuHandler getHandler() {
        return new ShinsakaiKekkaTorokuHandler(div);
    }

}
