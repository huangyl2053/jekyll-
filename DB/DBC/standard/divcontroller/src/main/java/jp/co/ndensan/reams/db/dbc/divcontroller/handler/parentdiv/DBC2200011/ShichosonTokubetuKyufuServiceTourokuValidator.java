/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011.ShichosonTokubetuKyufuServiceTourokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 画面設計_DBC2200011_市町村特別給付サービス内容登録の入力チェッククラスです。
 *
 * @reamsid_L DBC-3420-010 tz_chengpeng
 */
public class ShichosonTokubetuKyufuServiceTourokuValidator implements IValidatable {

    private final ShichosonTokubetuKyufuServiceTourokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShichosonTokubetuKyufuServiceTourokuDiv
     */
    public ShichosonTokubetuKyufuServiceTourokuValidator(ShichosonTokubetuKyufuServiceTourokuDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.非直近データを選択チェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.選択されていない)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.有効開始日と有効終了日の前後関係のチェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.有効開始日と有効終了日の前後関係が不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.有効開始日が前回の有効開始日以降の日付のチェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.前回の有効開始日以降の入力不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.有効開始日が前回の有効終了日以前の日付のチェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.前回の有効終了日以前の入力不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.名称入力内容チェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.名称入力内容が不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.名称入力文字数チェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.名称入力文字数が不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.略称入力内容チェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.略称入力内容が不正)
                .ifNot(ShichosonTokubetuKyufuServiceTourokuSpec.略称入力文字数チェック)
                .thenAdd(ShichosonTokubetuKyufuServiceTourokuValidationMessage.略称入力文字数が不正)
                .messages());
        return messages;
    }
}
