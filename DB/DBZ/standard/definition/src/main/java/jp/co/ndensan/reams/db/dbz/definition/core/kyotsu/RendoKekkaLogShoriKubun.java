/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動結果ログ処理区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum RendoKekkaLogShoriKubun {

    /**
     * コード:1 名称:可 略称:定義なし
     */
    可("1", "可"),
    /**
     * コード:2 名称:不可 略称:定義なし
     */
    不可("2", "不可");

    private final RString code;
    private final RString fullName;

    private RendoKekkaLogShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連動結果ログ処理区分のコードを返します。
     *
     * @return 連動結果ログ処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連動結果ログ処理区分の名称を返します。
     *
     * @return 連動結果ログ処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連動結果ログ処理区分のコードと一致する内容を探します。
     *
     * @param code 連動結果ログ処理区分のコード
     * @return {@code code} に対応する連動結果ログ処理区分
     */
    public static RendoKekkaLogShoriKubun toValue(RString code) {

        for (RendoKekkaLogShoriKubun value : RendoKekkaLogShoriKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("連動結果ログ処理区分"));
    }
}
