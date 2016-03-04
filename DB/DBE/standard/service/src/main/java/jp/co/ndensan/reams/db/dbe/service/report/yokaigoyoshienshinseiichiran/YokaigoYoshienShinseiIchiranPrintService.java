/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.yokaigoyoshienshinseiichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranItem;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定・要支援認定等申請者一覧表Printerです。
 */
public class YokaigoYoshienShinseiIchiranPrintService {

    /**
     * 要介護認定・要支援認定等申請者一覧表を印刷します。
     *
     * @param items 要介護認定・要支援認定等申請者一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<YokaigoYoshienShinseiIchiranItem> items) {
        YokaigoYoshienShinseiIchiranProperty property = new YokaigoYoshienShinseiIchiranProperty();
        return new Printer<YokaigoYoshienShinseiIchiranReportSource>().spool(property, toReports(items));
    }

    private static List<YokaigoYoshienShinseiIchiranReport> toReports(List<YokaigoYoshienShinseiIchiranItem> items) {
        List<YokaigoYoshienShinseiIchiranReport> list = new ArrayList<>();
        list.add(YokaigoYoshienShinseiIchiranReport.createFrom(items));
        return list;
    }
}
