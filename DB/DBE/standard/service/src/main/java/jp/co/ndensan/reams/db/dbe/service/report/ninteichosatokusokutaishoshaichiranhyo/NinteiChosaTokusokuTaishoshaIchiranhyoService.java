/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ninteichosatokusokutaishoshaichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokusokutaishoshaichiranhyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書督促対象者一覧表Printerです。
 *
 */
public class NinteiChosaTokusokuTaishoshaIchiranhyoService {

    /**
     * 主治医意見書督促対象者一覧表を印刷します。
     *
     * @param item 主治医意見書督促対象者一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> item) {
        NinteiChosaTokusokuTaishoshaIchiranhyoProperty property = new NinteiChosaTokusokuTaishoshaIchiranhyoProperty();
        return new Printer<NinteiChosaTokusokuTaishoshaIchiranhyoReportSource>().spool(property, toReports(item));
    }

    private static List<NinteiChosaTokusokuTaishoshaIchiranhyoReport> toReports(List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> item) {
        List<NinteiChosaTokusokuTaishoshaIchiranhyoReport> list = new ArrayList<>();
        list.add(NinteiChosaTokusokuTaishoshaIchiranhyoReport.createFrom(item));
        return list;
    }
}
