/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki12;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告月報・一般状況（様式1-2）のReportです。
 *
 * @reamsid_L DBU-5530-050 dongyabin
 */
public class JigyohokokuCompYoshiki12Report extends Report<JigyohokokuCompYoshiki12ReportSource> {

    private final JigyohokokuCompYoshiki12Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki12Report(JigyohokokuCompYoshiki12Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki12ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki12Change dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki12Editor editor = new JigyohokokuCompYoshiki12Editor(data);
            IJigyohokokuCompYoshiki12Editor bodyEditor = new JigyohokokuCompYoshiki12BodyEditor(dataBody);
            IJigyohokokuCompYoshiki12Builder builder = new JigyohokokuCompYoshiki12Builder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }

    }

    private List<JigyohokokuCompYoshiki12Change> getBodyData() {
        List<JigyohokokuCompYoshiki12Change> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_1(),
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
                data.get合計_居住費_1(),
                data.get免除認定表の利用者負担_1(),
                data.get減免認定表の特定負担限度額_食費_1(),
                data.get減免認定表の特定負担限度額_居住費_1(),
                data.get免除認定表の利用者負担_1()));
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_2(),
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
                data.get合計_居住費_2(),
                data.get免除認定表の利用者負担_2(),
                data.get減免認定表の特定負担限度額_食費_2(),
                data.get減免認定表の特定負担限度額_居住費_2(),
                data.get免除認定表の利用者負担_2()));
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_3(),
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
                data.get合計_居住費_3(),
                data.get免除認定表の利用者負担_3(),
                data.get減免認定表の特定負担限度額_食費_3(),
                data.get減免認定表の特定負担限度額_居住費_3(),
                data.get免除認定表の利用者負担_3()));
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_4(),
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
                data.get合計_居住費_4(),
                data.get免除認定表の利用者負担_4(),
                data.get減免認定表の特定負担限度額_食費_4(),
                data.get減免認定表の特定負担限度額_居住費_4(),
                data.get免除認定表の利用者負担_4()));
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_5(),
                data.get介護老人福祉施設_居住費_5(),
                data.get介護老人保健施設_食費_5(),
                data.get介護老人保健施設_居住費_5(),
                data.get介護療養型医療施設_食費_5(),
                data.get介護療養型医療施設_居住費_5(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_5(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_5(),
                data.getその他_食費_5(),
                data.getその他_居住費_5(),
                data.get合計_食費_5(),
                data.get合計_居住費_5(),
                data.get免除認定表の利用者負担_5(),
                data.get減免認定表の特定負担限度額_食費_5(),
                data.get減免認定表の特定負担限度額_居住費_5(),
                data.get免除認定表の利用者負担_5()));
        dataBodyList.add(new JigyohokokuCompYoshiki12Change(data.get介護老人福祉施設_食費_6(),
                data.get介護老人福祉施設_居住費_6(),
                data.get介護老人保健施設_食費_6(),
                data.get介護老人保健施設_居住費_6(),
                data.get介護療養型医療施設_食費_6(),
                data.get介護療養型医療施設_居住費_6(),
                data.get地域密着型介護老人福祉施設入居者生活介護_食費_6(),
                data.get地域密着型介護老人福祉施設入居者生活介護_居住費_6(),
                data.getその他_食費_6(),
                data.getその他_居住費_6(),
                data.get合計_食費_6(),
                data.get合計_居住費_6(),
                data.get免除認定表の利用者負担_6(),
                data.get減免認定表の特定負担限度額_食費_6(),
                data.get減免認定表の特定負担限度額_居住費_6(),
                data.get免除認定表の利用者負担_6()));
        return dataBodyList;
    }
}
