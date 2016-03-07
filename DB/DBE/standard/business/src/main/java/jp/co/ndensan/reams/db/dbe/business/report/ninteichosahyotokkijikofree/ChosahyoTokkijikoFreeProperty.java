/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijikofree;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（特記事項）フリー様式のプロパティです。
 */
public class ChosahyoTokkijikoFreeProperty extends ReportPropertyBase<ChosahyoTokkijikoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoTokkijikoFreeProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE221022_2.getReportId());
    }
}
