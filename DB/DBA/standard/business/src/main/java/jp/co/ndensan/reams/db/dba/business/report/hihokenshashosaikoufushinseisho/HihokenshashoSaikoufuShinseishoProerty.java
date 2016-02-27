/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashosaikoufushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashosaikoufushinseisho.HihokenshashoSaikoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link HihokenshashoSaikoufuShinseishoReportSource}のプロパティです。
 */
public class HihokenshashoSaikoufuShinseishoProerty extends ReportPropertyBase<HihokenshashoSaikoufuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HihokenshashoSaikoufuShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA800003.getReportId());
    }
}
