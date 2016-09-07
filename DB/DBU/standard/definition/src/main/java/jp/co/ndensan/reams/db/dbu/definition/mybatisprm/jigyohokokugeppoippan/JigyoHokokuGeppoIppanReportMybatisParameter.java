/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事業報告統計データ帳票出力のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoIppanReportMybatisParameter implements IMyBatisParameter {

    private List<RString> shichosoncodeList;
    private FlexibleYearMonth syukeiYM;
    private List<RString> shukeinoList;
    private List<RString> hyonoList;

    /**
     * コンストラクタです。
     *
     * @param 集計年月 FlexibleYearMonth
     * @param 市町村コードList List<RString>
     */
    public JigyoHokokuGeppoIppanReportMybatisParameter(FlexibleYearMonth 集計年月,
            List<RString> 市町村コードList) {
        this.syukeiYM = 集計年月;
        this.shichosoncodeList = 市町村コードList;
    }
}
