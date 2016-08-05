/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011.JikoFutangakuHoseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 事業分自己負担額情報補正（単）_情報一覧のValidatorです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiValidator {

    private final JikoFutangakuHoseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public JikoFutangakuHoseiValidator(JikoFutangakuHoseiDiv div) {
        this.div = div;
    }

    /**
     * 保存するチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate保存する() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JikoFutangakuHoseiSpec.被保険者氏名必須入力チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.被保険者氏名漢字必須項目)
                .ifNot(JikoFutangakuHoseiSpec.被保険者氏名全角文字チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.被保険者名全角文字で入力してください)
                .ifNot(JikoFutangakuHoseiSpec.郵便番号チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.郵便番号が不正)
                .ifNot(JikoFutangakuHoseiSpec.住所チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.住所全角文字で入力してください)
                .ifNot(JikoFutangakuHoseiSpec.対象計算期間大小関係チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.対象期間開始日終了日が不正)
                .ifNot(JikoFutangakuHoseiSpec.被保険者期間大小関係チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.被保険者期間が不正)
                .ifNot(JikoFutangakuHoseiSpec.対象計算と被保険者期間大小関係開始チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.対象計算と被保険者開始期間が不正)
                .ifNot(JikoFutangakuHoseiSpec.対象計算と被保険者期間大小関係終了チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.対象計算と被保険者終了期間が不正)
                .ifNot(JikoFutangakuHoseiSpec.窓口払情報年月日大小関係チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払期間年月日が不正)
                .ifNot(JikoFutangakuHoseiSpec.対象計算期間開始の年度チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.対象計算期間対象年度開始が不正)
                .ifNot(JikoFutangakuHoseiSpec.開始時間_時間チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.開始時間が不正)
                .ifNot(JikoFutangakuHoseiSpec.開始時間_分チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.開始分が不正)
                .ifNot(JikoFutangakuHoseiSpec.終了時間_時間チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.終了時間が不正)
                .ifNot(JikoFutangakuHoseiSpec.終了時間_分チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.終了分が不正)
                .ifNot(JikoFutangakuHoseiSpec.判定コードより支払場所チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払場所が不正)
                .ifNot(JikoFutangakuHoseiSpec.判定コードより開始日年月日チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払場所開始日が不正)
                .ifNot(JikoFutangakuHoseiSpec.判定コードより開始時間チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払場所開始時間が不正)
                .ifNot(JikoFutangakuHoseiSpec.判定コードより終了日年月日チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払場所終了日が不正)
                .ifNot(JikoFutangakuHoseiSpec.判定コードより終了時間チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.支払場所終了時間が不正)
                .messages());
        return messages;
    }

    /**
     * 負担額情報入力の明細月のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate負担額情報入力の明細月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JikoFutangakuHoseiSpec.明細月チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.被保険者期間明細月が不正)
                .messages());
        return messages;
    }

    /**
     * 終了年度が同年のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate終了年度が同年() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(JikoFutangakuHoseiSpec.対象計算期間終了の年度チェック)
                .thenAdd(JikoFutangakuHoseiValidationMessage.対象計算期間対象年度終了が不正)
                .messages());
        return messages;
    }
}
