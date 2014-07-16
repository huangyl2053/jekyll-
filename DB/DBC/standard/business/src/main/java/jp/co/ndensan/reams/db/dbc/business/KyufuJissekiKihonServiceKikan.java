/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の基本情報（サービス期間）を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonServiceKikan {

    private final FlexibleDate 開始日;
    private final FlexibleDate 中止日;
    private final RString 中止理由;

    /**
     * インスタンスを生成します。
     *
     * @param 開始日 開始日
     * @param 中止日 中止日
     * @param 中止理由 中止理由
     */
    public KyufuJissekiKihonServiceKikan(
            FlexibleDate 開始日,
            FlexibleDate 中止日,
            RString 中止理由) throws NullPointerException {
        this.開始日 = 開始日;
        this.中止日 = 中止日;
        this.中止理由 = 中止理由;
    }

    /**
     * 開始日を返します。
     *
     * @return 開始日
     */
    public FlexibleDate get開始日() {
        return 開始日;
    }

    /**
     * 中止日を返します。
     *
     * @return 中止日
     */
    public FlexibleDate get中止日() {
        return 中止日;
    }

    /**
     * 中止理由を返します。
     *
     * @return 中止理由
     */
    public RString get中止理由() {
        return 中止理由;
    }
}
