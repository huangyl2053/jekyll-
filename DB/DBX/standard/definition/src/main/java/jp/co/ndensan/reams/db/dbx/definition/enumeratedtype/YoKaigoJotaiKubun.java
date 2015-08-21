/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分(要支援状態区分)を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護状態区分
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum YoKaigoJotaiKubun {

    /**
     * 非該当
     */
    非該当("01"),
    /**
     * 非該当
     */
    要支援_経過的要介護("11"),
    /**
     * 要支援1
     */
    要支援1("12"),
    /**
     * 要支援2
     */
    要支援2("13"),
    /**
     * 要介護1
     */
    要介護1("21"),
    /**
     * 要介護2
     */
    要介護2("22"),
    /**
     * 要介護3
     */
    要介護3("23"),
    /**
     * 要介護4
     */
    要介護4("24"),
    /**
     * 要介護5
     */
    要介護5("25");
    private final RString 要介護状態区分コード;

    private YoKaigoJotaiKubun(String 要介護状態区分コード) {
        this.要介護状態区分コード = new RString(要介護状態区分コード);
    }

    /**
     * 指定された要介護状態区分(要支援状態区分)の名称を返します。
     *
     * @param code 要介護状態区分(要支援状態区分)コード
     * @return 要介護状態区分(要支援状態区分)
     */
    public static YoKaigoJotaiKubun toValue(RString code) {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分(要支援状態区分)"));

        for (YoKaigoJotaiKubun item : YoKaigoJotaiKubun.values()) {
            if (item.要介護状態区分コード.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する要介護状態区分(要支援状態区分)").evaluate());
    }

    /**
     * 要介護状態区分(要支援状態区分)のコードを返します
     *
     * @return コード
     */
    public RString getCode() {
        return 要介護状態区分コード;
    }
}
