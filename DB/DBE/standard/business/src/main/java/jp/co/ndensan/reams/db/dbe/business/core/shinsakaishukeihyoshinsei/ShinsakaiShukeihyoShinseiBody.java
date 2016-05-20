/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyoshinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会集計表（申請区分別）の一覧パラメータクラスです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShukeihyoShinseiBody {

    private final RString listShukeihyo1_1;
    private final RString listShukeihyo1_2;
    private final RString listShukeihyo1_3;
    private final RString listShukeihyo1_4;
    private final RString listShukeihyo1_5;
    private final RString listShukeihyo2_1;
    private final RString listShukeihyo2_2;
    private final RString listShukeihyo2_3;
    private final RString listShukeihyo2_4;
    private final RString listShukeihyo2_5;
    private final RString listShukeihyo3_1;
    private final RString listShukeihyo3_2;
    private final RString listShukeihyo3_3;

    /**
     * コンストラクタです。
     *
     * @param listShukeihyo1_1 listShukeihyo1_1
     * @param listShukeihyo1_2 listShukeihyo1_2
     * @param listShukeihyo1_3 listShukeihyo1_3
     * @param listShukeihyo1_4 listShukeihyo1_4
     * @param listShukeihyo1_5 listShukeihyo1_5
     * @param listShukeihyo2_1 listShukeihyo2_1
     * @param listShukeihyo2_2 listShukeihyo2_2
     * @param listShukeihyo2_3 listShukeihyo2_3
     * @param listShukeihyo2_4 listShukeihyo2_4
     * @param listShukeihyo2_5 listShukeihyo2_5
     * @param listShukeihyo3_1 listShukeihyo3_1
     * @param listShukeihyo3_2 listShukeihyo3_2
     * @param listShukeihyo3_3 listShukeihyo3_3
     */
    public ShinsakaiShukeihyoShinseiBody(RString listShukeihyo1_1,
            RString listShukeihyo1_2,
            RString listShukeihyo1_3,
            RString listShukeihyo1_4,
            RString listShukeihyo1_5,
            RString listShukeihyo2_1,
            RString listShukeihyo2_2,
            RString listShukeihyo2_3,
            RString listShukeihyo2_4,
            RString listShukeihyo2_5,
            RString listShukeihyo3_1,
            RString listShukeihyo3_2,
            RString listShukeihyo3_3) {
        this.listShukeihyo1_1 = listShukeihyo1_1;
        this.listShukeihyo1_2 = listShukeihyo1_2;
        this.listShukeihyo1_3 = listShukeihyo1_3;
        this.listShukeihyo1_4 = listShukeihyo1_4;
        this.listShukeihyo1_5 = listShukeihyo1_5;
        this.listShukeihyo2_1 = listShukeihyo2_1;
        this.listShukeihyo2_2 = listShukeihyo2_2;
        this.listShukeihyo2_3 = listShukeihyo2_3;
        this.listShukeihyo2_4 = listShukeihyo2_4;
        this.listShukeihyo2_5 = listShukeihyo2_5;
        this.listShukeihyo3_1 = listShukeihyo3_1;
        this.listShukeihyo3_2 = listShukeihyo3_2;
        this.listShukeihyo3_3 = listShukeihyo3_3;

    }

}
