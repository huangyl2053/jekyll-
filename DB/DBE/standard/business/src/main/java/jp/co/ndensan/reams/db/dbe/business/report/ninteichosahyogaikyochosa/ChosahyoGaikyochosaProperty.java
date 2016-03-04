/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（概況調査）のプロパティです。
 */
public class ChosahyoGaikyochosaProperty extends ReportPropertyBase<ChosahyoGaikyochosaReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoGaikyochosaProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE221011.getReportId());
    }
}
