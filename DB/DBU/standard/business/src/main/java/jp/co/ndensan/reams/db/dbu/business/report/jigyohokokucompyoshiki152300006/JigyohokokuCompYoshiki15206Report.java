/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152300006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）のReportです。
 *
 * @reamsid_L DBU-5600-160 wangrenze
 */
public class JigyohokokuCompYoshiki15206Report extends Report<JigyohokokuCompYoshiki15206ReportSource> {

    private final JigyohokokuCompYoshiki15206Entity data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行
     */
    public JigyohokokuCompYoshiki15206Report(JigyohokokuCompYoshiki15206Entity data) {
        this.data = data;
    }

    /**
     * インスタンスを生成します。
     *
     * @param entity JigyohokokuCompYoshiki15206Entity
     * @return JigyohokokuCompYoshiki15206Report
     */
    public static JigyohokokuCompYoshiki15206Report createReport(JigyohokokuCompYoshiki15206Entity entity) {
        return new JigyohokokuCompYoshiki15206Report(entity);
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki15206ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki15206BodyData dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki15206Editor editor = new JigyohokokuCompYoshiki15206Editor(data);
            IJigyohokokuCompYoshiki15206Editor bodyEditor = new JigyohokokuCompYoshiki15206BodyEditor(dataBody);
            IJigyohokokuCompYoshiki15206Builder builder = new JigyohokokuCompYoshiki15206Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki15206BodyData> getBodyData() {
        List<JigyohokokuCompYoshiki15206BodyData> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyohokokuCompYoshiki15206BodyData(
                data.get居宅介護_要支援1_1(),
                data.get居宅介護_要支援2_1(),
                data.get居宅介護_予防給付計_1(),
                data.get居宅介護_経過的要介護_1(),
                data.get居宅介護_要介護1_1(),
                data.get居宅介護_要介護2_1(),
                data.get居宅介護_要介護3_1(),
                data.get居宅介護_要介護4_1(),
                data.get居宅介護_要介護5_1(),
                data.get居宅介護_介護給付計_1(),
                data.get居宅介護_合計1(),
                data.get地域密着型_要支援1_1(),
                data.get地域密着型_要支援2_1(),
                data.get地域密着型_予防給付計_1(),
                data.get地域密着型_経過的要介護_1(),
                data.get地域密着型_要介護1_1(),
                data.get地域密着型_要介護2_1(),
                data.get地域密着型_要介護3_1(),
                data.get地域密着型_要介護4_1(),
                data.get地域密着型_要介護5_1(),
                data.getその他1(),
                data.get地域密着型_介護給付計_1(),
                data.get地域密着型_合計1()));
        dataBodyList.add(new JigyohokokuCompYoshiki15206BodyData(
                data.get居宅介護_要支援1_2(),
                data.get居宅介護_要支援2_2(),
                data.get居宅介護_予防給付計_2(),
                data.get居宅介護_経過的要介護_2(),
                data.get居宅介護_要介護1_2(),
                data.get居宅介護_要介護2_2(),
                data.get居宅介護_要介護3_2(),
                data.get居宅介護_要介護4_2(),
                data.get居宅介護_要介護5_2(),
                data.get居宅介護_介護給付計_2(),
                data.get居宅介護_合計2(),
                data.get地域密着型_要支援1_2(),
                data.get地域密着型_要支援2_2(),
                data.get地域密着型_予防給付計_2(),
                data.get地域密着型_経過的要介護_2(),
                data.get地域密着型_要介護1_2(),
                data.get地域密着型_要介護2_2(),
                data.get地域密着型_要介護3_2(),
                data.get地域密着型_要介護4_2(),
                data.get地域密着型_要介護5_2(),
                data.getその他2(),
                data.get地域密着型_介護給付計_2(),
                data.get地域密着型_合計2()));
        dataBodyList.add(new JigyohokokuCompYoshiki15206BodyData(
                data.get居宅介護_要支援1_3(),
                data.get居宅介護_要支援2_3(),
                data.get居宅介護_予防給付計_3(),
                data.get居宅介護_経過的要介護_3(),
                data.get居宅介護_要介護1_3(),
                data.get居宅介護_要介護2_3(),
                data.get居宅介護_要介護3_3(),
                data.get居宅介護_要介護4_3(),
                data.get居宅介護_要介護5_3(),
                data.get居宅介護_介護給付計_3(),
                data.get居宅介護_合計3(),
                data.get地域密着型_要支援1_3(),
                data.get地域密着型_要支援2_3(),
                data.get地域密着型_予防給付計_3(),
                data.get地域密着型_経過的要介護_3(),
                data.get地域密着型_要介護1_3(),
                data.get地域密着型_要介護2_3(),
                data.get地域密着型_要介護3_3(),
                data.get地域密着型_要介護4_3(),
                data.get地域密着型_要介護5_3(),
                data.getその他3(),
                data.get地域密着型_介護給付計_3(),
                data.get地域密着型_合計3()));
        return dataBodyList;
    }
}
