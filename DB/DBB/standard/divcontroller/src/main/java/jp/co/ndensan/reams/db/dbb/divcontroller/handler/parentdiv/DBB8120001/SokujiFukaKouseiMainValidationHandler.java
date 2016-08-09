/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB8120001;

import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiZengoChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbWarningMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.FukakonkyoAtoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujiFukaKouseiMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.SokujikouseiKiwarigakuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM13001_2_即時賦課更正のバリデーションハンドラークラス
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiMainValidationHandler {

    private final SokujiFukaKouseiMainDiv div;
    private static final RString ZERO = new RString("0");
    private static final RString FOUR = new RString("4");
    private static final RString FIVE = new RString("5");
    private static final RString SIX = new RString("6");
    private static final RString 読点 = new RString(",");
    private static final RString コンマ = new RString("、");
    private static final RString 更正後年間保険料 = new RString("更正後年間保険料");
    private static final RString 特別徴収の更正後合計_普通徴収の更正後合計_減免額 = new RString("特別徴収の更正後合計+普通徴収の更正後合計ー減免額");
    private static final RString 特殊処理のメニューID = new RString("DBBMNC3001");
    private static final RString 左括弧 = new RString("（");
    private static final RString 右括弧 = new RString("）");
    private static final Decimal 円_３００ = new Decimal(300);

    /**
     * コンストラクタ
     *
     * @param div SokujiFukaKouseiMainDiv
     */
    public SokujiFukaKouseiMainValidationHandler(SokujiFukaKouseiMainDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @param 更正前後徴収方法 更正前後徴収方法
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate(KoseiZengoChoshuHoho 更正前後徴収方法) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        項目に対する制約チェックValidate(validPairs);
        特徴対象者でないため期別金額設定不可チェックValidate(validPairs, 更正前後徴収方法);
        特徴金額チェックValidate(validPairs);
        return validPairs;
    }

    /**
     * 更正後金額チェック（特徴）のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate特徴警告() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        RString 特別徴収_期別端数 = get業務Config(ConfigNameDBB.特別徴収_期別端数);
        RString 該当する期 = RString.EMPTY;
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo04())) {
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi04().getText(),
                    tablePanel.getLblTsuki4().getText()));
        }
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo06())) {
            該当する期 = RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi06().getText(),
                    tablePanel.getLblTsuki6().getText()));
        }
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo08())) {
            該当する期 = RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi08().getText(),
                    tablePanel.getLblTsuki8().getText()));
        }
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo10())) {
            該当する期 = RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi10().getText(),
                    tablePanel.getLblTsuki10().getText()));
        }
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo12())) {
            該当する期 = RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi12().getText(),
                    tablePanel.getLblTsuki12().getText()));
        }
        if (is期別端数不整合(特別徴収_期別端数, tablePanel.getTxtTokuchoKoseiGo02())) {
            該当する期 = RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblTokuchoKi02().getText(),
                    tablePanel.getLblTsuki2().getText()));
        }
        if (!RString.isNullOrEmpty(該当する期)) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(DbbWarningMessages.特徴期割額端数不整合,
                    該当する期.toString(), 特別徴収_期別端数.toString())));
        }
        return validPairs;
    }

    /**
     * 更正後金額チェック（普徴）のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate普徴警告() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        RString 普通徴収_期別端数 = get業務Config(ConfigNameDBB.普通徴収_期別端数);
        RString 該当する期 = RString.EMPTY;
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo04())) {
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi04().getText(),
                    tablePanel.getLblTsuki4().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo05())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi05().getText(),
                    tablePanel.getLblTsuki5().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo06())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi06().getText(),
                    tablePanel.getLblTsuki6().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo07())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi07().getText(),
                    tablePanel.getLblTsuki7().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo08())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi08().getText(),
                    tablePanel.getLblTsuki8().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo09())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi09().getText(),
                    tablePanel.getLblTsuki9().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo10())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi10().getText(),
                    tablePanel.getLblTsuki10().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo11())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi11().getText(),
                    tablePanel.getLblTsuki11().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo12())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi12().getText(),
                    tablePanel.getLblTsuki12().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo01())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi01().getText(),
                    tablePanel.getLblTsuki1().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo02())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi02().getText(),
                    tablePanel.getLblTsuki2().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGo03())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKi03().getText(),
                    tablePanel.getLblTsuki3().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGoYoku04())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKiYoku04().getText(),
                    tablePanel.getLblTsukiYoku4().getText()));
        }
        if (is期別端数不整合(普通徴収_期別端数, tablePanel.getTxtFuchoKoseiGoYoku05())) {
            該当する期 = setコンマ(該当する期);
            該当する期 = 該当する期.concat(getFormat該当する月(tablePanel.getLblFuchoKiYoku05().getText(),
                    tablePanel.getLblTsukiYoku5().getText()));
        }
        if (!RString.isNullOrEmpty(該当する期)) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(DbbWarningMessages.普徴期割額端数不整合,
                    該当する期.toString(), 普通徴収_期別端数.toString())));
        }
        return validPairs;
    }

    private void 項目に対する制約チェックValidate(ValidationMessageControlPairs validPairs) {
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        FukakonkyoAtoDiv fukakonkyoAtoDiv = div.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiFukakonkyo().getFukakonkyoAto();
        Decimal 更正後年間保険料額 = fukakonkyoAtoDiv.getTxtGemmenGaku2().getValue();
        Decimal 減免額 = div.getGemmenGakuInput().getTxtGemmenGakuInput().getValue();
        if (更正後年間保険料額.equals(getFormat金額(tablePanel.getLblTokuchoKoseiGoSum().getText()).add(getFormat金額(tablePanel.getLblFuchoKoseiGoSum().getText())).
                multiply(減免額))) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(UrErrorMessages.項目に対する制約,
                    更正後年間保険料.toString(), 特別徴収の更正後合計_普通徴収の更正後合計_減免額.toString())));
        }
    }

    private void 特徴金額チェックValidate(ValidationMessageControlPairs validPairs) {
        if (is特殊処理()) {
            return;
        }
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        Decimal 納付額_４期 = tablePanel.getTxtTokuchoKoseiGo10().getValue();
        Decimal 納付額_５期 = tablePanel.getTxtTokuchoKoseiGo12().getValue();
        Decimal 納付額_６期 = tablePanel.getTxtTokuchoKoseiGo02().getValue();
        if (納付額_４期.subtract(納付額_５期).abs().compareTo(円_３００) > 0) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴期別額不正_300円以上の差)));
        }
        if (納付額_５期.compareTo(納付額_４期) > 0) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴期別額不正_大小関係)));
        }
        if (!ZERO.equals(div.getTokuchoNofugakuValue10())
                && 納付額_４期.compareTo(Decimal.ZERO) == 0) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴期別額不正_特徴0円, FOUR.toString())));
        }
        if (!ZERO.equals(div.getTokuchoNofugakuValue12())
                && 納付額_５期.compareTo(Decimal.ZERO) == 0) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴期別額不正_特徴0円, FIVE.toString())));
        }
        if (!ZERO.equals(div.getTokuchoNofugakuValue02())
                && 納付額_６期.compareTo(Decimal.ZERO) == 0) {
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴期別額不正_特徴0円, SIX.toString())));
        }
    }

    private void 特徴対象者でないため期別金額設定不可チェックValidate(ValidationMessageControlPairs validPairs,
            KoseiZengoChoshuHoho 更正前後徴収方法) {
        if (!is特殊処理()) {
            return;
        }
        SokujikouseiKiwarigakuDiv tablePanel = div.getSokujikouseiKiwarigaku();
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法4月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo04().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi04().getText(), tablePanel.getLblTsuki4().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo04()));
        }
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法6月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo06().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi06().getText(), tablePanel.getLblTsuki6().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo06()));
        }
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法8月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo08().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi08().getText(), tablePanel.getLblTsuki8().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo08()));
        }
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法10月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo10().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi10().getText(), tablePanel.getLblTsuki10().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo10()));
        }
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法12月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo12().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi12().getText(), tablePanel.getLblTsuki12().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo12()));
        }
        if (!is特徴開始者(更正前後徴収方法.get更正後().get徴収方法2月())
                && !Decimal.ZERO.equals(tablePanel.getTxtTokuchoKoseiGo02().getValue())) {
            RString 該当する月 = getFormat該当する月(tablePanel.getLblTokuchoKi02().getText(), tablePanel.getLblTsuki2().getText());
            validPairs.add(new ValidationMessageControlPair(new SokujiFukaKouseiMainValidationMessages(
                    DbbErrorMessages.特徴対象者でないため期別金額設定不可, 該当する月.toString()), tablePanel.getTxtTokuchoKoseiGo02()));
        }
    }

    private RString setコンマ(RString 該当する期) {
        return RString.isNullOrEmpty(該当する期) ? RString.EMPTY : 該当する期.concat(コンマ);
    }

    private boolean is期別端数不整合(RString 期別端数, TextBoxNum textBoxNum) {
        if (textBoxNum.isReadOnly()
                || textBoxNum.getValue().compareTo(Decimal.ZERO) == 0
                || RString.isNullOrEmpty(期別端数)) {
            return Boolean.FALSE;
        }
        return !textBoxNum.getValue().remainder(new Decimal(期別端数.toString())).equals(Decimal.ZERO);
    }

    private Decimal getFormat金額(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return Decimal.ZERO;
        }
        return new Decimal(金額.replace(読点, RString.EMPTY).trim().toString());
    }

    private RString getFormat該当する月(RString 期, RString 月) {
        return 期.concat(左括弧).concat(月).concat(右括弧);
    }

    private boolean is特徴開始者(RString 徴収方法) {
        return ChoshuHoho.特別徴収_地共済.getコード().equals(徴収方法) || ChoshuHoho.特別徴収_厚生労働省.getコード().equals(徴収方法);
    }

    private boolean is特殊処理() {
        return 特殊処理のメニューID.equals(ResponseHolder.getMenuID());
    }

    private RString get業務Config(Enum キー名称) {
        return DbBusinessConfig.get(キー名称, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
    }

    private static class SokujiFukaKouseiMainValidationMessages implements IValidationMessage {

        private final Message message;

        SokujiFukaKouseiMainValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
