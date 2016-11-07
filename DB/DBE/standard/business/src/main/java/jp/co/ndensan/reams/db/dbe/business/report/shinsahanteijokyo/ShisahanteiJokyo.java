/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteijokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE701001_介護認定審査会判定状況表クラスです。
 *
 * @reamsid_L DBE-1450-030 wanghui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisahanteiJokyo {

    private final RString listHanteiHeader_1;
    private final RString listHanteiHeader_2;
    private final RString listHanteiHeader_3;
    private final RString listHanteiHeader_4;
    private final RString listHanteiHeader_5;
    private final RString listHanteiHeader_6;
    private final RString listHanteiHeader_7;
    private final RString listHanteiHeader_8;
    private final RString listHanteiHeader_9;
    private final RString listHanteiHeader_10;
    private final RString listHantei_1;
    private final RString listHantei_2;
    private final RString listHantei_3;
    private final RString listHantei_4;
    private final RString listHantei_5;

    /**
     * コンストラクタです。
     *
     * @param listHanteiHeader_1 RString
     * @param listHanteiHeader_2 RString
     * @param listHanteiHeader_3 RString
     * @param listHanteiHeader_4 RString
     * @param listHanteiHeader_5 RString
     * @param listHanteiHeader_6 RString
     * @param listHanteiHeader_7 RString
     * @param listHanteiHeader_8 RString
     * @param listHanteiHeader_9 RString
     * @param listHanteiHeader_10 RString
     * @param listHantei_1 RString
     * @param listHantei_2 RString
     * @param listHantei_3 RString
     * @param listHantei_4 RString
     * @param listHantei_5 RString
     */
    public ShisahanteiJokyo(
            RString listHanteiHeader_1,
            RString listHanteiHeader_2,
            RString listHanteiHeader_3,
            RString listHanteiHeader_4,
            RString listHanteiHeader_5,
            RString listHanteiHeader_6,
            RString listHanteiHeader_7,
            RString listHanteiHeader_8,
            RString listHanteiHeader_9,
            RString listHanteiHeader_10,
            RString listHantei_1,
            RString listHantei_2,
            RString listHantei_3,
            RString listHantei_4,
            RString listHantei_5) {
        this.listHanteiHeader_1 = listHanteiHeader_1;
        this.listHanteiHeader_2 = listHanteiHeader_2;
        this.listHanteiHeader_3 = listHanteiHeader_3;
        this.listHanteiHeader_4 = listHanteiHeader_4;
        this.listHanteiHeader_5 = listHanteiHeader_5;
        this.listHanteiHeader_6 = listHanteiHeader_6;
        this.listHanteiHeader_7 = listHanteiHeader_7;
        this.listHanteiHeader_8 = listHanteiHeader_8;
        this.listHanteiHeader_9 = listHanteiHeader_9;
        this.listHanteiHeader_10 = listHanteiHeader_10;
        this.listHantei_1 = listHantei_1;
        this.listHantei_2 = listHantei_2;
        this.listHantei_3 = listHantei_3;
        this.listHantei_4 = listHantei_4;
        this.listHantei_5 = listHantei_5;
    }
}
