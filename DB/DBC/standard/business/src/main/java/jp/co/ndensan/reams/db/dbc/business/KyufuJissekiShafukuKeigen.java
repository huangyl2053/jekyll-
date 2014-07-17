/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績の社会福祉法人軽減額情報を保持するクラス
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiShafukuKeigen {

    private final RString 軽減率;
    private final RString 種類;
    private final RString 前後;
    private final Decimal 受領すべき利用者負担の総額;
    private final Decimal 軽減額;
    private final Decimal 軽減後利用者負担額;
    private final RString 備考;
    private final int 再審査回数;
    private final int 過誤回数;
    private final FlexibleYearMonth 審査年月;

    /**
     * コンストラクタです。
     *
     * @param 軽減率 軽減率
     * @param 種類 種類
     * @param 前後 前後
     * @param 受領すべき利用者負担の総額 受領すべき利用者負担の総額
     * @param 軽減額 軽減額
     * @param 軽減後利用者負担額 軽減後利用者負担額
     * @param 備考 備考
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     *
     *
     */
    public KyufuJissekiShafukuKeigen(RString 軽減率, RString 種類, RString 前後, Decimal 受領すべき利用者負担の総額, Decimal 軽減額,
            Decimal 軽減後利用者負担額, RString 備考, int 再審査回数, int 過誤回数, FlexibleYearMonth 審査年月) {

        this.軽減率 = 軽減率;
        this.種類 = 種類;
        this.前後 = 前後;
        this.受領すべき利用者負担の総額 = 受領すべき利用者負担の総額;
        this.軽減額 = 軽減額;
        this.軽減後利用者負担額 = 軽減後利用者負担額;
        this.備考 = 備考;
        this.再審査回数 = 再審査回数;
        this.過誤回数 = 過誤回数;
        this.審査年月 = 審査年月;

    }

    /**
     * 軽減率返します。
     *
     * @return 軽減率
     */
    public RString get軽減率() {
        return 軽減率;
    }

    /**
     * 種類を返します。
     *
     * @return 種類
     */
    public RString get種類() {
        return 種類;
    }

    /**
     * 前後を返します。
     *
     * @return 前後
     */
    public RString get前後() {
        return 前後;
    }

    /**
     * 受領すべき利用者負担の総額を返します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public Decimal get受領すべき利用者負担の総額() {
        return 受領すべき利用者負担の総額;
    }

    /**
     * 軽減額を返します。
     *
     * @return 軽減額
     */
    public Decimal get軽減額() {
        return 軽減額;
    }

    /**
     * 軽減後利用者負担額を返します。
     *
     * @return 軽減後利用者負担額
     */
    public Decimal get軽減後利用者負担額() {
        return 軽減後利用者負担額;
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return 備考;
    }

    /**
     * を返します。
     *
     * @return 再審査回数
     */
    public int get再審査回数() {
        return 再審査回数;
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public int get過誤回数() {
        return 過誤回数;
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return 審査年月;
    }

}
