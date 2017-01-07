/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（基本調査）のプロパティです。
 */
public class ChosahyoKihonchosaProperty extends ReportPropertyBase<ChosahyoGaikyochosaReportSource> {

    /**
     * コンストラクタです。
     */
    public ChosahyoKihonchosaProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE221004.getReportId());
    }
}
