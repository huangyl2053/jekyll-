/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoOutSofuFairulistcsvEntity {

    @CsvField(order = 1, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 2, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 3, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 4, name = "対象年月")
    private RString 対象年月;
    @CsvField(order = 5, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 6, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 7, name = "給付管理票情報作成区分コード")
    private RString 給付管理票情報作成区分コード;
    @CsvField(order = 8, name = "給付管理票作成年月日")
    private RString 給付管理票作成年月日;
    @CsvField(order = 9, name = "給付管理票種別区分コード")
    private RString 給付管理票種別区分コード;
    @CsvField(order = 10, name = "給付管理票明細行番号")
    private RString 給付管理票明細行番号;
    @CsvField(order = 11, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 12, name = "被保険者生年月日")
    private RString 被保険者生年月日;
    @CsvField(order = 13, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 14, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 15, name = "限度額適用期間(開始)")
    private RString 限度額適用期間_開始;
    @CsvField(order = 16, name = "限度額適用期間(終了)")
    private RString 限度額適用期間_終了;
    @CsvField(order = 17, name = "居宅・介護予防・総合事業支給限度額")
    private RString 居宅_介護予防_総合事業支給限度額;
    @CsvField(order = 18, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 19, name = "事業所番号（サービス事業所）")
    private RString 事業所番号_サービス事業所;
    @CsvField(order = 20, name = "指定／基準該当／地域密着型サービス／総合事業識別コード")
    private RString 指定_基準該当_地域密着型サービス_総合事業識別コード;
    @CsvField(order = 21, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 22, name = "給付計画単位数／日数")
    private RString 給付計画単位数_日数;
    @CsvField(order = 23, name = "限度額管理期間における前月までの給付計画日数")
    private RString 限度額管理期間における前月までの給付計画日数;
    @CsvField(order = 24, name = "指定サービス分小計")
    private RString 指定サービス分小計;
    @CsvField(order = 25, name = "基準該当サービス分小計")
    private RString 基準該当サービス分小計;
    @CsvField(order = 26, name = "給付計画合計単位数／日数")
    private RString 給付計画合計単位数_日数;
    @CsvField(order = 27, name = "担当介護支援専門員番号")
    private RString 担当介護支援専門員番号;
    @CsvField(order = 28, name = "委託先の居宅介護支援事業所番号")
    private RString 委託先の居宅介護支援事業所番号;
    @CsvField(order = 29, name = "委託先の担当介護支援専門員番号")
    private RString 委託先の担当介護支援専門員番号;
}
