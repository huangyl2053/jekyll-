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
 * 給付実績の住宅改修費情報を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiJutakuKaishuhi {

    private final RString サービス;
    private final FlexibleDate 着工日;
    private final RString 事業者名;
    private final RString 改修先住所;
    private final Decimal 改修費用;
    private final FlexibleYearMonth 審査年月;

    /**
     * インスタンスを生成します。
     *
     * @param サービス サービス
     * @param 着工日 着工日
     * @param 事業者名 事業者名
     * @param 改修先住所 改修先住所
     * @param 改修費用 改修費用
     * @param 審査年月 審査年月
     */
    public KyufuJissekiJutakuKaishuhi(
            RString サービス,
            FlexibleDate 着工日,
            RString 事業者名,
            RString 改修先住所,
            Decimal 改修費用,
            FlexibleYearMonth 審査年月) {
        this.サービス = サービス;
        this.着工日 = 着工日;
        this.事業者名 = 事業者名;
        this.改修先住所 = 改修先住所;
        this.改修費用 = 改修費用;
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
     * 着工日を返します。
     *
     * @return 着工日
     */
    public FlexibleDate get着工日() {
        return 着工日;
    }

    /**
     * 事業者名を返します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return 事業者名;
    }

    /**
     * 改修先住所を返します。
     *
     * @return 改修先住所
     */
    public RString get改修先住所() {
        return 改修先住所;
    }

    /**
     * 改修費用を返します。
     *
     * @return 改修費用
     */
    public Decimal get改修費用() {
        return 改修費用;
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
