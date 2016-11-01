/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 予防給付数情報根拠CSVEntityクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YoboKyufusuJohoKonkyoCsvEntity {

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
    @CsvField(order = 9, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 11, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 12, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 13, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 14, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 15, name = "明細番号")
    private RString 明細番号;
    @CsvField(order = 16, name = "元整理番号")
    private RString 元整理番号;
    @CsvField(order = 17, name = "申請管理支給区分コード")
    private RString 申請管理支給区分コード;
    @CsvField(order = 18, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 19, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 20, name = "旧措置入所者特例コード")
    private RString 旧措置入所者特例コード;
    @CsvField(order = 21, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 22, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 23, name = "食事費用被保険者番号")
    private RString 食事費用被保険者番号;
    @CsvField(order = 24, name = "基本提供日数")
    private RString 基本提供日数;
    @CsvField(order = 25, name = "特別提供日数")
    private RString 特別提供日数;
    @CsvField(order = 26, name = "食事提供延べ日数")
    private RString 食事提供延べ日数;
    @CsvField(order = 27, name = "基本提供単価")
    private RString 基本提供単価;
    @CsvField(order = 28, name = "特別提供単価")
    private RString 特別提供単価;
    @CsvField(order = 29, name = "後・食事提供費請求額")
    private RString 後_食事提供費請求額;
    @CsvField(order = 30, name = "食事費用支給区分コード")
    private RString 食事費用支給区分コード;
    @CsvField(order = 31, name = "食事費用支給金額")
    private RString 食事費用支給金額;
    @CsvField(order = 32, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 33, name = "請求点数単価")
    private RString 請求点数単価;
    @CsvField(order = 34, name = "請求額")
    private RString 請求額;
    @CsvField(order = 35, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 36, name = "後・点数合計")
    private RString 後_点数合計;
    @CsvField(order = 37, name = "後・保険請求分請求額")
    private RString 後_保険請求分請求額;
    @CsvField(order = 38, name = "後・出来高点数合計")
    private RString 後_出来高点数合計;
    @CsvField(order = 39, name = "後・出来高請求額")
    private RString 後_出来高請求額;
    @CsvField(order = 40, name = "集計支給区分コード")
    private RString 集計支給区分コード;
    @CsvField(order = 41, name = "集計支給金額")
    private RString 集計支給金額;
    @CsvField(order = 42, name = "増減点")
    private RString 増減点;
    @CsvField(order = 43, name = "後・点数")
    private RString 後_点数;
    @CsvField(order = 44, name = "後・請求金額 ")
    private RString 後_請求金額;
    @CsvField(order = 45, name = "計画費支給区分コード")
    private RString 計画費支給区分コード;
    @CsvField(order = 46, name = "計画費支給金額")
    private RString 計画費支給金額;
    @CsvField(order = 47, name = "明細点数")
    private RString 明細点数;
    @CsvField(order = 48, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 49, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 50, name = "旧市町村コード")
    private RString 旧市町村コード;
    @CsvField(order = 51, name = "現物分存在フラグ")
    private RString 現物分存在フラグ;
    @CsvField(order = 52, name = "負担割合区分")
    private RString 負担割合区分;
    @CsvField(order = 53, name = "審査年月")
    private RString 審査年月;
}
