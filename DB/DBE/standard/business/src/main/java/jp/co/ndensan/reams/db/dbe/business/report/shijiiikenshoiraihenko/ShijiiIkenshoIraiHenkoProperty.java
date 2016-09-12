/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shijiiikenshoiraihenko;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書作成依頼変更者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-140 suguangjun
 */
public class ShijiiIkenshoIraiHenkoProperty extends ReportPropertyBase<ShujiiIkensho5komokuReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShijiiIkenshoIraiHenkoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013005.getReportId());
    }
}
