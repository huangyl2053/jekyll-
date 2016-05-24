/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果情報Entityクラスです。
 *
 * @reamsid_L DBE-0180-030 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SanGyoumeYonJyoIchiRanEntity {

    private RString listShinseishubetsuCount_1;
    private RString listShinseishubetsuCount_2;
    private RString listShinseishubetsuCount_3;
    private RString listShinseishubetsuCount_4;

    /**
     * 新規、更新、区変の件数を設定します。
     *
     * @param listShinseishubetsuCount_1 listShinseishubetsuCount_1
     * @param listShinseishubetsuCount_2 listShinseishubetsuCount_2
     * @param listShinseishubetsuCount_3 listShinseishubetsuCount_3
     * @param listShinseishubetsuCount_4 listShinseishubetsuCount_4
     */
    public SanGyoumeYonJyoIchiRanEntity(RString listShinseishubetsuCount_1, RString listShinseishubetsuCount_2,
            RString listShinseishubetsuCount_3, RString listShinseishubetsuCount_4) {
        this.listShinseishubetsuCount_1 = listShinseishubetsuCount_1;
        this.listShinseishubetsuCount_2 = listShinseishubetsuCount_2;
        this.listShinseishubetsuCount_3 = listShinseishubetsuCount_3;
        this.listShinseishubetsuCount_4 = listShinseishubetsuCount_4;
    }
}
