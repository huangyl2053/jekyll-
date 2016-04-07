/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.source.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険被保険者証交付申請書（第2号被保険者）のプロパティです。
 *
 * @reamsid_L DBA-0540-140 houtp
 */
public class HihokenshashokoufuShinseishoProperty
        extends ReportPropertyBase<HihokenshashokoufuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HihokenshashokoufuShinseishoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA800004.getReportId());
    }
}
