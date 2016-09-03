/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppoippan.JigyouHoukokuTokeiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保台帳生年月日情報処理のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyouHoukokuTokeiProcessParameter implements IBatchProcessParameter {

    private final FlexibleYearMonth 集計年月;
    private final FlexibleYearMonth 報告年月;
    private final FlexibleYear 年度;
    private final RString 市町村コード;
    private final List<RString> 構成市町村コードList;
    private final RString 構成市町村区分;
    private final List<RString> 旧市町村コードList;
    private final RString 旧市町村区分;
    private final YMDHMS 処理日時;
    private final RString 出力ファイルPATH;
    private FileSpoolManager manager;

    /**
     * コンストラクタです。
     *
     * @param 報告年月 FlexibleYearMonth
     * @param 決定年月 FlexibleYearMonth
     * @param 年度 FlexibleYear
     * @param 市町村コード RString
     * @param 構成市町村コードList List<RString>
     * @param 構成市町村区分 RString
     * @param 旧市町村コードList List<RString>
     * @param 旧市町村区分 RString
     * @param 処理日時 YMDHMS
     * @param 出力ファイルPATH RString
     */
    public JigyouHoukokuTokeiProcessParameter(
            FlexibleYearMonth 報告年月,
            FlexibleYearMonth 決定年月,
            FlexibleYear 年度,
            RString 市町村コード,
            List<RString> 構成市町村コードList,
            RString 構成市町村区分,
            List<RString> 旧市町村コードList,
            RString 旧市町村区分,
            YMDHMS 処理日時,
            RString 出力ファイルPATH) {
        this.報告年月 = 報告年月;
        this.集計年月 = 決定年月;
        this.年度 = 年度;
        this.市町村コード = 市町村コード;
        this.構成市町村コードList = 構成市町村コードList;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村コードList = 旧市町村コードList;
        this.旧市町村区分 = 旧市町村区分;
        this.処理日時 = 処理日時;
        this.出力ファイルPATH = 出力ファイルPATH;
    }

    /**
     * 被保台帳生年月日情報処理mybatisのパラメータを生成します。
     *
     * @return JigyouHoukokuTokeiMybatisParameter
     */
    public JigyouHoukokuTokeiMybatisParameter toJigyouHoukokuTokeiMybatisParameter() {
        return new JigyouHoukokuTokeiMybatisParameter(集計年月, 年度, 処理日時);
    }

}
