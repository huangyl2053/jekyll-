/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14300105;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14300105.JigyohokokuCompYoshiki14300105ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報（様式1-4）のReportクラスです。
 *
 * @reamsid_L DBU-5600-140 lishengli
 */
public class JigyohokokuCompYoshiki14300105Report extends Report<JigyohokokuCompYoshiki14300105ReportSource> {

    private final JigyohokokuCompYoshiki14300105Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data JigyohokokuCompYoshiki14300105Data
     */
    public JigyohokokuCompYoshiki14300105Report(JigyohokokuCompYoshiki14300105Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki14300105ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki14300105Change change : getData()) {
            IJigyohokokuCompYoshiki14300105Editor editor = new JigyohokokuCompYoshiki14300105Editor(data, change);
            IJigyohokokuCompYoshiki14300105Builder builder = new JigyohokokuCompYoshiki14300105Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki14300105Change> getData() {
        List<JigyohokokuCompYoshiki14300105Change> dataList = new ArrayList<>();
        dataList.add(new JigyohokokuCompYoshiki14300105Change(data.get介護老人福祉施設_食費_1(),
                data.get介護老人福祉施設_居住費_1(),
                data.get介護老人保健施設_食費_1(),
                data.get介護老人保健施設_居住費_1(),
                data.get介護療養型医療施設_食費_1(),
                data.get介護療養型医療施設_居住費_1(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_1(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_1(),
                data.getその他_食費_1(),
                data.getその他_居住費_1(),
                data.get合計_食費_1(),
                data.get合計_居住費_1()));

        dataList.add(new JigyohokokuCompYoshiki14300105Change(data.get介護老人福祉施設_食費_2(),
                data.get介護老人福祉施設_居住費_2(),
                data.get介護老人保健施設_食費_2(),
                data.get介護老人保健施設_居住費_2(),
                data.get介護療養型医療施設_食費_2(),
                data.get介護療養型医療施設_居住費_2(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_2(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_2(),
                data.getその他_食費_2(),
                data.getその他_居住費_2(),
                data.get合計_食費_2(),
                data.get合計_居住費_2()));

        dataList.add(new JigyohokokuCompYoshiki14300105Change(data.get介護老人福祉施設_食費_3(),
                data.get介護老人福祉施設_居住費_3(),
                data.get介護老人保健施設_食費_3(),
                data.get介護老人保健施設_居住費_3(),
                data.get介護療養型医療施設_食費_3(),
                data.get介護療養型医療施設_居住費_3(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_3(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_3(),
                data.getその他_食費_3(),
                data.getその他_居住費_3(),
                data.get合計_食費_3(),
                data.get合計_居住費_3()));

        dataList.add(new JigyohokokuCompYoshiki14300105Change(data.get介護老人福祉施設_食費_4(),
                data.get介護老人福祉施設_居住費_4(),
                data.get介護老人保健施設_食費_4(),
                data.get介護老人保健施設_居住費_4(),
                data.get介護療養型医療施設_食費_4(),
                data.get介護療養型医療施設_居住費_4(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_4(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_4(),
                data.getその他_食費_4(),
                data.getその他_居住費_4(),
                data.get合計_食費_4(),
                data.get合計_居住費_4()));
        return dataList;
    }
}
