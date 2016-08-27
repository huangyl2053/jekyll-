/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免・減額更新申請対象外者一覧CSV情報entityクラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoGaiShaListCsvEntity {

    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 20, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 30, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 40, name = "基準年月日")
    private RString 基準年月日;
    @CsvField(order = 50, name = "所得年度")
    private RString 所得年度;
    @CsvField(order = 60, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 70, name = "氏名")
    private RString 氏名;
    @CsvField(order = 80, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 90, name = "年齢")
    private RString 年齢;
    @CsvField(order = 100, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 110, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 120, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 130, name = "住所")
    private RString 住所;
    @CsvField(order = 140, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 150, name = "行政区")
    private RString 行政区;
    @CsvField(order = 160, name = "決定区分")
    private RString 決定区分;
    @CsvField(order = 170, name = "減免申請日")
    private RString 減免申請日;
    @CsvField(order = 180, name = "減免決定日")
    private RString 減免決定日;
    @CsvField(order = 190, name = "減免適用日")
    private RString 減免適用日;
    @CsvField(order = 200, name = "減免有効期限")
    private RString 減免有効期限;
    @CsvField(order = 210, name = "世帯課税")
    private RString 世帯課税;
    @CsvField(order = 220, name = "利用者負担段階")
    private RString 利用者負担段階;
    @CsvField(order = 230, name = "老齢福祉年金受給区分")
    private RString 老齢福祉年金受給区分;
    @CsvField(order = 240, name = "生活保護受給区分")
    private RString 生活保護受給区分;
    @CsvField(order = 250, name = "課税所得額")
    private RString 課税所得額;
    @CsvField(order = 260, name = "課税区分")
    private RString 課税区分;
    @CsvField(order = 270, name = "所得税区分")
    private RString 所得税区分;
    @CsvField(order = 280, name = "入所施設コード")
    private RString 入所施設コード;
    @CsvField(order = 290, name = "入所施設名称")
    private RString 入所施設名称;
    @CsvField(order = 300, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 310, name = "旧措置")
    private RString 旧措置;
    @CsvField(order = 320, name = "要介護認定日")
    private RString 要介護認定日;
    @CsvField(order = 330, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 340, name = "認定終了日")
    private RString 認定終了日;

}
