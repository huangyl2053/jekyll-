/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokurenkei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式別連携情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBU-4050-020 lijia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class JigyoHokokuRenkeiEucCsvEntity implements IJigyoHokokuRenkeiEucCsvEntity {

    @CsvField(order = 10, name = "和暦年")
    private final RString 和暦年;
    @CsvField(order = 20, name = "月")
    private final RString 月;
    @CsvField(order = 30, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 40, name = "d001")
    private final RString d001;
    @CsvField(order = 50, name = "d002")
    private final RString d002;
    @CsvField(order = 60, name = "d003")
    private final RString d003;
    @CsvField(order = 70, name = "d004")
    private final RString d004;
    @CsvField(order = 80, name = "d005")
    private final RString d005;
    @CsvField(order = 90, name = "d006")
    private final RString d006;
    @CsvField(order = 100, name = "d007")
    private final RString d007;
    @CsvField(order = 110, name = "d008")
    private final RString d008;
    @CsvField(order = 120, name = "d009")
    private final RString d009;
    @CsvField(order = 130, name = "d010")
    private final RString d010;
    @CsvField(order = 140, name = "d011")
    private final RString d011;
    @CsvField(order = 150, name = "d012")
    private final RString d012;
    @CsvField(order = 160, name = "d013")
    private final RString d013;
    @CsvField(order = 170, name = "d014")
    private final RString d014;
    @CsvField(order = 180, name = "d015")
    private final RString d015;
    @CsvField(order = 190, name = "d016")
    private final RString d016;
    @CsvField(order = 200, name = "d017")
    private final RString d017;
    @CsvField(order = 210, name = "d018")
    private final RString d018;
    @CsvField(order = 220, name = "d019")
    private final RString d019;
    @CsvField(order = 230, name = "d020")
    private final RString d020;
    @CsvField(order = 240, name = "d021")
    private final RString d021;
    @CsvField(order = 250, name = "d022")
    private final RString d022;
    @CsvField(order = 260, name = "d023")
    private final RString d023;
    @CsvField(order = 270, name = "d0224")
    private final RString d024;
    @CsvField(order = 280, name = "d025")
    private final RString d025;
    @CsvField(order = 290, name = "d026")
    private final RString d026;
    @CsvField(order = 300, name = "d027")
    private final RString d027;
    @CsvField(order = 310, name = "d028")
    private final RString d028;
    @CsvField(order = 320, name = "d029")
    private final RString d029;
    @CsvField(order = 330, name = "d030")
    private final RString d030;
    @CsvField(order = 340, name = "d031")
    private final RString d031;
    @CsvField(order = 350, name = "d032")
    private final RString d032;
    @CsvField(order = 360, name = "d033")
    private final RString d033;
    @CsvField(order = 370, name = "d034")
    private final RString d034;
    @CsvField(order = 380, name = "d035")
    private final RString d035;
    @CsvField(order = 390, name = "d036")
    private final RString d036;

    /**
     * コンストラクタ
     *
     * @param 和暦年 RString
     * @param 月 RString
     * @param 保険者番号 RString
     * @param d001 RString
     * @param d002 RString
     * @param d003 RString
     * @param d004 RString
     * @param d005 RString
     * @param d006 RString
     * @param d007 RString
     * @param d008 RString
     * @param d009 RString
     * @param d010 RString
     * @param d011 RString
     * @param d012 RString
     * @param d013 RString
     * @param d014 RString
     * @param d015 RString
     * @param d016 RString
     * @param d017 RString
     * @param d018 RString
     * @param d019 RString
     * @param d020 RString
     * @param d021 RString
     * @param d022 RString
     * @param d023 RString
     * @param d024 RString
     * @param d025 RString
     * @param d026 RString
     * @param d027 RString
     * @param d028 RString
     * @param d029 RString
     * @param d030 RString
     * @param d031 RString
     * @param d032 RString
     * @param d033 RString
     * @param d034 RString
     * @param d035 RString
     * @param d036 RString
     */
    public JigyoHokokuRenkeiEucCsvEntity(
            RString 和暦年,
            RString 月,
            RString 保険者番号,
            RString d001,
            RString d002,
            RString d003,
            RString d004,
            RString d005,
            RString d006,
            RString d007,
            RString d008,
            RString d009,
            RString d010,
            RString d011,
            RString d012,
            RString d013,
            RString d014,
            RString d015,
            RString d016,
            RString d017,
            RString d018,
            RString d019,
            RString d020,
            RString d021,
            RString d022,
            RString d023,
            RString d024,
            RString d025,
            RString d026,
            RString d027,
            RString d028,
            RString d029,
            RString d030,
            RString d031,
            RString d032,
            RString d033,
            RString d034,
            RString d035,
            RString d036
    ) {
        this.和暦年 = 和暦年;
        this.月 = 月;
        this.保険者番号 = 保険者番号;
        this.d001 = d001;
        this.d002 = d002;
        this.d003 = d003;
        this.d004 = d004;
        this.d005 = d005;
        this.d006 = d006;
        this.d007 = d007;
        this.d008 = d008;
        this.d009 = d009;
        this.d010 = d010;
        this.d011 = d011;
        this.d012 = d012;
        this.d013 = d013;
        this.d014 = d014;
        this.d015 = d015;
        this.d016 = d016;
        this.d017 = d017;
        this.d018 = d018;
        this.d019 = d019;
        this.d020 = d020;
        this.d021 = d021;
        this.d022 = d022;
        this.d023 = d023;
        this.d024 = d024;
        this.d025 = d025;
        this.d026 = d026;
        this.d027 = d027;
        this.d028 = d028;
        this.d029 = d029;
        this.d030 = d030;
        this.d031 = d031;
        this.d032 = d032;
        this.d033 = d033;
        this.d034 = d034;
        this.d035 = d035;
        this.d036 = d036;
    }
}
