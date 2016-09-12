/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.itakuservicekeikalusakuseiiraitodokedesho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.itakuservicekeikalusakuseiiraitodokedesho.ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 居宅（介護予防）サービス計画作成依頼（変更）届出書のプロパティです。
 *
 * @reamsid_L DBA-0540-696 yaodongsheng
 */
public class ItakuServiceKeikaluSakuseiIraiTodokedeshoProerty extends ReportPropertyBase<ItakuServiceKeikaluSakuseiIraiTodokedeshoReportSource> {

    /**
     * コンストラクタです。
     */
    public ItakuServiceKeikaluSakuseiIraiTodokedeshoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800004.getReportId());
    }
}
