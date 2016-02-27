/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.johoteikyoshiryo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoItem;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.johoteikyoshiryo.JohoTeikyoShiryoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.johoteikyoshiryo.JohoTeikyoShiryoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 要介護認定結果情報提供票（主治医）Printerです。
 */
public class JohoTeikyoShiryoService {

    /**
     * 医療機関・主治医一覧表を印刷します。
     *
     * @param item 医療機関・主治医一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(JohoTeikyoShiryoItem item) {
        JohoTeikyoShiryoProperty property = new JohoTeikyoShiryoProperty();
        return new Printer<JohoTeikyoShiryoReportSource>().spool(property, toReports(item));
    }

    private static List<JohoTeikyoShiryoReport> toReports(JohoTeikyoShiryoItem item) {
        List<JohoTeikyoShiryoReport> list = new ArrayList<>();
        list.add(JohoTeikyoShiryoReport.createFrom(item));
        return list;
    }
}
