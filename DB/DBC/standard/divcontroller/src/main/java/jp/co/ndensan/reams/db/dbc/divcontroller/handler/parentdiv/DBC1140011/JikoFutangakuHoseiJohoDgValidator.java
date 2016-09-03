/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 自己負担額情報補正（単）_情報一覧のValidatorです。
 *
 * @reamsid_L DBC-2080-010 huzongcheng
 */
public class JikoFutangakuHoseiJohoDgValidator {

    private final JikoFutangakuJohoHoseiJohoDgDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link JikoFutangakuHosei hoDiv}
     */
    public JikoFutangakuHoseiJohoDgValidator(JikoFutangakuJohoHoseiJohoDgDiv div) {
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
                .ifNot(JikoFutangakuHoseiJohoDgSpec.被保険者氏名必須入力チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者氏名漢字必須項目)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.被保険者氏名全角文字チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者名全角文字で入力してください)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.郵便番号チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.郵便番号が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.住所チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.住所全角文字で入力してください)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.対象計算期間大小関係チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象期間開始日終了日が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.被保険者期間大小関係チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者期間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.対象計算と被保険者期間大小関係開始チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算と被保険者開始期間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.対象計算と被保険者期間大小関係終了チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算と被保険者終了期間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.窓口払情報年月日大小関係チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払期間年月日が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.対象計算期間開始の年度チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算期間対象年度開始が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.開始時間_時間チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.開始時間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.開始時間_分チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.開始分が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.終了時間_時間チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.終了時間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.終了時間_分チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.終了分が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.判定コードより支払場所チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.判定コードより開始日年月日チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所開始日が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.判定コードより開始時間チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所開始時間が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.判定コードより終了日年月日チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所終了日が不正)
                .ifNot(JikoFutangakuHoseiJohoDgSpec.判定コードより終了時間チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.支払場所終了時間が不正)
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
                .ifNot(JikoFutangakuHoseiJohoDgSpec.明細月チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.被保険者期間明細月が不正)
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
                .ifNot(JikoFutangakuHoseiJohoDgSpec.対象計算期間終了の年度チェック)
                .thenAdd(JikoFutangakuJohoHoseiJohoDgValidationMessage.対象計算期間対象年度終了が不正)
                .messages());
        return messages;
    }

}
