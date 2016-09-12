/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshomiteishutsu;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshomiteishutsu.ShujiiIkenshoMiteishutsuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書未提出者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-150 suguangjun
 */
public class ShujiiIkenshoMiteishutsuProperty extends ReportPropertyBase<ShujiiIkenshoMiteishutsuReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoMiteishutsuProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013003.getReportId());
    }
}
