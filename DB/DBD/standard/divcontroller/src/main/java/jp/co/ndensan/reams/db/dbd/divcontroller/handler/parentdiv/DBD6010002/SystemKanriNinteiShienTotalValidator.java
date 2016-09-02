/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.SystemKanriNinteiShienTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public class SystemKanriNinteiShienTotalValidator implements IValidatable {

    private final SystemKanriNinteiShienTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriNinteiShienTotalDiv
     */
    public SystemKanriNinteiShienTotalValidator(SystemKanriNinteiShienTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriNinteiShienTotalSpec.認定ＩＦ改定日が未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.認定ＩＦ改定日が未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_認定結果ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_認定結果ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_指定事業出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_指定事業出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_調査員出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_調査員出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_医療機関出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_医療機関出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_主治医出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_主治医出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.旧様式_申請情報出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.旧様式_申請情報出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_認定結果ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_認定結果ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_指定事業出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_指定事業出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_調査員出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_調査員出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_医療機関出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_医療機関出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_主治医出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_主治医出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_申請情報出力ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_申請情報出力ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_死亡情報ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_死亡情報ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.新様式_転入死亡ファイルが未入力チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.新様式_転入死亡ファイルが未入力)
                .ifNot(SystemKanriNinteiShienTotalSpec.対象更新のデータ変更チェック)
                .thenAdd(SystemKanriNinteiShienTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }
}
