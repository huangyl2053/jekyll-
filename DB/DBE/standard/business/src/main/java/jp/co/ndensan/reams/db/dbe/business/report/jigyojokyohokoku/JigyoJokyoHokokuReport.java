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
                data.get第1号被保険者_非該当(),
                data.get第1号被保険者_支援1(),
                data.get第1号被保険者_支援2(),
                data.get第1号被保険者_要介護1(),
                data.get第1号被保険者_要介護2(),
                data.get第1号被保険者_要介護3(),
                data.get第1号被保険者_要介護4(),
                data.get第1号被保険者_要介護5()));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get歳以上75歳未満タイトル(),
                data.get歳以上75歳未満_非該当(),
                data.get歳以上75歳未満_支援1(),
                data.get歳以上75歳未満_支援2(),
                data.get歳以上75歳未満_要介護1(),
                data.get歳以上75歳未満_要介護2(),
                data.get歳以上75歳未満_要介護3(),
                data.get歳以上75歳未満_要介護4(),
                data.get歳以上75歳未満_要介護5()));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get歳75以上タイトル(),
                data.get歳75以上_非該当(),
                data.get歳75以上_支援1(),
                data.get歳75以上_支援2(),
                data.get歳75以上_要介護1(),
                data.get歳75以上_要介護2(),
                data.get歳75以上_要介護3(),
                data.get歳75以上_要介護4(),
                data.get歳75以上_要介護5()));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get第2号被保険者タイトル(),
                data.get第2号被保険者_非該当(),
                data.get第2号被保険者_支援1(),
                data.get第2号被保険者_支援2(),
                data.get第2号被保険者_要介護1(),
                data.get第2号被保険者_要介護2(),
                data.get第2号被保険者_要介護3(),
                data.get第2号被保険者_要介護4(),
                data.get第2号被保険者_要介護5()));
        dataBodyList.add(new JigyoJokyoHokokuDataChange(data.get総数タイトル(),
                data.get総数_非該当(),
                data.get総数_支援1(),
                data.get総数_支援2(),
                data.get総数_要介護1(),
                data.get総数_要介護2(),
                data.get総数_要介護3(),
                data.get総数_要介護4(),
                data.get総数_要介護5()));
        return dataBodyList;
    }
}
