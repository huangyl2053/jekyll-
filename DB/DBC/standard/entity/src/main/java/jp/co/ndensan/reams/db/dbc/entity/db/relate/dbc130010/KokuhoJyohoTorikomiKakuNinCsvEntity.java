/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 現在国保資格情報Entityクラスです。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhoJyohoTorikomiKakuNinCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "IN住民コード")
    private RString IN住民コード;
    @CsvField(order = 3, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 4, name = "国保番号")
    private RString 国保番号;
    @CsvField(order = 5, name = "国保資格取得年月日")
    private RString 国保資格取得年月日;
    @CsvField(order = 6, name = "国保資格喪失年月日")
    private RString 国保資格喪失年月日;
    @CsvField(order = 7, name = "国保保険者番号")
    private RString 国保保険者番号;
    @CsvField(order = 8, name = "国保保険証番号")
    private RString 国保保険証番号;
    @CsvField(order = 9, name = "国保個人番号")
    private RString 国保個人番号;
    @CsvField(order = 10, name = "国保退職該当日")
    private RString 国保退職該当日;
    @CsvField(order = 11, name = "国保退職非該当日")
    private RString 国保退職非該当日;
    @CsvField(order = 12, name = "個人区分コード")
    private RString 個人区分コード;
    @CsvField(order = 13, name = "登録区分")
    private RString 登録区分;
    @CsvField(order = 14, name = "更新コード")
    private RString 更新コード;
    @CsvField(order = 15, name = "氏名")
    private RString 氏名;
    @CsvField(order = 16, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 17, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 18, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 19, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 20, name = "住所")
    private RString 住所;
    @CsvField(order = 21, name = "方書")
    private RString 方書;
    @CsvField(order = 22, name = "エラーコード")
    private RString エラーコード;
    @CsvField(order = 23, name = "エラー文言")
    private RString エラー文言;

}
