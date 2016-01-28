/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式名称取得パラメータ。
 *
 * @author GC 張鋭
 */
@lombok.Getter
public class YoshikiNameParameter {

    private final RString 識別番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 識別番号区分;

    /**
     * コンストラクタです。
     *
     * @param 識別番号
     * @param サービス提供年月
     * @param 識別番号区分
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private YoshikiNameParameter(
            @lombok.NonNull RString 識別番号,
            @lombok.NonNull FlexibleYearMonth サービス提供年月,
            @lombok.NonNull RString 識別番号区分) {
        this.識別番号 = 識別番号;
        this.サービス提供年月 = サービス提供年月;
        this.識別番号区分 = 識別番号区分;
    }
}
