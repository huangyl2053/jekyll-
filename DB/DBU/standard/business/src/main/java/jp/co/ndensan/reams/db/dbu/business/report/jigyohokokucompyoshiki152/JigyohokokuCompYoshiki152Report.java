/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152.JigyohokokuCompYoshiki152ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）_新様式 のReportです。
 *
 * @reamsid_L DBU-5540-050 dangjingjing
 */
public class JigyohokokuCompYoshiki152Report extends Report<JigyohokokuCompYoshiki152ReportSource> {

    private final JigyohokokuCompYoshiki152Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki152Report(JigyohokokuCompYoshiki152Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki152ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki152Change change : getBodyData()) {
            IJigyohokokuCompYoshiki152Editor editor = new JigyohokokuCompYoshiki152Editor(data);
            IJigyohokokuCompYoshiki152Editor bodyEditor = new JigyohokokuCompYoshiki152BodyEditor(change);
            IJigyohokokuCompYoshiki152Builder builder = new JigyohokokuCompYoshiki152Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki152Change> getBodyData() {
        List<JigyohokokuCompYoshiki152Change> bodyDatalist = new ArrayList<>();
        bodyDatalist.add(new JigyohokokuCompYoshiki152Change(data.get予防給付_居宅介護_要支援1_1(),
                data.get予防給付_居宅介護_要支援2_1(),
                data.get予防給付_居宅介護_要支援合計_1(),
                data.get介護給付_居宅介護_経過的要介護_1(),
                data.get介護給付_居宅介護_要介護1_1(),
                data.get介護給付_居宅介護_要介護2_1(),
                data.get介護給付_居宅介護_要介護3_1(),
                data.get介護給付_居宅介護_要介護4_1(),
                data.get介護給付_居宅介護_要介護5_1(),
                data.get介護給付_居宅介護_要介護合計_1(),
                data.get居宅介護_サービス受給者数合計_1(),
                data.get予備_1(),
                data.get予防給付_地域密着型_要支援1_1(),
                data.get予防給付_地域密着型_要支援2_1(),
                data.get予防給付_地域密着型_要支援合計_1(),
                data.get介護給付_地域密着型_経過的要介護_1(),
                data.get介護給付_地域密着型_要介護1_1(),
                data.get介護給付_地域密着型_要介護2_1(),
                data.get介護給付_地域密着型_要介護3_1(),
                data.get介護給付_地域密着型_要介護4_1(),
                data.get介護給付_地域密着型_要介護5_1(),
                data.get介護給付_地域密着型_その他_1(),
                data.get介護給付_地域密着型_要介護合計_1(),
                data.get地域密着型_サービス受給者数合計_1()));
        bodyDatalist.add(new JigyohokokuCompYoshiki152Change(data.get予防給付_居宅介護_要支援1_2(),
                data.get予防給付_居宅介護_要支援2_2(),
                data.get予防給付_居宅介護_要支援合計_2(),
                data.get介護給付_居宅介護_経過的要介護_2(),
                data.get介護給付_居宅介護_要介護1_2(),
                data.get介護給付_居宅介護_要介護2_2(),
                data.get介護給付_居宅介護_要介護3_2(),
                data.get介護給付_居宅介護_要介護4_2(),
                data.get介護給付_居宅介護_要介護5_2(),
                data.get介護給付_居宅介護_要介護合計_2(),
                data.get居宅介護_サービス受給者数合計_2(),
                data.get予備_2(),
                data.get予防給付_地域密着型_要支援1_2(),
                data.get予防給付_地域密着型_要支援2_2(),
                data.get予防給付_地域密着型_要支援合計_2(),
                data.get介護給付_地域密着型_経過的要介護_2(),
                data.get介護給付_地域密着型_要介護1_2(),
                data.get介護給付_地域密着型_要介護2_2(),
                data.get介護給付_地域密着型_要介護3_2(),
                data.get介護給付_地域密着型_要介護4_2(),
                data.get介護給付_地域密着型_要介護5_2(),
                data.get介護給付_地域密着型_その他_2(),
                data.get介護給付_地域密着型_要介護合計_2(),
                data.get地域密着型_サービス受給者数合計_2()));
        bodyDatalist.add(new JigyohokokuCompYoshiki152Change(data.get予防給付_居宅介護_要支援1_3(),
                data.get予防給付_居宅介護_要支援2_3(),
                data.get予防給付_居宅介護_要支援合計_3(),
                data.get介護給付_居宅介護_経過的要介護_3(),
                data.get介護給付_居宅介護_要介護1_3(),
                data.get介護給付_居宅介護_要介護2_3(),
                data.get介護給付_居宅介護_要介護3_3(),
                data.get介護給付_居宅介護_要介護4_3(),
                data.get介護給付_居宅介護_要介護5_3(),
                data.get介護給付_居宅介護_要介護合計_3(),
                data.get居宅介護_サービス受給者数合計_3(),
                data.get予備_1(),
                data.get予防給付_地域密着型_要支援1_3(),
                data.get予防給付_地域密着型_要支援2_3(),
                data.get予防給付_地域密着型_要支援合計_3(),
                data.get介護給付_地域密着型_経過的要介護_3(),
                data.get介護給付_地域密着型_要介護1_3(),
                data.get介護給付_地域密着型_要介護2_3(),
                data.get介護給付_地域密着型_要介護3_3(),
                data.get介護給付_地域密着型_要介護4_3(),
                data.get介護給付_地域密着型_要介護5_3(),
                data.get介護給付_地域密着型_その他_3(),
                data.get介護給付_地域密着型_要介護合計_3(),
                data.get地域密着型_サービス受給者数合計_3()));
        return bodyDatalist;
    }
}
