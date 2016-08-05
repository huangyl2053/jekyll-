/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200022;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseishohakkoichiran.FutanGendogakuNinteiShinseishoHakkoIchiran;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定申請書発行一覧表のReportです。
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
public final class FutanGendogakuNinteiShinseishoHakkoIchiranReport extends
        Report<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> {

    private final List<FutanGendogakuNinteiShinseishoHakkoIchiran> 帳票情報リスト;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報リスト List<FutanGendogakuNinteiShinseishoHakkoIchiran>
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人 IKojin
     * @return 負担限度額認定申請書発行一覧表
     */
    public static FutanGendogakuNinteiShinseishoHakkoIchiranReport createReport(
            List<FutanGendogakuNinteiShinseishoHakkoIchiran> 帳票情報リスト,
            Association association, IOutputOrder iOutputOrder, IKojin 個人) {
        return new FutanGendogakuNinteiShinseishoHakkoIchiranReport(帳票情報リスト, association, iOutputOrder, 個人);
    }

    private FutanGendogakuNinteiShinseishoHakkoIchiranReport(List<FutanGendogakuNinteiShinseishoHakkoIchiran> 帳票情報リスト,
            Association association, IOutputOrder iOutputOrder, IKojin 個人) {
        this.帳票情報リスト = 帳票情報リスト;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人 = 個人;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> writer) {
        for (int index = 0; index < 帳票情報リスト.size(); index++) {
            IFutanGendogakuNinteiShinseishoHakkoIchiranEditor bodyEditor = new FutanGendogakuNinteiShinseishoHakkoIchiranEditor(
                    帳票情報リスト, association, iOutputOrder, index, 個人);
            IFutanGendogakuNinteiShinseishoHakkoIchiranBuilder builder = new FutanGendogakuNinteiShinseishoHakkoIchiranBuilder(bodyEditor);
            writer.writeLine(builder);
        }

    }
}
