/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減認定者リストCSV用データEntity
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHojinKeigenCsvEntity {

    @CsvField(order = 10, name = "連番")
    private RString 連番;
    @CsvField(order = 20, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 30, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 40, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 50, name = "証保険者番号")
    private RString 証保険者番号;
    @CsvField(order = 60, name = "氏名")
    private RString 氏名;
    @CsvField(order = 70, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 80, name = "年齢")
    private RString 年齢;
    @CsvField(order = 90, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 100, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 110, name = "住所")
    private RString 住所;
    @CsvField(order = 120, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 130, name = "行政区")
    private RString 行政区;
    @CsvField(order = 140, name = "確認番号")
    private RString 確認番号;
    @CsvField(order = 150, name = "決定区分")
    private RString 決定区分;
    @CsvField(order = 160, name = "減免事由")
    private RString 減免事由;
    @CsvField(order = 170, name = "減免申請日")
    private RString 減免申請日;
    @CsvField(order = 180, name = "減免決定日")
    private RString 減免決定日;
    @CsvField(order = 190, name = "減免適用日")
    private RString 減免適用日;
    @CsvField(order = 200, name = "減免有効期限")
    private RString 減免有効期限;
    @CsvField(order = 210, name = "軽減率分子")
    private RString 軽減率分子;
    @CsvField(order = 220, name = "軽減率分母")
    private RString 軽減率分母;
    @CsvField(order = 230, name = "対象サービスの制限")
    private RString 対象サービスの制限;
    @CsvField(order = 240, name = "居宅支援事業者番号")
    private RString 居宅支援事業者番号;
    @CsvField(order = 250, name = "居宅支援事業者名称")
    private RString 居宅支援事業者名称;
    @CsvField(order = 260, name = "老齢福祉年金受給")
    private RString 老齢福祉年金受給;
    @CsvField(order = 270, name = "生活保護受給区分")
    private RString 生活保護受給区分;
    @CsvField(order = 280, name = "課税区分")
    private RString 課税区分;
    @CsvField(order = 290, name = "所得税課税区分")
    private RString 所得税課税区分;
    @CsvField(order = 300, name = "入所施設コード")
    private RString 入所施設コード;
    @CsvField(order = 310, name = "入所施設名称")
    private RString 入所施設名称;
    @CsvField(order = 320, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 330, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 340, name = "認定日")
    private RString 認定日;
    @CsvField(order = 350, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 360, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 370, name = "世帯員氏名")
    private RString 世帯員氏名;
    @CsvField(order = 380, name = "世帯員住民種別")
    private RString 世帯員住民種別;
    @CsvField(order = 390, name = "世帯員課税区分")
    private RString 世帯員課税区分;
    @CsvField(order = 400, name = "世帯員所得税課税区分")
    private RString 世帯員所得税課税区分;
}
