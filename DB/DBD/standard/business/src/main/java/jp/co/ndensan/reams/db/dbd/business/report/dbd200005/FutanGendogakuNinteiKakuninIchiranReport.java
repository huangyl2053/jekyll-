/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200005;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin.FutanGendogakuNinteiKakunin;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定（一括）確認リストのReportです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public final class FutanGendogakuNinteiKakuninIchiranReport extends Report<FutanGendogakuNinteiKakuninIchiranReportSource> {

    private final List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト;
    private final Association 導入団体;
    private final IOutputOrder 帳票出力順;
    private final FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity;

    /**
     * インスタンスを生成します。
     *
     * @param 負担限度額認定確認リスト List<FutanGendogakuNinteiKakunin>
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     * @param 負担限度額認定宛名Entity FutanGendogakuNinteiKakunin
     * @return 負担限度額認定申請書発行一覧表
     *
     */
    public static FutanGendogakuNinteiKakuninIchiranReport createReport(
            List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト,
            Association 導入団体, IOutputOrder 帳票出力順, FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity) {
        return new FutanGendogakuNinteiKakuninIchiranReport(負担限度額認定確認リスト, 導入団体, 帳票出力順, 負担限度額認定宛名Entity);
    }

    private FutanGendogakuNinteiKakuninIchiranReport(List<FutanGendogakuNinteiKakunin> 負担限度額認定確認リスト,
            Association 導入団体, IOutputOrder 帳票出力順, FutanGendogakuNinteiKakunin 負担限度額認定宛名Entity) {
        this.負担限度額認定確認リスト = 負担限度額認定確認リスト;
        this.導入団体 = 導入団体;
        this.帳票出力順 = 帳票出力順;
        this.負担限度額認定宛名Entity = 負担限度額認定宛名Entity;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteiKakuninIchiranReportSource> writer) {
        for (int index = 0; index < 負担限度額認定確認リスト.size(); index++) {
            IFutanGendogakuNinteiKakuninIchiranEditor bodyEditor = new FutanGendogakuNinteiKakuninIchiranEditor(
                    負担限度額認定確認リスト, 導入団体, 帳票出力順, index, 負担限度額認定宛名Entity);
            IFutanGendogakuNinteiKakuninIchiranBuilder builder = new FutanGendogakuNinteiKakuninIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }

    }
}
