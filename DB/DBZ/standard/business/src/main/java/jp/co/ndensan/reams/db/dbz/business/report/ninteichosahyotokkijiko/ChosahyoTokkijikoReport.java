/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）のReportです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoReport extends Report<ChosahyoTokkijikoReportSource> {

    private List<ChosahyoTokkijikoBusiness> businessList;
    private ChosahyoTokkijikoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定調査票（特記事項）のbusiness
     */
    public ChosahyoTokkijikoReport(ChosahyoTokkijikoBusiness business) {
        this.business = business;
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定調査票（特記事項）のbusinessList
     */
    public ChosahyoTokkijikoReport(List<ChosahyoTokkijikoBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        if (business == null) {
            for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(chosahyoTokkijikoBusiness);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else {
            IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(business);
            IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
