/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 要介護認定区分変更申請書のプロパティです。
 */
public class YokaigoNinteikbnHenkoShinseishoProperty
        extends ReportPropertyBase<YokaigoNinteikbnHenkoShinseishoReportSource> {

    private static final ReportId ID = ReportIdDBA.DBD501002.getReportId();

    /**
     * インスタンスを生成します。
     */
    public YokaigoNinteikbnHenkoShinseishoProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}
