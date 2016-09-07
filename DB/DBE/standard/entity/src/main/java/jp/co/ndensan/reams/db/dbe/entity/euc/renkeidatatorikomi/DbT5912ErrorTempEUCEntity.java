package jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 主治医エラー一時テーブルのCSV用データEntityです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5912ErrorTempEUCEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 5, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 6, name = "主治医名称")
    private RString 主治医名称;
    @CsvField(order = 7, name = "状況")
    private boolean 状況;
    @CsvField(order = 8, name = "主治医名称カナ")
    private RString 主治医名称カナ;
    @CsvField(order = 9, name = "エラー内容")
    private RString エラー内容;

}
