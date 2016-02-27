/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告報詳細用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JigyoHokokuGeppoDetalSearchParameter {

    private final FlexibleYear 報告年;
    private final RString 報告月;
    private final FlexibleYear 集計対象年;
    private final RString 集計対象月;
    private final RString 統計対象区分;
    private final LasdecCode 市町村コード;
    private final Code 表番号;
    private final Code 集計番号;

    /**
     * コンストラクタです。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 集計対象月 集計対象月
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     */
    private JigyoHokokuGeppoDetalSearchParameter(FlexibleYear 報告年,
            RString 報告月,
            FlexibleYear 集計対象年,
            RString 集計対象月,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            Code 集計番号) {
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.集計対象年 = 集計対象年;
        this.集計対象月 = 集計対象月;
        this.統計対象区分 = 統計対象区分;
        this.市町村コード = 市町村コード;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;

    }

    /**
     * 事業報告報詳細のパラメターを生成します。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 集計対象月 集計対象月
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @return 事業報告報詳細用パラメタ
     */
    public static JigyoHokokuGeppoDetalSearchParameter createParameterForJigyoHokokuGeppoDetal(FlexibleYear 報告年,
            RString 報告月,
            FlexibleYear 集計対象年,
            RString 集計対象月,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            Code 集計番号) {
        return new JigyoHokokuGeppoDetalSearchParameter(報告年,
                報告月, 集計対象年, 集計対象月, 統計対象区分, 市町村コード, 表番号, 集計番号);
    }

}
