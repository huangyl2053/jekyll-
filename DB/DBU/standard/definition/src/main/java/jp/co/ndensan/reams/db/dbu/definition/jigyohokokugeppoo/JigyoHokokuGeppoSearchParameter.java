/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告集計一覧用パラメータクラスです。
 *
 * @author sunhui
 */
@lombok.Getter
@lombok.Setter
public class JigyoHokokuGeppoSearchParameter {

    private final FlexibleYear 報告年;
    private final RString 報告月;
    private final FlexibleYear 集計対象年;
    private final RString 統計対象区分;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;

    /**
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     */
    private JigyoHokokuGeppoSearchParameter(FlexibleYear 報告年, RString 報告月, FlexibleYear 集計対象年,
            RString 統計対象区分, LasdecCode 市町村コード, RString 市町村名称) {
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.集計対象年 = 集計対象年;
        this.市町村コード = 市町村コード;
        this.統計対象区分 = 統計対象区分;
        this.市町村名称 = 市町村名称;
    }

    /**
     * 事業報告集計一覧用パラメータを生成します。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @return 事業報告集計一覧用パラメータ
     */
    public static JigyoHokokuGeppoSearchParameter createParameterForJigyoHokokuGeppo(FlexibleYear 報告年,
            RString 報告月, FlexibleYear 集計対象年, RString 統計対象区分, LasdecCode 市町村コード, RString 市町村名称) {
        if (市町村コード == null) {
            市町村コード = LasdecCode.EMPTY;
        }
        return new JigyoHokokuGeppoSearchParameter(報告年, 報告月, 集計対象年, 統計対象区分, 市町村コード, 市町村名称);
    }
}
