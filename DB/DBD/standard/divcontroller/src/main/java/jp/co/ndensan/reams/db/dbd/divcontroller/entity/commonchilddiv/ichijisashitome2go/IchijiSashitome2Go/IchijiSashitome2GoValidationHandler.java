/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ichijisashitome2go.IchijiSashitome2Go;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 【共有子Div】 2号一時差止ダイアログのハンドラクラスです。
 *
 * @reamsid_L DBD-3620-045 panxiaobo
 */
public class IchijiSashitome2GoValidationHandler {

    private final RString 新規登録 = new RString("新規登録");
    private final RString _２号一時差止登録 = new RString("２号一時差止登録");
    private final RString _２号予告者登録 = new RString("２号予告者登録");
    private final RString _２号一時差止解除 = new RString("２号一時差止解除");
    private final RString _２号弁明書受理 = new RString("２号弁明書受理");

    /**
     * 2号一時差止ダイアログの依頼受理日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼受理日入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号予告者登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼受理日入力チェック)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼受理日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼受理日未入力,
                    div.getTxtNigoYokokushaTorokuIraiJuribi()).build().check(messages));

        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの予告登録日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor予告登録日入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号予告者登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼受理日入力チェック)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.予告登録日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.予告登録日未入力,
                    div.getTxtNigoYokokushaTorokuIraiJuribi()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明書提出期限入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div ShokanBaraiKa1GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明書提出期限入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号予告者登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.弁明書提出期限入力チェック)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明書提出期限未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明書提出期限未入力,
                    div.getTxtBemmeishoTeishutsuKigenYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明審査結果選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明審査結果選択チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.弁明審査結果選択チェック)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明審査結果未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明審査結果未選択,
                    div.getDdlNigoBenmeishoJuriBenmeiShinsakekka()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明受付日入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明受付日入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.弁明受付日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明受付日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明受付日未入力,
                    div.getTxtNigoBenmeishoJuriBenmeishoUketsukebi()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明理由選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明理由選択チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.弁明理由未選択)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明理由未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明理由未選択,
                    div.getDdlNigoBenmeishoJuriBenmeiRiyu()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明内容決定日未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor弁明内容決定日未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号弁明書受理)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.弁明内容決定日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明内容決定日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.弁明内容決定日未入力,
                    div.getTxtBemmeiNaiyoKetteiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの弁明内容決定日未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間開始未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.適用期間開始未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間開始未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間開始未入力,
                    div.getTxtTekiyoKaishi()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの差止決定日未入力未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor差止決定日未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.差止決定日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.差止決定日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.差止決定日未入力,
                    div.getTxtSashitomeKetteiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの差止決定日未入力未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor保険証提出期限未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止登録)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.保険証提出期限未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.保険証提出期限未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.保険証提出期限未入力,
                    div.getTxtHokenshaTeishutsuKigenYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの適用期間チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止登録) || div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.適用期間チェック)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間チェック).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間チェック,
                    div.getTxtTekiyoKaishi()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの依頼審査結果未選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼審査結果未選択チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼審査結果未選択)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼審査結果未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼審査結果未選択,
                    div.getDdlIraiShinsaKekka()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの適用期間終了未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor適用期間終了未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.適用期間終了未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間終了未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.適用期間終了未入力,
                    div.getTxtTekiyoShuryo()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの終了状況未選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor終了状況未選択チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.終了状況未選択)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.終了状況未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.終了状況未選択,
                    div.getDdlShuryoJokyo()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの依頼受付日未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼受付日未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼受付日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼受付日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼受付日未入力,
                    div.getTxtIraiUketsukeYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの依頼日未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼日未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼日未入力,
                    div.getTxtIraiYMD()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの依頼理由未選択チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼理由未選択チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼理由未選択)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼理由未選択).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼理由未選択,
                    div.getDdlIraiRiyu()).build().check(messages));
        }
        return pairs;
    }

    /**
     * 2号一時差止ダイアログの依頼内容決定日未入力チェック。
     *
     * @param pairs バリデーションコントロール
     * @param div IchijiSashitome2GoDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor依頼内容決定日未入力チェック(ValidationMessageControlPairs pairs, IchijiSashitome2GoDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (div.getKey_Button().equals(_２号一時差止解除)) {
            messages.add(ValidateChain.validateStart(div).ifNot(IchijiSashitome2GoDivSpec.依頼内容決定日未入力)
                    .thenAdd(IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼内容決定日未入力).messages());
            pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                    IchijiSashitome2GoValidationHandler.IchijiSashitome2GoMessages.依頼内容決定日未入力,
                    div.getTxtIraiNaiyoKetteiYMD()).build().check(messages));
        }
        return pairs;
    }

    private static enum IchijiSashitome2GoMessages implements IValidationMessage {

        期間が不正_追加メッセージあり2(UrErrorMessages.期間が不正_追加メッセージあり２, "適用期間(開始)", "適用期間(終了)"),
        依頼受理日未入力(UrErrorMessages.未入力, "依頼受理日"),
        予告登録日未入力(UrErrorMessages.未入力, "予告登録日"),
        弁明書提出期限未入力(UrErrorMessages.未入力, "弁明書提出期限"),
        弁明審査結果未選択(UrErrorMessages.選択されていない, "弁明審査結果"),
        弁明受付日未入力(UrErrorMessages.未入力, "弁明受付日"),
        弁明理由未選択(UrErrorMessages.選択されていない, "弁明理由"),
        弁明内容決定日未入力(UrErrorMessages.未入力, "弁明内容決定日"),
        適用期間開始未入力(UrErrorMessages.未入力, "適用期間(開始)"),
        差止決定日未入力(UrErrorMessages.未入力, "差止決定日"),
        保険証提出期限未入力(UrErrorMessages.未入力, "保険証提出期限"),
        適用期間チェック(UrErrorMessages.期間が不正_追加メッセージあり２, "適用期間(開始)", "適用期間(終了)"),
        依頼審査結果未選択(UrErrorMessages.選択されていない, "依頼審査結果"),
        適用期間終了未入力(UrErrorMessages.未入力, "適用期間(終了)"),
        終了状況未選択(UrErrorMessages.選択されていない, "終了状況"),
        依頼受付日未入力(UrErrorMessages.未入力, "依頼受付日"),
        依頼日未入力(UrErrorMessages.未入力, "依頼日"),
        依頼理由未選択(UrErrorMessages.選択されていない, "依頼理由"),
        依頼内容決定日未入力(UrErrorMessages.未入力, "依頼内容決定日");
        private final Message message;

        private IchijiSashitome2GoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }

    }

}
