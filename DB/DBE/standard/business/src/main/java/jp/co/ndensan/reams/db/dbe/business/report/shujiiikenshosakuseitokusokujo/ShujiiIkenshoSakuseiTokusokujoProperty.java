/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakuseitokusokujo.ShujiiIkenshoSakuseiTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書提出督促状のプロパティです。
 *
 * @reamsid_L DBE-0060-020 hezhenzhen
 *
 */
public class ShujiiIkenshoSakuseiTokusokujoProperty extends ReportPropertyBase<ShujiiIkenshoSakuseiTokusokujoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoSakuseiTokusokujoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE233001.getReportId());
    }

}
