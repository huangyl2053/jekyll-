/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200022;

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

    private final FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 FutanGendogakuNinteiShinseishoHakkoIchiran
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人 IKojin
     * @param index int
     * @return 負担限度額認定申請書発行一覧表
     */
    public static FutanGendogakuNinteiShinseishoHakkoIchiranReport createReport(FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人, int index) {
        return new FutanGendogakuNinteiShinseishoHakkoIchiranReport(帳票情報, association, iOutputOrder, 個人, index);
    }

    private FutanGendogakuNinteiShinseishoHakkoIchiranReport(FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人 = 個人;
        this.index = index;
    }

    /**
     * writeBy
     *
     * @param writer ReportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> writer) {
        IFutanGendogakuNinteiShinseishoHakkoIchiranEditor bodyEditor = new FutanGendogakuNinteiShinseishoHakkoIchiranEditor(
                帳票情報, association, iOutputOrder, 個人, index);
        IFutanGendogakuNinteiShinseishoHakkoIchiranBuilder builder = new FutanGendogakuNinteiShinseishoHakkoIchiranBuilder(bodyEditor);
        writer.writeLine(builder);
    }

}
