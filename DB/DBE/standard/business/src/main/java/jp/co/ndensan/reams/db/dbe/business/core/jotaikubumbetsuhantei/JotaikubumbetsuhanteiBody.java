/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jotaikubumbetsuhantei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護状態区分別判定件数のBodyクラスです。
 *
 * @reamsid_L DBE-1450-050 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JotaikubumbetsuhanteiBody {

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
    private final RString listHantei_1;
    private final RString listHantei_2;
    private final RString listHantei_3;
    private final RString listHantei_4;
    private final RString listHantei_5;

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
     * @param listHantei_1 listHantei_1
     * @param listHantei_2 listHantei_2
     * @param listHantei_3 listHantei_3
     * @param listHantei_4 listHantei_4
     * @param listHantei_5 listHantei_5
     */
    public JotaikubumbetsuhanteiBody(RString listHantei1_1,
            RString listHantei1_2,
            RString listHantei1_3,
            RString listHantei1_4,
            RString listHantei1_5,
            RString listHantei1_6,
            RString listHantei1_7,
            RString listHantei1_8,
            RString listHantei1_9,
            RString listHantei1_10,
            RString listHantei_1,
            RString listHantei_2,
            RString listHantei_3,
            RString listHantei_4,
            RString listHantei_5) {
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
        this.listHantei_1 = listHantei_1;
        this.listHantei_2 = listHantei_2;
        this.listHantei_3 = listHantei_3;
        this.listHantei_4 = listHantei_4;
        this.listHantei_5 = listHantei_5;

    }

}
