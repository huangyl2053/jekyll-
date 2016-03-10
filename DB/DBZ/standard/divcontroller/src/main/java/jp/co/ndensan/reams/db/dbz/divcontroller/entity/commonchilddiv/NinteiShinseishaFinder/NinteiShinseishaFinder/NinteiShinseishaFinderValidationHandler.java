/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;

import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 共有子Div「条件検索画面」のValidationHandlerクラスです。
 */
public class NinteiShinseishaFinderValidationHandler {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private final NinteiShinseishaFinderDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 条件検索画面div
     */
    public NinteiShinseishaFinderValidationHandler(NinteiShinseishaFinderDiv div) {
        this.div = div;
    }

    /**
     * バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtNinteiShinseiDateFrom(), div.getTxtNinteiShinseiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtBirthDateFrom(), div.getTxtBirthDateTO()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtChosaJisshiDateFrom(), div.getTxtChosaJisshiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtIkenshoKinyuDateFrom(), div.getTxtIkenshoKinyuDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtIchijiHanteiDateFrom(), div.getTxtIchijiHanteiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtIchiGoHanteiDateFrom(), div.getTxtIchiGoHanteiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtNinteiYukoKaishiDateFrom(), div.getTxtNinteiYukoKaishiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtNinteiYukoShuryoDateFrom(), div.getTxtNinteiYukoShuryoDate()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtNijiHanteiDateFrom(), div.getTxtNijiHnateiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtKaisaiDateFrom(), div.getTxtKaisaiDateTo()));
        validPairs.add(checkTextBoxFlexibleDate(div.getTxtZenkaiYukoKaishiDateFrom(), div.getTxtZenkaiYukoKaishiDateTo()));
        RString txtKaisaiNumberStart = div.getTxtKaisaiNumberStart().getValue();
        RString txtKaisaiNumberEnd = div.getTxtKaisaiNumberEnd().getValue();
        if (txtKaisaiNumberStart != null && txtKaisaiNumberEnd != null
                && txtKaisaiNumberEnd.compareTo(txtKaisaiNumberStart) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.大小関係が不正,
                            txtKaisaiNumberStart.toString()),
                    div.getTxtKaisaiNumberStart()));
        }
        Decimal fromValue = div.getTxtShinseiKeikaNissu().getFromValue();
        Decimal toValue = div.getTxtShinseiKeikaNissu().getToValue();
        if (fromValue != null && toValue != null && toValue.compareTo(fromValue) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.大小関係が不正,
                            fromValue.toString()),
                    div.getTxtShinseiKeikaNissu()));
        }
        validPairs.add(checkNowPhase());
        return validPairs;
    }

    private ValidationMessageControlPairs checkTextBoxFlexibleDate(TextBoxFlexibleDate from, TextBoxFlexibleDate to) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        FlexibleDate txtNinteiShinseiDateFrom = from.getValue();
        FlexibleDate txtNinteiShinseiDateTo = to.getValue();
        if (txtNinteiShinseiDateFrom != null && !FlexibleDate.EMPTY.equals(txtNinteiShinseiDateFrom)
                && txtNinteiShinseiDateTo != null && !FlexibleDate.EMPTY.equals(txtNinteiShinseiDateTo)
                && txtNinteiShinseiDateTo.isBefore(txtNinteiShinseiDateFrom)) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrWarningMessages.日付の前後関係逆転以降,
                            txtNinteiShinseiDateFrom.toString(),
                            txtNinteiShinseiDateTo.toString()),
                    from, to));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkNowPhase() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getDdlNowPhase().getSelectedKey())) {
            validPairs.add(checkShinseiUketsuke());
            validPairs.add(checkChosaIrai());
            validPairs.add(checkIkenshoIrai());
            validPairs.add(checkChosaNyushu());
            validPairs.add(checkIkenshoNyushu());
            validPairs.add(checkIchijiHantei());
            validPairs.add(checkMasking());
            validPairs.add(checkShinsakaiToroku());
            validPairs.add(checkNijiHantei());
        }

        return validPairs;
    }

    private ValidationMessageControlPairs checkShinseiUketsuke() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isMiKanryo(div.getChkShinseiUketsuke().getDataSource())
                && (isKanryo(div.getChkChosaIrai().getDataSource())
                || isKanryo(div.getChkIkenshoIrai().getDataSource())
                || isKanryo(div.getChkChosaNyushu().getDataSource())
                || isKanryo(div.getChkIkenshoNyushu().getDataSource())
                || isKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "申請受付状態"),
                    div.getChkShinseiUketsuke()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkChosaIrai() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isMiKanryo(div.getChkChosaIrai().getDataSource())
                && (isKanryo(div.getChkIkenshoIrai().getDataSource())
                || isKanryo(div.getChkChosaNyushu().getDataSource())
                || isKanryo(div.getChkIkenshoNyushu().getDataSource())
                || isKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "調査依頼状態"),
                    div.getChkChosaIrai()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkIkenshoIrai() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isMiKanryo(div.getChkIkenshoIrai().getDataSource())
                && (isKanryo(div.getChkChosaNyushu().getDataSource())
                || isKanryo(div.getChkIkenshoNyushu().getDataSource())
                || isKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "意見書依頼状態"),
                    div.getChkIkenshoIrai()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkChosaNyushu() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkChosaIrai().getDataSource())
                && isMiKanryo(div.getChkChosaNyushu().getDataSource())
                && (isKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "調査入手状態"),
                    div.getChkChosaNyushu()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkIkenshoNyushu() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkIkenshoIrai().getDataSource())
                && isMiKanryo(div.getChkIkenshoNyushu().getDataSource())
                && (isKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "意見書入手状態"),
                    div.getChkIkenshoNyushu()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkIchijiHantei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkChosaIrai().getDataSource())
                && isKanryo(div.getChkIkenshoIrai().getDataSource())
                && isKanryo(div.getChkChosaNyushu().getDataSource())
                && isKanryo(div.getChkIkenshoNyushu().getDataSource())
                && (isMiKanryo(div.getChkIchijiHantei().getDataSource())
                || isKanryo(div.getChkMasking().getDataSource())
                || isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "一次判定状態"),
                    div.getChkIchijiHantei()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkMasking() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkChosaIrai().getDataSource())
                && isKanryo(div.getChkIkenshoIrai().getDataSource())
                && isKanryo(div.getChkChosaNyushu().getDataSource())
                && isKanryo(div.getChkIkenshoNyushu().getDataSource())
                && isKanryo(div.getChkIchijiHantei().getDataSource())
                && isMiKanryo(div.getChkMasking().getDataSource())
                && (isKanryo(div.getChkShinsakaiToroku().getDataSource())
                || isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "マスキング状態"),
                    div.getChkMasking()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkShinsakaiToroku() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkChosaIrai().getDataSource())
                && isKanryo(div.getChkIkenshoIrai().getDataSource())
                && isKanryo(div.getChkChosaNyushu().getDataSource())
                && isKanryo(div.getChkIkenshoNyushu().getDataSource())
                && isKanryo(div.getChkIchijiHantei().getDataSource())
                && isKanryo(div.getChkMasking().getDataSource())
                && isMiKanryo(div.getChkShinsakaiToroku().getDataSource())
                && (isKanryo(div.getChkNijiHantei().getDataSource())
                || isKanryo(div.getChkGetsureiShori().getDataSource()))) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "審査会登録状態"),
                    div.getChkShinsakaiToroku()));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkNijiHantei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (isKanryo(div.getChkShinseiUketsuke().getDataSource())
                && isKanryo(div.getChkChosaIrai().getDataSource())
                && isKanryo(div.getChkIkenshoIrai().getDataSource())
                && isKanryo(div.getChkChosaNyushu().getDataSource())
                && isKanryo(div.getChkIkenshoNyushu().getDataSource())
                && isKanryo(div.getChkIchijiHantei().getDataSource())
                && isKanryo(div.getChkMasking().getDataSource())
                && isKanryo(div.getChkShinsakaiToroku().getDataSource())
                && isMiKanryo(div.getChkNijiHantei().getDataSource())
                && isKanryo(div.getChkGetsureiShori().getDataSource())) {
            validPairs.add(new ValidationMessageControlPair(
                    new IdocheckMessages(UrErrorMessages.存在しない,
                            "二次判定状態"),
                    div.getChkNijiHantei()));
        }
        return validPairs;
    }

    private boolean isKanryo(List<KeyValueDataSource> dataSource) {
        for (KeyValueDataSource keyValueDataSource : dataSource) {
            if (KEY0.equals(keyValueDataSource.getKey()) && !KEY1.equals(keyValueDataSource.getKey())) {
                return true;
            }
        }
        return false;
    }

    private boolean isMiKanryo(List<KeyValueDataSource> dataSource) {
        for (KeyValueDataSource keyValueDataSource : dataSource) {
            if (KEY1.equals(keyValueDataSource.getKey()) && !KEY0.equals(keyValueDataSource.getKey())) {
                return true;
            }
        }
        return false;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
