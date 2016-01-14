/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 要介護認定業務進捗状況一覧表のReportです。
 */
public final class NiteiGyomuShinchokuJokyoIchiranhyoReport extends Report<NiteiGyomuShinchokuJokyoIchiranhyoReportSource> {
    
    private final List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItemList;
    
    /**
     * インスタンスを生成します。
     * @param bodyItemList 要介護認定業務進捗状況一覧表リスト一覧表情報
     * @return 要介護認定業務進捗状況一覧表
     */
    public static NiteiGyomuShinchokuJokyoIchiranhyoReport createReport(@NonNull List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItemList) {
        return new NiteiGyomuShinchokuJokyoIchiranhyoReport(bodyItemList);
    }
    
    private NiteiGyomuShinchokuJokyoIchiranhyoReport(List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItemList) {
        this.bodyItemList = bodyItemList;
    }

    @Override
    protected void writeBy(ReportSourceWriter<NiteiGyomuShinchokuJokyoIchiranhyoReportSource> writer) {
        for (int i = 0; i < bodyItemList.size(); i++) {
            INiteiGyomuShinchokuJokyoIchiranhyoEditor headEditor = new NiteiGyomuShinchokuJokyoIchiranhyoHeadEditor();
            INiteiGyomuShinchokuJokyoIchiranhyoEditor bodyEditor = new NiteiGyomuShinchokuJokyoIchiranhyoBodyEditor(bodyItemList.get(i), i);
            INiteiGyomuShinchokuJokyoIchiranhyoBuilder builder = new NiteiGyomuShinchokuJokyoIchiranhyoBuilderItem(headEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }
}
