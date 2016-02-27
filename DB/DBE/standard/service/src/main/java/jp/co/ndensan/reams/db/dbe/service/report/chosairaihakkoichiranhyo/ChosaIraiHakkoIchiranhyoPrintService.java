/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaihakkoichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaihakkoichiranhyo.ChosaIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 認定調査依頼発行一覧表Printerです。
 */
public class ChosaIraiHakkoIchiranhyoPrintService {

    /**
     * 認定調査依頼発行一覧表を印刷します。
     *
     * @param joho 認定調査依頼発行一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaIraiHakkoIchiranhyoReportJoho joho) {
        ChosaIraiHakkoIchiranhyoProperty property = new ChosaIraiHakkoIchiranhyoProperty();

        return new Printer<ChosaIraiHakkoIchiranhyoReportSource>().spool(property, toReports(joho));
    }

    private static List<ChosaIraiHakkoIchiranhyoReport> toReports(ChosaIraiHakkoIchiranhyoReportJoho joho) {
        List<ChosaIraiHakkoIchiranhyoReport> list = new ArrayList<>();
        list.add(ChosaIraiHakkoIchiranhyoReport.createFrom(joho.getHeadItem(), joho.getBodyItemList()));
        return list;
    }

}
