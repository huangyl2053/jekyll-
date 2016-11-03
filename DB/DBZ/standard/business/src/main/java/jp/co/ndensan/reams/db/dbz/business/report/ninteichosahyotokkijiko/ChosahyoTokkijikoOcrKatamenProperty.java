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
 *
 * @author n3331
 */
public class ChosahyoTokkijikoOcrKatamenProperty extends ReportPropertyBase<ChosahyoTokkijikoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoTokkijikoOcrKatamenProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221032.getReportId());
    }
}
