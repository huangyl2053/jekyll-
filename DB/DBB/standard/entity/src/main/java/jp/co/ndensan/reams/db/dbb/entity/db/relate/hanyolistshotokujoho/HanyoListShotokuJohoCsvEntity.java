/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報CsvEntityのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShotokuJohoCsvEntity {

    @CsvField(order = 10, name = "連番")
    private RString 連番;
    @CsvField(order = 20, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 30, name = "住民種別")
    private RString 住民種別;
    @CsvField(order = 40, name = "氏名")
    private RString 氏名;
    @CsvField(order = 50, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 60, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 70, name = "年齢")
    private RString 年齢;
    @CsvField(order = 80, name = "性別")
    private RString 性別;
    @CsvField(order = 90, name = "続柄コード")
    private RString 続柄コード;
    @CsvField(order = 100, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 110, name = "世帯主名")
    private RString 世帯主名;
    @CsvField(order = 120, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 130, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 140, name = "住所番地方書")
    private RString 住所番地方書;
    @CsvField(order = 150, name = "住所")
    private RString 住所;
    @CsvField(order = 160, name = "番地")
    private RString 番地;
    @CsvField(order = 170, name = "方書")
    private RString 方書;
    @CsvField(order = 180, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 190, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 200, name = "地区１")
    private RString 地区１;
    @CsvField(order = 210, name = "地区２")
    private RString 地区２;
    @CsvField(order = 220, name = "地区３")
    private RString 地区３;
    @CsvField(order = 230, name = "連絡先１")
    private RString 連絡先１;
    @CsvField(order = 240, name = "連絡先２")
    private RString 連絡先２;
    @CsvField(order = 250, name = "登録異動日")
    private RString 登録異動日;
    @CsvField(order = 260, name = "登録事由")
    private RString 登録事由;
    @CsvField(order = 270, name = "登録届出日")
    private RString 登録届出日;
    @CsvField(order = 280, name = "住定異動日")
    private RString 住定異動日;
    @CsvField(order = 290, name = "住定事由")
    private RString 住定事由;
    @CsvField(order = 300, name = "住定届出日")
    private RString 住定届出日;
    @CsvField(order = 310, name = "消除異動日")
    private RString 消除異動日;
    @CsvField(order = 320, name = "消除事由")
    private RString 消除事由;
    @CsvField(order = 330, name = "消除届出日")
    private RString 消除届出日;
    @CsvField(order = 340, name = "転出入理由")
    private RString 転出入理由;
    @CsvField(order = 350, name = "前住所郵便番号")
    private RString 前住所郵便番号;
    @CsvField(order = 360, name = "前住所番地方書")
    private RString 前住所番地方書;
    @CsvField(order = 370, name = "前住所")
    private RString 前住所;
    @CsvField(order = 380, name = "前住所番地")
    private RString 前住所番地;
    @CsvField(order = 390, name = "前住所方書")
    private RString 前住所方書;
    @CsvField(order = 400, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 410, name = "市町村名")
    private RString 市町村名;
    @CsvField(order = 420, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 430, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 440, name = "送付先住所コード")
    private RString 送付先住所コード;
    @CsvField(order = 450, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 460, name = "送付先住所番地方書")
    private RString 送付先住所番地方書;
    @CsvField(order = 470, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 480, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 490, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 500, name = "送付先行政区コード")
    private RString 送付先行政区コード;
    @CsvField(order = 510, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 520, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 530, name = "資格取得事由")
    private RString 資格取得事由;
    @CsvField(order = 540, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 550, name = "資格取得届出日")
    private RString 資格取得届出日;
    @CsvField(order = 560, name = "喪失事由")
    private RString 喪失事由;
    @CsvField(order = 570, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 580, name = "資格喪失届日")
    private RString 資格喪失届日;
    @CsvField(order = 590, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 600, name = "住所地特例状態")
    private RString 住所地特例状態;
    @CsvField(order = 610, name = "資格証記載保険者番号")
    private RString 資格証記載保険者番号;
    @CsvField(order = 620, name = "保険料段階")
    private RString 保険料段階;
    @CsvField(order = 630, name = "保険料段階仮算定時")
    private RString 保険料段階仮算定時;
    @CsvField(order = 640, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 650, name = "課税区分減免前")
    private RString 課税区分減免前;
    @CsvField(order = 660, name = "課税区分減免後")
    private RString 課税区分減免後;
    @CsvField(order = 670, name = "合計所得金額")
    private RString 合計所得金額;
    @CsvField(order = 680, name = "公的年金等収入")
    private RString 公的年金等収入;
    @CsvField(order = 690, name = "公的年金等所得")
    private RString 公的年金等所得;
    @CsvField(order = 700, name = "住民税更正年月日")
    private RString 住民税更正年月日;
    @CsvField(order = 710, name = "激変緩和区分")
    private RString 激変緩和区分;
}
