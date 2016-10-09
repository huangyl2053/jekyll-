/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1040001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001.TokuteiNyushoServiceHiShinseiPanelDivSpec;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 特別地域加算減免申請のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokuteiNyushoServiceHiShinseiValidationHandler {

    /**
     * 申請日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請日の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.申請日の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.申請日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.申請日の必須入力, div.getShinseiDetail().getTxtShinseiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 決定区分の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定区分の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.決定区分の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.決定区分の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.決定区分の必須入力, div.getShinseiDetail().getRadKettaiKubun()).build().check(messages));
        return pairs;
    }

    /**
     * 決定日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor決定日の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.決定日の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.決定日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.決定日の必須入力, div.getShinseiDetail().getTxtKettaiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 適用日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用日の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.適用日の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.適用日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.適用日の必須入力, div.getShinseiDetail().getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 有効期限の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor有効期限の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.有効期限の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.有効期限の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.有効期限の必須入力, div.getShinseiDetail().getTxtYukoKigenYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 軽減率の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div RiyoshaFutangakuGengakuPanelDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor軽減率の必須入力(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.軽減率の非空チェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.軽減率の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.軽減率の必須入力, div.getShinseiDetail().getTxtKeigenRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 特別地域加算減免_適用開始日が法施行以前のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特別地域加算減免_適用開始日が法施行以前(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.特別地域加算減免_適用日が法施行以前のチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.減免減額_適用日が法施行前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.減免減額_適用日が法施行前, div.getShinseiDetail().getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 特別地域加算減免_適用終了日が年度外のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特別地域加算減免_適用終了日が年度外(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.特別地域加算減免_適用終了日が年度外のチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.減免減額_有効期限が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.減免減額_有効期限が年度外, div.getShinseiDetail().getTxtYukoKigenYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 特別地域加算減免_適用終了日が開始日以前のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特別地域加算減免_適用終了日が開始日以前(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.特別地域加算減免_適用終了日が開始日以前のチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.減免減額_有効期限が適用日以前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.減免減額_有効期限が適用日以前, div.getShinseiDetail().getTxtYukoKigenYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 特別地域加算減免_減免減額_確認番号が重複のチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特別地域加算減免_減免減額_確認番号が重複(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.減免減額_確認番号が重複のチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.減免減額_確認番号が既に存在).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.減免減額_確認番号が既に存在, div.getShinseiDetail().getTxtKakuninNo()).build().check(messages));
        return pairs;
    }

    /**
     * 特別地域加算減免_軽減率範囲外チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特別地域加算減免_軽減率範囲外(ValidationMessageControlPairs pairs, TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.特別地域加算減免_軽減率範囲外のチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.特別地域加算減免_軽減率範囲外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.特別地域加算減免_軽減率範囲外, div.getShinseiDetail().getTxtKeigenRitsu()).build().check(messages));
        return pairs;
    }

    /**
     * 受給共通_受給者登録なしのチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor受給共通_受給者登録なし(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.受給共通_受給者登録なしのチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.受給共通_受給者_事業対象者登録なし, div.getShinseiDetail().getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 適用期間重複なしのチェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div TokuteiNyushoServiceHiShinseiDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間重複なし(ValidationMessageControlPairs pairs,
            TokuteiNyushoServiceHiShinseiDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(TokuteiNyushoServiceHiShinseiPanelDivSpec.適用期間重複なしのチェック)
                .thenAdd(TokuteiNyushoServiceHiShinseiMessages.減免減額_適用期間重複).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                TokuteiNyushoServiceHiShinseiMessages.減免減額_適用期間重複, div.getShinseiList().getDgShinseiList()).build().check(messages));
        return pairs;
    }

    private static enum TokuteiNyushoServiceHiShinseiMessages implements IValidationMessage {

        申請日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "申請日"),
        決定区分の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定区分"),
        決定日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "決定日"),
        適用日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "適用日"),
        有効期限の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "有効期限"),
        軽減率の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "給付率"),
        特別地域加算減免_軽減率範囲外(DbdErrorMessages.特別地域加算減免_軽減率範囲外),
        減免減額_適用日が法施行前(DbdErrorMessages.減免減額_適用日が法施行前),
        減免減額_有効期限が年度外(DbdErrorMessages.減免減額_有効期限が年度外),
        減免減額_有効期限が適用日以前(DbdErrorMessages.減免減額_有効期限が適用日以前),
        減免減額_確認番号が既に存在(DbdErrorMessages.減免減額_確認番号が既に存在),
        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし),
        減免減額_適用期間重複(DbdErrorMessages.減免減額_適用期間重複);

        private final Message message;

        private TokuteiNyushoServiceHiShinseiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
