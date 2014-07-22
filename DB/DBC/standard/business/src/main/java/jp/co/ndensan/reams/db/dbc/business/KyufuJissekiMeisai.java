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
 * 給付実績の明細情報を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiMeisai {

    private final RString サービス;
    private final RString 適要;
    private final RString 決定;
    private final Decimal 単位;
    private final int 回数日数;
    private final int 公費1日数;
    private final int 公費2日数;
    private final int 公費3日数;
    private final Decimal サービス単位;
    private final int 公費1単位;
    private final int 公費2単位;
    private final int 公費3単位;
    private final int 再審査回数;
    private final int 過誤回数;
    private final FlexibleYearMonth 審査年月;

    /**
     * インスタンスを生成します。
     *
     * @param サービス サービス
     * @param 適要 適要
     * @param 決定 決定
     * @param 単位 単位
     * @param 回数日数 回数日数
     * @param 公費1日数 公費1日数
     * @param 公費2日数 公費2日数
     * @param 公費3日数 公費3日数
     * @param サービス単位 サービス単位
     * @param 公費1単位 公費1単位
     * @param 公費2単位 公費2単位
     * @param 公費3単位 公費3単位
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     */
    public KyufuJissekiMeisai(
            RString サービス,
            RString 適要,
            RString 決定,
            Decimal 単位,
            int 回数日数,
            int 公費1日数,
            int 公費2日数,
            int 公費3日数,
            Decimal サービス単位,
            int 公費1単位,
            int 公費2単位,
            int 公費3単位,
            int 再審査回数,
            int 過誤回数,
            FlexibleYearMonth 審査年月) throws NullPointerException {
        this.サービス = サービス;
        this.適要 = 適要;
        this.決定 = 決定;
        this.単位 = 単位;
        this.回数日数 = 回数日数;
        this.公費1日数 = 公費1日数;
        this.公費2日数 = 公費2日数;
        this.公費3日数 = 公費3日数;
        this.サービス単位 = サービス単位;
        this.公費1単位 = 公費1単位;
        this.公費2単位 = 公費2単位;
        this.公費3単位 = 公費3単位;
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

    /**
     * 適要を返します。
     *
     * @return 適要
     */
    public RString get適要() {
        return 適要;
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
     * 単位を返します。
     *
     * @return 単位
     */
    public Decimal get単位() {
        return 単位;
    }

    /**
     * 回数日数を返します。
     *
     * @return 回数日数
     */
    public int get回数日数() {
        return 回数日数;
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
     * 公費2日数を返します。
     *
     * @return 公費2日数
     */
    public int get公費2日数() {
        return 公費2日数;
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
     * サービス単位を返します。
     *
     * @return サービス単位
     */
    public Decimal getサービス単位() {
        return サービス単位;
    }

    /**
     * 公費1単位を返します。
     *
     * @return 公費1単位
     */
    public int get公費1単位() {
        return 公費1単位;
    }

    /**
     * 公費2単位を返します。
     *
     * @return 公費2単位
     */
    public int get公費2単位() {
        return 公費2単位;
    }

    /**
     * 公費3単位を返します。
     *
     * @return 公費3単位
     */
    public int get公費3単位() {
        return 公費3単位;
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
     * @return
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
