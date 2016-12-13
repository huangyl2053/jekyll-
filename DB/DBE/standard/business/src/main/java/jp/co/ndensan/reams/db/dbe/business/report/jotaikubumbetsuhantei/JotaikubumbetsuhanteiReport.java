/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.Jotaikubumbetsuhantei;
import jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei.JotaikubumbetsuhanteiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護状態区分別判定件数のReportです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
public class JotaikubumbetsuhanteiReport extends Report<JotaikubumbetsuhanteiReportSource> {

    private final Jotaikubumbetsuhantei data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public JotaikubumbetsuhanteiReport(Jotaikubumbetsuhantei data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JotaikubumbetsuhanteiReportSource> reportSourceWriter) {
        for (JotaikubumbetsuhanteiBody dataBody : getBodyData(data)) {
            IJotaikubumbetsuhanteiEditor editor = new JotaikubumbetsuhanteiEditor(data);
            IJotaikubumbetsuhanteiBodyEditor bodyEditor = new JotaikubumbetsuhanteiBodyEditor(dataBody);
            IJotaikubumbetsuhanteiBuilder builder = new JotaikubumbetsuhanteiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JotaikubumbetsuhanteiBody> getBodyData(Jotaikubumbetsuhantei data) {
        List<JotaikubumbetsuhanteiBody> dataList = new ArrayList<>();
        dataList.add(new JotaikubumbetsuhanteiBody(RString.EMPTY,
                data.get二次判定非該当タイトル(),
                data.get二次判定要支援1タイトル(),
                data.get二次判定要支援2タイトル(),
                data.get二次判定要介護1タイトル(),
                data.get二次判定要介護2タイトル(),
                data.get二次判定要介護3タイトル(),
                data.get二次判定要介護4タイトル(),
                data.get二次判定要介護5タイトル(),
                data.get一次判定_計タイトル(),
                data.get一次判定非該当_再調査二次保留分(),
                data.get一次判定非該当_判定変更者数(),
                data.get一次判定非該当_軽度変更者数(),
                data.get一次判定非該当_重度変更者数(),
                data.get一次判定非該当_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定非該当タイトル(),
                data.get一次判定非該当_二次判定非該当(),
                data.get一次判定非該当_二次判定要支援1(),
                data.get一次判定非該当_二次判定要支援2(),
                data.get一次判定非該当_二次判定要介護1(),
                data.get一次判定非該当_二次判定要介護2(),
                data.get一次判定非該当_二次判定要介護3(),
                data.get一次判定非該当_二次判定要介護4(),
                data.get一次判定非該当_二次判定要介護5(),
                data.get一次判定非該当_計(),
                data.get一次判定要支援1_再調査二次保留分(),
                data.get一次判定要支援1_判定変更者数(),
                data.get一次判定要支援1_軽度変更者数(),
                data.get一次判定要支援1_重度変更者数(),
                data.get一次判定要支援1_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要支援1タイトル(),
                data.get一次判定要支援1_二次判定非該当(),
                data.get一次判定要支援1_二次判定要支援1(),
                data.get一次判定要支援1_二次判定要支援2(),
                data.get一次判定要支援1_二次判定要介護1(),
                data.get一次判定要支援1_二次判定要介護2(),
                data.get一次判定要支援1_二次判定要介護3(),
                data.get一次判定要支援1_二次判定要介護4(),
                data.get一次判定要支援1_二次判定要介護5(),
                data.get一次判定要支援1_計(),
                data.get一次判定要支援2_再調査二次保留分(),
                data.get一次判定要支援2_判定変更者数(),
                data.get一次判定要支援2_軽度変更者数(),
                data.get一次判定要支援2_重度変更者数(),
                data.get一次判定要支援2_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要支援2タイトル(),
                data.get一次判定要支援2_二次判定非該当(),
                data.get一次判定要支援2_二次判定要支援1(),
                data.get一次判定要支援2_二次判定要支援2(),
                data.get一次判定要支援2_二次判定要介護1(),
                data.get一次判定要支援2_二次判定要介護2(),
                data.get一次判定要支援2_二次判定要介護3(),
                data.get一次判定要支援2_二次判定要介護4(),
                data.get一次判定要支援2_二次判定要介護5(),
                data.get一次判定要支援2_計(),
                data.get一次判定要介護1_再調査二次保留分(),
                data.get一次判定要介護1_判定変更者数(),
                data.get一次判定要介護1_軽度変更者数(),
                data.get一次判定要介護1_重度変更者数(),
                data.get一次判定要介護1_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要介護1タイトル(),
                data.get一次判定要介護1_二次判定非該当(),
                data.get一次判定要介護1_二次判定要支援1(),
                data.get一次判定要介護1_二次判定要支援2(),
                data.get一次判定要介護1_二次判定要介護1(),
                data.get一次判定要介護1_二次判定要介護2(),
                data.get一次判定要介護1_二次判定要介護3(),
                data.get一次判定要介護1_二次判定要介護4(),
                data.get一次判定要介護1_二次判定要介護5(),
                data.get一次判定要介護1_計(),
                data.get一次判定要介護2_再調査二次保留分(),
                data.get一次判定要介護2_判定変更者数(),
                data.get一次判定要介護2_軽度変更者数(),
                data.get一次判定要介護2_重度変更者数(),
                data.get一次判定要介護2_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要介護2タイトル(),
                data.get一次判定要介護2_二次判定非該当(),
                data.get一次判定要介護2_二次判定要支援1(),
                data.get一次判定要介護2_二次判定要支援2(),
                data.get一次判定要介護2_二次判定要介護1(),
                data.get一次判定要介護2_二次判定要介護2(),
                data.get一次判定要介護2_二次判定要介護3(),
                data.get一次判定要介護2_二次判定要介護4(),
                data.get一次判定要介護2_二次判定要介護5(),
                data.get一次判定要介護2_計(),
                data.get一次判定要介護3_再調査二次保留分(),
                data.get一次判定要介護3_判定変更者数(),
                data.get一次判定要介護3_軽度変更者数(),
                data.get一次判定要介護3_重度変更者数(),
                data.get一次判定要介護3_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要介護3タイトル(),
                data.get一次判定要介護3_二次判定非該当(),
                data.get一次判定要介護3_二次判定要支援1(),
                data.get一次判定要介護3_二次判定要支援2(),
                data.get一次判定要介護3_二次判定要介護1(),
                data.get一次判定要介護3_二次判定要介護2(),
                data.get一次判定要介護3_二次判定要介護3(),
                data.get一次判定要介護3_二次判定要介護4(),
                data.get一次判定要介護3_二次判定要介護5(),
                data.get一次判定要介護3_計(),
                data.get一次判定要介護4_再調査二次保留分(),
                data.get一次判定要介護4_判定変更者数(),
                data.get一次判定要介護4_軽度変更者数(),
                data.get一次判定要介護4_重度変更者数(),
                data.get一次判定要介護4_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要介護4タイトル(),
                data.get一次判定要介護4_二次判定非該当(),
                data.get一次判定要介護4_二次判定要支援1(),
                data.get一次判定要介護4_二次判定要支援2(),
                data.get一次判定要介護4_二次判定要介護1(),
                data.get一次判定要介護4_二次判定要介護2(),
                data.get一次判定要介護4_二次判定要介護3(),
                data.get一次判定要介護4_二次判定要介護4(),
                data.get一次判定要介護4_二次判定要介護5(),
                data.get一次判定要介護4_計(),
                data.get一次判定要介護5_再調査二次保留分(),
                data.get一次判定要介護5_判定変更者数(),
                data.get一次判定要介護5_軽度変更者数(),
                data.get一次判定要介護5_重度変更者数(),
                data.get一次判定要介護5_判定変更割合()));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get一次判定要介護5タイトル(),
                data.get一次判定要介護5_二次判定非該当(),
                data.get一次判定要介護5_二次判定要支援1(),
                data.get一次判定要介護5_二次判定要支援2(),
                data.get一次判定要介護5_二次判定要介護1(),
                data.get一次判定要介護5_二次判定要介護2(),
                data.get一次判定要介護5_二次判定要介護3(),
                data.get一次判定要介護5_二次判定要介護4(),
                data.get一次判定要介護5_二次判定要介護5(),
                data.get一次判定要介護5_計(),
                data.get計_再調査二次保留分(),
                data.get計_判定変更者数(),
                data.get計_軽度変更者数(),
                data.get計_重度変更者数(),
                data.get計_判定変更割合()));
        dataList.addAll(getBodyDataBak(data));
        return dataList;
    }

