/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼区分を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 項目に見直しが入る可能性があり 2014年2月末
public enum NinteichosaIraiKubun {

    /**
     * 初回であることを表します。
     */
    初回("0"),
    /**
     * 再依頼であることを表します。
     */
    再依頼("1"),
    /**
     * 再調査であることを表します。
     */
    再調査("2");
    private final RString 区分コード;

    private NinteichosaIraiKubun(String 区分コード) {
        this.区分コード = new RString(区分コード);
    }

    /**
     * 認定調査依頼区分を表すコードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return 区分コード;
    }

    /**
     * 引数から渡されたコードに対応した、認定調査依頼区分を返します。
     *
     * @param 区分コード 区分コード
     * @return 認定調査依頼区分
     * @throws IllegalArgumentException 対応する認定調査委依頼区分コードが存在しないとき
     */
    public static NinteichosaIraiKubun toValue(RString 区分コード) throws IllegalArgumentException {
        for (NinteichosaIraiKubun code : values()) {
            if (code.getCode().equals(区分コード)) {
                return code;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査依頼区分").evaluate());
    }
}
