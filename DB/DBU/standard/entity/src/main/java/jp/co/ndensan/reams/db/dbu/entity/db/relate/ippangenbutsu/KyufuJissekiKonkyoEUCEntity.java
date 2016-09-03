package jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 事業状況報告統計情報CSV用データEntityです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KyufuJissekiKonkyoEUCEntity implements IKyufuJissekiKonkyoDBU011200EUCEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分")
    private RString 集計区分;
    @CsvField(order = 3, name = "表番号")
    private RString 表番号;
    @CsvField(order = 4, name = "集計番号")
    private RString 集計番号;
    @CsvField(order = 5, name = "集計単位")
    private RString 集計単位;
    @CsvField(order = 6, name = "縦番号")
    private RString 縦番号;
    @CsvField(order = 7, name = "横番号")
    private RString 横番号;
    @CsvField(order = 8, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 9, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 10, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 11, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 12, name = "事業者番号")
    private JigyoshaNo 事業者番号;
    @CsvField(order = 13, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 14, name = "生年月日")
    private FlexibleDate 生年月日;
    @CsvField(order = 15, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 16, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 17, name = "サービス分類")
    private RString サービス分類;
    @CsvField(order = 18, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 19, name = "市町村コード")
    private LasdecCode 市町村コード;
    @CsvField(order = 20, name = "旧市町村コード")
    private LasdecCode 旧市町村コード;
}
