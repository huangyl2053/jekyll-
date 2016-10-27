/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力(負担限度額認定者リストCSV)クラスです
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakuninListCsvEntity {

    @CsvField(order = 0, name = "連番")
    private RString 連番;
    @CsvField(order = 1, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 2, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 3, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 4, name = "証保険者番号")
    private RString 証保険者番号;
    @CsvField(order = 5, name = "氏名")
    private RString 氏名;
    @CsvField(order = 6, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 7, name = "年齢")
    private RString 年齢;
    @CsvField(order = 8, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 9, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 10, name = "住所")
    private RString 住所;
    @CsvField(order = 11, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 12, name = "行政区")
    private RString 行政区;
    @CsvField(order = 13, name = "決定区分")
    private RString 決定区分;
    @CsvField(order = 14, name = "旧措置者_負担限度額認定")
    private RString 旧措置者_負担限度額認定;
    @CsvField(order = 15, name = "減免申請日")
    private RString 減免申請日;
    @CsvField(order = 16, name = "減免決定日")
    private RString 減免決定日;
    @CsvField(order = 17, name = "減免適用日")
    private RString 減免適用日;
    @CsvField(order = 18, name = "減免有効期限")
    private RString 減免有効期限;
    @CsvField(order = 19, name = "利用者負担段階")
    private RString 利用者負担段階;
    @CsvField(order = 20, name = "食費負担額")
    private RString 食費負担額;
    @CsvField(order = 21, name = "居住費負担限度額ユニット型個室")
    private RString 居住費負担限度額ユニット型個室;
    @CsvField(order = 22, name = "居住費負担限度額ユニット型準個室")
    private RString 居住費負担限度額ユニット型準個室;
    @CsvField(order = 23, name = "居住費負担限度額従来型個室_特養等")
    private RString 居住費負担限度額従来型個室_特養等;
    @CsvField(order = 24, name = "居住費負担限度額従来型個室_老健療養等")
    private RString 居住費負担限度額従来型個室_老健療養等;
    @CsvField(order = 25, name = "居住費負担限度額多床室")
    private RString 居住費負担限度額多床室;
    @CsvField(order = 26, name = "老齢福祉年金受給区分")
    private RString 老齢福祉年金受給区分;
    @CsvField(order = 27, name = "生活保護受給区分")
    private RString 生活保護受給区分;
    @CsvField(order = 28, name = "所得税区分")
    private RString 所得税区分;
    @CsvField(order = 29, name = "課税区分")
    private RString 課税区分;
    @CsvField(order = 30, name = "合計所得金額")
    private RString 合計所得金額;
    @CsvField(order = 31, name = "入所施設コード")
    private RString 入所施設コード;
    @CsvField(order = 32, name = "入所施設名称")
    private RString 入所施設名称;
    @CsvField(order = 33, name = "（認定前負担段階）")
    private RString 認定前負担段階;
    @CsvField(order = 34, name = "旧措置_受給者台帳")
    private RString 旧措置_受給者台帳;
    @CsvField(order = 35, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 36, name = "認定日")
    private RString 認定日;
    @CsvField(order = 37, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 38, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 39, name = "世帯員氏名")
    private RString 世帯員氏名;
    @CsvField(order = 40, name = "世帯員住民種別")
    private RString 世帯員住民種別;
    @CsvField(order = 41, name = "世帯員課税区分")
    private RString 世帯員課税区分;
    @CsvField(order = 42, name = "世帯員所得税課税区分")
    private RString 世帯員所得税課税区分;
    @CsvField(order = 43, name = "世帯員年齢")
    private RString 世帯員年齢;
    @CsvField(order = 44, name = "世帯員受給者区分")
    private RString 世帯員受給者区分;
    @CsvField(order = 45, name = "住民となった日")
    private RString 住民となった日;
    @CsvField(order = 46, name = "住所地特例該当")
    private RString 住所地特例該当;
    @CsvField(order = 47, name = "非課税年金有")
    private RString 非課税年金有;
    @CsvField(order = 48, name = "非課税年金自己申告有")
    private RString 非課税年金自己申告有;
}
