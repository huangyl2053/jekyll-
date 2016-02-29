/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link HihokenshashoHakkoKanriIchiranhyoReportSource}のプロパティです。
 */
public class HihokenshashoHakkoKanriIchiranhyoProperty extends ReportPropertyBase<HihokenshashoHakkoKanriIchiranhyoReportSource> {

    /**
     * コンストラクタです。
     */
    public HihokenshashoHakkoKanriIchiranhyoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200004.getReportId());
    }
}
