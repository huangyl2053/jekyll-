/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200016;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200001.FutanGendogakuNinteiGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定者リストのReportです。
 *
 * @reamsid_L DBD-3960-060 donghj
 */
public class FutanGendogakuNinteiGaitoshaIchiranReport extends Report<FutanGendogakuNinteiGaitoshaIchiranReportSource> {

    private final RDateTime 作成日時;
    private final TargetList 対象リスト;
    private final NinteishaListSakuseiEntity 負担限度額認定者リストEntity;
    private final Association 導入団体;
    private final IOutputOrder 出力順;
    private static final int NUM_0 = 0;
    private static final int NUM_3 = 3;

    /**
     * インスタンスを生成します
     *
     * @param 作成日時 RDateTime
     * @param 対象リスト TargetList
     * @param 負担限度額認定者リストEntity NinteishaListSakuseiEntity
     * @param 導入団体 Association
     * @param 出力順 IOutputOrder
     */
    public FutanGendogakuNinteiGaitoshaIchiranReport(RDateTime 作成日時, TargetList 対象リスト,
            jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity 負担限度額認定者リストEntity, Association 導入団体, IOutputOrder 出力順) {
        this.作成日時 = 作成日時;
        this.対象リスト = 対象リスト;
        this.負担限度額認定者リストEntity = 負担限度額認定者リストEntity;
        this.導入団体 = 導入団体;
        this.出力順 = 出力順;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteiGaitoshaIchiranReportSource> writer) {
        int index = 1;
        for (int i = NUM_0; i < 負担限度額認定者リストEntity.get世帯員リスト().size(); i += NUM_3) {
            FutanGendogakuNinteiGaitoshaIchiranEditor editor
                    = new FutanGendogakuNinteiGaitoshaIchiranEditor(作成日時, 対象リスト, 負担限度額認定者リストEntity, 導入団体, 出力順, index);
            IFutanGendogakuNinteiGaitoshaIchiranBuilder builder
                    = new FutanGendogakuNinteiGaitoshaIchiranBuilder(editor);
            writer.writeLine(builder);
            index++;
        }

    }

}
