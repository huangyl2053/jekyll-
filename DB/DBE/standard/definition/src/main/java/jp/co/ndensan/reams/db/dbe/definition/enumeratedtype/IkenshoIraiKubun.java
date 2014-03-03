/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成依頼区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IkenshoIraiKubun {

    /**
     * 意見書作成依頼区分が「初回依頼」であることを表します。<br />
     * コード : 1
     */
    初回依頼(new RString("1")),
    /**
     * 意見書作成依頼区分が「再依頼」であることを表します。<br />
     * コード : 2
     */
    再依頼(new RString("2")),
    /**
     * 意見書作成依頼区分が「再意見書」であることを表します。<br />
     * コード : 3
     */
    再意見書(new RString("3"));
    private RString code;

    private IkenshoIraiKubun(RString code) {
        this.code = code;
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
     * 引数のコードに対応する意見書作成依頼区分を返します。
     *
     * @param code コード
     * @return 意見書作成依頼区分
     */
    public static IkenshoIraiKubun toValue(RString code) {
        for (IkenshoIraiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する意見書作成依頼区分").getMessage());
    }
}
