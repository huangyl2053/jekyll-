/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績D4一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111FKyufuJissekiD4CsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private KokanShikibetsuNo 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private NyuryokuShikibetsuNo 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "証記載保険者番号")
    private HokenshaNo 証記載保険者番号;
    @CsvField(order = 70, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 80, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 90, name = "事業所番号")
    private JigyoshaNo 事業所番号;
    @CsvField(order = 100, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 110, name = "基本_提供日数")
    private int 基本_提供日数;
    @CsvField(order = 120, name = "基本_提供単価")
    private int 基本_提供単価;
    @CsvField(order = 130, name = "基本_提供金額")
    private int 基本_提供金額;
    @CsvField(order = 140, name = "特別_提供日数")
    private int 特別_提供日数;
    @CsvField(order = 150, name = "特別_提供単価")
    private int 特別_提供単価;
    @CsvField(order = 160, name = "特別_提供金額")
    private int 特別_提供金額;
    @CsvField(order = 170, name = "食事提供延べ日数")
    private int 食事提供延べ日数;
    @CsvField(order = 180, name = "公費１対象食事提供延べ日数")
    private int 公費１対象食事提供延べ日数;
    @CsvField(order = 190, name = "公費２対象食事提供延べ日数")
    private int 公費２対象食事提供延べ日数;
    @CsvField(order = 200, name = "公費３対象食事提供延べ日数")
    private int 公費３対象食事提供延べ日数;
    @CsvField(order = 210, name = "食事提供費合計")
    private int 食事提供費合計;
    @CsvField(order = 220, name = "標準負担額_月額")
    private int 標準負担額_月額;
    @CsvField(order = 230, name = "食事提供費請求額")
    private int 食事提供費請求額;
    @CsvField(order = 240, name = "公費１食事提供費請求額")
    private int 公費１食事提供費請求額;
    @CsvField(order = 250, name = "公費２食事提供費請求額")
    private int 公費２食事提供費請求額;
    @CsvField(order = 260, name = "公費３食事提供費請求額")
    private int 公費３食事提供費請求額;
    @CsvField(order = 270, name = "標準負担額_日額")
    private int 標準負担額_日額;
    @CsvField(order = 280, name = "後_基本食提供費用提供単価")
    private int 後_基本食提供費用提供単価;
    @CsvField(order = 290, name = "後_特別食提供費用提供単価")
    private int 後_特別食提供費用提供単価;
    @CsvField(order = 300, name = "後_食事提供費請求額")
    private int 後_食事提供費請求額;
    @CsvField(order = 310, name = "再審査回数")
    private int 再審査回数;
    @CsvField(order = 320, name = "過誤回数")
    private int 過誤回数;
    @CsvField(order = 330, name = "審査年月")
    private FlexibleYearMonth 審査年月;
}
