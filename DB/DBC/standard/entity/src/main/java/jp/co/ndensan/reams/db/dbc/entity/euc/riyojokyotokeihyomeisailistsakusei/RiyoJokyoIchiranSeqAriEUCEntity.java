package jp.co.ndensan.reams.db.dbc.entity.euc.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 利用状況一覧表作成のCSV用データEntity(SEQあり)です。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class RiyoJokyoIchiranSeqAriEUCEntity implements IRiyoJokyoIchiranEUCEntity {

    @CsvField(order = 1, name = "SEQ")
    private RString seq;
    @CsvField(order = 2, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 3, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 4, name = "旧市町村コード")
    private RString 旧市町村コード;
    @CsvField(order = 5, name = "旧市町村名")
    private RString 旧市町村名;
    @CsvField(order = 6, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 7, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 8, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 9, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 10, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 11, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 12, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 13, name = "氏名漢字")
    private RString 氏名漢字;
    @CsvField(order = 14, name = "性別")
    private RString 性別;
    @CsvField(order = 15, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 16, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 17, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 18, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 19, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 20, name = "住所")
    private RString 住所;
    @CsvField(order = 21, name = "地区コード1")
    private RString 地区コード1;
    @CsvField(order = 22, name = "地区名1")
    private RString 地区名1;
    @CsvField(order = 23, name = "地区コード2")
    private RString 地区コード2;
    @CsvField(order = 24, name = "地区名2")
    private RString 地区名2;
    @CsvField(order = 25, name = "地区コード3")
    private RString 地区コード3;
    @CsvField(order = 26, name = "地区名3")
    private RString 地区名3;
    @CsvField(order = 27, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 28, name = "要介護状態区分")
    private RString 要介護状態区分;
    @CsvField(order = 29, name = "認定有効期間・開始年月日")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 30, name = "認定有効期間・終了年月日")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 31, name = "居宅サービス計画作成区分")
    private RString 居宅サービス計画作成区分;
    @CsvField(order = 32, name = "居宅サービス計画事業所番号")
    private RString 居宅サービス計画事業所番号;
    @CsvField(order = 33, name = "居宅サービス計画事業所名")
    private RString 居宅サービス計画事業所名;
    @CsvField(order = 34, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 35, name = "利用実績")
    private RString 利用実績;
    @CsvField(order = 36, name = "公費１・負担者番号")
    private RString 公費１負担者番号;
    @CsvField(order = 37, name = "公費１・受給者番号")
    private RString 公費１受給者番号;
    @CsvField(order = 38, name = "公費２・負担者番号")
    private RString 公費２負担者番号;
    @CsvField(order = 39, name = "公費２・受給者番号")
    private RString 公費２受給者番号;
    @CsvField(order = 40, name = "公費３・負担者番号")
    private RString 公費３負担者番号;
    @CsvField(order = 41, name = "公費３・受給者番号")
    private RString 公費３受給者番号;
    @CsvField(order = 42, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 43, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 44, name = "後期保険者番号")
    private RString 後期保険者番号;
    @CsvField(order = 45, name = "後期被保険者番号")
    private RString 後期被保険者番号;
    @CsvField(order = 46, name = "国保保険者番号")
    private RString 国保保険者番号;
    @CsvField(order = 47, name = "国保被保険者証番号")
    private RString 国保被保険者証番号;
    @CsvField(order = 48, name = "国保個人番号")
    private RString 国保個人番号;
    @CsvField(order = 49, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 50, name = "現物償還の別")
    private RString 現物償還の別;
    @CsvField(order = 51, name = "サービスの別")
    private RString サービスの別;
    @CsvField(order = 52, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 53, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 54, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 55, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 56, name = "日数／回数")
    private RString 日数回数;
    @CsvField(order = 57, name = "短期入所実日数")
    private RString 短期入所実日数;
    @CsvField(order = 58, name = "保険単位数")
    private RString 保険単位数;
    @CsvField(order = 59, name = "保険単位数単価")
    private RString 保険単位数単価;
    @CsvField(order = 60, name = "保険請求額")
    private RString 保険請求額;
    @CsvField(order = 61, name = "保険利用者負担額")
    private RString 保険利用者負担額;
    @CsvField(order = 62, name = "公費１・単位数")
    private RString 公費１単位数;
    @CsvField(order = 63, name = "公費１・請求額")
    private RString 公費１請求額;
    @CsvField(order = 64, name = "公費１・本人負担額")
    private RString 公費１本人負担額;
    @CsvField(order = 65, name = "公費２・単位数")
    private RString 公費２単位数;
    @CsvField(order = 66, name = "公費２・請求額")
    private RString 公費２請求額;
    @CsvField(order = 67, name = "公費２・本人負担額")
    private RString 公費２本人負担額;
    @CsvField(order = 68, name = "公費３・単位数")
    private RString 公費３単位数;
    @CsvField(order = 69, name = "公費３・請求額")
    private RString 公費３請求額;
    @CsvField(order = 70, name = "公費３・本人負担額")
    private RString 公費３本人負担額;
    @CsvField(order = 71, name = "保険出来高単位数")
    private RString 保険出来高単位数;
    @CsvField(order = 72, name = "保険出来高請求額")
    private RString 保険出来高請求額;
    @CsvField(order = 73, name = "保険出来高利用者負担額")
    private RString 保険出来高利用者負担額;
    @CsvField(order = 74, name = "公費１・出来高単位数")
    private RString 公費１出来高単位数;
    @CsvField(order = 75, name = "公費１・出来高請求額")
    private RString 公費１出来高請求額;
    @CsvField(order = 76, name = "公費１・出来高本人負担額")
    private RString 公費１出来高本人負担額;
    @CsvField(order = 77, name = "公費２・出来高単位数")
    private RString 公費２出来高単位数;
    @CsvField(order = 78, name = "公費２・出来高請求額")
    private RString 公費２出来高請求額;
    @CsvField(order = 79, name = "公費２・出来高本人負担額")
    private RString 公費２出来高本人負担額;
    @CsvField(order = 80, name = "公費３・出来高単位数")
    private RString 公費３出来高単位数;
    @CsvField(order = 81, name = "公費３・出来高請求額")
    private RString 公費３出来高請求額;
    @CsvField(order = 82, name = "公費３・出来高本人負担額")
    private RString 公費３出来高本人負担額;
    @CsvField(order = 83, name = "食事基本日数")
    private RString 食事基本日数;
    @CsvField(order = 84, name = "食事基本単価")
    private RString 食事基本単価;
    @CsvField(order = 85, name = "食事特別日数")
    private RString 食事特別日数;
    @CsvField(order = 86, name = "食事特別単価")
    private RString 食事特別単価;
    @CsvField(order = 87, name = "食事提供費合計")
    private RString 食事提供費合計;
    @CsvField(order = 88, name = "標準負担額（日額）")
    private RString 標準負担額日額;
    @CsvField(order = 89, name = "食事提供費請求額")
    private RString 食事提供費請求額;
    @CsvField(order = 90, name = "限度額管理対象単位数")
    private RString 限度額管理対象単位数;
    @CsvField(order = 91, name = "限度額管理対象外単位数")
    private RString 限度額管理対象外単位数;
    @CsvField(order = 92, name = "再審査回数")
    private RString 再審査回数;
    @CsvField(order = 93, name = "過誤回数")
    private RString 過誤回数;
    @CsvField(order = 94, name = "訪問支給限度額")
    private RString 訪問支給限度額;
    @CsvField(order = 95, name = "訪問適用開始日")
    private RString 訪問適用開始日;
    @CsvField(order = 96, name = "訪問適用終了日")
    private RString 訪問適用終了日;
    @CsvField(order = 97, name = "訪問利用サービス単位数")
    private RString 訪問利用サービス単位数;
    @CsvField(order = 98, name = "短期支給限度額")
    private RString 短期支給限度額;
    @CsvField(order = 99, name = "短期適用開始日")
    private RString 短期適用開始日;
    @CsvField(order = 100, name = "短期適用終了日")
    private RString 短期適用終了日;
    @CsvField(order = 101, name = "短期利用サービス単位数")
    private RString 短期利用サービス単位数;
    @CsvField(order = 102, name = "在宅利用率")
    private RString 在宅利用率;
    @CsvField(order = 103, name = "訪問利用率")
    private RString 訪問利用率;
    @CsvField(order = 104, name = "短期利用率")
    private RString 短期利用率;
    @CsvField(order = 105, name = "外泊日数")
    private RString 外泊日数;
    @CsvField(order = 106, name = "退所（院）後の状況")
    private RString 退所院後の状況;
    @CsvField(order = 107, name = "特定入所・日数（食費）")
    private RString 特定入所日数食費;
    @CsvField(order = 108, name = "特定入所・費用額（食費）")
    private RString 特定入所費用額食費;
    @CsvField(order = 109, name = "特定入所・保険分請求額（食費）")
    private RString 特定入所保険分請求額食費;
    @CsvField(order = 110, name = "特定入所・利用者負担額（食費）")
    private RString 特定入所利用者負担額食費;
    @CsvField(order = 111, name = "特定入所・日数（居住）")
    private RString 特定入所日数居住;
    @CsvField(order = 112, name = "特定入所・費用額（居住）")
    private RString 特定入所費用額居住;
    @CsvField(order = 113, name = "特定入所・保険分請求額（居住）")
    private RString 特定入所保険分請求額居住;
    @CsvField(order = 114, name = "特定入所・利用者負担額（居住）")
    private RString 特定入所利用者負担額居住;
    @CsvField(order = 115, name = "社福・軽減率")
    private RString 社福軽減率;
    @CsvField(order = 116, name = "社福・受領すべき利用者負担額")
    private RString 社福受領すべき利用者負担額;
    @CsvField(order = 117, name = "社福・軽減額")
    private RString 社福軽減額;
    @CsvField(order = 118, name = "社福・軽減後利用者負担額")
    private RString 社福軽減後利用者負担額;
}
