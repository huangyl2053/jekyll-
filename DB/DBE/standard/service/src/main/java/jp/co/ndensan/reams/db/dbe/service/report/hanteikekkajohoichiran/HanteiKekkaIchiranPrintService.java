/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.hanteikekkajohoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran.HanteiKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran.HanteiKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran.HanteiKekkaIchiranA4ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定判定結果一覧表用出力クラスです。
 *
 * @reamsid_L DBE-0170-020 wangkun
 */
public class HanteiKekkaIchiranPrintService {

    /**
     * 要介護認定結果通知書対象者一覧表を印刷します。
     *
     * @param itemList HanteiKekkaIchiranEntity
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<HanteiKekkaIchiranEntity> itemList) {
        HanteiKekkaIchiranProperty property = new HanteiKekkaIchiranProperty();
        return new Printer<HanteiKekkaIchiranA4ReportSource>().spool(property, toReports(itemList));
    }

    private static List<HanteiKekkaIchiranReport> toReports(List<HanteiKekkaIchiranEntity> itemList) {
        List<HanteiKekkaIchiranReport> list = new ArrayList<>();
        list.add(HanteiKekkaIchiranReport.createFrom(itemList));
        return list;
    }
}
