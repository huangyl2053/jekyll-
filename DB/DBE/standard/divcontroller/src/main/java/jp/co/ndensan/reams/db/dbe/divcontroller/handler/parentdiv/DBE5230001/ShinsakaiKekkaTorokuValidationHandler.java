/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
        有効月数チェック(validationMessages);
        有効月数範囲チェック(validationMessages);
        認定期間開始チェック(validationMessages);
        認定期間終了チェック(validationMessages);
        入力チェック(validationMessages);
        設定期間Fromと設定期間Toの前後順(validationMessages);
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
        return validationMessages;
    }

    /**
     * 対象者一覧件数チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    void 対象者一覧件数チェック(ValidationMessageControlPairs validationMessages) {
        if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            validationMessages.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.該当データなし)));
        }
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
     * 有効月数チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    void 有効月数チェック(ValidationMessageControlPairs validPairs) {
        if (div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue().isNullOrEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
    }

    /**
     * 有効月数範囲チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    void 有効月数範囲チェック(ValidationMessageControlPairs validPairs) {
        Decimal ninteiKikanMonth = new Decimal(div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue().toString());
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
     * 入力チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    void 入力チェック(ValidationMessageControlPairs validPairs) {
        if (IchijiHanteiKekkaCode09.要介護1.get名称().equals(div.getTxtIchijiHantei().getValue())
                && div.getDdlJotaiZo().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.必須項目), div.getDdlJotaiZo()));
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
