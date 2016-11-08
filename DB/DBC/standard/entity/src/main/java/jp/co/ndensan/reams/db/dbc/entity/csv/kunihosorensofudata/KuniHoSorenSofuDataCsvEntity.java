/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kunihosorensofudata;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 国保連送付データエラーリストのCsvEntityです。
 *
 * @reamsid_L DBC-2770-050 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KuniHoSorenSofuDataCsvEntity implements IKuniHoSorenSofuDataCsvEntity {

    @CsvField(order = 1, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 2, name = "市町村名称")
    private RString 市町村名称;
    @CsvField(order = 3, name = "連番")
    private RString 連番;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 6, name = "氏名")
    private RString 氏名;
    @CsvField(order = 7, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 8, name = "認定要介護度")
    private RString 認定要介護度;
    @CsvField(order = 9, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 10, name = "居宅事業者番号")
    private RString 居宅事業者番号;
    @CsvField(order = 11, name = "特定申請日")
    private RString 特定申請日;
    @CsvField(order = 12, name = "特定開始日")
    private RString 特定開始日;
    @CsvField(order = 13, name = "特定終了日")
    private RString 特定終了日;
    @CsvField(order = 14, name = "社福開始日")
    private RString 社福開始日;
    @CsvField(order = 15, name = "社福終了日")
    private RString 社福終了日;
    @CsvField(order = 16, name = "償還開始日")
    private RString 償還開始日;
    @CsvField(order = 17, name = "エラー情報コード")
    private RString エラー情報コード;
    @CsvField(order = 18, name = "エラー情報内容")
    private RString エラー情報内容;
    @CsvField(order = 19, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 20, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 21, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 22, name = "居宅開始日")
    private RString 居宅開始日;
    @CsvField(order = 23, name = "利用申請日")
    private RString 利用申請日;
    @CsvField(order = 24, name = "利用開始日")
    private RString 利用開始日;
    @CsvField(order = 25, name = "利用終了日")
    private RString 利用終了日;
    @CsvField(order = 26, name = "標準開始日")
    private RString 標準開始日;
    @CsvField(order = 27, name = "標準終了日")
    private RString 標準終了日;
    @CsvField(order = 28, name = "被下開始日")
    private RString 被下開始日;
    @CsvField(order = 29, name = "ページ数")
    private RString ページ数;
    @CsvField(order = 30, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 31, name = "処理年月")
    private RString 処理年月;
}
