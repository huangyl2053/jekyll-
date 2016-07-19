/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.ShinsakaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
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
    private static final RString 介護１ = new RString("介護１");

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
        if (div.getKobetsuHyojiArea().getTxtNinteiKikanTo().getValue()
                .isBefore(div.getKobetsuHyojiArea().getTxtNinteiKikanFrom().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, "設定期間From", "設定期間To")));
        }
        return validPairs;
    }

    /**
     * 有効月数チェック
     *
     * @param validPairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 有効月数チェック(ValidationMessageControlPairs validPairs) {
        if (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ZERO) == 0
                || div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue() == null) {
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
        if ((NinteiShinseiShinseijiKubunCode.新規申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                || NinteiShinseiShinseijiKubunCode.区分変更申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue()))
                && !((div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ONE) >= 0)
                && (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(new Decimal("12"))) <= 0)) {
            validPairs.add(new ValidationMessageControlPair(
                    new ShinsakaiKekkaTorokuValidationHandler.IdocheckMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "有効月数")));
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.get名称().equals(div.getKobetsuHyojiArea().getTxtShinseiKubunShinseiji().getValue())
                && !((div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(Decimal.ONE) >= 0)
                && (div.getKobetsuHyojiArea().getTxtNinteiKikanMonth().getValue().compareTo(new Decimal("24"))) <= 0)) {
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
