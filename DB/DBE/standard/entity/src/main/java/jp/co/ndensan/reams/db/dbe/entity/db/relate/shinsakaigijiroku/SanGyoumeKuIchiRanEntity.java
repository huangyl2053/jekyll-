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
public class SanGyoumeKuIchiRanEntity {

    private RString listIchijihantei2betsuCount_1;
    private RString listIchijihantei2betsuCount_2;
    private RString listIchijihantei2betsuCount_3;
    private RString listIchijihantei2betsuCount_4;
    private RString listIchijihantei2betsuCount_5;
    private RString listIchijihantei2betsuCount_6;
    private RString listIchijihantei2betsuCount_7;
    private RString listIchijihantei2betsuCount_8;
    private RString listIchijihantei2betsuCount_9;

    /**
     * 新規、更新、区変毎の件数を設定します。
     *
     * @param listIchijihantei2betsuCount_1 llistIchijihantei2betsuCount_1
     * @param listIchijihantei2betsuCount_2 llistIchijihantei2betsuCount_2
     * @param listIchijihantei2betsuCount_3 llistIchijihantei2betsuCount_3
     * @param listIchijihantei2betsuCount_4 llistIchijihantei2betsuCount_4
     * @param listIchijihantei2betsuCount_5 llistIchijihantei2betsuCount_5
     * @param listIchijihantei2betsuCount_6 llistIchijihantei2betsuCount_6
     * @param listIchijihantei2betsuCount_7 llistIchijihantei2betsuCount_7
     * @param listIchijihantei2betsuCount_8 llistIchijihantei2betsuCount_8
     * @param listIchijihantei2betsuCount_9 llistIchijihantei2betsuCount_9
     */
    public SanGyoumeKuIchiRanEntity(RString listIchijihantei2betsuCount_1,
            RString listIchijihantei2betsuCount_2,
            RString listIchijihantei2betsuCount_3,
            RString listIchijihantei2betsuCount_4,
            RString listIchijihantei2betsuCount_5,
            RString listIchijihantei2betsuCount_6,
            RString listIchijihantei2betsuCount_7,
            RString listIchijihantei2betsuCount_8,
            RString listIchijihantei2betsuCount_9) {
        this.listIchijihantei2betsuCount_1 = listIchijihantei2betsuCount_1;
        this.listIchijihantei2betsuCount_2 = listIchijihantei2betsuCount_2;
        this.listIchijihantei2betsuCount_3 = listIchijihantei2betsuCount_3;
        this.listIchijihantei2betsuCount_4 = listIchijihantei2betsuCount_4;
        this.listIchijihantei2betsuCount_5 = listIchijihantei2betsuCount_5;
        this.listIchijihantei2betsuCount_6 = listIchijihantei2betsuCount_6;
        this.listIchijihantei2betsuCount_7 = listIchijihantei2betsuCount_7;
        this.listIchijihantei2betsuCount_8 = listIchijihantei2betsuCount_8;
        this.listIchijihantei2betsuCount_9 = listIchijihantei2betsuCount_9;

    }
}
