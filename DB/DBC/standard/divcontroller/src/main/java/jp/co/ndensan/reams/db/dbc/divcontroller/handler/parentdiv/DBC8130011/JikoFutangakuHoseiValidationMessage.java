/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8130011;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入力チェックエラーメッセージです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public enum JikoFutangakuHoseiValidationMessage implements IValidationMessage {

    /**
     * 被保険者氏名漢字必須項目
     */
    被保険者氏名漢字必須項目(UrErrorMessages.必須項目_追加メッセージあり, "被保険者氏名（漢字）"),
    /**
     * 被保険者名全角文字で入力してください
     */
    被保険者名全角文字で入力してください(UrErrorMessages.全角文字で入力),
    /**
     * 郵便番号が不正
     */
    郵便番号が不正(DbcErrorMessages.郵便番号エラー),
    /**
     * 住所全角文字で入力してください
     */
    住所全角文字で入力してください(UrErrorMessages.全角文字で入力),
    /**
     * 対象期間開始日終了日が不正
     */
    対象期間開始日終了日が不正(DbcErrorMessages.対象期間開始日終了日不整合),
    /**
     * 被保険者期間が不正
     */
    被保険者期間が不正(DbcErrorMessages.被保険者期間開始日終了日不整合),
    /**
     * 対象計算と被保険者開始期間が不正
     */
    対象計算と被保険者開始期間が不正(DbcErrorMessages.対象計算期間被保険者期間開始日不整合),
    /**
     * 対象計算と被保険者終了期間が不正
     */
    対象計算と被保険者終了期間が不正(DbcErrorMessages.対象計算期間被保険者期間終了日不整合),
    /**
     * 支払期間年月日が不正
     */
    支払期間年月日が不正(DbcErrorMessages.窓口払開始日終了日不整合),
    /**
     * 被保険者期間明細月が不正
     */
    被保険者期間明細月が不正(DbcWarningMessages.自己負担被保険者期間外),
    /**
     * 対象計算期間対象年度開始が不正
     */
    対象計算期間対象年度開始が不正(DbcErrorMessages.対象年計算期間開始不整合),
    /**
     * 対象計算期間対象年度終了が不正
     */
    対象計算期間対象年度終了が不正(DbcWarningMessages.対象年対象計算期間終了不整合),
    /**
     * 開始時間が不正
     */
    開始時間が不正(DbcErrorMessages.時間不整合),
    /**
     * 開始分時間が不正
     */
    開始分が不正(DbcErrorMessages.時間不整合),
    /**
     * 終了時間が不正
     */
    終了時間が不正(DbcErrorMessages.時間不整合),
    /**
     * 終了分が不正
     */
    終了分が不正(DbcErrorMessages.時間不整合),
    /**
     * 支払場所が不正
     */
    支払場所が不正(DbcErrorMessages.窓口払支払場所不整合),
    /**
     * 支払場所開始日が不正
     */
    支払場所開始日が不正(DbcErrorMessages.窓口払支払開始日不整合),
    /**
     * 支払場所開始時間が不正
     */
    支払場所開始時間が不正(DbcErrorMessages.窓口払支払開始時間不整合),
    /**
     * 支払場所終了日が不正
     */
    支払場所終了日が不正(DbcErrorMessages.窓口払支払終了日不整合),
    /**
     * 支払場所終了時間が不正
     */
    支払場所終了時間が不正(DbcErrorMessages.窓口払支払終了時間不整合);

    private final Message message;

    /**
     * エラーメッセージを取得する。
     *
     * @return エラーメッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

    private JikoFutangakuHoseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
