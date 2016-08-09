/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojigyotaishosha;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(事業対象者)CSV用データEntity。
 *
 * @reamsid_L DBD-5080-030 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoJigyoTaishoshaEucCsvEntity {

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
    @CsvField(order = 140, name = "住所＋番地＋方書")
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
    @CsvField(order = 360, name = "前住所＋番地＋方書")
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
    @CsvField(order = 420, name = "保険者コード")
    private RString 保険者コード;
    @CsvField(order = 430, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 440, name = "空白")
    private RString 空白;
    @CsvField(order = 450, name = "送付先氏名")
    private RString 送付先氏名;
    @CsvField(order = 460, name = "送付先氏名カナ")
    private RString 送付先氏名カナ;
    @CsvField(order = 470, name = "送付先住所コード")
    private RString 送付先住所コード;
    @CsvField(order = 480, name = "送付先郵便番号")
    private RString 送付先郵便番号;
    @CsvField(order = 490, name = "送付先住所＋番地＋方書")
    private RString 送付先住所番地方書;
    @CsvField(order = 500, name = "送付先住所")
    private RString 送付先住所;
    @CsvField(order = 510, name = "送付先番地")
    private RString 送付先番地;
    @CsvField(order = 520, name = "送付先方書")
    private RString 送付先方書;
    @CsvField(order = 530, name = "送付先行政区コード")
    private RString 送付先行政区コード;
    @CsvField(order = 540, name = "送付先行政区名")
    private RString 送付先行政区名;
    @CsvField(order = 550, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 560, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 570, name = "事業適用開始日")
    private RString 事業適用開始日;
    @CsvField(order = 580, name = "事業適用終了日")
    private RString 事業適用終了日;
    @CsvField(order = 590, name = "事業チェック実施日")
    private RString 事業チェック実施日;
    @CsvField(order = 600, name = "事業決定日")
    private RString 事業決定日;
}
