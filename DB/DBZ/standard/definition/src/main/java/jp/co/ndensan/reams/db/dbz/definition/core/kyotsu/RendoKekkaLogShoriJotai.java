/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動結果ログ処理状態を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum RendoKekkaLogShoriJotai {

    /**
     * コード:1 名称:正常終了 略称:定義なし
     */
    正常終了("1", "正常終了"),
    /**
     * コード:2 名称:処理待ち 略称:定義なし
     */
    処理待ち("2", "処理待ち"),
    /**
     * コード:3 名称:処理中 略称:定義なし
     */
    処理中("3", "処理中"),
    /**
     * コード:4 名称:異常終了 略称:定義なし
     */
    異常終了("4", "異常終了"),
    /**
     * コード:5 名称:状態なし 略称:定義なし
     */
    状態なし("5", "状態なし");

    private final RString code;
    private final RString fullName;

    private RendoKekkaLogShoriJotai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連動結果ログ処理状態のコードを返します。
     *
     * @return 連動結果ログ処理状態のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連動結果ログ処理状態の名称を返します。
     *
     * @return 連動結果ログ処理状態の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連動結果ログ処理状態のコードと一致する内容を探します。
     *
     * @param code 連動結果ログ処理状態のコード
     * @return {@code code} に対応する連動結果ログ処理状態
     */
    public static RendoKekkaLogShoriJotai toValue(RString code) {

        for (RendoKekkaLogShoriJotai value : RendoKekkaLogShoriJotai.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("連動結果ログ処理状態"));
    }
}
