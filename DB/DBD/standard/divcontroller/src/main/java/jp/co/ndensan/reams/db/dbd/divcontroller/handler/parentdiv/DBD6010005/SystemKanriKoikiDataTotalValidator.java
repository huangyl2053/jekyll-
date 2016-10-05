/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010005;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010005.SystemKanriKoikiDataTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * システム管理登録（広域データ交換）画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-3764-010 tz_chengpeng
 */
public class SystemKanriKoikiDataTotalValidator implements IValidatable {

    private final SystemKanriKoikiDataTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriKoikiDataTotalDiv
     */
    public SystemKanriKoikiDataTotalValidator(SystemKanriKoikiDataTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriKoikiDataTotalSpec.一次判定ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.一次判定ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.訪問調査ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.訪問調査ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.特記事項ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.特記事項ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.意見書ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.意見書ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.日医意見書ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.日医意見書ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.死亡情報ファイル名が未入力チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.死亡情報ファイル名が未入力)
                .ifNot(SystemKanriKoikiDataTotalSpec.対象更新のデータ変更チェック)
                .thenAdd(SystemKanriKoikiDataTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }
}
