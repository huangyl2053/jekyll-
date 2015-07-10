/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧保険者番号変換区分の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShinKyuHokenshaNoHenkanKubun {

    /**
     * 新旧保険者番号変換区分が「変換不要」であることを表します。<br/>
     * コード : 0
     */
    変換不要("0"),
    /**
     * 新旧保険者番号変換区分が「変換必要」であることを表します。<br/>
     * コード : 1
     */
    変換必要("1"),
    /**
     * 新旧保険者番号変換区分が「UNKNOWN」であることを表します。<br/>
     * コード : 99
     */
    UNKNOWN("99");
    private final RString code;

    private ShinKyuHokenshaNoHenkanKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 指定のコードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 指定のコードに対応する列挙型。該当する列挙型が見つからない場合は、UNKNOWNを返します。
     */
    public static ShinKyuHokenshaNoHenkanKubun toValue(RString code) {
        for (ShinKyuHokenshaNoHenkanKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        return UNKNOWN;
    }
}
