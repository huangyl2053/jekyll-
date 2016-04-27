/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsahanteijokyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo.ShinsaHanteiJokyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahanteijokyo.ShinsaHanteiJokyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
public class ShinsaHanteiJokyo {

    /**
     * 介護認定審査会判定状況表票を印刷します。
     *
     * @param itemList 介護認定審査会判定状況表票作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShinsaHanteiJokyoItem> itemList) {
        ShinsaHanteiJokyoProperty property = new ShinsaHanteiJokyoProperty();
        return new Printer<ShinsaHanteiJokyoReportSource>().spool(property, toReports(itemList));
    }

    private static List<ShinsaHanteiJokyoReport> toReports(List<ShinsaHanteiJokyoItem> itemList) {
        List<ShinsaHanteiJokyoReport> list = new ArrayList<>();
        list.add(ShinsaHanteiJokyoReport.createFrom(itemList));
        return list;
    }

}
