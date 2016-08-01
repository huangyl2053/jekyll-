/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link ShoriKekkaKakuninListProperty}のプロパティです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListProperty extends ReportPropertyBase<ShoriKekkaKakuninListReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShoriKekkaKakuninListProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU200002.getReportId());
    }

}
