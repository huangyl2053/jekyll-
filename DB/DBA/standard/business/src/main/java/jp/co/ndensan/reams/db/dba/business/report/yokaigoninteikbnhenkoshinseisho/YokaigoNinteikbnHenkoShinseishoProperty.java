/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定区分変更申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-713 lishengli
 */
public class YokaigoNinteikbnHenkoShinseishoProperty
        extends ReportPropertyBase<YokaigoNinteikbnHenkoShinseishoReportSource> {

    private static final ReportId ID = ReportIdDBA.DBD501002.getReportId();

    /**
     * インスタンスを生成します。
     */
    public YokaigoNinteikbnHenkoShinseishoProperty() {
        super(SubGyomuCode.DBD介護受給, ID);
    }
}
