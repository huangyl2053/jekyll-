/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosairaihenko;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosairaihenko.NinteichosaIraiHenkoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査依頼先変更者一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-120 dongyabin
 */
public class NinteichosaIraiHenkoProperty extends ReportPropertyBase<NinteichosaIraiHenkoReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE012002.getReportId();

    /**
     * インスタンスを生成します。
     */
    public NinteichosaIraiHenkoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}
