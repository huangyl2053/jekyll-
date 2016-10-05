/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyoHokokuGeppoIppanReportMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 一般状況1-11帳票出力のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoIppanReportProcessParameter implements IBatchProcessParameter {

    private final FlexibleYearMonth 集計年月;
    private final List<RString> 過去市町村コードList;
    private final RString 市町村コード;
    private final YMDHMS 処理日時;
    private final RString プリントコントロール区分;
    private final RString 過去集計分旧市町村区分;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     * @param 過去市町村コードList List<RString>
     * @param 市町村コード RString
     * @param プリントコントロール区分 RString
     * @param 過去集計分旧市町村区分 RString
     * @param 処理日時 YMDHMS
     */
    public JigyoHokokuGeppoIppanReportProcessParameter(FlexibleYearMonth 集計年月,
            List<RString> 過去市町村コードList,
            RString 市町村コード,
            RString プリントコントロール区分,
            YMDHMS 処理日時,
            RString 過去集計分旧市町村区分) {
        this.集計年月 = 集計年月;
        this.過去市町村コードList = 過去市町村コードList;
        this.市町村コード = 市町村コード;
        this.プリントコントロール区分 = プリントコントロール区分;
        this.処理日時 = 処理日時;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
    }

    /**
     * 事業報告統計データの帳票出力mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanReportMybatisParameter
     */
    public JigyoHokokuGeppoIppanReportMybatisParameter toJigyoHokokuGeppoIppanReportMybatisParameter() {
        return new JigyoHokokuGeppoIppanReportMybatisParameter(集計年月, 過去市町村コードList);
    }

}
