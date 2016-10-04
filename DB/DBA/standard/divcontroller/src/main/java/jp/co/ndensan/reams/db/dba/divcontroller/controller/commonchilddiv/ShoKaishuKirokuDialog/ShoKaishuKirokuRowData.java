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

    /**
     * {@link dgKoufuKaishu_Row}の情報を保持したインスタンスを生成します。
     *
     * @param row {@link dgKoufuKaishu_Row}
     */
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

    /**
     * {@link dgKoufuKaishu_Row}へ変換します。
     *
     * @return {@link dgKoufuKaishu_Row}
     */
    public dgKoufuKaishu_Row toRow() {
        dgKoufuKaishu_Row row = new dgKoufuKaishu_Row();
        row.setStatus(this.status);
        row.setKoufuType(this.koufuType);
        row.getKoufuDate().setValue(this.koufuDate);
        row.setKoufuJiyu(this.koufuJiyu);
        row.getKaishuDate().setValue(this.kaishuDate);
        row.setKaishuJiyu(this.kaishuJiyu);
        row.getYukoKigen().setValue(this.yukoKigen);
        row.setKofuRiyu(this.kofuRiyu);
        row.setKaishuRiyu(this.kaishuRiyu);
        row.setRirekiNo(this.rirekiNo);
        row.setKoufuTypeNo(this.koufuTypeNo);
        row.setKoufuJiyuNo(this.koufuJiyuNo);
        row.setKaishuJiyuNo(this.kaishuJiyuNo);
        return row;
    }
}
