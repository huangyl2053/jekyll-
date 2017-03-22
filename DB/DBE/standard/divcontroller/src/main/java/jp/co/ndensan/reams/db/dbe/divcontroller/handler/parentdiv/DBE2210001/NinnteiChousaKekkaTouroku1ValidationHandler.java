/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1DivSpec;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoServiceJyokyo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録1のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1ValidationHandler {

    /**
     * 調査実施日の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor調査実施日の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.調査実施日の非空チェック)
                .thenAdd(NoInputMessages.調査実施日の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.調査実施日の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate()).build().check(messages));
        return pairs;
    }

    /**
     * 調査実施日の妥当性入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor調査実施日の妥当性入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.調査実施日の妥当性チェック)
                .thenAdd(NoInputMessages.調査実施日の妥当性入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.調査実施日の妥当性入力,
                div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate()).build().check(messages));
        return pairs;
    }

    /**
     * 実施場所の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor実施場所の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.実施場所の非空チェック)
                .thenAdd(NoInputMessages.実施場所の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.実施場所の必須入力,
                div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho()).build().check(messages));
        return pairs;
    }

    /**
     * 実施場所名称の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor実施場所名称の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.実施場所名称の非空チェック)
                .thenAdd(NoInputMessages.実施場所名称の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.実施場所名称の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho()).build().check(messages));
        return pairs;
    }

    /**
     * 所属機関の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor所属機関の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.所属機関の非空チェック)
                .thenAdd(NoInputMessages.所属機関の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.所属機関の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode()).build().check(messages));
        return pairs;
    }

    /**
     * 記入者の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor記入者の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.記入者の非空チェック)
                .thenAdd(NoInputMessages.記入者の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.記入者の必須入力,
                div.getCcdChosaJisshishaJoho().getTxtKinyushaCode()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第1群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第1群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第1群の非空チェック)
                .thenAdd(NoInputMessages.第1群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第1群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa1()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第2群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第2群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第2群の非空チェック)
                .thenAdd(NoInputMessages.第2群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第2群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa2()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第3群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第3群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第3群の非空チェック)
                .thenAdd(NoInputMessages.第3群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第3群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa3()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第4群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第4群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第4群の非空チェック)
                .thenAdd(NoInputMessages.第4群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第4群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa4()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の第5群の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor第5群の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.第5群の非空チェック)
                .thenAdd(NoInputMessages.第5群の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.第5群の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa5()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の生活自立度の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor生活自立度の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.生活自立度の非空チェック)
                .thenAdd(NoInputMessages.生活自立度の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.生活自立度の必須入力,
                div.getTplKihonChosa().getBtnKihonchosa7()).build().check(messages));
        return pairs;
    }

    /**
     * 基本調査の生活自立度の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor未編集(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        RStringBuilder builder = new RStringBuilder();
        builder.append(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate() != null ? div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho() != null ? div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho() != null ? div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode() != null ? div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtKinyushaCode() != null ? div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText() : RString.EMPTY);
        builder.append(div.getRadGenzaiservis().getSelectedKey());
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().getSelectedKey());
        for (dgRiyoServiceJyokyo_Row row : div.getTabChosaShurui().getDgRiyoServiceJyokyo().getDataSource()) {
            builder.append(row.getServiceJokyo() != null ? row.getServiceJokyo().getText() : RString.EMPTY);
        }
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().getText() : RString.EMPTY);
        for (dgRiyoShisetsu_Row row : div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource()) {
            builder.append(new RString(row.getShisetsuRiyoUmu().toString()));
        }
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho().getDomain().value() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo().getDomain().value() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku() != null
                ? div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue() : RString.EMPTY);
        builder.append(div.getTxtIchijiHanteiKekka() != null
                ? div.getTxtIchijiHanteiKekka().getValue() : RString.EMPTY);
        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        for (KihonChosaInput item : 第1群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第2群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第3群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第4群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第5群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 特別な医療List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 自立度List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }
        RString 編集前データ = ViewStateHolder.get(ViewStateKeys.画面データ, RString.class);

        if (編集前データ.equals(builder.toRString())) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.未編集のため更新不可));
        }
        return pairs;
    }

    /**
     * 特記事項の必須入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateFor特記事項の必須入力(ValidationMessageControlPairs pairs, NinnteiChousaKekkaTouroku1Div div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(NinnteiChousaKekkaTouroku1DivSpec.特記事項の非空チェック)
                .thenAdd(NoInputMessages.特記事項の必須入力).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                NoInputMessages.特記事項の必須入力,
                div.getTplKihonChosa().getBtnTokkiJiko()).build().check(messages));
        return pairs;
    }

    /**
     * 一次判定DLLに渡す引数が正しく作成されたかをチェックします。
     *
     * @param div NinnteiChousaKekkaTouroku1Div
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate一次判定引数(NinnteiChousaKekkaTouroku1Div div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (RString.isNullOrEmpty(div.getIchijiHanteiArgument())) {
            pairs.add(new ValidationMessageControlPair(NoInputMessages.一次判定引数チェック));
        }
        return pairs;
    }

    private static enum NoInputMessages implements IValidationMessage {

        調査実施日の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "調査実施日"),
        調査実施日の妥当性入力(UrErrorMessages.前後関係逆転, "認定申請日", "調査実施日"),
        実施場所の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "実施場所"),
        実施場所名称の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "実施場所名称"),
        所属機関の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "所属機関"),
        記入者の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "記入者"),
        第1群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第1群"),
        第2群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第2群"),
        第3群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第3群"),
        第4群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第4群"),
        第5群の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の第5群"),
        生活自立度の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "基本調査の生活自立度"),
        特記事項の必須入力(UrErrorMessages.必須項目_追加メッセージあり, "特記事項"),
        一次判定引数チェック(DbeErrorMessages.一次判定実行不可_申請日),
        未編集のため更新不可(UrErrorMessages.編集なしで更新不可);

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
