/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu.Chosahoshuseikyu;
import jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu.ChosahoshuseikyuBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 認定調査報酬請求書のReportです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuReport extends Report<ChosahoshuseikyuReportSource> {

    private final Chosahoshuseikyu data;

    /**
     * インスタンスを生成します。
     *
     * @param data 要介護状態区分別判定件数のdataList
     */
    public ChosahoshuseikyuReport(Chosahoshuseikyu data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<ChosahoshuseikyuReportSource> reportSourceWriter) {
        for (ChosahoshuseikyuBody dataBody : getBodyData(data)) {
            IChosahoshuseikyuEditor editor = new ChosahoshuseikyuEditor(data);
            IChosahoshuseikyuBodyEditor bodyEditor = new ChosahoshuseikyuBodyEditor(dataBody);
            IChosahoshuseikyuBuilder builder = new ChosahoshuseikyuBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<ChosahoshuseikyuBody> getBodyData(Chosahoshuseikyu data) {
        List<ChosahoshuseikyuBody> dataList = new ArrayList<>();
        dataList.add(new ChosahoshuseikyuBody(data.get新規在宅件数(),
                data.get新規在宅単価(),
                data.get新規在宅計()
        ));
        dataList.add(new ChosahoshuseikyuBody(data.get新規施設件数(),
                data.get新規施設単価(),
                data.get新規施設計()
        ));
        dataList.add(new ChosahoshuseikyuBody(data.get更新在宅件数(),
                data.get更新在宅単価(),
                data.get更新在宅計()
        ));
        dataList.add(new ChosahoshuseikyuBody(data.get更新施設件数(),
                data.get更新施設単価(),
                data.get更新施設計()
        ));
        return dataList;
    }
}
