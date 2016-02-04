/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.source.ReportItem;

/**
 * TODO 内部QA:667 Redmine#: (Formファイルは不正、ReportSourceは臨時ファイル。)
 */
public class ChosahyoTokkijikoReportSource implements IReportSource {

    @ReportItem(name = "hokenshaNo", length = 12, order = 1)
    public RString hokenshaNo;
    @ReportItem(name = "shinseiYY", length = 2, order = 2)
    public RString shinseiYY;
    @ReportItem(name = "shinseiMM", length = 2, order = 3)
    public RString shinseiMM;
    @ReportItem(name = "shinseiDD", length = 2, order = 4)
    public RString shinseiDD;
    @ReportItem(name = "hihokenshaName", order = 5)
    public RString hihokenshaName;
    @ReportItem(name = "hihokenshaNo", length = 20, order = 6)
    public RString hihokenshaNo;
}
