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
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JigyoHokokuGeppoSearchParameter {

    private final FlexibleYear 報告年;
    private final RString 報告月;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final RString 保険者区分;

    /**
     * コンストラクタです。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 保険者区分 保険者区分
     */
    private JigyoHokokuGeppoSearchParameter(FlexibleYear 報告年,
            RString 報告月,
            LasdecCode 市町村コード,
            RString 市町村名称,
            RString 保険者区分) {
        this.報告年 = 報告年;
        this.報告月 = 報告月;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.保険者区分 = 保険者区分;
    }

    /**
     * 事業報告集計一覧用パラメータを生成します。
     *
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 保険者区分 保険者区分
     * @return 事業報告集計一覧用パラメータ
     */
    public static JigyoHokokuGeppoSearchParameter createParameterForJigyoHokokuGeppo(FlexibleYear 報告年,
            RString 報告月,
            LasdecCode 市町村コード,
            RString 市町村名称,
            RString 保険者区分) {
        if (市町村コード == null) {
            市町村コード = LasdecCode.EMPTY;
        }
        return new JigyoHokokuGeppoSearchParameter(報告年, 報告月, 市町村コード, 市町村名称, 保険者区分);
    }
}
