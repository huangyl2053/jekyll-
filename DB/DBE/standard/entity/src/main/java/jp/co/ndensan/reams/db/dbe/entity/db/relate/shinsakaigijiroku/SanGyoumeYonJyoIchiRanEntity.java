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
 * @reamsid_L DBE-0170-040 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SanGyoumeYonJyoIchiRanEntity {

    private RString 一行目;
    private RString 二行目;
    private RString 三行目;
    private RString 四行目;

    /**
     * 新規、更新、区変の件数を設定します。
     *
     * @param 一行目 一行目
     * @param 二行目 二行目
     * @param 三行目 三行目
     * @param 四行目 四行目
     */
    public SanGyoumeYonJyoIchiRanEntity(RString 一行目, RString 二行目,
            RString 三行目, RString 四行目) {
        this.一行目 = 一行目;
        this.二行目 = 二行目;
        this.三行目 = 三行目;
        this.四行目 = 四行目;
    }
}
