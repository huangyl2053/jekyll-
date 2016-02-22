/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link KyokaisoKanriMasterListReport}のプロパティです。
 */
public class KyokaisoKanriMasterListProperty extends ReportPropertyBase<KyokaisoKanriMasterListReportSource> {

    private static final ReportId ID = ReportIdDBA.DBA200005.getReportId();

    /**
     * インスタンスを生成します。
     */
    public KyokaisoKanriMasterListProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}
