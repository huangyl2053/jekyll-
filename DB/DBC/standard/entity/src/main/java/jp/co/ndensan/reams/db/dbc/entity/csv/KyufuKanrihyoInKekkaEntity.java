/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票取込結果CSVのエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuKanrihyoInKekkaEntity {

    @CsvField(order = 10)
    private RString 作成日付;
    @CsvField(order = 20)
    private RString 作成時間;
    @CsvField(order = 30)
    private RString 出力順名称1;
    @CsvField(order = 40)
    private RString 出力順昇降順指示1;
    @CsvField(order = 50)
    private RString 出力順名称2;
    @CsvField(order = 60)
    private RString 出力順昇降順指示2;
    @CsvField(order = 70)
    private RString 出力順名称3;
    @CsvField(order = 80)
    private RString 出力順昇降順指示3;
    @CsvField(order = 90)
    private RString 出力順名称4;
    @CsvField(order = 100)
    private RString 出力順昇降順指示4;
    @CsvField(order = 110)
    private RString 出力順名称5;
    @CsvField(order = 120)
    private RString 出力順昇降順指示5;
    @CsvField(order = 130)
    private RString 訪問通所サービス件数;
    @CsvField(order = 140)
    private RString 短期入所サービス件数;
    @CsvField(order = 150)
    private RString 居宅サービス件数;
    @CsvField(order = 160)
    private RString 合計件数;

    /**
     * 作成日付を返します。
     *
     * @return 作成日付
     */
    public RString get作成日付() {
        return 作成日付;
    }

    /**
     * 作成時間を返します。
     *
     * @return 作成時間
     */
    public RString get作成時間() {
        return 作成時間;
    }

    /**
     * 出力順名称1を返します。
     *
     * @return 出力順名称1
     */
    public RString get出力順名称1() {
        return 出力順名称1;
    }

    /**
     * 出力順昇降順指示1を返します。
     *
     * @return 出力順昇降順指示1
     */
    public RString get出力順昇降順指示1() {
        return 出力順昇降順指示1;
    }

    /**
     * 出力順名称2を返します。
     *
     * @return 出力順名称2
     */
    public RString get出力順名称2() {
        return 出力順名称2;
    }

    /**
     * 出力順昇降順指示2を返します。
     *
     * @return 出力順昇降順指示2
     */
    public RString get出力順昇降順指示2() {
        return 出力順昇降順指示2;
    }

    /**
     * 出力順名称3を返します。
     *
     * @return 出力順名称3
     */
    public RString get出力順名称3() {
        return 出力順名称3;
    }

    /**
     * 出力順昇降順指示3を返します。
     *
     * @return 出力順昇降順指示3
     */
    public RString get出力順昇降順指示3() {
        return 出力順昇降順指示3;
    }

    /**
     * 出力順名称4を返します。
     *
     * @return 出力順名称4
     */
    public RString get出力順名称4() {
        return 出力順名称4;
    }

    /**
     * 出力順昇降順指示4を返します。
     *
     * @return 出力順昇降順指示4
     */
    public RString get出力順昇降順指示4() {
        return 出力順昇降順指示4;
    }

    /**
     * 出力順名称5を返します。
     *
     * @return 出力順名称5
     */
    public RString get出力順名称5() {
        return 出力順名称5;
    }

    /**
     * 出力順昇降順指示5を返します。
     *
     * @return 出力順昇降順指示5
     */
    public RString get出力順昇降順指示5() {
        return 出力順昇降順指示5;
    }

    /**
     * 訪問通所サービス件数を返します。
     *
     * @return 訪問通所サービス件数
     */
    public RString get訪問通所サービス件数() {
        return 訪問通所サービス件数;
    }

    /**
     * 短期入所サービス件数を返します。
     *
     * @return 短期入所サービス件数
     */
    public RString get短期入所サービス件数() {
        return 短期入所サービス件数;
    }

    /**
     * 居宅サービス件数を返します。
     *
     * @return 居宅サービス件数
     */
    public RString get居宅サービス件数() {
        return 居宅サービス件数;
    }

    /**
     * 合計件数を返します。
     *
     * @return 合計件数
     */
    public RString get合計件数() {
        return 合計件数;
    }

    /**
     * 作成日付を設定します。
     *
     * @param 作成日付 作成日付
     */
    public void set作成日付(RString 作成日付) {
        this.作成日付 = 作成日付;
    }

    /**
     * 作成時間を設定します。
     *
     * @param 作成時間 作成時間
     */
    public void set作成時間(RString 作成時間) {
        this.作成時間 = 作成時間;
    }

    /**
     * 出力順名称1を設定します。
     *
     * @param 出力順名称1 出力順名称1
     */
    public void set出力順名称1(RString 出力順名称1) {
        this.出力順名称1 = 出力順名称1;
    }

    /**
     * 出力順昇降順指示1を設定します。
     *
     * @param 出力順昇降順指示1 出力順昇降順指示1
     */
    public void set出力順昇降順指示1(RString 出力順昇降順指示1) {
        this.出力順昇降順指示1 = 出力順昇降順指示1;
    }

    /**
     * 出力順名称2を設定します。
     *
     * @param 出力順名称2 出力順名称2
     */
    public void set出力順名称2(RString 出力順名称2) {
        this.出力順名称2 = 出力順名称2;
    }

    /**
     * 出力順昇降順指示2を設定します。
     *
     * @param 出力順昇降順指示2 出力順昇降順指示2
     */
    public void set出力順昇降順指示2(RString 出力順昇降順指示2) {
        this.出力順昇降順指示2 = 出力順昇降順指示2;
    }

    /**
     * 出力順名称3を設定します。
     *
     * @param 出力順名称3 出力順名称3
     */
    public void set出力順名称3(RString 出力順名称3) {
        this.出力順名称3 = 出力順名称3;
    }

    /**
     * 出力順昇降順指示3を設定します。
     *
     * @param 出力順昇降順指示3 出力順昇降順指示3
     */
    public void set出力順昇降順指示3(RString 出力順昇降順指示3) {
        this.出力順昇降順指示3 = 出力順昇降順指示3;
    }

    /**
     * 出力順名称4を設定します。
     *
     * @param 出力順名称4 出力順名称4
     */
    public void set出力順名称4(RString 出力順名称4) {
        this.出力順名称4 = 出力順名称4;
    }

    /**
     * 出力順昇降順指示4を設定します。
     *
     * @param 出力順昇降順指示4 出力順昇降順指示4
     */
    public void set出力順昇降順指示4(RString 出力順昇降順指示4) {
        this.出力順昇降順指示4 = 出力順昇降順指示4;
    }

    /**
     * 出力順名称5を設定します。
     *
     * @param 出力順名称5 出力順名称5
     */
    public void set出力順名称5(RString 出力順名称5) {
        this.出力順名称5 = 出力順名称5;
    }

    /**
     * 出力順昇降順指示5を設定します。
     *
     * @param 出力順昇降順指示5 出力順昇降順指示5
     */
    public void set出力順昇降順指示5(RString 出力順昇降順指示5) {
        this.出力順昇降順指示5 = 出力順昇降順指示5;
    }

    /**
     * 訪問通所サービス件数を設定します。
     *
     * @param 訪問通所サービス件数 訪問通所サービス件数
     */
    public void set訪問通所サービス件数(RString 訪問通所サービス件数) {
        this.訪問通所サービス件数 = 訪問通所サービス件数;
    }

    /**
     * 短期入所サービス件数を設定します。
     *
     * @param 短期入所サービス件数 短期入所サービス件数
     */
    public void set短期入所サービス件数(RString 短期入所サービス件数) {
        this.短期入所サービス件数 = 短期入所サービス件数;
    }

    /**
     * 居宅サービス件数を設定します。
     *
     * @param 居宅サービス件数 居宅サービス件数
     */
    public void set居宅サービス件数(RString 居宅サービス件数) {
        this.居宅サービス件数 = 居宅サービス件数;
    }

    /**
     * 合計件数を設定します。
     *
     * @param 合計件数 合計件数
     */
    public void set合計件数(RString 合計件数) {
        this.合計件数 = 合計件数;
    }
}
