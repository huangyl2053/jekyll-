/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho1;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho1.ShujiiikenshoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class ShujiiikenshoProperty extends ReportPropertyBase<ShujiiikenshoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShujiiikenshoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517151.getReportId());
    }
}
