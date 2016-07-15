/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshuseikyu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuBodyEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshohoshuseikyu.IkenshoHoshuSeikyuReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBE621004_主治医意見書作成報酬請求書のIkenshoHoshuSeikyuReportです。
 *
 * @reamsid_L DBE-1980-042 xuyongchao
 */
public class IkenshoHoshuSeikyuReport extends Report<IkenshoHoshuSeikyuReportSource> {

    private final IkenshoHoshuSeikyuEntity data;

    /**
     * インスタンスを生成します。
     *
     * @param data IkenshoHoshuSeikyuEntity
     */
    public IkenshoHoshuSeikyuReport(IkenshoHoshuSeikyuEntity data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoHoshuSeikyuReportSource> reportSourceWriter) {
        for (IkenshoHoshuSeikyuBodyEntity bodyData : getBodyData(data)) {
            IIkenshoHoshuSeikyuEditor editor = new IkenshoHoshuSeikyuEditor(data);
            IIkenshoHoshuSeikyuBodyEditor bodyEditor = new IkenshoHoshuSeikyuBodyEditor(bodyData);
            IIkenshoHoshuSeikyuBuilder builder = new IkenshoHoshuSeikyuBuilder(editor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private List<IkenshoHoshuSeikyuBodyEntity> getBodyData(IkenshoHoshuSeikyuEntity data) {
        List<IkenshoHoshuSeikyuBodyEntity> dataList = new ArrayList<>();
        dataList.add(new IkenshoHoshuSeikyuBodyEntity(data.get新規在宅件数(), data.get新規在宅単価(), data.get新規在宅計()));
        dataList.add(new IkenshoHoshuSeikyuBodyEntity(data.get新規施設件数(), data.get新規施設単価(), data.get新規施設計()));
        dataList.add(new IkenshoHoshuSeikyuBodyEntity(data.get更新在宅件数(), data.get更新在宅単価(), data.get更新在宅計()));
        dataList.add(new IkenshoHoshuSeikyuBodyEntity(data.get更新施設件数(), data.get更新施設単価(), data.get更新施設計()));
        return dataList;
    }
}
