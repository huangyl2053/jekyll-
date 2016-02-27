/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.joseikinKyufuShinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.source.joseikinKyufuShinseisho.JoseikinKyufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険助成金給付申請書のプロパティです。
 */
public class JoseikinKyufuShinseishoProperty
        extends ReportPropertyBase<JoseikinKyufuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public JoseikinKyufuShinseishoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBC800017.getReportId());
    }
}
