/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.taino;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 未納完納区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum MinoKannoKubun {

    /**
     * コード:1 名称:完納 略称:定義なし
     */
    完納("1", "完納"),
    /**
     * コード:2 名称:過納 略称:定義なし
     */
    過納("2", "過納"),
    /**
     * コード:3 名称:未納あり 略称:定義なし
     */
    未納あり("3", "未納あり"),
    /**
     * コード:4 名称:未来納期 略称:定義なし
     */
    未来納期("4", "未来納期"),
    /**
     * コード:9 名称:_0円 略称:定義なし
     */
    _0円("9", "_0円");
    private final RString code;
    private final RString fullName;

    private MinoKannoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 未納完納区分のコードを返します。
     *
     * @return 激変緩和措置区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 未納完納区分の名称を返します。
     *
     * @return 激変緩和措置区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 未納完納区分のコードと一致する内容を探します。
     *
     * @param code 未納完納区分のコード
     * @return {@code code} に対応する未納完納区分
     */
    public static MinoKannoKubun toValue(RString code) {

        for (MinoKannoKubun minoKannoKubun : MinoKannoKubun.values()) {
            if (minoKannoKubun.code.equals(code)) {
                return minoKannoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("未納完納区分"));
    }
}
