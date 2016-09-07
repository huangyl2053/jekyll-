/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 県報告用資料情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KenHokokuShiryoSakuseiCSVEntity {

    @CsvField(order = 0, name = " ")
    private final RString タイトル;
    @CsvField(order = 10, name = "非該当")
    private final RString 非該当;
    @CsvField(order = 20, name = "要支援1")
    private final RString 要支援1;
    @CsvField(order = 30, name = "要支援2")
    private final RString 要支援2;
    @CsvField(order = 40, name = "要介護1")
    private final RString 要介護1;
    @CsvField(order = 50, name = "要介護2")
    private final RString 要介護2;
    @CsvField(order = 60, name = "要介護3")
    private final RString 要介護3;
    @CsvField(order = 70, name = "要介護4")
    private final RString 要介護4;
    @CsvField(order = 80, name = "要介護5")
    private final RString 要介護5;

    /**
     * コンストラクタ。
     *
     * @param タイトル タイトル
     * @param 非該当 非該当
     * @param 要支援1 要支援1
     * @param 要支援2 要支援2
     * @param 要介護1 要介護1
     * @param 要介護2 要介護2
     * @param 要介護3 要介護3
     * @param 要介護4 要介護4
     * @param 要介護5 要介護5
     */
    public KenHokokuShiryoSakuseiCSVEntity(
            RString タイトル,
            RString 非該当,
            RString 要支援1,
            RString 要支援2,
            RString 要介護1,
            RString 要介護2,
            RString 要介護3,
            RString 要介護4,
            RString 要介護5) {
        this.タイトル = タイトル;
        this.非該当 = 非該当;
        this.要支援1 = 要支援1;
        this.要支援2 = 要支援2;
        this.要介護1 = 要介護1;
        this.要介護2 = 要介護2;
        this.要介護3 = 要介護3;
        this.要介護4 = 要介護4;
        this.要介護5 = 要介護5;
    }
}
