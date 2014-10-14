/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績のサービス計画費情報を保持するクラスです。
 *
 * @author n8178 城間篤人
 */
public class KyufuJissekiKyotakuService {

    private final RString 指定基準区分;
    private final FlexibleDate 届出日;
    private final RString サービス;
    private final Decimal 単位数単価;
    private final RString 決定;
    private final RString 明細合計;
    private final Decimal 単位数;
    private final Integer 回数;
    private final Decimal サービス単位数;
    private final Decimal 請求金額;
    private final RString 専門員番号;
    private final Integer 再審査回数;
    private final Integer 過誤回数;
    private final FlexibleYearMonth 審査年月;
    private final RString 摘要;

    /**
     * 外部から必要な情報を受け取り、インスタンスを生成します。
     *
     * @param 指定基準区分 指定基準区分
     * @param 届出日 届出日
     * @param サービス サービス
     * @param 単位数単価 単位数単価
     * @param 決定 決定
     * @param 明細合計 明細合計
     * @param 単位数 単位数
     * @param 回数 回数
     * @param サービス単位数 サービス単位数
     * @param 請求金額 請求金額
     * @param 専門員番号 専門員番号
     * @param 再審査回数 再審査回数
     * @param 過誤回数 過誤回数
     * @param 審査年月 審査年月
     * @param 摘要 摘要
     */
    public KyufuJissekiKyotakuService(
            RString 指定基準区分,
            FlexibleDate 届出日,
            RString サービス,
            Decimal 単位数単価,
            RString 決定,
            RString 明細合計,
            Decimal 単位数,
            Integer 回数,
            Decimal サービス単位数,
            Decimal 請求金額,
            RString 専門員番号,
            Integer 再審査回数,
            Integer 過誤回数,
            FlexibleYearMonth 審査年月,
            RString 摘要) {
        this.指定基準区分 = 指定基準区分;
        this.届出日 = 届出日;
        this.サービス = サービス;
        this.単位数単価 = 単位数単価;
        this.決定 = 決定;
        this.明細合計 = 明細合計;
        this.単位数 = 単位数;
        this.回数 = 回数;
        this.サービス単位数 = サービス単位数;
        this.請求金額 = 請求金額;
        this.専門員番号 = 専門員番号;
        this.再審査回数 = 再審査回数;
        this.過誤回数 = 過誤回数;
        this.審査年月 = 審査年月;
        this.摘要 = 摘要;
    }

    /**
     * 指定基準区分を取得します。
     *
     * @return 指定基準区分
     */
    public RString get指定基準区分() {
        return 指定基準区分;
    }

    /**
     * 届出日を取得します。
     *
     * @return 届出日
     */
    public FlexibleDate get届出日() {
        return 届出日;
    }

    /**
     * サービスを取得します。
     *
     * @return サービス
     */
    public RString getサービス() {
        return サービス;
    }

    /**
     * 単位数単価を取得します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return 単位数単価;
    }

    /**
     * 決定を取得します。
     *
     * @return 決定
     */
    public RString get決定() {
        return 決定;
    }

    /**
     * 明細合計を取得します。
     *
     * @return 明細合計
     */
    public RString get明細合計() {
        return 明細合計;
    }

    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return 単位数;
    }

    /**
     * 回数を取得します。
     *
     * @return 回数
     */
    public Integer get回数() {
        return 回数;
    }

    /**
     * サービス単位数を取得します。
     *
     * @return サービス単位数
     */
    public Decimal getサービス単位数() {
        return サービス単位数;
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public Decimal get請求金額() {
        return 請求金額;
    }

    /**
     * 専門員番号を取得します。
     *
     * @return 専門員番号
     */
    public RString get専門員番号() {
        return 専門員番号;
    }

    /**
     * 再審査回数を取得します。
     *
     * @return 再審査回数
     */
    public Integer get再審査回数() {
        return 再審査回数;
    }

    /**
     * 過誤回数を取得します。
     *
     * @return 過誤回数
     */
    public Integer get過誤回数() {
        return 過誤回数;
    }

    /**
     * 審査年月を取得します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return 審査年月;
    }

    /**
     * 摘要を取得します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return 摘要;
    }
}
