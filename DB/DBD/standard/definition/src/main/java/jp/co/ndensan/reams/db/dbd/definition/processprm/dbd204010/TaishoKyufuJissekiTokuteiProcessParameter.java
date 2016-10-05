/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetYearMonth;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd204010.TaishoKyufuJissekiTokuteiMybatisprmParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力情報の取得_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-3880-050 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoKyufuJissekiTokuteiProcessParameter implements IBatchProcessParameter {

    private TargetYearMonth 対象年月;
    private FlexibleYearMonth 年月範囲の開始;
    private FlexibleYearMonth 年月範囲の終了;
    private RString 事業者番号;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @param 対象年月 対象年月
     * @param 年月範囲の開始 年月範囲の開始
     * @param 年月範囲の終了 年月範囲の終了
     * @param 事業者番号 事業者番号
     */
    public TaishoKyufuJissekiTokuteiProcessParameter(TargetYearMonth 対象年月,
            FlexibleYearMonth 年月範囲の開始, FlexibleYearMonth 年月範囲の終了, RString 事業者番号) {
        this.対象年月 = 対象年月;
        this.年月範囲の開始 = 年月範囲の開始;
        this.年月範囲の終了 = 年月範囲の終了;
        this.事業者番号 = 事業者番号;
    }

    /**
     * 利用者負担額減免認定者リスト発行の引数を返します。
     *
     * @return HchiJinoSyouriCreateMybatisprmParamter
     */
    public TaishoKyufuJissekiTokuteiMybatisprmParamter toTaishoKyufuJissekiTokuteiMybatisprmParamter() {
        return new TaishoKyufuJissekiTokuteiMybatisprmParamter(対象年月, 年月範囲の開始, 年月範囲の終了, 事業者番号);
    }
}
