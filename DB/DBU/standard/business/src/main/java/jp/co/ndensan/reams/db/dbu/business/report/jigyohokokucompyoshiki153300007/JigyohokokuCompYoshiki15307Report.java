/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153300007.JigyohokokuCompYoshiki15307ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）のReportです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
public class JigyohokokuCompYoshiki15307Report extends Report<JigyohokokuCompYoshiki15307ReportSource> {

    private final JigyohokokuCompYoshiki15307Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行
     */
    public JigyohokokuCompYoshiki15307Report(JigyohokokuCompYoshiki15307Entity data) {
        this.data = data;
    }

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompYoshiki15307Entity
     * @return JigyohokokuCompYoshiki15307Report
     */
    public static JigyohokokuCompYoshiki15307Report createReport(JigyohokokuCompYoshiki15307Entity entity) {
        return new JigyohokokuCompYoshiki15307Report(entity);
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki15307ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki15307BodyData dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki15307Editor editor = new JigyohokokuCompYoshiki15307Editor(data);
            IJigyohokokuCompYoshiki15307Editor bodyEditor = new JigyohokokuCompYoshiki15307BodyEditor(dataBody);
            IJigyohokokuCompYoshiki15307Builder builder = new JigyohokokuCompYoshiki15307Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki15307BodyData> getBodyData() {
        List<JigyohokokuCompYoshiki15307BodyData> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_1(), data.get要支援2_1(), data.get予防給付計_1(), data.get経過的要介護_1(),
                data.get要介護1_1(), data.get要介護2_1(), data.get要介護3_1(), data.get要介護4_1(),
                data.get要介護5_1(), data.getその他1(), data.get介護給付計_1(), data.get合計1()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_2(), data.get要支援2_2(), data.get予防給付計_2(), data.get経過的要介護_2(),
                data.get要介護1_2(), data.get要介護2_2(), data.get要介護3_2(), data.get要介護4_2(),
                data.get要介護5_2(), data.getその他2(), data.get介護給付計_2(), data.get合計2()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_3(), data.get要支援2_3(), data.get予防給付計_3(), data.get経過的要介護_3(),
                data.get要介護1_3(), data.get要介護2_3(), data.get要介護3_3(), data.get要介護4_3(),
                data.get要介護5_3(), data.getその他3(), data.get介護給付計_3(), data.get合計3()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_4(), data.get要支援2_4(), data.get予防給付計_4(), data.get経過的要介護_4(),
                data.get要介護1_4(), data.get要介護2_4(), data.get要介護3_4(), data.get要介護4_4(),
                data.get要介護5_4(), data.getその他4(), data.get介護給付計_4(), data.get合計4()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_5(), data.get要支援2_5(), data.get予防給付計_5(), data.get経過的要介護_5(),
                data.get要介護1_5(), data.get要介護2_5(), data.get要介護3_5(), data.get要介護4_5(),
                data.get要介護5_5(), data.getその他5(), data.get介護給付計_5(), data.get合計5()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_6(), data.get要支援2_6(), data.get予防給付計_6(), data.get経過的要介護_6(),
                data.get要介護1_6(), data.get要介護2_6(), data.get要介護3_6(), data.get要介護4_6(),
                data.get要介護5_6(), data.getその他6(), data.get介護給付計_6(), data.get合計6()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_7(), data.get要支援2_7(), data.get予防給付計_7(), data.get経過的要介護_7(),
                data.get要介護1_7(), data.get要介護2_7(), data.get要介護3_7(), data.get要介護4_7(),
                data.get要介護5_7(), data.getその他7(), data.get介護給付計_7(), data.get合計7()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_8(), data.get要支援2_8(), data.get予防給付計_8(), data.get経過的要介護_8(),
                data.get要介護1_8(), data.get要介護2_8(), data.get要介護3_8(), data.get要介護4_8(),
                data.get要介護5_8(), data.getその他8(), data.get介護給付計_8(), data.get合計8()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_9(), data.get要支援2_9(), data.get予防給付計_9(), data.get経過的要介護_9(),
                data.get要介護1_9(), data.get要介護2_9(), data.get要介護3_9(), data.get要介護4_9(),
                data.get要介護5_9(), data.getその他9(), data.get介護給付計_9(), data.get合計9()));
        dataBodyList.add(new JigyohokokuCompYoshiki15307BodyData(
                data.get要支援1_10(), data.get要支援2_10(), data.get予防給付計_10(), data.get経過的要介護_10(),
                data.get要介護1_10(), data.get要介護2_10(), data.get要介護3_10(), data.get要介護4_10(),
                data.get要介護5_10(), data.getその他10(), data.get介護給付計_10(), data.get合計10()));
        return dataBodyList;
    }
}
