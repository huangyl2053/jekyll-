/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定関連データ作成画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public class RenekeiDataSakuseiFourMasterValidationHandler {

    private final RenekeiDataSakuseiFourMasterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     */
    public RenekeiDataSakuseiFourMasterValidationHandler(RenekeiDataSakuseiFourMasterDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定関連データ作成画面のバリデーション。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _RenekeiDataSakuseiFourMasterValidator validator = new _RenekeiDataSakuseiFourMasterValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(RenekeiDataSakuseiFourMasterValidationMessage.今回処理日時_終了日時が開始日時以前チェック, div.getTxtkonkaishoriymdtime())
                .add(RenekeiDataSakuseiFourMasterValidationMessage.今回開始チェック_年月日, div.getTxtkonkaishoriymdtime())
                .add(RenekeiDataSakuseiFourMasterValidationMessage.今回開始チェック_時分秒, div.getTxtkonkaishoriymdtime())
                .add(RenekeiDataSakuseiFourMasterValidationMessage.今回終了チェック_年月日, div.getTxtkonkaishoriymdtime())
                .add(RenekeiDataSakuseiFourMasterValidationMessage.今回終了チェック_時分秒, div.getTxtkonkaishoriymdtime())
                .build();
    }
}
