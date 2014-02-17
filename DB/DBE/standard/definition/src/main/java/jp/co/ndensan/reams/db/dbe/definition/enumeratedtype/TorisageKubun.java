/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    認定申請有効(new Code(new RString("1"))),
    /**
     * 却下
     */
    却下(new Code(new RString("2"))),
    /**
     * 取下げ
     */
    取下げ(
    new Code(new RString("3"))),
    /**
     * 区分変更却下
     */
    区分変更却下(new Code(new RString("4")));
    private final Code 取下げ区分コード;

    private TorisageKubun(Code 取下げ区分コード) {
        this.取下げ区分コード = 取下げ区分コード;
    }

    /**
     * 取下げ区分コードを返します。
     *
     * @return 取下げ区分コード
     */
    public Code get取下げ区分コード() {
        return 取下げ区分コード;
    }

    /**
     * 引数から渡された取下げ区分コードを元に、対応した取下げ区分を返します。<br/>
     * 対応していないコードを渡した場合はnullが返ります。
     *
     * @param 取下げ区分コード 取下げ区分コード
     * @return 取下げ区分
     */
    public static TorisageKubun toValue(Code 取下げ区分コード) {
        for (TorisageKubun kubun : values()) {
            if (kubun.取下げ区分コード.equals(取下げ区分コード)) {
                return kubun;
            }
        }
        return null;
    }
}
