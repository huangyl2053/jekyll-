/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200014;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200014.HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訪問介護利用者負担額減額認定者リストのReportです。
 *
 * @reamsid_L DBD-3970-060 b_liuyang2
 */
public final class HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport extends
        Report<HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource> {

    private final RDateTime 作成日時;
    private final TargetList 対象リスト;
    private final NinteishaListSakuseiEntity 訪問介護利用者負担額減額認定者Entity;
    private final Association 導入団体;
    private final IOutputOrder 出力順;
    private static final int NUM_0 = 0;
    private static final int NUM_3 = 3;

    /**
     * インスタンスを生成します。
     *
     * @param 作成日時 RDateTime
     * @param 対象リスト TargetList
     * @param 訪問介護利用者負担額減額認定者Entity NinteishaListSakuseiEntity
     * @param 導入団体 Association
     * @param 出力順 IOutputOrder
     */
    public HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReport(RDateTime 作成日時, TargetList 対象リスト,
            NinteishaListSakuseiEntity 訪問介護利用者負担額減額認定者Entity, Association 導入団体, IOutputOrder 出力順) {
        this.作成日時 = 作成日時;
        this.対象リスト = 対象リスト;
        this.訪問介護利用者負担額減額認定者Entity = 訪問介護利用者負担額減額認定者Entity;
        this.導入団体 = 導入団体;
        this.出力順 = 出力順;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranReportSource> writer) {
        if (null != 訪問介護利用者負担額減額認定者Entity.get世帯員リスト() && !訪問介護利用者負担額減額認定者Entity.get世帯員リスト().isEmpty()) {
            int index = 1;
            for (int i = NUM_0; i < 訪問介護利用者負担額減額認定者Entity.get世帯員リスト().size(); i += NUM_3) {
                IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor editor
                        = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor(作成日時, 対象リスト,
                                訪問介護利用者負担額減額認定者Entity, 導入団体, 出力順, index);
                IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder builder
                        = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder(editor);
                writer.writeLine(builder);
                index++;
            }
        } else {
            int index = 1;
            IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor editor
                    = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranEditor(作成日時, 対象リスト,
                            訪問介護利用者負担額減額認定者Entity, 導入団体, 出力順, index);
            IHomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder builder
                    = new HomonKaigoRiyoshaFutangakuGengakuNinteishaIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }
}
