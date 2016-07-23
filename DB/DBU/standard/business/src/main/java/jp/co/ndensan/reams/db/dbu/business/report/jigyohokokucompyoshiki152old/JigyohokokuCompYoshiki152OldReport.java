/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldChange;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldData;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-040 dangjingjing
 */
public class JigyohokokuCompYoshiki152OldReport extends Report<JigyohokokuCompYoshiki152OldReportSource> {

    private final JigyohokokuCompYoshiki152OldData data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki152OldReport(JigyohokokuCompYoshiki152OldData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki152OldReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki152OldChange change : getBodyData()) {
            IJigyohokokuCompYoshiki152OldEditor editor = new JigyohokokuCompYoshiki152OldEditor(data);
            IJigyohokokuCompYoshiki152OldEditor bodyEditor = new JigyohokokuCompYoshiki152OldBodyEditor(change);
            IJigyohokokuCompYoshiki152OldBuilder builder = new JigyohokokuCompYoshiki152OldBuilder(bodyEditor, editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki152OldChange> getBodyData() {
        List<JigyohokokuCompYoshiki152OldChange> list = new ArrayList<>();
        list.add(new JigyohokokuCompYoshiki152OldChange(data.get予防給付_居宅介護_要支援1_1(),
                data.get予防給付_居宅介護_要支援2_1(),
                data.get予防給付_居宅介護_予防給付の計_1(),
                data.get介護給付_居宅介護_経過的要介護_1(),
                data.get介護給付_居宅介護_要介護1_1(),
                data.get介護給付_居宅介護_要介護2_1(),
                data.get介護給付_居宅介護_要介護3_1(),
                data.get介護給付_居宅介護_要介護4_1(),
                data.get介護給付_居宅介護_要介護5_1(),
                data.get介護給付_居宅介護_介護給付の計_1(),
                data.get介護給付_居宅介護_合計_1(),
                data.get予防給付_地域密着型_要支援1_1(),
                data.get予防給付_地域密着型_要支援2_1(),
                data.get予防給付_地域密着型_予防給付の計_1(),
                data.get介護給付_地域密着型_経過的要介護_1(),
                data.get介護給付_地域密着型_要介護1_1(),
                data.get介護給付_地域密着型_要介護2_1(),
                data.get介護給付_地域密着型_要介護3_1(),
                data.get介護給付_地域密着型_要介護4_1(),
                data.get介護給付_地域密着型_要介護5_1(),
                data.get介護給付_地域密着型_その他_1(),
                data.get介護給付_地域密着型_介護給付の計_1(),
                data.get介護給付_地域密着型_合計_1()));

        list.add(new JigyohokokuCompYoshiki152OldChange(data.get予防給付_居宅介護_要支援1_2(),
                data.get予防給付_居宅介護_要支援2_2(),
                data.get予防給付_居宅介護_予防給付の計_2(),
                data.get介護給付_居宅介護_経過的要介護_2(),
                data.get介護給付_居宅介護_要介護1_2(),
                data.get介護給付_居宅介護_要介護2_2(),
                data.get介護給付_居宅介護_要介護3_2(),
                data.get介護給付_居宅介護_要介護4_2(),
                data.get介護給付_居宅介護_要介護5_2(),
                data.get介護給付_居宅介護_介護給付の計_2(),
                data.get介護給付_居宅介護_合計_2(),
                data.get予防給付_地域密着型_要支援1_2(),
                data.get予防給付_地域密着型_要支援2_2(),
                data.get予防給付_地域密着型_予防給付の計_2(),
                data.get介護給付_地域密着型_経過的要介護_2(),
                data.get介護給付_地域密着型_要介護1_2(),
                data.get介護給付_地域密着型_要介護2_2(),
                data.get介護給付_地域密着型_要介護3_2(),
                data.get介護給付_地域密着型_要介護4_2(),
                data.get介護給付_地域密着型_要介護5_2(),
                data.get介護給付_地域密着型_その他_2(),
                data.get介護給付_地域密着型_介護給付の計_2(),
                data.get介護給付_地域密着型_合計_2()));

        list.add(new JigyohokokuCompYoshiki152OldChange(data.get予防給付_居宅介護_要支援1_3(),
                data.get予防給付_居宅介護_要支援2_3(),
                data.get予防給付_居宅介護_予防給付の計_3(),
                data.get介護給付_居宅介護_経過的要介護_3(),
                data.get介護給付_居宅介護_要介護1_3(),
                data.get介護給付_居宅介護_要介護2_3(),
                data.get介護給付_居宅介護_要介護3_3(),
                data.get介護給付_居宅介護_要介護4_3(),
                data.get介護給付_居宅介護_要介護5_3(),
                data.get介護給付_居宅介護_介護給付の計_3(),
                data.get介護給付_居宅介護_合計_3(),
                data.get予防給付_地域密着型_要支援1_3(),
                data.get予防給付_地域密着型_要支援2_3(),
                data.get予防給付_地域密着型_予防給付の計_3(),
                data.get介護給付_地域密着型_経過的要介護_3(),
                data.get介護給付_地域密着型_要介護1_3(),
                data.get介護給付_地域密着型_要介護2_3(),
                data.get介護給付_地域密着型_要介護3_3(),
                data.get介護給付_地域密着型_要介護4_3(),
                data.get介護給付_地域密着型_要介護5_3(),
                data.get介護給付_地域密着型_その他_3(),
                data.get介護給付_地域密着型_介護給付の計_3(),
                data.get介護給付_地域密着型_合計_3()));
        return list;
    }

}
