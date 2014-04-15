/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定の結果を送付したか否かを表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum IchijiHanteiResultSofuKubun {

    /**
     * 送付済みであることを表します。
     */
    送付済み("1"),
    /**
     * まだ送付していないことを表します。
     */
    未送付("0");
    private final RString 送付区分コード;

    private IchijiHanteiResultSofuKubun(String 送付区分コード) {
        this.送付区分コード = new RString(送付区分コード);
    }

    /**
     * 送付区分を表すコードを返します。
     *
     * @return 送付区分コード
     */
    public RString get送付区分コード() {
        return 送付区分コード;
    }

    /**
     * 一次判定送付区分コードを受け取り、対応する送付区分を返します。<br/>
     * 対応する送付区分が存在しない場合、nullが返却されます。
     *
     * @param 送付区分コード 一次判定送付区分コード
     * @return 送付区分
     * @throws IllegalArgumentException 対応する送付区分が存在しないとき
     */
    public static IchijiHanteiResultSofuKubun toValue(RString 送付区分コード) throws IllegalArgumentException {
        for (IchijiHanteiResultSofuKubun 送付区分 : values()) {
            if (送付区分.get送付区分コード().equals(送付区分コード)) {
                return 送付区分;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する送付区分").getMessage());
    }
}
