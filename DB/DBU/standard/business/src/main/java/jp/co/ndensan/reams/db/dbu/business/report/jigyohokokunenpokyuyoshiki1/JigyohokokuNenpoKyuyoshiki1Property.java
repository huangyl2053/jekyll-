/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpokyuyoshiki1;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事業状況報告年報（様式１・２　所得段階）のプロパティです。
 *
 * @reamsid_L DBU-5610-060 kanghongsong
 */
public class JigyohokokuNenpoKyuyoshiki1Property extends ReportPropertyBase<JigyohokokuNenpoKyuyoshiki1ReportSource> {

    private static final ReportId ID = ReportIdDBU.DBU301125.getReportId();

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuNenpoKyuyoshiki1Property() {
        super(SubGyomuCode.DBU介護統計報告, ID);
    }
}
