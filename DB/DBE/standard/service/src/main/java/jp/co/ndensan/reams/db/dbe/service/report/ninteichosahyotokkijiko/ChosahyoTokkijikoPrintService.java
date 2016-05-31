/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyotokkijiko.ChosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票（特記事項）Printerです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoPrintService {

    /**
     * 要介護認定調査票（特記事項）を印刷します。
     *
     * @param entity 要介護認定調査票（特記事項）作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosahyoTokkijikoEntity entity) {
        ChosahyoTokkijikoProperty property = new ChosahyoTokkijikoProperty();
        return new Printer<ChosahyoTokkijikoReportSource>().spool(property, toReports(entity));
    }

    private static ChosahyoTokkijikoReport toReports(ChosahyoTokkijikoEntity entity) {
        return new ChosahyoTokkijikoReport(entity);
    }
}
