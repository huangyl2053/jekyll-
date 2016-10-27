/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定（一括）確認リストCsvEntityです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGengaokuNintteiKakuninListCsvEntity {

    @CsvField(order = 1, name = "タイトル")
    private RString タイトル;
    @CsvField(order = 2, name = "印刷年月日時分秒")
    private RString 印刷年月日時分秒;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "氏名")
    private RString 氏名;
    @CsvField(order = 5, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 6, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 7, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 8, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 9, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 10, name = "申請負担段階")
    private RString 申請負担段階;
    @CsvField(order = 11, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 12, name = "利")
    private RString 利;
    @CsvField(order = 13, name = "社")
    private RString 社;
    @CsvField(order = 14, name = "対")
    private RString 対;
    @CsvField(order = 15, name = "地")
    private RString 地;
    @CsvField(order = 16, name = "生保")
    private RString 生保;
    @CsvField(order = 17, name = "老齡")
    private RString 老齡;
    @CsvField(order = 18, name = "合計所得(含年金収入)")
    private RString 合計所得_含年金収入;
    @CsvField(order = 19, name = "空白")
    private RString 空白;
    @CsvField(order = 20, name = "世帯課税")
    private RString 世帯課税;
    @CsvField(order = 21, name = "配偶者有無")
    private RString 配偶者有無;
    @CsvField(order = 22, name = "配偶者識別コード")
    private RString 配偶者識別コード;
    @CsvField(order = 23, name = "配偶者氏名")
    private RString 配偶者氏名;
    @CsvField(order = 24, name = "配偶者課税区分")
    private RString 配偶者課税区分;
    @CsvField(order = 25, name = "預貯金額")
    private RString 預貯金額;
    @CsvField(order = 26, name = "有価証券評価概算額")
    private RString 有価証券評価概算額;
    @CsvField(order = 27, name = "その他金額")
    private RString その他金額;
    @CsvField(order = 28, name = "預貯金等合計")
    private RString 預貯金等合計;
    @CsvField(order = 29, name = "住民となった日")
    private RString 住民となった日;
    @CsvField(order = 30, name = "住所地特例該当")
    private RString 住所地特例該当;
    @CsvField(order = 31, name = "非課税年金有")
    private RString 非課税年金有;
    @CsvField(order = 32, name = "非課税年金自己申告有")
    private RString 非課税年金自己申告有;
    @CsvField(order = 33, name = "激変緩和")
    private RString 激変緩和;
    @CsvField(order = 34, name = "今回・申請年月日")
    private RString 今回_申請年月日;
    @CsvField(order = 35, name = "今回・決定年月日")
    private RString 今回_決定年月日;
    @CsvField(order = 36, name = "今回・決定区分")
    private RString 今回_決定区分;

    @CsvField(order = 39, name = "今回・適用日")
    private RString 今回_適用日;
    @CsvField(order = 40, name = "今回・有効期限")
    private RString 今回_有効期限;
    @CsvField(order = 41, name = "今回・旧措置")
    private RString 今回_旧措置;
    @CsvField(order = 42, name = "今回・前回との比較")
    private RString 今回_前回との比較;

    @CsvField(order = 44, name = "今回・負担段階")
    private RString 今回_負担段階;
    @CsvField(order = 45, name = "今回・食費負担額")
    private RString 今回_食費負担額;
    @CsvField(order = 46, name = "今回・ユニット個")
    private RString 今回_ユニット個;
    @CsvField(order = 47, name = "今回・ユニット準")
    private RString 今回_ユニット準;
    @CsvField(order = 48, name = "今回・従来型特養")
    private RString 今回_従来型特養;
    @CsvField(order = 49, name = "今回・従来型老健")
    private RString 今回_従来型老健;
    @CsvField(order = 50, name = "今回・多床室")
    private RString 今回_多床室;
    @CsvField(order = 51, name = "今回・特例減額")
    private RString 今回_特例減額;

    @CsvField(order = 53, name = "前回・申請年月日")
    private RString 前回_申請年月日;
    @CsvField(order = 54, name = "前回・決定年月日")
    private RString 前回_決定年月日;
    @CsvField(order = 55, name = "前回・決定区分")
    private RString 前回_決定区分;

    @CsvField(order = 58, name = "前回・適用日")
    private RString 前回_適用日;
    @CsvField(order = 59, name = "前回・有効期限")
    private RString 前回_有効期限;
    @CsvField(order = 60, name = "前回・旧措置")
    private RString 前回_旧措置;
    @CsvField(order = 61, name = "前回・負担段階")
    private RString 前回_負担段階;
    @CsvField(order = 62, name = "前回・食費負担額")
    private RString 前回_食費負担額;
    @CsvField(order = 63, name = "前回・ユニット個")
    private RString 前回_ユニット個;
    @CsvField(order = 64, name = "前回・ユニット準")
    private RString 前回_ユニット準;
    @CsvField(order = 65, name = "前回・従来型特養")
    private RString 前回_従来型特養;
    @CsvField(order = 66, name = "前回・従来型老健")
    private RString 前回_従来型老健;
    @CsvField(order = 67, name = "前回・多床室")
    private RString 前回_多床室;
    @CsvField(order = 68, name = "前回・特例減額")
    private RString 前回_特例減額;

}
