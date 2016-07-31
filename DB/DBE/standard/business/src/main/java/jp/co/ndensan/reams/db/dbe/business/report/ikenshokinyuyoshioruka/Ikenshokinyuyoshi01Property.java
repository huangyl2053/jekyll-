/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書（オルカ）のプロパティです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01Property extends ReportPropertyBase<Ikenshokinyuyoshi01ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public Ikenshokinyuyoshi01Property() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE231101.getReportId());
    }

}
