/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki14;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki14.JigyohokokuCompYoshiki14ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-4） のReportです。
 *
 * @reamsid_L DBU-5530-070 dangjingjing
 */
public class JigyohokokuCompYoshiki14Report extends Report<JigyohokokuCompYoshiki14ReportSource> {

    private final JigyohokokuCompYoshiki14Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki14Report(JigyohokokuCompYoshiki14Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki14ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki14Change change : getData()) {
            IJigyohokokuCompYoshiki14Editor editor = new JigyohokokuCompYoshiki14Editor(data, change);
            IJigyohokokuCompYoshiki14Builder builder = new JigyohokokuCompYoshiki14Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyohokokuCompYoshiki14Change> getData() {
        List<JigyohokokuCompYoshiki14Change> dataList = new ArrayList<>();
        dataList.add(new JigyohokokuCompYoshiki14Change(data.get介護老人福祉施設_食費_1(),
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
        dataList.add(new JigyohokokuCompYoshiki14Change(data.get介護老人福祉施設_食費_2(),
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
        dataList.add(new JigyohokokuCompYoshiki14Change(data.get介護老人福祉施設_食費_3(),
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
        dataList.add(new JigyohokokuCompYoshiki14Change(data.get介護老人福祉施設_食費_4(),
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
