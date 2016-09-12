package jp.co.ndensan.reams.db.dbe.entity.euc.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 要介護認定申請情報エラー一時テーブルのCSV用データEntityです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5913ErrorTempEUCEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "委託先コード")
    private RString 委託先コード;
    @CsvField(order = 5, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 6, name = "調査員名称")
    private RString 調査員名称;
    @CsvField(order = 7, name = "資格コード")
    private RString 資格コード;
    @CsvField(order = 8, name = "資格名称")
    private RString 資格名称;
    @CsvField(order = 9, name = "状況")
    private boolean 状況;
    @CsvField(order = 10, name = "調査員名称カナ")
    private RString 調査員名称カナ;
    @CsvField(order = 11, name = "エラー内容")
    private RString エラー内容;

}
