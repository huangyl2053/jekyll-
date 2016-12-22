/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijikofree;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）フリー様式のReportです。
 *
 * @reamsid_L DBE-0080-050 xuyannan
 */
public class ChosahyoTokkijikoFreeReport extends Report<ChosahyoTokkijikoReportSource> {

    private final List<ChosahyoTokkijikoBusiness> businessList;

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定調査票（特記事項）フリー様式のbusiness
     * @return 要介護認定調査票（特記事項）フリー様式のReport
     */
    public static ChosahyoTokkijikoFreeReport createFrom(List<ChosahyoTokkijikoBusiness> businessList) {
        return new ChosahyoTokkijikoFreeReport(businessList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定調査票（特記事項）フリー様式のbusiness
     * @return 要介護認定調査票（特記事項）フリー様式のReport
     */
    public static ChosahyoTokkijikoFreeReport createFrom(ChosahyoTokkijikoBusiness business) {
        List<ChosahyoTokkijikoBusiness> bussinessList = new ArrayList();
        bussinessList.add(business);
        return new ChosahyoTokkijikoFreeReport(bussinessList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定調査票（特記事項）フリー様式のItem
     */
    protected ChosahyoTokkijikoFreeReport(List<ChosahyoTokkijikoBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * 要介護認定調査票（特記事項）フリー様式を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        for (ChosahyoTokkijikoBusiness item : businessList) {
            IChosahyoTokkijikoFreeEditor editor = new ChosahyoTokkijikoFreeEditorImpl(item);
            IChosahyoTokkijikoFreeBuilder builder = new ChosahyoTokkijikoFreeBuilderImpl(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
