/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計算対象者ファイルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakukaigoSabishiEucEntity {

    @CsvField(order = 1, name = "No ")
    private RString no;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 4, name = "氏名")
    private RString 氏名;
    @CsvField(order = 5, name = "年月")
    private RString 年月;
    @CsvField(order = 6, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 7, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 8, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 9, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 10, name = "旧措置区分")
    private RString 旧措置区分;
    @CsvField(order = 11, name = "世帯番号")
    private RString 世帯番号;
    @CsvField(order = 12, name = "単独合算")
    private RString 単独合算;
    @CsvField(order = 13, name = "自己負担額")
    private RString 自己負担額;
    @CsvField(order = 14, name = "支給(予定)金額")
    private RString 支給予定金額;
    @CsvField(order = 15, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 16, name = "世帯所得区分")
    private RString 世帯所得区分;
    @CsvField(order = 17, name = "生保区分")
    private RString 生保区分;
    @CsvField(order = 18, name = "激変緩和")
    private RString 激変緩和;
    @CsvField(order = 19, name = "データの状態")
    private RString データの状態;
    @CsvField(order = 20, name = "算定基準額")
    private RString 算定基準額;
    @CsvField(order = 21, name = "高額支給額")
    private RString 高額支給額;
    @CsvField(order = 22, name = "社福軽減")
    private RString 社福軽減;
    @CsvField(order = 23, name = "境界層")
    private RString 境界層;
    @CsvField(order = 24, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 25, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 26, name = "住所+番地+方書")
    private RString 住所番地方書;
    @CsvField(order = 27, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 28, name = "行政区")
    private RString 行政区;
    @CsvField(order = 29, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 30, name = "異動内容1")
    private RString 異動内容1;
    @CsvField(order = 31, name = "異動内容2")
    private RString 異動内容2;
    @CsvField(order = 32, name = "異動内容3")
    private RString 異動内容3;
    @CsvField(order = 33, name = "異動内容4")
    private RString 異動内容4;
    @CsvField(order = 34, name = "異動内容5")
    private RString 異動内容5;
    @CsvField(order = 35, name = "異動内容6")
    private RString 異動内容6;
    @CsvField(order = 36, name = "異動内容7")
    private RString 異動内容7;
    @CsvField(order = 37, name = "異動内容8")
    private RString 異動内容8;
    @CsvField(order = 38, name = "異動内容9")
    private RString 異動内容9;
    @CsvField(order = 39, name = "異動内容10")
    private RString 異動内容10;

}
