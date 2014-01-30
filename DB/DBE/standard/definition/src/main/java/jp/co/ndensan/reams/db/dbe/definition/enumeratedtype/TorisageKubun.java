/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定申請の取下げ区分を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum TorisageKubun {

    /**
     * 認定申請有効
     */
    認定申請有効(new RString("認定申請有効")),
    /**
     * 区分変更却下
     */
    区分変更却下(new RString("区分変更却下")),
    /**
     * 認定申請取下げ
     */
    認定申請取下げ(new RString("認定申請取下げ")),
    /**
     * 認定申請削除
     */
    認定申請削除(new RString("認定申請削除"));
    private final RString 取下げ区分コード;

    private TorisageKubun(RString 取下げ区分コード) {
        this.取下げ区分コード = 取下げ区分コード;
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return 取下げ区分コード
     */
    public RString get取下げ区分コード() {
        return 取下げ区分コード;
    }

    /**
     * 引数から渡された取下げ区分コードを元に、対応した取下げ区分を返します。
     *
     * @param 取下げ区分コード 取下げ区分コード
     * @return 取下げ区分
     */
    public static TorisageKubun toValue(RString 取下げ区分コード) {
        for (TorisageKubun kubun : values()) {
            if (kubun.取下げ区分コード.equals(取下げ区分コード)) {
                return kubun;
            }
        }
        return null;
    }
}
