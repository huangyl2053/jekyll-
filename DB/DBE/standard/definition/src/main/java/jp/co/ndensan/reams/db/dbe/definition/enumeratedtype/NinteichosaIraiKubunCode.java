/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼区分コードを表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum NinteichosaIraiKubunCode {

    /**
     * 初回であることを表します。
     */
    初回(new Code(new RString("0"))),
    /**
     * 再依頼であることを表します。
     */
    再依頼(new Code(new RString("1"))),
    /**
     * 再調査であることを表します。
     */
    再調査(new Code(new RString("2")));
    private final Code 区分コード;

    private NinteichosaIraiKubunCode(Code 区分コード) {
        this.区分コード = 区分コード;
    }

    /**
     * 認定調査依頼区分を表すコードを返します。
     *
     * @return コード
     */
    public Code getCode() {
        return 区分コード;
    }

    /**
     * 引数から渡されたコードに対応した、認定調査依頼区分コードを返します。
     *
     * @param 区分コード 区分コード
     * @return 認定調査依頼区分コード
     * @throws IllegalArgumentException 対応する認定調査委依頼区分コードが存在しないとき
     */
    public static NinteichosaIraiKubunCode toValue(Code 区分コード) throws IllegalArgumentException {
        for (NinteichosaIraiKubunCode code : values()) {
            if (code.getCode().equals(区分コード)) {
                return code;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する認定調査依頼区分コード").getMessage());
    }
}
