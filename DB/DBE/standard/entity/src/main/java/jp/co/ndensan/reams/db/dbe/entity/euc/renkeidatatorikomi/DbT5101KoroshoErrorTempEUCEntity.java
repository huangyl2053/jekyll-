package jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 要介護認定申請情報一時テーブルのCSV用データEntityです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5101KoroshoErrorTempEUCEntity {

    @CsvField(order = 1, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 2, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 3, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 4, name = "申請種別コード")
    private RString 申請種別コード;
    @CsvField(order = 5, name = "申請種別名称")
    private RString 申請種別名称;
    @CsvField(order = 6, name = "取下区分コード")
    private RString 取下区分コード;
    @CsvField(order = 7, name = "取下区分名称")
    private RString 取下区分名称;
    @CsvField(order = 8, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 9, name = "被保険者区分名称")
    private RString 被保険者区分名称;
    @CsvField(order = 10, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 11, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 12, name = "性別")
    private RString 性別;
    @CsvField(order = 13, name = "氏名（カナ）")
    private RString 氏名カナ;
    @CsvField(order = 14, name = "氏名")
    private RString 氏名;
    @CsvField(order = 15, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 16, name = "住所")
    private RString 住所;
    @CsvField(order = 17, name = "エラー内容")
    private RString エラー内容;
}
