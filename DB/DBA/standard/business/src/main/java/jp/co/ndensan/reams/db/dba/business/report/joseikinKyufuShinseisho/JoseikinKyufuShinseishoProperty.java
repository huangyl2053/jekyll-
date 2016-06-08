/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.joseikinKyufuShinseisho.JoseikinKyufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険助成金給付申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-686 houtianpeng
 */
public class JoseikinKyufuShinseishoProperty
        extends ReportPropertyBase<JoseikinKyufuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JoseikinKyufuShinseishoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800017.getReportId());
    }
}
