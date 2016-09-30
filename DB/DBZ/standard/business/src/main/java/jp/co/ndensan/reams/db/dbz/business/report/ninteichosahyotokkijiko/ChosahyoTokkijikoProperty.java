/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（特記事項）のプロパティです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoProperty extends ReportPropertyBase<ChosahyoTokkijikoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoTokkijikoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221022_1.getReportId());
    }
}
