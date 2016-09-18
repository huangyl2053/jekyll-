/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShoKaishuKirokuDialog;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178
 */
public class ShoKaishuKirokuRowData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final RString status;
    private final RString koufuType;
    private final RDate koufuDate;
    private final RString koufuJiyu;
    private final RDate kaishuDate;
    private final RString kaishuJiyu;
    private final RDate yukoKigen;
    private final RString kofuRiyu;
    private final RString kaishuRiyu;
    private final RString rirekiNo;
    private final RString koufuTypeNo;
    private final RString koufuJiyuNo;
    private final RString kaishuJiyuNo;

    public ShoKaishuKirokuRowData(dgKoufuKaishu_Row row) {
        status = row.getStatus();
        koufuType = row.getKoufuType();
        koufuDate = row.getKoufuDate().getValue();
        koufuJiyu = row.getKoufuJiyu();
        kaishuDate = row.getKaishuDate().getValue();
        kaishuJiyu = row.getKaishuJiyu();
        yukoKigen = row.getYukoKigen().getValue();
        kofuRiyu = row.getKofuRiyu();
        kaishuRiyu = row.getKaishuRiyu();
        rirekiNo = row.getRirekiNo();
        koufuTypeNo = row.getKoufuTypeNo();
        koufuJiyuNo = row.getKoufuJiyuNo();
        kaishuJiyuNo = row.getKaishuJiyuNo();
    }

    public static dgKoufuKaishu_Row toRow(ShoKaishuKirokuRowData rowData) {
        dgKoufuKaishu_Row row = new dgKoufuKaishu_Row();
        row.setStatus(rowData.status);
        row.setKoufuType(rowData.koufuType);
        row.getKoufuDate().setValue(rowData.koufuDate);
        row.setKoufuJiyu(rowData.koufuJiyu);
        row.getKaishuDate().setValue(rowData.kaishuDate);
        row.setKaishuJiyu(rowData.kaishuJiyu);
        row.getYukoKigen().setValue(rowData.yukoKigen);
        row.setKofuRiyu(rowData.kofuRiyu);
        row.setKaishuRiyu(rowData.kaishuRiyu);
        row.setRirekiNo(rowData.rirekiNo);
        row.setKoufuTypeNo(rowData.koufuTypeNo);
        row.setKoufuJiyuNo(rowData.koufuJiyuNo);
        row.setKaishuJiyuNo(rowData.kaishuJiyuNo);
        return row;
    }
}
