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
 * 給付実績の特定入所者情報を保持するクラスです。
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiTokuteiNyushohi {

    private final RString サービス;
    private final Decimal 負担限度額;
    private final RString 決定;
    private final RString 明細合計;
    private final Decimal 費用単価;
    private final int 日数;
    private final Decimal 費用額;
    private final Decimal 請求額;
    private final Decimal 利用者負担額;
    private final int 公費1日数;
    private final Decimal 公費1負担額;
    private final Decimal 公費1請求額;
    private final Decimal 公費1本人負担額;
    private final int 公費2日数;
    private final Decimal 公費2負担額;
    private final Decimal 公費2請求額;
    private final Decimal 公費2本人負担額;
    private final int 公費3日数;
    private final Decimal 公費3負担額;
    private final Decimal 公費3請額;
    private final Decimal 公費3本人負担額;
    private final int 再審査回数;
    private final int 過誤回数;
    private final FlexibleYearMonth 審査年月;

    /**
     * インスタンスを生成します。
     *
     * @param サービス サービス
     * @param 負担限度額
     * @param 決定
     * @param 明細合計
     * @param 費用単価
     * @param 日数
     * @param 費用額
     * @param 請求額
     * @param 利用者負担額
     * @param 公費1日数
     * @param 公費1負担額
     * @param 公費1請求額
     * @param 公費1本人負担額
     * @param 公費2日数
     * @param 公費2負担額
     * @param 公費2請求額
     * @param 公費2本人負担額
     * @param 公費3日数
     * @param 公費3負担額
     * @param 公費3請額
     * @param 公費3本人負担額
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     */
    public KyufuJissekiTokuteiNyushohi(
            RString サービス,
            Decimal 負担限度額,
            RString 決定,
            RString 明細合計,
            Decimal 費用単価,
            int 日数,
            Decimal 費用額,
            Decimal 請求額,
            Decimal 利用者負担額,
            int 公費1日数,
            Decimal 公費1負担額,
            Decimal 公費1請求額,
            Decimal 公費1本人負担額,
            int 公費2日数,
            Decimal 公費2負担額,
            Decimal 公費2請求額,
            Decimal 公費2本人負担額,
            int 公費3日数,
            Decimal 公費3負担額,
            Decimal 公費3請額,
            Decimal 公費3本人負担額,
            int 再審査回数,
            int 過誤回数,
            FlexibleYearMonth 審査年月) {
        this.サービス = サービス;
        this.負担限度額 = 負担限度額;
        this.決定 = 決定;
        this.明細合計 = 明細合計;
        this.費用単価 = 費用単価;
        this.日数 = 日数;
        this.費用額 = 費用額;
        this.請求額 = 請求額;
        this.利用者負担額 = 利用者負担額;
        this.公費1日数 = 公費1日数;
        this.公費1負担額 = 公費1負担額;
        this.公費1請求額 = 公費1請求額;
        this.公費1本人負担額 = 公費1本人負担額;
        this.公費2日数 = 公費2日数;
        this.公費2負担額 = 公費2負担額;
        this.公費2請求額 = 公費2請求額;
        this.公費2本人負担額 = 公費2本人負担額;
        this.公費3日数 = 公費3日数;
        this.公費3負担額 = 公費3負担額;
        this.公費3請額 = 公費3請額;
        this.公費3本人負担額 = 公費3本人負担額;
        this.再審査回数 = 再審査回数;
        this.過誤回数 = 過誤回数;
        this.審査年月 = 審査年月;
    }

    /**
     * サービスを返します。
     *
     * @return サービス
     */
    public RString getサービス() {
        return サービス;
    }

    public Decimal get負担限度額() {
        return 負担限度額;
    }

    public RString get決定() {
        return 決定;
    }

    /**
     * 明細合計を返します。
     *
     * @return 明細合計
     */
    public RString get明細合計() {
        return 明細合計;
    }

    /**
     * 費用単価を返します。
     *
     * @return 費用単価
     */
    public Decimal get費用単価() {
        return 費用単価;
    }

    /**
     * 日数を返します。
     *
     * @return 日数
     */
    public int get日数() {
        return 日数;
    }

    /**
     * 費用額を返します。
     *
     * @return 費用額
     */
    public Decimal get費用額() {
        return 費用額;
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
     * 公費1日数を返します。
     *
     * @return 公費1日数
     */
    public int get公費1日数() {
        return 公費1日数;
    }

    /**
     * 公費1負担額を返します。
     *
     * @return 公費1負担額
     */
    public Decimal get公費1負担額() {
        return 公費1負担額;
    }

    /**
     * 公費1請求額を返します。
     *
     * @return 公費1請求額
     */
    public Decimal get公費1請求額() {
        return 公費1請求額;
    }

    /**
     * 公費1本人負担額を返します。
     *
     * @return 公費1本人負担額
     */
    public Decimal get公費1本人負担額() {
        return 公費1本人負担額;
    }

    /**
     * 公費2日数を返します。
     *
     * @return 公費2日数
     */
    public int get公費2日数() {
        return 公費2日数;
    }

    /**
     * 公費2負担額を返します。
     *
     * @return 公費2負担額
     */
    public Decimal get公費2負担額() {
        return 公費2負担額;
    }

    /**
     * 公費2請求額を返します。
     *
     * @return 公費2請求額
     */
    public Decimal get公費2請求額() {
        return 公費2請求額;
    }

    /**
     * 公費2本人負担額を返します。
     *
     * @return 公費2本人負担額
     */
    public Decimal get公費2本人負担額() {
        return 公費2本人負担額;
    }

    /**
     * 公費3日数を返します。
     *
     * @return 公費3日数
     */
    public int get公費3日数() {
        return 公費3日数;
    }

    /**
     * 公費3負担額を返します。
     *
     * @return 公費3負担額
     */
    public Decimal get公費3負担額() {
        return 公費3負担額;
    }

    /**
     * 公費3請額を返します。
     *
     * @return 公費3請額
     */
    public Decimal get公費3請額() {
        return 公費3請額;
    }

    /**
     * 公費3本人負担額を返します。
     *
     * @return 公費3本人負担額
     */
    public Decimal get公費3本人負担額() {
        return 公費3本人負担額;
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
