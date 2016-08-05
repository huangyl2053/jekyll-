/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100025;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link NinteishoJohoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3870-030 donghj
 */
public class ShogaishaKojoNinteishoProperty extends ReportPropertyBase<NinteishoJohoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShogaishaKojoNinteishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId());
    }
}
