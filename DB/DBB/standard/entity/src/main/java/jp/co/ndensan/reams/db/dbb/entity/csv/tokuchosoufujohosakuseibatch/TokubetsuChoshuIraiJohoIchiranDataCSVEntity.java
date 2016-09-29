/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（特別徴収依頼情報一覧表ＣＳＶ）のentityです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIraiJohoIchiranDataCSVEntity {

    @CsvField(order = 1, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 2, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 3, name = "年金保険者名称")
    private RString 年金保険者名称;
    @CsvField(order = 4, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 5, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 6, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 7, name = "保険者名称")
    private RString 保険者名称;
    @CsvField(order = 8, name = "表示コード名称1")
    private RString 表示コード名称1;
    @CsvField(order = 9, name = "表示コード名称2")
    private RString 表示コード名称2;
    @CsvField(order = 10, name = "表示コード名称3")
    private RString 表示コード名称3;
    @CsvField(order = 11, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 12, name = "年金番号")
    private RString 年金番号;
    @CsvField(order = 13, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 14, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 15, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 16, name = "表示コード1")
    private RString 表示コード1;
    @CsvField(order = 17, name = "表示コード2")
    private RString 表示コード2;
    @CsvField(order = 18, name = "表示コード3")
    private RString 表示コード3;
    @CsvField(order = 19, name = "金額1")
    private RString 金額1;
    @CsvField(order = 20, name = "金額2")
    private RString 金額2;
    @CsvField(order = 21, name = "金額3")
    private RString 金額3;
    @CsvField(order = 22, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 23, name = "年金コード")
    private RString 年金コード;
    @CsvField(order = 24, name = "漢字氏名")
    private RString 漢字氏名;
    @CsvField(order = 25, name = "性別")
    private RString 性別;
    @CsvField(order = 26, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 27, name = "住所")
    private RString 住所;

}
