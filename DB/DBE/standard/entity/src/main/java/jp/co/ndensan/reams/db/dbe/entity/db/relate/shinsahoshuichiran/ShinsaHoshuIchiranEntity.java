/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬一覧表の帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaHoshuIchiranEntity implements IShinsaHoshuIchiranEntityCsvEucEntity {

    @CsvField(order = 1, name = "合議体番号")
    private final RString 合議体No;
    @CsvField(order = 2, name = "審査員氏名")
    private final RString 審査員氏名;
    @CsvField(order = 3, name = "対象年月")
    private final RString 出席日;
    @CsvField(order = 4, name = "1日の出席状況")
    private final RString 出欠_1;
    @CsvField(order = 5, name = "2日の出席状況")
    private final RString 出欠_2;
    @CsvField(order = 6, name = "3日の出席状況")
    private final RString 出欠_3;
    @CsvField(order = 7, name = "4日の出席状況")
    private final RString 出欠_4;
    @CsvField(order = 8, name = "5日の出席状況")
    private final RString 出欠_5;
    @CsvField(order = 9, name = "6日の出席状況")
    private final RString 出欠_6;
    @CsvField(order = 10, name = "7日の出席状況")
    private final RString 出欠_7;
    @CsvField(order = 11, name = "8日の出席状況")
    private final RString 出欠_8;
    @CsvField(order = 12, name = "9日の出席状況")
    private final RString 出欠_9;
    @CsvField(order = 13, name = "10日の出席状況")
    private final RString 出欠_10;
    @CsvField(order = 14, name = "11日の出席状況")
    private final RString 出欠_11;
    @CsvField(order = 15, name = "12日の出席状況")
    private final RString 出欠_12;
    @CsvField(order = 16, name = "13日の出席状況")
    private final RString 出欠_13;
    @CsvField(order = 17, name = "14日の出席状況")
    private final RString 出欠_14;
    @CsvField(order = 18, name = "15日の出席状況")
    private final RString 出欠_15;
    @CsvField(order = 19, name = "16日の出席状況")
    private final RString 出欠_16;
    @CsvField(order = 20, name = "17日の出席状況")
    private final RString 出欠_17;
    @CsvField(order = 21, name = "18日の出席状況")
    private final RString 出欠_18;
    @CsvField(order = 22, name = "19日の出席状況")
    private final RString 出欠_19;
    @CsvField(order = 23, name = "20日の出席状況")
    private final RString 出欠_20;
    @CsvField(order = 24, name = "21日の出席状況")
    private final RString 出欠_21;
    @CsvField(order = 25, name = "22日の出席状況")
    private final RString 出欠_22;
    @CsvField(order = 26, name = "23日の出席状況")
    private final RString 出欠_23;
    @CsvField(order = 27, name = "24日の出席状況")
    private final RString 出欠_24;
    @CsvField(order = 28, name = "25日の出席状況")
    private final RString 出欠_25;
    @CsvField(order = 29, name = "26日の出席状況")
    private final RString 出欠_26;
    @CsvField(order = 30, name = "27日の出席状況")
    private final RString 出欠_27;
    @CsvField(order = 31, name = "28日の出席状況")
    private final RString 出欠_28;
    @CsvField(order = 32, name = "29日の出席状況")
    private final RString 出欠_29;
    @CsvField(order = 33, name = "30日の出席状況")
    private final RString 出欠_30;
    @CsvField(order = 34, name = "31日の出席状況")
    private final RString 出欠_31;
    @CsvField(order = 35, name = "出席回数")
    private final RString 出席回数;
    @CsvField(order = 36, name = "報酬総額")
    private final RString 報酬総額;
    @CsvField(order = 37, name = "税額控除")
    private final RString 税額控除;
    @CsvField(order = 38, name = "報酬合計")
    private final RString 報酬合計;
    @CsvField(order = 39, name = "審査回数_合計")
    private final RString 審査回数_合計;
    @CsvField(order = 40, name = "報酬総額_合計")
    private final RString 報酬総額_合計;
    @CsvField(order = 41, name = "税額控除_合計")
    private final RString 税額控除_合計;
    @CsvField(order = 42, name = "報酬合計_合計")
    private final RString 報酬合計_合計;

    /**
     * コンストラクタです。
     *
     * @param 合議体No 合議体番号
     * @param 審査員氏名 審査員氏名
     * @param 出席日 出席日
     * @param 出欠_1 1日の出席状況
     * @param 出欠_2 2日の出席状況
     * @param 出欠_3 3日の出席状況
     * @param 出欠_4 4日の出席状況
     * @param 出欠_5 5日の出席状況
     * @param 出欠_6 6日の出席状況
     * @param 出欠_7 7日の出席状況
     * @param 出欠_8 8日の出席状況
     * @param 出欠_9 9日の出席状況
     * @param 出欠_10 10日の出席状況
     * @param 出欠_11 11日の出席状況
     * @param 出欠_12 12日の出席状況
     * @param 出欠_13 13日の出席状況
     * @param 出欠_14 14日の出席状況
     * @param 出欠_15 15日の出席状況
     * @param 出欠_16 16日の出席状況
     * @param 出欠_17 17日の出席状況
     * @param 出欠_18 18日の出席状況
     * @param 出欠_19 19日の出席状況
     * @param 出欠_20 20日の出席状況
     * @param 出欠_21 21日の出席状況
     * @param 出欠_22 22日の出席状況
     * @param 出欠_23 23日の出席状況
     * @param 出欠_24 24日の出席状況
     * @param 出欠_25 25日の出席状況
     * @param 出欠_26 26日の出席状況
     * @param 出欠_27 27日の出席状況
     * @param 出欠_28 28日の出席状況
     * @param 出欠_29 29日の出席状況
     * @param 出欠_30 30日の出席状況
     * @param 出欠_31 31日の出席状況
     * @param 出席回数 出席回数
     * @param 報酬総額 報酬総額
     * @param 税額控除 税額控除
     * @param 報酬合計 報酬合計
     * @param 審査回数_合計 審査回数_合計
     * @param 報酬総額_合計 報酬総額_合計
     * @param 税額控除_合計 税額控除_合計
     * @param 報酬合計_合計 報酬合計_合計
     */
    public ShinsaHoshuIchiranEntity(
            RString 合議体No,
            RString 審査員氏名,
            RString 出席日,
            RString 出欠_1,
            RString 出欠_2,
            RString 出欠_3,
            RString 出欠_4,
            RString 出欠_5,
            RString 出欠_6,
            RString 出欠_7,
            RString 出欠_8,
            RString 出欠_9,
            RString 出欠_10,
            RString 出欠_11,
            RString 出欠_12,
            RString 出欠_13,
            RString 出欠_14,
            RString 出欠_15,
            RString 出欠_16,
            RString 出欠_17,
            RString 出欠_18,
            RString 出欠_19,
            RString 出欠_20,
            RString 出欠_21,
            RString 出欠_22,
            RString 出欠_23,
            RString 出欠_24,
            RString 出欠_25,
            RString 出欠_26,
            RString 出欠_27,
            RString 出欠_28,
            RString 出欠_29,
            RString 出欠_30,
            RString 出欠_31,
            RString 出席回数,
            RString 報酬総額,
            RString 税額控除,
            RString 報酬合計,
            RString 審査回数_合計,
            RString 報酬総額_合計,
            RString 税額控除_合計,
            RString 報酬合計_合計) {
        this.合議体No = 合議体No;
        this.審査員氏名 = 審査員氏名;
        this.出席日 = 出席日;
        this.出欠_1 = 出欠_1;
        this.出欠_2 = 出欠_2;
        this.出欠_3 = 出欠_3;
        this.出欠_4 = 出欠_4;
        this.出欠_5 = 出欠_5;
        this.出欠_6 = 出欠_6;
        this.出欠_7 = 出欠_7;
        this.出欠_8 = 出欠_8;
        this.出欠_9 = 出欠_9;
        this.出欠_10 = 出欠_10;
        this.出欠_11 = 出欠_11;
        this.出欠_12 = 出欠_12;
        this.出欠_13 = 出欠_13;
        this.出欠_14 = 出欠_14;
        this.出欠_15 = 出欠_15;
        this.出欠_16 = 出欠_16;
        this.出欠_17 = 出欠_17;
        this.出欠_18 = 出欠_18;
        this.出欠_19 = 出欠_19;
        this.出欠_20 = 出欠_20;
        this.出欠_21 = 出欠_21;
        this.出欠_22 = 出欠_22;
        this.出欠_23 = 出欠_23;
        this.出欠_24 = 出欠_24;
        this.出欠_25 = 出欠_25;
        this.出欠_26 = 出欠_26;
        this.出欠_27 = 出欠_27;
        this.出欠_28 = 出欠_28;
        this.出欠_29 = 出欠_29;
        this.出欠_30 = 出欠_30;
        this.出欠_31 = 出欠_31;
        this.出席回数 = 出席回数;
        this.報酬総額 = 報酬総額;
        this.税額控除 = 税額控除;
        this.報酬合計 = 報酬合計;
        this.審査回数_合計 = 審査回数_合計;
        this.報酬総額_合計 = 報酬総額_合計;
        this.税額控除_合計 = 税額控除_合計;
        this.報酬合計_合計 = 報酬合計_合計;
    }
}
