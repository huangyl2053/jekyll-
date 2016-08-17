/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoshokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 給付管理票照会（画面）のMapperParameterです。
 *
 * @reamsid_L DBC-2960-060 chenxiangyu
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufuKanrihyoShokaiMapperParameter {

    private final RString 被保番号;
    private final boolean 被保番号Flag;
    private final RString 支援事業者番号;
    private final boolean 支援事業者番号Flag;
    private final RString 給付対象年月開始;
    private final RString 給付対象年月終了;
    private final RString 審査年月;
    private final RString サービス提供年月;
    private final RString 被保険者番号;

    private KyufuKanrihyoShokaiMapperParameter(
            RString 被保番号,
            boolean 被保番号Flag,
            RString 支援事業者番号,
            boolean 支援事業者番号Flag,
            RString 給付対象年月開始,
            RString 給付対象年月終了,
            RString 審査年月,
            RString サービス提供年月,
            RString 被保険者番号) {
        this.被保番号 = 被保番号;
        this.被保番号Flag = 被保番号Flag;
        this.支援事業者番号 = 支援事業者番号;
        this.支援事業者番号Flag = 支援事業者番号Flag;
        this.給付対象年月開始 = 給付対象年月開始;
        this.給付対象年月終了 = 給付対象年月終了;
        this.審査年月 = 審査年月;
        this.サービス提供年月 = サービス提供年月;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 給付管理票一覧のパラメータを生成します。
     *
     * @param 被保番号 被保番号
     * @param 支援事業者番号 支援事業者番号
     * @param 給付対象年月開始 給付対象年月開始
     * @param 給付対象年月終了 給付対象年月終了
     * @return KyufuKanrihyoShokaiMapperParameter
     */
    public static KyufuKanrihyoShokaiMapperParameter createKyufuKanrihyoParameter(
            RString 被保番号,
            RString 支援事業者番号,
            RString 給付対象年月開始,
            RString 給付対象年月終了) {
        return new KyufuKanrihyoShokaiMapperParameter(
                被保番号,
                !(被保番号 == null),
                支援事業者番号,
                !(支援事業者番号 == null),
                給付対象年月開始,
                給付対象年月終了,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * 給付管理明細一覧のパラメータを生成します。
     *
     * @param 審査年月 審査年月
     * @param サービス提供年月 サービス提供年月
     * @param 被保険者番号 被保険者番号
     * @return KyufuKanrihyoShokaiMapperParameter
     */
    public static KyufuKanrihyoShokaiMapperParameter createKyufuKanriMeisaiParameter(
            RString 審査年月,
            RString サービス提供年月,
            RString 被保険者番号) {
        return new KyufuKanrihyoShokaiMapperParameter(
                RString.EMPTY,
                false,
                RString.EMPTY,
                false,
                RString.EMPTY,
                RString.EMPTY,
                審査年月,
                サービス提供年月,
                被保険者番号);
    }
}
