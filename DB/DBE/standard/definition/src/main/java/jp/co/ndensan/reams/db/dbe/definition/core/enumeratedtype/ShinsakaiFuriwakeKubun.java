/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定の審査会優先振分区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShinsakaiFuriwakeKubun {

    /**
     * 審査会優先振分区分が「直近の審査会への割付希望」であることを表します。<br />
     * コード : 1
     */
    直近の審査会への割付希望("1"),
    /**
     * 審査会優先振分区分が「精神科医のいる審査会への割付希望」であることを表します。<br />
     * コード : 2
     */
    精神科医のいる審査会への割付希望("2"),
    /**
     * 審査会優先振分区分が「希望無し」であることを表します。<br />
     * コード : 0
     */
    希望無し("0");
    private final RString code;

    private ShinsakaiFuriwakeKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ShinsakaiFuriwakeKubun toValue(RString code) {
        for (ShinsakaiFuriwakeKubun data : ShinsakaiFuriwakeKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
