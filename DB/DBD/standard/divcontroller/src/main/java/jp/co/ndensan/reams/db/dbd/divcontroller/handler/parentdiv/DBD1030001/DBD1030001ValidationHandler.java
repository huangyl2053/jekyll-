/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdWarningMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001Div;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001.DBD1030001DivSpec;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urd.service.core.seikatsuhogo.SeikatsuhogoManagerFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 社会福祉法人等利用者負担軽減申請のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public class DBD1030001ValidationHandler {

    private static final Decimal DECIMAL_100 = new Decimal("100");
    private static final FlexibleDate FLEXIBLEDDTE_20060701 = new FlexibleDate("20060701");
    private static final FlexibleDate FLEXIBLEDDTE_20110331 = new FlexibleDate("20110331");

    /**
     * 申請日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 申請日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.申請日の非空チェック)
                .thenAdd(NoInputMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.申請日の必須入力, div.getTxtShinseiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 軽減事由の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 軽減事由の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.軽減事由の非空チェック)
                .thenAdd(NoInputMessages.軽減事由の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.軽減事由の必須入力, div.getDdlKeigenJiyu()).build().check(messages));
        return pairs;
    }

    /**
     * 確認番号の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 確認番号の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.確認番号の非空チェック)
                .thenAdd(NoInputMessages.確認番号の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.確認番号の必須入力, div.getTxtKakuninNo()).build().check(messages));
        return pairs;
    }

    /**
     * 決定区分の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定区分の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.決定区分の非空チェック)
                .thenAdd(NoInputMessages.決定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定区分の必須入力, div.getRadKetteiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 決定日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 決定日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.決定日の非空チェック)
                .thenAdd(NoInputMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.決定日の必須入力, div.getTxtKetteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 適用日の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 適用日の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.適用日の非空チェック)
                .thenAdd(NoInputMessages.適用日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.適用日の必須入力, div.getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期限の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 有効期限の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.有効期限の非空チェック)
                .thenAdd(NoInputMessages.有効期限の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.有効期限の必須入力, div.getTxtYukoKigenYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 軽減率_分子の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 軽減率_分子の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.軽減率_分子の非空チェック)
                .thenAdd(NoInputMessages.軽減率_分子の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.軽減率_分子の必須入力, div.getTxtKeigenRitsuBunshi()).build().check(messages));
        return pairs;
    }

    /**
     * 軽減率_分母の未入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 軽減率_分母の未入力チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.軽減率_分母の非空チェック)
                .thenAdd(NoInputMessages.軽減率_分母の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.軽減率_分母の必須入力, div.getTxtKeigenRitsuBunbo()).build().check(messages));
        return pairs;
    }

    /**
     * 減免減額_確認番号が既に存在チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 減免減額_確認番号が既に存在チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.減免減額_確認番号が既に存在のチェック)
                .thenAdd(NoInputMessages.減免減額_確認番号が既に存在).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_確認番号が既に存在, div.getDgShinseiList()).build().check(messages));
        return pairs;
    }

    /**
     * 減免減額_適用期間重複チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 減免減額_適用期間重複チェック(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.減免減額_適用期間重複のチェック)
                .thenAdd(NoInputMessages.減免減額_適用期間重複).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_適用期間重複, div.getDgShinseiList()).build().check(messages));
        return pairs;
    }

    /**
     * 承認情報相関チェック１を行います。
     *
     * @param pairs バリデーションコントロール
     * @param div DBD1030001Div
     */
    public void 承認情報相関チェック１(ValidationMessageControlPairs pairs, DBD1030001Div div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        FlexibleDate 適用開始日 = div.getTxtTekiyoYMD().getValue();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.減免減額_適用日が法施行前のチェック)
                .thenAdd(NoInputMessages.減免減額_適用日が法施行前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_適用日が法施行前, div.getTxtTekiyoYMD()).build().check(messages));
        IValidationMessages messages1 = ValidationMessagesFactory.createInstance();
        messages1.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.減免減額_有効期限が年度外のチェック)
                .thenAdd(NoInputMessages.減免減額_有効期限が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_有効期限が年度外, div.getTxtYukoKigenYMD()).build().check(messages1));
        IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
        messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.減免減額_有効期限が適用日以前のチェック)
                .thenAdd(NoInputMessages.減免減額_有効期限が適用日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.減免減額_有効期限が適用日以前, div.getTxtYukoKigenYMD()).build().check(messages2));
        IValidationMessages messages3 = ValidationMessagesFactory.createInstance();
        messages3.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子が分母より大のチェック)
                .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子が分母より大).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.社会福祉法人減免_減免率_分子が分母より大,
                div.getTxtKeigenRitsuBunshi()).build().check(messages3));
        IValidationMessages messages4 = ValidationMessagesFactory.createInstance();
        messages4.add(ValidateChain.validateStart(div)
                .ifNot(DBD1030001DivSpec.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択のチェック)
                .thenAdd(NoInputMessages.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択,
                div.getChkKyotakuServiceGentei(), div.getChkKyusochiUnitGataJunKoshitsu()).build().check(messages4));
        承認情報相関チェック１_15(適用開始日, div, pairs);
        IValidationMessages messages5 = ValidationMessagesFactory.createInstance();
        messages5.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.受給共通_受給者_事業対象者登録なしのチェック)
                .thenAdd(NoInputMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.受給共通_受給者_事業対象者登録なし,
                div.getTxtTekiyoYMD()).build().check(messages5));
    }

    private void 承認情報相関チェック１_15(FlexibleDate 適用開始日,
            DBD1030001Div div, ValidationMessageControlPairs pairs) {
        Decimal 減免率_分子 = div.getTxtKeigenRitsuBunshi().getValue();
        Decimal 減免率_分母 = div.getTxtKeigenRitsuBunbo().getValue();
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        FlexibleDate 制度改正施行日_平成１７年１０月改正 = get制度改正施行日_平成１７年１０月改正();
        FlexibleDate 特例措置期間開始日 = get特例措置期間開始日();
        FlexibleDate 特例措置期間終了日 = get特例措置期間終了日();
        if (!制度改正施行日_平成１７年１０月改正.isEmpty() && 適用開始日.isBefore(制度改正施行日_平成１７年１０月改正)) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子は1桁整数のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子は1桁整数).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分子は1桁整数,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages));
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は2桁整数のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は2桁整数).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は2桁整数,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages2));
        } else if (適用開始日.isBefore(FLEXIBLEDDTE_20060701)) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子は2桁整数のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子は2桁整数).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分子は2桁整数,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages));
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は100,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages2));
        } else if (特例措置期間開始日.isBeforeOrEquals(適用開始日) && !特例措置期間終了日.isEmpty() && 適用開始日.isBeforeOrEquals(特例措置期間終了日)) {
            承認情報相関チェック１_15_1(居宅サービス限定SelectKeys, div, pairs);
        } else if (!居宅サービス限定SelectKeys.isEmpty() || !旧措置ユニット型個室SelectKeys.isEmpty()) {
            承認情報相関チェック１_15_2(減免率_分母, div, pairs);
        } else {
            承認情報相関チェック１_15_3(減免率_分子, div, 適用開始日, pairs);
        }
    }

    private void 承認情報相関チェック１_15_3(Decimal 減免率_分子,
            DBD1030001Div div, FlexibleDate 適用開始日, ValidationMessageControlPairs pairs) {
        IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
        messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.社会福祉法人減免_減免率_分母は100,
                div.getTxtKeigenRitsuBunbo()).build().check(messages2));
        if (減免率_分子.compareTo(DECIMAL_100) == 0 && FLEXIBLEDDTE_20110331.isBefore(適用開始日) && is対象の被保険者が生活保護(div)) {
            IValidationMessages messages3 = ValidationMessagesFactory.createInstance();
            messages3.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_非生活保護者_軽減率100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_非生活保護者_軽減率100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_非生活保護者_軽減率100,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages3));
        } else {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子は1から99の範囲のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages));
        }
    }

    private void 承認情報相関チェック１_15_2(Decimal 減免率_分母, DBD1030001Div div, ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_軽減率_特例措置期間のチェック2)
                .thenAdd(NoInputMessages.社会福祉法人減免_軽減率_特例措置期間).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.社会福祉法人減免_軽減率_特例措置期間,
                div.getTxtKeigenRitsuBunshi()).build().check(messages));
        if (減免率_分母.compareTo(DECIMAL_100) != 0) {
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は100,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages2));
        } else {
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子は1から99の範囲のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages2));
            IValidationMessages messages3 = ValidationMessagesFactory.createInstance();
            messages3.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は100,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages3));
        }
    }

    private void 承認情報相関チェック１_15_1(
            List<RString> 居宅サービス限定SelectKeys, DBD1030001Div div, ValidationMessageControlPairs pairs) {
        if (!居宅サービス限定SelectKeys.isEmpty() || isすべてがチェックオフ(div)) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は100,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages));
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_軽減率_特例措置期間のチェック1)
                    .thenAdd(NoInputMessages.社会福祉法人減免_軽減率_特例措置期間).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_軽減率_特例措置期間,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages2));
        } else {
            IValidationMessages messages2 = ValidationMessagesFactory.createInstance();
            messages2.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分子は1から99の範囲のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分子は1から99の範囲,
                    div.getTxtKeigenRitsuBunshi()).build().check(messages2));
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div).ifNot(DBD1030001DivSpec.社会福祉法人減免_減免率_分母は100のチェック)
                    .thenAdd(NoInputMessages.社会福祉法人減免_減免率_分母は100).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    NoInputMessages.社会福祉法人減免_減免率_分母は100,
                    div.getTxtKeigenRitsuBunbo()).build().check(messages));
        }
    }

    private FlexibleDate get制度改正施行日_平成１７年１０月改正() {
        return new FlexibleDate(DbBusinessConfig.get(
                ConfigNameDBU.制度改正施行日_平成１７年１０月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
    }

    private boolean is対象の被保険者が生活保護(DBD1030001Div div) {
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        if (div.getHiddenShikibetsuCode() != null) {
            識別コード = new ShikibetsuCode(div.getHiddenShikibetsuCode());
        }
        return SeikatsuhogoManagerFactory.createInstance().get生活保護(
                識別コード, GyomuCode.DB介護保険, div.getTxtShinseiYMD().getValue()) == null;
    }

    private boolean is入力内容がある(List<RString> 入力内容) {
        return 入力内容 != null && !入力内容.isEmpty();
    }

    private boolean isすべてがチェックオフ(DBD1030001Div div) {
        List<RString> 居宅サービス限定SelectKeys = div.getChkKyotakuServiceGentei().getSelectedKeys();
        List<RString> 居居住費_食費限定SelectKeys = div.getChkKyojuhiShokuhiGentei().getSelectedKeys();
        List<RString> 旧措置ユニット型個室限定SelectKeys = div.getChkKyusochiUnitGataJunKoshitsu().getSelectedKeys();
        return is入力内容がある(居宅サービス限定SelectKeys)
                && is入力内容がある(居居住費_食費限定SelectKeys)
                && is入力内容がある(旧措置ユニット型個室限定SelectKeys);
    }

    private FlexibleDate get特例措置期間開始日() {
        return new FlexibleDate(DbBusinessConfig.get(
                ConfigNameDBD.社会福祉法人軽減_特例措置期間開始日, RDate.getNowDate(), SubGyomuCode.DBD介護受給));
    }

    private FlexibleDate get特例措置期間終了日() {
        return new FlexibleDate(DbBusinessConfig.get(
                ConfigNameDBD.社会福祉法人軽減_特例措置期間終了日, RDate.getNowDate(), SubGyomuCode.DBD介護受給));
    }

    private static enum NoInputMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "申請日"),
        軽減事由の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "軽減事由"),
        確認番号の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "確認番号"),
        決定区分の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "決定区分"),
        決定日の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "決定日"),
        適用日の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "適用日"),
        有効期限の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "有効期限"),
        軽減率_分子の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "軽減率（分子）"),
        軽減率_分母の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "軽減率（分母）"),
        給付率の必須入力(UrErrorMessages.必須項目_追加メッセージあり.getMessage(), "給付率"),
        減免減額_適用日が法施行前(DbdErrorMessages.減免減額_適用日が法施行前.getMessage()),
        減免減額_有効期限が年度外(DbdErrorMessages.減免減額_有効期限が年度外.getMessage()),
        減免減額_有効期限が適用日以前(DbdErrorMessages.減免減額_有効期限が適用日以前.getMessage()),
        社会福祉法人減免_減免率_分子が分母より大(DbdErrorMessages.社会福祉法人減免_減免率_分子が分母より大.getMessage()),
        社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択(
                DbdErrorMessages.社会福祉法人減免_居宅サービス限定と旧措置ユニット型個室限定の同時選択.getMessage()),
        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage()),
        社会福祉法人減免_減免率_分子は1桁整数(DbdErrorMessages.社会福祉法人減免_減免率_分子は1桁整数.getMessage()),
        社会福祉法人減免_減免率_分母は2桁整数(DbdErrorMessages.社会福祉法人減免_減免率_分母は2桁整数.getMessage()),
        社会福祉法人減免_減免率_分子は2桁整数(DbdErrorMessages.社会福祉法人減免_減免率_分子は2桁整数.getMessage()),
        社会福祉法人減免_減免率_分母は100(DbdErrorMessages.社会福祉法人減免_減免率_分母は100.getMessage()),
        社会福祉法人減免_減免率_分子は1から99の範囲(DbdErrorMessages.社会福祉法人減免_減免率_分子は1から99の範囲.getMessage()),
        減免減額_確認番号が既に存在(DbdErrorMessages.減免減額_確認番号が既に存在.getMessage()),
        減免減額_適用期間重複(DbdErrorMessages.減免減額_適用期間重複.getMessage()),
        社会福祉法人減免_軽減率_特例措置期間(DbdWarningMessages.社会福祉法人減免_軽減率_特例措置期間.getMessage()),
        社会福祉法人減免_非生活保護者_軽減率100(DbdWarningMessages.社会福祉法人減免_非生活保護者_軽減率100.getMessage());
        private final Message message;

        private NoInputMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
