/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請書発行一覧CSVコードです。
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoSetaiyinCsvEntity {

    @CsvField(order = 10, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 20, name = "処理年度")
    private RString 処理年度;
    @CsvField(order = 30, name = "世帯課税区分")
    private RString 世帯課税区分;
    @CsvField(order = 40, name = "課税所得区分")
    private RString 課税所得区分;
    @CsvField(order = 50, name = "総収入額")
    private RString 総収入額;
    @CsvField(order = 60, name = "メッセージ")
    private RString メッセージ;
    @CsvField(order = 70, name = "出力有無")
    private RString 出力有無;
    @CsvField(order = 80, name = "年少扶養控除_16歳未満人数")
    private Integer 年少扶養控除_16歳未満人数;
    @CsvField(order = 90, name = "年少扶養控除_16歳から18歳人数")
    private Integer 年少扶養控除_16歳から18歳人数;
    @CsvField(order = 100, name = "ランク市町村コード")
    private RString ランク市町村コード;
    @CsvField(order = 110, name = "世帯員把握基準日")
    private RString 世帯員把握基準日;
    @CsvField(order = 120, name = "世帯員把握基準日2")
    private RString 世帯員把握基準日2;
    @CsvField(order = 130, name = "更新時履歴番号")
    private Integer 更新時履歴番号;
    @CsvField(order = 140, name = "印字文字欠け区分")
    private Boolean 印字文字欠け区分;
    @CsvField(order = 150, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 160, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 170, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 180, name = "住所地特例フラグ")
    private RString 住所地特例フラグ;
    @CsvField(order = 190, name = "課税区分")
    private RString 課税区分;
    @CsvField(order = 200, name = "課税所得")
    private RString 課税所得;
    @CsvField(order = 210, name = "課税所得_控除後")
    private RString 課税所得_控除後;
    @CsvField(order = 220, name = "年金収入")
    private RString 年金収入;
    @CsvField(order = 230, name = "その他の合計所得")
    private RString その他の合計所得;
    @CsvField(order = 240, name = "編集続柄コード")
    private RString 編集続柄コード;
    @CsvField(order = 250, name = "宛名データ種別_1231")
    private RString 宛名データ種別_1231;
    @CsvField(order = 260, name = "宛名データ種別_基準日")
    private RString 宛名データ種別_基準日;
    @CsvField(order = 270, name = "氏名")
    private RString 氏名;
    @CsvField(order = 280, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 290, name = "性別")
    private RString 性別;
    @CsvField(order = 300, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 310, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 320, name = "受給区分")
    private RString 受給区分;
    @CsvField(order = 330, name = "要介護度")
    private RString 要介護度;
    @CsvField(order = 340, name = "認定開始日")
    private RString 認定開始日;
    @CsvField(order = 350, name = "認定終了日")
    private RString 認定終了日;
    @CsvField(order = 360, name = "適用開始日")
    private RString 適用開始日;
    @CsvField(order = 370, name = "適用終了日")
    private RString 適用終了日;
    @CsvField(order = 380, name = "宛名_印字者区分")
    private RString 宛名_印字者区分;

}
