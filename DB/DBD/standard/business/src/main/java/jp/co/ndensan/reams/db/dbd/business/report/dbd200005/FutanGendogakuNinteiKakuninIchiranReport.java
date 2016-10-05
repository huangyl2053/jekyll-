/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200005;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定（一括）確認リストのReportです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public final class FutanGendogakuNinteiKakuninIchiranReport extends Report<FutanGendogakuNinteiKakuninIchiranReportSource> {

    private final FutanGengaokuNintteiKakuninListEntity 負担限度額認定確認リスト;
    private final Association 導入団体;
    private final IOutputOrder 帳票出力順;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 負担限度額認定確認リスト FutanGengaokuNintteiKakuninListEntity
     * @param 導入団体 Association
     * @param 帳票出力順 IOutputOrder
     * @param 作成日時 RDateTime
     */
    public FutanGendogakuNinteiKakuninIchiranReport(FutanGengaokuNintteiKakuninListEntity 負担限度額認定確認リスト,
            Association 導入団体, IOutputOrder 帳票出力順, RDateTime 作成日時) {
        this.負担限度額認定確認リスト = 負担限度額認定確認リスト;
        this.導入団体 = 導入団体;
        this.帳票出力順 = 帳票出力順;
        this.作成日時 = 作成日時;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteiKakuninIchiranReportSource> writer) {
        IFutanGendogakuNinteiKakuninIchiranEditor bodyEditor = new FutanGendogakuNinteiKakuninIchiranEditor(
                負担限度額認定確認リスト, 導入団体, 帳票出力順, 作成日時);
        IFutanGendogakuNinteiKakuninIchiranBuilder builder = new FutanGendogakuNinteiKakuninIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }
}
