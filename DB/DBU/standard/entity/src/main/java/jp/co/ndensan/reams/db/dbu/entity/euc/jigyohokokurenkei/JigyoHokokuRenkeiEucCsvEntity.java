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
    @CsvField(order = 40, name = "D001")
    private final RString D001;
    @CsvField(order = 50, name = "D002")
    private final RString D002;
    @CsvField(order = 60, name = "D003")
    private final RString D003;
    @CsvField(order = 70, name = "D004")
    private final RString D004;
    @CsvField(order = 80, name = "D005")
    private final RString D005;
    @CsvField(order = 90, name = "D006")
    private final RString D006;
    @CsvField(order = 100, name = "D007")
    private final RString D007;
    @CsvField(order = 110, name = "D008")
    private final RString D008;
    @CsvField(order = 120, name = "D009")
    private final RString D009;
    @CsvField(order = 130, name = "D010")
    private final RString D010;
    @CsvField(order = 140, name = "D011")
    private final RString D011;
    @CsvField(order = 150, name = "D012")
    private final RString D012;
    @CsvField(order = 160, name = "D013")
    private final RString D013;
    @CsvField(order = 170, name = "D014")
    private final RString D014;
    @CsvField(order = 180, name = "D015")
    private final RString D015;
    @CsvField(order = 190, name = "D016")
    private final RString D016;
    @CsvField(order = 200, name = "D017")
    private final RString D017;
    @CsvField(order = 210, name = "D018")
    private final RString D018;
    @CsvField(order = 220, name = "D019")
    private final RString D019;
    @CsvField(order = 230, name = "D020")
    private final RString D020;
    @CsvField(order = 240, name = "D021")
    private final RString D021;
    @CsvField(order = 250, name = "D022")
    private final RString D022;
    @CsvField(order = 260, name = "D023")
    private final RString D023;
    @CsvField(order = 270, name = "D0224")
    private final RString D024;
    @CsvField(order = 280, name = "D025")
    private final RString D025;
    @CsvField(order = 290, name = "D026")
    private final RString D026;
    @CsvField(order = 300, name = "D027")
    private final RString D027;
    @CsvField(order = 310, name = "D028")
    private final RString D028;
    @CsvField(order = 320, name = "D029")
    private final RString D029;
    @CsvField(order = 330, name = "D030")
    private final RString D030;
    @CsvField(order = 340, name = "D031")
    private final RString D031;
    @CsvField(order = 350, name = "D032")
    private final RString D032;
    @CsvField(order = 360, name = "D033")
    private final RString D033;
    @CsvField(order = 370, name = "D034")
    private final RString D034;
    @CsvField(order = 380, name = "D035")
    private final RString D035;
    @CsvField(order = 390, name = "D036")
    private final RString D036;

    /**
     * コンストラクタ
     *
     * @param 和暦年 RString
     * @param 月 RString
     * @param 保険者番号 RString
     * @param D001 RString
     * @param D002 RString
     * @param D003 RString
     * @param D004 RString
     * @param D005 RString
     * @param D006 RString
     * @param D007 RString
     * @param D008 RString
     * @param D009 RString
     * @param D010 RString
     * @param D011 RString
     * @param D012 RString
     * @param D013 RString
     * @param D014 RString
     * @param D015 RString
     * @param D016 RString
     * @param D017 RString
     * @param D018 RString
     * @param D019 RString
     * @param D020 RString
     * @param D021 RString
     * @param D022 RString
     * @param D023 RString
     * @param D024 RString
     * @param D025 RString
     * @param D026 RString
     * @param D027 RString
     * @param D028 RString
     * @param D029 RString
     * @param D030 RString
     * @param D031 RString
     * @param D032 RString
     * @param D033 RString
     * @param D034 RString
     * @param D035 RString
     * @param D036 RString
     */
    public JigyoHokokuRenkeiEucCsvEntity(
            RString 和暦年,
            RString 月,
            RString 保険者番号,
            RString D001,
            RString D002,
            RString D003,
            RString D004,
            RString D005,
            RString D006,
            RString D007,
            RString D008,
            RString D009,
            RString D010,
            RString D011,
            RString D012,
            RString D013,
            RString D014,
            RString D015,
            RString D016,
            RString D017,
            RString D018,
            RString D019,
            RString D020,
            RString D021,
            RString D022,
            RString D023,
            RString D024,
            RString D025,
            RString D026,
            RString D027,
            RString D028,
            RString D029,
            RString D030,
            RString D031,
            RString D032,
            RString D033,
            RString D034,
            RString D035,
            RString D036
    ) {
        this.和暦年 = 和暦年;
        this.月 = 月;
        this.保険者番号 = 保険者番号;
        this.D001 = D001;
        this.D002 = D002;
        this.D003 = D003;
        this.D004 = D004;
        this.D005 = D005;
        this.D006 = D006;
        this.D007 = D007;
        this.D008 = D008;
        this.D009 = D009;
        this.D010 = D010;
        this.D011 = D011;
        this.D012 = D012;
        this.D013 = D013;
        this.D014 = D014;
        this.D015 = D015;
        this.D016 = D016;
        this.D017 = D017;
        this.D018 = D018;
        this.D019 = D019;
        this.D020 = D020;
        this.D021 = D021;
        this.D022 = D022;
        this.D023 = D023;
        this.D024 = D024;
        this.D025 = D025;
        this.D026 = D026;
        this.D027 = D027;
        this.D028 = D028;
        this.D029 = D029;
        this.D030 = D030;
        this.D031 = D031;
        this.D032 = D032;
        this.D033 = D033;
        this.D034 = D034;
        this.D035 = D035;
        this.D036 = D036;
    }
}
