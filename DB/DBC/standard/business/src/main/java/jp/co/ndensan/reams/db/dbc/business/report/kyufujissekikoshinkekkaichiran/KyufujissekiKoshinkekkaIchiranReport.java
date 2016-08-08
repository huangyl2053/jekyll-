/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekikoshinkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate.ChohyoShutsuryokuTaishoDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinkekkaichiran.KyufujissekiKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表 Report
 *
 * @reamsid_L DBC-2470-030 surun
 */
public class KyufujissekiKoshinkekkaIchiranReport extends Report<KyufujissekiKoshinkekkaIchiranSource> {

    private final List<ChohyoShutsuryokuTaishoDateEntity> entityList;
    private final FlexibleYearMonth 処理年月;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;
    private final YMDHMS システム日時;
    private final List<RString> indexList;
    private static final int NUM1 = 1;

    /**
     * インスタンスを生成します。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param entityList List<ChohyoShutsuryokuTaishoDateEntity>
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     * @param システム日時 YMDHMS
     * @param indexList List<RString>
     */
    public KyufujissekiKoshinkekkaIchiranReport(FlexibleYearMonth 処理年月, List<ChohyoShutsuryokuTaishoDateEntity> entityList,
            RString 並び順の１件目, RString 並び順の２件目, RString 並び順の３件目,
            RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List, YMDHMS システム日時, List<RString> indexList) {
        this.処理年月 = 処理年月;
        this.entityList = entityList;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
        this.システム日時 = システム日時;
        this.indexList = indexList;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufujissekiKoshinkekkaIchiranSource> reportSourceWriter) {
        int i = NUM1;
        for (ChohyoShutsuryokuTaishoDateEntity entity : entityList) {
            IKyufujissekiKoshinkekkaIchiranEditor editor
                    = new KyufujissekiKoshinkekkaIchiranEditor(処理年月, entity, 並び順の１件目, 並び順の２件目,
                            並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List, システム日時, i, indexList);
            IKyufujissekiKoshinkekkaIchiranBuilder builder
                    = new KyufujissekiKoshinkekkaIchiranBuilder(editor);
            reportSourceWriter.writeLine(builder);
            i = i + NUM1;
        }
    }
}
