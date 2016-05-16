/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.Shinsakaishukeihyo;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo.ShinsakaishukeihyoBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会集計表（判定別）のReportです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
public class ShinsakaishukeihyoReport extends Report<ShinsakaishukeihyoReportSource> {

    private final Shinsakaishukeihyo data;

    /**
     * インスタンスを生成します。
     *
     * @param data 介護認定審査会集計表（判定別）のdataList
     */
    public ShinsakaishukeihyoReport(Shinsakaishukeihyo data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaishukeihyoReportSource> reportSourceWriter) {
        for (ShinsakaishukeihyoBody dataBody : getBodyData(data)) {
            IShinsakaishukeihyoEditor editor = new ShinsakaishukeihyoEditor(data);
            IShinsakaishukeihyoBodyEditor bodyEditor = new ShinsakaishukeihyoBodyEditor(dataBody);
            IShinsakaishukeihyoBuilder builder = new ShinsakaishukeihyoBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ShinsakaishukeihyoBody> getBodyData(Shinsakaishukeihyo data) {
        List<ShinsakaishukeihyoBody> dataBodyList = new ArrayList<>();
        dataBodyList.add(new ShinsakaishukeihyoBody(RString.EMPTY,
                data.get二次判定非該当タイトル(),
                data.get二次判定要支援1タイトル(),
                data.get二次判定要支援2タイトル(),
                data.get二次判定要介護1タイトル(),
                data.get二次判定要介護2タイトル(),
                data.get二次判定要介護3タイトル(),
                data.get二次判定要介護4タイトル(),
                data.get二次判定要介護5タイトル(),
                data.get前回二次判定_計タイトル()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定非該当タイトル(),
                data.get前回二次判定非該当_二次判定非該当(),
                data.get前回二次判定非該当_二次判定要支援1(),
                data.get前回二次判定非該当_二次判定要支援2(),
                data.get前回二次判定非該当_二次判定要介護1(),
                data.get前回二次判定非該当_二次判定要介護2(),
                data.get前回二次判定非該当_二次判定要介護3(),
                data.get前回二次判定非該当_二次判定要介護4(),
                data.get前回二次判定非該当_二次判定要介護5(),
                data.get前回二次判定非該当_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要支援1タイトル(),
                data.get前回二次判定要支援1_二次判定非該当(),
                data.get前回二次判定要支援1_二次判定要支援1(),
                data.get前回二次判定要支援1_二次判定要支援2(),
                data.get前回二次判定要支援1_二次判定要介護1(),
                data.get前回二次判定要支援1_二次判定要介護2(),
                data.get前回二次判定要支援1_二次判定要介護3(),
                data.get前回二次判定要支援1_二次判定要介護4(),
                data.get前回二次判定要支援1_二次判定要介護5(),
                data.get前回二次判定要支援1_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要支援2タイトル(),
                data.get前回二次判定要支援2_二次判定非該当(),
                data.get前回二次判定要支援2_二次判定要支援1(),
                data.get前回二次判定要支援2_二次判定要支援2(),
                data.get前回二次判定要支援2_二次判定要介護1(),
                data.get前回二次判定要支援2_二次判定要介護2(),
                data.get前回二次判定要支援2_二次判定要介護3(),
                data.get前回二次判定要支援2_二次判定要介護4(),
                data.get前回二次判定要支援2_二次判定要介護5(),
                data.get前回二次判定要支援2_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要介護1タイトル(),
                data.get前回二次判定要介護1_二次判定非該当(),
                data.get前回二次判定要介護1_二次判定要支援1(),
                data.get前回二次判定要介護1_二次判定要支援2(),
                data.get前回二次判定要介護1_二次判定要介護1(),
                data.get前回二次判定要介護1_二次判定要介護2(),
                data.get前回二次判定要介護1_二次判定要介護3(),
                data.get前回二次判定要介護1_二次判定要介護4(),
                data.get前回二次判定要介護1_二次判定要介護5(),
                data.get前回二次判定要介護1_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要介護2タイトル(),
                data.get前回二次判定要介護2_二次判定非該当(),
                data.get前回二次判定要介護2_二次判定要支援1(),
                data.get前回二次判定要介護2_二次判定要支援2(),
                data.get前回二次判定要介護2_二次判定要介護1(),
                data.get前回二次判定要介護2_二次判定要介護2(),
                data.get前回二次判定要介護2_二次判定要介護3(),
                data.get前回二次判定要介護2_二次判定要介護4(),
                data.get前回二次判定要介護2_二次判定要介護5(),
                data.get前回二次判定要介護2_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要介護3タイトル(),
                data.get前回二次判定要介護3_二次判定非該当(),
                data.get前回二次判定要介護3_二次判定要支援1(),
                data.get前回二次判定要介護3_二次判定要支援2(),
                data.get前回二次判定要介護3_二次判定要介護1(),
                data.get前回二次判定要介護3_二次判定要介護2(),
                data.get前回二次判定要介護3_二次判定要介護3(),
                data.get前回二次判定要介護3_二次判定要介護4(),
                data.get前回二次判定要介護3_二次判定要介護5(),
                data.get前回二次判定要介護3_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要介護4タイトル(),
                data.get前回二次判定要介護4_二次判定非該当(),
                data.get前回二次判定要介護4_二次判定要支援1(),
                data.get前回二次判定要介護4_二次判定要支援2(),
                data.get前回二次判定要介護4_二次判定要介護1(),
                data.get前回二次判定要介護4_二次判定要介護2(),
                data.get前回二次判定要介護4_二次判定要介護3(),
                data.get前回二次判定要介護4_二次判定要介護4(),
                data.get前回二次判定要介護4_二次判定要介護5(),
                data.get前回二次判定要介護4_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get前回二次判定要介護5タイトル(),
                data.get前回二次判定要介護5_二次判定非該当(),
                data.get前回二次判定要介護5_二次判定要支援1(),
                data.get前回二次判定要介護5_二次判定要支援2(),
                data.get前回二次判定要介護5_二次判定要介護1(),
                data.get前回二次判定要介護5_二次判定要介護2(),
                data.get前回二次判定要介護5_二次判定要介護3(),
                data.get前回二次判定要介護5_二次判定要介護4(),
                data.get前回二次判定要介護5_二次判定要介護5(),
                data.get前回二次判定要介護5_計()));
        dataBodyList.add(new ShinsakaishukeihyoBody(data.get計タイトル(),
                data.get計_二次判定非該当(),
                data.get計_二次判定要支援1(),
                data.get計_二次判定要支援2(),
                data.get計_二次判定要介護1(),
                data.get計_二次判定要介護2(),
                data.get計_二次判定要介護3(),
                data.get計_二次判定要介護4(),
                data.get計_二次判定要介護5(),
                data.get計_計()));
        return dataBodyList;
    }
}
