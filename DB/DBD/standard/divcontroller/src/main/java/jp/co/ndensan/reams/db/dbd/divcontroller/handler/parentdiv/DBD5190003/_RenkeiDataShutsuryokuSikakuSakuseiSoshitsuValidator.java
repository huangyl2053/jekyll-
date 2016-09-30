/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 資格喪失（死亡）データ作成画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class _RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidator implements IValidatable {

    private final RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div;

    /**
     * バリデーション。
     *
     * @param div ドメインオブジェクトを取り出したい{@link RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv}
     */
    public _RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidator(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec.今回処理日時_終了日時が開始日時以前チェック)
                .thenAdd(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回処理日時_終了日時が開始日時以前チェック)
                .ifNot(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec.今回開始チェック_年月日)
                .thenAdd(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回開始チェック_年月日)
                .ifNot(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec.今回開始チェック_時分秒)
                .thenAdd(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回終了チェック_時分秒)
                .ifNot(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec.今回終了チェック_年月日)
                .thenAdd(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回終了チェック_年月日)
                .ifNot(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuSpec.今回終了チェック_時分秒)
                .thenAdd(RenkeiDataShutsuryokuSikakuSakuseiSoshitsuValidationMessage.今回終了チェック_時分秒)
                .messages());
        return messages;
    }
}
