/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikariireshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikariireshinseisho.KyufuhiKariireiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険給付費借入申請書のプロパティです。
 */
public class KyufuhiKariireiShinseishoProerty extends ReportPropertyBase<KyufuhiKariireiShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public KyufuhiKariireiShinseishoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800018.getReportId());
    }
}
