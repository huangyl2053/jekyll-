/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153old;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153OldReport extends Report<JigyohokokuCompYoshiki153OldReportSource> {

    private final JigyohokokuCompYoshiki153OldData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki153OldReport(JigyohokokuCompYoshiki153OldData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki153OldReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki153OldChange change : getListData()) {
            IJigyohokokuCompYoshiki153OldEditor editor = new JigyohokokuCompYoshiki153OldEditor(data, change);
            IJigyohokokuCompYoshiki153OldBuilder builder = new JigyohokokuCompYoshiki153OldBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki153OldChange> getListData() {
        List<JigyohokokuCompYoshiki153OldChange> list = new ArrayList<>();
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_1(),
                data.get予防給付_要支援2_1(),
                data.get予防給付の計_1(),
                data.get介護給付_経過的要介護_1(),
                data.get介護給付_要介護1_1(),
                data.get介護給付_要介護2_1(),
                data.get介護給付_要介護3_1(),
                data.get介護給付_要介護4_1(),
                data.get介護給付_要介護5_1(),
                data.get介護給付_その他_1(),
                data.get介護給付の計_1(),
                data.getサービス受給者数合計_1()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_2(),
                data.get予防給付_要支援2_2(),
                data.get予防給付の計_2(),
                data.get介護給付_経過的要介護_2(),
                data.get介護給付_要介護1_2(),
                data.get介護給付_要介護2_2(),
                data.get介護給付_要介護3_2(),
                data.get介護給付_要介護4_2(),
                data.get介護給付_要介護5_2(),
                data.get介護給付_その他_2(),
                data.get介護給付の計_2(),
                data.getサービス受給者数合計_2()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_3(),
                data.get予防給付_要支援2_3(),
                data.get予防給付の計_3(),
                data.get介護給付_経過的要介護_3(),
                data.get介護給付_要介護1_3(),
                data.get介護給付_要介護2_3(),
                data.get介護給付_要介護3_3(),
                data.get介護給付_要介護4_3(),
                data.get介護給付_要介護5_3(),
                data.get介護給付_その他_3(),
                data.get介護給付の計_3(),
                data.getサービス受給者数合計_1()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_4(),
                data.get予防給付_要支援2_4(),
                data.get予防給付の計_4(),
                data.get介護給付_経過的要介護_4(),
                data.get介護給付_要介護1_4(),
                data.get介護給付_要介護2_4(),
                data.get介護給付_要介護3_4(),
                data.get介護給付_要介護4_4(),
                data.get介護給付_要介護5_4(),
                data.get介護給付_その他_4(),
                data.get介護給付の計_4(),
                data.getサービス受給者数合計_1()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_4(),
                data.get予防給付_要支援2_5(),
                data.get予防給付の計_5(),
                data.get介護給付_経過的要介護_5(),
                data.get介護給付_要介護1_5(),
                data.get介護給付_要介護2_5(),
                data.get介護給付_要介護3_5(),
                data.get介護給付_要介護4_5(),
                data.get介護給付_要介護5_5(),
                data.get介護給付_その他_5(),
                data.get介護給付の計_5(),
                data.getサービス受給者数合計_5()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_6(),
                data.get予防給付_要支援2_6(),
                data.get予防給付の計_6(),
                data.get介護給付_経過的要介護_6(),
                data.get介護給付_要介護1_6(),
                data.get介護給付_要介護2_6(),
                data.get介護給付_要介護3_6(),
                data.get介護給付_要介護4_6(),
                data.get介護給付_要介護5_6(),
                data.get介護給付_その他_6(),
                data.get介護給付の計_6(),
                data.getサービス受給者数合計_6()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_7(),
                data.get予防給付_要支援2_7(),
                data.get予防給付の計_7(),
                data.get介護給付_経過的要介護_7(),
                data.get介護給付_要介護1_7(),
                data.get介護給付_要介護2_7(),
                data.get介護給付_要介護3_7(),
                data.get介護給付_要介護4_7(),
                data.get介護給付_要介護5_7(),
                data.get介護給付_その他_7(),
                data.get介護給付の計_7(),
                data.getサービス受給者数合計_7()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_8(),
                data.get予防給付_要支援2_8(),
                data.get予防給付の計_8(),
                data.get介護給付_経過的要介護_8(),
                data.get介護給付_要介護1_8(),
                data.get介護給付_要介護2_8(),
                data.get介護給付_要介護3_8(),
                data.get介護給付_要介護4_8(),
                data.get介護給付_要介護5_8(),
                data.get介護給付_その他_8(),
                data.get介護給付の計_8(),
                data.getサービス受給者数合計_8()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_9(),
                data.get予防給付_要支援2_9(),
                data.get予防給付の計_9(),
                data.get介護給付_経過的要介護_9(),
                data.get介護給付_要介護1_9(),
                data.get介護給付_要介護2_9(),
                data.get介護給付_要介護3_9(),
                data.get介護給付_要介護4_9(),
                data.get介護給付_要介護5_9(),
                data.get介護給付_その他_9(),
                data.get介護給付の計_9(),
                data.getサービス受給者数合計_9()));
        list.add(new JigyohokokuCompYoshiki153OldChange(data.get予防給付_要支援1_10(),
                data.get予防給付_要支援2_10(),
                data.get予防給付の計_10(),
                data.get介護給付_経過的要介護_10(),
                data.get介護給付_要介護1_10(),
                data.get介護給付_要介護2_10(),
                data.get介護給付_要介護3_10(),
                data.get介護給付_要介護4_10(),
                data.get介護給付_要介護5_10(),
                data.get介護給付_その他_10(),
                data.get介護給付の計_10(),
                data.getサービス受給者数合計_10()));
        return list;
    }
}
