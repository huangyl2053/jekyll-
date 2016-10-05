/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc150050;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力対象データ取得CSVEntityクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3470chohyouShutsuryokuyouCSVEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "明細項目")
    private RString 明細項目;
    @CsvField(order = 60, name = "住民コード")
    private RString 住民コード;
    @CsvField(order = 70, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 80, name = "氏名")
    private RString 氏名;
    @CsvField(order = 90, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 100, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 110, name = "年齢")
    private RString 年齢;
    @CsvField(order = 120, name = "性別")
    private RString 性別;
    @CsvField(order = 130, name = "性別名称")
    private RString 性別名称;
    @CsvField(order = 140, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 150, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 160, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 170, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 180, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 190, name = "住所＋番地＋方書")
    private RString 住所番地方書;
    @CsvField(order = 200, name = "住所")
    private RString 住所;
    @CsvField(order = 210, name = "番地")
    private RString 番地;
    @CsvField(order = 220, name = "方書")
    private RString 方書;
    @CsvField(order = 230, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 240, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 250, name = "地区１")
    private RString 地区１;
    @CsvField(order = 260, name = "地区２")
    private RString 地区２;
    @CsvField(order = 270, name = "地区３")
    private RString 地区３;
    @CsvField(order = 280, name = "空白")
    private RString 空白;
    @CsvField(order = 290, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 300, name = "広域内住所地特例")
    private RString 広域内住所地特例;
    @CsvField(order = 310, name = "広域内住所地名称")
    private RString 広域内住所地名称;
    @CsvField(order = 320, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 330, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 340, name = "給付実績情報作成区分名称")
    private RString 給付実績情報作成区分名称;
    @CsvField(order = 350, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 360, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 370, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 380, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 390, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 400, name = "給付実績区分名称")
    private RString 給付実績区分名称;
    @CsvField(order = 410, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 420, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 430, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 440, name = "要介護状態区分名称")
    private RString 要介護状態区分名称;
    @CsvField(order = 450, name = "旧措置入所者特例コード")
    private RString 旧措置入所者特例コード;
    @CsvField(order = 460, name = "旧措置入所者特例名称")
    private RString 旧措置入所者特例名称;
    @CsvField(order = 470, name = "認定有効期間・開始年月日")
    private RString 認定有効期間_開始年月日;
    @CsvField(order = 480, name = "認定有効期間・終了年月日")
    private RString 認定有効期間_終了年月日;
    @CsvField(order = 490, name = "老人保健市町村番号")
    private RString 老人保健市町村番号;
    @CsvField(order = 500, name = "老人保健受給者番号")
    private RString 老人保健受給者番号;
    @CsvField(order = 510, name = "計画作成区分")
    private RString 計画作成区分;
    @CsvField(order = 520, name = "計画事業所番号")
    private RString 計画事業所番号;
    @CsvField(order = 530, name = "計画事業所名")
    private RString 計画事業所名;
    @CsvField(order = 540, name = "入所（院）年月日")
    private RString 入所院年月日;
    @CsvField(order = 550, name = "退所（院）年月日")
    private RString 退所院年月日;
    @CsvField(order = 560, name = "入所（院）実日数")
    private RString 入所院実日数;
    @CsvField(order = 570, name = "保険給付率")
    private RString 保険給付率;
    @CsvField(order = 580, name = "公費１給付率")
    private RString 公費１給付率;
    @CsvField(order = 590, name = "公費２給付率")
    private RString 公費２給付率;
    @CsvField(order = 600, name = "公費３給付率")
    private RString 公費３給付率;
    @CsvField(order = 610, name = "保険者番号（後期）")
    private RString 保険者番号後期;
    @CsvField(order = 620, name = "被保険者番号（後期）")
    private RString 被保険者番号後期;
    @CsvField(order = 630, name = "保険者番号（国保）")
    private RString 保険者番号国保;
    @CsvField(order = 640, name = "被保険者証番号（国保）")
    private RString 被保険者証番号国保;
    @CsvField(order = 650, name = "個人番号（国保）")
    private RString 個人番号国保;
    @CsvField(order = 660, name = "サービスコード")
    private RString サービスコード;
    @CsvField(order = 670, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 680, name = "サービスコード名称")
    private RString サービスコード名称;
    @CsvField(order = 690, name = "単位数")
    private RString 単位数;
    @CsvField(order = 700, name = "日数・回数")
    private RString 日数回数;
    @CsvField(order = 710, name = "公費１日数・回数")
    private RString 公費１日数回数;
    @CsvField(order = 720, name = "公費２日数・回数")
    private RString 公費２日数回数;
    @CsvField(order = 730, name = "公費３日数・回数")
    private RString 公費３日数回数;
    @CsvField(order = 740, name = "サービス単位数")
    private RString サービス単位数;
    @CsvField(order = 750, name = "公費１サービス単位数")
    private RString 公費１サービス単位数;
    @CsvField(order = 760, name = "公費２サービス単位数")
    private RString 公費２サービス単位数;
    @CsvField(order = 770, name = "公費３サービス単位数")
    private RString 公費３サービス単位数;
    @CsvField(order = 780, name = "審査年月")
    private RString 審査年月;
}
