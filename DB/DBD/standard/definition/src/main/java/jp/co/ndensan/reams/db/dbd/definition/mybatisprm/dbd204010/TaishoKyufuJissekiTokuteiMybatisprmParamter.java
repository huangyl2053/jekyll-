/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetYearMonth;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績キー用検索条件
 *
 * @reamsid_L DBD-3880-030 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoKyufuJissekiTokuteiMybatisprmParamter implements IMyBatisParameter {

    private FlexibleYearMonth 年月範囲の開始;
    private FlexibleYearMonth 年月範囲の終了;
    private RString 事業者番号;
    private boolean is対象年月_サービス提供年月 = false;
    private boolean is対象年月_審査年月 = false;
    private boolean is事業者番号_非空 = false;
    private static final RString サービス提供年月 = new RString("1");
    private static final RString 審査年月 = new RString("2");

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象年月 対象年月
     * @param 年月範囲の開始 年月範囲の開始
     * @param 年月範囲の終了 年月範囲の終了
     * @param 事業者番号 事業者番号
     */
    public TaishoKyufuJissekiTokuteiMybatisprmParamter(
            TargetYearMonth 対象年月,
            FlexibleYearMonth 年月範囲の開始, FlexibleYearMonth 年月範囲の終了, RString 事業者番号) {
        this.事業者番号 = 事業者番号;
        this.年月範囲の開始 = 年月範囲の開始;
        this.年月範囲の終了 = 年月範囲の終了;
        edit対象年月(対象年月);
        edit事業者番号(事業者番号);
    }

    private void edit対象年月(TargetYearMonth 対象年月) {
        if (サービス提供年月.equals(対象年月.getコード())) {
            is対象年月_サービス提供年月 = true;
        } else if (審査年月.equals(対象年月.getコード())) {
            is対象年月_審査年月 = true;
        }
    }

    private void edit事業者番号(RString 事業者番号) {
        if (事業者番号 != null && !事業者番号.isEmpty()) {
            is事業者番号_非空 = true;
        }
    }
}
