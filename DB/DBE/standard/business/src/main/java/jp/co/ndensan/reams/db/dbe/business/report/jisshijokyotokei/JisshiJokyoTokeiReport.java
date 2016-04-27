/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jisshijokyotokei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokei;
import jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei.JisshiJokyoTokeiDataChange;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jisshijokyotokei.JisshiJokyoTokeiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定実施状況統計のReportです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JisshiJokyoTokeiReport extends Report<JisshiJokyoTokeiReportSource> {

    private final JisshiJokyoTokei data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護認定実施状況統計のdataList
     */
    public JisshiJokyoTokeiReport(JisshiJokyoTokei data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JisshiJokyoTokeiReportSource> reportSourceWriter) {
        for (JisshiJokyoTokeiDataChange dataBody : getBodyData(data)) {
            IJisshiJokyoTokeiEditor editor = new JisshiJokyoTokeiEditor(data);
            IJisshiJokyoTokeiBodyEditor bodyEditor = new JisshiJokyoTokeiBodyEditor(dataBody);
            IJisshiJokyoTokeiBuilder builder = new JisshiJokyoTokeiBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<JisshiJokyoTokeiDataChange> getBodyData(JisshiJokyoTokei data) {
        List<JisshiJokyoTokeiDataChange> dataBodyList = new ArrayList<>();
        dataBodyList.add(new JisshiJokyoTokeiDataChange(RString.EMPTY,
                data.get申請受付数タイトル(),
                data.get調査実施数タイトル(),
                data.get審査会実施数タイトル(),
                data.get認定結果数タイトル()));
        dataBodyList.add(new JisshiJokyoTokeiDataChange(data.get新規申請タイトル(),
                data.get新規申請_申請受付数(),
                data.get新規申請_調査実施数(),
                data.get新規申請_審査会実施数(),
                data.get新規申請_認定結果数()));
        dataBodyList.add(new JisshiJokyoTokeiDataChange(data.get更新申請タイトル(),
                data.get更新申請_申請受付数(),
                data.get更新申請_調査実施数(),
                data.get更新申請_審査会実施数(),
                data.get更新申請_認定結果数()));
        dataBodyList.add(new JisshiJokyoTokeiDataChange(data.get区分変更申請タイトル(),
                data.get区分変更申請_申請受付数(),
                data.get区分変更申請_調査実施数(),
                data.get区分変更申請_審査会実施数(),
                data.get区分変更申請_認定結果数()));
        dataBodyList.add(new JisshiJokyoTokeiDataChange(data.get合計タイトル(),
                data.get合計_申請受付数(),
                data.get合計_調査実施数(),
                data.get合計_審査会実施数(),
                data.get合計_認定結果数()));
        return dataBodyList;
    }
}
