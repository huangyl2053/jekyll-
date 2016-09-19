/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 要介護認定関連データ作成画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class _RenekeiDataSakuseiFourMasterValidator implements IValidatable {

    private final RenekeiDataSakuseiFourMasterDiv div;

    /**
     * バリデーション。
     *
     * @param div ドメインオブジェクトを取り出したい{@link RenekeiDataSakuseiFourMasterDiv}
     */
    public _RenekeiDataSakuseiFourMasterValidator(RenekeiDataSakuseiFourMasterDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RenekeiDataSakuseiFourMasterSpec.今回処理日時_終了日時が開始日時以前チェック)
                .thenAdd(RenekeiDataSakuseiFourMasterValidationMessage.今回処理日時_終了日時が開始日時以前チェック)
                .ifNot(RenekeiDataSakuseiFourMasterSpec.今回開始チェック_年月日)
                .thenAdd(RenekeiDataSakuseiFourMasterValidationMessage.今回開始チェック_年月日)
                .ifNot(RenekeiDataSakuseiFourMasterSpec.今回開始チェック_時分秒)
                .thenAdd(RenekeiDataSakuseiFourMasterValidationMessage.今回終了チェック_時分秒)
                .ifNot(RenekeiDataSakuseiFourMasterSpec.今回終了チェック_年月日)
                .thenAdd(RenekeiDataSakuseiFourMasterValidationMessage.今回終了チェック_年月日)
                .ifNot(RenekeiDataSakuseiFourMasterSpec.今回終了チェック_時分秒)
                .thenAdd(RenekeiDataSakuseiFourMasterValidationMessage.今回終了チェック_時分秒)
                .messages());
        return messages;
    }
}
