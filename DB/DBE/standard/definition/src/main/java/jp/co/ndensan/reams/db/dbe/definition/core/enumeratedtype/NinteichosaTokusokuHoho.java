/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促方法を現す列挙型です。
 *
 * @author n8178 城間篤人
 */
//TODO n8178 城間篤人 項目に見直しが入る可能性があり 2014年2月末
public enum NinteichosaTokusokuHoho {

    /**
     * 督促状郵送。
     */
    督促状郵送(new RString("0")),
    /**
     * 督促状ＦＡＸ。
     */
    督促状ＦＡＸ(new RString("1")),
    /**
     * 電話。
     */
    電話(new RString("2")),
    /**
     * その他。
     */
    その他(new RString("3"));
    private final RString 督促方法コード;

    private NinteichosaTokusokuHoho(RString 督促方法コード) {
        this.督促方法コード = 督促方法コード;
    }

    /**
     * 認定調査督促方法を現すコードを返します。
     *
     * @return 督促方法コード
     */
    public RString getCode() {
        return 督促方法コード;
    }

    /**
     * 引数から渡されたコードに対応した、認定調査督促方法を返します。
     *
     * @param 督促方法コード 認定調査督促方法を現すコード
     * @return 対応した認定調査督促方法
     * @throws IllegalArgumentException 対応する認定調査督促方法が存在しなかったとき
     */
    public static NinteichosaTokusokuHoho toValue(RString 督促方法コード) throws IllegalArgumentException {
        for (NinteichosaTokusokuHoho hoho : values()) {
            if (hoho.getCode().equals(督促方法コード)) {
                return hoho;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査督促方法").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する認定調査督促方法").getMessage());
    }
}
