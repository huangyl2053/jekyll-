/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jigyojokyohokoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokoku;
import jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku.JigyoJokyoHokokuDataChange;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jigyojokyohokoku.JigyoJokyoHokokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定事業状況報告のReportです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
public class JigyoJokyoHokokuReport extends Report<JigyoJokyoHokokuReportSource> {

    private final JigyoJokyoHokoku data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護認定事業状況報告のdataList
     */
    public JigyoJokyoHokokuReport(JigyoJokyoHokoku data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JigyoJokyoHokokuReportSource> reportSourceWriter) {
        for (JigyoJokyoHokokuDataChange dataBody : getBodyData(data)) {
            IJigyoJokyoHokokuEditor editor = new JigyoJokyoHokokuEditor(data);
            IJigyoJokyoHokokuBodyEditor bodyEditor = new JigyoJokyoHokokuBodyEditor(dataBody);
            IJigyoJokyoHokokuBuilder builder = new JigyoJokyoHokokuBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JigyoJokyoHokokuDataChange> getBodyData(JigyoJokyoHokoku data) {
        List<JigyoJokyoHokokuDataChange> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get第1号被保険者タイトル(),
                get認定者数(data.get第1号被保険者_非該当()),
                get認定者数(data.get第1号被保険者_支援1()),
                get認定者数(data.get第1号被保険者_支援2()),
                get認定者数(data.get第1号被保険者_要介護1()),
                get認定者数(data.get第1号被保険者_要介護2()),
                get認定者数(data.get第1号被保険者_要介護3()),
                get認定者数(data.get第1号被保険者_要介護4()),
                get認定者数(data.get第1号被保険者_要介護5()),
                get認定者数(data.get第1号被保険者_合計())));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get歳以上75歳未満タイトル(),
                get認定者数(data.get歳以上75歳未満_非該当()),
                get認定者数(data.get歳以上75歳未満_支援1()),
                get認定者数(data.get歳以上75歳未満_支援2()),
                get認定者数(data.get歳以上75歳未満_要介護1()),
                get認定者数(data.get歳以上75歳未満_要介護2()),
                get認定者数(data.get歳以上75歳未満_要介護3()),
                get認定者数(data.get歳以上75歳未満_要介護4()),
                get認定者数(data.get歳以上75歳未満_要介護5()),
                get認定者数(data.get歳以上75歳未満_合計())));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get歳75以上タイトル(),
                get認定者数(data.get歳75以上_非該当()),
                get認定者数(data.get歳75以上_支援1()),
                get認定者数(data.get歳75以上_支援2()),
                get認定者数(data.get歳75以上_要介護1()),
                get認定者数(data.get歳75以上_要介護2()),
                get認定者数(data.get歳75以上_要介護3()),
                get認定者数(data.get歳75以上_要介護4()),
                get認定者数(data.get歳75以上_要介護5()),
                get認定者数(data.get歳75以上_合計())));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get第2号被保険者タイトル(),
                get認定者数(data.get第2号被保険者_非該当()),
                get認定者数(data.get第2号被保険者_支援1()),
                get認定者数(data.get第2号被保険者_支援2()),
                get認定者数(data.get第2号被保険者_要介護1()),
                get認定者数(data.get第2号被保険者_要介護2()),
                get認定者数(data.get第2号被保険者_要介護3()),
                get認定者数(data.get第2号被保険者_要介護4()),
                get認定者数(data.get第2号被保険者_要介護5()),
                get認定者数(data.get第2号被保険者_合計())));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get総数タイトル(),
                get認定者数(data.get総数_非該当()),
                get認定者数(data.get総数_支援1()),
                get認定者数(data.get総数_支援2()),
                get認定者数(data.get総数_要介護1()),
                get認定者数(data.get総数_要介護2()),
                get認定者数(data.get総数_要介護3()),
                get認定者数(data.get総数_要介護4()),
                get認定者数(data.get総数_要介護5()),
                get認定者数(data.get総数_合計())));
        return dataBodyList;
    }

    private RString get認定者数(RString 認定者数) {
        if (RString.isNullOrEmpty(認定者数)) {
            return new RString("0");
        }
        return 認定者数;
    }
}
