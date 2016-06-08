/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.hokensha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計対象区分を表す列挙型です。
 */
public enum TokeiTaishoKubun {

    /**
     * コード:1 名称:保険者分 略称:定義なし
     */
    保険者分("1", "保険者分"),
    /**
     * コード:2 名称:構成市町村分 略称:定義なし
     */
    構成市町村分("2", "構成市町村分"),
    /**
     * コード:3 名称:旧市町村分 略称:定義なし
     */
    旧市町村分("3", "旧市町村分"),
    /**
     * コード:"" 名称:"" 略称:定義なし
     */
    空;

    private final RString code;
    private final RString fullName;

    private TokeiTaishoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    private TokeiTaishoKubun() {
        this.code = RString.EMPTY;
        this.fullName = RString.EMPTY;
    }

    /**
     * 統計対象区分のコードを返します。
     *
     * @return 統計対象区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 統計対象区分の名称を返します。
     *
     * @return 統計対象区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 統計対象区分のコードと一致する内容を探します。
     *
     * @param code 統計対象区分のコード
     * @return {@code code} に対応する統計対象区分
     */
    public static TokeiTaishoKubun toValue(RString code) {
        for (TokeiTaishoKubun tokeiTaishoKubun : TokeiTaishoKubun.values()) {
            if (tokeiTaishoKubun.code.equals(code)) {
                return tokeiTaishoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("\"" + code + "\"に対応する統計対象区分"));
    }
}
