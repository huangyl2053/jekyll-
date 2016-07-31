/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.shokanbaraika1go.ShokanBaraiKa1Go;

import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【共有子Div】 1号償還払い化ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-041 mawy
 */
public class ShokanBaraiKa1GoValidationHandler {

    private final RString _１号予告者登録 = new RString("１号予告者登録");
    private final RString 償還払い化登録 = new RString("償還払い化登録");
    private final RString 償還払い化終了申請 = new RString("償還払い化終了申請");
    private final RString _１号弁明書受理 = new RString("１号弁明書受理");
    private final RString 新規登録 = new RString("新規登録");

    /**
     * 1号償還払い化ダイアログの滞納状況情報チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @param shiharaiHohoHenko 支払方法変更管理業務概念
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor滞納状況情報(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div, ShiharaiHohoHenko shiharaiHohoHenko) {
        if (div.getShinkiKubun().equals(新規登録)) {
            if ((div.getKey_Button().equals(_１号予告者登録) || div.getKey_Button().equals(償還払い化登録))
                    && div.getTainoHanteiKekka().isEmpty()) {
                pairs.add(new ValidationMessageControlPair(ShokanBaraiKa1GoMessages.支払方法変更_要滞納状況確定));
            }
        } else {
            if ((div.getKey_Button().equals(_１号予告者登録) || div.getKey_Button().equals(償還払い化登録))
                    && (shiharaiHohoHenko.getShiharaiHohoHenkoTainoList().isEmpty() || div.getTainoHanteiKekka().isEmpty())) {
                pairs.add(new ValidationMessageControlPair(ShokanBaraiKa1GoMessages.支払方法変更_要滞納状況確定));
            }
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの適用期間チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請) || div.getKey_Button().equals(償還払い化登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.適用期間チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.期間が不正_追加メッセージあり2).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.期間が不正_追加メッセージあり2,
                    div.getTxtTekiyoKikanKaishi()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの弁明受付日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明受付日入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_１号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.弁明受付日入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.弁明受付日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.弁明受付日未入力,
                    div.getTxtBemmeiUketsukeYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの弁明内容決定日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明内容決定日入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_１号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.弁明内容決定日入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.弁明内容決定日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.弁明内容決定日未入力,
                    div.getTxtBemmeiNaiyoKetteiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの適用期間(終了)入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間終了入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.適用期間終了入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.適用期間終了未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.適用期間終了未入力,
                    div.getTxtTekiyoKikanShuryo()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの申請受付日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請受付日入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.申請受付日入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.申請受付日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.申請受付日未入力,
                    div.getTxtShinseiUketsukeYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの申請日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請日入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.申請日入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.申請日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.申請日未入力,
                    div.getTxtShinseiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの申請内容決定日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請内容決定日入力チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.申請内容決定日入力チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.申請内容決定日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.申請内容決定日未入力,
                    div.getTxtShinseiNaiyoKetteiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの弁明審査結果選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明審査結果選択チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_１号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.弁明審査結果選択チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.弁明審査結果未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.弁明審査結果未選択,
                    div.getDdlBemmeiShinsaKekka()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの弁明理由選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明理由選択チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_１号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.弁明理由選択チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.弁明理由未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.弁明理由未選択,
                    div.getDdlBemmeiRiyu()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの申請審査結果選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請審査結果選択チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.申請審査結果選択チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.申請審査結果未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.申請審査結果未選択,
                    div.getDdlShinseiShinsaKekka()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの申請理由選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor申請理由選択チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.申請理由選択チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.申請理由未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.申請理由未選択,
                    div.getDdlShinseiRiyu()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 1号償還払い化ダイアログの終了状況選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor終了状況選択チェック(ValidationMessageControlPairs pairs, ShokanBaraiKa1GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(償還払い化終了申請)) {
            messages.add(ValidateChain.validateStart(div).ifNot(ShokanBaraiKa1GoDivSpec.終了状況選択チェック)
                    .thenAdd(ShokanBaraiKa1GoMessages.終了状況未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    ShokanBaraiKa1GoMessages.終了状況未選択,
                    div.getDdlShuryoJokyo()).build().check(messages));
        }
        return pairs;
    }

    private static enum ShokanBaraiKa1GoMessages implements IValidationMessage {

        支払方法変更_要滞納状況確定(DbdErrorMessages.支払方法変更_要滞納状況確定),
        期間が不正_追加メッセージあり2(UrErrorMessages.期間が不正_追加メッセージあり２, "適用期間(開始)", "適用期間(終了)"),
        弁明受付日未入力(UrErrorMessages.未入力, "弁明受付日"),
        弁明内容決定日未入力(UrErrorMessages.未入力, "弁明内容決定日"),
        適用期間終了未入力(UrErrorMessages.未入力, "適用期間(終了)"),
        申請受付日未入力(UrErrorMessages.未入力, "申請受付日"),
        申請日未入力(UrErrorMessages.未入力, "申請日"),
        申請内容決定日未入力(UrErrorMessages.未入力, "申請内容決定日"),
        弁明審査結果未選択(UrErrorMessages.選択されていない, "弁明審査結果"),
        弁明理由未選択(UrErrorMessages.選択されていない, "弁明理由"),
        終了状況未選択(UrErrorMessages.選択されていない, "終了状況"),
        申請審査結果未選択(UrErrorMessages.選択されていない, "申請審査結果"),
        申請理由未選択(UrErrorMessages.選択されていない, "申請理由");
        private final Message message;

        private ShokanBaraiKa1GoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }
}
