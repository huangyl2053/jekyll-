/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票差異チェック票のプロパティです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenProperty extends ReportPropertyBase<SaiChekkuhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public SaiChekkuhyoRyoumenProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE292001_Ryoumen.getReportId());
    }
}
