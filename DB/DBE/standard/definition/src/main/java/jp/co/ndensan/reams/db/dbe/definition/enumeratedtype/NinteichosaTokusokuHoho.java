/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促方法を現す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum NinteichosaTokusokuHoho {

    督促状郵送(new Code(new RString("0"))),
    督促状ＦＡＸ(new Code(new RString("1"))),
    電話(new Code(new RString("2"))),
    その他(new Code(new RString("3")));
    private final Code 督促方法コード;

    private NinteichosaTokusokuHoho(Code 督促方法コード) {
        this.督促方法コード = 督促方法コード;
    }

    /**
     * 認定調査督促方法を現すコードを返します。
     *
     * @return 督促方法コード
     */
    public Code getCode() {
        return 督促方法コード;
    }

    /**
     * 引数から渡されたコードに対応した、認定調査督促方法を返します。
     *
     * @param 督促方法コード 認定調査督促方法を現すコード
     * @return 対応した認定調査督促方法
     * @throws IllegalArgumentException 対応する認定調査督促方法が存在しなかったとき
     */
    public static NinteichosaTokusokuHoho toValue(Code 督促方法コード) throws IllegalArgumentException {
        for (NinteichosaTokusokuHoho hoho : values()) {
            if (hoho.getCode().equals(督促方法コード)) {
                return hoho;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する認定調査督促方法").getMessage());
    }
}
