/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.saichekkuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoRyoumenProperty;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoRyoumenReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定調査票差異チェック票Printerです。
 *
 * @reamsid_L DBE-0080-060 xuyannan
 */
public class SaiChekkuhyoRyoumenPrintService {

    private static final RString CONFIGVALUE2 = new RString("2");
    private static final RString CONFIGVALUE3 = new RString("3");

    /**
     * 要介護認定調査票差異チェック票を印刷します。
     *
     * @param itemList 要介護認定調査票差異チェック票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<SaiChekkuhyoItem> itemList) {
        SaiChekkuhyoRyoumenProperty property = null;
        if (CONFIGVALUE2.equals(
                DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            property = new SaiChekkuhyoRyoumenProperty(ReportIdDBE.DBE292003.getReportId());
        } else if (CONFIGVALUE3.equals(
                DbBusinessConfig.get(ConfigNameDBE.認定調査票差異チェック票_印刷タイプ, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            property = new SaiChekkuhyoRyoumenProperty(ReportIdDBE.DBE292002.getReportId());
        }
        return new Printer<SaiChekkuhyoReportSource>().spool(property, toReports(itemList));
    }

    private static List<SaiChekkuhyoRyoumenReport> toReports(List<SaiChekkuhyoItem> itemList) {
        List<SaiChekkuhyoRyoumenReport> list = new ArrayList<>();
        list.add(SaiChekkuhyoRyoumenReport.createFrom(itemList));
        return list;
    }
}
