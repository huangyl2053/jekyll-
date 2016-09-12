/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiirai;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiirai.ShujiiIkenshoMiIraiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書依頼未処理者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-130 suguangjun
 */
public class ShujiiIkenshoMiIraiProperty extends ReportPropertyBase<ShujiiIkenshoMiIraiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoMiIraiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013001.getReportId());
    }
}
