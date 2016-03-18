/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払（居宅）支給限度額判定
 *
 */
public class ShokanbaraiJutakuShikyuGendogakuHanteiCheck {

    private static final RString DEFAULT_213 = new RString("213");
    private static final RString DEFAULT_214 = new RString("214");
    private static final RString DEFAULT_215 = new RString("215");
    private static final RString DEFAULT_216 = new RString("216");
    private static final RString DEFAULT_2173 = new RString("2173");
    private static final RString DEFAULT_2174 = new RString("2174");
    private static final ServiceShuruiCode DEFAULT_33 = new ServiceShuruiCode("33");
    private static final ServiceShuruiCode DEFAULT_35 = new ServiceShuruiCode("35");

    /**
     * 対象単位の必須入力チェック
     *
     * @param 様式番号 様式番号
     * @param 限度額対象単位 限度額対象単位
     * @param サービス種類コード サービス種類コード
     * @return flag
     */
    public boolean chkShokanbaraiJutakuShikyuGendogakuTaishoTani(RString 様式番号, Decimal 限度額対象単位,
            ServiceShuruiCode サービス種類コード) {
        boolean flag = false;
        if (様式番号 == null) {
            return flag;
        }
        if (様式番号.startsWith(DEFAULT_213) || 様式番号.startsWith(DEFAULT_214)
                || 様式番号.startsWith(DEFAULT_215) || 様式番号.startsWith(DEFAULT_216)) {
            if (!様式番号.endsWith("1") && 限度額対象単位 == null) {
                flag = true;
            }
        } else if (DEFAULT_2173.equals(様式番号) && DEFAULT_33.equals(サービス種類コード) && 限度額対象単位 == null) {

            flag = true;

        } else if (DEFAULT_2174.equals(様式番号) && DEFAULT_35.equals(サービス種類コード) && 限度額対象単位 == null) {

            flag = true;

        }

        return flag;
    }

    /**
     * 保険分単位合計チェック
     *
     * @param 様式番号 様式番号
     * @param 限度額対象外単位 限度額対象外単位
     * @param 限度額対象単位 限度額対象単位
     * @param 保険分単位合計 保険分単位合計
     * @param サービス種類コード サービス種類コード
     * @return flag
     */
    public boolean chkShokanbaraiJutakuShikyuGendogakuTaniGokei(RString 様式番号, Decimal 限度額対象外単位,
            Decimal 限度額対象単位, Decimal 保険分単位合計, ServiceShuruiCode サービス種類コード) {
        boolean flag = false;
        if (様式番号 == null) {
            return flag;
        }
        if (様式番号.startsWith(DEFAULT_213) || 様式番号.startsWith(DEFAULT_214)
                || 様式番号.startsWith(DEFAULT_215) || 様式番号.startsWith(DEFAULT_216)) {
            if (!保険分単位合計.equals(限度額対象外単位.add(限度額対象単位))) {
                flag = true;
            }
        }

        return flag;
    }
}
