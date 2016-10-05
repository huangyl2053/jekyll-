/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakugassan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算補正済自己負担額情報作成のデータレコードです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanSoufuFairuSakuseiMeisaiEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "支給申請書整理番号")
    private RString 支給申請書整理番号;
    @CsvField(order = 50, name = "保険制度コード")
    private RString 保険制度コード;
    @CsvField(order = 60, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 70, name = "保険者名称")
    private RString 保険者名称;
    @CsvField(order = 80, name = "被保険者証記号")
    private RString 被保険者証記号;
    @CsvField(order = 90, name = "被保険者（証）番号")
    private RString 被保険者証番号;
    @CsvField(order = 100, name = "被保険者氏名（カナ）")
    private RString 被保険者氏名_カナ;
    @CsvField(order = 110, name = "被保険者氏名（漢字）")
    private RString 被保険者氏名_漢字;
    @CsvField(order = 120, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 130, name = "性別")
    private RString 性別;
    @CsvField(order = 140, name = "所得区分")
    private RString 所得区分;
    @CsvField(order = 150, name = "70歳以上の者に係る所得区分")
    private RString 所得区分_70歳以上の者係る;
    @CsvField(order = 160, name = "自己負担額証明書整理番号")
    private RString 自己負担額証明書整理番号;
    @CsvField(order = 170, name = "突合用後期高齢者医療保険者番号")
    private RString 突合用後期高齢者医療保険者番号;
    @CsvField(order = 180, name = "突合用後期高齢者医療被保険者番号")
    private RString 突合用後期高齢者医療被保険者番号;
    @CsvField(order = 190, name = "突合用国民健康保険保険者番号")
    private RString 突合用国民健康保険保険者番号;
    @CsvField(order = 200, name = "突合用国民健康保険被保険者証番号")
    private RString 突合用国民健康保険被保険者証番号;
    @CsvField(order = 210, name = "突合用国保被保険者個人番号")
    private RString 突合用国保被保険者個人番号;
    @CsvField(order = 220, name = "異動区分")
    private RString 異動区分;
    @CsvField(order = 230, name = "補正済自己負担額送付区分")
    private RString 補正済自己負担額送付区分;
    @CsvField(order = 240, name = "対象年度")
    private RString 対象年度;
    @CsvField(order = 250, name = "対象計算期間（開始）")
    private RString 対象計算期間_開始;
    @CsvField(order = 260, name = "対象計算期間（終了）")
    private RString 対象計算期間_終了;
    @CsvField(order = 270, name = "被保険者期間（開始）")
    private RString 被保険者期間_開始;
    @CsvField(order = 280, name = "被保険者期間（終了）")
    private RString 被保険者期間_終了;
    @CsvField(order = 290, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 300, name = "月分4_自己負担額")
    private RString 月分4_自己負担額;
    @CsvField(order = 310, name = "月分4_うち70～74歳の者に係る負担額")
    private RString 月分4_うち70_74歳の者に係る負担額;
    @CsvField(order = 320, name = "月分4_70歳未満高額療養費支給額")
    private RString 月分4_70歳未満高額療養費支給額;
    @CsvField(order = 330, name = "月分4_70～74歳高額療養費支給額")
    private RString 月分4_70_74歳高額療養費支給額;
    @CsvField(order = 340, name = "月分4_摘要")
    private RString 月分4_摘要;
    @CsvField(order = 350, name = "月分5_自己負担額")
    private RString 月分5_自己負担額;
    @CsvField(order = 360, name = "月分5_うち70～74歳の者に係る負担額")
    private RString 月分5_うち70_74歳の者に係る負担額;
    @CsvField(order = 370, name = "月分5_70歳未満高額療養費支給額")
    private RString 月分5_70歳未満高額療養費支給額;
    @CsvField(order = 380, name = "月分5_70～74歳高額療養費支給額")
    private RString 月分5_70_74歳高額療養費支給額;
    @CsvField(order = 390, name = "月分5_摘要")
    private RString 月分5_摘要;
    @CsvField(order = 400, name = "月分6_自己負担額")
    private RString 月分6_自己負担額;
    @CsvField(order = 410, name = "月分6_うち70～74歳の者に係る負担額")
    private RString 月分6_うち70_74歳の者に係る負担額;
    @CsvField(order = 420, name = "月分6_70歳未満高額療養費支給額")
    private RString 月分6_70歳未満高額療養費支給額;
    @CsvField(order = 430, name = "月分6_70～74歳高額療養費支給額")
    private RString 月分6_70_74歳高額療養費支給額;
    @CsvField(order = 440, name = "月分6_摘要")
    private RString 月分6_摘要;
    @CsvField(order = 450, name = "月分7_自己負担額")
    private RString 月分7_自己負担額;
    @CsvField(order = 460, name = "月分7_うち70～74歳の者に係る負担額")
    private RString 月分7_うち70_74歳の者に係る負担額;
    @CsvField(order = 470, name = "月分7_70歳未満高額療養費支給額")
    private RString 月分7_70歳未満高額療養費支給額;
    @CsvField(order = 480, name = "月分7_70～74歳高額療養費支給額")
    private RString 月分7_70_74歳高額療養費支給額;
    @CsvField(order = 490, name = "月分7_摘要")
    private RString 月分7_摘要;
    @CsvField(order = 500, name = "月分8_自己負担額")
    private RString 月分8_自己負担額;
    @CsvField(order = 510, name = "月分8_うち70～74歳の者に係る負担額")
    private RString 月分8_うち70_74歳の者に係る負担額;
    @CsvField(order = 520, name = "月分8_70歳未満高額療養費支給額")
    private RString 月分8_70歳未満高額療養費支給額;
    @CsvField(order = 530, name = "月分8_70～74歳高額療養費支給額")
    private RString 月分8_70_74歳高額療養費支給額;
    @CsvField(order = 540, name = "月分8_摘要")
    private RString 月分8_摘要;
    @CsvField(order = 550, name = "月分9_自己負担額")
    private RString 月分9_自己負担額;
    @CsvField(order = 560, name = "月分9_うち70～74歳の者に係る負担額")
    private RString 月分9_うち70_74歳の者に係る負担額;
    @CsvField(order = 570, name = "月分9_70歳未満高額療養費支給額")
    private RString 月分9_70歳未満高額療養費支給額;
    @CsvField(order = 580, name = "月分9_70～74歳高額療養費支給額")
    private RString 月分9_70_74歳高額療養費支給額;
    @CsvField(order = 590, name = "月分9_摘要")
    private RString 月分9_摘要;
    @CsvField(order = 600, name = "月分10_自己負担額")
    private RString 月分10_自己負担額;
    @CsvField(order = 610, name = "月分10_うち70～74歳の者に係る負担額")
    private RString 月分10_うち70_74歳の者に係る負担額;
    @CsvField(order = 620, name = "月分10_70歳未満高額療養費支給額")
    private RString 月分10_70歳未満高額療養費支給額;
    @CsvField(order = 630, name = "月分10_70～74歳高額療養費支給額")
    private RString 月分10_70_74歳高額療養費支給額;
    @CsvField(order = 640, name = "月分10_摘要")
    private RString 月分10_摘要;
    @CsvField(order = 650, name = "月分11_自己負担額")
    private RString 月分11_自己負担額;
    @CsvField(order = 660, name = "月分11_うち70～74歳の者に係る負担額")
    private RString 月分11_うち70_74歳の者に係る負担額;
    @CsvField(order = 670, name = "月分11_70歳未満高額療養費支給額")
    private RString 月分11_70歳未満高額療養費支給額;
    @CsvField(order = 680, name = "月分11_70～74歳高額療養費支給額")
    private RString 月分11_70_74歳高額療養費支給額;
    @CsvField(order = 690, name = "月分11_摘要")
    private RString 月分11_摘要;
    @CsvField(order = 700, name = "月分12_自己負担額")
    private RString 月分12_自己負担額;
    @CsvField(order = 710, name = "月分12_うち70～74歳の者に係る負担額")
    private RString 月分12_うち70_74歳の者に係る負担額;
    @CsvField(order = 720, name = "月分12_70歳未満高額療養費支給額")
    private RString 月分12_70歳未満高額療養費支給額;
    @CsvField(order = 730, name = "月分12_70～74歳高額療養費支給額")
    private RString 月分12_70_74歳高額療養費支給額;
    @CsvField(order = 740, name = "月分12_摘要")
    private RString 月分12_摘要;
    @CsvField(order = 750, name = "月分翌年1_自己負担額")
    private RString 月分翌年1_自己負担額;
    @CsvField(order = 760, name = "月分翌年1_うち70～74歳の者に係る負担額")
    private RString 月分翌年1_うち70_74歳の者に係る負担額;
    @CsvField(order = 770, name = "月分翌年1_70歳未満高額療養費支給額")
    private RString 月分翌年1_70歳未満高額療養費支給額;
    @CsvField(order = 780, name = "月分翌年1_70～74歳高額療養費支給額")
    private RString 月分翌年1_70_74歳高額療養費支給額;
    @CsvField(order = 790, name = "月分翌年1_摘要")
    private RString 月分翌年1_摘要;
    @CsvField(order = 800, name = "月分翌年2_自己負担額")
    private RString 月分翌年2_自己負担額;
    @CsvField(order = 810, name = "月分翌年2_うち70～74歳の者に係る負担額")
    private RString 月分翌年2_うち70_74歳の者に係る負担額;
    @CsvField(order = 820, name = "月分翌年2_70歳未満高額療養費支給額")
    private RString 月分翌年2_70歳未満高額療養費支給額;
    @CsvField(order = 830, name = "月分翌年2_70～74歳高額療養費支給額")
    private RString 月分翌年2_70_74歳高額療養費支給額;
    @CsvField(order = 840, name = "月分2_摘要")
    private RString 月分翌年2_摘要;
    @CsvField(order = 850, name = "月分翌年3_自己負担額")
    private RString 月分翌年3_自己負担額;
    @CsvField(order = 860, name = "月分翌年3_うち70～74歳の者に係る負担額")
    private RString 月分翌年3_うち70_74歳の者に係る負担額;
    @CsvField(order = 870, name = "月分3_70歳未満高額療養費支給額")
    private RString 月分翌年3_70歳未満高額療養費支給額;
    @CsvField(order = 880, name = "月分翌年3_70～74歳高額療養費支給額")
    private RString 月分翌年3_70_74歳高額療養費支給額;
    @CsvField(order = 890, name = "月分翌年3_摘要")
    private RString 月分翌年3_摘要;
    @CsvField(order = 900, name = "月分翌年4_自己負担額")
    private RString 月分翌年4_自己負担額;
    @CsvField(order = 910, name = "月分翌年4_うち70～74歳の者に係る負担額")
    private RString 月分翌年4_うち70_74歳の者に係る負担額;
    @CsvField(order = 920, name = "月分翌年4_70歳未満高額療養費支給額")
    private RString 月分翌年4_70歳未満高額療養費支給額;
    @CsvField(order = 930, name = "月分翌年4_70～74歳高額療養費支給額")
    private RString 月分翌年4_70_74歳高額療養費支給額;
    @CsvField(order = 940, name = "月分翌年4_摘要")
    private RString 月分翌年4_摘要;
    @CsvField(order = 950, name = "月分翌年5_自己負担額")
    private RString 月分翌年5_自己負担額;
    @CsvField(order = 960, name = "月分翌年5_うち70～74歳の者に係る負担額")
    private RString 月分翌年5_うち70_74歳の者に係る負担額;
    @CsvField(order = 970, name = "月分翌年5_70歳未満高額療養費支給額")
    private RString 月分翌年5_70歳未満高額療養費支給額;
    @CsvField(order = 980, name = "月分翌年5_70～74歳高額療養費支給額")
    private RString 月分翌年5_70_74歳高額療養費支給額;
    @CsvField(order = 990, name = "月分翌年5_摘要")
    private RString 月分翌年5_摘要;
    @CsvField(order = 1000, name = "月分翌年6_自己負担額")
    private RString 月分翌年6_自己負担額;
    @CsvField(order = 1010, name = "月分翌年6_うち70～74歳の者に係る負担額")
    private RString 月分翌年6_うち70_74歳の者に係る負担額;
    @CsvField(order = 1020, name = "月分翌年6_70歳未満高額療養費支給額")
    private RString 月分翌年6_70歳未満高額療養費支給額;
    @CsvField(order = 1030, name = "月分翌年6_70～74歳高額療養費支給額")
    private RString 月分翌年6_70_74歳高額療養費支給額;
    @CsvField(order = 1040, name = "月分翌年6_摘要")
    private RString 月分翌年6_摘要;
    @CsvField(order = 1050, name = "月分翌年7_自己負担額")
    private RString 月分翌年7_自己負担額;
    @CsvField(order = 1060, name = "月分翌年7_うち70～74歳の者に係る負担額")
    private RString 月分翌年7_うち70_74歳の者に係る負担額;
    @CsvField(order = 1070, name = "月分翌年7_70歳未満高額療養費支給額")
    private RString 月分翌年7_70歳未満高額療養費支給額;
    @CsvField(order = 1080, name = "月分翌年7_70～74歳高額療養費支給額")
    private RString 月分翌年7_70_74歳高額療養費支給額;
    @CsvField(order = 1090, name = "月分翌年7_摘要")
    private RString 月分翌年7_摘要;
    @CsvField(order = 1100, name = "合計_自己負担額")
    private RString 合計_自己負担額;
    @CsvField(order = 1110, name = "合計_うち70～74歳の者に係る負担額")
    private RString 合計_うち70_74歳の者に係る負担額;
    @CsvField(order = 1120, name = "合計_70歳未満高額療養費支給額")
    private RString 合計_70歳未満高額療養費支給額;
    @CsvField(order = 1130, name = "合計_70～74歳高額療養費支給額")
    private RString 合計_70_74歳高額療養費支給額;
    @CsvField(order = 1140, name = "宛先氏名")
    private RString 宛先氏名;
    @CsvField(order = 1150, name = "宛先郵便番号")
    private RString 宛先郵便番号;
    @CsvField(order = 1160, name = "宛先住所")
    private RString 宛先住所;
    @CsvField(order = 1170, name = "証明書発行年月日")
    private RString 証明書発行年月日;
    @CsvField(order = 1180, name = "証明書発行者名")
    private RString 証明書発行者名;
    @CsvField(order = 1190, name = "証明書発行者郵便番号")
    private RString 証明書発行者郵便番号;
    @CsvField(order = 1200, name = "証明書発行者住所")
    private RString 証明書発行者住所;
    @CsvField(order = 1210, name = "問い合わせ先郵便番号")
    private RString 問い合わせ先郵便番号;
    @CsvField(order = 1220, name = "問い合わせ先住所")
    private RString 問い合わせ先住所;
    @CsvField(order = 1230, name = "問い合わせ先名称1")
    private RString 問い合わせ先名称1;
    @CsvField(order = 1240, name = "問い合わせ先名称2")
    private RString 問い合わせ先名称2;
    @CsvField(order = 1250, name = "問い合わせ先電話番号")
    private RString 問い合わせ先電話番号;
    @CsvField(order = 1260, name = "計算結果送付先郵便番号")
    private RString 計算結果送付先郵便番号;
    @CsvField(order = 1270, name = "計算結果送付先住所")
    private RString 計算結果送付先住所;
    @CsvField(order = 1280, name = "計算結果送付先名称1")
    private RString 計算結果送付先名称1;
    @CsvField(order = 1290, name = "計算結果送付先名称2")
    private RString 計算結果送付先名称2;
    @CsvField(order = 1300, name = "計算結果送付先電話番号")
    private RString 計算結果送付先電話番号;
    @CsvField(order = 1310, name = "窓口払対象者判定コード")
    private RString 窓口払対象者判定コード;
    @CsvField(order = 1320, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 1330, name = "支払期間開始年月日")
    private RString 支払期間開始年月日;
    @CsvField(order = 1340, name = "支払期間終了年月日")
    private RString 支払期間終了年月日;
    @CsvField(order = 1350, name = "支払期間開始年月日（曜日）")
    private RString 支払期間開始年月日_曜日;
    @CsvField(order = 1360, name = "支払期間終了年月日（曜日）")
    private RString 支払期間終了年月日_曜日;
    @CsvField(order = 1370, name = "支払期間開始年月日（開始時間）")
    private RString 支払期間開始年月日_開始時間;
    @CsvField(order = 1380, name = "支払期間終了年月日（終了時間）")
    private RString 支払期間終了年月日_終了時間;
    @CsvField(order = 1390, name = "備考欄")
    private RString 備考欄;
}
