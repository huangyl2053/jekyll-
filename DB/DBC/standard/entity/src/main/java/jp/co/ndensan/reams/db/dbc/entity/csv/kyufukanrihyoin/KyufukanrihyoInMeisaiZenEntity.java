/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kyufukanrihyoin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票情報取込（ファイル読込）の明細csvEntity。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufukanrihyoInMeisaiZenEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 60, name = "対象年月")
    private RString 対象年月;
    @CsvField(order = 70, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 80, name = "事業所番号（居宅介護支援事業所）")
    private RString 事業所番号_居宅介護支援事業所;
    @CsvField(order = 90, name = "給付管理票情報作成区分コード")
    private RString 給付管理票情報作成区分コード;
    @CsvField(order = 100, name = "給付管理票作成年月日")
    private RString 給付管理票作成年月日;
    @CsvField(order = 110, name = "給付管理票種別区分コード")
    private RString 給付管理票種別区分コード;
    @CsvField(order = 120, name = "給付管理票明細行番号")
    private RString 給付管理票明細行番号;
    @CsvField(order = 130, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 140, name = "被保険者生年月日")
    private RString 被保険者生年月日;
    @CsvField(order = 150, name = "被保険者性別コード")
    private RString 被保険者性別コード;
    @CsvField(order = 160, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 170, name = "限度額適用期間（開始）")
    private RString 限度額適用期間_開始;
    @CsvField(order = 180, name = "限度額適用期間（終了）")
    private RString 限度額適用期間_終了;
    @CsvField(order = 190, name = "訪問通所/短期入所支給限度額")
    private RString 訪問通所_短期入所支給限度額;
    @CsvField(order = 200, name = "居宅サービス計画作成区分コード")
    private RString 居宅サービス計画作成区分コード;
    @CsvField(order = 210, name = "事業所番号（サービス事業所）")
    private RString 事業所番号_サービス事業所;
    @CsvField(order = 220, name = "指定/基準該当等事業所区分コード")
    private RString 指定等事業所区分コード;
    @CsvField(order = 230, name = "サービス種別コード")
    private RString サービス種別コード;
    @CsvField(order = 240, name = "給付計画単位数/日数")
    private RString 給付計画単位数_日数;
    @CsvField(order = 250, name = "限度額管理期間における前月までの給付計画日数")
    private RString 限度額管理期間における前月までの給付計画日数;
    @CsvField(order = 260, name = "指定サービス分小計")
    private RString 指定サービス分小計;
    @CsvField(order = 270, name = "基準該当サービス分小計")
    private RString 基準該当サービス分小計;
    @CsvField(order = 280, name = "給付計画合計単位数/日数")
    private RString 給付計画合計単位数_日数;
    @CsvField(order = 290, name = "ブランク")
    private RString ブランク;

}
