/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.SyotaiJohoSyoriMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 世帯情報処理のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyotaiJohoSyoriProcessParamter implements IBatchProcessParameter {

    private final FlexibleYearMonth 集計年月;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     */
    public SyotaiJohoSyoriProcessParamter(FlexibleYearMonth 集計年月) {
        this.集計年月 = 集計年月;
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @return SyotaiJohoSyoriMybatisParamter
     */
    public SyotaiJohoSyoriMybatisParamter toSyotaiJohoSyoriMybatisParamter() {
        return new SyotaiJohoSyoriMybatisParamter(集計年月);
    }

}
