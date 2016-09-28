/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定結果一覧表出力CSVのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonnSanteiFukaCSVEntity {

    @CsvField(order = 10, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 20, name = "作成時刻")
    private RString 作成時刻;
    @CsvField(order = 30, name = "賦課年度")
    private RString 賦課年度;
    @CsvField(order = 40, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "氏名")
    private RString 氏名;
    @CsvField(order = 70, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 80, name = "性別")
    private RString 性別;
    @CsvField(order = 90, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 100, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 110, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 120, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 130, name = "住所")
    private RString 住所;
    @CsvField(order = 140, name = "町域管内管外住所")
    private RString 町域管内管外住所;
    @CsvField(order = 150, name = "番地")
    private RString 番地;
    @CsvField(order = 160, name = "口座情報")
    private RString 口座情報;
    @CsvField(order = 170, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 180, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 190, name = "資格期間")
    private RString 資格期間;
    @CsvField(order = 200, name = "確定保険料額")
    private RString 確定保険料額;
    @CsvField(order = 210, name = "計算上保険料額")
    private RString 計算上保険料額;
    @CsvField(order = 220, name = "減免額")
    private RString 減免額;
    @CsvField(order = 230, name = "月別取得段階4月")
    private RString 月別取得段階4月;
    @CsvField(order = 240, name = "月別取得段階5月")
    private RString 月別取得段階5月;
    @CsvField(order = 250, name = "月別取得段階6月")
    private RString 月別取得段階6月;
    @CsvField(order = 260, name = "月別取得段階7月")
    private RString 月別取得段階7月;
    @CsvField(order = 270, name = "月別取得段階8月")
    private RString 月別取得段階8月;
    @CsvField(order = 280, name = "月別取得段階9月")
    private RString 月別取得段階9月;
    @CsvField(order = 290, name = "月別取得段階10月")
    private RString 月別取得段階10月;
    @CsvField(order = 300, name = "月別取得段階11月")
    private RString 月別取得段階11月;
    @CsvField(order = 310, name = "月別取得段階12月")
    private RString 月別取得段階12月;
    @CsvField(order = 320, name = "月別取得段階1月")
    private RString 月別取得段階1月;
    @CsvField(order = 330, name = "月別取得段階2月")
    private RString 月別取得段階2月;
    @CsvField(order = 340, name = "月別取得段階3月")
    private RString 月別取得段階3月;
    @CsvField(order = 350, name = "徴収方法")
    private RString 徴収方法;
    @CsvField(order = 360, name = "特徴額１期")
    private RString 特徴額１期;
    @CsvField(order = 370, name = "特徴額２期")
    private RString 特徴額２期;
    @CsvField(order = 380, name = "特徴額３期")
    private RString 特徴額３期;
    @CsvField(order = 390, name = "特徴額４期")
    private RString 特徴額４期;
    @CsvField(order = 400, name = "特徴額５期")
    private RString 特徴額５期;
    @CsvField(order = 410, name = "特徴額６期")
    private RString 特徴額６期;
    @CsvField(order = 420, name = "普徴額1期")
    private RString 普徴額1期;
    @CsvField(order = 430, name = "普徴額2期")
    private RString 普徴額2期;
    @CsvField(order = 440, name = "普徴額3期")
    private RString 普徴額3期;
    @CsvField(order = 450, name = "普徴額4期")
    private RString 普徴額4期;
    @CsvField(order = 460, name = "普徴額5期")
    private RString 普徴額5期;
    @CsvField(order = 470, name = "普徴額6期")
    private RString 普徴額6期;
    @CsvField(order = 480, name = "普徴額7期")
    private RString 普徴額7期;
    @CsvField(order = 490, name = "普徴額8期")
    private RString 普徴額8期;
    @CsvField(order = 500, name = "普徴額9期")
    private RString 普徴額9期;
    @CsvField(order = 510, name = "普徴額10期")
    private RString 普徴額10期;
    @CsvField(order = 520, name = "普徴額11期")
    private RString 普徴額11期;
    @CsvField(order = 530, name = "普徴額12期")
    private RString 普徴額12期;
    @CsvField(order = 540, name = "備考")
    private RString 備考;
}
