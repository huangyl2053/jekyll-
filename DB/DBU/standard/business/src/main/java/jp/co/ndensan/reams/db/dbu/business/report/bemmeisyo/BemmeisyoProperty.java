/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link BemmeisyoReport}のプロパティです。
 *
 * @reamsid_L DBU-1080-150 linghuhang
 */
public class BemmeisyoProperty extends ReportPropertyBase<BemmeisyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public BemmeisyoProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU100001.getReportId());
    }
}
