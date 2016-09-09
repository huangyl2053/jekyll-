/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100029;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100029.OmutsuShoumeishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link OmutsuShoumeishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoProperty extends ReportPropertyBase<OmutsuShoumeishoReportSource> {

    /**
     * コンストラクタです。
     */
    public OmutsuShoumeishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100029.getReportId());
    }

}
