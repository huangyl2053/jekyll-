/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局用介護認定審査対象者一覧表のReportです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4Report extends Report<ShinsakaishiryoA4ReportSource> {

    private final List<ShinsakaishiryoA4Item> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 事務局用介護認定審査対象者一覧表のITEMLIST
     * @return 事務局用介護認定審査対象者一覧表のReport
     */
    public static ShinsakaishiryoA4Report createFrom(List<ShinsakaishiryoA4Item> itemList) {

        return new ShinsakaishiryoA4Report(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 事務局用介護認定審査対象者一覧表のITEMLIST
     */
    protected ShinsakaishiryoA4Report(List<ShinsakaishiryoA4Item> itemList) {

        this.itemList = itemList;
    }

    /**
     *
     * @param reportSourceWriter 事務局用介護認定審査対象者一覧表Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishiryoA4ReportSource> reportSourceWriter) {
        for (ShinsakaishiryoA4Item headItem : itemList) {
            IShinsakaishiryoA4Editor headerEditor = new ShinsakaishiryoA4Editor(headItem);
            IShinsakaishiryoA4Builder builder = new ShinsakaishiryoA4BuilderImpl(headerEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
