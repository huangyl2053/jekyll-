/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特別徴収同定一覧表のＣＳＶエンティティです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokubetsuChoshuDoteiIchiranCSVEntity {

    @CsvField(order = 1, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 2, name = "年金番号")
    private RString 年金番号;
    @CsvField(order = 3, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 4, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 5, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 6, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 7, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "カナ氏名_上段")
    private RString カナ氏名_上段;
    @CsvField(order = 10, name = "カナ氏名_下段")
    private RString カナ氏名_下段;
    @CsvField(order = 11, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 12, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 13, name = "住所")
    private RString 住所;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 年金番号 年金番号
     * @param 年金コード 年金コード
     * @param 識別コード 識別コード
     * @param 世帯コード 世帯コード
     * @param 行政区コード 行政区コード
     * @param 生年月日 生年月日
     * @param 性別 性別
     * @param カナ氏名_上段 カナ氏名_上段
     * @param カナ氏名_下段 カナ氏名_下段
     * @param 漢字氏名 漢字氏名
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     */
    public TokubetsuChoshuDoteiIchiranCSVEntity(RString 被保険者番号, RString 年金番号, RString 年金コード,
            RString 識別コード, RString 世帯コード, RString 行政区コード, RString 生年月日, RString 性別, RString カナ氏名_上段,
            RString カナ氏名_下段, RString 漢字氏名, RString 郵便番号, RString 住所) {
        this.被保険者番号 = 被保険者番号;
        this.年金番号 = 年金番号;
        this.年金コード = 年金コード;
        this.識別コード = 識別コード;
        this.世帯コード = 世帯コード;
        this.行政区コード = 行政区コード;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.カナ氏名_上段 = カナ氏名_上段;
        this.カナ氏名_下段 = カナ氏名_下段;
        this.漢字氏名 = 漢字氏名;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
    }

}
