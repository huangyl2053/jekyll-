/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
    private static final RString 介護１ = new RString("介1");
    private static final int INT1 = 1;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会開催場所情報Div
     */
    public ShinsakaiKekkaTorokuValidationHandler(ShinsakaiKekkaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 設定期間Fromと設定期間Toの前後順チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 設定期間Fromと設定期間Toの前後順(ValidationMessageControlPairs validPairs) {
        RDate 設定期間From = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
        RDate 設定期間To = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
        if ((設定期間From == null && 設定期間To == null)
                || (設定期間From != null && 設定期間To == null)
                || (設定期間From == null && 設定期間To != null)) {
            return validPairs;
        }
        if (is設定期間(設定期間From, 設定期間To)) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, "設定期間From", "設定期間To")));
        }
        return validPairs;
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
    public ValidationMessageControlPairs 有効月数チェック(ValidationMessageControlPairs validPairs) {
        if (div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue().isNullOrEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
        return validPairs;
    }

    /**
     * 有効月数範囲チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効月数範囲チェック(ValidationMessageControlPairs validPairs) {
        Decimal ninteiKikanMonth = new Decimal(div.getKobetsuHyojiArea().getDdlNinteiKikanMonth().getSelectedValue().toString());
        if ((NinteiShinseiShinseijiKubunCode.新規申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue()))
                && !((ninteiKikanMonth.compareTo(Decimal.ONE) >= 0)
                && (ninteiKikanMonth.compareTo(new Decimal("12"))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                && !((ninteiKikanMonth.compareTo(Decimal.ONE) >= 0)
                && (ninteiKikanMonth.compareTo(new Decimal("24"))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        }
        return validPairs;
    }

    /**
     * 対象者一覧件数チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 対象者一覧件数チェック(ValidationMessageControlPairs validPairs) {
        if (div.getShinseishaIchiran().getDgTaishoshaIchiran().getDataSource().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        return validPairs;
    }

    /**
     * 入力チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック(ValidationMessageControlPairs validPairs) {
        if (介護１.equals(div.getTxtIchijiHantei().getValue())
                && div.getDdlJotaiZo().getSelectedKey().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.必須項目), div.getDdlJotaiZo()));
        }
        return validPairs;
    }

    /**
     * 認定期間チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 認定期間チェック(ValidationMessageControlPairs validPairs) {
//        if (div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue() == null) {
//            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
//                    UrErrorMessages.項目に対する制約, "認定期間・開始日", "（基準日)")));
//        }

        if (div.getKobetsuHyojiArea().getTxtShinseiDay().getValue() != null
                && div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue() != null) {
            FlexibleDate shinseiDay = div.getKobetsuHyojiArea().getTxtShinseiDay().getValue();
            RDate 基準日 = DateConverter.flexibleDateToRDate(shinseiDay);
            RDate 開始日 = div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue();
            if (基準日.compareTo(開始日) != 0) {
                validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                        UrErrorMessages.項目に対する制約, "認定期間・開始日", "（基準日)")));
            }
        }

        if (div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue() != null) {
            RYearMonth 基準年月 = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue().getYearMonth();
            RDate 当月末日 = get当月末日(基準年月);
            RDate 終了日 = div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue();
            if (当月末日.compareTo(終了日) != 0) {
                validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                        UrErrorMessages.項目に対する制約, "認定期間・終了日", "（月末日)")));
            }
        }

//        if (div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue() == null) {
//            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
//                    UrErrorMessages.項目に対する制約, "認定期間・終了日", "（月末日)")));
//        }
        return validPairs;
    }

    private RDate get当月末日(RYearMonth 基準年月) {
        return new RDate(基準年月.getYearValue(), 基準年月.getMonthValue(), INT1).plusMonth(INT1).minusDay(INT1);
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
}
