/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 資格喪失（死亡）データ作成画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationHandler {

    private final RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     */
    public RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationHandler(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        this.div = div;
    }

    /**
     * 要介護認定関連データ作成画面のバリデーション。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidator validator = new _RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回処理日時_終了日時が開始日時以前チェック,
                        div.getTxtKonkaiKaishiDay(), div.getTxtKonkaiKaishiTime(), div.getTxtKonkaiShuryoDay(), div.getTxtKonkaiShuryoTime())
                .add(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回開始チェック_年月日, div.getTxtKonkaiKaishiDay())
                .add(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回開始チェック_時分秒, div.getTxtKonkaiKaishiTime())
                .add(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回終了チェック_年月日, div.getTxtKonkaiShuryoDay())
                .add(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回終了チェック_時分秒, div.getTxtKonkaiShuryoTime())
                .build();
    }
}
