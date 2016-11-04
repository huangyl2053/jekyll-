/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 転入転出未登録一覧表のReportです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoReport extends Report<TennyuTenshutsuMitorokuIchiranhyoReportSource> {

    private final TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem;
    private final TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 転入転出未登録一覧表ヘッダのITEM
     * @param bodyItem 転入転出未登録一覧表ボディのITEM
     * @return 転入転出未登録一覧表のReport
     */
    public static TennyuTenshutsuMiTorokuIchiranhyoReport createFrom(
            TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem,
            @NonNull TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {

        return new TennyuTenshutsuMiTorokuIchiranhyoReport(
                headItem,
                bodyItem);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 転入転出未登録一覧表ヘッダのITEM
     * @param bodyItem 転入転出未登録一覧表のITEM
     */
    protected TennyuTenshutsuMiTorokuIchiranhyoReport(
            TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem,
            TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }

    /**
     * 転入転出未登録一覧表writeです。
     *
     * @param reportSourceWriter 転入転出未登録一覧表Source
     */
    @Override
    public void writeBy(ReportSourceWriter<TennyuTenshutsuMitorokuIchiranhyoReportSource> reportSourceWriter) {
        ITennyuTenshutsuMiTorokuIchiranhyoEditor headerEditor = new TennyuTenshutsuMiTorokuIchiranhyoHeaderEditor(headItem);
        TennyuTenshutsuMiTorokuIchiranhyoBodyEditor bodyEditor = new TennyuTenshutsuMiTorokuIchiranhyoBodyEditor(bodyItem);
        ITennyuTenshutsuMiTorokuIchiranhyoBuilder builder = new TennyuTenshutsuMiTorokuIchiranhyoBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
