/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaishukeihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会集計表（判定別）の一覧パラメータクラスです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaishukeihyoBody {

    private final RString listHantei1_1;
    private final RString listHantei1_2;
    private final RString listHantei1_3;
    private final RString listHantei1_4;
    private final RString listHantei1_5;
    private final RString listHantei1_6;
    private final RString listHantei1_7;
    private final RString listHantei1_8;
    private final RString listHantei1_9;
    private final RString listHantei1_10;

    /**
     * コンストラクタです。
     *
     * @param listHantei1_1 listHantei1_1
     * @param listHantei1_2 listHantei1_2
     * @param listHantei1_3 listHantei1_3
     * @param listHantei1_4 listHantei1_4
     * @param listHantei1_5 listHantei1_5
     * @param listHantei1_6 listHantei1_6
     * @param listHantei1_7 listHantei1_7
     * @param listHantei1_8 listHantei1_8
     * @param listHantei1_9 listHantei1_9
     * @param listHantei1_10 listHantei1_10
     */
    public ShinsakaishukeihyoBody(RString listHantei1_1,
            RString listHantei1_2,
            RString listHantei1_3,
            RString listHantei1_4,
            RString listHantei1_5,
            RString listHantei1_6,
            RString listHantei1_7,
            RString listHantei1_8,
            RString listHantei1_9,
            RString listHantei1_10) {
        this.listHantei1_1 = listHantei1_1;
        this.listHantei1_2 = listHantei1_2;
        this.listHantei1_3 = listHantei1_3;
        this.listHantei1_4 = listHantei1_4;
        this.listHantei1_5 = listHantei1_5;
        this.listHantei1_6 = listHantei1_6;
        this.listHantei1_7 = listHantei1_7;
        this.listHantei1_8 = listHantei1_8;
        this.listHantei1_9 = listHantei1_9;
        this.listHantei1_10 = listHantei1_10;

    }
}
