/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込_明細データ区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 b_liuyang2
 */
public enum Furikomi_MeisaiDataKubun {

    /**
     * コード:1 名称:償還 略称:定義なし
     */
    償還("1", "償還"),
    /**
     * コード:2 名称:高額 略称:定義なし
     */
    高額("2", "高額"),
    /**
     * コード:3 名称:償還高額 略称:定義なし
     */
    償還高額("3", "償還高額");

    private final RString code;
    private final RString fullName;

    private Furikomi_MeisaiDataKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込_明細データ区分のコードを返します。
     *
     * @return 明細行出力有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込_明細データ区分の名称を返します。
     *
     * @return 振込_明細データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 振込_明細データ区分のコードと一致する内容を探します。
     *
     * @param code 振込_明細データ区分のコード
     * @return {@code code} に対応する振込_明細データ区分
     */
    public static Furikomi_MeisaiDataKubun toValue(RString code) {
        for (Furikomi_MeisaiDataKubun furikomi_MeisaiDataKubun : Furikomi_MeisaiDataKubun.values()) {
            if (furikomi_MeisaiDataKubun.code.equals(code)) {
                return furikomi_MeisaiDataKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込_明細データ区分"));
    }
}