    private List<JotaikubumbetsuhanteiBody> getBodyDataBak(Jotaikubumbetsuhantei data) {
        List<JotaikubumbetsuhanteiBody> dataList = new ArrayList<>();
        dataList.add(new JotaikubumbetsuhanteiBody(data.get計タイトル(),
                data.get計_二次判定非該当(),
                data.get計_二次判定要支援1(),
                data.get計_二次判定要支援2(),
                data.get計_二次判定要介護1(),
                data.get計_二次判定要介護2(),
                data.get計_二次判定要介護3(),
                data.get計_二次判定要介護4(),
                data.get計_二次判定要介護5(),
                data.get計_計(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get変更者タイトル(),
                data.get変更者_二次判定非該当(),
                data.get変更者_二次判定要支援1(),
                data.get変更者_二次判定要支援2(),
                data.get変更者_二次判定要介護1(),
                data.get変更者_二次判定要介護2(),
                data.get変更者_二次判定要介護3(),
                data.get変更者_二次判定要介護4(),
                data.get変更者_二次判定要介護5(),
                data.get変更者_計(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        dataList.add(new JotaikubumbetsuhanteiBody(data.get割合タイトル(),
                data.get割合_二次判定非該当(),
                data.get割合_二次判定要支援1(),
                data.get割合_二次判定要支援2(),
                data.get割合_二次判定要介護1(),
                data.get割合_二次判定要介護2(),
                data.get割合_二次判定要介護3(),
                data.get割合_二次判定要介護4(),
                data.get割合_二次判定要介護5(),
                data.get割合_計(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));
        return dataList;
    }
}
