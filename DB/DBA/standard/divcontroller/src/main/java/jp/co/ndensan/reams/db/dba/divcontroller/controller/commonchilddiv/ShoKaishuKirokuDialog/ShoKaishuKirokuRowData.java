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
     * コンストラクタです。
     *
     * @param row 証回収グリッドRow
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
     * 状態を取得します。
     *
     * @return
     */
    public RString getStatus() {
        return status;
    }

    /**
     * 交付種類を取得します。
     *
     * @return
     */
    public RString getKoufuType() {
        return koufuType;
    }

    /**
     * 交付日を取得します。
     *
     * @return
     */
    public RDate getKoufuDate() {
        return koufuDate;
    }

    /**
     * 交付事由を取得します。
     *
     * @return
     */
    public RString getKoufuJiyu() {
        return koufuJiyu;
    }

    /**
     * 回収日を取得します。
     *
     * @return
     */
    public RDate getKaishuDate() {
        return kaishuDate;
    }

    /**
     * 回収事由を取得します。
     *
     * @return
     */
    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    /**
     * 有効期限を取得します。
     *
     * @return
     */
    public RDate getYukoKigen() {
        return yukoKigen;
    }

    /**
     * 交付理由を取得します。
     *
     * @return
     */
    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    /**
     * 回収理由を取得します。
     *
     * @return
     */
    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    /**
     * 履歴番号を取得します。
     *
     * @return
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 交付種類コードを取得します。
     *
     * @return
     */
    public RString getKoufuTypeNo() {
        return koufuTypeNo;
    }

    /**
     * 交付事由コードを取得します。
     *
     * @return
     */
    public RString getKoufuJiyuNo() {
        return koufuJiyuNo;
    }

    /**
     * 回収事由コードを取得します。
     *
     * @return
     */
    public RString getKaishuJiyuNo() {
        return kaishuJiyuNo;
    }

    /**
     * 引数から受け取ったデータを元にグリッドに設定するデータを用意します。
     *
     * @param rowData 証回収記録データ
     * @return 証回収グリッドRow
     */
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
