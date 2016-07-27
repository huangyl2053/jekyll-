/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki300104;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki12.JigyohokokuCompYoshiki12Change;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103Data;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki300103.JigyohokokuCompYoshiki300103ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護事業状況報告年報（様式1-3）のReportです。
 *
 * @reamsid_L DBU-5600-130 lishengli
 */
public class JigyohokokuCompYoshiki300104Report extends Report<JigyohokokuCompYoshiki300103ReportSource> {

    private final JigyohokokuCompYoshiki300103Data data;

    /**
     * インスタンスを生成します。
     *
     * @param data 申請に関する帳票発行のdataList
     */
    public JigyohokokuCompYoshiki300104Report(JigyohokokuCompYoshiki300103Data data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyohokokuCompYoshiki300103ReportSource> reportSourceWriter) {
        for (JigyohokokuCompYoshiki12Change dataBody : getBodyData()) {
            IJigyohokokuCompYoshiki300104Editor editor = new JigyohokokuCompYoshiki300104Editor(data);
            IJigyohokokuCompYoshiki300104Editor bodyEditor = new JigyohokokuCompYoshiki300104BodyEditor(dataBody);
            IJigyohokokuCompYoshiki300104Builder builder = new JigyohokokuCompYoshiki300104Builder(editor, bodyEditor);
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
