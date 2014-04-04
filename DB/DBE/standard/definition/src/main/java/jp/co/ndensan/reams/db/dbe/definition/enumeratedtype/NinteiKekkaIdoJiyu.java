/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果異動事由を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum NinteiKekkaIdoJiyu {

    /**
     * 介護サービス種類が「職権追加」であることを表します。<br />
     * コード : 1
     */
    職権追加("1"),
    /**
     * 介護サービス種類が「職権修正」であることを表します。<br />
     * コード : 2
     */
    職権修正("2"),
    /**
     * 介護サービス種類が「職権全部削除」であることを表します。<br />
     * コード : 3
     */
    職権全部削除("3"),
    /**
     * 介護サービス種類が「職権一部削除」であることを表します。<br />
     * コード : 4
     */
    職権一部削除("4");
    private final RString code;

    private NinteiKekkaIdoJiyu(String code) {
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
    public static NinteiKekkaIdoJiyu toValue(RString code) {
        for (NinteiKekkaIdoJiyu data : NinteiKekkaIdoJiyu.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する要介護認定結果異動事由").getMessage());
    }
}
