/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiShinseishaFinder;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder.NinteiShinseishaFinderDiv;
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
        if (txtKaisaiNumberStart != null && txtKaisaiNumberEnd != null) {
            if (txtKaisaiNumberEnd.compareTo(txtKaisaiNumberStart) < 0) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.大小関係が不正,
                                txtKaisaiNumberStart.toString()),
                        div.getTxtKaisaiNumberStart()));
            }
        }
        Decimal fromValue = div.getTxtShinseiKeikaNissu().getFromValue();
        Decimal toValue = div.getTxtShinseiKeikaNissu().getToValue();
        if (fromValue != null && toValue != null) {
            if (toValue.compareTo(fromValue) < 0) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.大小関係が不正,
                                fromValue.toString()),
                        div.getTxtShinseiKeikaNissu()));
            }
        }
        validPairs.add(checkNowPhase());
        return validPairs;
    }

    private ValidationMessageControlPairs checkTextBoxFlexibleDate(TextBoxFlexibleDate From, TextBoxFlexibleDate To) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        FlexibleDate txtNinteiShinseiDateFrom = From.getValue();
        FlexibleDate txtNinteiShinseiDateTo = To.getValue();
        if (txtNinteiShinseiDateFrom != null && txtNinteiShinseiDateTo != null) {
            if (txtNinteiShinseiDateTo.isBefore(txtNinteiShinseiDateFrom)) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrWarningMessages.日付の前後関係逆転以降,
                                txtNinteiShinseiDateFrom.toString(),
                                txtNinteiShinseiDateTo.toString()),
                        From, To));
            }
        }
        return validPairs;
    }

    private ValidationMessageControlPairs checkNowPhase() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getDdlNowPhase().getSelectedKey())) {
            List<KeyValueDataSource> chkShinseiUketsuke = div.getChkShinseiUketsuke().getDataSource();
            List<KeyValueDataSource> chkChosaIrai = div.getChkChosaIrai().getDataSource();
            List<KeyValueDataSource> chkIkenshoIrai = div.getChkIkenshoIrai().getDataSource();
            List<KeyValueDataSource> chkChosaNyushu = div.getChkChosaNyushu().getDataSource();
            List<KeyValueDataSource> chkIkenshoNyushu = div.getChkIkenshoNyushu().getDataSource();
            List<KeyValueDataSource> chkIchijiHantei = div.getChkIchijiHantei().getDataSource();
            List<KeyValueDataSource> chkMasking = div.getChkMasking().getDataSource();
            List<KeyValueDataSource> chkShinsakaiToroku = div.getChkShinsakaiToroku().getDataSource();
            List<KeyValueDataSource> chkNijiHantei = div.getChkNijiHantei().getDataSource();
            List<KeyValueDataSource> chkGetsureiShori = div.getChkGetsureiShori().getDataSource();
            if (isMiKanryo(chkShinseiUketsuke) && (isKanryo(chkChosaIrai) || isKanryo(chkIkenshoIrai)
                    || isKanryo(chkChosaNyushu)
                    || isKanryo(chkIkenshoNyushu)
                    || isKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "申請受付状態"),
                        div.getChkShinseiUketsuke()));
            }
            if (isKanryo(chkShinseiUketsuke) && isMiKanryo(chkChosaIrai) && (isKanryo(chkIkenshoIrai)
                    || isKanryo(chkChosaNyushu)
                    || isKanryo(chkIkenshoNyushu)
                    || isKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "調査依頼状態"),
                        div.getChkChosaIrai()));
            }
            if (isKanryo(chkShinseiUketsuke) && isMiKanryo(chkIkenshoIrai)
                    && (isKanryo(chkChosaNyushu)
                    || isKanryo(chkIkenshoNyushu)
                    || isKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "意見書依頼状態"),
                        div.getChkIkenshoIrai()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkChosaIrai)
                    && isMiKanryo(chkChosaNyushu)
                    && (isKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "調査入手状態"),
                        div.getChkChosaNyushu()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkIkenshoIrai)
                    && isMiKanryo(chkIkenshoNyushu)
                    && (isKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "意見書入手状態"),
                        div.getChkIkenshoNyushu()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkChosaIrai) && isKanryo(chkIkenshoIrai)
                    && isKanryo(chkChosaNyushu)
                    && isKanryo(chkIkenshoNyushu)
                    && (isMiKanryo(chkIchijiHantei)
                    || isKanryo(chkMasking)
                    || isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "一次判定状態"),
                        div.getChkIchijiHantei()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkChosaIrai) && isKanryo(chkIkenshoIrai)
                    && isKanryo(chkChosaNyushu)
                    && isKanryo(chkIkenshoNyushu)
                    && isKanryo(chkIchijiHantei)
                    && isMiKanryo(chkMasking)
                    && (isKanryo(chkShinsakaiToroku)
                    || isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "マスキング状態"),
                        div.getChkMasking()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkChosaIrai) && isKanryo(chkIkenshoIrai)
                    && isKanryo(chkChosaNyushu)
                    && isKanryo(chkIkenshoNyushu)
                    && isKanryo(chkIchijiHantei)
                    && isKanryo(chkMasking)
                    && isMiKanryo(chkShinsakaiToroku)
                    && (isKanryo(chkNijiHantei)
                    || isKanryo(chkGetsureiShori))) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "審査会登録状態"),
                        div.getChkShinsakaiToroku()));
            }
            if (isKanryo(chkShinseiUketsuke) && isKanryo(chkChosaIrai) && isKanryo(chkIkenshoIrai)
                    && isKanryo(chkChosaNyushu)
                    && isKanryo(chkIkenshoNyushu)
                    && isKanryo(chkIchijiHantei)
                    && isKanryo(chkMasking)
                    && isKanryo(chkShinsakaiToroku)
                    && isMiKanryo(chkNijiHantei)
                    && isKanryo(chkGetsureiShori)) {
                validPairs.add(new ValidationMessageControlPair(
                        new IdocheckMessages(UrErrorMessages.存在しない,
                                "二次判定状態"),
                        div.getChkNijiHantei()));
            }
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
