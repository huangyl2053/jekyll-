/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa3;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3.ShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査対象者一覧表A3のReportです。
 *
 * @reamsid_L DBE-0150-230 lishengli
 */
public class ShinsakaishiryoA3Report extends Report<ShinsakaishiryoA3ReportSource> {

    private static final int INT_25 = 25;
    private final List<JimuShinsakaishiryoBusiness> businessList;

    /**
     * インスタンスを生成します。
     *
     * @param businessList List<JimuShinsakaishiryoBusiness>
     */
    public ShinsakaishiryoA3Report(List<JimuShinsakaishiryoBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * 介護認定審査対象者一覧表情報のBusinessList追加処理です。
     *
     * @param business 介護認定審査対象者一覧表情報のBusiness
     */
    public void addBusiness(JimuShinsakaishiryoBusiness business) {
        businessList.add(business);
    }

    /**
     *
     * @param reportSourceWriter 介護認定審査対象者一覧表A3Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishiryoA3ReportSource> reportSourceWriter) {
        for (int i = 0; i < INT_25; i++) {
            IShinsakaishiryoA3Editor editor_Left;
            IShinsakaishiryoA3Editor editor_Right;
            if (businessList.size() < INT_25 && i < businessList.size()) {
                editor_Left = new ShinsakaishiryoA3EditorLeft(businessList.get(i));
                editor_Right = new ShinsakaishiryoA3EditorRight(businessList.get(i), i);
                IShinsakaishiryoA3Builder builder = new ShinsakaishiryoA3BuilderImpl(editor_Left, editor_Right);
                reportSourceWriter.writeLine(builder);
            } else {
                editor_Left = new ShinsakaishiryoA3EditorLeft(businessList.get(i));
                if (i + INT_25 < businessList.size()) {
                    editor_Right = new ShinsakaishiryoA3EditorRight(businessList.get(i + INT_25), i + INT_25);
                } else {
                    editor_Right = new ShinsakaishiryoA3EditorRight(businessList.get(i), i);
                }
                IShinsakaishiryoA3Builder builder = new ShinsakaishiryoA3BuilderImpl(editor_Left, editor_Right);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
