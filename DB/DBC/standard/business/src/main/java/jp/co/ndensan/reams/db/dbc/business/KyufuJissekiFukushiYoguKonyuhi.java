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
 * 給付実績の福祉用具購入費情報を保持するクラスです。
 *
 * @author N8223　朴義一
 */
public class KyufuJissekiFukushiYoguKonyuhi {

    private final RString サービス;
    private final FlexibleDate 購入日;
    private final RString 商品名;
    private final RString 種目;
    private final RString 製造事業者名;
    private final Decimal 購入金額;
    private final FlexibleYearMonth 審査年月;
    private final RString 摘要;

    /**
     * インスタンスを生成します。
     *
     * @param サービス サービスコード
     * @param 購入日 福祉用具販売年月日
     * @param 商品名 福祉用具商品名
     * @param 種目 福祉用具種目コード
     * @param 製造事業者名 販売金額
     * @param 購入金額
     * @param 審査年月 審査年月
     * @param 摘要 摘要
     */
    public KyufuJissekiFukushiYoguKonyuhi(
            RString サービス,
            FlexibleDate 購入日,
            RString 商品名,
            RString 種目,
            RString 製造事業者名,
            Decimal 購入金額,
            FlexibleYearMonth 審査年月,
            RString 摘要
    ) {

        this.サービス = サービス;
        this.購入日 = 購入日;
        this.商品名 = 商品名;
        this.種目 = 種目;
        this.製造事業者名 = 製造事業者名;
        this.購入金額 = 購入金額;
        this.審査年月 = 審査年月;
        this.摘要 = 摘要;
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
     * 購入日を返します。
     *
     * @return 購入日
     */
    public FlexibleDate get購入日() {
        return 購入日;
    }

    /**
     * 商品名を返します。
     *
     * @return 商品名
     */
    public RString get商品名() {
        return 商品名;
    }

    /**
     * 種目を返します。
     *
     * @return 種目
     */
    public RString get種目() {
        return 種目;
    }

    /**
     * 製造事業者名を返します。
     *
     * @return 製造事業者名
     */
    public RString get製造事業者名() {
        return 製造事業者名;
    }

    /**
     * 購入金額を返します。
     *
     * @return 購入金額
     */
    public Decimal get購入金額() {
        return 購入金額;
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return 審査年月;
    }

    /**
     * 適要を返します。
     *
     * @return 適要
     */
    public RString get適要() {
        return 摘要;
    }

}
