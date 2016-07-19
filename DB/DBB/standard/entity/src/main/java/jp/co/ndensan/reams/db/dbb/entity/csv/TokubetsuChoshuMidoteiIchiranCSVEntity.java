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
 * 特別徴収未同定一覧表のＣＳＶエンティティです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokubetsuChoshuMidoteiIchiranCSVEntity {

    @CsvField(order = 1, name = "年金番号")
    private RString 年金番号;
    @CsvField(order = 2, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 3, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 4, name = "性別")
    private RString 性別;
    @CsvField(order = 5, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 6, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 7, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 8, name = "住所")
    private RString 住所;
    @CsvField(order = 9, name = "天引先区分")
    private RString 天引先区分;

    /**
     * コンストラクタです。
     *
     * @param 年金番号 年金番号
     * @param 年金コード 年金コード
     * @param 生年月日 生年月日
     * @param 性別 性別
     * @param カナ氏名 カナ氏名
     * @param 漢字氏名 漢字氏名
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 天引先区分 天引先区分
     */
    public TokubetsuChoshuMidoteiIchiranCSVEntity(RString 年金番号, RString 年金コード, RString 生年月日, RString 性別,
            RString カナ氏名, RString 漢字氏名, RString 郵便番号, RString 住所, RString 天引先区分) {
        this.年金番号 = 年金番号;
        this.年金コード = 年金コード;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.カナ氏名 = カナ氏名;
        this.漢字氏名 = 漢字氏名;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.天引先区分 = 天引先区分;
    }

}
