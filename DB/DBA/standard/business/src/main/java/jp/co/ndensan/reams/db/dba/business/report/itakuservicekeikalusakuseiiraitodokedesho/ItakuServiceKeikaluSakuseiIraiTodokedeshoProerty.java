/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.itakuservicekeikalusakuseiiraitodokedesho.ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書のプロパティです。
 */
public class ItakuServiceKeikaluSakuseiIraiTodokedeshoProerty extends ReportPropertyBase<ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource> {

    /**
     * コンストラクタです。
     */
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800004.getReportId());
    }
}
