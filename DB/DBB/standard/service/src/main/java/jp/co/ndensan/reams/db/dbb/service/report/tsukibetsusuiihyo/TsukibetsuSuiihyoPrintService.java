/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoHeaderItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoProerty;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReportJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 月別推移表（帳票）Printerです。
 */
public class TsukibetsuSuiihyoPrintService {

    /**
     * 月別推移表（帳票）を印刷します。
     *
     * @param reportJoho 月別推移表パラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(TsukibetsuSuiihyoReportJoho reportJoho) {
        TsukibetsuSuiihyoProerty property = new TsukibetsuSuiihyoProerty();
        return new Printer<TsukibetsuSuiihyoReportSource>().spool(property, toReports(reportJoho));
    }

    private static List<TsukibetsuSuiihyoReport> toReports(TsukibetsuSuiihyoReportJoho reportJoho) {
        List<TsukibetsuSuiihyoReport> list = new ArrayList<>();
        TsukibetsuSuiihyoHeaderItem headItem = reportJoho.getHeadItem();
        list.add(TsukibetsuSuiihyoReport.createFrom(
                new TsukibetsuSuiihyoHeaderItem(headItem.getGengo(),
                        headItem.getNendo(),
                        AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().value(),
                        AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                        headItem.getChoshuHouhouTitle()),
                reportJoho.getBodyTitleItem(),
                reportJoho.getBodyItemList()));
        return list;
    }
}
