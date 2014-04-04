/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の依頼区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoIraiKubun {

    /**
     * 依頼区分が「初回」であることを表します。
     */
    初回("1"),
    /**
     * 依頼区分が「再依頼」であることを表します。
     */
    再依頼("2"),
    /**
     * 依頼区分が「再意見書」であることを表します。
     */
    再意見書("3");
    private final RString code;

    private ShujiiIkenshoIraiKubun(String code) {
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
    public static ShujiiIkenshoIraiKubun toValue(RString code) {
        for (ShujiiIkenshoIraiKubun data : ShujiiIkenshoIraiKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する主治医意見書依頼区分").getMessage());
    }
}
