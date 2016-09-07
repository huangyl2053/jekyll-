/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 非課税年金対象者情報アップロード画面の入力チェックのメッセージクラスです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public enum TaishoShoriValidationMessage implements IValidationMessage {

    /**
     * 調定年度チェック。
     */
    調定年度チェック(DbdErrorMessages.調定年度が_2016_以前),
    /**
     * 処理状態チェック_処理済。
     */
    処理状態チェック_処理済(DbdErrorMessages.処理状態不正, "処理済"),
    /**
     * 処理状態チェック_処理なし。
     */
    処理状態チェック_処理なし(DbdErrorMessages.処理状態不正, "処理なし"),
    /**
     * アップロードファイル未指定チェック。
     */
    アップロードファイル未指定チェック(DbzErrorMessages.ファイル指定なし),
    /**
     * 編集なしチェック。
     */
    編集なしチェック(DbdErrorMessages.変更無し),
    /**
     * 市町村コードチェック。
     */
    市町村コードチェック(DbdErrorMessages.市町村コード相違),
    /**
     * 年次ファイル通知内容チェック。
     */
    年次ファイル通知内容チェック(DbdErrorMessages.年次ファイル相違),
    /**
     * 月次ファイル通知内容チェック。
     */
    月次ファイル通知内容チェック(DbdErrorMessages.月次ファイル相違);

    private final Message message;

    TaishoShoriValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TaishoShoriValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
