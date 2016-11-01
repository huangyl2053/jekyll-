/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(更正対象給付実績一覧CSV)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiTaishoKyufuJissekiIchiranCsvEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "連番")
    private RString 連番;
    @CsvField(order = 3, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 4, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 5, name = "年度")
    private FlexibleYear 年度;
    @CsvField(order = 6, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 7, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 8, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 9, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 10, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 11, name = "サービス種類")
    private RString サービス種類;
    @CsvField(order = 12, name = "サービス費用額")
    private Decimal サービス費用額;
    @CsvField(order = 13, name = "社福")
    private RString 社福;
    @CsvField(order = 14, name = "高額")
    private RString 高額;
    @CsvField(order = 15, name = "更正前給付率")
    private RString 更正前給付率;
    @CsvField(order = 16, name = "更正前請求額")
    private Decimal 更正前請求額;
    @CsvField(order = 17, name = "更正前自己負担額")
    private Decimal 更正前自己負担額;
    @CsvField(order = 18, name = "更正後給付率")
    private Decimal 更正後給付率;
    @CsvField(order = 19, name = "更正後請求額")
    private Decimal 更正後請求額;
    @CsvField(order = 20, name = "更正後自己負担額")
    private Decimal 更正後自己負担額;
    @CsvField(order = 21, name = "自己負担額差額")
    private Decimal 自己負担額差額;
    @CsvField(order = 22, name = "高額サービス費用額")
    private Decimal 高額サービス費用額;
}
