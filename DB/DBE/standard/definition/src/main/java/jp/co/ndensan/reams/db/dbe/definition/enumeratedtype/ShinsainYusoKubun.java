/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員に送付する資料の送り先を表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum ShinsainYusoKubun {

    /**
     * 自宅に送付することを示す項目です。
     */
    自宅(new RString("1")),
    /**
     * 所属機関に送付することを示す項目です。
     */
    所属機関(new RString("2"));
    private final RString 郵送区分;

    private ShinsainYusoKubun(RString 郵送区分) {
        this.郵送区分 = 郵送区分;
    }

    /**
     * 郵送区分を表す文字列を返します。
     *
     * @return 郵送区分を表す文字列
     */
    public RString get郵送区分() {
        return 郵送区分;
    }

    /**
     * 引数に郵送区分を表す文字列を渡し、それに対応した郵送区分を取得します。<br/>
     * 対応する郵送区分が存在しない場合、例外が発生します。
     *
     * @param 郵送区分 郵送区分を表す文字列
     * @return 引数に対応した郵送区分項目
     */
    public static ShinsainYusoKubun toValue(RString 郵送区分) {
        for (ShinsainYusoKubun kubun : values()) {
            if (kubun.get郵送区分().equals(郵送区分)) {
                return kubun;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する郵送区分").getMessage());
    }
}
