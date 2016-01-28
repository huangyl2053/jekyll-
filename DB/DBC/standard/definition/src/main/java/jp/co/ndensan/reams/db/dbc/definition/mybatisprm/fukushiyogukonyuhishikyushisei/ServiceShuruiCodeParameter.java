/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * サービス種類取得パラメータ
 *
 * @author GC 張鋭
 */
@lombok.Getter
public class ServiceShuruiCodeParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ServiceShuruiCodeParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull FlexibleYearMonth サービス提供年月) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
    }

    /**
     * サービス種類取得パラメータ作成
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return
     */
    public static ServiceShuruiCodeParameter createParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        return new ServiceShuruiCodeParameter(被保険者番号, サービス提供年月);
    }
}
