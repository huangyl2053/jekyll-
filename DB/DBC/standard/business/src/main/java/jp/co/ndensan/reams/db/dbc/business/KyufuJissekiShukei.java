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
 * 給付実績の集計情報を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiShukei {

    private final RString 種類;
    private final int 実日数;
    private final Decimal 計画単位;
    private final Decimal 対象単位;
    private final Decimal 対象外単位;
    private final int 短計画日数;
    private final RString 保険公費;
    private final RString 決定;
    private final int 短実日数;
    private final Decimal 単位合計;
    private final Decimal 単位数単価;
    private final Decimal 請求額;
    private final Decimal 利用者負担額;
    private final Decimal 出来高単位合計;
    private final Decimal 出来高請求;
    private final Decimal 出来高本人負担額;
    private final int 再審査回数;
    private final int 過誤回数;
    private final FlexibleYearMonth 審査年月;

    /**
     * インスタンスを生成します。
     *
     * @param 種類 種類
     * @param 実日数 実日数
     * @param 計画単位 計画単位
     * @param 対象単位 対象単位
     * @param 対象外単位 対象外単位
     * @param 短計画日数 短計画日数
     * @param 保険公費 保険公費
     * @param 決定 決定
     * @param 短実日数 短実日数
     * @param 単位合計 単位合計
     * @param 単位数単価 単位数単価
     * @param 請求額 請求額
     * @param 利用者負担額 利用者負担額
     * @param 出来高単位合計 出来高単位合計
     * @param 出来高請求 出来高請求
     * @param 出来高本人負担額 出来高本人負担額
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     */
    public KyufuJissekiShukei(
            RString 種類,
            int 実日数,
            Decimal 計画単位,
            Decimal 対象単位,
            Decimal 対象外単位,
            int 短計画日数,
            RString 保険公費,
            RString 決定,
            int 短実日数,
            Decimal 単位合計,
            Decimal 単位数単価,
            Decimal 請求額,
            Decimal 利用者負担額,
            Decimal 出来高単位合計,
            Decimal 出来高請求,
            Decimal 出来高本人負担額,
            int 再審査回数,
            int 過誤回数,
            FlexibleYearMonth 審査年月) {
        this.種類 = 種類;
        this.実日数 = 実日数;
        this.計画単位 = 計画単位;
        this.対象単位 = 対象単位;
        this.対象外単位 = 対象外単位;
        this.短計画日数 = 短計画日数;
        this.保険公費 = 保険公費;
        this.決定 = 決定;
        this.短実日数 = 短実日数;
        this.単位合計 = 単位合計;
        this.単位数単価 = 単位数単価;
        this.請求額 = 請求額;
        this.利用者負担額 = 利用者負担額;
        this.出来高単位合計 = 出来高単位合計;
        this.出来高請求 = 出来高請求;
        this.出来高本人負担額 = 出来高本人負担額;
        this.再審査回数 = 再審査回数;
        this.過誤回数 = 過誤回数;
        this.審査年月 = 審査年月;
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
     * 実日数を返します。
     *
     * @return 実日数
     */
    public int get実日数() {
        return 実日数;
    }

    /**
     * 計画単位を返します。
     *
     * @return 計画単位
     */
    public Decimal get計画単位() {
        return 計画単位;
    }

    /**
     * 対象単位を返します。
     *
     * @return 対象単位
     */
    public Decimal get対象単位() {
        return 対象単位;
    }

    /**
     * 対象外単位を返します。
     *
     * @return 対象外単位
     */
    public Decimal get対象外単位() {
        return 対象外単位;
    }

    /**
     * 短計画日数を返します。
     *
     * @return 短計画日数
     */
    public int get短計画日数() {
        return 短計画日数;
    }

    /**
     * 保険公費を返します。
     *
     * @return 保険公費
     */
    public RString get保険公費() {
        return 保険公費;
    }

    /**
     * 決定を返します。
     *
     * @return 決定
     */
    public RString get決定() {
        return 決定;
    }

    /**
     * 短実日数を返します。
     *
     * @return 短実日数
     */
    public int get短実日数() {
        return 短実日数;
    }

    /**
     * 単位合計を返します。
     *
     * @return 単位合計
     */
    public Decimal get単位合計() {
        return 単位合計;
    }

    /**
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return 単位数単価;
    }

    /**
     * 請求額を返します。
     *
     * @return 請求額
     */
    public Decimal get請求額() {
        return 請求額;
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return 利用者負担額;
    }

    /**
     * 出来高単位合計を返します。
     *
     * @return 出来高単位合計
     */
    public Decimal get出来高単位合計() {
        return 出来高単位合計;
    }

    /**
     * 出来高請求を返します。
     *
     * @return 出来高請求
     */
    public Decimal get出来高請求() {
        return 出来高請求;
    }

    /**
     * 出来高本人負担額を返します。
     *
     * @return 出来高本人負担額
     */
    public Decimal get出来高本人負担額() {
        return 出来高本人負担額;
    }

    /**
     * 再審査回数を返します。
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
